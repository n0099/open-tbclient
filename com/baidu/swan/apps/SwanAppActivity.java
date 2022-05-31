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
import com.repackage.a63;
import com.repackage.ab3;
import com.repackage.ac3;
import com.repackage.ae3;
import com.repackage.af3;
import com.repackage.at2;
import com.repackage.b62;
import com.repackage.bc3;
import com.repackage.bd3;
import com.repackage.bk2;
import com.repackage.c62;
import com.repackage.ce3;
import com.repackage.cw2;
import com.repackage.eb3;
import com.repackage.ek2;
import com.repackage.ez2;
import com.repackage.f43;
import com.repackage.f53;
import com.repackage.fc2;
import com.repackage.fw2;
import com.repackage.gc2;
import com.repackage.gc3;
import com.repackage.gk2;
import com.repackage.gz2;
import com.repackage.h53;
import com.repackage.hp2;
import com.repackage.hw1;
import com.repackage.hz2;
import com.repackage.i63;
import com.repackage.ic2;
import com.repackage.it2;
import com.repackage.jd3;
import com.repackage.je3;
import com.repackage.k63;
import com.repackage.kk2;
import com.repackage.lz2;
import com.repackage.m93;
import com.repackage.mk2;
import com.repackage.ms2;
import com.repackage.n93;
import com.repackage.nb3;
import com.repackage.nb4;
import com.repackage.o42;
import com.repackage.oi2;
import com.repackage.oy2;
import com.repackage.p53;
import com.repackage.pb3;
import com.repackage.pi2;
import com.repackage.py1;
import com.repackage.qb3;
import com.repackage.qc3;
import com.repackage.qy1;
import com.repackage.rf1;
import com.repackage.rw1;
import com.repackage.s23;
import com.repackage.t43;
import com.repackage.ub4;
import com.repackage.uk2;
import com.repackage.uy1;
import com.repackage.v53;
import com.repackage.vk2;
import com.repackage.wa3;
import com.repackage.xl1;
import com.repackage.yc3;
import com.repackage.z53;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, oy2.a, n93, ServiceConnection {
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
    public final ez2 mEventSubscriber;
    public oy2 mFloatLayer;
    public gc2 mFrame;
    public boolean mIsBackground;
    public boolean mIsFromSchema;
    public FrameLifeState mLifeStatus;
    public je3 mLoadingView;
    public View mLocalDebugLayer;
    public Messenger mLocalService;
    public OrientationEventListener mOrientationListener;
    public ActivityResultDispatcher mResultDispatcher;
    public String mShowBy;
    public pb3 mSlideHelper;
    @Nullable
    public nb3 mTaskManager;
    public boolean restoreFromSaveInstance;

    /* loaded from: classes2.dex */
    public class a implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppUpdated(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppOccupied(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.showSwanAppStartView(true, aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ce3<lz2.a, Boolean> {
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
        @Override // com.repackage.ce3
        /* renamed from: b */
        public Boolean a(lz2.a aVar) {
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
                this.a.tryFinishAndRemoveTask();
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
                uk2 U = uk2.U();
                SwanAppActivity activity = U.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    qy1 V = U.V();
                    if (V == null) {
                        hw1.i(SwanAppActivity.TAG, "doWebViewStart: fragment manager is null.");
                        return;
                    } else if (TextUtils.isEmpty(this.a)) {
                        hw1.i(SwanAppActivity.TAG, "doWebViewStart:  url is null.");
                        return;
                    } else if (V == null) {
                        hw1.i(SwanAppActivity.TAG, "pushWebViewFragment: fragment manager is null.");
                        return;
                    } else {
                        py1.R3(null);
                        qy1.b i = V.i("init");
                        int i2 = qy1.i;
                        i.n(i2, i2);
                        i.f();
                        String str = this.a;
                        i.l("default_webview", hp2.d(str, str), true).a();
                        je3 loadingView = activity.getLoadingView();
                        if (loadingView != null) {
                            loadingView.F(1);
                        }
                        ab3 ab3Var = new ab3();
                        ab3Var.k(1L);
                        ab3Var.i(2110L);
                        ab3Var.f("host url" + this.a);
                        eb3.a().f(ab3Var);
                        i63 i63Var = new i63();
                        i63Var.p(ab3Var);
                        i63Var.r(gz2.J().r().V());
                        i63Var.q(a63.n(gz2.J().l()));
                        i63Var.m(gz2.J().getAppId());
                        a63.R(i63Var);
                        return;
                    }
                }
                hw1.i(SwanAppActivity.TAG, "activity is invalid.");
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
                oi2.o().d();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f53.d()) {
                f53.k();
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
                oi2.o().k();
                if (it2.h()) {
                    return;
                }
                ac3.m(this.a);
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
                    gz2.J().c = i;
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
                    h53.d().l();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e(SwanAppActivity.TAG, "SaveTraceException:", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppWebModeStart(aVar.n("property_launch_url"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.syncFrameLifeStatus();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.notifyInstallProgress(aVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.onAppMaintainFinish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements ae3<lz2.a> {
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
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
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
        DEBUG = rf1.a;
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
        this.mEventSubscriber = new ez2();
        this.restoreFromSaveInstance = false;
    }

    private boolean hasHostFailUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? !TextUtils.isEmpty(ub4.e().b()) : invokeV.booleanValue;
    }

    private boolean hasLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (this.mLoadingView == null || isDestroyed()) ? false : true : invokeV.booleanValue;
    }

    private void initEventHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            ez2 ez2Var = this.mEventSubscriber;
            ez2Var.b(new d(this));
            ez2Var.e(new c(this), "event_on_still_maintaining");
            ez2Var.e(new b(this), "event_on_app_occupied");
            ez2Var.e(new a(this), "event_on_app_updated");
            ez2Var.e(new p(this), "event_on_app_icon_update");
            ez2Var.e(new o(this), "event_on_pkg_maintain_finish");
            ez2Var.e(new n(this), "installer_on_progress");
            ez2Var.e(new m(this), "event_first_action_launched");
            ez2Var.e(new l(this), "event_on_web_mode_launched");
            vk2.a().c();
        }
    }

    private boolean isForceWebMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            PMSAppInfo f0 = gz2.J().r().V().f0();
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
            hw1.k(TAG, "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + gz2.J().getAppId());
            boolean z = true;
            z = (!(gz2.J().r().D() && gz2.J().r().w0()) || TextUtils.equals(str, gz2.J().getAppId())) ? false : false;
            hw1.k(TAG, "isInvalidIntentAppId: isInValidIntent=" + z);
            if (z) {
                p53.b bVar = new p53.b(10017);
                bVar.l(str);
                bVar.h(gz2.J().getAppId());
                bVar.m();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInstallProgress(kk2 kk2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, kk2Var) == null) && hasLoadingView() && kk2Var.c(" event_params_installer_progress")) {
            this.mLoadingView.u(kk2Var.g(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppMaintainFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (uy1.b.a()) {
                onWebModeUrlStart(af3.b(s23.e()));
            } else if (isDestroyed()) {
            } else {
                if (gz2.J().r().H()) {
                    updateFrame(true);
                } else {
                    gz2.L().postDelayed(new e(this), DELAY_TIME_FOR_LAUNCH_FAIL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppOccupied(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, aVar) == null) {
            if (DEBUG) {
                Log.i(TAG, "onAppOccupied: ");
            }
            ek2.a V = gz2.J().r().V();
            setWindowFeature(V.d0(), V.G());
            showSwanAppStartView(false, aVar);
            hw1.i(TAG, "appName: " + V.K() + " appId: " + V.H());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppUpdated(kk2 kk2Var) {
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, kk2Var) == null) && (gc2Var = this.mFrame) != null && gc2Var.f0()) {
            updateFrame("update_tag_by_activity_on_new_intent".equals(kk2Var.n("app_update_tag")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppWebModeStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                onWebModeUrlStart(str);
            } else if (isDestroyed()) {
                hw1.i(TAG, "onAppWebModeStart: swan activity isDestroyed.");
            } else if (uy1.b.a() && gz2.J().r().y0() && nb4.d()) {
                updateFrame(true);
                b62.U().a1();
            } else if (hasHostFailUrl() && !isForceWebMode()) {
                updateFrame(true);
                openWebViewFragment(ub4.e().b());
            } else if (gz2.J().r().y0() && nb4.d()) {
                updateFrame(true);
                b62.U().a1();
            } else {
                String D = oi2.o().D();
                if (oi2.a().c() && !bd3.G() && !TextUtils.isEmpty(D)) {
                    updateFrame(true);
                    openWebViewFragment(Uri.parse(D).buildUpon().appendQueryParameter("appkey", gz2.J().getAppId()).build().toString());
                    return;
                }
                ab3 ab3Var = new ab3();
                ab3Var.k(1L);
                ab3Var.i(2109L);
                ab3Var.f("web mode start failed.");
                if (isForceWebMode()) {
                    eb3.a().f(ab3Var);
                    i63 i63Var = new i63();
                    i63Var.p(ab3Var);
                    i63Var.r(gz2.J().r().V());
                    i63Var.q(a63.n(gz2.J().l()));
                    i63Var.m(gz2.J().getAppId());
                    a63.R(i63Var);
                }
                bk2.e(oi2.c(), ab3Var, 0, "");
                tryFinishAndRemoveTask();
            }
        }
    }

    private void openWebViewFragment(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            bd3.e0(new f(this, str));
        }
    }

    private void reportLaunchTrace() {
        hz2 r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (r = gz2.J().r()) == null) {
            return;
        }
        String V = r.X().V();
        mk2 d2 = mk2.d(r.X().V());
        d2.f("appId: " + r.b + "  launchId: " + V).e();
        d2.h();
    }

    private void setWindowFeature(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65561, this, i2, i3) == null) {
            if (-1 < i2) {
                setRequestedOrientation(i2 == 1 ? 0 : 1);
            }
            if (i3 == 1) {
                if (qc3.p(this)) {
                    qc3.s(this);
                }
                qb3.e(this);
            }
        }
    }

    private synchronized boolean swapFrame(hz2 hz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, hz2Var)) == null) {
            synchronized (this) {
                if (this.mFrame != null) {
                    destroyFrame();
                }
                gc2 a2 = ic2.a(this, hz2Var);
                if (a2 == null) {
                    ab3 ab3Var = new ab3();
                    ab3Var.k(5L);
                    ab3Var.i(11L);
                    ab3Var.d("can not buildFramework");
                    bk2.e(this, ab3Var, hz2Var.l(), hz2Var.b);
                    tryFinishAndRemoveTask();
                    return false;
                }
                this.mFrame = a2;
                g gVar = new g(this);
                if (it2.h()) {
                    at2.e().d(gVar, "updateMobStat", false);
                } else {
                    bc3.k(gVar, "updateMobStat");
                }
                setWindowFeature(hz2Var.V().d0(), hz2Var.l());
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
            qb3.j(this);
        }
    }

    private synchronized void updateFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, this, z) == null) {
            synchronized (this) {
                hz2 r = gz2.J().r();
                if (!r.H()) {
                    hw1.i(TAG, "updateFrame: unavailable");
                } else if (!isActivedApp(r.getAppId()) && !swapFrame(r)) {
                    hw1.i(TAG, "updateFrame: swan app id is null.");
                } else {
                    this.mFrame.update(this.mLifeStatus, z);
                    hw1.i(TAG, "updateFrame: ");
                    if (DEBUG) {
                        reportLaunchTrace();
                    }
                    if (this.mTaskManager == null && nb3.j()) {
                        nb3 m2 = nb3.m();
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
    public void updateLoadingView(kk2 kk2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65568, this, kk2Var) == null) && hasLoadingView()) {
            this.mLoadingView.I(kk2Var.n("app_icon_url"));
            this.mLoadingView.K(kk2Var.n("app_name"));
            if (gz2.J().r().V().G() == 0) {
                this.mLoadingView.L(kk2Var.i("app_pay_protected"));
            }
        }
    }

    public void addDebugRunningView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mLocalDebugLayer == null) {
            this.mLocalDebugLayer = rw1.a(this);
        }
    }

    public boolean checkShowEntryGuideWhenBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            gc2 gc2Var = this.mFrame;
            return gc2Var != null && gc2Var.O();
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
                je3.A();
                je3.z(oi2.c());
                qy1 swanAppFragmentManager = getSwanAppFragmentManager();
                if (swanAppFragmentManager != null) {
                    qy1.b h2 = swanAppFragmentManager.h();
                    h2.n(0, 0);
                    h2.f();
                    h2.b();
                }
                wa3.j();
                if (this.mFrame != null) {
                    this.mFrame.R0(FrameLifeState.INACTIVATED);
                    this.mFrame.release();
                    this.mFrame = null;
                }
                f43.r();
                hz2 r = gz2.J().r();
                r.d0().j();
                r.M().a();
                t43.x();
                pi2.o().a();
            }
        }
    }

    public final void doUBCEventStatistic(k63 k63Var) {
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, k63Var) == null) || (gc2Var = this.mFrame) == null) {
            return;
        }
        gc2Var.Q(k63Var);
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.finish();
            if (DEBUG) {
                hw1.i(TAG, Log.getStackTraceString(new Throwable("call finish!")));
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
            gc2 gc2Var = this.mFrame;
            return gc2Var == null ? "" : gc2Var.j;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.oy2.a
    @NonNull
    public oy2 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mFloatLayer == null) {
                this.mFloatLayer = new oy2(this, (FrameLayout) findViewById(16908290), 0);
            }
            return this.mFloatLayer;
        }
        return (oy2) invokeV.objValue;
    }

    public gc2 getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFrame : (gc2) invokeV.objValue;
    }

    public int getFrameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            gc2 gc2Var = this.mFrame;
            if (gc2Var == null) {
                return -1;
            }
            return gc2Var.l();
        }
        return invokeV.intValue;
    }

    public ek2.a getLaunchInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            gc2 gc2Var = this.mFrame;
            if (gc2Var == null) {
                return null;
            }
            return gc2Var.Z();
        }
        return (ek2.a) invokeV.objValue;
    }

    public je3 getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLoadingView : (je3) invokeV.objValue;
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

    public pb3 getSlideHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSlideHelper : (pb3) invokeV.objValue;
    }

    @Nullable
    public qy1 getSwanAppFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            gc2 gc2Var = this.mFrame;
            if (gc2Var == null) {
                return null;
            }
            return gc2Var.c0();
        }
        return (qy1) invokeV.objValue;
    }

    @Override // com.repackage.n93
    public m93 getTrimMemoryDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            gc2 gc2Var = this.mFrame;
            if (gc2Var == null) {
                return null;
            }
            return gc2Var.d0();
        }
        return (m93) invokeV.objValue;
    }

    @UiThread
    public void handleSwanAppExit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (DEBUG) {
                Log.i(TAG, "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
            }
            oi2.H().d(this, i2, getLaunchInfo());
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
            gc2 gc2Var = this.mFrame;
            return gc2Var != null && gc2Var.g0();
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
            ek2.a launchInfo = getLaunchInfo();
            boolean z2 = false;
            boolean z3 = launchInfo != null && "1230000000000000".equals(launchInfo.T());
            nb3 nb3Var = this.mTaskManager;
            if (nb3Var != null && !z3) {
                nb3Var.v(false);
            }
            if (hasActivedFrame() && !gz2.J().r().r0()) {
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
            a63.Y();
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
        xl1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            onBackPressed(1);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.vc4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            c62.e();
            long currentTimeMillis = System.currentTimeMillis();
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            SwanAppProcessInfo.init(getProcessInfo());
            oi2.G().b();
            cw2.P().b0();
            boolean z = true;
            this.mIsFromSchema = true;
            v53.l(true);
            z53.d(bundle == null ? 0 : 1);
            super.onCreate(bundle);
            updateLifeStatus(FrameLifeState.JUST_CREATED);
            if (gc3.a(this)) {
                return;
            }
            Intent intent = getIntent();
            boolean a2 = gk2.a(intent);
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
            b62.v.g(intent);
            if (DEBUG) {
                Log.i(TAG, "onCreate: bindService");
            }
            if (!o42.a.c()) {
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
            hw1.b(TAG, "SwanAppActivity onCreate() savedInstanceState=", bundle);
            hw1.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(R.layout.obfuscated_res_0x7f0d0091);
            if (getFrameType() == 0) {
                yc3.c(this);
            }
            initEventHandler();
            gz2 J = gz2.J();
            J.u(this);
            J.v(this.mEventSubscriber);
            if (intent != null && (a2 || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                Bundle extras = intent.getExtras();
                if (bundle == null || !isInvalidIntentAppId(extras.getString("mAppId"))) {
                    hw1.k(TAG, "updateSwanApp by onCreate");
                    J.m(extras, "update_tag_by_activity_on_create");
                }
            }
            if (J.D() && a2) {
                J.r().V().I0("1250000000000000");
            }
            yc3.b(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.mSlideHelper = new pb3(this);
            }
            pb3 pb3Var = this.mSlideHelper;
            if (pb3Var != null) {
                pb3Var.u(false);
            }
            pb3 pb3Var2 = this.mSlideHelper;
            if (pb3Var2 != null) {
                pb3Var2.n();
            }
            ExecutorUtilsExt.postOnSerial(new h(this), "小程序稳定性数据采集");
            bc3.k(new i(this), "initOnCreate");
            this.restoreFromSaveInstance = (bundle == null || bundle.getInt(KEY_SAVE_TASK_ID) != getTaskId()) ? false : false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            gz2.J().p(this.mEventSubscriber);
            hw1.i("SwanApp", "SwanAppActivity onDestroy");
            this.mOrientationListener = null;
            destroyFrame();
            if (this.mLocalService != null) {
                unbindService(this);
            }
            oi2.H().b();
            pb3 pb3Var = this.mSlideHelper;
            if (pb3Var != null) {
                pb3Var.p();
            }
            gz2.J().s(this);
            updateLifeStatus(FrameLifeState.INACTIVATED);
            uk2.b0();
            String appId = gz2.J().getAppId();
            if (DEBUG) {
                mk2 d2 = mk2.d(appId);
                d2.e().c();
                d2.h();
            }
            f53.l(true);
            gz2.J().o(new String[0]);
            this.mTaskManager = null;
            super.onDestroy();
            vk2.a().e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            gc2 gc2Var = this.mFrame;
            if ((gc2Var == null || !gc2Var.r0(i2, keyEvent)) && this.mLocalDebugLayer == null) {
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
            c62.e();
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            hw1.i("SwanApp", "SwanAppActivity onNewIntent");
            setIntent(intent);
            overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
            if (DEBUG) {
                int flags = intent.getFlags();
                StringBuilder sb = new StringBuilder();
                sb.append("onNewIntent:REORDER_TO_FRONT = ");
                sb.append((flags & 131072) == 131072);
                Log.i(TAG, sb.toString());
            }
            pb3 pb3Var = this.mSlideHelper;
            if (pb3Var != null) {
                pb3Var.r();
            }
            if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
                hw1.i(TAG, "onNewIntent: start swan web");
                gz2.J().r().z0();
            }
            this.mIsFromSchema = true;
            v53.l(true);
            gz2 J = gz2.J();
            J.m(intent.getExtras(), "update_tag_by_activity_on_new_intent");
            if (J.D() && gk2.a(intent)) {
                J.r().X().I0("1250000000000000");
            }
            nb3 nb3Var = this.mTaskManager;
            if (nb3Var != null) {
                nb3Var.z(intent, getTaskId());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            hw1.i("SwanApp", "SwanAppActivity onPause");
            super.onPause();
            updateLifeStatus(FrameLifeState.JUST_STARTED);
            this.mIsFromSchema = false;
            v53.l(false);
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
            pb3 pb3Var = this.mSlideHelper;
            if (pb3Var != null) {
                pb3Var.k();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            hw1.i("SwanApp", "SwanAppActivity onResume");
            Intent intent = getIntent();
            if (intent != null && !gz2.J().D()) {
                intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
                gz2.J().m(intent.getExtras(), "update_tag_by_activity_on_create");
                if (gz2.J().D() && gk2.a(intent)) {
                    gz2.J().r().V().I0("1250000000000000");
                }
            }
            markShowByStatus();
            super.onResume();
            ExecutorUtilsExt.postOnElastic(new j(this), "OrientationEventListener", 2);
            pb3 pb3Var = this.mSlideHelper;
            if (pb3Var != null) {
                pb3Var.s();
            }
            updateLifeStatus(FrameLifeState.JUST_RESUMED);
            jd3.b().d();
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
            hw1.i("SwanApp", "SwanAppActivity onStart");
            super.onStart();
            this.mIsBackground = false;
            pb3 pb3Var = this.mSlideHelper;
            if (pb3Var != null) {
                pb3Var.d();
            }
            updateLifeStatus(FrameLifeState.JUST_STARTED);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            hw1.i("SwanApp", "SwanAppActivity onStop");
            super.onStop();
            this.mIsBackground = true;
            updateLifeStatus(FrameLifeState.JUST_CREATED);
            if (!hasActivedFrame()) {
                ms2.m();
            }
            bc3.k(new k(this), "tracer");
            oi2.p0().flush(false);
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
            b62.U().b1(str);
        }
    }

    public void preloadNextSwanAppProcess(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            fw2.k(this, bundle);
        }
    }

    public void registerCallback(fc2 fc2Var) {
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, fc2Var) == null) || (gc2Var = this.mFrame) == null) {
            return;
        }
        gc2Var.I0(fc2Var);
    }

    public void removeDebugRunningView() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (view2 = this.mLocalDebugLayer) == null) {
            return;
        }
        rw1.d(this, view2);
        this.mLocalDebugLayer = null;
    }

    public void removeLoadingView() {
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (gc2Var = this.mFrame) == null) {
            return;
        }
        gc2Var.K0();
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
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (gc2Var = this.mFrame) == null) {
            return;
        }
        gc2Var.M0();
    }

    public void showSwanAppStartView(boolean z, @Nullable lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048624, this, z, aVar) == null) {
            if (this.mLoadingView == null) {
                this.mLoadingView = new je3(this);
            }
            this.mLoadingView.E(1 == gz2.J().r().V().G(), z, aVar);
        }
    }

    public void unregisterCallback(fc2 fc2Var) {
        gc2 gc2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, fc2Var) == null) || (gc2Var = this.mFrame) == null) {
            return;
        }
        gc2Var.T0(fc2Var);
    }

    public void onBackPressed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            hw1.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
            if (hasActivedFrame()) {
                this.mFrame.l0(i2);
                return;
            }
            HybridUbcFlow m2 = ms2.m();
            if (m2 != null) {
                m2.E("value", "cancel");
                m2.D("exitType", String.valueOf(4));
                m2.n();
            }
            vk2.a().d(false);
            moveTaskToBack(true);
        }
    }
}
