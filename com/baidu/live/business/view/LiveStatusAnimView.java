package com.baidu.live.business.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.util.CustomTypefaceSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.ca0;
import com.baidu.tieba.da0;
import com.baidu.tieba.uc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class LiveStatusAnimView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageView b;
    public LottieAnimationView c;
    public TextView d;
    public SimpleDraweeView e;
    public SimpleDraweeView f;
    public boolean g;
    public String h;

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
        this.g = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d056b, this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913ff);
            this.c = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091400);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091401);
            this.c.loop(true);
            this.e = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f0913f5);
            this.f = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f0913f6);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
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
            if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
                this.c.cancelAnimation();
            }
        }
    }

    public void c() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (lottieAnimationView = this.c) != null) {
            if (this.g) {
                lottieAnimationView.setVisibility(0);
                this.c.setProgress(0.0f);
                if (!this.c.isAnimating()) {
                    this.c.playAnimation();
                    return;
                }
                return;
            }
            d();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
            if (i != 0) {
                LottieAnimationView lottieAnimationView = this.c;
                if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
                    this.c.cancelAnimation();
                    return;
                }
                return;
            }
            c();
        }
    }

    public void setData(LiveRoomEntity liveRoomEntity, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, liveRoomEntity, z) == null) {
            d();
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            if (!LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.h)) {
                if (!"night".equals(uc0.f().r()) && !"dark".equals(uc0.f().r())) {
                    this.c.setAnimation("live_feed_page_tag_live_ani.json");
                } else if (LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    this.c.setAnimation("live_feed_page_tag_live_ani.json");
                } else {
                    this.c.setAnimation("live_feed_page_tag_live_night.json");
                }
            } else {
                this.c.setAnimation("live_feed_page_tag_live_ani.json");
            }
            LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
            String str = leftLableInfo.startColor;
            if (str != null && !str.equals(leftLableInfo.endColor)) {
                z2 = true;
            } else {
                z2 = false;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(da0.b(this.a, 9.0f));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor(liveRoomEntity.leftLabel.startColor), Color.parseColor(liveRoomEntity.leftLabel.endColor)});
            } catch (Exception e) {
                gradientDrawable.setColors(new int[]{Color.parseColor("#FE33BA"), Color.parseColor("#FE3355")});
                e.printStackTrace();
            }
            if ("night".equals(uc0.f().r()) && LiveFeedPageSdk.HOST_LIVE_TAB.equals(this.h)) {
                gradientDrawable.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP);
            } else {
                gradientDrawable.setColorFilter(null);
            }
            setBackground(gradientDrawable);
            if (z2) {
                this.d.setPadding(0, 0, 0, 0);
            } else {
                this.d.setPadding(da0.b(this.a, 3.0f), 0, 0, 0);
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(da0.b(this.a, 9.0f));
            int i = liveRoomEntity.liveStatus;
            if (i == 3) {
                this.g = false;
                gradientDrawable2.setColors(new int[]{uc0.f().a(this.a, this.h, "color_768CAE"), uc0.f().a(this.a, this.h, "color_768CAE")});
                if (!"day".equals(uc0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.h)) {
                    if (!"tieba".equals(LiveFeedPageSdk.getInstance().getHost()) && !LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d63);
                    } else {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d62);
                    }
                } else {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d62);
                }
                this.b.setBackgroundDrawable(gradientDrawable2);
                this.b.setVisibility(0);
            } else if (i == 0) {
                this.g = false;
                gradientDrawable2.setColors(new int[]{uc0.f().a(this.a, this.h, "color_4E6EF2"), uc0.f().a(this.a, this.h, "color_4E6EF2")});
                if (!"day".equals(uc0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.h)) {
                    if (!"tieba".equals(LiveFeedPageSdk.getInstance().getHost()) && !LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d65);
                    } else {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d64);
                    }
                } else {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d64);
                }
                this.b.setBackgroundDrawable(gradientDrawable2);
                this.b.setVisibility(0);
            } else if (!TextUtils.isEmpty(liveRoomEntity.leftLabel.leftIcon)) {
                this.b.setVisibility(8);
                this.g = false;
                this.e.setVisibility(0);
                this.e.setImageURI(liveRoomEntity.leftLabel.leftIcon);
            } else {
                this.g = true;
                if (z2) {
                    this.b.setVisibility(4);
                } else {
                    gradientDrawable2.setColors(new int[]{uc0.f().a(this.a, this.h, "color_FF3333"), uc0.f().a(this.a, this.h, "color_FF3333")});
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d68);
                    this.b.setBackgroundDrawable(gradientDrawable2);
                    this.b.setVisibility(0);
                }
            }
            if (z) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) liveRoomEntity.leftLabel.prefix);
                spannableStringBuilder.append((CharSequence) liveRoomEntity.leftLabel.newText);
                spannableStringBuilder.setSpan(new CustomTypefaceSpan(ca0.b("dinalternate.ttf")), liveRoomEntity.leftLabel.prefix.length(), spannableStringBuilder.length(), 33);
                this.d.setTextColor(uc0.f().a(this.a, this.h, "color_white3"));
                this.d.setText(spannableStringBuilder);
            } else {
                this.d.setTextColor(uc0.f().a(this.a, this.h, "color_white3"));
                this.d.setText(liveRoomEntity.leftLabel.text);
            }
            if (!TextUtils.isEmpty(liveRoomEntity.leftLabel.rightIcon)) {
                this.f.setVisibility(0);
                this.f.setImageURI(liveRoomEntity.leftLabel.rightIcon);
            }
        }
    }

    public void setScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.h = str;
        }
    }
}
