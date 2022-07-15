package com.baidu.nadcore.webview;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d21;
import com.repackage.e21;
import com.repackage.h21;
import com.repackage.i21;
import com.repackage.tk0;
import com.repackage.x11;
/* loaded from: classes2.dex */
public class AdWebActivity extends BaseActivity implements SlideInterceptor, d21, e21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbsContainer u;

    public AdWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = x11.a.a(this, this, tk0.b().a().a("key_webview_core_type", 0));
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.B0(bundle);
            if (!this.u.b()) {
                if (isFinishing()) {
                    return;
                }
                finish();
                return;
            }
            this.u.v("1");
            this.u.m();
            h21.g().a(getActivity());
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E0();
            this.u.o();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.F0(bundle);
            this.u.p(bundle);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.H0();
            this.u.q();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.L0();
            this.u.r();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.M0();
            this.u.s();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean N0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) {
            if (super.N0(bundle)) {
                requestWindowFeature(1);
                if (i21.b.a().a(getIntent())) {
                    V0(0, 0, 0, 0);
                    forceActivityTransparent(true);
                } else {
                    V0(R.anim.obfuscated_res_0x7f0100a8, R.anim.obfuscated_res_0x7f0100ab, R.anim.obfuscated_res_0x7f0100a7, R.anim.obfuscated_res_0x7f0100ac);
                }
                if (Build.VERSION.SDK_INT == 26) {
                    setEnableSliding(false);
                    setCurrentActivityNoTransparent();
                } else {
                    Q0(true, this);
                    a1(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.d21
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            finish();
        }
    }

    @Override // com.repackage.d21
    @NonNull
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.e21
    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (this.u.k()) {
                return false;
            }
            return this.u.a(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.d21
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.u.n();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            if (this.u.onKeyDown(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
