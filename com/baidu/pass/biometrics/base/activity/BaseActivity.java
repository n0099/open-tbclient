package com.baidu.pass.biometrics.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.R;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BaseActivity extends Activity implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f43854a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43855b;

    /* renamed from: c  reason: collision with root package name */
    public String f43856c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43857d;

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43854a = false;
        this.f43855b = true;
        this.f43857d = false;
    }

    @TargetApi(24)
    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.f43854a) {
                PassBioGlobalUtils.toastWithText(getActivity(), this.f43856c, 1);
            }
            if (this.f43855b) {
                return;
            }
            finish();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    public boolean isActivityInForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43857d : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.f43856c = getResources().getString(R.string.pass_bio_multi_window_tips);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    @TargetApi(5)
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 82 && keyEvent.isLongPress()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        super.onMultiWindowModeChanged(z);
        if (z && isActivityInForeground()) {
            if (this.f43854a) {
                PassBioGlobalUtils.toastWithText(getActivity(), this.f43856c, 1);
            }
            if (this.f43855b) {
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            this.f43857d = false;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            this.f43857d = true;
            a();
        }
    }

    public void setIsMultiWindowAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z == this.f43855b) {
            return;
        }
        this.f43855b = z;
    }

    public void setIsShowMultiWindowTips(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || z == this.f43854a) {
            return;
        }
        this.f43854a = z;
    }

    public void setMultiWindowTipsId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f43856c = str;
        }
    }
}
