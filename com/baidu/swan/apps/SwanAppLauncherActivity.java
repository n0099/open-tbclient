package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.s1.d;
import d.a.o0.a.v2.n0;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.v;
@Autowired
/* loaded from: classes3.dex */
public class SwanAppLauncherActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String SWAN_APP_LAUNCH_ACTION = "com.baidu.searchbox.action.aiapps.LAUNCH";
    public static final String TAG = "SwanAppLauncherActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public Object mPermissionDialog;

    /* loaded from: classes3.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppLauncherActivity f10614a;

        public a(SwanAppLauncherActivity swanAppLauncherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLauncherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10614a = swanAppLauncherActivity;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLauncherActivity f10615e;

        public b(SwanAppLauncherActivity swanAppLauncherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLauncherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10615e = swanAppLauncherActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10615e.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-279784695, "Lcom/baidu/swan/apps/SwanAppLauncherActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-279784695, "Lcom/baidu/swan/apps/SwanAppLauncherActivity;");
                return;
            }
        }
        DEBUG = k.f46335a;
    }

    public SwanAppLauncherActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            SwanLauncher.j().m(getIntent().getExtras());
            d.a.o0.a.a2.d.i().post(new b(this));
        }
    }

    @Deprecated
    public static void startSwanApp(Context context, d.a.o0.a.f1.e.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, bVar, str) == null) {
            SwanLauncher.j().n(bVar, null);
        }
    }

    @Inject(force = false)
    public d getPermissionDialogIOC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.f47814a : (d) invokeV.objValue;
    }

    @Override // android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int Z = q0.Z(this);
            super.onCreate(bundle);
            q0.g(this, Z);
            n0.b(this);
            if (DEBUG) {
                Log.d(TAG, MissionEvent.MESSAGE_CREATE);
            }
            if (v.a(this)) {
                return;
            }
            String stringExtra = getIntent() != null ? getIntent().getStringExtra("mAppId") : "";
            getPermissionDialogIOC().a(stringExtra);
            if (getPermissionDialogIOC().b()) {
                this.mPermissionDialog = getPermissionDialogIOC().c(this, stringExtra, new a(this), true);
            } else {
                handleIntent();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            getPermissionDialogIOC().f(this, this.mPermissionDialog);
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048579, this, i2, strArr, iArr) == null) || getPermissionDialogIOC().e(this, i2, strArr, iArr, this.mPermissionDialog)) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            getPermissionDialogIOC().d(this, this.mPermissionDialog);
        }
    }
}
