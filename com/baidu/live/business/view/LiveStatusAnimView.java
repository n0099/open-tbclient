package com.baidu.live.business.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.y.b.f.a;
import c.a.y.c.a.b;
import c.a.y.c.a.c;
import c.a.y.c.a.d;
import c.a.y.k.f;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class LiveStatusAnimView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35016e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35017f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f35018g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35019h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35020i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35021j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveStatusAnimView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f35016e = context;
            LayoutInflater.from(context).inflate(d.live_feed_page_status_anim_layout, this);
            this.f35017f = (ImageView) findViewById(c.live_feed_page_tip_iv);
            this.f35018g = (LottieAnimationView) findViewById(c.live_feed_page_tip_lottie);
            this.f35019h = (TextView) findViewById(c.live_feed_page_tip_text);
            this.f35018g.loop(true);
        }
    }

    public boolean isHasAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35020i : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            LottieAnimationView lottieAnimationView = this.f35018g;
            if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
                return;
            }
            this.f35018g.cancelAnimation();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 != 0) {
                LottieAnimationView lottieAnimationView = this.f35018g;
                if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
                    return;
                }
                this.f35018g.cancelAnimation();
                return;
            }
            startAnim();
        }
    }

    public void setData(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            stopAnim();
            this.f35018g.setVisibility(8);
            if (this.f35021j) {
                this.f35018g.setAnimation("live_feed_page_tag_live_ani.json");
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
                this.f35018g.setAnimation("live_feed_page_tag_live_ani.json");
            } else {
                this.f35018g.setAnimation("live_feed_page_tag_live_night.json");
            }
            boolean z = (str2 == null || str2.equals(str3)) ? false : true;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(a.a(this.f35016e, 9.0f));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor(str2), Color.parseColor(str3)});
            } catch (Exception e2) {
                gradientDrawable.setColors(new int[]{Color.parseColor("#FE33BA"), Color.parseColor("#FE3355")});
                e2.printStackTrace();
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !this.f35021j) {
                gradientDrawable.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP);
            } else {
                gradientDrawable.setColorFilter(null);
            }
            setBackground(gradientDrawable);
            if (z) {
                this.f35019h.setPadding(0, 0, 0, 0);
            } else {
                this.f35019h.setPadding(a.a(this.f35016e, 3.0f), 0, 0, 0);
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(a.a(this.f35016e, 9.0f));
            if (i2 == 3) {
                this.f35020i = false;
                gradientDrawable2.setColors(new int[]{f.e().a(this.f35016e, this.f35021j, "color_768CAE"), f.e().a(this.f35016e, this.f35021j, "color_768CAE")});
                if (!"day".equals(f.e().o()) && !this.f35021j) {
                    if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                        this.f35017f.setImageResource(b.live_feed_page_tag_back);
                    } else {
                        this.f35017f.setImageResource(b.live_feed_page_tag_back_night);
                    }
                } else {
                    this.f35017f.setImageResource(b.live_feed_page_tag_back);
                }
                this.f35017f.setBackgroundDrawable(gradientDrawable2);
                this.f35017f.setVisibility(0);
            } else if (i2 == 0) {
                this.f35020i = false;
                gradientDrawable2.setColors(new int[]{f.e().a(this.f35016e, this.f35021j, "color_4E6EF2"), f.e().a(this.f35016e, this.f35021j, "color_4E6EF2")});
                if (!"day".equals(f.e().o()) && !this.f35021j) {
                    if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                        this.f35017f.setImageResource(b.live_feed_page_tag_preview);
                    } else {
                        this.f35017f.setImageResource(b.live_feed_page_tag_preview_night);
                    }
                } else {
                    this.f35017f.setImageResource(b.live_feed_page_tag_preview);
                }
                this.f35017f.setBackgroundDrawable(gradientDrawable2);
                this.f35017f.setVisibility(0);
            } else {
                this.f35020i = true;
                if (z) {
                    this.f35017f.setVisibility(4);
                } else {
                    gradientDrawable2.setColors(new int[]{f.e().a(this.f35016e, this.f35021j, "color_FF3333"), f.e().a(this.f35016e, this.f35021j, "color_FF3333")});
                    this.f35017f.setImageResource(b.live_feed_page_transparent);
                    this.f35017f.setBackgroundDrawable(gradientDrawable2);
                    this.f35017f.setVisibility(0);
                }
            }
            this.f35019h.setTextColor(f.e().a(this.f35016e, this.f35021j, "color_white3"));
            this.f35019h.setText(str);
        }
    }

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f35021j = z;
        }
    }

    public void startAnim() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lottieAnimationView = this.f35018g) == null) {
            return;
        }
        if (this.f35020i) {
            lottieAnimationView.setVisibility(0);
            this.f35018g.setProgress(0.0f);
            if (this.f35018g.isAnimating()) {
                return;
            }
            this.f35018g.playAnimation();
            return;
        }
        stopAnim();
    }

    public void stopAnim() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (lottieAnimationView = this.f35018g) != null && lottieAnimationView.isAnimating()) {
            this.f35018g.cancelAnimation();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35020i = false;
        this.f35021j = false;
        a(context);
    }
}
