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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f29141e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f29142f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f29143g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f29144h;
    public TextView i;
    public TextView j;
    public Animation k;
    public Animation l;
    public ImageView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigBgHeaderLoadingLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, viewGroup, attributeSet)) == null) ? LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00cb, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.m == null) {
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
        this.m.setAlpha(f3);
        this.m.setScaleX(f4);
        this.m.setScaleY(f4);
        super.d(f2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (ILoadingLayout$State.RELEASE_TO_REFRESH == getPreState()) {
                this.f29142f.clearAnimation();
                this.f29142f.startAnimation(this.l);
            }
            this.f29144h.setText(R.string.obfuscated_res_0x7f0f01a7);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = this.f29141e;
            if (relativeLayout != null) {
                return relativeLayout.getHeight();
            }
            return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070161);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29142f.clearAnimation();
            this.f29142f.setVisibility(4);
            this.f29143g.setVisibility(0);
            this.f29144h.setText(R.string.obfuscated_res_0x7f0f01ab);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29142f.clearAnimation();
            this.f29142f.startAnimation(this.k);
            this.f29144h.setText(R.string.obfuscated_res_0x7f0f01a8);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29142f.clearAnimation();
            this.f29144h.setText(R.string.obfuscated_res_0x7f0f01a7);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, iLoadingLayout$State, iLoadingLayout$State2) == null) {
            this.f29142f.setVisibility(0);
            this.f29143g.setVisibility(4);
            super.l(iLoadingLayout$State, iLoadingLayout$State2);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f29141e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091970);
            this.f29142f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09196e);
            this.f29144h = (TextView) findViewById(R.id.obfuscated_res_0x7f091971);
            this.f29143g = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091972);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091974);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091976);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f09196f);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.k = rotateAnimation;
            rotateAnimation.setDuration(120L);
            this.k.setFillAfter(true);
            RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.l = rotateAnimation2;
            rotateAnimation2.setDuration(120L);
            this.l.setFillAfter(true);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (imageView = this.m) == null) {
            return;
        }
        imageView.setBackgroundResource(i);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) {
            this.j.setVisibility(TextUtils.isEmpty(charSequence) ? 4 : 0);
            this.i.setText(charSequence);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n(context);
    }
}
