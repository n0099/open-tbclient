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
import com.repackage.bk2;
import com.repackage.eh1;
import com.repackage.j63;
import com.repackage.kx2;
import com.repackage.ml2;
import com.repackage.mx2;
import com.repackage.oe3;
import com.repackage.yv2;
/* loaded from: classes2.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SwanAppBaseActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public yv2 mPermissionHandler;
    public j63 mSkinDecorator;

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
        DEBUG = eh1.a;
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
        this.mSkinDecorator = null;
    }

    public j63 getSkinDecorator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSkinDecorator : (j63) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.ie4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int c0 = oe3.c0(this);
            super.onCreate(bundle);
            oe3.g(this, c0);
        }
    }

    public void onNightModeCoverChanged(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Window window = getWindow();
            if (window == null) {
                if (DEBUG) {
                    Log.e(TAG, "activity or window is null");
                    return;
                }
                return;
            }
            if (this.mSkinDecorator == null) {
                this.mSkinDecorator = new j63();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.mSkinDecorator.a(viewGroup);
            } else {
                this.mSkinDecorator.b(viewGroup);
            }
            if (z2) {
                kx2 e = kx2.e();
                mx2 mx2Var = new mx2(5);
                mx2Var.f(true);
                e.h(mx2Var);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onPostCreate(bundle);
            boolean a = bk2.M().a();
            ml2.e(Boolean.valueOf(a));
            onNightModeCoverChanged(a, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.repackage.ce4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, strArr, iArr) == null) {
            yv2 yv2Var = this.mPermissionHandler;
            if (yv2Var != null) {
                yv2Var.f(this, i, strArr, iArr);
            } else {
                superOnRequestPermissionsResult(i, strArr, iArr);
            }
        }
    }

    public void requestPermissionsExt(int i, @NonNull String[] strArr, yv2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, aVar) == null) {
            yv2 c = yv2.c();
            this.mPermissionHandler = c;
            c.requestPermissions(this, i, strArr, aVar);
        }
    }

    public void superOnRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
