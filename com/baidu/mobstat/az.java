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
    public Context f8623a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f8624b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f8625c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8626d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f8627e;

    /* renamed from: f  reason: collision with root package name */
    public long f8628f;

    /* renamed from: g  reason: collision with root package name */
    public long f8629g;

    /* renamed from: h  reason: collision with root package name */
    public String f8630h;
    public PointF i;
    public bf j = bf.a();

    private void e() {
        if (bw.s(this.f8623a) && !this.f8625c) {
            if (!this.f8626d) {
                this.f8627e = bo.a(this.f8623a, "mtj_autoTracker.js");
                this.f8626d = true;
            }
            if (this.f8628f == 0) {
                this.f8628f = bq.a().n(this.f8623a);
                this.f8629g = bq.a().o(this.f8623a);
            }
            if (!(this.f8626d && TextUtils.isEmpty(this.f8627e)) && System.currentTimeMillis() - this.f8628f <= this.f8629g) {
                return;
            }
            f();
        }
    }

    private void f() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.az.2
            @Override // java.lang.Runnable
            public void run() {
                if (az.this.f8625c) {
                    return;
                }
                boolean a2 = bg.a(az.this.f8623a, az.this.f8630h, 1, false);
                az.this.f8625c = true;
                if (a2) {
                    az azVar = az.this;
                    azVar.f8627e = bo.a(azVar.f8623a, "mtj_autoTracker.js");
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
        this.f8630h = str;
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
                if (az.this.i == null) {
                    az.this.i = new PointF();
                }
                az.this.i.set(motionEvent.getRawX(), motionEvent.getRawY());
            }

            @Override // com.baidu.mobstat.al.a
            public void a(KeyEvent keyEvent) {
                ar.a(keyEvent);
            }
        }));
    }

    public PointF b() {
        return this.i;
    }

    public void b(Activity activity) {
        if (d()) {
            d(this.f8624b);
            this.f8624b = null;
            a(activity, false);
        }
    }

    public static az a() {
        return k;
    }

    private boolean d() {
        return !TextUtils.isEmpty(this.f8630h);
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
        blVar.a(this.f8624b, webView, str, (JSONObject) null, false);
    }

    public void a(Activity activity) {
        if (d()) {
            a(true);
            this.f8623a = activity.getApplicationContext();
            this.f8624b = activity;
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
        if (TextUtils.isEmpty(this.f8627e)) {
            this.f8627e = bo.a(this.f8623a, "mtj_autoTracker.js");
        }
        b(webView, this.f8627e, blVar);
    }
}
