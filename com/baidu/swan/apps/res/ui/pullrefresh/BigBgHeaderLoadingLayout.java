package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d;
import c.a.s0.a.f;
import c.a.s0.a.g;
import c.a.s0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f39376i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f39377j;
    public ProgressBar k;
    public TextView l;
    public TextView m;
    public TextView n;
    public Animation o;
    public Animation p;
    public ImageView q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigBgHeaderLoadingLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f39376i = (RelativeLayout) findViewById(f.pull_to_refresh_header_content);
            this.f39377j = (ImageView) findViewById(f.pull_to_refresh_header_arrow);
            this.l = (TextView) findViewById(f.pull_to_refresh_header_hint_textview);
            this.k = (ProgressBar) findViewById(f.pull_to_refresh_header_progressbar);
            this.m = (TextView) findViewById(f.pull_to_refresh_header_time);
            this.n = (TextView) findViewById(f.pull_to_refresh_last_update_time_text);
            this.q = (ImageView) findViewById(f.pull_to_refresh_header_background);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.o = rotateAnimation;
            rotateAnimation.setDuration(120L);
            this.o.setFillAfter(true);
            RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.p = rotateAnimation2;
            rotateAnimation2.setDuration(120L);
            this.p.setFillAfter(true);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup, attributeSet)) == null) ? LayoutInflater.from(context).inflate(g.aiapps_pull_to_refresh_header_big_bg, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RelativeLayout relativeLayout = this.f39376i;
            if (relativeLayout != null) {
                return relativeLayout.getHeight();
            }
            return (int) getResources().getDimension(d.aiapps_picture_pull_to_refresh_height_height);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPull(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || this.q == null) {
            return;
        }
        float f3 = f2 - 0.3f;
        float f4 = 1.0f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        float f5 = f2 + 0.8f;
        if (f5 < 0.8f) {
            f4 = 0.8f;
        } else if (f5 <= 1.0f) {
            f4 = f5;
        }
        this.q.setAlpha(f3);
        this.q.setScaleX(f4);
        this.q.setScaleY(f4);
        super.onPull(f2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (ILoadingLayout$State.RELEASE_TO_REFRESH == getPreState()) {
                this.f39377j.clearAnimation();
                this.f39377j.startAnimation(this.p);
            }
            this.l.setText(h.aiapps_pull_to_refresh_header_hint_normal);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f39377j.clearAnimation();
            this.f39377j.setVisibility(4);
            this.k.setVisibility(0);
            this.l.setText(h.aiapps_pull_to_refresh_header_updateing);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f39377j.clearAnimation();
            this.f39377j.startAnimation(this.o);
            this.l.setText(h.aiapps_pull_to_refresh_header_hint_ready);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f39377j.clearAnimation();
            this.l.setText(h.aiapps_pull_to_refresh_header_hint_normal);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void onStateChanged(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iLoadingLayout$State, iLoadingLayout$State2) == null) {
            this.f39377j.setVisibility(0);
            this.k.setVisibility(4);
            super.onStateChanged(iLoadingLayout$State, iLoadingLayout$State2);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (imageView = this.q) == null) {
            return;
        }
        imageView.setBackgroundResource(i2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) {
            this.n.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
            this.m.setText(charSequence);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigBgHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }
}
