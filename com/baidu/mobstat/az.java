package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.WebView;
import com.baidu.mobstat.al;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class az {
    public static final az k = new az();
    public static volatile boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    public Context f8643a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f8644b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f8645c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8646d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f8647e;

    /* renamed from: f  reason: collision with root package name */
    public long f8648f;

    /* renamed from: g  reason: collision with root package name */
    public long f8649g;

    /* renamed from: h  reason: collision with root package name */
    public String f8650h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f8651i;
    public bf j = bf.a();

    private void e() {
        if (bw.s(this.f8643a) && !this.f8645c) {
            if (!this.f8646d) {
                this.f8647e = bo.a(this.f8643a, "mtj_autoTracker.js");
                this.f8646d = true;
            }
            if (this.f8648f == 0) {
                this.f8648f = bq.a().n(this.f8643a);
                this.f8649g = bq.a().o(this.f8643a);
            }
            if (!(this.f8646d && TextUtils.isEmpty(this.f8647e)) && System.currentTimeMillis() - this.f8648f <= this.f8649g) {
                return;
            }
            f();
        }
    }

    private void f() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.az.2
            @Override // java.lang.Runnable
            public void run() {
                if (az.this.f8645c) {
                    return;
                }
                boolean a2 = bg.a(az.this.f8643a, az.this.f8650h, 1, false);
                az.this.f8645c = true;
                if (a2) {
                    az azVar = az.this;
                    azVar.f8647e = bo.a(azVar.f8643a, "mtj_autoTracker.js");
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    public static boolean c() {
        return l;
    }

    private void d(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setCallback(a(window.getCallback()));
    }

    public void b(String str) {
        this.f8650h = str;
    }

    private void c(Activity activity) {
        Window window;
        Window.Callback callback;
        if (activity == null || (window = activity.getWindow()) == null || (callback = window.getCallback()) == null) {
            return;
        }
        window.setCallback(new al(callback, new al.a() { // from class: com.baidu.mobstat.az.1
            @Override // com.baidu.mobstat.al.a
            public void a(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1) {
                    return;
                }
                az.a(true);
                if (az.this.f8651i == null) {
                    az.this.f8651i = new PointF();
                }
                az.this.f8651i.set(motionEvent.getRawX(), motionEvent.getRawY());
            }

            @Override // com.baidu.mobstat.al.a
            public void a(KeyEvent keyEvent) {
                ar.a(keyEvent);
            }
        }));
    }

    public PointF b() {
        return this.f8651i;
    }

    public void b(Activity activity) {
        if (d()) {
            d(this.f8644b);
            this.f8644b = null;
            a(activity, false);
        }
    }

    public static az a() {
        return k;
    }

    private boolean d() {
        return !TextUtils.isEmpty(this.f8650h);
    }

    public void a(String str) {
        ax.a().a(str);
    }

    public static void a(boolean z) {
        if (z) {
            bf.b();
        }
        l = z;
    }

    private void b(WebView webView, String str, bl blVar) {
        if (blVar == null) {
            return;
        }
        blVar.a(this.f8644b, webView, str, (JSONObject) null, false);
    }

    public void a(Activity activity) {
        if (d()) {
            a(true);
            this.f8643a = activity.getApplicationContext();
            this.f8644b = activity;
            e();
            c(activity);
            a(activity, true);
        }
    }

    public void a(Activity activity, boolean z) {
        if (activity instanceof IIgnoreAutoEvent) {
            return;
        }
        if (z) {
            this.j.a(activity, false, null, false);
        } else {
            this.j.a(activity, false);
        }
    }

    private Window.Callback a(Window.Callback callback) {
        while (callback != null && (callback instanceof al)) {
            callback = ((al) callback).a();
        }
        return callback;
    }

    public void a(WebView webView, String str, bl blVar) {
        if (TextUtils.isEmpty(this.f8647e)) {
            this.f8647e = bo.a(this.f8643a, "mtj_autoTracker.js");
        }
        b(webView, this.f8647e, blVar);
    }
}
