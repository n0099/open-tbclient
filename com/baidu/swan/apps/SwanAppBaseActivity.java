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
import com.repackage.dw2;
import com.repackage.gk2;
import com.repackage.jh1;
import com.repackage.o63;
import com.repackage.px2;
import com.repackage.rl2;
import com.repackage.rx2;
import com.repackage.te3;
/* loaded from: classes2.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public o63 j;
    public dw2 k;

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
        l = jh1.a;
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

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.ne4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = te3.c0(this);
            super.onCreate(bundle);
            te3.g(this, c0);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onPostCreate(bundle);
            boolean a = gk2.M().a();
            rl2.e(Boolean.valueOf(a));
            x(a, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.repackage.he4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) {
            dw2 dw2Var = this.k;
            if (dw2Var != null) {
                dw2Var.f(this, i, strArr, iArr);
            } else {
                z(i, strArr, iArr);
            }
        }
    }

    public o63 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (o63) invokeV.objValue;
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
                this.j = new o63();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.j.a(viewGroup);
            } else {
                this.j.b(viewGroup);
            }
            if (z2) {
                px2 e = px2.e();
                rx2 rx2Var = new rx2(5);
                rx2Var.f(true);
                e.h(rx2Var);
            }
        }
    }

    public void y(int i, @NonNull String[] strArr, dw2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, aVar) == null) {
            dw2 c = dw2.c();
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
