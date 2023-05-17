package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.WebView;
import com.baidu.mobstat.ak;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ay {
    public static final ay k = new ay();
    public static volatile boolean l = true;
    public Context a;
    public Activity b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile String e;
    public long f;
    public long g;
    public String h;
    public PointF i;
    public be j = be.a();

    public static ay a() {
        return k;
    }

    public static boolean c() {
        return l;
    }

    private boolean d() {
        if (TextUtils.isEmpty(this.h)) {
            return false;
        }
        return true;
    }

    private void f() {
        if (!bw.q(this.a)) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.ay.2
            @Override // java.lang.Runnable
            public void run() {
                if (ay.this.c) {
                    return;
                }
                boolean a = bf.a(ay.this.a, ay.this.h, 1, false);
                ay.this.c = true;
                if (a) {
                    ay ayVar = ay.this;
                    ayVar.e = bn.a(ayVar.a, af.b);
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    public PointF b() {
        return this.i;
    }

    private Window.Callback a(Window.Callback callback) {
        while (callback != null && (callback instanceof ak)) {
            callback = ((ak) callback).a();
        }
        return callback;
    }

    private void c(Activity activity) {
        Window window;
        Window.Callback callback;
        if (activity == null || (window = activity.getWindow()) == null || (callback = window.getCallback()) == null) {
            return;
        }
        window.setCallback(new ak(callback, new ak.a() { // from class: com.baidu.mobstat.ay.1
            @Override // com.baidu.mobstat.ak.a
            public void a(KeyEvent keyEvent) {
                aq.a(keyEvent);
            }

            @Override // com.baidu.mobstat.ak.a
            public void a(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 1) {
                    ay.a(true);
                    if (ay.this.i == null) {
                        ay.this.i = new PointF();
                    }
                    ay.this.i.set(motionEvent.getRawX(), motionEvent.getRawY());
                }
            }
        }));
    }

    private void d(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setCallback(a(window.getCallback()));
    }

    public void b(Activity activity) {
        if (!d()) {
            return;
        }
        d(this.b);
        this.b = null;
        a(activity, false);
    }

    public static void a(boolean z) {
        if (z) {
            be.b();
        }
        l = z;
    }

    public void b(String str) {
        this.h = str;
    }

    private void b(WebView webView, String str, bk bkVar) {
        if (bkVar == null) {
            return;
        }
        bkVar.a(this.b, webView, str, (JSONObject) null, false);
    }

    public void a(WebView webView, String str, bk bkVar) {
        if (TextUtils.isEmpty(this.e)) {
            this.e = bn.a(this.a, af.b);
        }
        b(webView, this.e, bkVar);
    }

    private void e() {
        if (this.c) {
            return;
        }
        if (!this.d) {
            this.e = bn.a(this.a, af.b);
            this.d = true;
        }
        if (this.f == 0) {
            this.f = bp.a().n(this.a);
            this.g = bp.a().o(this.a);
        }
        long j = this.g;
        if ((this.d && TextUtils.isEmpty(this.e)) || System.currentTimeMillis() - this.f > j) {
            f();
        }
    }

    public void a(Activity activity) {
        if (!d()) {
            return;
        }
        a(true);
        this.a = activity.getApplicationContext();
        this.b = activity;
        e();
        c(activity);
        a(activity, true);
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

    public void a(String str) {
        aw.a().a(str);
    }
}
