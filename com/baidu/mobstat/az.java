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
    public Context f8705a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f8706b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f8707c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8708d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f8709e;

    /* renamed from: f  reason: collision with root package name */
    public long f8710f;

    /* renamed from: g  reason: collision with root package name */
    public long f8711g;

    /* renamed from: h  reason: collision with root package name */
    public String f8712h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f8713i;
    public bf j = bf.a();

    private void e() {
        if (bw.s(this.f8705a) && !this.f8707c) {
            if (!this.f8708d) {
                this.f8709e = bo.a(this.f8705a, "mtj_autoTracker.js");
                this.f8708d = true;
            }
            if (this.f8710f == 0) {
                this.f8710f = bq.a().n(this.f8705a);
                this.f8711g = bq.a().o(this.f8705a);
            }
            if (!(this.f8708d && TextUtils.isEmpty(this.f8709e)) && System.currentTimeMillis() - this.f8710f <= this.f8711g) {
                return;
            }
            f();
        }
    }

    private void f() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.az.2
            @Override // java.lang.Runnable
            public void run() {
                if (az.this.f8707c) {
                    return;
                }
                boolean a2 = bg.a(az.this.f8705a, az.this.f8712h, 1, false);
                az.this.f8707c = true;
                if (a2) {
                    az azVar = az.this;
                    azVar.f8709e = bo.a(azVar.f8705a, "mtj_autoTracker.js");
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
        this.f8712h = str;
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
                if (az.this.f8713i == null) {
                    az.this.f8713i = new PointF();
                }
                az.this.f8713i.set(motionEvent.getRawX(), motionEvent.getRawY());
            }

            @Override // com.baidu.mobstat.al.a
            public void a(KeyEvent keyEvent) {
                ar.a(keyEvent);
            }
        }));
    }

    public PointF b() {
        return this.f8713i;
    }

    public void b(Activity activity) {
        if (d()) {
            d(this.f8706b);
            this.f8706b = null;
            a(activity, false);
        }
    }

    public static az a() {
        return k;
    }

    private boolean d() {
        return !TextUtils.isEmpty(this.f8712h);
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
        blVar.a(this.f8706b, webView, str, (JSONObject) null, false);
    }

    public void a(Activity activity) {
        if (d()) {
            a(true);
            this.f8705a = activity.getApplicationContext();
            this.f8706b = activity;
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
        if (TextUtils.isEmpty(this.f8709e)) {
            this.f8709e = bo.a(this.f8705a, "mtj_autoTracker.js");
        }
        b(webView, this.f8709e, blVar);
    }
}
