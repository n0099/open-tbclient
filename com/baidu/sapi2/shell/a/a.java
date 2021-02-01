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
/* loaded from: classes15.dex */
public class a {
    private static final String g = "screen_shot_observer";
    private static final String[] h = {StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    private static final String[] i = {"_data", "datetaken"};

    /* renamed from: a  reason: collision with root package name */
    private ContentResolver f5076a;

    /* renamed from: b  reason: collision with root package name */
    private IScreenShotListener f5077b;
    private HandlerThread c;
    private Handler d;
    private C0330a e;
    private C0330a f;

    /* renamed from: com.baidu.sapi2.shell.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0330a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f5078a;

        public C0330a(Uri uri, Handler handler) {
            super(handler);
            this.f5078a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f5078a);
        }
    }

    public void b() {
        this.f5076a.unregisterContentObserver(this.e);
        this.f5076a.unregisterContentObserver(this.f);
    }

    public void a(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.f5076a = contentResolver;
        this.f5077b = iScreenShotListener;
        this.c = new HandlerThread(g);
        this.c.start();
        this.d = new Handler(this.c.getLooper());
        this.e = new C0330a(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.d);
        this.f = new C0330a(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.d);
    }

    public void a() {
        this.f5076a.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.e);
        this.f5076a.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        try {
            try {
                cursor2 = this.f5076a.query(uri, i, null, null, "date_added desc limit 1");
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor3;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor2 != null) {
            try {
            } catch (Exception e2) {
                e = e2;
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
        if (!a(str) || (iScreenShotListener = this.f5077b) == null) {
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
