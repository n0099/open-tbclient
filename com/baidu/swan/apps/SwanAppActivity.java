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
import c.a.n0.a.d2.c;
import c.a.n0.a.p2.f0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.v;
import c.a.n0.a.p2.y0;
import c.a.n0.a.s1.b.c.a;
import c.a.n0.a.t1.i;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.g.k;
import c.a.n0.a.x.p.a;
import c.a.n0.a.x.u.g;
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
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, a.InterfaceC0451a, c.a.n0.a.h2.g.c, ServiceConnection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACK_TYPE_SLIDE = 3;
    public static final int BACK_TYPE_SYSTEM = 1;
    public static final int BACK_TYPE_TITLE_BAR = 2;
    public static final String COMPONENT_NAME;
    public static final boolean DEBUG;
    public static final long DELAY_TIME_FOR_LAUNCH_FAIL;
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int FROM_BACK_PRESS = 2;
    public static final int FROM_LOADING_BACK_PRESS = 4;
    public static final int FROM_LOADING_TITLE_BAR = 3;
    public static final int FROM_TITLE_BAR = 1;
    public static final String KEY_SAVE_BUNDLE = "swan_key_save_bundle";
    public static final String KEY_SAVE_TASK_ID = "swan_key_save_task_id";
    public static final int REQUEST_CODE_RESULT_DISPATCHER = 1;
    public static final String SHOW_BY_SCHEMA = "schema";
    public static final String SHOW_BY_SYS = "sys";
    public static final String SHOW_BY_USER = "user";
    public static final String TAG = "SwanAppActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.t1.b mEventSubscriber;
    public c.a.n0.a.s1.b.c.a mFloatLayer;
    public c.a.n0.a.j0.c mFrame;
    public boolean mIsBackground;
    public boolean mIsFromSchema;
    public FrameLifeState mLifeStatus;
    public c.a.n0.a.q2.e mLoadingView;
    public View mLocalDebugLayer;
    public Messenger mLocalService;
    public OrientationEventListener mOrientationListener;
    public ActivityResultDispatcher mResultDispatcher;
    public String mShowBy;
    public c.a.n0.a.p2.e mSlideHelper;
    @Nullable
    public c.a.n0.a.p2.c mTaskManager;
    public boolean restoreFromSaveInstance;

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppUpdated(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppOccupied(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.showSwanAppStartView(true, aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.n0.a.p2.g1.e<i.a, Boolean> {
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
        @Override // c.a.n0.a.p2.g1.e
        /* renamed from: b */
        public Boolean a(i.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? Boolean.valueOf(!this.a.isDestroyed()) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.tryFinishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f28715b;

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
            this.f28715b = swanAppActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    c.a.n0.a.x.g.g V = U.V();
                    if (V == null) {
                        c.a.n0.a.u.d.i(SwanAppActivity.TAG, "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        c.a.n0.a.u.d.i(SwanAppActivity.TAG, "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        c.a.n0.a.u.d.i(SwanAppActivity.TAG, "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        c.a.n0.a.x.g.f.Q3(null);
                        g.b i = V.i("init");
                        int i2 = c.a.n0.a.x.g.g.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", c.a.n0.a.c1.b.d(str, str), true).a();
                        c.a.n0.a.q2.e loadingView = activity.getLoadingView();
                        if (loadingView != null) {
                            loadingView.F(1);
                        }
                        c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                        aVar.k(1L);
                        aVar.i(2110L);
                        aVar.f("host url" + this.a);
                        c.a.n0.a.k2.e.a().f(aVar);
                        c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                        dVar.p(aVar);
                        dVar.r(c.a.n0.a.t1.d.J().r().V());
                        dVar.q(c.a.n0.a.d2.n.n(c.a.n0.a.t1.d.J().l()));
                        dVar.m(c.a.n0.a.t1.d.J().getAppId());
                        c.a.n0.a.d2.n.R(dVar);
                        return;
                    }
                }
                c.a.n0.a.u.d.i(SwanAppActivity.TAG, "activity is invalid.");
            }
        }
    }

    /* loaded from: classes4.dex */
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
                c.a.n0.a.s0.a.o().d();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.n0.a.b2.c.d()) {
                c.a.n0.a.b2.c.k();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                c.a.n0.a.s0.a.o().k();
                if (c.a.n0.a.k1.l.e.h()) {
                    return;
                }
                c.a.n0.a.p2.p.m(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;

        /* loaded from: classes4.dex */
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
                    c.a.n0.a.t1.d.J().f6334c = i;
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
                if (swanAppActivity.mOrientationListener == null) {
                    swanAppActivity.mOrientationListener = new a(this, this.a, 2);
                }
                if (this.a.mResumed) {
                    this.a.mOrientationListener.enable();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    c.a.n0.a.c2.a.d().l();
                } catch (Exception e2) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e(SwanAppActivity.TAG, "SaveTraceException:", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppWebModeStart(aVar.n("property_launch_url"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.syncFrameLifeStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.notifyInstallProgress(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppMaintainFinish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements c.a.n0.a.p2.g1.c<i.a> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.updateLoadingView(aVar);
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
        DEBUG = c.a.n0.a.a.a;
        COMPONENT_NAME = SwanAppActivity.class.getName();
        DELAY_TIME_FOR_LAUNCH_FAIL = TimeUnit.SECONDS.toMillis(1L);
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
        this.mLifeStatus = FrameLifeState.INACTIVATED;
        this.mShowBy = "sys";
        this.mIsFromSchema = false;
        this.mEventSubscriber = new c.a.n0.a.t1.b();
        this.restoreFromSaveInstance = false;
    }

    private boolean hasHostFailUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? !TextUtils.isEmpty(c.a.n0.q.j.j.b.e().b()) : invokeV.booleanValue;
    }

    private boolean hasLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (this.mLoadingView == null || isDestroyed()) ? false : true : invokeV.booleanValue;
    }

    private void initEventHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            c.a.n0.a.t1.b bVar = this.mEventSubscriber;
            bVar.b(new d(this));
            bVar.e(new c(this), "event_on_still_maintaining");
            bVar.e(new b(this), "event_on_app_occupied");
            bVar.e(new a(this), "event_on_app_updated");
            bVar.e(new p(this), "event_on_app_icon_update");
            bVar.e(new o(this), "event_on_pkg_maintain_finish");
            bVar.e(new n(this), "installer_on_progress");
            bVar.e(new m(this), "event_first_action_launched");
            bVar.e(new l(this), "event_on_web_mode_launched");
            c.a.n0.a.w0.g.a().c();
        }
    }

    private boolean isForceWebMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            PMSAppInfo f0 = c.a.n0.a.t1.d.J().r().V().f0();
            return f0 != null && f0.appStatus == 6;
        }
        return invokeV.booleanValue;
    }

    private boolean isInvalidComponentName(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, intent)) == null) {
            if (intent != null) {
                ComponentName component = intent.getComponent();
                return (component == null || component.getClassName().startsWith(COMPONENT_NAME)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean isInvalidIntentAppId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            c.a.n0.a.u.d.k(TAG, "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + c.a.n0.a.t1.d.J().getAppId());
            boolean z = true;
            z = (!(c.a.n0.a.t1.d.J().r().D() && c.a.n0.a.t1.d.J().r().w0()) || TextUtils.equals(str, c.a.n0.a.t1.d.J().getAppId())) ? false : false;
            c.a.n0.a.u.d.k(TAG, "isInvalidIntentAppId: isInValidIntent=" + z);
            if (z) {
                c.b bVar = new c.b(10017);
                bVar.l(str);
                bVar.h(c.a.n0.a.t1.d.J().getAppId());
                bVar.m();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInstallProgress(c.a.n0.a.v0.e.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, cVar) == null) && hasLoadingView() && cVar.c(" event_params_installer_progress")) {
            this.mLoadingView.u(cVar.g(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppMaintainFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (k.b.a()) {
                onWebModeUrlStart(c.a.n0.a.r2.c.b(c.a.n0.a.v1.f.o0.c.e()));
            } else if (isDestroyed()) {
            } else {
                if (c.a.n0.a.t1.d.J().r().H()) {
                    updateFrame(true);
                } else {
                    c.a.n0.a.t1.d.L().postDelayed(new e(this), DELAY_TIME_FOR_LAUNCH_FAIL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppOccupied(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, aVar) == null) {
            if (DEBUG) {
                Log.i(TAG, "onAppOccupied: ");
            }
            b.a V = c.a.n0.a.t1.d.J().r().V();
            setWindowFeature(V.d0(), V.G());
            showSwanAppStartView(false, aVar);
            c.a.n0.a.u.d.i(TAG, "appName: " + V.K() + " appId: " + V.H());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppUpdated(c.a.n0.a.v0.e.f.c cVar) {
        c.a.n0.a.j0.c cVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, cVar) == null) && (cVar2 = this.mFrame) != null && cVar2.f0()) {
            updateFrame("update_tag_by_activity_on_new_intent".equals(cVar.n("app_update_tag")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppWebModeStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                onWebModeUrlStart(str);
            } else if (isDestroyed()) {
                c.a.n0.a.u.d.i(TAG, "onAppWebModeStart: swan activity isDestroyed.");
            } else if (k.b.a() && c.a.n0.a.t1.d.J().r().y0() && c.a.n0.q.j.i.p.d()) {
                updateFrame(true);
                c.a.n0.a.x.u.g.U().a1();
            } else if (hasHostFailUrl() && !isForceWebMode()) {
                updateFrame(true);
                openWebViewFragment(c.a.n0.q.j.j.b.e().b());
            } else if (c.a.n0.a.t1.d.J().r().y0() && c.a.n0.q.j.i.p.d()) {
                updateFrame(true);
                c.a.n0.a.x.u.g.U().a1();
            } else {
                String D = c.a.n0.a.s0.a.o().D();
                if (c.a.n0.a.s0.a.a().c() && !q0.G() && !TextUtils.isEmpty(D)) {
                    updateFrame(true);
                    openWebViewFragment(Uri.parse(D).buildUpon().appendQueryParameter("appkey", c.a.n0.a.t1.d.J().getAppId()).build().toString());
                    return;
                }
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(1L);
                aVar.i(2109L);
                aVar.f("web mode start failed.");
                if (isForceWebMode()) {
                    c.a.n0.a.k2.e.a().f(aVar);
                    c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                    dVar.p(aVar);
                    dVar.r(c.a.n0.a.t1.d.J().r().V());
                    dVar.q(c.a.n0.a.d2.n.n(c.a.n0.a.t1.d.J().l()));
                    dVar.m(c.a.n0.a.t1.d.J().getAppId());
                    c.a.n0.a.d2.n.R(dVar);
                }
                c.a.n0.a.v0.d.a.e(c.a.n0.a.s0.a.c(), aVar, 0, "");
                tryFinishAndRemoveTask();
            }
        }
    }

    private void openWebViewFragment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            q0.e0(new f(this, str));
        }
    }

    private void reportLaunchTrace() {
        c.a.n0.a.t1.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (r = c.a.n0.a.t1.d.J().r()) == null) {
            return;
        }
        String V = r.X().V();
        c.a.n0.a.v0.g.a d2 = c.a.n0.a.v0.g.a.d(r.X().V());
        d2.f("appId: " + r.f6344b + "  launchId: " + V).e();
        d2.h();
    }

    private void setWindowFeature(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65561, this, i2, i3) == null) {
            if (-1 < i2) {
                setRequestedOrientation(i2 == 1 ? 0 : 1);
            }
            if (i3 == 1) {
                if (f0.p(this)) {
                    f0.s(this);
                }
                c.a.n0.a.p2.f.e(this);
            }
        }
    }

    private synchronized boolean swapFrame(c.a.n0.a.t1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, eVar)) == null) {
            synchronized (this) {
                if (this.mFrame != null) {
                    destroyFrame();
                }
                c.a.n0.a.j0.c a2 = c.a.n0.a.j0.e.a(this, eVar);
                if (a2 == null) {
                    c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                    aVar.k(5L);
                    aVar.i(11L);
                    aVar.d("can not buildFramework");
                    c.a.n0.a.v0.d.a.e(this, aVar, eVar.l(), eVar.f6344b);
                    tryFinishAndRemoveTask();
                    return false;
                }
                this.mFrame = a2;
                g gVar = new g(this);
                if (c.a.n0.a.k1.l.e.h()) {
                    c.a.n0.a.k1.k.i.c.e().d(gVar, "updateMobStat", false);
                } else {
                    q.k(gVar, "updateMobStat");
                }
                setWindowFeature(eVar.V().d0(), eVar.l());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void syncFrameLifeStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            synchronized (this) {
                transFrameLifeStatus(this.mLifeStatus);
            }
        }
    }

    private synchronized void transFrameLifeStatus(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, frameLifeState) == null) {
            synchronized (this) {
                if (this.mFrame != null && !this.mFrame.i0()) {
                    this.mFrame.R0(frameLifeState);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFinishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            c.a.n0.a.p2.f.j(this);
        }
    }

    private synchronized void updateFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, this, z) == null) {
            synchronized (this) {
                c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
                if (!r.H()) {
                    c.a.n0.a.u.d.i(TAG, "updateFrame: unavailable");
                } else if (!isActivedApp(r.getAppId()) && !swapFrame(r)) {
                    c.a.n0.a.u.d.i(TAG, "updateFrame: swan app id is null.");
                } else {
                    this.mFrame.update(this.mLifeStatus, z);
                    c.a.n0.a.u.d.i(TAG, "updateFrame: ");
                    if (DEBUG) {
                        reportLaunchTrace();
                    }
                    if (this.mTaskManager == null && c.a.n0.a.p2.c.j()) {
                        c.a.n0.a.p2.c m2 = c.a.n0.a.p2.c.m();
                        this.mTaskManager = m2;
                        if (!this.restoreFromSaveInstance) {
                            m2.y(getLaunchInfo(), getTaskId());
                        }
                    }
                }
            }
        }
    }

    private synchronized void updateLifeStatus(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, frameLifeState) == null) {
            synchronized (this) {
                this.mLifeStatus = frameLifeState;
                syncFrameLifeStatus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadingView(c.a.n0.a.v0.e.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65568, this, cVar) == null) && hasLoadingView()) {
            this.mLoadingView.I(cVar.n("app_icon_url"));
            this.mLoadingView.K(cVar.n("app_name"));
            if (c.a.n0.a.t1.d.J().r().V().G() == 0) {
                this.mLoadingView.L(cVar.i("app_pay_protected"));
            }
        }
    }

    public void addDebugRunningView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mLocalDebugLayer == null) {
            this.mLocalDebugLayer = c.a.n0.a.u.f.d.e.a(this);
        }
    }

    public boolean checkShowEntryGuideWhenBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            return cVar != null && cVar.O();
        }
        return invokeV.booleanValue;
    }

    public synchronized void destroyFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.mLoadingView != null) {
                    this.mLoadingView.H();
                    if (DEBUG) {
                        Log.i(TAG, "destroyFrame resetLoadingView");
                    }
                }
                c.a.n0.a.q2.e.A();
                c.a.n0.a.q2.e.z(c.a.n0.a.s0.a.c());
                c.a.n0.a.x.g.g swanAppFragmentManager = getSwanAppFragmentManager();
                if (swanAppFragmentManager != null) {
                    g.b h2 = swanAppFragmentManager.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                c.a.n0.a.j2.c.j();
                if (this.mFrame != null) {
                    this.mFrame.R0(FrameLifeState.INACTIVATED);
                    this.mFrame.release();
                    this.mFrame = null;
                }
                c.a.n0.a.x1.c.d.r();
                c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
                r.d0().j();
                r.M().a();
                c.a.n0.a.x1.d.a.x();
                c.a.n0.a.s0.b.o().a();
            }
        }
    }

    public final void doUBCEventStatistic(c.a.n0.a.d2.s.f fVar) {
        c.a.n0.a.j0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.Q(fVar);
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.finish();
            if (DEBUG) {
                c.a.n0.a.u.d.i(TAG, Log.getStackTraceString(new Throwable("call finish!")));
            }
        }
    }

    public void finishLoadingAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = (getLaunchInfo() == null || getLaunchInfo().d0() != 1) ? 2 : 3;
            if (getLoadingView() != null) {
                getLoadingView().F(i2);
            }
        }
    }

    public String getActivedAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            return cVar == null ? "" : cVar.j;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.s1.b.c.a.InterfaceC0451a
    @NonNull
    public c.a.n0.a.s1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mFloatLayer == null) {
                this.mFloatLayer = new c.a.n0.a.s1.b.c.a(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.mFloatLayer;
        }
        return (c.a.n0.a.s1.b.c.a) invokeV.objValue;
    }

    public c.a.n0.a.j0.c getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFrame : (c.a.n0.a.j0.c) invokeV.objValue;
    }

    public int getFrameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            if (cVar == null) {
                return -1;
            }
            return cVar.l();
        }
        return invokeV.intValue;
    }

    public b.a getLaunchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            if (cVar == null) {
                return null;
            }
            return cVar.Z();
        }
        return (b.a) invokeV.objValue;
    }

    public c.a.n0.a.q2.e getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLoadingView : (c.a.n0.a.q2.e) invokeV.objValue;
    }

    public SwanAppProcessInfo getProcessInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? SwanAppProcessInfo.P0 : (SwanAppProcessInfo) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mResultDispatcher == null) {
                this.mResultDispatcher = new ActivityResultDispatcher(this, 1);
            }
            return this.mResultDispatcher;
        }
        return (ActivityResultDispatcher) invokeV.objValue;
    }

    public String getShowBy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mShowBy : (String) invokeV.objValue;
    }

    public c.a.n0.a.p2.e getSlideHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSlideHelper : (c.a.n0.a.p2.e) invokeV.objValue;
    }

    @Nullable
    public c.a.n0.a.x.g.g getSwanAppFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            if (cVar == null) {
                return null;
            }
            return cVar.c0();
        }
        return (c.a.n0.a.x.g.g) invokeV.objValue;
    }

    @Override // c.a.n0.a.h2.g.c
    public c.a.n0.a.h2.g.b getTrimMemoryDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            if (cVar == null) {
                return null;
            }
            return cVar.d0();
        }
        return (c.a.n0.a.h2.g.b) invokeV.objValue;
    }

    @UiThread
    public void handleSwanAppExit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (DEBUG) {
                Log.i(TAG, "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            c.a.n0.a.s0.a.H().d(this, i2, getLaunchInfo());
        }
    }

    public synchronized boolean hasActivedFrame() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                if (!isDestroyed() && this.mFrame != null) {
                    z = this.mFrame.a0().activated();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isActivedApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? !TextUtils.isEmpty(str) && TextUtils.equals(str, getActivedAppId()) : invokeL.booleanValue;
    }

    public boolean isBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mIsBackground : invokeV.booleanValue;
    }

    public boolean isLandScape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            return cVar != null && cVar.g0();
        }
        return invokeV.booleanValue;
    }

    public void markShowByStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.mIsFromSchema) {
                this.mShowBy = "schema";
            } else {
                this.mShowBy = "user";
            }
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        boolean moveTaskToBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            b.a launchInfo = getLaunchInfo();
            boolean z2 = false;
            boolean z3 = launchInfo != null && "1230000000000000".equals(launchInfo.T());
            c.a.n0.a.p2.c cVar = this.mTaskManager;
            if (cVar != null && !z3) {
                cVar.v(false);
            }
            if (hasActivedFrame() && !c.a.n0.a.t1.d.J().r().r0()) {
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
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    return z2;
                }
            }
            c.a.n0.a.d2.n.Y();
            tryFinishAndRemoveTask();
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048601, this, i2, i3, intent) == null) || getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        c.a.n0.a.f.e.j.c.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            onBackPressed(1);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, c.a.n0.r.a.a.g, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            c.a.n0.a.x.u.h.a.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(getProcessInfo());
            c.a.n0.a.s0.a.G().b();
            c.a.n0.a.o1.c.e.a.P().b0();
            boolean z = true;
            this.mIsFromSchema = true;
            c.a.n0.a.d2.i.l(true);
            c.a.n0.a.d2.m.d(bundle == null ? 0 : 1);
            super.onCreate(bundle);
            updateLifeStatus(FrameLifeState.JUST_CREATED);
            if (v.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = c.a.n0.a.v0.e.d.a(intent);
            if (a2) {
                intent.putExtra("launch_id", SwanLauncher.h());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle(KEY_SAVE_BUNDLE)) != null) {
                ClassLoader classLoader = getClass().getClassLoader();
                bundle2.setClassLoader(classLoader);
                intent.setExtrasClassLoader(classLoader);
                intent.putExtras(bundle2);
            }
            if (isInvalidComponentName(intent)) {
                tryFinishAndRemoveTask();
                return;
            }
            g.v.g(intent);
            if (DEBUG) {
                Log.i(TAG, "onCreate: bindService");
            }
            if (!a.C0568a.c()) {
                try {
                    bindService(new Intent(this, getProcessInfo().service), this, 1);
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            if (Build.VERSION.SDK_INT == 26) {
                TranslucentUtils.convertFromTranslucent(this);
            }
            c.a.n0.a.u.d.b(TAG, "SwanAppActivity onCreate() savedInstanceState=", bundle);
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0097);
            if (getFrameType() == 0) {
                n0.c(this);
            }
            initEventHandler();
            c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
            J.u(this);
            J.v(this.mEventSubscriber);
            if (intent != null && (a2 || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                Bundle extras = intent.getExtras();
                if (bundle == null || !isInvalidIntentAppId(extras.getString("mAppId"))) {
                    c.a.n0.a.u.d.k(TAG, "updateSwanApp by onCreate");
                    J.m(extras, "update_tag_by_activity_on_create");
                }
            }
            if (J.D() && a2) {
                J.r().V().I0("1250000000000000");
            }
            n0.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.mSlideHelper = new c.a.n0.a.p2.e(this);
            }
            c.a.n0.a.p2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.u(false);
            }
            c.a.n0.a.p2.e eVar2 = this.mSlideHelper;
            if (eVar2 != null) {
                eVar2.n();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            q.k(new i(this), "initOnCreate");
            this.restoreFromSaveInstance = (bundle == null || bundle.getInt(KEY_SAVE_TASK_ID) != getTaskId()) ? false : false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            c.a.n0.a.t1.d.J().p(this.mEventSubscriber);
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onDestroy");
            this.mOrientationListener = null;
            destroyFrame();
            if (this.mLocalService != null) {
                unbindService(this);
            }
            c.a.n0.a.s0.a.H().b();
            c.a.n0.a.p2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.p();
            }
            c.a.n0.a.t1.d.J().s(this);
            updateLifeStatus(FrameLifeState.INACTIVATED);
            c.a.n0.a.w0.f.b0();
            String appId = c.a.n0.a.t1.d.J().getAppId();
            if (DEBUG) {
                c.a.n0.a.v0.g.a d2 = c.a.n0.a.v0.g.a.d(appId);
                d2.e().c();
                d2.h();
            }
            c.a.n0.a.b2.c.l(true);
            c.a.n0.a.t1.d.J().o(new String[0]);
            this.mTaskManager = null;
            super.onDestroy();
            c.a.n0.a.w0.g.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            c.a.n0.a.j0.c cVar = this.mFrame;
            if ((cVar == null || !cVar.r0(i2, keyEvent)) && this.mLocalDebugLayer == null) {
                return super.onKeyDown(i2, keyEvent);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, intent) == null) {
            super.onNewIntent(intent);
            c.a.n0.a.x.u.h.a.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onNewIntent");
            setIntent(intent);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            if (DEBUG) {
                int flags = intent.getFlags();
                StringBuilder sb = new StringBuilder();
                sb.append("onNewIntent:REORDER_TO_FRONT = ");
                sb.append((flags & 131072) == 131072);
                Log.i(TAG, sb.toString());
            }
            c.a.n0.a.p2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                c.a.n0.a.u.d.i(TAG, "onNewIntent: start swan web");
                c.a.n0.a.t1.d.J().r().z0();
            }
            this.mIsFromSchema = true;
            c.a.n0.a.d2.i.l(true);
            c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
            J.m(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (J.D() && c.a.n0.a.v0.e.d.a(intent)) {
                J.r().X().I0("1250000000000000");
            }
            c.a.n0.a.p2.c cVar = this.mTaskManager;
            if (cVar != null) {
                cVar.z(intent, getTaskId());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            updateLifeStatus(FrameLifeState.JUST_STARTED);
            this.mIsFromSchema = false;
            c.a.n0.a.d2.i.l(false);
            OrientationEventListener orientationEventListener = this.mOrientationListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onPostCreate(bundle);
            c.a.n0.a.p2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.k();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !c.a.n0.a.t1.d.J().D()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                c.a.n0.a.t1.d.J().m(intent.getExtras(), "update_tag_by_activity_on_create");
                if (c.a.n0.a.t1.d.J().D() && c.a.n0.a.v0.e.d.a(intent)) {
                    c.a.n0.a.t1.d.J().r().V().I0("1250000000000000");
                }
            }
            markShowByStatus();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            c.a.n0.a.p2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.s();
            }
            updateLifeStatus(FrameLifeState.JUST_RESUMED);
            y0.b().d();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle.get("android:support:fragments") != null) {
                bundle.remove("android:support:fragments");
            }
            Intent intent = getIntent();
            if (intent != null) {
                bundle.putBundle(KEY_SAVE_BUNDLE, intent.getExtras());
                bundle.putInt(KEY_SAVE_TASK_ID, getTaskId());
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, componentName, iBinder) == null) {
            if (DEBUG) {
                Log.i(TAG, "onServiceConnected: " + componentName);
            }
            if (iBinder != null) {
                this.mLocalService = new Messenger(iBinder);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, componentName) == null) {
            if (DEBUG) {
                Log.i(TAG, "onServiceDisconnected: " + componentName);
            }
            this.mLocalService = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.mIsBackground = false;
            c.a.n0.a.p2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.d();
            }
            updateLifeStatus(FrameLifeState.JUST_STARTED);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            c.a.n0.a.u.d.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.mIsBackground = true;
            updateLifeStatus(FrameLifeState.JUST_CREATED);
            if (!hasActivedFrame()) {
                c.a.n0.a.k1.h.m();
            }
            q.k(new k(this), "tracer");
            c.a.n0.a.s0.a.p0().flush(false);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            super.onTrimMemory(i2);
            if (hasActivedFrame()) {
                this.mFrame.F0(i2);
            }
        }
    }

    public void onWebModeUrlStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            updateFrame(true);
            c.a.n0.a.x.u.g.U().b1(str);
        }
    }

    public void preloadNextSwanAppProcess(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            c.a.n0.a.o1.c.f.b.k(this, bundle);
        }
    }

    public void registerCallback(c.a.n0.a.j0.b bVar) {
        c.a.n0.a.j0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.I0(bVar);
    }

    public void removeDebugRunningView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (view = this.mLocalDebugLayer) == null) {
            return;
        }
        c.a.n0.a.u.f.d.e.d(this, view);
        this.mLocalDebugLayer = null;
    }

    public void removeLoadingView() {
        c.a.n0.a.j0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.K0();
    }

    public void reset(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, strArr) == null) {
            destroyFrame();
            HashSet newHashSet = strArr == null ? Sets.newHashSet() : Sets.newHashSet(strArr);
            if (newHashSet.contains("flag_finish_activity")) {
                if (newHashSet.contains("flag_remove_task")) {
                    tryFinishAndRemoveTask();
                } else {
                    finish();
                }
            }
        }
    }

    public void showLoadingView() {
        c.a.n0.a.j0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.M0();
    }

    public void showSwanAppStartView(boolean z, @Nullable i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048624, this, z, aVar) == null) {
            if (this.mLoadingView == null) {
                this.mLoadingView = new c.a.n0.a.q2.e(this);
            }
            this.mLoadingView.E(1 == c.a.n0.a.t1.d.J().r().V().G(), z, aVar);
        }
    }

    public void unregisterCallback(c.a.n0.a.j0.b bVar) {
        c.a.n0.a.j0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, bVar) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.T0(bVar);
    }

    public void onBackPressed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            c.a.n0.a.u.d.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (hasActivedFrame()) {
                this.mFrame.l0(i2);
                return;
            }
            HybridUbcFlow m2 = c.a.n0.a.k1.h.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            c.a.n0.a.w0.g.a().d(false);
            moveTaskToBack(true);
        }
    }
}
