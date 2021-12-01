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
/* loaded from: classes8.dex */
public class bf {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int a;

    /* renamed from: k  reason: collision with root package name */
    public static final bf f37105k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f37106b;

    /* renamed from: c  reason: collision with root package name */
    public int f37107c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37108d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f37109e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37110f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f37111g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f37112h;

    /* renamed from: i  reason: collision with root package name */
    public a f37113i;

    /* renamed from: j  reason: collision with root package name */
    public be f37114j;

    /* loaded from: classes8.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37115b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<View> f37116c;

        /* renamed from: d  reason: collision with root package name */
        public final bk f37117d;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f37118e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f37119f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f37120g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f37121h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f37122i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f37123j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f37124k;
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
            this.f37121h = new WeakReference<>(activity);
            this.f37120g = jSONObject;
            this.f37117d = bkVar;
            this.f37116c = new WeakReference<>(view);
            this.f37118e = handler;
            this.f37119f = handler2;
            this.f37115b = true;
            this.a = false;
            this.f37122i = z;
            this.f37123j = z2;
            this.f37124k = z3;
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
                if (this.f37115b) {
                    View view = this.f37116c.get();
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
                    a(this.f37117d, this.f37119f);
                }
                this.f37115b = false;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f37115b) {
                if (this.f37116c.get() != null && !this.a) {
                    if (bd.c().b() && this.f37124k) {
                        bd.c().a("onGlobalLayout");
                    }
                    if (bh.c().b()) {
                        bh.c().a("onGlobalLayout");
                    }
                    if (af.b()) {
                        if (az.c()) {
                            Activity activity = this.f37121h.get();
                            if (activity != null) {
                                bf.b(activity, this.f37122i, this.f37124k);
                                a(this.f37121h, this.f37120g, this.f37117d, this.f37119f, this.f37123j);
                            }
                        } else {
                            if (bd.c().b() && this.f37124k) {
                                bd.c().a("no touch, skip onGlobalLayout");
                            }
                            if (bh.c().b()) {
                                bh.c().a("no touch, skip onGlobalLayout");
                            }
                        }
                    }
                    this.f37118e.removeCallbacks(this);
                    return;
                }
                b();
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a) {
                return;
            }
            this.a = true;
            this.f37118e.post(this);
        }

        private void a(WeakReference<Activity> weakReference, JSONObject jSONObject, bk bkVar, Handler handler, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{weakReference, jSONObject, bkVar, handler, Boolean.valueOf(z)}) == null) || bkVar == null || handler == null) {
                return;
            }
            Runnable runnable = new Runnable(this, weakReference, z, bkVar, jSONObject) { // from class: com.baidu.mobstat.bf.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeakReference a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f37125b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ bk f37126c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ JSONObject f37127d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f37128e;

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
                    this.f37128e = this;
                    this.a = weakReference;
                    this.f37125b = z;
                    this.f37126c = bkVar;
                    this.f37127d = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!az.c()) {
                            if (bd.c().b() && this.f37128e.f37124k) {
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
                        Activity activity = (Activity) this.a.get();
                        if (activity != null) {
                            ar.c(activity, this.f37125b);
                            this.f37126c.a(activity, this.f37127d, this.f37125b);
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
                public final /* synthetic */ bk a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f37129b;

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
                    this.f37129b = this;
                    this.a = bkVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
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
        f37105k = new bf();
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
        this.f37111g = new Handler(Looper.getMainLooper());
        this.f37114j = new be();
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.f37112h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a = 0;
        }
    }

    public static /* synthetic */ int c() {
        int i2 = a + 1;
        a = i2;
        return i2;
    }

    public static bf a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f37105k : (bf) invokeV.objValue;
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
            if (!this.f37108d) {
                this.f37108d = z2;
            }
            if (z) {
                this.f37110f = z;
                this.f37109e = jSONObject;
            }
            if (a(activity, 1)) {
                return;
            }
            if (this.f37106b != null && (aVar = this.f37113i) != null) {
                aVar.a();
            }
            WeakReference<Activity> weakReference = new WeakReference<>(activity);
            this.f37106b = weakReference;
            this.f37107c = 1;
            this.f37113i = new a(activity, bj.a(activity), new bk.a(1, weakReference, this.f37114j), this.f37111g, this.f37112h, this.f37109e, this.f37108d, true, this.f37110f);
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, activity, z) == null) {
            ar.b(activity, !z);
            if (a(activity, 2)) {
                return;
            }
            this.f37106b = new WeakReference<>(activity);
            this.f37107c = 2;
            a aVar = this.f37113i;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private boolean a(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, activity, i2)) == null) {
            WeakReference<Activity> weakReference = this.f37106b;
            return weakReference != null && weakReference.get() == activity && this.f37107c == i2;
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
