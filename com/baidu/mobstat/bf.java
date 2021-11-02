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
/* loaded from: classes7.dex */
public class bf {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f41135a;
    public static final bf k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f41136b;

    /* renamed from: c  reason: collision with root package name */
    public int f41137c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41138d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f41139e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41140f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f41141g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f41142h;

    /* renamed from: i  reason: collision with root package name */
    public a f41143i;
    public be j;

    /* loaded from: classes7.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f41144a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41145b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<View> f41146c;

        /* renamed from: d  reason: collision with root package name */
        public final bk f41147d;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f41148e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f41149f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f41150g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f41151h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f41152i;
        public boolean j;
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
            this.f41151h = new WeakReference<>(activity);
            this.f41150g = jSONObject;
            this.f41147d = bkVar;
            this.f41146c = new WeakReference<>(view);
            this.f41148e = handler;
            this.f41149f = handler2;
            this.f41145b = true;
            this.f41144a = false;
            this.f41152i = z;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                if (this.f41145b) {
                    View view = this.f41146c.get();
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
                    a(this.f41147d, this.f41149f);
                }
                this.f41145b = false;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f41145b) {
                if (this.f41146c.get() != null && !this.f41144a) {
                    if (bd.c().b() && this.k) {
                        bd.c().a("onGlobalLayout");
                    }
                    if (bh.c().b()) {
                        bh.c().a("onGlobalLayout");
                    }
                    if (af.b()) {
                        if (az.c()) {
                            Activity activity = this.f41151h.get();
                            if (activity != null) {
                                bf.b(activity, this.f41152i, this.k);
                                a(this.f41151h, this.f41150g, this.f41147d, this.f41149f, this.j);
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
                    this.f41148e.removeCallbacks(this);
                    return;
                }
                b();
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41144a) {
                return;
            }
            this.f41144a = true;
            this.f41148e.post(this);
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
                public final /* synthetic */ WeakReference f41153a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f41154b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ bk f41155c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ JSONObject f41156d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f41157e;

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
                    this.f41157e = this;
                    this.f41153a = weakReference;
                    this.f41154b = z;
                    this.f41155c = bkVar;
                    this.f41156d = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!az.c()) {
                            if (bd.c().b() && this.f41157e.k) {
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
                        Activity activity = (Activity) this.f41153a.get();
                        if (activity != null) {
                            ar.c(activity, this.f41154b);
                            this.f41155c.a(activity, this.f41156d, this.f41154b);
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
                public final /* synthetic */ bk f41158a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f41159b;

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
                    this.f41159b = this;
                    this.f41158a = bkVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f41158a.a();
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
        this.f41141g = new Handler(Looper.getMainLooper());
        this.j = new be();
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.f41142h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f41135a = 0;
        }
    }

    public static /* synthetic */ int c() {
        int i2 = f41135a + 1;
        f41135a = i2;
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
            if (!this.f41138d) {
                this.f41138d = z2;
            }
            if (z) {
                this.f41140f = z;
                this.f41139e = jSONObject;
            }
            if (a(activity, 1)) {
                return;
            }
            if (this.f41136b != null && (aVar = this.f41143i) != null) {
                aVar.a();
            }
            WeakReference<Activity> weakReference = new WeakReference<>(activity);
            this.f41136b = weakReference;
            this.f41137c = 1;
            this.f41143i = new a(activity, bj.a(activity), new bk.a(1, weakReference, this.j), this.f41141g, this.f41142h, this.f41139e, this.f41138d, true, this.f41140f);
        }
    }

    public void a(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, activity, z) == null) {
            ar.b(activity, !z);
            if (a(activity, 2)) {
                return;
            }
            this.f41136b = new WeakReference<>(activity);
            this.f41137c = 2;
            a aVar = this.f41143i;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private boolean a(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, activity, i2)) == null) {
            WeakReference<Activity> weakReference = this.f41136b;
            return weakReference != null && weakReference.get() == activity && this.f41137c == i2;
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
