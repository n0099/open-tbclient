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
import com.baidu.mobstat.bj;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int a;
    public static final be k;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> b;
    public int c;
    public boolean d;
    public JSONObject e;
    public boolean f;
    public final Handler g;
    public final Handler h;
    public a i;
    public bd j;

    /* loaded from: classes2.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public boolean b;
        public final WeakReference<View> c;
        public final bj d;
        public final Handler e;
        public final Handler f;
        public JSONObject g;
        public WeakReference<Activity> h;
        public boolean i;
        public boolean j;
        public boolean k;
        public Runnable l;

        public a(Activity activity, View view2, bj bjVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, view2, bjVar, handler, handler2, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = null;
            this.h = new WeakReference<>(activity);
            this.g = jSONObject;
            this.d = bjVar;
            this.c = new WeakReference<>(view2);
            this.e = handler;
            this.f = handler2;
            this.b = true;
            this.a = false;
            this.i = z;
            this.j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        private void a(bj bjVar, Handler handler) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(65537, this, bjVar, handler) != null) || bjVar == null || handler == null) {
                return;
            }
            handler.postDelayed(new Runnable(this, bjVar) { // from class: com.baidu.mobstat.be.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ bj a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bjVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bjVar;
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

        private void a(WeakReference<Activity> weakReference, JSONObject jSONObject, bj bjVar, Handler handler, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(65538, this, new Object[]{weakReference, jSONObject, bjVar, handler, Boolean.valueOf(z)}) != null) || bjVar == null || handler == null) {
                return;
            }
            Runnable runnable = new Runnable(this, weakReference, z, bjVar, jSONObject) { // from class: com.baidu.mobstat.be.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeakReference a;
                public final /* synthetic */ boolean b;
                public final /* synthetic */ bj c;
                public final /* synthetic */ JSONObject d;
                public final /* synthetic */ a e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, weakReference, Boolean.valueOf(z), bjVar, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = weakReference;
                    this.b = z;
                    this.c = bjVar;
                    this.d = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!ay.c()) {
                            if (bc.c().b() && this.e.k) {
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
                        Activity activity = (Activity) this.a.get();
                        if (activity != null) {
                            aq.c(activity, this.b);
                            this.c.a(activity, this.d, this.b);
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

        @SuppressLint({"NewApi"})
        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a) {
                this.a = true;
                this.e.post(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (CooperService.instance().isCloseTrace()) {
                    b();
                } else {
                    run();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !this.b) {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657935, "Lcom/baidu/mobstat/be;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657935, "Lcom/baidu/mobstat/be;");
                return;
            }
        }
        k = new be();
    }

    public static be a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return k;
        }
        return (be) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a = 0;
        }
    }

    public static /* synthetic */ int c() {
        int i = a + 1;
        a = i;
        return i;
    }

    public be() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new Handler(Looper.getMainLooper());
        this.j = new bd();
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper());
    }

    public static void a(Activity activity, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65539, null, activity, view2, z) != null) || view2 == null || bi.c(activity, view2)) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            b(activity, z2);
        }
    }

    private boolean a(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, activity, i)) == null) {
            WeakReference<Activity> weakReference = this.b;
            if (weakReference != null && weakReference.get() == activity && this.c == i) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, activity, z) == null) {
            a(activity, bi.a(activity), z);
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, activity, z) == null) {
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
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, Boolean.valueOf(z), jSONObject, Boolean.valueOf(z2)}) == null) {
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
}
