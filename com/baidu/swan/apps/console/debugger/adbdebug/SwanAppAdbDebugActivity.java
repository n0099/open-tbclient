package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.v;
import c.a.n0.a.s1.b.b.h;
import c.a.n0.a.s1.b.f.e;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SwanAppAdbDebugActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAdbDebugActivity a;

        public a(SwanAppAdbDebugActivity swanAppAdbDebugActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdbDebugActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAdbDebugActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAdbDebugActivity f28809b;

        public b(SwanAppAdbDebugActivity swanAppAdbDebugActivity, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAdbDebugActivity, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28809b = swanAppAdbDebugActivity;
            this.a = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.setClass(this.f28809b, SwanAppLauncherActivity.class);
                this.f28809b.startActivity(this.a);
                this.f28809b.finish();
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
        DEBUG = c.a.n0.a.a.a;
    }

    public SwanAppAdbDebugActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            Intent intent = getIntent();
            if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
                e.f(this, R.string.obfuscated_res_0x7f0f00f7).G();
                if (DEBUG) {
                    Log.d(TAG, "ADB Debug lack of app path");
                }
                finish();
            }
            h.a aVar = new h.a(this);
            aVar.V(getString(R.string.obfuscated_res_0x7f0f00f5));
            aVar.x(getString(R.string.obfuscated_res_0x7f0f00f6));
            aVar.n(new c.a.n0.a.q2.h.a());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f010f, new b(this, intent));
            aVar.B(R.string.obfuscated_res_0x7f0f1272, new a(this));
            aVar.X();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
