package com.baidu.sapi2.shell.a;

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
/* loaded from: classes5.dex */
public class a {
    private static final String g = "screen_shot_observer";
    private static final String[] h = {StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static final String[] i = {"_data", "datetaken"};

    /* renamed from: a  reason: collision with root package name */
    private ContentResolver f3520a;
    private IScreenShotListener b;
    private HandlerThread c;
    private Handler d;
    private C0332a e;
    private C0332a f;

    /* renamed from: com.baidu.sapi2.shell.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0332a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f3521a;

        public C0332a(Uri uri, Handler handler) {
            super(handler);
            this.f3521a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f3521a);
        }
    }

    public void b() {
        this.f3520a.unregisterContentObserver(this.e);
        this.f3520a.unregisterContentObserver(this.f);
    }

    public void a(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.f3520a = contentResolver;
        this.b = iScreenShotListener;
        this.c = new HandlerThread(g);
        this.c.start();
        this.d = new Handler(this.c.getLooper());
        this.e = new C0332a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.d);
        this.f = new C0332a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.d);
    }

    public void a() {
        this.f3520a.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.e);
        this.f3520a.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        Cursor cursor3;
        try {
            try {
                cursor2 = this.f3520a.query(uri, i, null, null, "date_added desc limit 1");
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
        if (cursor2 != null && !cursor2.isClosed()) {
            cursor2.close();
        }
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
        if (!a(str) || (iScreenShotListener = this.b) == null) {
            return;
        }
        iScreenShotListener.onScreenShot();
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : h) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
