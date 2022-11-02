package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.tieba.R;
import com.baidu.tieba.da0;
import com.baidu.tieba.uc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LoadingView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public LottieAnimationView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context) {
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
        this.a = true;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, AttributeSet attributeSet) {
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
        this.a = true;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = true;
        b();
    }

    public void a() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (lottieAnimationView = this.b) != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = false;
            if (this.b.isAnimating()) {
                this.b.cancelAnimation();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = true;
            if (getVisibility() == 0 && !this.b.isAnimating()) {
                this.b.playAnimation();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setGravity(17);
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0551, (ViewGroup) this, true);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091446);
            this.b = lottieAnimationView;
            if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
                this.b.cancelAnimation();
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = da0.b(getContext(), LoadAnimStrategy.getInstance().loadingLottieWidth);
            layoutParams.height = da0.b(getContext(), LoadAnimStrategy.getInstance().loadingLottieHeight);
            this.b.setLayoutParams(layoutParams);
            this.b.setImageAssetsFolder(LoadAnimStrategy.getInstance().loadingLottieImgRes);
            String j = uc0.f().j(str);
            if (TextUtils.isEmpty(j)) {
                int k = uc0.f().k(str);
                if (k != 0) {
                    this.b.setAnimation(k);
                    return;
                }
                return;
            }
            this.b.setAnimation(j);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i == 0) {
                if (this.a) {
                    this.b.playAnimation();
                }
            } else {
                this.b.cancelAnimation();
            }
            super.setVisibility(i);
        }
    }
}
