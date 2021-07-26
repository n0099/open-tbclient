package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h;
import d.a.o0.a.k;
import d.a.o0.a.v2.v;
import d.a.o0.a.z1.b.b.h;
import d.a.o0.a.z1.b.f.e;
/* loaded from: classes3.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SwanAppAdbDebugActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdbDebugActivity f10937e;

        public a(SwanAppAdbDebugActivity swanAppAdbDebugActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdbDebugActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10937e = swanAppAdbDebugActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f10937e.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f10938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdbDebugActivity f10939f;

        public b(SwanAppAdbDebugActivity swanAppAdbDebugActivity, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdbDebugActivity, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10939f = swanAppAdbDebugActivity;
            this.f10938e = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f10938e.setClass(this.f10939f, SwanAppLauncherActivity.class);
                this.f10939f.startActivity(this.f10938e);
                this.f10939f.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1410172890, "Lcom/baidu/swan/apps/console/debugger/adbdebug/SwanAppAdbDebugActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1410172890, "Lcom/baidu/swan/apps/console/debugger/adbdebug/SwanAppAdbDebugActivity;");
                return;
            }
        }
        DEBUG = k.f46335a;
    }

    public SwanAppAdbDebugActivity() {
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

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (DEBUG) {
                Log.d(TAG, "ADB Debug onCreate");
            }
            if (v.a(this)) {
                return;
            }
            Intent intent = getIntent();
            if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
                e.f(this, h.aiapps_adb_debug_lack_path).F();
                if (DEBUG) {
                    Log.d(TAG, "ADB Debug lack of app path");
                }
                finish();
            }
            h.a aVar = new h.a(this);
            aVar.V(getString(d.a.o0.a.h.aiapps_adb_debug));
            aVar.x(getString(d.a.o0.a.h.aiapps_adb_debug_alert));
            aVar.n(new d.a.o0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.o0.a.h.aiapps_confirm, new b(this, intent));
            aVar.B(d.a.o0.a.h.swanapp_close, new a(this));
            aVar.X();
        }
    }
}
