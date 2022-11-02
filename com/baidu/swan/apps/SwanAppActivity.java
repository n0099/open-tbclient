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
import com.baidu.tieba.b43;
import com.baidu.tieba.bg3;
import com.baidu.tieba.bp2;
import com.baidu.tieba.c13;
import com.baidu.tieba.c93;
import com.baidu.tieba.ca3;
import com.baidu.tieba.ch2;
import com.baidu.tieba.d43;
import com.baidu.tieba.dh2;
import com.baidu.tieba.dh3;
import com.baidu.tieba.dp2;
import com.baidu.tieba.e12;
import com.baidu.tieba.e43;
import com.baidu.tieba.ea3;
import com.baidu.tieba.eu2;
import com.baidu.tieba.fb3;
import com.baidu.tieba.fh2;
import com.baidu.tieba.fy2;
import com.baidu.tieba.gi3;
import com.baidu.tieba.gj3;
import com.baidu.tieba.hb3;
import com.baidu.tieba.hp2;
import com.baidu.tieba.i43;
import com.baidu.tieba.je3;
import com.baidu.tieba.jp2;
import com.baidu.tieba.jx2;
import com.baidu.tieba.ke3;
import com.baidu.tieba.kg3;
import com.baidu.tieba.l33;
import com.baidu.tieba.l92;
import com.baidu.tieba.ln2;
import com.baidu.tieba.m32;
import com.baidu.tieba.ma3;
import com.baidu.tieba.mg3;
import com.baidu.tieba.mg4;
import com.baidu.tieba.mn2;
import com.baidu.tieba.n32;
import com.baidu.tieba.ng3;
import com.baidu.tieba.nh3;
import com.baidu.tieba.o12;
import com.baidu.tieba.ok1;
import com.baidu.tieba.p73;
import com.baidu.tieba.q93;
import com.baidu.tieba.r32;
import com.baidu.tieba.rp2;
import com.baidu.tieba.sa3;
import com.baidu.tieba.sp2;
import com.baidu.tieba.tf3;
import com.baidu.tieba.tg4;
import com.baidu.tieba.uq1;
import com.baidu.tieba.vh3;
import com.baidu.tieba.wa3;
import com.baidu.tieba.xa3;
import com.baidu.tieba.xf3;
import com.baidu.tieba.xg3;
import com.baidu.tieba.xi3;
import com.baidu.tieba.xj3;
import com.baidu.tieba.xx2;
import com.baidu.tieba.ya2;
import com.baidu.tieba.yg3;
import com.baidu.tieba.yh3;
import com.baidu.tieba.yo2;
import com.baidu.tieba.z03;
import com.baidu.tieba.za2;
import com.baidu.tieba.zi3;
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
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, l33.a, ke3, ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public static final String C;
    public static final long D;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public dh2 m;
    public Messenger n;
    public FrameLifeState o;
    public ActivityResultDispatcher p;
    @Nullable
    public kg3 q;
    public String r;
    public boolean s;
    public boolean t;
    public OrientationEventListener u;
    public mg3 v;
    public gj3 w;
    public l33 x;
    public final b43 y;
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
                    d43.K().c = i;
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
    public class a implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.n0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.m0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.A0(true, aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements zi3<i43.a, Boolean> {
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
        @Override // com.baidu.tieba.zi3
        /* renamed from: b */
        public Boolean a(i43.a aVar) {
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
                rp2 U = rp2.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    n32 V = U.V();
                    if (V == null) {
                        e12.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        e12.i("SwanAppActivity", "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        e12.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        m32.S3(null);
                        n32.b i = V.i("init");
                        int i2 = n32.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", eu2.d(str, str), true).a();
                        gj3 T = activity.T();
                        if (T != null) {
                            T.F(1);
                        }
                        xf3 xf3Var = new xf3();
                        xf3Var.k(1L);
                        xf3Var.i(2110L);
                        xf3Var.f("host url" + this.a);
                        bg3.a().f(xf3Var);
                        fb3 fb3Var = new fb3();
                        fb3Var.p(xf3Var);
                        fb3Var.r(d43.K().q().W());
                        fb3Var.q(xa3.n(d43.K().k()));
                        fb3Var.m(d43.K().getAppId());
                        xa3.R(fb3Var);
                        return;
                    }
                }
                e12.i("SwanAppActivity", "activity is invalid.");
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
                ln2.o().d();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ca3.d()) {
                ca3.k();
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
                ln2.o().k();
                if (!fy2.h()) {
                    xg3.m(this.a);
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
                    ea3.d().l();
                } catch (Exception e) {
                    if (SwanAppActivity.B) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.o0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes2.dex */
    public class m implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.C0();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.k0(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class o implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) {
                return;
            }
            this.a.l0();
        }
    }

    /* loaded from: classes2.dex */
    public class p implements xi3<i43.a> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(i43.a aVar) {
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
        B = ok1.a;
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
        this.y = new b43();
        this.z = false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            e12.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.t = true;
            H0(FrameLifeState.JUST_CREATED);
            if (!Z()) {
                jx2.m();
            }
            yg3.k(new k(this), "tracer");
            ln2.p0().flush(false);
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

    public void F0(ch2 ch2Var) {
        dh2 dh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ch2Var) == null) && (dh2Var = this.m) != null) {
            dh2Var.T0(ch2Var);
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

    public final void N(hb3 hb3Var) {
        dh2 dh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, hb3Var) == null) && (dh2Var = this.m) != null) {
            dh2Var.Q(hb3Var);
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

    public final void k0(hp2 hp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, hp2Var) == null) && b0() && hp2Var.c(" event_params_installer_progress")) {
            this.w.u(hp2Var.g(" event_params_installer_progress"));
        }
    }

    public final void n0(hp2 hp2Var) {
        dh2 dh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, hp2Var) == null) && (dh2Var = this.m) != null && dh2Var.f0()) {
            G0("update_tag_by_activity_on_new_intent".equals(hp2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onPostCreate(bundle);
            mg3 mg3Var = this.v;
            if (mg3Var != null) {
                mg3Var.n();
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
            ya2.U().b1(str);
        }
    }

    public final void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            yh3.e0(new f(this, str));
        }
    }

    public void s0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            c13.k(this, bundle);
        }
    }

    public void t0(ch2 ch2Var) {
        dh2 dh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, ch2Var) == null) && (dh2Var = this.m) != null) {
            dh2Var.I0(ch2Var);
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
            ng3.j(this);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.A == null) {
            this.A = o12.a(this);
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
            dh2 dh2Var = this.m;
            if (dh2Var == null) {
                return "";
            }
            return dh2Var.i;
        }
        return (String) invokeV.objValue;
    }

    public dh2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.m;
        }
        return (dh2) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            dh2 dh2Var = this.m;
            if (dh2Var == null) {
                return -1;
            }
            return dh2Var.k();
        }
        return invokeV.intValue;
    }

    public bp2.a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            dh2 dh2Var = this.m;
            if (dh2Var == null) {
                return null;
            }
            return dh2Var.Z();
        }
        return (bp2.a) invokeV.objValue;
    }

    public gj3 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.w;
        }
        return (gj3) invokeV.objValue;
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

    public mg3 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.v;
        }
        return (mg3) invokeV.objValue;
    }

    @Nullable
    public n32 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            dh2 dh2Var = this.m;
            if (dh2Var == null) {
                return null;
            }
            return dh2Var.c0();
        }
        return (n32) invokeV.objValue;
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
            return !TextUtils.isEmpty(tg4.e().b());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ke3
    public je3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            dh2 dh2Var = this.m;
            if (dh2Var == null) {
                return null;
            }
            return dh2Var.d0();
        }
        return (je3) invokeV.objValue;
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

    @Override // com.baidu.tieba.l33.a
    @NonNull
    public l33 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.x == null) {
                this.x = new l33(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.x;
        }
        return (l33) invokeV.objValue;
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
            PMSAppInfo f0 = d43.K().q().W().f0();
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
                e12.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
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
            dh2 dh2Var = this.m;
            if (dh2Var != null && dh2Var.g0()) {
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
            e12.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            H0(FrameLifeState.JUST_STARTED);
            this.s = false;
            sa3.l(false);
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
            e12.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.t = false;
            mg3 mg3Var = this.v;
            if (mg3Var != null) {
                mg3Var.e();
            }
            H0(FrameLifeState.JUST_STARTED);
        }
    }

    public void u0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (view2 = this.A) != null) {
            o12.d(this, view2);
            this.A = null;
        }
    }

    public void v0() {
        dh2 dh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (dh2Var = this.m) != null) {
            dh2Var.K0();
        }
    }

    public void z0() {
        dh2 dh2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (dh2Var = this.m) != null) {
            dh2Var.M0();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i2, keyEvent)) == null) {
            dh2 dh2Var = this.m;
            if ((dh2Var != null && dh2Var.r0(i2, keyEvent)) || this.A != null) {
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
                if (nh3.p(this)) {
                    nh3.s(this);
                }
                ng3.e(this);
            }
        }
    }

    public void A0(boolean z, @Nullable i43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, aVar) == null) {
            if (this.w == null) {
                this.w = new gj3(this);
            }
            gj3 gj3Var = this.w;
            boolean z2 = true;
            if (1 != d43.K().q().W().G()) {
                z2 = false;
            }
            gj3Var.E(z2, z, aVar);
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

    public final synchronized boolean B0(e43 e43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e43Var)) == null) {
            synchronized (this) {
                if (this.m != null) {
                    M();
                }
                dh2 a2 = fh2.a(this, e43Var);
                if (a2 == null) {
                    xf3 xf3Var = new xf3();
                    xf3Var.k(5L);
                    xf3Var.i(11L);
                    xf3Var.d("can not buildFramework");
                    yo2.e(this, xf3Var, e43Var.k(), e43Var.b);
                    E0();
                    return false;
                }
                this.m = a2;
                g gVar = new g(this);
                if (fy2.h()) {
                    xx2.e().d(gVar, "updateMobStat", false);
                } else {
                    yg3.k(gVar, "updateMobStat");
                }
                y0(e43Var.W().d0(), e43Var.k());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final synchronized void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            synchronized (this) {
                e43 q = d43.K().q();
                if (!q.I()) {
                    e12.i("SwanAppActivity", "updateFrame: unavailable");
                } else if (!d0(q.getAppId()) && !B0(q)) {
                    e12.i("SwanAppActivity", "updateFrame: swan app id is null.");
                } else {
                    this.m.update(this.o, z);
                    e12.i("SwanAppActivity", "updateFrame: ");
                    if (B) {
                        w0();
                    }
                    if (this.q == null && kg3.j()) {
                        kg3 m2 = kg3.m();
                        this.q = m2;
                        if (!this.z) {
                            m2.y(S(), getTaskId());
                        }
                    }
                }
            }
        }
    }

    public final void I0(hp2 hp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hp2Var) == null) && b0()) {
            this.w.I(hp2Var.n("app_icon_url"));
            this.w.K(hp2Var.n("app_name"));
            if (d43.K().q().W().G() == 0) {
                this.w.L(hp2Var.i("app_pay_protected"));
            }
        }
    }

    public final void m0(i43.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
            if (B) {
                Log.i("SwanAppActivity", "onAppOccupied: ");
            }
            bp2.a W = d43.K().q().W();
            y0(W.d0(), W.G());
            A0(false, aVar);
            e12.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        boolean moveTaskToBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            bp2.a S = S();
            boolean z3 = false;
            if (S != null && "1230000000000000".equals(S.T())) {
                z2 = true;
            } else {
                z2 = false;
            }
            kg3 kg3Var = this.q;
            if (kg3Var != null && !z2) {
                kg3Var.v(false);
            }
            if (Z() && !d43.K().q().s0()) {
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
            xa3.Y();
            E0();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            e12.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (Z()) {
                this.m.l0(i2);
                return;
            }
            HybridUbcFlow m2 = jx2.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            sp2.a().d(false);
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
                gj3.A();
                gj3.z(ln2.c());
                n32 X = X();
                if (X != null) {
                    n32.b h2 = X.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                tf3.j();
                if (this.m != null) {
                    this.m.R0(FrameLifeState.INACTIVATED);
                    this.m.release();
                    this.m = null;
                }
                c93.r();
                e43 q = d43.K().q();
                q.e0().j();
                q.N().a();
                q93.x();
                mn2.o().a();
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            b43 b43Var = this.y;
            b43Var.c(new d(this));
            b43Var.f(new c(this), "event_on_still_maintaining");
            b43Var.f(new b(this), "event_on_app_occupied");
            b43Var.f(new a(this), "event_on_app_updated");
            b43Var.f(new p(this), "event_on_app_icon_update");
            b43Var.f(new o(this), "event_on_pkg_maintain_finish");
            b43Var.f(new n(this), "installer_on_progress");
            b43Var.f(new m(this), "event_first_action_launched");
            b43Var.f(new l(this), "event_on_web_mode_launched");
            sp2.a().c();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            d43.K().o(this.y);
            e12.i("SwanApp", "SwanAppActivity onDestroy");
            this.u = null;
            M();
            if (this.n != null) {
                unbindService(this);
            }
            ln2.H().b();
            mg3 mg3Var = this.v;
            if (mg3Var != null) {
                mg3Var.p();
            }
            d43.K().r(this);
            H0(FrameLifeState.INACTIVATED);
            rp2.b0();
            String appId = d43.K().getAppId();
            if (B) {
                jp2 d2 = jp2.d(appId);
                d2.e().c();
                d2.h();
            }
            ca3.l(true);
            d43.K().n(new String[0]);
            this.q = null;
            super.onDestroy();
            sp2.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            e12.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !d43.K().E()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                d43.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
                if (d43.K().E() && dp2.a(intent)) {
                    d43.K().q().W().I0("1250000000000000");
                }
            }
            j0();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            mg3 mg3Var = this.v;
            if (mg3Var != null) {
                mg3Var.t();
            }
            H0(FrameLifeState.JUST_RESUMED);
            gi3.b().d();
        }
    }

    @UiThread
    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (B) {
                Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            ln2.H().d(this, i2, S());
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
            e12.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + d43.K().getAppId());
            boolean z2 = true;
            if (d43.K().q().E() && d43.K().q().x0()) {
                z = true;
            } else {
                z = false;
            }
            z2 = (!z || TextUtils.equals(str, d43.K().getAppId())) ? false : false;
            e12.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
            if (z2) {
                ma3.b bVar = new ma3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
                bVar.l(str);
                bVar.h(d43.K().getAppId());
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
            za2.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            e12.i("SwanApp", "SwanAppActivity onNewIntent");
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
            mg3 mg3Var = this.v;
            if (mg3Var != null) {
                mg3Var.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                e12.i("SwanAppActivity", "onNewIntent: start swan web");
                d43.K().q().A0();
            }
            this.s = true;
            sa3.l(true);
            d43 K = d43.K();
            K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (K.E() && dp2.a(intent)) {
                K.q().Y().I0("1250000000000000");
            }
            kg3 kg3Var = this.q;
            if (kg3Var != null) {
                kg3Var.z(intent, getTaskId());
            }
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (r32.b.a()) {
                q0(xj3.b(p73.e()));
            } else if (!isDestroyed()) {
                if (d43.K().q().I()) {
                    G0(true);
                } else {
                    d43.M().postDelayed(new e(this), D);
                }
            }
        }
    }

    public final void w0() {
        e43 q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (q = d43.K().q()) != null) {
            String V = q.Y().V();
            jp2 d2 = jp2.d(q.Y().V());
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
                e12.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
            } else if (r32.b.a() && d43.K().q().z0() && mg4.d()) {
                G0(true);
                ya2.U().a1();
            } else if (a0() && !f0()) {
                G0(true);
                r0(tg4.e().b());
            } else if (d43.K().q().z0() && mg4.d()) {
                G0(true);
                ya2.U().a1();
            } else {
                String D2 = ln2.o().D();
                if (ln2.a().c() && !yh3.G() && !TextUtils.isEmpty(D2)) {
                    G0(true);
                    r0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", d43.K().getAppId()).build().toString());
                    return;
                }
                xf3 xf3Var = new xf3();
                xf3Var.k(1L);
                xf3Var.i(2109L);
                xf3Var.f("web mode start failed.");
                if (f0()) {
                    bg3.a().f(xf3Var);
                    fb3 fb3Var = new fb3();
                    fb3Var.p(xf3Var);
                    fb3Var.r(d43.K().q().W());
                    fb3Var.q(xa3.n(d43.K().k()));
                    fb3Var.m(d43.K().getAppId());
                    xa3.R(fb3Var);
                }
                yo2.e(ln2.c(), xf3Var, 0, "");
                E0();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.uh4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            za2.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(U());
            ln2.G().b();
            z03.Q().c0();
            boolean z2 = true;
            this.s = true;
            sa3.l(true);
            if (bundle == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            wa3.d(i2);
            super.onCreate(bundle);
            H0(FrameLifeState.JUST_CREATED);
            if (dh3.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = dp2.a(intent);
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
            ya2.v.g(intent);
            if (B) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            if (!l92.a.c()) {
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
            e12.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            e12.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0094);
            if (R() == 0) {
                vh3.c(this);
            }
            c0();
            d43 K = d43.K();
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
                    e12.k("SwanAppActivity", "updateSwanApp by onCreate");
                    K.l(extras, "update_tag_by_activity_on_create");
                }
            }
            if (K.E() && a2) {
                K.q().W().I0("1250000000000000");
            }
            vh3.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.v = new mg3(this);
            }
            mg3 mg3Var = this.v;
            if (mg3Var != null) {
                mg3Var.u(false);
            }
            mg3 mg3Var2 = this.v;
            if (mg3Var2 != null) {
                mg3Var2.o();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            yg3.k(new i(this), "initOnCreate");
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
        uq1.a().b().b().onActivityResult(this, i2, i3, intent);
    }
}
