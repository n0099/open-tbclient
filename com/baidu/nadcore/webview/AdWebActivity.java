package com.baidu.nadcore.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.tieba.R;
import com.baidu.tieba.a51;
import com.baidu.tieba.d51;
import com.baidu.tieba.e51;
import com.baidu.tieba.rm0;
import com.baidu.tieba.t41;
import com.baidu.tieba.z41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AdWebActivity extends BaseActivity implements SlideInterceptor, z41, a51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AbsContainer u;

    @Override // com.baidu.tieba.a51
    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z41
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z41
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

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
        this.u = t41.a.a(this, this, rm0.b().a().a("key_webview_core_type", 0));
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void Y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.Y0(bundle);
            if (!this.u.d()) {
                if (!isFinishing()) {
                    finish();
                    return;
                }
                return;
            }
            this.u.y("1");
            this.u.p();
            d51.f().a(getActivity());
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.Z0();
            this.u.q();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b1();
            this.u.r();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.g1();
            this.u.t();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.h1();
            this.u.u();
        }
    }

    @Override // com.baidu.tieba.z41
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.i1();
            this.u.v();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void c1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.c1(bundle);
            this.u.s(bundle);
        }
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

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean j1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            if (!super.j1(bundle)) {
                return false;
            }
            requestWindowFeature(1);
            if (e51.b.a().a(getIntent())) {
                p1(0, 0, 0, 0);
                forceActivityTransparent(true);
            } else {
                p1(R.anim.obfuscated_res_0x7f0100ae, R.anim.obfuscated_res_0x7f0100b1, R.anim.obfuscated_res_0x7f0100ad, R.anim.obfuscated_res_0x7f0100b2);
            }
            if (Build.VERSION.SDK_INT == 26) {
                setEnableSliding(false);
                setCurrentActivityNoTransparent();
            } else {
                m1(true, this);
                s1(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.u.o(i, i2, intent);
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
