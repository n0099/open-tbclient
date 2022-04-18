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
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fc0;
import com.repackage.y90;
/* loaded from: classes2.dex */
public class LiveStatusAnimView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageView b;
    public LottieAnimationView c;
    public TextView d;
    public boolean e;
    public boolean f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveStatusAnimView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d051b, this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912a7);
            this.c = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0912a8);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0912a9);
            this.c.loop(true);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void c() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lottieAnimationView = this.c) == null) {
            return;
        }
        if (this.e) {
            lottieAnimationView.setVisibility(0);
            this.c.setProgress(0.0f);
            if (this.c.isAnimating()) {
                return;
            }
            this.c.playAnimation();
            return;
        }
        d();
    }

    public void d() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (lottieAnimationView = this.c) != null && lottieAnimationView.isAnimating()) {
            this.c.cancelAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            LottieAnimationView lottieAnimationView = this.c;
            if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
                return;
            }
            this.c.cancelAnimation();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
            if (i != 0) {
                LottieAnimationView lottieAnimationView = this.c;
                if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
                    return;
                }
                this.c.cancelAnimation();
                return;
            }
            c();
        }
    }

    public void setData(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            d();
            this.c.setVisibility(8);
            if (this.f) {
                this.c.setAnimation("live_feed_page_tag_live_ani.json");
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(fc0.e().o()) && !"dark".equals(fc0.e().o())) {
                this.c.setAnimation("live_feed_page_tag_live_ani.json");
            } else {
                this.c.setAnimation("live_feed_page_tag_live_night.json");
            }
            boolean z = (str2 == null || str2.equals(str3)) ? false : true;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(y90.a(this.a, 9.0f));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor(str2), Color.parseColor(str3)});
            } catch (Exception e) {
                gradientDrawable.setColors(new int[]{Color.parseColor("#FE33BA"), Color.parseColor("#FE3355")});
                e.printStackTrace();
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(fc0.e().o()) && !this.f) {
                gradientDrawable.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP);
            } else {
                gradientDrawable.setColorFilter(null);
            }
            setBackground(gradientDrawable);
            if (z) {
                this.d.setPadding(0, 0, 0, 0);
            } else {
                this.d.setPadding(y90.a(this.a, 3.0f), 0, 0, 0);
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(y90.a(this.a, 9.0f));
            if (i == 3) {
                this.e = false;
                gradientDrawable2.setColors(new int[]{fc0.e().a(this.a, this.f, "color_768CAE"), fc0.e().a(this.a, this.f, "color_768CAE")});
                if (!Config.TRACE_VISIT_RECENT_DAY.equals(fc0.e().o()) && !this.f) {
                    if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d25);
                    } else {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d26);
                    }
                } else {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d25);
                }
                this.b.setBackgroundDrawable(gradientDrawable2);
                this.b.setVisibility(0);
            } else if (i == 0) {
                this.e = false;
                gradientDrawable2.setColors(new int[]{fc0.e().a(this.a, this.f, "color_4E6EF2"), fc0.e().a(this.a, this.f, "color_4E6EF2")});
                if (!Config.TRACE_VISIT_RECENT_DAY.equals(fc0.e().o()) && !this.f) {
                    if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d27);
                    } else {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d28);
                    }
                } else {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d27);
                }
                this.b.setBackgroundDrawable(gradientDrawable2);
                this.b.setVisibility(0);
            } else {
                this.e = true;
                if (z) {
                    this.b.setVisibility(4);
                } else {
                    gradientDrawable2.setColors(new int[]{fc0.e().a(this.a, this.f, "color_FF3333"), fc0.e().a(this.a, this.f, "color_FF3333")});
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d2a);
                    this.b.setBackgroundDrawable(gradientDrawable2);
                    this.b.setVisibility(0);
                }
            }
            this.d.setTextColor(fc0.e().a(this.a, this.f, "color_white3"));
            this.d.setText(str);
        }
    }

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.e = false;
        this.f = false;
        a(context);
    }
}
