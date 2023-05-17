package com.baidu.sapi2.shell.manager;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes3.dex */
public class ScreenShotManager {
    public static final String[] KEYWORDS = {StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    public static final String[] MEDIA_PROJECTIONS = {"_data", "datetaken"};
    public static final String SCREEN_SHOT_OBSERVER = "screen_shot_observer";
    public ContentResolver mContentResolver;
    public MediaContentObserver mExternalObserver;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public MediaContentObserver mInternalObserver;
    public IScreenShotListener mScreenShotListener;

    /* loaded from: classes3.dex */
    public class MediaContentObserver extends ContentObserver {
        public final Uri mContentUri;

        public MediaContentObserver(Uri uri, Handler handler) {
            super(handler);
            this.mContentUri = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            ScreenShotManager.this.handleMediaContentChange(this.mContentUri);
        }
    }

    public void register() {
        this.mContentResolver.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.mInternalObserver);
        this.mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.mExternalObserver);
    }

    public void unRegister() {
        this.mContentResolver.unregisterContentObserver(this.mInternalObserver);
        this.mContentResolver.unregisterContentObserver(this.mExternalObserver);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    private void handleMediaRowData(String str, long j) {
        IScreenShotListener iScreenShotListener;
        long j2 = 0;
        while (!isScreenShot(str) && j2 <= 500) {
            j2 += 100;
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                Log.e(e);
            }
        }
        if (isScreenShot(str) && (iScreenShotListener = this.mScreenShotListener) != null) {
            iScreenShotListener.onScreenShot();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.isClosed() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMediaContentChange(Uri uri) {
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContentResolver.query(uri, MEDIA_PROJECTIONS, null, null, "date_added desc limit 1");
            } catch (Exception e) {
                Log.e(e);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                handleMediaRowData(cursor.getString(cursor.getColumnIndex("_data")), cursor.getLong(cursor.getColumnIndex("datetaken")));
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    private boolean isScreenShot(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : KEYWORDS) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public void init(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.mContentResolver = contentResolver;
        this.mScreenShotListener = iScreenShotListener;
        HandlerThread handlerThread = new HandlerThread(SCREEN_SHOT_OBSERVER);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mInternalObserver = new MediaContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mHandler);
        this.mExternalObserver = new MediaContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mHandler);
    }
}
