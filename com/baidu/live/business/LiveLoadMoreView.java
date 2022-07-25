package com.baidu.live.business;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eb0;
/* loaded from: classes2.dex */
public class LiveLoadMoreView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LottieAnimationView d;
    public TextView e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLoadMoreView(Context context) {
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
        d();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            g();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            f();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            f();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean equals = "baidu".equals(LiveFeedPageSdk.f().e());
            int i = R.layout.obfuscated_res_0x7f0d051a;
            if (!equals) {
                if ("haokan".equals(LiveFeedPageSdk.f().e())) {
                    i = R.layout.obfuscated_res_0x7f0d051b;
                } else if ("quanmin".equals(LiveFeedPageSdk.f().e())) {
                    i = R.layout.obfuscated_res_0x7f0d051c;
                } else if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                    i = R.layout.obfuscated_res_0x7f0d051d;
                }
            }
            LayoutInflater.from(getContext()).inflate(i, this);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091345);
            this.d = lottieAnimationView;
            lottieAnimationView.loop(true);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091346);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            String f = eb0.e().f(z);
            if (TextUtils.isEmpty(f)) {
                int g = eb0.e().g(z);
                if (g != 0) {
                    this.d.setAnimation(g);
                }
            } else {
                this.d.setAnimation(f);
            }
            this.e.setTextColor(eb0.e().a(getContext(), z, "color_1F1F1F"));
        }
    }

    public final void f() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (lottieAnimationView = this.d) != null && lottieAnimationView.isAnimating()) {
            this.d.cancelAnimation();
        }
    }

    public final void g() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lottieAnimationView = this.d) == null || lottieAnimationView.isAnimating()) {
            return;
        }
        this.d.playAnimation();
    }

    public void setAnimViewVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i == 0) {
                this.d.playAnimation();
            } else {
                this.d.cancelAnimation();
            }
            this.d.setVisibility(i);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, liveRoomEntity, i) == null) {
        }
    }

    public void setLoadMoreLabel(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
    }

    public void setTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (textView = this.e) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setTextSize(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (textView = this.e) == null) {
            return;
        }
        textView.setTextSize(2, i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i == 0) {
                this.d.playAnimation();
            } else {
                this.d.cancelAnimation();
            }
            super.setVisibility(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLoadMoreView(Context context, AttributeSet attributeSet) {
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
        d();
    }

    public void setLoadMoreLabel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            String string = getResources().getString(i);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.e.setText(string);
        }
    }
}
