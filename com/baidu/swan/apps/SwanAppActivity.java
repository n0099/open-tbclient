package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import d.a.n0.a.a2.i;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.h0.p.a;
import d.a.n0.a.h0.u.g;
import d.a.n0.a.j2.c;
import d.a.n0.a.v2.f0;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.p;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.v;
import d.a.n0.a.v2.x0;
import d.a.n0.a.z1.b.c.a;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, a.InterfaceC1003a, d.a.n0.a.n2.h.e, ServiceConnection {
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
    public final d.a.n0.a.a2.b mEventSubscriber;
    public d.a.n0.a.z1.b.c.a mFloatLayer;
    public d.a.n0.a.t0.c mFrame;
    public boolean mIsBackground;
    public boolean mIsFromSchema;
    public FrameLifeState mLifeStatus;
    public d.a.n0.a.w2.e mLoadingView;
    public View mLocalDebugLayer;
    public Messenger mLocalService;
    public OrientationEventListener mOrientationListener;
    public ActivityResultDispatcher mResultDispatcher;
    public String mShowBy;
    public d.a.n0.a.v2.e mSlideHelper;
    @Nullable
    public d.a.n0.a.v2.c mTaskManager;
    public boolean restoreFromSaveInstance;

    /* loaded from: classes3.dex */
    public class a implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10575e;

        public a(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10575e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10575e.showSwanAppStartView(true, aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.n0.a.v2.e1.c<i.a, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10576a;

        public b(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10576a = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.c
        /* renamed from: b */
        public Boolean a(i.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? Boolean.valueOf(!this.f10576a.isDestroyed()) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10577e;

        public c(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10577e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10577e.tryFinishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10578e;

        public d(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10578e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.c1.a.n().d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10579e;

        public e(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10579e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.c1.a.n().k();
                if (d.a.n0.a.r1.l.e.l()) {
                    return;
                }
                p.i(this.f10579e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10580e;

        /* loaded from: classes3.dex */
        public class a extends OrientationEventListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar, Context context, int i2) {
                super(context, i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, context, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    d.a.n0.a.a2.d.g().f43370g = i2;
                }
            }
        }

        public f(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10580e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity swanAppActivity = this.f10580e;
                if (swanAppActivity.mOrientationListener == null) {
                    swanAppActivity.mOrientationListener = new a(this, this.f10580e, 2);
                }
                if (this.f10580e.mResumed) {
                    this.f10580e.mOrientationListener.enable();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10581e;

        public g(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10581e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d.a.n0.a.i2.a.d().l();
                } catch (Exception e2) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e(SwanAppActivity.TAG, "SaveTraceException:", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10582e;

        public h(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10582e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10582e.syncFrameLifeStatus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10583e;

        public i(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10583e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10583e.notifyInstallProgress(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10584e;

        public j(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10584e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10584e.onAppMaintainFinish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10585e;

        public k(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10585e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10585e.updateLoadingView(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10586e;

        public l(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10586e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10586e.onAppUpdated(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements d.a.n0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f10587e;

        public m(SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10587e = swanAppActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f10587e.onAppOccupied(aVar);
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
        DEBUG = d.a.n0.a.k.f45831a;
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
        this.mEventSubscriber = new d.a.n0.a.a2.b();
        this.restoreFromSaveInstance = false;
    }

    private boolean hasLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? (this.mLoadingView == null || isDestroyed()) ? false : true : invokeV.booleanValue;
    }

    private void initEventHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            d.a.n0.a.a2.b bVar = this.mEventSubscriber;
            bVar.b(new b(this));
            bVar.e(new a(this), "event_on_still_maintaining");
            bVar.e(new m(this), "event_on_app_occupied");
            bVar.e(new l(this), "event_on_app_updated");
            bVar.e(new k(this), "event_on_app_icon_update");
            bVar.e(new j(this), "event_on_pkg_maintain_finish");
            bVar.e(new i(this), "installer_on_progress");
            bVar.e(new h(this), "event_first_action_launched");
            d.a.n0.a.g1.g.a().c();
        }
    }

    private boolean isInvalidComponentName(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, intent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            d.a.n0.a.e0.d.h(TAG, "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + d.a.n0.a.a2.d.g().getAppId());
            boolean z = true;
            z = (!(d.a.n0.a.a2.d.g().r().C() && d.a.n0.a.a2.d.g().r().n0()) || TextUtils.equals(str, d.a.n0.a.a2.d.g().getAppId())) ? false : false;
            d.a.n0.a.e0.d.h(TAG, "isInvalidIntentAppId: isInValidIntent=" + z);
            if (z) {
                c.b bVar = new c.b(10017);
                bVar.l(str);
                bVar.h(d.a.n0.a.a2.d.g().getAppId());
                bVar.m();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInstallProgress(d.a.n0.a.f1.e.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, this, cVar) == null) && hasLoadingView() && cVar.c(" event_params_installer_progress")) {
            this.mLoadingView.v(cVar.g(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppMaintainFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || isDestroyed()) {
            return;
        }
        if (d.a.n0.a.a2.d.g().r().e()) {
            updateFrame(true);
        } else {
            d.a.n0.a.a2.d.i().postDelayed(new c(this), DELAY_TIME_FOR_LAUNCH_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppOccupied(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            if (DEBUG) {
                Log.i(TAG, "onAppOccupied: ");
            }
            b.a L = d.a.n0.a.a2.d.g().r().L();
            setWindowFeature(L.d0(), L.G());
            showSwanAppStartView(false, aVar);
            d.a.n0.a.e0.d.g(TAG, "appName: " + L.K() + " appId: " + L.H());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppUpdated(d.a.n0.a.f1.e.f.c cVar) {
        d.a.n0.a.t0.c cVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, cVar) == null) && (cVar2 = this.mFrame) != null && cVar2.U()) {
            updateFrame("update_tag_by_activity_on_new_intent".equals(cVar.n("app_update_tag")));
        }
    }

    private void reportLaunchTrace() {
        d.a.n0.a.a2.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (r = d.a.n0.a.a2.d.g().r()) == null) {
            return;
        }
        String V = r.N().V();
        d.a.n0.a.f1.g.a d2 = d.a.n0.a.f1.g.a.d(r.N().V());
        d2.f("appId: " + r.f43381f + "  launchId: " + V).e();
        d2.h();
    }

    private void setWindowFeature(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65556, this, i2, i3) == null) {
            if (-1 < i2) {
                setRequestedOrientation(i2 == 1 ? 0 : 1);
            }
            if (i3 == 1) {
                if (f0.p(this)) {
                    f0.s(this);
                }
                d.a.n0.a.v2.f.e(this);
            }
        }
    }

    private synchronized boolean swapFrame(d.a.n0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, eVar)) == null) {
            synchronized (this) {
                if (this.mFrame != null) {
                    destroyFrame();
                }
                d.a.n0.a.t0.c a2 = d.a.n0.a.t0.e.a(this, eVar);
                if (a2 == null) {
                    d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(11L);
                    aVar.c("can not buildFramework");
                    d.a.n0.a.f1.d.a.d(this, aVar, eVar.l(), eVar.f43381f);
                    tryFinishAndRemoveTask();
                    return false;
                }
                this.mFrame = a2;
                d dVar = new d(this);
                if (d.a.n0.a.r1.l.e.l()) {
                    d.a.n0.a.r1.k.i.b.e().f(dVar, "updateMobStat");
                } else {
                    q.j(dVar, "updateMobStat");
                }
                setWindowFeature(eVar.L().d0(), eVar.l());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void syncFrameLifeStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            synchronized (this) {
                transFrameLifeStatus(this.mLifeStatus);
            }
        }
    }

    private synchronized void transFrameLifeStatus(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, frameLifeState) == null) {
            synchronized (this) {
                if (this.mFrame != null && !this.mFrame.X()) {
                    this.mFrame.H0(frameLifeState);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFinishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            d.a.n0.a.v2.f.j(this);
        }
    }

    private synchronized void updateFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            synchronized (this) {
                d.a.n0.a.a2.e r = d.a.n0.a.a2.d.g().r();
                if (r.e()) {
                    if (isActivedApp(r.getAppId()) || swapFrame(r)) {
                        this.mFrame.K0(this.mLifeStatus, z);
                        if (DEBUG) {
                            reportLaunchTrace();
                        }
                        if (this.mTaskManager == null && d.a.n0.a.v2.c.j()) {
                            d.a.n0.a.v2.c m2 = d.a.n0.a.v2.c.m();
                            this.mTaskManager = m2;
                            if (!this.restoreFromSaveInstance) {
                                m2.y(getLaunchInfo(), getTaskId());
                            }
                        }
                    }
                }
            }
        }
    }

    private synchronized void updateLifeStatus(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, frameLifeState) == null) {
            synchronized (this) {
                this.mLifeStatus = frameLifeState;
                syncFrameLifeStatus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadingView(d.a.n0.a.f1.e.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, this, cVar) == null) && hasLoadingView()) {
            this.mLoadingView.K(cVar.n("app_icon_url"));
            this.mLoadingView.M(cVar.n("app_name"));
            if (d.a.n0.a.a2.d.g().r().L().G() == 0) {
                this.mLoadingView.N(cVar.i("app_pay_protected"));
            }
        }
    }

    public void addDebugRunningView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mLocalDebugLayer == null) {
            this.mLocalDebugLayer = d.a.n0.a.e0.f.d.e.a(this);
        }
    }

    public boolean checkShowEntryGuideWhenBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            return cVar != null && cVar.D();
        }
        return invokeV.booleanValue;
    }

    public synchronized void destroyFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.mLoadingView != null) {
                    this.mLoadingView.J();
                    if (DEBUG) {
                        Log.i(TAG, "destroyFrame resetLoadingView");
                    }
                }
                d.a.n0.a.w2.e.B();
                d.a.n0.a.w2.e.A(d.a.n0.a.c1.a.b());
                d.a.n0.a.h0.g.g swanAppFragmentManager = getSwanAppFragmentManager();
                if (swanAppFragmentManager != null) {
                    g.b h2 = swanAppFragmentManager.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                d.a.n0.a.p2.c.j();
                if (this.mFrame != null) {
                    this.mFrame.H0(FrameLifeState.INACTIVATED);
                    this.mFrame.y0();
                    this.mFrame = null;
                }
                d.a.n0.a.e2.c.d.q();
                d.a.n0.a.a2.e r = d.a.n0.a.a2.d.g().r();
                r.T().j();
                r.j().a();
                d.a.n0.a.e2.d.a.x();
                d.a.n0.a.c1.b.o().a();
            }
        }
    }

    public final void doUBCEventStatistic(d.a.n0.a.j2.p.f fVar) {
        d.a.n0.a.t0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.F(fVar);
    }

    public void finishLoadingAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = (getLaunchInfo() == null || getLaunchInfo().d0() != 1) ? 2 : 3;
            if (getLoadingView() != null) {
                getLoadingView().H(i2);
            }
        }
    }

    public String getActivedAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            return cVar == null ? "" : cVar.n;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.z1.b.c.a.InterfaceC1003a
    @NonNull
    public d.a.n0.a.z1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mFloatLayer == null) {
                this.mFloatLayer = new d.a.n0.a.z1.b.c.a(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.mFloatLayer;
        }
        return (d.a.n0.a.z1.b.c.a) invokeV.objValue;
    }

    public d.a.n0.a.t0.c getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mFrame : (d.a.n0.a.t0.c) invokeV.objValue;
    }

    public int getFrameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            if (cVar == null) {
                return null;
            }
            return cVar.O();
        }
        return (b.a) invokeV.objValue;
    }

    public d.a.n0.a.w2.e getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mLoadingView : (d.a.n0.a.w2.e) invokeV.objValue;
    }

    public SwanAppProcessInfo getProcessInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? SwanAppProcessInfo.P0 : (SwanAppProcessInfo) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mShowBy : (String) invokeV.objValue;
    }

    public d.a.n0.a.v2.e getSlideHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSlideHelper : (d.a.n0.a.v2.e) invokeV.objValue;
    }

    @Nullable
    public d.a.n0.a.h0.g.g getSwanAppFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            if (cVar == null) {
                return null;
            }
            return cVar.R();
        }
        return (d.a.n0.a.h0.g.g) invokeV.objValue;
    }

    @Override // d.a.n0.a.n2.h.e
    public d.a.n0.a.n2.h.d getTrimMemoryDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            if (cVar == null) {
                return null;
            }
            return cVar.S();
        }
        return (d.a.n0.a.n2.h.d) invokeV.objValue;
    }

    @UiThread
    public void handleSwanAppExit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (DEBUG) {
                Log.i(TAG, "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            d.a.n0.a.c1.a.D().d(this, i2, getLaunchInfo());
        }
    }

    public synchronized boolean hasActivedFrame() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                if (!isDestroyed() && this.mFrame != null) {
                    z = this.mFrame.P().activated();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isActivedApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? !TextUtils.isEmpty(str) && TextUtils.equals(str, getActivedAppId()) : invokeL.booleanValue;
    }

    public boolean isBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mIsBackground : invokeV.booleanValue;
    }

    public boolean isLandScape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            return cVar != null && cVar.V();
        }
        return invokeV.booleanValue;
    }

    public void markShowByStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            b.a launchInfo = getLaunchInfo();
            boolean z2 = false;
            boolean z3 = launchInfo != null && "1230000000000000".equals(launchInfo.T());
            d.a.n0.a.v2.c cVar = this.mTaskManager;
            if (cVar != null && !z3) {
                cVar.v(false);
            }
            if (hasActivedFrame() && !d.a.n0.a.a2.d.g().r().i0()) {
                try {
                    moveTaskToBack = super.moveTaskToBack(z);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    overridePendingTransition(0, d.a.n0.a.a.aiapps_slide_out_to_right_zadjustment_top);
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
            d.a.n0.a.j2.k.Q();
            tryFinishAndRemoveTask();
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048600, this, i2, i3, intent) == null) || getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        d.a.n0.a.p.e.j.c.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            onBackPressed(1);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.n0.o.a.a.f, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(d.a.n0.a.a.aiapps_slide_in_from_right, d.a.n0.a.a.aiapps_hold);
            SwanAppProcessInfo.init(getProcessInfo());
            d.a.n0.a.c1.a.C().b();
            d.a.n0.a.v1.c.e.a.E().Q();
            boolean z = true;
            this.mIsFromSchema = true;
            d.a.n0.a.j2.h.i(true);
            d.a.n0.a.j2.j.c(bundle == null ? 0 : 1);
            super.onCreate(bundle);
            updateLifeStatus(FrameLifeState.JUST_CREATED);
            if (v.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = d.a.n0.a.f1.e.d.a(intent);
            if (a2) {
                intent.putExtra("launch_id", SwanLauncher.h());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle(KEY_SAVE_BUNDLE)) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (isInvalidComponentName(intent)) {
                tryFinishAndRemoveTask();
                return;
            }
            g.t.g(intent);
            if (DEBUG) {
                Log.i(TAG, "onCreate: bindService");
            }
            if (!a.C0762a.c()) {
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
            d.a.n0.a.e0.d.a(TAG, "SwanAppActivity onCreate() savedInstanceState=", bundle);
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onCreate");
            setContentView(d.a.n0.a.g.aiapps_activity);
            n0.c(this);
            initEventHandler();
            d.a.n0.a.a2.d g2 = d.a.n0.a.a2.d.g();
            g2.u(this);
            g2.v(this.mEventSubscriber);
            if (intent != null && (a2 || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                Bundle extras = intent.getExtras();
                if (bundle == null || !isInvalidIntentAppId(extras.getString("mAppId"))) {
                    d.a.n0.a.e0.d.h(TAG, "updateSwanApp by onCreate");
                    g2.m(extras, "update_tag_by_activity_on_create");
                }
            }
            if (g2.C() && a2) {
                g2.r().L().H0("1250000000000000");
            }
            n0.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.mSlideHelper = new d.a.n0.a.v2.e(this);
            }
            d.a.n0.a.v2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.u(false);
            }
            d.a.n0.a.v2.e eVar2 = this.mSlideHelper;
            if (eVar2 != null) {
                eVar2.n();
            }
            q.j(new e(this), "initOnCreate");
            this.restoreFromSaveInstance = (bundle == null || bundle.getInt(KEY_SAVE_TASK_ID) != getTaskId()) ? false : false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            d.a.n0.a.a2.d.g().p(this.mEventSubscriber);
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onDestroy");
            this.mOrientationListener = null;
            destroyFrame();
            if (this.mLocalService != null) {
                unbindService(this);
            }
            d.a.n0.a.c1.a.D().b();
            d.a.n0.a.v2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.p();
            }
            d.a.n0.a.a2.d.g().s(this);
            updateLifeStatus(FrameLifeState.INACTIVATED);
            d.a.n0.a.g1.f.c0();
            String appId = d.a.n0.a.a2.d.g().getAppId();
            if (DEBUG) {
                d.a.n0.a.f1.g.a d2 = d.a.n0.a.f1.g.a.d(appId);
                d2.e().c();
                d2.h();
            }
            d.a.n0.a.a2.d.g().o(new String[0]);
            this.mTaskManager = null;
            super.onDestroy();
            d.a.n0.a.g1.g.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, keyEvent)) == null) {
            d.a.n0.a.t0.c cVar = this.mFrame;
            if ((cVar == null || !cVar.g0(i2, keyEvent)) && this.mLocalDebugLayer == null) {
                return super.onKeyDown(i2, keyEvent);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, intent) == null) {
            super.onNewIntent(intent);
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onNewIntent");
            setIntent(intent);
            overridePendingTransition(d.a.n0.a.a.aiapps_slide_in_from_right, d.a.n0.a.a.aiapps_hold);
            if (DEBUG) {
                int flags = intent.getFlags();
                StringBuilder sb = new StringBuilder();
                sb.append("onNewIntent:REORDER_TO_FRONT = ");
                sb.append((flags & 131072) == 131072);
                Log.i(TAG, sb.toString());
            }
            d.a.n0.a.v2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.r();
            }
            this.mIsFromSchema = true;
            d.a.n0.a.j2.h.i(true);
            d.a.n0.a.a2.d g2 = d.a.n0.a.a2.d.g();
            g2.m(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (g2.C() && d.a.n0.a.f1.e.d.a(intent)) {
                g2.r().N().H0("1250000000000000");
            }
            d.a.n0.a.v2.c cVar = this.mTaskManager;
            if (cVar != null) {
                cVar.z(intent, getTaskId());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            updateLifeStatus(FrameLifeState.JUST_STARTED);
            this.mIsFromSchema = false;
            d.a.n0.a.j2.h.i(false);
            OrientationEventListener orientationEventListener = this.mOrientationListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onPostCreate(bundle);
            d.a.n0.a.v2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.k();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !d.a.n0.a.a2.d.g().C()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                d.a.n0.a.a2.d.g().m(intent.getExtras(), "update_tag_by_activity_on_create");
                if (d.a.n0.a.a2.d.g().C() && d.a.n0.a.f1.e.d.a(intent)) {
                    d.a.n0.a.a2.d.g().r().L().H0("1250000000000000");
                }
            }
            markShowByStatus();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new f(this), "OrientationEventListener", 2);
            d.a.n0.a.v2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.s();
            }
            updateLifeStatus(FrameLifeState.JUST_RESUMED);
            x0.b().d();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048611, this, componentName, iBinder) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048612, this, componentName) == null) {
            if (DEBUG) {
                Log.i(TAG, "onServiceDisconnected: " + componentName);
            }
            this.mLocalService = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.mIsBackground = false;
            d.a.n0.a.v2.e eVar = this.mSlideHelper;
            if (eVar != null) {
                eVar.e();
            }
            updateLifeStatus(FrameLifeState.JUST_STARTED);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.mIsBackground = true;
            updateLifeStatus(FrameLifeState.JUST_CREATED);
            if (!hasActivedFrame()) {
                d.a.n0.a.r1.h.m();
            }
            q.j(new g(this), "tracer");
            d.a.n0.a.c1.a.g0().c(false);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            super.onTrimMemory(i2);
            if (hasActivedFrame()) {
                this.mFrame.u0(i2);
            }
        }
    }

    public void preloadNextSwanAppProcess(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            d.a.n0.a.v1.c.f.b.k(this, bundle);
        }
    }

    public void registerCallback(d.a.n0.a.t0.b bVar) {
        d.a.n0.a.t0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.x0(bVar);
    }

    public void removeDebugRunningView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (view = this.mLocalDebugLayer) == null) {
            return;
        }
        d.a.n0.a.e0.f.d.e.d(this, view);
        this.mLocalDebugLayer = null;
    }

    public void removeLoadingView() {
        d.a.n0.a.t0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.A0();
    }

    public void reset(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, strArr) == null) {
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
        d.a.n0.a.t0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.C0();
    }

    public void showSwanAppStartView(boolean z, @Nullable i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048622, this, z, aVar) == null) {
            if (this.mLoadingView == null) {
                this.mLoadingView = new d.a.n0.a.w2.e(this);
            }
            this.mLoadingView.F(1 == d.a.n0.a.a2.d.g().r().L().G(), z, aVar);
        }
    }

    public void unregisterCallback(d.a.n0.a.t0.b bVar) {
        d.a.n0.a.t0.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, bVar) == null) || (cVar = this.mFrame) == null) {
            return;
        }
        cVar.J0(bVar);
    }

    public void onBackPressed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (hasActivedFrame()) {
                this.mFrame.a0(i2);
                return;
            }
            HybridUbcFlow m2 = d.a.n0.a.r1.h.m();
            if (m2 != null) {
                m2.B("value", QueryResponse.Options.CANCEL);
                m2.A("exitType", String.valueOf(4));
                m2.l();
            }
            d.a.n0.a.g1.g.a().d(false);
            moveTaskToBack(true);
        }
    }
}
