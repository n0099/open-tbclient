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
import com.repackage.b73;
import com.repackage.bc3;
import com.repackage.bd3;
import com.repackage.bf3;
import com.repackage.bg3;
import com.repackage.bu2;
import com.repackage.c72;
import com.repackage.cd3;
import com.repackage.ce3;
import com.repackage.cl2;
import com.repackage.d72;
import com.repackage.df3;
import com.repackage.dx2;
import com.repackage.f03;
import com.repackage.fc3;
import com.repackage.fl2;
import com.repackage.g53;
import com.repackage.g63;
import com.repackage.gd2;
import com.repackage.gx2;
import com.repackage.h03;
import com.repackage.hd2;
import com.repackage.hd3;
import com.repackage.hl2;
import com.repackage.i03;
import com.repackage.i63;
import com.repackage.iq2;
import com.repackage.ix1;
import com.repackage.j73;
import com.repackage.jd2;
import com.repackage.ju2;
import com.repackage.ke3;
import com.repackage.kf3;
import com.repackage.l73;
import com.repackage.ll2;
import com.repackage.m03;
import com.repackage.na3;
import com.repackage.nl2;
import com.repackage.nt2;
import com.repackage.oa3;
import com.repackage.oc3;
import com.repackage.oc4;
import com.repackage.p52;
import com.repackage.pj2;
import com.repackage.pz2;
import com.repackage.q63;
import com.repackage.qc3;
import com.repackage.qj2;
import com.repackage.qz1;
import com.repackage.rc3;
import com.repackage.rd3;
import com.repackage.rz1;
import com.repackage.sg1;
import com.repackage.sx1;
import com.repackage.t33;
import com.repackage.u53;
import com.repackage.vc4;
import com.repackage.vl2;
import com.repackage.vz1;
import com.repackage.w63;
import com.repackage.wl2;
import com.repackage.xb3;
import com.repackage.ym1;
import com.repackage.zd3;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, pz2.a, oa3, ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public static final String C;
    public static final long D;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public hd2 m;
    public Messenger n;
    public FrameLifeState o;
    public ActivityResultDispatcher p;
    @Nullable
    public oc3 q;
    public String r;
    public boolean s;
    public boolean t;
    public OrientationEventListener u;
    public qc3 v;
    public kf3 w;
    public pz2 x;
    public final f03 y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.n0(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.m0(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.A0(true, aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements df3<m03.a, Boolean> {
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
        @Override // com.repackage.df3
        /* renamed from: b */
        public Boolean a(m03.a aVar) {
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
                vl2 U = vl2.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    rz1 V = U.V();
                    if (V == null) {
                        ix1.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        ix1.i("SwanAppActivity", "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        ix1.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        qz1.S3(null);
                        rz1.b i = V.i("init");
                        int i2 = rz1.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", iq2.d(str, str), true).a();
                        kf3 T = activity.T();
                        if (T != null) {
                            T.F(1);
                        }
                        bc3 bc3Var = new bc3();
                        bc3Var.k(1L);
                        bc3Var.i(2110L);
                        bc3Var.f("host url" + this.a);
                        fc3.a().f(bc3Var);
                        j73 j73Var = new j73();
                        j73Var.p(bc3Var);
                        j73Var.r(h03.K().q().W());
                        j73Var.q(b73.n(h03.K().k()));
                        j73Var.m(h03.K().getAppId());
                        b73.R(j73Var);
                        return;
                    }
                }
                ix1.i("SwanAppActivity", "activity is invalid.");
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
                pj2.o().d();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && g63.d()) {
                g63.k();
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
                pj2.o().k();
                if (ju2.h()) {
                    return;
                }
                bd3.m(this.a);
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
                    h03.K().c = i;
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
                    i63.d().l();
                } catch (Exception e) {
                    if (SwanAppActivity.B) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.o0(aVar.n("property_launch_url"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.C0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.k0(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.l0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements bf3<m03.a> {
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
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
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
        B = sg1.a;
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
        this.y = new f03();
        this.z = false;
    }

    public void A0(boolean z, @Nullable m03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
            if (this.w == null) {
                this.w = new kf3(this);
            }
            this.w.E(1 == h03.K().q().W().G(), z, aVar);
        }
    }

    public final synchronized boolean B0(i03 i03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i03Var)) == null) {
            synchronized (this) {
                if (this.m != null) {
                    M();
                }
                hd2 a2 = jd2.a(this, i03Var);
                if (a2 == null) {
                    bc3 bc3Var = new bc3();
                    bc3Var.k(5L);
                    bc3Var.i(11L);
                    bc3Var.d("can not buildFramework");
                    cl2.e(this, bc3Var, i03Var.k(), i03Var.b);
                    E0();
                    return false;
                }
                this.m = a2;
                g gVar = new g(this);
                if (ju2.h()) {
                    bu2.e().d(gVar, "updateMobStat", false);
                } else {
                    cd3.k(gVar, "updateMobStat");
                }
                y0(i03Var.W().d0(), i03Var.k());
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
            rc3.j(this);
        }
    }

    public void F0(gd2 gd2Var) {
        hd2 hd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gd2Var) == null) || (hd2Var = this.m) == null) {
            return;
        }
        hd2Var.T0(gd2Var);
    }

    public final synchronized void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                i03 q = h03.K().q();
                if (!q.I()) {
                    ix1.i("SwanAppActivity", "updateFrame: unavailable");
                } else if (!d0(q.getAppId()) && !B0(q)) {
                    ix1.i("SwanAppActivity", "updateFrame: swan app id is null.");
                } else {
                    this.m.update(this.o, z);
                    ix1.i("SwanAppActivity", "updateFrame: ");
                    if (B) {
                        w0();
                    }
                    if (this.q == null && oc3.j()) {
                        oc3 m2 = oc3.m();
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

    public final void I0(ll2 ll2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ll2Var) == null) && b0()) {
            this.w.I(ll2Var.n("app_icon_url"));
            this.w.K(ll2Var.n("app_name"));
            if (h03.K().q().W().G() == 0) {
                this.w.L(ll2Var.i("app_pay_protected"));
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.A == null) {
            this.A = sx1.a(this);
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
                kf3.A();
                kf3.z(pj2.c());
                rz1 X = X();
                if (X != null) {
                    rz1.b h2 = X.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                xb3.j();
                if (this.m != null) {
                    this.m.R0(FrameLifeState.INACTIVATED);
                    this.m.release();
                    this.m = null;
                }
                g53.r();
                i03 q = h03.K().q();
                q.e0().j();
                q.N().a();
                u53.x();
                qj2.o().a();
            }
        }
    }

    public final void N(l73 l73Var) {
        hd2 hd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, l73Var) == null) || (hd2Var = this.m) == null) {
            return;
        }
        hd2Var.Q(l73Var);
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
            hd2 hd2Var = this.m;
            return hd2Var == null ? "" : hd2Var.i;
        }
        return (String) invokeV.objValue;
    }

    public hd2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : (hd2) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            hd2 hd2Var = this.m;
            if (hd2Var == null) {
                return -1;
            }
            return hd2Var.k();
        }
        return invokeV.intValue;
    }

    public fl2.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            hd2 hd2Var = this.m;
            if (hd2Var == null) {
                return null;
            }
            return hd2Var.Z();
        }
        return (fl2.a) invokeV.objValue;
    }

    public kf3 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w : (kf3) invokeV.objValue;
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

    public qc3 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.v : (qc3) invokeV.objValue;
    }

    @Nullable
    public rz1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            hd2 hd2Var = this.m;
            if (hd2Var == null) {
                return null;
            }
            return hd2Var.c0();
        }
        return (rz1) invokeV.objValue;
    }

    @UiThread
    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (B) {
                Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            pj2.H().d(this, i2, S());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? !TextUtils.isEmpty(vc4.e().b()) : invokeV.booleanValue;
    }

    @Override // com.repackage.oa3
    public na3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            hd2 hd2Var = this.m;
            if (hd2Var == null) {
                return null;
            }
            return hd2Var.d0();
        }
        return (na3) invokeV.objValue;
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.w == null || isDestroyed()) ? false : true : invokeV.booleanValue;
    }

    @Override // com.repackage.pz2.a
    @NonNull
    public pz2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.x == null) {
                this.x = new pz2(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.x;
        }
        return (pz2) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            f03 f03Var = this.y;
            f03Var.c(new d(this));
            f03Var.f(new c(this), "event_on_still_maintaining");
            f03Var.f(new b(this), "event_on_app_occupied");
            f03Var.f(new a(this), "event_on_app_updated");
            f03Var.f(new p(this), "event_on_app_icon_update");
            f03Var.f(new o(this), "event_on_pkg_maintain_finish");
            f03Var.f(new n(this), "installer_on_progress");
            f03Var.f(new m(this), "event_first_action_launched");
            f03Var.f(new l(this), "event_on_web_mode_launched");
            wl2.a().c();
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
            PMSAppInfo f0 = h03.K().q().W().f0();
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
                ix1.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
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
            ix1.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + h03.K().getAppId());
            boolean z = true;
            z = (!(h03.K().q().E() && h03.K().q().x0()) || TextUtils.equals(str, h03.K().getAppId())) ? false : false;
            ix1.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z);
            if (z) {
                q63.b bVar = new q63.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
                bVar.l(str);
                bVar.h(h03.K().getAppId());
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
            hd2 hd2Var = this.m;
            return hd2Var != null && hd2Var.g0();
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

    public final void k0(ll2 ll2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, ll2Var) == null) && b0() && ll2Var.c(" event_params_installer_progress")) {
            this.w.u(ll2Var.g(" event_params_installer_progress"));
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (vz1.b.a()) {
                q0(bg3.b(t33.e()));
            } else if (isDestroyed()) {
            } else {
                if (h03.K().q().I()) {
                    G0(true);
                } else {
                    h03.M().postDelayed(new e(this), D);
                }
            }
        }
    }

    public final void m0(m03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onAppOccupied: ");
            }
            fl2.a W = h03.K().q().W();
            y0(W.d0(), W.G());
            A0(false, aVar);
            ix1.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        boolean moveTaskToBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            fl2.a S = S();
            boolean z2 = false;
            boolean z3 = S != null && "1230000000000000".equals(S.T());
            oc3 oc3Var = this.q;
            if (oc3Var != null && !z3) {
                oc3Var.v(false);
            }
            if (Z() && !h03.K().q().s0()) {
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
            b73.Y();
            E0();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void n0(ll2 ll2Var) {
        hd2 hd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, ll2Var) == null) && (hd2Var = this.m) != null && hd2Var.f0()) {
            G0("update_tag_by_activity_on_new_intent".equals(ll2Var.n("app_update_tag")));
        }
    }

    public final void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                q0(str);
            } else if (isDestroyed()) {
                ix1.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
            } else if (vz1.b.a() && h03.K().q().z0() && oc4.d()) {
                G0(true);
                c72.U().a1();
            } else if (a0() && !f0()) {
                G0(true);
                r0(vc4.e().b());
            } else if (h03.K().q().z0() && oc4.d()) {
                G0(true);
                c72.U().a1();
            } else {
                String D2 = pj2.o().D();
                if (pj2.a().c() && !ce3.G() && !TextUtils.isEmpty(D2)) {
                    G0(true);
                    r0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", h03.K().getAppId()).build().toString());
                    return;
                }
                bc3 bc3Var = new bc3();
                bc3Var.k(1L);
                bc3Var.i(2109L);
                bc3Var.f("web mode start failed.");
                if (f0()) {
                    fc3.a().f(bc3Var);
                    j73 j73Var = new j73();
                    j73Var.p(bc3Var);
                    j73Var.r(h03.K().q().W());
                    j73Var.q(b73.n(h03.K().k()));
                    j73Var.m(h03.K().getAppId());
                    b73.R(j73Var);
                }
                cl2.e(pj2.c(), bc3Var, 0, "");
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
        ym1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            p0(1);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.wd4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            d72.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(U());
            pj2.G().b();
            dx2.Q().c0();
            boolean z = true;
            this.s = true;
            w63.l(true);
            a73.d(bundle == null ? 0 : 1);
            super.onCreate(bundle);
            H0(FrameLifeState.JUST_CREATED);
            if (hd3.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = hl2.a(intent);
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
            c72.v.g(intent);
            if (B) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            if (!p52.a.c()) {
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
            ix1.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            ix1.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0090);
            if (R() == 0) {
                zd3.c(this);
            }
            c0();
            h03 K = h03.K();
            K.t(this);
            K.u(this.y);
            if (intent != null && (a2 || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                Bundle extras = intent.getExtras();
                if (bundle == null || !h0(extras.getString("mAppId"))) {
                    ix1.k("SwanAppActivity", "updateSwanApp by onCreate");
                    K.l(extras, "update_tag_by_activity_on_create");
                }
            }
            if (K.E() && a2) {
                K.q().W().I0("1250000000000000");
            }
            zd3.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.v = new qc3(this);
            }
            qc3 qc3Var = this.v;
            if (qc3Var != null) {
                qc3Var.u(false);
            }
            qc3 qc3Var2 = this.v;
            if (qc3Var2 != null) {
                qc3Var2.o();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            cd3.k(new i(this), "initOnCreate");
            this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            h03.K().o(this.y);
            ix1.i("SwanApp", "SwanAppActivity onDestroy");
            this.u = null;
            M();
            if (this.n != null) {
                unbindService(this);
            }
            pj2.H().b();
            qc3 qc3Var = this.v;
            if (qc3Var != null) {
                qc3Var.p();
            }
            h03.K().r(this);
            H0(FrameLifeState.INACTIVATED);
            vl2.b0();
            String appId = h03.K().getAppId();
            if (B) {
                nl2 d2 = nl2.d(appId);
                d2.e().c();
                d2.h();
            }
            g63.l(true);
            h03.K().n(new String[0]);
            this.q = null;
            super.onDestroy();
            wl2.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i2, keyEvent)) == null) {
            hd2 hd2Var = this.m;
            if ((hd2Var == null || !hd2Var.r0(i2, keyEvent)) && this.A == null) {
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
            d72.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            ix1.i("SwanApp", "SwanAppActivity onNewIntent");
            setIntent(intent);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            if (B) {
                int flags = intent.getFlags();
                StringBuilder sb = new StringBuilder();
                sb.append("onNewIntent:REORDER_TO_FRONT = ");
                sb.append((flags & 131072) == 131072);
                Log.i("SwanAppActivity", sb.toString());
            }
            qc3 qc3Var = this.v;
            if (qc3Var != null) {
                qc3Var.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                ix1.i("SwanAppActivity", "onNewIntent: start swan web");
                h03.K().q().A0();
            }
            this.s = true;
            w63.l(true);
            h03 K = h03.K();
            K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (K.E() && hl2.a(intent)) {
                K.q().Y().I0("1250000000000000");
            }
            oc3 oc3Var = this.q;
            if (oc3Var != null) {
                oc3Var.z(intent, getTaskId());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            ix1.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            H0(FrameLifeState.JUST_STARTED);
            this.s = false;
            w63.l(false);
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
            qc3 qc3Var = this.v;
            if (qc3Var != null) {
                qc3Var.m();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            ix1.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !h03.K().E()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                h03.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
                if (h03.K().E() && hl2.a(intent)) {
                    h03.K().q().W().I0("1250000000000000");
                }
            }
            j0();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            qc3 qc3Var = this.v;
            if (qc3Var != null) {
                qc3Var.t();
            }
            H0(FrameLifeState.JUST_RESUMED);
            ke3.b().d();
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
            ix1.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.t = false;
            qc3 qc3Var = this.v;
            if (qc3Var != null) {
                qc3Var.e();
            }
            H0(FrameLifeState.JUST_STARTED);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            ix1.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.t = true;
            H0(FrameLifeState.JUST_CREATED);
            if (!Z()) {
                nt2.m();
            }
            cd3.k(new k(this), "tracer");
            pj2.p0().flush(false);
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
            ix1.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (Z()) {
                this.m.l0(i2);
                return;
            }
            HybridUbcFlow m2 = nt2.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            wl2.a().d(false);
            moveTaskToBack(true);
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            G0(true);
            c72.U().b1(str);
        }
    }

    public final void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            ce3.e0(new f(this, str));
        }
    }

    public void s0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            gx2.k(this, bundle);
        }
    }

    public void t0(gd2 gd2Var) {
        hd2 hd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, gd2Var) == null) || (hd2Var = this.m) == null) {
            return;
        }
        hd2Var.I0(gd2Var);
    }

    public void u0() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (view2 = this.A) == null) {
            return;
        }
        sx1.d(this, view2);
        this.A = null;
    }

    public void v0() {
        hd2 hd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (hd2Var = this.m) == null) {
            return;
        }
        hd2Var.K0();
    }

    public final void w0() {
        i03 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (q = h03.K().q()) == null) {
            return;
        }
        String V = q.Y().V();
        nl2 d2 = nl2.d(q.Y().V());
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
                if (rd3.p(this)) {
                    rd3.s(this);
                }
                rc3.e(this);
            }
        }
    }

    public void z0() {
        hd2 hd2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (hd2Var = this.m) == null) {
            return;
        }
        hd2Var.M0();
    }
}
