package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.baidu.mobstat.bk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class bf {
    private static volatile int a = 0;
    private static final bf k = new bf();
    private WeakReference<Activity> b;
    private int c;
    private boolean d;
    private JSONObject e;
    private boolean f;
    private final Handler h;
    private a i;
    private final Handler g = new Handler(Looper.getMainLooper());
    private be j = new be();

    static /* synthetic */ int c() {
        int i = a + 1;
        a = i;
        return i;
    }

    public static bf a() {
        return k;
    }

    private bf() {
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        a = 0;
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        ar.a(activity, !z);
        if (!this.d) {
            this.d = z2;
        }
        if (z) {
            this.f = z;
            this.e = jSONObject;
        }
        if (!a(activity, 1)) {
            if (this.b != null && this.i != null) {
                this.i.a();
            }
            this.b = new WeakReference<>(activity);
            this.c = 1;
            this.i = new a(activity, bj.a(activity), new bk.a(1, this.b, this.j), this.g, this.h, this.e, this.d, true, this.f);
        }
    }

    public void a(Activity activity, boolean z) {
        ar.b(activity, !z);
        if (!a(activity, 2)) {
            this.b = new WeakReference<>(activity);
            this.c = 2;
            if (this.i != null) {
                this.i.a();
            }
        }
    }

    private boolean a(Activity activity, int i) {
        return this.b != null && this.b.get() == activity && this.c == i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        private final WeakReference<View> c;
        private final bk d;
        private final Handler e;
        private final Handler f;
        private JSONObject g;
        private WeakReference<Activity> h;
        private boolean i;
        private boolean j;
        private boolean k;
        private Runnable l = null;
        private boolean b = true;
        private volatile boolean a = false;

        public a(Activity activity, View view, bk bkVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            this.h = new WeakReference<>(activity);
            this.g = jSONObject;
            this.d = bkVar;
            this.c = new WeakReference<>(view);
            this.e = handler;
            this.f = handler2;
            this.i = z;
            this.j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                if (this.c.get() == null || this.a) {
                    b();
                    return;
                }
                if (bd.c().b() && this.k) {
                    bd.c().a("onGlobalLayout");
                }
                if (bh.c().b()) {
                    bh.c().a("onGlobalLayout");
                }
                if (af.b()) {
                    if (az.c()) {
                        Activity activity = this.h.get();
                        if (activity != null) {
                            bf.b(activity, this.i, this.k);
                            a(this.h, this.g, this.d, this.f, this.j);
                        }
                    } else {
                        if (bd.c().b() && this.k) {
                            bd.c().a("no touch, skip onGlobalLayout");
                        }
                        if (bh.c().b()) {
                            bh.c().a("no touch, skip onGlobalLayout");
                        }
                    }
                }
                this.e.removeCallbacks(this);
            }
        }

        public void a() {
            if (!this.a) {
                this.a = true;
                this.e.post(this);
            }
        }

        @SuppressLint({"NewApi"})
        private void b() {
            if (this.b) {
                View view = this.c.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        if (Build.VERSION.SDK_INT < 16) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        } else {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                    }
                }
                a(this.d, this.f);
            }
            this.b = false;
        }

        private void a(final WeakReference<Activity> weakReference, final JSONObject jSONObject, final bk bkVar, Handler handler, final boolean z) {
            if (bkVar != null && handler != null) {
                Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.bf.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!az.c()) {
                            if (bd.c().b() && a.this.k) {
                                bd.c().a("no touch, skip doViewVisit");
                            }
                            if (bh.c().b()) {
                                bh.c().a("no touch, skip doViewVisit");
                                return;
                            }
                            return;
                        }
                        if (bf.c() >= 3) {
                            az.a(false);
                        }
                        Activity activity = (Activity) weakReference.get();
                        if (activity != null) {
                            ar.c(activity, z);
                            bkVar.a(activity, jSONObject, z);
                        }
                    }
                };
                if (this.l != null) {
                    handler.removeCallbacks(this.l);
                }
                this.l = runnable;
                handler.postDelayed(runnable, 500L);
            }
        }

        private void a(final bk bkVar, Handler handler) {
            if (bkVar != null && handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.baidu.mobstat.bf.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        bkVar.a();
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z, boolean z2) {
        if (z) {
            b(activity, z2);
        }
    }

    private static void b(Activity activity, boolean z) {
        a(activity, bj.a(activity), z);
    }

    private static void a(Activity activity, View view, boolean z) {
        if (view != null && !bj.c(activity, view)) {
            if (view instanceof WebView) {
                WebView webView = (WebView) view;
                if (webView.getTag(-96001) == null) {
                    if (bd.c().b() && z) {
                        bd.c().a("webview auto set " + activity.getClass().getName());
                    }
                    if (bh.c().b()) {
                        bh.c().a("webview auto set " + activity.getClass().getName());
                    }
                    StatService.trackWebView(activity.getApplicationContext(), webView, null);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    a(activity, viewGroup.getChildAt(i), z);
                }
            }
        }
    }
}
