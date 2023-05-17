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
import com.baidu.mobstat.bj;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class be {
    public static volatile int a;
    public static final be k = new be();
    public WeakReference<Activity> b;
    public int c;
    public boolean d;
    public JSONObject e;
    public boolean f;
    public final Handler h;
    public a i;
    public final Handler g = new Handler(Looper.getMainLooper());
    public bd j = new bd();

    /* loaded from: classes3.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        public final WeakReference<View> c;
        public final bj d;
        public final Handler e;
        public final Handler f;
        public JSONObject g;
        public WeakReference<Activity> h;
        public boolean i;
        public boolean j;
        public boolean k;
        public Runnable l = null;
        public boolean b = true;
        public volatile boolean a = false;

        public a(Activity activity, View view2, bj bjVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            this.h = new WeakReference<>(activity);
            this.g = jSONObject;
            this.d = bjVar;
            this.c = new WeakReference<>(view2);
            this.e = handler;
            this.f = handler2;
            this.i = z;
            this.j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        private void a(final bj bjVar, Handler handler) {
            if (bjVar == null || handler == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.baidu.mobstat.be.a.2
                @Override // java.lang.Runnable
                public void run() {
                    bjVar.a();
                }
            }, 500L);
        }

        private void a(final WeakReference<Activity> weakReference, final JSONObject jSONObject, final bj bjVar, Handler handler, final boolean z) {
            if (bjVar == null || handler == null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.be.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ay.c()) {
                        if (bc.c().b() && a.this.k) {
                            bc.c().a("no touch, skip doViewVisit");
                        }
                        if (bg.c().b()) {
                            bg.c().a("no touch, skip doViewVisit");
                            return;
                        }
                        return;
                    }
                    if (be.c() >= 3) {
                        ay.a(false);
                    }
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        aq.c(activity, z);
                        bjVar.a(activity, jSONObject, z);
                    }
                }
            };
            Runnable runnable2 = this.l;
            if (runnable2 != null) {
                handler.removeCallbacks(runnable2);
            }
            this.l = runnable;
            handler.postDelayed(runnable, 500L);
        }

        @SuppressLint({"NewApi"})
        private void b() {
            if (this.b) {
                View view2 = this.c.get();
                if (view2 != null) {
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
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

        public void a() {
            if (!this.a) {
                this.a = true;
                this.e.post(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CooperService.instance().isCloseTrace()) {
                b();
            } else {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b) {
                return;
            }
            if (this.c.get() != null && !this.a) {
                if (bc.c().b() && this.k) {
                    bc.c().a("onGlobalLayout");
                }
                if (bg.c().b()) {
                    bg.c().a("onGlobalLayout");
                }
                if (ad.b()) {
                    if (ay.c()) {
                        Activity activity = this.h.get();
                        if (activity != null) {
                            be.b(activity, this.i, this.k);
                            a(this.h, this.g, this.d, this.f, this.j);
                        }
                    } else {
                        if (bc.c().b() && this.k) {
                            bc.c().a("no touch, skip onGlobalLayout");
                        }
                        if (bg.c().b()) {
                            bg.c().a("no touch, skip onGlobalLayout");
                        }
                    }
                }
                this.e.removeCallbacks(this);
                return;
            }
            b();
        }
    }

    public be() {
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper());
    }

    public static be a() {
        return k;
    }

    public static void b() {
        a = 0;
    }

    public static /* synthetic */ int c() {
        int i = a + 1;
        a = i;
        return i;
    }

    public static void a(Activity activity, View view2, boolean z) {
        if (view2 == null || bi.c(activity, view2)) {
            return;
        }
        if (view2 instanceof WebView) {
            WebView webView = (WebView) view2;
            if (webView.getTag(-96001) == null) {
                if (bc.c().b() && z) {
                    bc c = bc.c();
                    c.a("webview auto set " + activity.getClass().getName());
                }
                if (bg.c().b()) {
                    bg c2 = bg.c();
                    c2.a("webview auto set " + activity.getClass().getName());
                }
                StatService.trackWebView(activity.getApplicationContext(), webView, null);
            }
        } else if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), z);
            }
        }
    }

    public static void b(Activity activity, boolean z, boolean z2) {
        if (z) {
            b(activity, z2);
        }
    }

    private boolean a(Activity activity, int i) {
        WeakReference<Activity> weakReference = this.b;
        if (weakReference != null && weakReference.get() == activity && this.c == i) {
            return true;
        }
        return false;
    }

    public static void b(Activity activity, boolean z) {
        a(activity, bi.a(activity), z);
    }

    public void a(Activity activity, boolean z) {
        aq.b(activity, !z);
        if (a(activity, 2)) {
            return;
        }
        this.b = new WeakReference<>(activity);
        this.c = 2;
        a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        a aVar;
        aq.a(activity, !z);
        if (!this.d) {
            this.d = z2;
        }
        if (z) {
            this.f = z;
            this.e = jSONObject;
        }
        if (a(activity, 1)) {
            return;
        }
        if (this.b != null && (aVar = this.i) != null) {
            aVar.a();
        }
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.b = weakReference;
        this.c = 1;
        this.i = new a(activity, bi.a(activity), new bj.a(1, weakReference, this.j), this.g, this.h, this.e, this.d, true, this.f);
    }
}
