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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.bk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bf {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f43253a;
    public static final bf k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f43254b;

    /* renamed from: c  reason: collision with root package name */
    public int f43255c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43256d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f43257e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43258f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f43259g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f43260h;

    /* renamed from: i  reason: collision with root package name */
    public a f43261i;

    /* renamed from: j  reason: collision with root package name */
    public be f43262j;

    /* loaded from: classes5.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f43263a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43264b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<View> f43265c;

        /* renamed from: d  reason: collision with root package name */
        public final bk f43266d;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f43267e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f43268f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f43269g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f43270h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f43271i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f43272j;
        public boolean k;
        public Runnable l;

        public a(Activity activity, View view, bk bkVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, view, bkVar, handler, handler2, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = null;
            this.f43270h = new WeakReference<>(activity);
            this.f43269g = jSONObject;
            this.f43266d = bkVar;
            this.f43265c = new WeakReference<>(view);
            this.f43267e = handler;
            this.f43268f = handler2;
            this.f43264b = true;
            this.f43263a = false;
            this.f43271i = z;
            this.f43272j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @SuppressLint({"NewApi"})
        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                if (this.f43264b) {
                    View view = this.f43265c.get();
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
                    a(this.f43266d, this.f43268f);
                }
                this.f43264b = false;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f43264b) {
                if (this.f43265c.get() != null && !this.f43263a) {
                    if (bd.c().b() && this.k) {
                        bd.c().a("onGlobalLayout");
                    }
                    if (bh.c().b()) {
                        bh.c().a("onGlobalLayout");
                    }
                    if (af.b()) {
                        if (az.c()) {
                            Activity activity = this.f43270h.get();
                            if (activity != null) {
                                bf.b(activity, this.f43271i, this.k);
                                a(this.f43270h, this.f43269g, this.f43266d, this.f43268f, this.f43272j);
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
                    this.f43267e.removeCallbacks(this);
                    return;
                }
                b();
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43263a) {
                return;
            }
            this.f43263a = true;
            this.f43267e.post(this);
        }

        private void a(WeakReference<Activity> weakReference, JSONObject jSONObject, bk bkVar, Handler handler, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{weakReference, jSONObject, bkVar, handler, Boolean.valueOf(z)}) == null) || bkVar == null || handler == null) {
                return;
            }
            Runnable runnable = new Runnable(this, weakReference, z, bkVar, jSONObject) { // from class: com.baidu.mobstat.bf.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WeakReference f43273a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f43274b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ bk f43275c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ JSONObject f43276d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f43277e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, weakReference, Boolean.valueOf(z), bkVar, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43277e = this;
                    this.f43273a = weakReference;
                    this.f43274b = z;
                    this.f43275c = bkVar;
                    this.f43276d = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!az.c()) {
                            if (bd.c().b() && this.f43277e.k) {
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
                        Activity activity = (Activity) this.f43273a.get();
                        if (activity != null) {
                            ar.c(activity, this.f43274b);
                            this.f43275c.a(activity, this.f43276d, this.f43274b);
                        }
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

        private void a(bk bkVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65537, this, bkVar, handler) == null) || bkVar == null || handler == null) {
                return;
            }
            handler.postDelayed(new Runnable(this, bkVar) { // from class: com.baidu.mobstat.bf.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ bk f43278a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f43279b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bkVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43279b = this;
                    this.f43278a = bkVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f43278a.a();
                    }
                }
            }, 500L);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657966, "Lcom/baidu/mobstat/bf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657966, "Lcom/baidu/mobstat/bf;");
                return;
            }
        }
        k = new bf();
    }

    public bf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43259g = new Handler(Looper.getMainLooper());
        this.f43262j = new be();
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.f43260h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f43253a = 0;
        }
    }

    public static /* synthetic */ int c() {
        int i2 = f43253a + 1;
        f43253a = i2;
        return i2;
    }

    public static bf a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? k : (bf) invokeV.objValue;
    }

    public static void b(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            b(activity, z2);
        }
    }

    public static void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, activity, z) == null) {
            a(activity, bj.a(activity), z);
        }
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, Boolean.valueOf(z), jSONObject, Boolean.valueOf(z2)}) == null) {
            ar.a(activity, !z);
            if (!this.f43256d) {
                this.f43256d = z2;
            }
            if (z) {
                this.f43258f = z;
                this.f43257e = jSONObject;
            }
            if (a(activity, 1)) {
                return;
            }
            if (this.f43254b != null && (aVar = this.f43261i) != null) {
                aVar.a();
            }
            WeakReference<Activity> weakReference = new WeakReference<>(activity);
            this.f43254b = weakReference;
            this.f43255c = 1;
            this.f43261i = new a(activity, bj.a(activity), new bk.a(1, weakReference, this.f43262j), this.f43259g, this.f43260h, this.f43257e, this.f43256d, true, this.f43258f);
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, activity, z) == null) {
            ar.b(activity, !z);
            if (a(activity, 2)) {
                return;
            }
            this.f43254b = new WeakReference<>(activity);
            this.f43255c = 2;
            a aVar = this.f43261i;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private boolean a(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, activity, i2)) == null) {
            WeakReference<Activity> weakReference = this.f43254b;
            return weakReference != null && weakReference.get() == activity && this.f43255c == i2;
        }
        return invokeLI.booleanValue;
    }

    public static void a(Activity activity, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, activity, view, z) == null) || view == null || bj.c(activity, view)) {
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
