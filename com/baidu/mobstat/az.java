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
/* loaded from: classes15.dex */
public class az {
    private static final az k = new az();
    private static volatile boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f3771a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3772b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile String e;
    private long f;
    private long g;
    private String h;
    private PointF i;
    private bf j = bf.a();

    public static az a() {
        return k;
    }

    private az() {
    }

    public void a(String str) {
        ax.a().a(str);
    }

    public void b(String str) {
        this.h = str;
    }

    public PointF b() {
        return this.i;
    }

    public static void a(boolean z) {
        if (z) {
            bf.b();
        }
        l = z;
    }

    public static boolean c() {
        return l;
    }

    private void c(Activity activity) {
        Window window;
        Window.Callback callback;
        if (activity != null && (window = activity.getWindow()) != null && (callback = window.getCallback()) != null) {
            window.setCallback(new al(callback, new al.a() { // from class: com.baidu.mobstat.az.1
                @Override // com.baidu.mobstat.al.a
                public void a(MotionEvent motionEvent) {
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        default:
                            return;
                        case 1:
                            az.a(true);
                            if (az.this.i == null) {
                                az.this.i = new PointF();
                            }
                            az.this.i.set(motionEvent.getRawX(), motionEvent.getRawY());
                            return;
                    }
                }

                @Override // com.baidu.mobstat.al.a
                public void a(KeyEvent keyEvent) {
                    ar.a(keyEvent);
                }
            }));
        }
    }

    public void a(Activity activity) {
        if (d()) {
            a(true);
            this.f3771a = activity.getApplicationContext();
            this.f3772b = activity;
            e();
            c(activity);
            a(activity, true);
        }
    }

    public void a(Activity activity, boolean z) {
        if (!(activity instanceof IIgnoreAutoEvent)) {
            if (z) {
                this.j.a(activity, false, null, false);
            } else {
                this.j.a(activity, false);
            }
        }
    }

    private void d(Activity activity) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setCallback(a(window.getCallback()));
        }
    }

    private Window.Callback a(Window.Callback callback) {
        Window.Callback callback2 = callback;
        while (callback2 != null && (callback2 instanceof al)) {
            callback2 = ((al) callback2).a();
        }
        return callback2;
    }

    public void b(Activity activity) {
        if (d()) {
            d(this.f3772b);
            this.f3772b = null;
            a(activity, false);
        }
    }

    public void a(WebView webView, String str, bl blVar) {
        if (TextUtils.isEmpty(this.e)) {
            this.e = bo.a(this.f3771a, "mtj_autoTracker.js");
        }
        b(webView, this.e, blVar);
    }

    private boolean d() {
        return !TextUtils.isEmpty(this.h);
    }

    private void e() {
        if (bw.s(this.f3771a) && !this.c) {
            if (!this.d) {
                this.e = bo.a(this.f3771a, "mtj_autoTracker.js");
                this.d = true;
            }
            if (this.f == 0) {
                this.f = bq.a().n(this.f3771a);
                this.g = bq.a().o(this.f3771a);
            }
            if ((this.d && TextUtils.isEmpty(this.e)) || System.currentTimeMillis() - this.f > this.g) {
                f();
            }
        }
    }

    private void f() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.az.2
            @Override // java.lang.Runnable
            public void run() {
                if (!az.this.c) {
                    boolean a2 = bg.a(az.this.f3771a, az.this.h, 1, false);
                    az.this.c = true;
                    if (a2) {
                        az.this.e = bo.a(az.this.f3771a, "mtj_autoTracker.js");
                    }
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    private void b(WebView webView, String str, bl blVar) {
        if (blVar != null) {
            blVar.a(this.f3772b, webView, str, (JSONObject) null, false);
        }
    }
}
