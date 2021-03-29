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
    public static volatile int f9066a;
    public static final bf k = new bf();

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f9067b;

    /* renamed from: c  reason: collision with root package name */
    public int f9068c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9069d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9070e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9071f;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f9073h;
    public a i;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f9072g = new Handler(Looper.getMainLooper());
    public be j = new be();

    /* loaded from: classes2.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<View> f9076c;

        /* renamed from: d  reason: collision with root package name */
        public final bk f9077d;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f9078e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f9079f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f9080g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f9081h;
        public boolean i;
        public boolean j;
        public boolean k;
        public Runnable l = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f9075b = true;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f9074a = false;

        public a(Activity activity, View view, bk bkVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            this.f9081h = new WeakReference<>(activity);
            this.f9080g = jSONObject;
            this.f9077d = bkVar;
            this.f9076c = new WeakReference<>(view);
            this.f9078e = handler;
            this.f9079f = handler2;
            this.i = z;
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
            if (this.f9075b) {
                View view = this.f9076c.get();
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
                a(this.f9077d, this.f9079f);
            }
            this.f9075b = false;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9075b) {
                if (this.f9076c.get() != null && !this.f9074a) {
                    if (bd.c().b() && this.k) {
                        bd.c().a("onGlobalLayout");
                    }
                    if (bh.c().b()) {
                        bh.c().a("onGlobalLayout");
                    }
                    if (af.b()) {
                        if (az.c()) {
                            Activity activity = this.f9081h.get();
                            if (activity != null) {
                                bf.b(activity, this.i, this.k);
                                a(this.f9081h, this.f9080g, this.f9077d, this.f9079f, this.j);
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
                    this.f9078e.removeCallbacks(this);
                    return;
                }
                b();
            }
        }

        public void a() {
            if (this.f9074a) {
                return;
            }
            this.f9074a = true;
            this.f9078e.post(this);
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
        this.f9073h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        f9066a = 0;
    }

    public static /* synthetic */ int c() {
        int i = f9066a + 1;
        f9066a = i;
        return i;
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
        if (!this.f9069d) {
            this.f9069d = z2;
        }
        if (z) {
            this.f9071f = z;
            this.f9070e = jSONObject;
        }
        if (a(activity, 1)) {
            return;
        }
        if (this.f9067b != null && (aVar = this.i) != null) {
            aVar.a();
        }
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f9067b = weakReference;
        this.f9068c = 1;
        this.i = new a(activity, bj.a(activity), new bk.a(1, weakReference, this.j), this.f9072g, this.f9073h, this.f9070e, this.f9069d, true, this.f9071f);
    }

    public void a(Activity activity, boolean z) {
        ar.b(activity, !z);
        if (a(activity, 2)) {
            return;
        }
        this.f9067b = new WeakReference<>(activity);
        this.f9068c = 2;
        a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
    }

    private boolean a(Activity activity, int i) {
        WeakReference<Activity> weakReference = this.f9067b;
        return weakReference != null && weakReference.get() == activity && this.f9068c == i;
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
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), z);
            }
        }
    }
}
