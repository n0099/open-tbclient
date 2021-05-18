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
/* loaded from: classes2.dex */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f8761a;
    public static final bf k = new bf();

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f8762b;

    /* renamed from: c  reason: collision with root package name */
    public int f8763c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8764d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f8765e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8766f;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f8768h;

    /* renamed from: i  reason: collision with root package name */
    public a f8769i;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f8767g = new Handler(Looper.getMainLooper());
    public be j = new be();

    /* loaded from: classes2.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<View> f8772c;

        /* renamed from: d  reason: collision with root package name */
        public final bk f8773d;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f8774e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f8775f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f8776g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f8777h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f8778i;
        public boolean j;
        public boolean k;
        public Runnable l = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8771b = true;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f8770a = false;

        public a(Activity activity, View view, bk bkVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            this.f8777h = new WeakReference<>(activity);
            this.f8776g = jSONObject;
            this.f8773d = bkVar;
            this.f8772c = new WeakReference<>(view);
            this.f8774e = handler;
            this.f8775f = handler2;
            this.f8778i = z;
            this.j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @SuppressLint({"NewApi"})
        private void b() {
            if (this.f8771b) {
                View view = this.f8772c.get();
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
                a(this.f8773d, this.f8775f);
            }
            this.f8771b = false;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8771b) {
                if (this.f8772c.get() != null && !this.f8770a) {
                    if (bd.c().b() && this.k) {
                        bd.c().a("onGlobalLayout");
                    }
                    if (bh.c().b()) {
                        bh.c().a("onGlobalLayout");
                    }
                    if (af.b()) {
                        if (az.c()) {
                            Activity activity = this.f8777h.get();
                            if (activity != null) {
                                bf.b(activity, this.f8778i, this.k);
                                a(this.f8777h, this.f8776g, this.f8773d, this.f8775f, this.j);
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
                    this.f8774e.removeCallbacks(this);
                    return;
                }
                b();
            }
        }

        public void a() {
            if (this.f8770a) {
                return;
            }
            this.f8770a = true;
            this.f8774e.post(this);
        }

        private void a(final WeakReference<Activity> weakReference, final JSONObject jSONObject, final bk bkVar, Handler handler, final boolean z) {
            if (bkVar == null || handler == null) {
                return;
            }
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
            Runnable runnable2 = this.l;
            if (runnable2 != null) {
                handler.removeCallbacks(runnable2);
            }
            this.l = runnable;
            handler.postDelayed(runnable, 500L);
        }

        private void a(final bk bkVar, Handler handler) {
            if (bkVar == null || handler == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.baidu.mobstat.bf.a.2
                @Override // java.lang.Runnable
                public void run() {
                    bkVar.a();
                }
            }, 500L);
        }
    }

    public bf() {
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.f8768h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        f8761a = 0;
    }

    public static /* synthetic */ int c() {
        int i2 = f8761a + 1;
        f8761a = i2;
        return i2;
    }

    public static bf a() {
        return k;
    }

    public static void b(Activity activity, boolean z, boolean z2) {
        if (z) {
            b(activity, z2);
        }
    }

    public static void b(Activity activity, boolean z) {
        a(activity, bj.a(activity), z);
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        a aVar;
        ar.a(activity, !z);
        if (!this.f8764d) {
            this.f8764d = z2;
        }
        if (z) {
            this.f8766f = z;
            this.f8765e = jSONObject;
        }
        if (a(activity, 1)) {
            return;
        }
        if (this.f8762b != null && (aVar = this.f8769i) != null) {
            aVar.a();
        }
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f8762b = weakReference;
        this.f8763c = 1;
        this.f8769i = new a(activity, bj.a(activity), new bk.a(1, weakReference, this.j), this.f8767g, this.f8768h, this.f8765e, this.f8764d, true, this.f8766f);
    }

    public void a(Activity activity, boolean z) {
        ar.b(activity, !z);
        if (a(activity, 2)) {
            return;
        }
        this.f8762b = new WeakReference<>(activity);
        this.f8763c = 2;
        a aVar = this.f8769i;
        if (aVar != null) {
            aVar.a();
        }
    }

    private boolean a(Activity activity, int i2) {
        WeakReference<Activity> weakReference = this.f8762b;
        return weakReference != null && weakReference.get() == activity && this.f8763c == i2;
    }

    public static void a(Activity activity, View view, boolean z) {
        if (view == null || bj.c(activity, view)) {
            return;
        }
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            if (webView.getTag(-96001) == null) {
                if (bd.c().b() && z) {
                    bd c2 = bd.c();
                    c2.a("webview auto set " + activity.getClass().getName());
                }
                if (bh.c().b()) {
                    bh c3 = bh.c();
                    c3.a("webview auto set " + activity.getClass().getName());
                }
                StatService.trackWebView(activity.getApplicationContext(), webView, null);
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(activity, viewGroup.getChildAt(i2), z);
            }
        }
    }
}
