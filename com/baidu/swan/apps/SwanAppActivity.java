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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media2.session.SessionCommand;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
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
import com.baidu.tieba.a13;
import com.baidu.tieba.ab2;
import com.baidu.tieba.aj3;
import com.baidu.tieba.c43;
import com.baidu.tieba.cg3;
import com.baidu.tieba.cp2;
import com.baidu.tieba.d13;
import com.baidu.tieba.d93;
import com.baidu.tieba.da3;
import com.baidu.tieba.dh2;
import com.baidu.tieba.e43;
import com.baidu.tieba.eh2;
import com.baidu.tieba.eh3;
import com.baidu.tieba.ep2;
import com.baidu.tieba.f12;
import com.baidu.tieba.f43;
import com.baidu.tieba.fa3;
import com.baidu.tieba.fu2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.gh2;
import com.baidu.tieba.gy2;
import com.baidu.tieba.hi3;
import com.baidu.tieba.hj3;
import com.baidu.tieba.ib3;
import com.baidu.tieba.ip2;
import com.baidu.tieba.j43;
import com.baidu.tieba.ke3;
import com.baidu.tieba.kp2;
import com.baidu.tieba.kx2;
import com.baidu.tieba.le3;
import com.baidu.tieba.lg3;
import com.baidu.tieba.m33;
import com.baidu.tieba.m92;
import com.baidu.tieba.mn2;
import com.baidu.tieba.n32;
import com.baidu.tieba.na3;
import com.baidu.tieba.ng3;
import com.baidu.tieba.ng4;
import com.baidu.tieba.nn2;
import com.baidu.tieba.o32;
import com.baidu.tieba.og3;
import com.baidu.tieba.oh3;
import com.baidu.tieba.p12;
import com.baidu.tieba.pk1;
import com.baidu.tieba.q73;
import com.baidu.tieba.r93;
import com.baidu.tieba.s32;
import com.baidu.tieba.sp2;
import com.baidu.tieba.ta3;
import com.baidu.tieba.tp2;
import com.baidu.tieba.uf3;
import com.baidu.tieba.ug4;
import com.baidu.tieba.vq1;
import com.baidu.tieba.wh3;
import com.baidu.tieba.xa3;
import com.baidu.tieba.ya3;
import com.baidu.tieba.yf3;
import com.baidu.tieba.yg3;
import com.baidu.tieba.yi3;
import com.baidu.tieba.yj3;
import com.baidu.tieba.yx2;
import com.baidu.tieba.za2;
import com.baidu.tieba.zg3;
import com.baidu.tieba.zh3;
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
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, m33.a, le3, ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public static final String C;
    public static final long D;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public eh2 m;
    public Messenger n;
    public FrameLifeState o;
    public ActivityResultDispatcher p;
    @Nullable
    public lg3 q;
    public String r;
    public boolean s;
    public boolean t;
    public OrientationEventListener u;
    public ng3 v;
    public hj3 w;
    public m33 x;
    public final c43 y;
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
                    e43.K().c = i;
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
    public class a implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.n0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.m0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.A0(true, aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements aj3<j43.a, Boolean> {
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
        @Override // com.baidu.tieba.aj3
        /* renamed from: b */
        public Boolean a(j43.a aVar) {
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
                sp2 U = sp2.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    o32 V = U.V();
                    if (V == null) {
                        f12.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        f12.i("SwanAppActivity", "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        f12.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        n32.S3(null);
                        o32.b i = V.i("init");
                        int i2 = o32.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", fu2.d(str, str), true).a();
                        hj3 T = activity.T();
                        if (T != null) {
                            T.F(1);
                        }
                        yf3 yf3Var = new yf3();
                        yf3Var.k(1L);
                        yf3Var.i(2110L);
                        yf3Var.f("host url" + this.a);
                        cg3.a().f(yf3Var);
                        gb3 gb3Var = new gb3();
                        gb3Var.p(yf3Var);
                        gb3Var.r(e43.K().q().W());
                        gb3Var.q(ya3.n(e43.K().k()));
                        gb3Var.m(e43.K().getAppId());
                        ya3.R(gb3Var);
                        return;
                    }
                }
                f12.i("SwanAppActivity", "activity is invalid.");
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
                mn2.o().d();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && da3.d()) {
                da3.k();
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
                mn2.o().k();
                if (!gy2.h()) {
                    yg3.m(this.a);
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
                    fa3.d().l();
                } catch (Exception e) {
                    if (SwanAppActivity.B) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.o0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes2.dex */
    public class m implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.C0();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.k0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.l0();
        }
    }

    /* loaded from: classes2.dex */
    public class p implements yi3<j43.a> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(j43.a aVar) {
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
        B = pk1.a;
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
        this.y = new c43();
        this.z = false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            f12.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.t = true;
            H0(FrameLifeState.JUST_CREATED);
            if (!Z()) {
                kx2.m();
            }
            zg3.k(new k(this), "tracer");
            mn2.p0().flush(false);
        }
    }

    public final synchronized void D0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frameLifeState) == null) {
            synchronized (this) {
                if (this.m != null && !this.m.i0()) {
                    this.m.R0(frameLifeState);
                }
            }
        }
    }

    public void F0(dh2 dh2Var) {
        eh2 eh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dh2Var) == null) && (eh2Var = this.m) != null) {
            eh2Var.T0(dh2Var);
        }
    }

    public final synchronized void H0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, frameLifeState) == null) {
            synchronized (this) {
                this.o = frameLifeState;
                C0();
            }
        }
    }

    public final void N(ib3 ib3Var) {
        eh2 eh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, ib3Var) == null) && (eh2Var = this.m) != null) {
            eh2Var.Q(ib3Var);
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

    public final void k0(ip2 ip2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, ip2Var) == null) && b0() && ip2Var.c(" event_params_installer_progress")) {
            this.w.u(ip2Var.g(" event_params_installer_progress"));
        }
    }

    public final void n0(ip2 ip2Var) {
        eh2 eh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, ip2Var) == null) && (eh2Var = this.m) != null && eh2Var.f0()) {
            G0("update_tag_by_activity_on_new_intent".equals(ip2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onPostCreate(bundle);
            ng3 ng3Var = this.v;
            if (ng3Var != null) {
                ng3Var.n();
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
            za2.U().b1(str);
        }
    }

    public final void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            zh3.e0(new f(this, str));
        }
    }

    public void s0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            d13.k(this, bundle);
        }
    }

    public void t0(dh2 dh2Var) {
        eh2 eh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, dh2Var) == null) && (eh2Var = this.m) != null) {
            eh2Var.I0(dh2Var);
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
            og3.j(this);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.A == null) {
            this.A = p12.a(this);
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
            eh2 eh2Var = this.m;
            if (eh2Var == null) {
                return "";
            }
            return eh2Var.i;
        }
        return (String) invokeV.objValue;
    }

    public eh2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.m;
        }
        return (eh2) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            eh2 eh2Var = this.m;
            if (eh2Var == null) {
                return -1;
            }
            return eh2Var.k();
        }
        return invokeV.intValue;
    }

    public cp2.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            eh2 eh2Var = this.m;
            if (eh2Var == null) {
                return null;
            }
            return eh2Var.Z();
        }
        return (cp2.a) invokeV.objValue;
    }

    public hj3 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.w;
        }
        return (hj3) invokeV.objValue;
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

    public ng3 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.v;
        }
        return (ng3) invokeV.objValue;
    }

    @Nullable
    public o32 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            eh2 eh2Var = this.m;
            if (eh2Var == null) {
                return null;
            }
            return eh2Var.c0();
        }
        return (o32) invokeV.objValue;
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
            return !TextUtils.isEmpty(ug4.e().b());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.le3
    public ke3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            eh2 eh2Var = this.m;
            if (eh2Var == null) {
                return null;
            }
            return eh2Var.d0();
        }
        return (ke3) invokeV.objValue;
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

    @Override // com.baidu.tieba.m33.a
    @NonNull
    public m33 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.x == null) {
                this.x = new m33(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.x;
        }
        return (m33) invokeV.objValue;
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
            PMSAppInfo f0 = e43.K().q().W().f0();
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
                f12.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
            }
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
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
            eh2 eh2Var = this.m;
            if (eh2Var != null && eh2Var.g0()) {
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
            f12.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            H0(FrameLifeState.JUST_STARTED);
            this.s = false;
            ta3.l(false);
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
            f12.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.t = false;
            ng3 ng3Var = this.v;
            if (ng3Var != null) {
                ng3Var.e();
            }
            H0(FrameLifeState.JUST_STARTED);
        }
    }

    public void u0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (view2 = this.A) != null) {
            p12.d(this, view2);
            this.A = null;
        }
    }

    public void v0() {
        eh2 eh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (eh2Var = this.m) != null) {
            eh2Var.K0();
        }
    }

    public void z0() {
        eh2 eh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (eh2Var = this.m) != null) {
            eh2Var.M0();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i2, keyEvent)) == null) {
            eh2 eh2Var = this.m;
            if ((eh2Var != null && eh2Var.r0(i2, keyEvent)) || this.A != null) {
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
                if (oh3.p(this)) {
                    oh3.s(this);
                }
                og3.e(this);
            }
        }
    }

    public void A0(boolean z, @Nullable j43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
            if (this.w == null) {
                this.w = new hj3(this);
            }
            hj3 hj3Var = this.w;
            boolean z2 = true;
            if (1 != e43.K().q().W().G()) {
                z2 = false;
            }
            hj3Var.E(z2, z, aVar);
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

    public final synchronized boolean B0(f43 f43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f43Var)) == null) {
            synchronized (this) {
                if (this.m != null) {
                    M();
                }
                eh2 a2 = gh2.a(this, f43Var);
                if (a2 == null) {
                    yf3 yf3Var = new yf3();
                    yf3Var.k(5L);
                    yf3Var.i(11L);
                    yf3Var.d("can not buildFramework");
                    zo2.e(this, yf3Var, f43Var.k(), f43Var.b);
                    E0();
                    return false;
                }
                this.m = a2;
                g gVar = new g(this);
                if (gy2.h()) {
                    yx2.e().d(gVar, "updateMobStat", false);
                } else {
                    zg3.k(gVar, "updateMobStat");
                }
                y0(f43Var.W().d0(), f43Var.k());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final synchronized void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                f43 q = e43.K().q();
                if (!q.I()) {
                    f12.i("SwanAppActivity", "updateFrame: unavailable");
                } else if (!d0(q.getAppId()) && !B0(q)) {
                    f12.i("SwanAppActivity", "updateFrame: swan app id is null.");
                } else {
                    this.m.update(this.o, z);
                    f12.i("SwanAppActivity", "updateFrame: ");
                    if (B) {
                        w0();
                    }
                    if (this.q == null && lg3.j()) {
                        lg3 m2 = lg3.m();
                        this.q = m2;
                        if (!this.z) {
                            m2.y(S(), getTaskId());
                        }
                    }
                }
            }
        }
    }

    public final void I0(ip2 ip2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ip2Var) == null) && b0()) {
            this.w.I(ip2Var.n("app_icon_url"));
            this.w.K(ip2Var.n("app_name"));
            if (e43.K().q().W().G() == 0) {
                this.w.L(ip2Var.i("app_pay_protected"));
            }
        }
    }

    public final void m0(j43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onAppOccupied: ");
            }
            cp2.a W = e43.K().q().W();
            y0(W.d0(), W.G());
            A0(false, aVar);
            f12.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        boolean moveTaskToBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            cp2.a S = S();
            boolean z3 = false;
            if (S != null && "1230000000000000".equals(S.T())) {
                z2 = true;
            } else {
                z2 = false;
            }
            lg3 lg3Var = this.q;
            if (lg3Var != null && !z2) {
                lg3Var.v(false);
            }
            if (Z() && !e43.K().q().s0()) {
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
            ya3.Y();
            E0();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            f12.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (Z()) {
                this.m.l0(i2);
                return;
            }
            HybridUbcFlow m2 = kx2.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            tp2.a().d(false);
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
                hj3.A();
                hj3.z(mn2.c());
                o32 X = X();
                if (X != null) {
                    o32.b h2 = X.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                uf3.j();
                if (this.m != null) {
                    this.m.R0(FrameLifeState.INACTIVATED);
                    this.m.release();
                    this.m = null;
                }
                d93.r();
                f43 q = e43.K().q();
                q.e0().j();
                q.N().a();
                r93.x();
                nn2.o().a();
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c43 c43Var = this.y;
            c43Var.c(new d(this));
            c43Var.f(new c(this), "event_on_still_maintaining");
            c43Var.f(new b(this), "event_on_app_occupied");
            c43Var.f(new a(this), "event_on_app_updated");
            c43Var.f(new p(this), "event_on_app_icon_update");
            c43Var.f(new o(this), "event_on_pkg_maintain_finish");
            c43Var.f(new n(this), "installer_on_progress");
            c43Var.f(new m(this), "event_first_action_launched");
            c43Var.f(new l(this), "event_on_web_mode_launched");
            tp2.a().c();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            e43.K().o(this.y);
            f12.i("SwanApp", "SwanAppActivity onDestroy");
            this.u = null;
            M();
            if (this.n != null) {
                unbindService(this);
            }
            mn2.H().b();
            ng3 ng3Var = this.v;
            if (ng3Var != null) {
                ng3Var.p();
            }
            e43.K().r(this);
            H0(FrameLifeState.INACTIVATED);
            sp2.b0();
            String appId = e43.K().getAppId();
            if (B) {
                kp2 d2 = kp2.d(appId);
                d2.e().c();
                d2.h();
            }
            da3.l(true);
            e43.K().n(new String[0]);
            this.q = null;
            super.onDestroy();
            tp2.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            f12.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !e43.K().E()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                e43.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
                if (e43.K().E() && ep2.a(intent)) {
                    e43.K().q().W().I0("1250000000000000");
                }
            }
            j0();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            ng3 ng3Var = this.v;
            if (ng3Var != null) {
                ng3Var.t();
            }
            H0(FrameLifeState.JUST_RESUMED);
            hi3.b().d();
        }
    }

    @UiThread
    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (B) {
                Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            mn2.H().d(this, i2, S());
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
            f12.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + e43.K().getAppId());
            boolean z2 = true;
            if (e43.K().q().E() && e43.K().q().x0()) {
                z = true;
            } else {
                z = false;
            }
            z2 = (!z || TextUtils.equals(str, e43.K().getAppId())) ? false : false;
            f12.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
            if (z2) {
                na3.b bVar = new na3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
                bVar.l(str);
                bVar.h(e43.K().getAppId());
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
            ab2.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            f12.i("SwanApp", "SwanAppActivity onNewIntent");
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
            ng3 ng3Var = this.v;
            if (ng3Var != null) {
                ng3Var.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                f12.i("SwanAppActivity", "onNewIntent: start swan web");
                e43.K().q().A0();
            }
            this.s = true;
            ta3.l(true);
            e43 K = e43.K();
            K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (K.E() && ep2.a(intent)) {
                K.q().Y().I0("1250000000000000");
            }
            lg3 lg3Var = this.q;
            if (lg3Var != null) {
                lg3Var.z(intent, getTaskId());
            }
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (s32.b.a()) {
                q0(yj3.b(q73.e()));
            } else if (!isDestroyed()) {
                if (e43.K().q().I()) {
                    G0(true);
                } else {
                    e43.M().postDelayed(new e(this), D);
                }
            }
        }
    }

    public final void w0() {
        f43 q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (q = e43.K().q()) != null) {
            String V = q.Y().V();
            kp2 d2 = kp2.d(q.Y().V());
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
                f12.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
            } else if (s32.b.a() && e43.K().q().z0() && ng4.d()) {
                G0(true);
                za2.U().a1();
            } else if (a0() && !f0()) {
                G0(true);
                r0(ug4.e().b());
            } else if (e43.K().q().z0() && ng4.d()) {
                G0(true);
                za2.U().a1();
            } else {
                String D2 = mn2.o().D();
                if (mn2.a().c() && !zh3.G() && !TextUtils.isEmpty(D2)) {
                    G0(true);
                    r0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", e43.K().getAppId()).build().toString());
                    return;
                }
                yf3 yf3Var = new yf3();
                yf3Var.k(1L);
                yf3Var.i(2109L);
                yf3Var.f("web mode start failed.");
                if (f0()) {
                    cg3.a().f(yf3Var);
                    gb3 gb3Var = new gb3();
                    gb3Var.p(yf3Var);
                    gb3Var.r(e43.K().q().W());
                    gb3Var.q(ya3.n(e43.K().k()));
                    gb3Var.m(e43.K().getAppId());
                    ya3.R(gb3Var);
                }
                zo2.e(mn2.c(), yf3Var, 0, "");
                E0();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vh4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            ab2.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(U());
            mn2.G().b();
            a13.Q().c0();
            boolean z2 = true;
            this.s = true;
            ta3.l(true);
            if (bundle == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            xa3.d(i2);
            super.onCreate(bundle);
            H0(FrameLifeState.JUST_CREATED);
            if (eh3.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = ep2.a(intent);
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
            za2.v.g(intent);
            if (B) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            if (!m92.a.c()) {
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
            f12.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            f12.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0094);
            if (R() == 0) {
                wh3.c(this);
            }
            c0();
            e43 K = e43.K();
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
                    f12.k("SwanAppActivity", "updateSwanApp by onCreate");
                    K.l(extras, "update_tag_by_activity_on_create");
                }
            }
            if (K.E() && a2) {
                K.q().W().I0("1250000000000000");
            }
            wh3.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.v = new ng3(this);
            }
            ng3 ng3Var = this.v;
            if (ng3Var != null) {
                ng3Var.u(false);
            }
            ng3 ng3Var2 = this.v;
            if (ng3Var2 != null) {
                ng3Var2.o();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            zg3.k(new i(this), "initOnCreate");
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
        vq1.a().b().b().onActivityResult(this, i2, i3, intent);
    }
}
