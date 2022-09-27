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
import com.baidu.tieba.c51;
import com.baidu.tieba.d51;
import com.baidu.tieba.qm0;
import com.baidu.tieba.s41;
import com.baidu.tieba.y41;
import com.baidu.tieba.z41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AdWebActivity extends BaseActivity implements SlideInterceptor, y41, z41 {
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
        this.u = s41.a.a(this, this, qm0.b().a().a("key_webview_core_type", 0));
    }

    @Override // com.baidu.tieba.z41
    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void Z0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.Z0(bundle);
            if (!this.u.d()) {
                if (isFinishing()) {
                    return;
                }
                finish();
                return;
            }
            this.u.y("1");
            this.u.p();
            c51.f().a(getActivity());
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a1();
            this.u.q();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c1();
            this.u.r();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void d1(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.d1(bundle);
            this.u.s(bundle);
        }
    }

    @Override // com.baidu.tieba.y41
    @NonNull
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.h1();
            this.u.t();
        }
    }

    @Override // com.baidu.tieba.y41
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.i1();
            this.u.u();
        }
    }

    @Override // com.baidu.nadcore.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (this.u.m()) {
                return false;
            }
            return this.u.c(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.j1();
            this.u.v();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean k1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundle)) == null) {
            if (super.k1(bundle)) {
                requestWindowFeature(1);
                if (d51.b.a().a(getIntent())) {
                    q1(0, 0, 0, 0);
                    forceActivityTransparent(true);
                } else {
                    q1(R.anim.obfuscated_res_0x7f0100ae, R.anim.obfuscated_res_0x7f0100b1, R.anim.obfuscated_res_0x7f0100ad, R.anim.obfuscated_res_0x7f0100b2);
                }
                if (Build.VERSION.SDK_INT == 26) {
                    setEnableSliding(false);
                    setCurrentActivityNoTransparent();
                } else {
                    n1(true, this);
                    t1(true);
                }
                return true;
            }
            return false;
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

    @Override // com.baidu.tieba.y41
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
