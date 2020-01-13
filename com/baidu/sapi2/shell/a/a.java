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
/* loaded from: classes5.dex */
public class a {
    private static final String a = "screen_shot_observer";
    private static final String[] b = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static final String[] c = {"_data", "datetaken"};
    private ContentResolver d;
    private IScreenShotListener e;
    private HandlerThread f;
    private Handler g;
    private C0168a h;
    private C0168a i;

    /* renamed from: com.baidu.sapi2.shell.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0168a extends ContentObserver {
        private final Uri a;

        public C0168a(Uri uri, Handler handler) {
            super(handler);
            this.a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.a);
        }
    }

    public void b() {
        this.d.unregisterContentObserver(this.h);
        this.d.unregisterContentObserver(this.i);
    }

    public void a(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.d = contentResolver;
        this.e = iScreenShotListener;
        this.f = new HandlerThread(a);
        this.f.start();
        this.g = new Handler(this.f.getLooper());
        this.h = new C0168a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.g);
        this.i = new C0168a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.g);
    }

    public void a() {
        this.d.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.h);
        this.d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [20=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        Cursor cursor3;
        try {
            try {
                cursor2 = this.d.query(uri, c, null, null, "date_added desc limit 1");
            } catch (Throwable th) {
                cursor = cursor3;
                th = th;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor2 != null) {
            try {
            } catch (Exception e3) {
                e = e3;
                Log.e(e);
                if (cursor2 == null || cursor2.isClosed()) {
                    return;
                }
                cursor2.close();
                return;
            }
            if (cursor2.moveToFirst()) {
                a(cursor2.getString(cursor2.getColumnIndex("_data")), cursor2.getLong(cursor2.getColumnIndex("datetaken")));
                if (cursor2 == null || cursor2.isClosed()) {
                    return;
                }
                cursor2.close();
                return;
            }
        }
        if (cursor2 == null || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    private void a(String str, long j) {
        IScreenShotListener iScreenShotListener;
        long j2 = 0;
        while (!a(str) && j2 <= 500) {
            j2 += 100;
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                Log.e(e);
            }
        }
        if (!a(str) || (iScreenShotListener = this.e) == null) {
            return;
        }
        iScreenShotListener.onScreenShot();
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : b) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
