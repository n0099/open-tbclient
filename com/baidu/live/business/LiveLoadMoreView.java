package com.baidu.live.business;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.uc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveLoadMoreView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup h;
    public LottieAnimationView i;
    public TextView j;

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, liveRoomEntity, i) == null) {
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

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
        f();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            String g = uc0.f().g(str);
            if (TextUtils.isEmpty(g)) {
                int h = uc0.f().h(str);
                if (h != 0) {
                    this.i.setAnimation(h);
                }
            } else {
                this.i.setAnimation(g);
            }
            this.j.setTextColor(uc0.f().a(getContext(), str, "color_1F1F1F"));
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
        f();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            h();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            h();
        }
    }

    public void d() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (viewGroup = this.h) != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setMinimumHeight(1);
        }
    }

    public final void h() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (lottieAnimationView = this.i) != null && lottieAnimationView.isAnimating()) {
            this.i.cancelAnimation();
        }
    }

    public final void i() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (lottieAnimationView = this.i) != null && !lottieAnimationView.isAnimating()) {
            this.i.playAnimation();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean equals = "recommend".equals(this.c);
            int i = R.layout.obfuscated_res_0x7f0d054d;
            if (!equals && !"baidu".equals(LiveFeedPageSdk.getInstance().getHost())) {
                if (LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    i = R.layout.obfuscated_res_0x7f0d054e;
                } else if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    i = R.layout.obfuscated_res_0x7f0d054f;
                } else if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                    i = R.layout.obfuscated_res_0x7f0d0550;
                }
            }
            LayoutInflater.from(getContext()).inflate(i, this);
            this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091cb1);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091440);
            this.i = lottieAnimationView;
            lottieAnimationView.loop(true);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091441);
        }
    }

    public void setAnimViewVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 0) {
                this.i.playAnimation();
            } else {
                this.i.cancelAnimation();
            }
            this.i.setVisibility(i);
        }
    }

    public void setLoadMoreLabel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String string = getResources().getString(i);
            if (!TextUtils.isEmpty(string)) {
                this.j.setText(string);
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            super.setScene(str);
            e();
        }
    }

    public void setTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (textView = this.j) != null) {
            textView.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (textView = this.j) != null) {
            textView.setTextSize(2, i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i == 0) {
                this.i.playAnimation();
            } else {
                this.i.cancelAnimation();
            }
            super.setVisibility(i);
        }
    }
}
