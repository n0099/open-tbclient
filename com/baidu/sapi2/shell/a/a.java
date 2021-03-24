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
    public static final String f11397g = "screen_shot_observer";

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f11398h = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    public static final String[] i = {"_data", "datetaken"};

    /* renamed from: a  reason: collision with root package name */
    public ContentResolver f11399a;

    /* renamed from: b  reason: collision with root package name */
    public IScreenShotListener f11400b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f11401c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f11402d;

    /* renamed from: e  reason: collision with root package name */
    public C0145a f11403e;

    /* renamed from: f  reason: collision with root package name */
    public C0145a f11404f;

    /* renamed from: com.baidu.sapi2.shell.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0145a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f11405a;

        public C0145a(Uri uri, Handler handler) {
            super(handler);
            this.f11405a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f11405a);
        }
    }

    public void b() {
        this.f11399a.unregisterContentObserver(this.f11403e);
        this.f11399a.unregisterContentObserver(this.f11404f);
        Handler handler = this.f11402d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f11402d = null;
        }
        HandlerThread handlerThread = this.f11401c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void a(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.f11399a = contentResolver;
        this.f11400b = iScreenShotListener;
        HandlerThread handlerThread = new HandlerThread(f11397g);
        this.f11401c = handlerThread;
        handlerThread.start();
        this.f11402d = new Handler(this.f11401c.getLooper());
        this.f11403e = new C0145a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f11402d);
        this.f11404f = new C0145a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f11402d);
    }

    public void a() {
        this.f11399a.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f11403e);
        this.f11399a.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f11404f);
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
                cursor = this.f11399a.query(uri, i, null, null, "date_added desc limit 1");
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
        if (!a(str) || (iScreenShotListener = this.f11400b) == null) {
            return;
        }
        iScreenShotListener.onScreenShot();
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : f11398h) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
