package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.jz2;
import com.baidu.tieba.mn2;
import com.baidu.tieba.pk1;
import com.baidu.tieba.u93;
import com.baidu.tieba.v03;
import com.baidu.tieba.x03;
import com.baidu.tieba.xo2;
import com.baidu.tieba.zh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public u93 j;
    public jz2 k;

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
        l = pk1.a;
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

    public u93 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (u93) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vh4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = zh3.c0(this);
            super.onCreate(bundle);
            zh3.g(this, c0);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onPostCreate(bundle);
            boolean a = mn2.M().a();
            xo2.e(Boolean.valueOf(a));
            x(a, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.ph4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) {
            jz2 jz2Var = this.k;
            if (jz2Var != null) {
                jz2Var.f(this, i, strArr, iArr);
            } else {
                z(i, strArr, iArr);
            }
        }
    }

    public void y(int i, @NonNull String[] strArr, jz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, aVar) == null) {
            jz2 c = jz2.c();
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
                this.j = new u93();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.j.a(viewGroup);
            } else {
                this.j.b(viewGroup);
            }
            if (z2) {
                v03 e = v03.e();
                x03 x03Var = new x03(5);
                x03Var.f(true);
                e.h(x03Var);
            }
        }
    }
}
