package com.baidu.sapi2.shell.a;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f10982g = "screen_shot_observer";

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f10983h = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    public static final String[] i = {"_data", "datetaken"};

    /* renamed from: a  reason: collision with root package name */
    public ContentResolver f10984a;

    /* renamed from: b  reason: collision with root package name */
    public IScreenShotListener f10985b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f10986c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f10987d;

    /* renamed from: e  reason: collision with root package name */
    public C0146a f10988e;

    /* renamed from: f  reason: collision with root package name */
    public C0146a f10989f;

    /* renamed from: com.baidu.sapi2.shell.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0146a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f10990a;

        public C0146a(Uri uri, Handler handler) {
            super(handler);
            this.f10990a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f10990a);
        }
    }

    public void b() {
        this.f10984a.unregisterContentObserver(this.f10988e);
        this.f10984a.unregisterContentObserver(this.f10989f);
        Handler handler = this.f10987d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10987d = null;
        }
        HandlerThread handlerThread = this.f10986c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void a(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.f10984a = contentResolver;
        this.f10985b = iScreenShotListener;
        HandlerThread handlerThread = new HandlerThread(f10982g);
        this.f10986c = handlerThread;
        handlerThread.start();
        this.f10987d = new Handler(this.f10986c.getLooper());
        this.f10988e = new C0146a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f10987d);
        this.f10989f = new C0146a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f10987d);
    }

    public void a() {
        this.f10984a.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f10988e);
        this.f10984a.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f10989f);
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
    public void a(Uri uri) {
        Cursor cursor = null;
        try {
            try {
                cursor = this.f10984a.query(uri, i, null, null, "date_added desc limit 1");
            } catch (Exception e2) {
                Log.e(e2);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                a(cursor.getString(cursor.getColumnIndex("_data")), cursor.getLong(cursor.getColumnIndex("datetaken")));
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

    private void a(String str, long j) {
        IScreenShotListener iScreenShotListener;
        long j2 = 0;
        while (!a(str) && j2 <= 500) {
            j2 += 100;
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e2) {
                Log.e(e2);
            }
        }
        if (!a(str) || (iScreenShotListener = this.f10985b) == null) {
            return;
        }
        iScreenShotListener.onScreenShot();
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : f10983h) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
