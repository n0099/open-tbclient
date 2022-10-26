package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media2.session.SessionCommand;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.aa3;
import com.baidu.tieba.ap2;
import com.baidu.tieba.bf3;
import com.baidu.tieba.bg4;
import com.baidu.tieba.cq1;
import com.baidu.tieba.dh3;
import com.baidu.tieba.ea3;
import com.baidu.tieba.fa3;
import com.baidu.tieba.ff3;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fi3;
import com.baidu.tieba.fj3;
import com.baidu.tieba.fx2;
import com.baidu.tieba.ga2;
import com.baidu.tieba.gg3;
import com.baidu.tieba.gh3;
import com.baidu.tieba.go2;
import com.baidu.tieba.h03;
import com.baidu.tieba.ha2;
import com.baidu.tieba.hi3;
import com.baidu.tieba.j33;
import com.baidu.tieba.jf3;
import com.baidu.tieba.jo2;
import com.baidu.tieba.k03;
import com.baidu.tieba.k83;
import com.baidu.tieba.k93;
import com.baidu.tieba.kg2;
import com.baidu.tieba.l33;
import com.baidu.tieba.lg2;
import com.baidu.tieba.lg3;
import com.baidu.tieba.lo2;
import com.baidu.tieba.m02;
import com.baidu.tieba.m33;
import com.baidu.tieba.m93;
import com.baidu.tieba.mt2;
import com.baidu.tieba.na3;
import com.baidu.tieba.ng2;
import com.baidu.tieba.nx2;
import com.baidu.tieba.oh3;
import com.baidu.tieba.oi3;
import com.baidu.tieba.pa3;
import com.baidu.tieba.po2;
import com.baidu.tieba.q33;
import com.baidu.tieba.rd3;
import com.baidu.tieba.ro2;
import com.baidu.tieba.rw2;
import com.baidu.tieba.sd3;
import com.baidu.tieba.sf3;
import com.baidu.tieba.t23;
import com.baidu.tieba.t82;
import com.baidu.tieba.tm2;
import com.baidu.tieba.u22;
import com.baidu.tieba.u93;
import com.baidu.tieba.uf3;
import com.baidu.tieba.uf4;
import com.baidu.tieba.um2;
import com.baidu.tieba.v22;
import com.baidu.tieba.vf3;
import com.baidu.tieba.vg3;
import com.baidu.tieba.w02;
import com.baidu.tieba.wj1;
import com.baidu.tieba.x63;
import com.baidu.tieba.y83;
import com.baidu.tieba.z22;
import com.baidu.tieba.zo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, t23.a, sd3, ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public static final String C;
    public static final long D;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public lg2 m;
    public Messenger n;
    public FrameLifeState o;
    public ActivityResultDispatcher p;
    public sf3 q;
    public String r;
    public boolean s;
    public boolean t;
    public OrientationEventListener u;
    public uf3 v;
    public oi3 w;
    public t23 x;
    public final j33 y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        /* loaded from: classes2.dex */
        public class a extends OrientationEventListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, Context context, int i) {
                super(context, i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, context, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    l33.K().c = i;
                }
            }
        }

        public j(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity swanAppActivity = this.a;
                if (swanAppActivity.u == null) {
                    swanAppActivity.u = new a(this, this.a, 2);
                }
                if (this.a.d) {
                    this.a.u.enable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public a(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.n0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public b(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.m0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public c(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.A0(true, aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements hi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public d(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hi3
        /* renamed from: b */
        public Boolean a(q33.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                return Boolean.valueOf(!this.a.isDestroyed());
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public e(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SwanAppActivity b;

        public f(SwanAppActivity swanAppActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zo2 U = zo2.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    v22 V = U.V();
                    if (V == null) {
                        m02.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        m02.i("SwanAppActivity", "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        m02.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        u22.S3(null);
                        v22.b i = V.i("init");
                        int i2 = v22.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", mt2.d(str, str), true).a();
                        oi3 T = activity.T();
                        if (T != null) {
                            T.F(1);
                        }
                        ff3 ff3Var = new ff3();
                        ff3Var.k(1L);
                        ff3Var.i(2110L);
                        ff3Var.f("host url" + this.a);
                        jf3.a().f(ff3Var);
                        na3 na3Var = new na3();
                        na3Var.p(ff3Var);
                        na3Var.r(l33.K().q().W());
                        na3Var.q(fa3.n(l33.K().k()));
                        na3Var.m(l33.K().getAppId());
                        fa3.R(na3Var);
                        return;
                    }
                }
                m02.i("SwanAppActivity", "activity is invalid.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public g(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tm2.o().d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public h(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k93.d()) {
                k93.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public i(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tm2.o().k();
                if (!nx2.h()) {
                    fg3.m(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public k(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    m93.d().l();
                } catch (Exception e) {
                    if (SwanAppActivity.B) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public l(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.o0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes2.dex */
    public class m implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public m(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.C0();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public n(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.k0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public o(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.l0();
        }
    }

    /* loaded from: classes2.dex */
    public class p implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        public p(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(q33.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.I0(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1851900983, "Lcom/baidu/swan/apps/SwanAppActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1851900983, "Lcom/baidu/swan/apps/SwanAppActivity;");
                return;
            }
        }
        B = wj1.a;
        C = SwanAppActivity.class.getName();
        D = TimeUnit.SECONDS.toMillis(1L);
    }

    public SwanAppActivity() {
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
        this.o = FrameLifeState.INACTIVATED;
        this.r = "sys";
        this.s = false;
        this.y = new j33();
        this.z = false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            m02.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.t = true;
            H0(FrameLifeState.JUST_CREATED);
            if (!Z()) {
                rw2.m();
            }
            gg3.k(new k(this), "tracer");
            tm2.p0().flush(false);
        }
    }

    public final synchronized void D0(FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frameLifeState) == null) {
            synchronized (this) {
                if (this.m != null && !this.m.i0()) {
                    this.m.R0(frameLifeState);
                }
            }
        }
    }

    public void F0(kg2 kg2Var) {
        lg2 lg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, kg2Var) == null) && (lg2Var = this.m) != null) {
            lg2Var.T0(kg2Var);
        }
    }

    public final synchronized void H0(FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, frameLifeState) == null) {
            synchronized (this) {
                this.o = frameLifeState;
                C0();
            }
        }
    }

    public final void N(pa3 pa3Var) {
        lg2 lg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, pa3Var) == null) && (lg2Var = this.m) != null) {
            lg2Var.Q(pa3Var);
        }
    }

    public boolean d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && TextUtils.equals(str, P())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean g0(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, intent)) == null) {
            if (intent == null) {
                return true;
            }
            ComponentName component = intent.getComponent();
            if (component != null && !component.getClassName().startsWith(C)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k0(po2 po2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, po2Var) == null) && b0() && po2Var.c(" event_params_installer_progress")) {
            this.w.u(po2Var.g(" event_params_installer_progress"));
        }
    }

    public final void n0(po2 po2Var) {
        lg2 lg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, po2Var) == null) && (lg2Var = this.m) != null && lg2Var.f0()) {
            G0("update_tag_by_activity_on_new_intent".equals(po2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onPostCreate(bundle);
            uf3 uf3Var = this.v;
            if (uf3Var != null) {
                uf3Var.n();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, componentName) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
            }
            this.n = null;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            super.onTrimMemory(i2);
            if (Z()) {
                this.m.F0(i2);
            }
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            G0(true);
            ga2.U().b1(str);
        }
    }

    public final void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            gh3.e0(new f(this, str));
        }
    }

    public void s0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            k03.k(this, bundle);
        }
    }

    public void t0(kg2 kg2Var) {
        lg2 lg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, kg2Var) == null) && (lg2Var = this.m) != null) {
            lg2Var.I0(kg2Var);
        }
    }

    public final synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                D0(this.o);
            }
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            vf3.j(this);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.A == null) {
            this.A = w02.a(this);
        }
    }

    public void O() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (S() != null && S().d0() == 1) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            if (T() != null) {
                T().F(i2);
            }
        }
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            lg2 lg2Var = this.m;
            if (lg2Var == null) {
                return "";
            }
            return lg2Var.i;
        }
        return (String) invokeV.objValue;
    }

    public lg2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.m;
        }
        return (lg2) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            lg2 lg2Var = this.m;
            if (lg2Var == null) {
                return -1;
            }
            return lg2Var.k();
        }
        return invokeV.intValue;
    }

    public jo2.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            lg2 lg2Var = this.m;
            if (lg2Var == null) {
                return null;
            }
            return lg2Var.Z();
        }
        return (jo2.a) invokeV.objValue;
    }

    public oi3 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.w;
        }
        return (oi3) invokeV.objValue;
    }

    public SwanAppProcessInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return SwanAppProcessInfo.P0;
        }
        return (SwanAppProcessInfo) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public uf3 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.v;
        }
        return (uf3) invokeV.objValue;
    }

    public v22 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            lg2 lg2Var = this.m;
            if (lg2Var == null) {
                return null;
            }
            return lg2Var.c0();
        }
        return (v22) invokeV.objValue;
    }

    public synchronized boolean Z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                if (!isDestroyed() && this.m != null) {
                    if (this.m.a0().activated()) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return !TextUtils.isEmpty(bg4.e().b());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sd3
    public rd3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            lg2 lg2Var = this.m;
            if (lg2Var == null) {
                return null;
            }
            return lg2Var.d0();
        }
        return (rd3) invokeV.objValue;
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.w != null && !isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t23.a
    public t23 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.x == null) {
                this.x = new t23(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.x;
        }
        return (t23) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            PMSAppInfo f0 = l33.K().q().W().f0();
            if (f0 == null || f0.appStatus != 6) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.finish();
            if (B) {
                m02.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
            }
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    public ActivityResultDispatcher getResultDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.p == null) {
                this.p = new ActivityResultDispatcher(this, 1);
            }
            return this.p;
        }
        return (ActivityResultDispatcher) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            lg2 lg2Var = this.m;
            if (lg2Var != null && lg2Var.g0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.s) {
                this.r = "schema";
            } else {
                this.r = "user";
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            p0(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            m02.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            H0(FrameLifeState.JUST_STARTED);
            this.s = false;
            aa3.l(false);
            OrientationEventListener orientationEventListener = this.u;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            m02.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.t = false;
            uf3 uf3Var = this.v;
            if (uf3Var != null) {
                uf3Var.e();
            }
            H0(FrameLifeState.JUST_STARTED);
        }
    }

    public void u0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (view2 = this.A) != null) {
            w02.d(this, view2);
            this.A = null;
        }
    }

    public void v0() {
        lg2 lg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (lg2Var = this.m) != null) {
            lg2Var.K0();
        }
    }

    public void z0() {
        lg2 lg2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (lg2Var = this.m) != null) {
            lg2Var.M0();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i2, keyEvent)) == null) {
            lg2 lg2Var = this.m;
            if ((lg2Var != null && lg2Var.r0(i2, keyEvent)) || this.A != null) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void y0(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048644, this, i2, i3) == null) {
            if (-1 < i2) {
                if (i2 == 1) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                setRequestedOrientation(i4);
            }
            if (i3 == 1) {
                if (vg3.p(this)) {
                    vg3.s(this);
                }
                vf3.e(this);
            }
        }
    }

    public void A0(boolean z, q33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
            if (this.w == null) {
                this.w = new oi3(this);
            }
            oi3 oi3Var = this.w;
            boolean z2 = true;
            if (1 != l33.K().q().W().G()) {
                z2 = false;
            }
            oi3Var.E(z2, z, aVar);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, componentName, iBinder) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
            }
            if (iBinder != null) {
                this.n = new Messenger(iBinder);
            }
        }
    }

    public final synchronized boolean B0(m33 m33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m33Var)) == null) {
            synchronized (this) {
                if (this.m != null) {
                    M();
                }
                lg2 a2 = ng2.a(this, m33Var);
                if (a2 == null) {
                    ff3 ff3Var = new ff3();
                    ff3Var.k(5L);
                    ff3Var.i(11L);
                    ff3Var.d("can not buildFramework");
                    go2.e(this, ff3Var, m33Var.k(), m33Var.b);
                    E0();
                    return false;
                }
                this.m = a2;
                g gVar = new g(this);
                if (nx2.h()) {
                    fx2.e().d(gVar, "updateMobStat", false);
                } else {
                    gg3.k(gVar, "updateMobStat");
                }
                y0(m33Var.W().d0(), m33Var.k());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final synchronized void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                m33 q = l33.K().q();
                if (!q.I()) {
                    m02.i("SwanAppActivity", "updateFrame: unavailable");
                } else if (!d0(q.getAppId()) && !B0(q)) {
                    m02.i("SwanAppActivity", "updateFrame: swan app id is null.");
                } else {
                    this.m.update(this.o, z);
                    m02.i("SwanAppActivity", "updateFrame: ");
                    if (B) {
                        w0();
                    }
                    if (this.q == null && sf3.j()) {
                        sf3 m2 = sf3.m();
                        this.q = m2;
                        if (!this.z) {
                            m2.y(S(), getTaskId());
                        }
                    }
                }
            }
        }
    }

    public final void I0(po2 po2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, po2Var) == null) && b0()) {
            this.w.I(po2Var.n("app_icon_url"));
            this.w.K(po2Var.n("app_name"));
            if (l33.K().q().W().G() == 0) {
                this.w.L(po2Var.i("app_pay_protected"));
            }
        }
    }

    public final void m0(q33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onAppOccupied: ");
            }
            jo2.a W = l33.K().q().W();
            y0(W.d0(), W.G());
            A0(false, aVar);
            m02.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        boolean moveTaskToBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            jo2.a S = S();
            boolean z3 = false;
            if (S != null && "1230000000000000".equals(S.T())) {
                z2 = true;
            } else {
                z2 = false;
            }
            sf3 sf3Var = this.q;
            if (sf3Var != null && !z2) {
                sf3Var.v(false);
            }
            if (Z() && !l33.K().q().s0()) {
                try {
                    moveTaskToBack = super.moveTaskToBack(z);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    overridePendingTransition(0, R.anim.obfuscated_res_0x7f010026);
                    return moveTaskToBack;
                } catch (Exception e3) {
                    e = e3;
                    z3 = moveTaskToBack;
                    if (B) {
                        e.printStackTrace();
                    }
                    return z3;
                }
            }
            fa3.Y();
            E0();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            m02.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (Z()) {
                this.m.l0(i2);
                return;
            }
            HybridUbcFlow m2 = rw2.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            ap2.a().d(false);
            moveTaskToBack(true);
        }
    }

    public synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (this.w != null) {
                    this.w.H();
                    if (B) {
                        Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
                    }
                }
                oi3.A();
                oi3.z(tm2.c());
                v22 X = X();
                if (X != null) {
                    v22.b h2 = X.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                bf3.j();
                if (this.m != null) {
                    this.m.R0(FrameLifeState.INACTIVATED);
                    this.m.release();
                    this.m = null;
                }
                k83.r();
                m33 q = l33.K().q();
                q.e0().j();
                q.N().a();
                y83.x();
                um2.o().a();
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            j33 j33Var = this.y;
            j33Var.c(new d(this));
            j33Var.f(new c(this), "event_on_still_maintaining");
            j33Var.f(new b(this), "event_on_app_occupied");
            j33Var.f(new a(this), "event_on_app_updated");
            j33Var.f(new p(this), "event_on_app_icon_update");
            j33Var.f(new o(this), "event_on_pkg_maintain_finish");
            j33Var.f(new n(this), "installer_on_progress");
            j33Var.f(new m(this), "event_first_action_launched");
            j33Var.f(new l(this), "event_on_web_mode_launched");
            ap2.a().c();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            l33.K().o(this.y);
            m02.i("SwanApp", "SwanAppActivity onDestroy");
            this.u = null;
            M();
            if (this.n != null) {
                unbindService(this);
            }
            tm2.H().b();
            uf3 uf3Var = this.v;
            if (uf3Var != null) {
                uf3Var.p();
            }
            l33.K().r(this);
            H0(FrameLifeState.INACTIVATED);
            zo2.b0();
            String appId = l33.K().getAppId();
            if (B) {
                ro2 d2 = ro2.d(appId);
                d2.e().c();
                d2.h();
            }
            k93.l(true);
            l33.K().n(new String[0]);
            this.q = null;
            super.onDestroy();
            ap2.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            m02.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !l33.K().E()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                l33.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
                if (l33.K().E() && lo2.a(intent)) {
                    l33.K().q().W().I0("1250000000000000");
                }
            }
            j0();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            uf3 uf3Var = this.v;
            if (uf3Var != null) {
                uf3Var.t();
            }
            H0(FrameLifeState.JUST_RESUMED);
            oh3.b().d();
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (B) {
                Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            tm2.H().d(this, i2, S());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle.get(FragmentActivity.FRAGMENTS_TAG) != null) {
                bundle.remove(FragmentActivity.FRAGMENTS_TAG);
            }
            Intent intent = getIntent();
            if (intent != null) {
                bundle.putBundle("swan_key_save_bundle", intent.getExtras());
                bundle.putInt("swan_key_save_task_id", getTaskId());
            }
        }
    }

    public void x0(String... strArr) {
        HashSet newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, strArr) == null) {
            M();
            if (strArr == null) {
                newHashSet = Sets.newHashSet();
            } else {
                newHashSet = Sets.newHashSet(strArr);
            }
            if (newHashSet.contains("flag_finish_activity")) {
                if (newHashSet.contains("flag_remove_task")) {
                    E0();
                } else {
                    finish();
                }
            }
        }
    }

    public final boolean h0(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            m02.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + l33.K().getAppId());
            boolean z2 = true;
            if (l33.K().q().E() && l33.K().q().x0()) {
                z = true;
            } else {
                z = false;
            }
            z2 = (!z || TextUtils.equals(str, l33.K().getAppId())) ? false : false;
            m02.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
            if (z2) {
                u93.b bVar = new u93.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
                bVar.l(str);
                bVar.h(l33.K().getAppId());
                bVar.m();
            }
            return z2;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, intent) == null) {
            super.onNewIntent(intent);
            ha2.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            m02.i("SwanApp", "SwanAppActivity onNewIntent");
            setIntent(intent);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            if (B) {
                int flags = intent.getFlags();
                StringBuilder sb = new StringBuilder();
                sb.append("onNewIntent:REORDER_TO_FRONT = ");
                if ((flags & 131072) == 131072) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.i("SwanAppActivity", sb.toString());
            }
            uf3 uf3Var = this.v;
            if (uf3Var != null) {
                uf3Var.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                m02.i("SwanAppActivity", "onNewIntent: start swan web");
                l33.K().q().A0();
            }
            this.s = true;
            aa3.l(true);
            l33 K = l33.K();
            K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (K.E() && lo2.a(intent)) {
                K.q().Y().I0("1250000000000000");
            }
            sf3 sf3Var = this.q;
            if (sf3Var != null) {
                sf3Var.z(intent, getTaskId());
            }
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (z22.b.a()) {
                q0(fj3.b(x63.e()));
            } else if (!isDestroyed()) {
                if (l33.K().q().I()) {
                    G0(true);
                } else {
                    l33.M().postDelayed(new e(this), D);
                }
            }
        }
    }

    public final void w0() {
        m33 q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (q = l33.K().q()) != null) {
            String V = q.Y().V();
            ro2 d2 = ro2.d(q.Y().V());
            d2.f("appId: " + q.b + "  launchId: " + V).e();
            d2.h();
        }
    }

    public final void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                q0(str);
            } else if (isDestroyed()) {
                m02.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
            } else if (z22.b.a() && l33.K().q().z0() && uf4.d()) {
                G0(true);
                ga2.U().a1();
            } else if (a0() && !f0()) {
                G0(true);
                r0(bg4.e().b());
            } else if (l33.K().q().z0() && uf4.d()) {
                G0(true);
                ga2.U().a1();
            } else {
                String D2 = tm2.o().D();
                if (tm2.a().c() && !gh3.G() && !TextUtils.isEmpty(D2)) {
                    G0(true);
                    r0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", l33.K().getAppId()).build().toString());
                    return;
                }
                ff3 ff3Var = new ff3();
                ff3Var.k(1L);
                ff3Var.i(2109L);
                ff3Var.f("web mode start failed.");
                if (f0()) {
                    jf3.a().f(ff3Var);
                    na3 na3Var = new na3();
                    na3Var.p(ff3Var);
                    na3Var.r(l33.K().q().W());
                    na3Var.q(fa3.n(l33.K().k()));
                    na3Var.m(l33.K().getAppId());
                    fa3.R(na3Var);
                }
                go2.e(tm2.c(), ff3Var, 0, "");
                E0();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.ch4, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            ha2.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(U());
            tm2.G().b();
            h03.Q().c0();
            boolean z2 = true;
            this.s = true;
            aa3.l(true);
            if (bundle == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            ea3.d(i2);
            super.onCreate(bundle);
            H0(FrameLifeState.JUST_CREATED);
            if (lg3.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = lo2.a(intent);
            if (a2) {
                intent.putExtra("launch_id", SwanLauncher.h());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                ClassLoader classLoader = getClass().getClassLoader();
                bundle2.setClassLoader(classLoader);
                intent.setExtrasClassLoader(classLoader);
                intent.putExtras(bundle2);
            }
            if (g0(intent)) {
                E0();
                return;
            }
            ga2.v.g(intent);
            if (B) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            if (!t82.a.c()) {
                try {
                    bindService(new Intent(this, U().service), this, 1);
                } catch (Exception e2) {
                    if (B) {
                        e2.printStackTrace();
                    }
                }
            }
            if (Build.VERSION.SDK_INT == 26) {
                TranslucentUtils.convertFromTranslucent(this);
            }
            m02.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            m02.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0093);
            if (R() == 0) {
                dh3.c(this);
            }
            c0();
            l33 K = l33.K();
            K.t(this);
            K.u(this.y);
            if (intent != null && (a2 || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                Bundle extras = intent.getExtras();
                String string = extras.getString("mAppId");
                if (bundle != null && h0(string)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    m02.k("SwanAppActivity", "updateSwanApp by onCreate");
                    K.l(extras, "update_tag_by_activity_on_create");
                }
            }
            if (K.E() && a2) {
                K.q().W().I0("1250000000000000");
            }
            dh3.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.v = new uf3(this);
            }
            uf3 uf3Var = this.v;
            if (uf3Var != null) {
                uf3Var.u(false);
            }
            uf3 uf3Var2 = this.v;
            if (uf3Var2 != null) {
                uf3Var2.o();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            gg3.k(new i(this), "initOnCreate");
            this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048620, this, i2, i3, intent) != null) || getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        cq1.a().b().b().onActivityResult(this, i2, i3, intent);
    }
}
