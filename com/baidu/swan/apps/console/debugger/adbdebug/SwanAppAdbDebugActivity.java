package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.repackage.af3;
import com.repackage.cg1;
import com.repackage.kz2;
import com.repackage.rc3;
import com.repackage.wy2;
/* loaded from: classes2.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ SwanAppAdbDebugActivity b;

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
            this.b = swanAppAdbDebugActivity;
            this.a = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.setClass(this.b, SwanAppLauncherActivity.class);
                this.b.startActivity(this.a);
                this.b.finish();
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
        a = cg1.a;
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
            if (a) {
                Log.d("SwanAppAdbDebugActivity", "ADB Debug onCreate");
            }
            if (rc3.a(this)) {
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            Intent intent = getIntent();
            if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
                kz2.f(this, R.string.obfuscated_res_0x7f0f00fb).G();
                if (a) {
                    Log.d("SwanAppAdbDebugActivity", "ADB Debug lack of app path");
                }
                finish();
            }
            wy2.a aVar = new wy2.a(this);
            aVar.V(getString(R.string.obfuscated_res_0x7f0f00f9));
            aVar.x(getString(R.string.obfuscated_res_0x7f0f00fa));
            aVar.n(new af3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0113, new b(this, intent));
            aVar.B(R.string.obfuscated_res_0x7f0f12b9, new a(this));
            aVar.X();
            LogUtil.logActivity(this, "onCreate");
        }
    }
}
