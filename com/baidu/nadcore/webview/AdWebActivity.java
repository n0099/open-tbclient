package com.baidu.nadcore.webview;

import android.app.Activity;
import android.content.Intent;
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
import com.repackage.m21;
import com.repackage.qk0;
import com.repackage.s21;
import com.repackage.t21;
import com.repackage.w21;
import com.repackage.x21;
/* loaded from: classes2.dex */
public class AdWebActivity extends BaseActivity implements SlideInterceptor, s21, t21 {
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
        this.u = m21.a.a(this, this, qk0.b().a().a("key_webview_core_type", 1));
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.P0(bundle);
            if (!this.u.d()) {
                if (isFinishing()) {
                    return;
                }
                finish();
                return;
            }
            this.u.y("1");
            this.u.p();
            w21.f().a(getActivity());
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.S0();
            this.u.q();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.U0();
            this.u.r();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void V0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.V0(bundle);
            this.u.s(bundle);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.Z0();
            this.u.t();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.a1();
            this.u.u();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.b1();
            this.u.v();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean c1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            if (super.c1(bundle)) {
                requestWindowFeature(1);
                if (x21.b.a().a(getIntent())) {
                    k1(0, 0, 0, 0);
                    forceActivityTransparent(true);
                } else {
                    k1(R.anim.obfuscated_res_0x7f0100ae, R.anim.obfuscated_res_0x7f0100b1, R.anim.obfuscated_res_0x7f0100ad, R.anim.obfuscated_res_0x7f0100b2);
                }
                if (Build.VERSION.SDK_INT == 26) {
                    setEnableSliding(false);
                    setCurrentActivityNoTransparent();
                } else {
                    h1(true, this);
                    n1(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.s21
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            finish();
        }
    }

    @Override // com.repackage.s21
    @NonNull
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (this.u.m()) {
                return false;
            }
            return this.u.c(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.u.o(i, i2, intent);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            if (this.u.onKeyDown(i, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.s21
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.t21
    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
