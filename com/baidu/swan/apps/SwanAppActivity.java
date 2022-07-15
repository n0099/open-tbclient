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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.repackage.a73;
import com.repackage.ac3;
import com.repackage.ad3;
import com.repackage.af3;
import com.repackage.ag3;
import com.repackage.au2;
import com.repackage.b72;
import com.repackage.bd3;
import com.repackage.be3;
import com.repackage.bl2;
import com.repackage.c72;
import com.repackage.cf3;
import com.repackage.cx2;
import com.repackage.e03;
import com.repackage.ec3;
import com.repackage.el2;
import com.repackage.f53;
import com.repackage.f63;
import com.repackage.fd2;
import com.repackage.fx2;
import com.repackage.g03;
import com.repackage.gd2;
import com.repackage.gd3;
import com.repackage.gl2;
import com.repackage.h03;
import com.repackage.h63;
import com.repackage.hq2;
import com.repackage.hx1;
import com.repackage.i73;
import com.repackage.id2;
import com.repackage.iu2;
import com.repackage.je3;
import com.repackage.jf3;
import com.repackage.k73;
import com.repackage.kl2;
import com.repackage.l03;
import com.repackage.ma3;
import com.repackage.ml2;
import com.repackage.mt2;
import com.repackage.na3;
import com.repackage.nc3;
import com.repackage.nc4;
import com.repackage.o52;
import com.repackage.oj2;
import com.repackage.oz2;
import com.repackage.p63;
import com.repackage.pc3;
import com.repackage.pj2;
import com.repackage.pz1;
import com.repackage.qc3;
import com.repackage.qd3;
import com.repackage.qz1;
import com.repackage.rg1;
import com.repackage.rx1;
import com.repackage.s33;
import com.repackage.t53;
import com.repackage.uc4;
import com.repackage.ul2;
import com.repackage.uz1;
import com.repackage.v63;
import com.repackage.vl2;
import com.repackage.wb3;
import com.repackage.xm1;
import com.repackage.yd3;
import com.repackage.z63;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, oz2.a, na3, ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public static final String C;
    public static final long D;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public gd2 m;
    public Messenger n;
    public FrameLifeState o;
    public ActivityResultDispatcher p;
    @Nullable
    public nc3 q;
    public String r;
    public boolean s;
    public boolean t;
    public OrientationEventListener u;
    public pc3 v;
    public jf3 w;
    public oz2 x;
    public final e03 y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.n0(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.m0(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.A0(true, aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements cf3<l03.a, Boolean> {
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
        @Override // com.repackage.cf3
        /* renamed from: b */
        public Boolean a(l03.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? Boolean.valueOf(!this.a.isDestroyed()) : (Boolean) invokeL.objValue;
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
                ul2 U = ul2.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    qz1 V = U.V();
                    if (V == null) {
                        hx1.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        hx1.i("SwanAppActivity", "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        hx1.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        pz1.S3(null);
                        qz1.b i = V.i("init");
                        int i2 = qz1.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", hq2.d(str, str), true).a();
                        jf3 T = activity.T();
                        if (T != null) {
                            T.F(1);
                        }
                        ac3 ac3Var = new ac3();
                        ac3Var.k(1L);
                        ac3Var.i(2110L);
                        ac3Var.f("host url" + this.a);
                        ec3.a().f(ac3Var);
                        i73 i73Var = new i73();
                        i73Var.p(ac3Var);
                        i73Var.r(g03.K().q().W());
                        i73Var.q(a73.n(g03.K().k()));
                        i73Var.m(g03.K().getAppId());
                        a73.R(i73Var);
                        return;
                    }
                }
                hx1.i("SwanAppActivity", "activity is invalid.");
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
                oj2.o().d();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f63.d()) {
                f63.k();
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
                oj2.o().k();
                if (iu2.h()) {
                    return;
                }
                ad3.m(this.a);
            }
        }
    }

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
                    g03.K().c = i;
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
                    h63.d().l();
                } catch (Exception e) {
                    if (SwanAppActivity.B) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.o0(aVar.n("property_launch_url"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.C0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.k0(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.l0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements af3<l03.a> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.I0(aVar);
            }
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
        B = rg1.a;
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
        this.y = new e03();
        this.z = false;
    }

    public void A0(boolean z, @Nullable l03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
            if (this.w == null) {
                this.w = new jf3(this);
            }
            this.w.E(1 == g03.K().q().W().G(), z, aVar);
        }
    }

    public final synchronized boolean B0(h03 h03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h03Var)) == null) {
            synchronized (this) {
                if (this.m != null) {
                    M();
                }
                gd2 a2 = id2.a(this, h03Var);
                if (a2 == null) {
                    ac3 ac3Var = new ac3();
                    ac3Var.k(5L);
                    ac3Var.i(11L);
                    ac3Var.d("can not buildFramework");
                    bl2.e(this, ac3Var, h03Var.k(), h03Var.b);
                    E0();
                    return false;
                }
                this.m = a2;
                g gVar = new g(this);
                if (iu2.h()) {
                    au2.e().d(gVar, "updateMobStat", false);
                } else {
                    bd3.k(gVar, "updateMobStat");
                }
                y0(h03Var.W().d0(), h03Var.k());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                D0(this.o);
            }
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

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            qc3.j(this);
        }
    }

    public void F0(fd2 fd2Var) {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fd2Var) == null) || (gd2Var = this.m) == null) {
            return;
        }
        gd2Var.T0(fd2Var);
    }

    public final synchronized void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                h03 q = g03.K().q();
                if (!q.I()) {
                    hx1.i("SwanAppActivity", "updateFrame: unavailable");
                } else if (!d0(q.getAppId()) && !B0(q)) {
                    hx1.i("SwanAppActivity", "updateFrame: swan app id is null.");
                } else {
                    this.m.update(this.o, z);
                    hx1.i("SwanAppActivity", "updateFrame: ");
                    if (B) {
                        w0();
                    }
                    if (this.q == null && nc3.j()) {
                        nc3 m2 = nc3.m();
                        this.q = m2;
                        if (!this.z) {
                            m2.y(S(), getTaskId());
                        }
                    }
                }
            }
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

    public final void I0(kl2 kl2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kl2Var) == null) && b0()) {
            this.w.I(kl2Var.n("app_icon_url"));
            this.w.K(kl2Var.n("app_name"));
            if (g03.K().q().W().G() == 0) {
                this.w.L(kl2Var.i("app_pay_protected"));
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.A == null) {
            this.A = rx1.a(this);
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
                jf3.A();
                jf3.z(oj2.c());
                qz1 X = X();
                if (X != null) {
                    qz1.b h2 = X.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                wb3.j();
                if (this.m != null) {
                    this.m.R0(FrameLifeState.INACTIVATED);
                    this.m.release();
                    this.m = null;
                }
                f53.r();
                h03 q = g03.K().q();
                q.e0().j();
                q.N().a();
                t53.x();
                pj2.o().a();
            }
        }
    }

    public final void N(k73 k73Var) {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, k73Var) == null) || (gd2Var = this.m) == null) {
            return;
        }
        gd2Var.Q(k73Var);
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = (S() == null || S().d0() != 1) ? 2 : 3;
            if (T() != null) {
                T().F(i2);
            }
        }
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            gd2 gd2Var = this.m;
            return gd2Var == null ? "" : gd2Var.i;
        }
        return (String) invokeV.objValue;
    }

    public gd2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : (gd2) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            gd2 gd2Var = this.m;
            if (gd2Var == null) {
                return -1;
            }
            return gd2Var.k();
        }
        return invokeV.intValue;
    }

    public el2.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            gd2 gd2Var = this.m;
            if (gd2Var == null) {
                return null;
            }
            return gd2Var.Z();
        }
        return (el2.a) invokeV.objValue;
    }

    public jf3 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w : (jf3) invokeV.objValue;
    }

    public SwanAppProcessInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? SwanAppProcessInfo.P0 : (SwanAppProcessInfo) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public pc3 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.v : (pc3) invokeV.objValue;
    }

    @Nullable
    public qz1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            gd2 gd2Var = this.m;
            if (gd2Var == null) {
                return null;
            }
            return gd2Var.c0();
        }
        return (qz1) invokeV.objValue;
    }

    @UiThread
    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (B) {
                Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            oj2.H().d(this, i2, S());
        }
    }

    public synchronized boolean Z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                if (!isDestroyed() && this.m != null) {
                    z = this.m.a0().activated();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? !TextUtils.isEmpty(uc4.e().b()) : invokeV.booleanValue;
    }

    @Override // com.repackage.na3
    public ma3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            gd2 gd2Var = this.m;
            if (gd2Var == null) {
                return null;
            }
            return gd2Var.d0();
        }
        return (ma3) invokeV.objValue;
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.w == null || isDestroyed()) ? false : true : invokeV.booleanValue;
    }

    @Override // com.repackage.oz2.a
    @NonNull
    public oz2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.x == null) {
                this.x = new oz2(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.x;
        }
        return (oz2) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            e03 e03Var = this.y;
            e03Var.c(new d(this));
            e03Var.f(new c(this), "event_on_still_maintaining");
            e03Var.f(new b(this), "event_on_app_occupied");
            e03Var.f(new a(this), "event_on_app_updated");
            e03Var.f(new p(this), "event_on_app_icon_update");
            e03Var.f(new o(this), "event_on_pkg_maintain_finish");
            e03Var.f(new n(this), "installer_on_progress");
            e03Var.f(new m(this), "event_first_action_launched");
            e03Var.f(new l(this), "event_on_web_mode_launched");
            vl2.a().c();
        }
    }

    public boolean d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? !TextUtils.isEmpty(str) && TextUtils.equals(str, P()) : invokeL.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            PMSAppInfo f0 = g03.K().q().W().f0();
            return f0 != null && f0.appStatus == 6;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.finish();
            if (B) {
                hx1.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
            }
        }
    }

    public final boolean g0(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, intent)) == null) {
            if (intent != null) {
                ComponentName component = intent.getComponent();
                return (component == null || component.getClassName().startsWith(C)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
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

    public final boolean h0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            hx1.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + g03.K().getAppId());
            boolean z = true;
            z = (!(g03.K().q().E() && g03.K().q().x0()) || TextUtils.equals(str, g03.K().getAppId())) ? false : false;
            hx1.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z);
            if (z) {
                p63.b bVar = new p63.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
                bVar.l(str);
                bVar.h(g03.K().getAppId());
                bVar.m();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            gd2 gd2Var = this.m;
            return gd2Var != null && gd2Var.g0();
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

    public final void k0(kl2 kl2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, kl2Var) == null) && b0() && kl2Var.c(" event_params_installer_progress")) {
            this.w.u(kl2Var.g(" event_params_installer_progress"));
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (uz1.b.a()) {
                q0(ag3.b(s33.e()));
            } else if (isDestroyed()) {
            } else {
                if (g03.K().q().I()) {
                    G0(true);
                } else {
                    g03.M().postDelayed(new e(this), D);
                }
            }
        }
    }

    public final void m0(l03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onAppOccupied: ");
            }
            el2.a W = g03.K().q().W();
            y0(W.d0(), W.G());
            A0(false, aVar);
            hx1.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        boolean moveTaskToBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            el2.a S = S();
            boolean z2 = false;
            boolean z3 = S != null && "1230000000000000".equals(S.T());
            nc3 nc3Var = this.q;
            if (nc3Var != null && !z3) {
                nc3Var.v(false);
            }
            if (Z() && !g03.K().q().s0()) {
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
                    z2 = moveTaskToBack;
                    if (B) {
                        e.printStackTrace();
                    }
                    return z2;
                }
            }
            a73.Y();
            E0();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void n0(kl2 kl2Var) {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, kl2Var) == null) && (gd2Var = this.m) != null && gd2Var.f0()) {
            G0("update_tag_by_activity_on_new_intent".equals(kl2Var.n("app_update_tag")));
        }
    }

    public final void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                q0(str);
            } else if (isDestroyed()) {
                hx1.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
            } else if (uz1.b.a() && g03.K().q().z0() && nc4.d()) {
                G0(true);
                b72.U().a1();
            } else if (a0() && !f0()) {
                G0(true);
                r0(uc4.e().b());
            } else if (g03.K().q().z0() && nc4.d()) {
                G0(true);
                b72.U().a1();
            } else {
                String D2 = oj2.o().D();
                if (oj2.a().c() && !be3.G() && !TextUtils.isEmpty(D2)) {
                    G0(true);
                    r0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", g03.K().getAppId()).build().toString());
                    return;
                }
                ac3 ac3Var = new ac3();
                ac3Var.k(1L);
                ac3Var.i(2109L);
                ac3Var.f("web mode start failed.");
                if (f0()) {
                    ec3.a().f(ac3Var);
                    i73 i73Var = new i73();
                    i73Var.p(ac3Var);
                    i73Var.r(g03.K().q().W());
                    i73Var.q(a73.n(g03.K().k()));
                    i73Var.m(g03.K().getAppId());
                    a73.R(i73Var);
                }
                bl2.e(oj2.c(), ac3Var, 0, "");
                E0();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) || getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        xm1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            p0(1);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.vd4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            c72.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(U());
            oj2.G().b();
            cx2.Q().c0();
            boolean z = true;
            this.s = true;
            v63.l(true);
            z63.d(bundle == null ? 0 : 1);
            super.onCreate(bundle);
            H0(FrameLifeState.JUST_CREATED);
            if (gd3.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = gl2.a(intent);
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
            b72.v.g(intent);
            if (B) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            if (!o52.a.c()) {
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
            hx1.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            hx1.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0090);
            if (R() == 0) {
                yd3.c(this);
            }
            c0();
            g03 K = g03.K();
            K.t(this);
            K.u(this.y);
            if (intent != null && (a2 || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                Bundle extras = intent.getExtras();
                if (bundle == null || !h0(extras.getString("mAppId"))) {
                    hx1.k("SwanAppActivity", "updateSwanApp by onCreate");
                    K.l(extras, "update_tag_by_activity_on_create");
                }
            }
            if (K.E() && a2) {
                K.q().W().I0("1250000000000000");
            }
            yd3.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.v = new pc3(this);
            }
            pc3 pc3Var = this.v;
            if (pc3Var != null) {
                pc3Var.u(false);
            }
            pc3 pc3Var2 = this.v;
            if (pc3Var2 != null) {
                pc3Var2.o();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            bd3.k(new i(this), "initOnCreate");
            this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            g03.K().o(this.y);
            hx1.i("SwanApp", "SwanAppActivity onDestroy");
            this.u = null;
            M();
            if (this.n != null) {
                unbindService(this);
            }
            oj2.H().b();
            pc3 pc3Var = this.v;
            if (pc3Var != null) {
                pc3Var.p();
            }
            g03.K().r(this);
            H0(FrameLifeState.INACTIVATED);
            ul2.b0();
            String appId = g03.K().getAppId();
            if (B) {
                ml2 d2 = ml2.d(appId);
                d2.e().c();
                d2.h();
            }
            f63.l(true);
            g03.K().n(new String[0]);
            this.q = null;
            super.onDestroy();
            vl2.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i2, keyEvent)) == null) {
            gd2 gd2Var = this.m;
            if ((gd2Var == null || !gd2Var.r0(i2, keyEvent)) && this.A == null) {
                return super.onKeyDown(i2, keyEvent);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, intent) == null) {
            super.onNewIntent(intent);
            c72.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            hx1.i("SwanApp", "SwanAppActivity onNewIntent");
            setIntent(intent);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            if (B) {
                int flags = intent.getFlags();
                StringBuilder sb = new StringBuilder();
                sb.append("onNewIntent:REORDER_TO_FRONT = ");
                sb.append((flags & 131072) == 131072);
                Log.i("SwanAppActivity", sb.toString());
            }
            pc3 pc3Var = this.v;
            if (pc3Var != null) {
                pc3Var.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                hx1.i("SwanAppActivity", "onNewIntent: start swan web");
                g03.K().q().A0();
            }
            this.s = true;
            v63.l(true);
            g03 K = g03.K();
            K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (K.E() && gl2.a(intent)) {
                K.q().Y().I0("1250000000000000");
            }
            nc3 nc3Var = this.q;
            if (nc3Var != null) {
                nc3Var.z(intent, getTaskId());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            hx1.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            H0(FrameLifeState.JUST_STARTED);
            this.s = false;
            v63.l(false);
            OrientationEventListener orientationEventListener = this.u;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onPostCreate(bundle);
            pc3 pc3Var = this.v;
            if (pc3Var != null) {
                pc3Var.m();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            hx1.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !g03.K().E()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                g03.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
                if (g03.K().E() && gl2.a(intent)) {
                    g03.K().q().W().I0("1250000000000000");
                }
            }
            j0();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            pc3 pc3Var = this.v;
            if (pc3Var != null) {
                pc3Var.t();
            }
            H0(FrameLifeState.JUST_RESUMED);
            je3.b().d();
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

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            hx1.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.t = false;
            pc3 pc3Var = this.v;
            if (pc3Var != null) {
                pc3Var.e();
            }
            H0(FrameLifeState.JUST_STARTED);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            hx1.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.t = true;
            H0(FrameLifeState.JUST_CREATED);
            if (!Z()) {
                mt2.m();
            }
            bd3.k(new k(this), "tracer");
            oj2.p0().flush(false);
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

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            hx1.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (Z()) {
                this.m.l0(i2);
                return;
            }
            HybridUbcFlow m2 = mt2.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            vl2.a().d(false);
            moveTaskToBack(true);
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            G0(true);
            b72.U().b1(str);
        }
    }

    public final void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            be3.e0(new f(this, str));
        }
    }

    public void s0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            fx2.k(this, bundle);
        }
    }

    public void t0(fd2 fd2Var) {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, fd2Var) == null) || (gd2Var = this.m) == null) {
            return;
        }
        gd2Var.I0(fd2Var);
    }

    public void u0() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (view2 = this.A) == null) {
            return;
        }
        rx1.d(this, view2);
        this.A = null;
    }

    public void v0() {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (gd2Var = this.m) == null) {
            return;
        }
        gd2Var.K0();
    }

    public final void w0() {
        h03 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (q = g03.K().q()) == null) {
            return;
        }
        String V = q.Y().V();
        ml2 d2 = ml2.d(q.Y().V());
        d2.f("appId: " + q.b + "  launchId: " + V).e();
        d2.h();
    }

    public void x0(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, strArr) == null) {
            M();
            HashSet newHashSet = strArr == null ? Sets.newHashSet() : Sets.newHashSet(strArr);
            if (newHashSet.contains("flag_finish_activity")) {
                if (newHashSet.contains("flag_remove_task")) {
                    E0();
                } else {
                    finish();
                }
            }
        }
    }

    public final void y0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048644, this, i2, i3) == null) {
            if (-1 < i2) {
                setRequestedOrientation(i2 == 1 ? 0 : 1);
            }
            if (i3 == 1) {
                if (qd3.p(this)) {
                    qd3.s(this);
                }
                qc3.e(this);
            }
        }
    }

    public void z0() {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (gd2Var = this.m) == null) {
            return;
        }
        gd2Var.M0();
    }
}
