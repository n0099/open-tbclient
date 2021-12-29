package com.baidu.live.business;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.x.c.a.c;
import c.a.x.c.a.d;
import c.a.x.k.f;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class LiveLoadMoreView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LottieAnimationView f35876f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35877g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLoadMoreView(Context context) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = d.live_feed_page_load_more_bd;
            if ("baidu".equals(LiveFeedPageSdk.f().e())) {
                i2 = d.live_feed_page_load_more_bd;
            } else if ("haokan".equals(LiveFeedPageSdk.f().e())) {
                i2 = d.live_feed_page_load_more_hk;
            } else if ("quanmin".equals(LiveFeedPageSdk.f().e())) {
                i2 = d.live_feed_page_load_more_qm;
            } else if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                i2 = d.live_feed_page_load_more_tb;
            }
            LayoutInflater.from(getContext()).inflate(i2, this);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(c.load_more_anim_view);
            this.f35876f = lottieAnimationView;
            lottieAnimationView.loop(true);
            this.f35877g = (TextView) findViewById(c.load_more_label);
        }
    }

    public final void b() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (lottieAnimationView = this.f35876f) != null && lottieAnimationView.isAnimating()) {
            this.f35876f.cancelAnimation();
        }
    }

    public final void c() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lottieAnimationView = this.f35876f) == null || lottieAnimationView.isAnimating()) {
            return;
        }
        this.f35876f.playAnimation();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void onDarkModeChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            String f2 = f.e().f(z);
            if (TextUtils.isEmpty(f2)) {
                int g2 = f.e().g(z);
                if (g2 != 0) {
                    this.f35876f.setAnimation(g2);
                }
            } else {
                this.f35876f.setAnimation(f2);
            }
            this.f35877g.setTextColor(f.e().a(getContext(), z, "color_1F1F1F"));
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onViewAttached();
            c();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onViewDetached();
            b();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewRecycled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onViewRecycled();
            b();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void releaseHolder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.releaseHolder();
            b();
        }
    }

    public void setAnimViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 0) {
                this.f35876f.playAnimation();
            } else {
                this.f35876f.cancelAnimation();
            }
            this.f35876f.setVisibility(i2);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, liveRoomEntity, i2) == null) {
        }
    }

    public void setLoadMoreLabel(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f35877g.setText(str);
    }

    public void setTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (textView = this.f35877g) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void setTextSize(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (textView = this.f35877g) == null) {
            return;
        }
        textView.setTextSize(2, i2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 == 0) {
                this.f35876f.playAnimation();
            } else {
                this.f35876f.cancelAnimation();
            }
            super.setVisibility(i2);
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
        a();
    }

    public void setLoadMoreLabel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            String string = getResources().getString(i2);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f35877g.setText(string);
        }
    }
}
