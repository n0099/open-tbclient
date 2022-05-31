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
import com.repackage.bd3;
import com.repackage.lu2;
import com.repackage.oi2;
import com.repackage.rf1;
import com.repackage.w43;
import com.repackage.xv2;
import com.repackage.zj2;
import com.repackage.zv2;
/* loaded from: classes2.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SwanAppBaseActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public lu2 mPermissionHandler;
    public w43 mSkinDecorator;

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
        DEBUG = rf1.a;
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

    public w43 getSkinDecorator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSkinDecorator : (w43) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.repackage.vc4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int c0 = bd3.c0(this);
            super.onCreate(bundle);
            bd3.g(this, c0);
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
                this.mSkinDecorator = new w43();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.mSkinDecorator.a(viewGroup);
            } else {
                this.mSkinDecorator.b(viewGroup);
            }
            if (z2) {
                xv2 e = xv2.e();
                zv2 zv2Var = new zv2(5);
                zv2Var.f(true);
                e.h(zv2Var);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onPostCreate(bundle);
            boolean a = oi2.M().a();
            zj2.e(Boolean.valueOf(a));
            onNightModeCoverChanged(a, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.repackage.pc4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, strArr, iArr) == null) {
            lu2 lu2Var = this.mPermissionHandler;
            if (lu2Var != null) {
                lu2Var.f(this, i, strArr, iArr);
            } else {
                superOnRequestPermissionsResult(i, strArr, iArr);
            }
        }
    }

    public void requestPermissionsExt(int i, @NonNull String[] strArr, lu2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, strArr, aVar) == null) {
            lu2 c = lu2.c();
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
