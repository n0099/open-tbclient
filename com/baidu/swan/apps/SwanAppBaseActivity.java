package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.be3;
import com.repackage.lv2;
import com.repackage.oj2;
import com.repackage.rg1;
import com.repackage.w53;
import com.repackage.xw2;
import com.repackage.zk2;
import com.repackage.zw2;
/* loaded from: classes2.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public w53 j;
    public lv2 k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(484428152, "Lcom/baidu/swan/apps/SwanAppBaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(484428152, "Lcom/baidu/swan/apps/SwanAppBaseActivity;");
                return;
            }
        }
        l = rg1.a;
    }

    public SwanAppBaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = null;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.vd4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = be3.c0(this);
            super.onCreate(bundle);
            be3.g(this, c0);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onPostCreate(bundle);
            boolean a = oj2.M().a();
            zk2.e(Boolean.valueOf(a));
            x(a, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.repackage.pd4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) {
            lv2 lv2Var = this.k;
            if (lv2Var != null) {
                lv2Var.f(this, i, strArr, iArr);
            } else {
                z(i, strArr, iArr);
            }
        }
    }

    public w53 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (w53) invokeV.objValue;
    }

    public void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Window window = getWindow();
            if (window == null) {
                if (l) {
                    Log.e("SwanAppBaseActivity", "activity or window is null");
                    return;
                }
                return;
            }
            if (this.j == null) {
                this.j = new w53();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.j.a(viewGroup);
            } else {
                this.j.b(viewGroup);
            }
            if (z2) {
                xw2 e = xw2.e();
                zw2 zw2Var = new zw2(5);
                zw2Var.f(true);
                e.h(zw2Var);
            }
        }
    }

    public void y(int i, @NonNull String[] strArr, lv2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, aVar) == null) {
            lv2 c = lv2.c();
            this.k = c;
            c.requestPermissions(this, i, strArr, aVar);
        }
    }

    public void z(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
