package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.WebView;
import com.baidu.mobstat.as;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bg {
    private static final bg k = new bg();
    private static volatile boolean l = true;
    private Context a;
    private Activity b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile String e;
    private long f;
    private long g;
    private String h;
    private PointF i;
    private bm j = bm.a();

    public static bg a() {
        return k;
    }

    private bg() {
    }

    public void a(String str) {
        be.a().a(str);
    }

    public void b(String str) {
        this.h = str;
    }

    public PointF b() {
        return this.i;
    }

    public static void a(boolean z) {
        if (z) {
            bm.b();
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
            window.setCallback(new as(callback, new as.a() { // from class: com.baidu.mobstat.bg.1
                @Override // com.baidu.mobstat.as.a
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
                            bg.a(true);
                            if (bg.this.i == null) {
                                bg.this.i = new PointF();
                            }
                            bg.this.i.set(motionEvent.getRawX(), motionEvent.getRawY());
                            return;
                    }
                }

                @Override // com.baidu.mobstat.as.a
                public void a(KeyEvent keyEvent) {
                    ay.a(keyEvent);
                }
            }));
        }
    }

    public void a(Activity activity) {
        if (d()) {
            a(true);
            this.a = activity.getApplicationContext();
            this.b = activity;
            e();
            c(activity);
            this.j.a(activity, false, null, false);
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
        while (callback2 != null && (callback2 instanceof as)) {
            callback2 = ((as) callback2).a();
        }
        return callback2;
    }

    public void b(Activity activity) {
        if (d()) {
            d(this.b);
            this.b = null;
            this.j.a(activity, false);
        }
    }

    public void a(WebView webView, String str, bs bsVar) {
        if (TextUtils.isEmpty(this.e)) {
            this.e = bv.a(this.a, "mtj_autoTracker.js");
        }
        b(webView, this.e, bsVar);
    }

    private boolean d() {
        return !TextUtils.isEmpty(this.h);
    }

    private void e() {
        if (cc.s(this.a) && !this.c) {
            if (!this.d) {
                this.e = bv.a(this.a, "mtj_autoTracker.js");
                this.d = true;
            }
            if (this.f == 0) {
                this.f = BasicStoreTools.getInstance().getAutoTraceTrackJsFetchTime(this.a);
                this.g = BasicStoreTools.getInstance().getAutoTraceTrackJsFetchInterval(this.a);
            }
            if ((this.d && TextUtils.isEmpty(this.e)) || System.currentTimeMillis() - this.f > this.g) {
                f();
            }
        }
    }

    private void f() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.mobstat.bg.2
            @Override // java.lang.Runnable
            public void run() {
                if (!bg.this.c) {
                    boolean a = bn.a(bg.this.a, bg.this.h, 1, false);
                    bg.this.c = true;
                    if (a) {
                        bg.this.e = bv.a(bg.this.a, "mtj_autoTracker.js");
                    }
                }
            }
        });
        thread.setName("downloadThread");
        thread.start();
    }

    private void b(WebView webView, String str, bs bsVar) {
        if (bsVar != null) {
            bsVar.a(this.b, webView, str, (JSONObject) null, false);
        }
    }
}
