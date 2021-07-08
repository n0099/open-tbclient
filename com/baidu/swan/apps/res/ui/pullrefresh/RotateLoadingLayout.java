package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.e;
import d.a.n0.a.f;
import d.a.n0.a.g;
import d.a.n0.a.h;
import d.a.n0.a.v2.d;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f11444i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public Animation n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1112341176, "Lcom/baidu/swan/apps/res/ui/pullrefresh/RotateLoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1112341176, "Lcom/baidu/swan/apps/res/ui/pullrefresh/RotateLoadingLayout;");
                return;
            }
        }
        o = new LinearInterpolator();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLoadingLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, viewGroup, attributeSet)) == null) ? LayoutInflater.from(context).inflate(g.aiapps_pull_to_refresh_header2, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) && d.c()) {
            this.j.setRotation(f2 * 180.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.setText(h.aiapps_pull_to_refresh_header_hint_normal);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = this.f11444i;
            if (relativeLayout != null) {
                return relativeLayout.getHeight();
            }
            return (int) getResources().getDimension(d.a.n0.a.d.aiapps_picture_pull_to_refresh_height_height);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            o();
            this.j.startAnimation(this.n);
            this.k.setText(h.aiapps_pull_to_refresh_header_hint_loading);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.i();
            this.k.setText(h.aiapps_pull_to_refresh_header_hint_go_home);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k.setText(h.aiapps_pull_to_refresh_header_hint_ready);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o();
            this.k.setText(h.aiapps_pull_to_refresh_header_hint_normal);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iLoadingLayout$State, iLoadingLayout$State2) == null) {
            super.l(iLoadingLayout$State, iLoadingLayout$State2);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.f11444i = (RelativeLayout) findViewById(f.pull_to_refresh_header_content);
            this.j = (ImageView) findViewById(f.pull_to_refresh_header_arrow);
            this.k = (TextView) findViewById(f.pull_to_refresh_header_hint_textview);
            this.l = (TextView) findViewById(f.pull_to_refresh_header_time);
            this.m = (TextView) findViewById(f.pull_to_refresh_last_update_time_text);
            this.j.setScaleType(ImageView.ScaleType.CENTER);
            this.j.setImageResource(e.aiapps_default_ptr_rotate);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
            this.n = rotateAnimation;
            rotateAnimation.setFillAfter(true);
            this.n.setInterpolator(o);
            this.n.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.n.setRepeatCount(-1);
            this.n.setRepeatMode(1);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j.clearAnimation();
            if (d.c()) {
                this.j.setRotation(0.0f);
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, charSequence) == null) {
            this.m.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
            this.l.setText(charSequence);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        n(context);
    }
}
