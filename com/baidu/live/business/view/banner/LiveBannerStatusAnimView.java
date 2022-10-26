package com.baidu.live.business.view.banner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.ea0;
import com.baidu.tieba.vc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveBannerStatusAnimView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public View f;
    public boolean g;
    public String h;
    public int i;
    public int j;
    public String k;
    public LottieDrawable l;
    public String m;

    /* loaded from: classes2.dex */
    public class a implements OnCompositionLoadedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveBannerStatusAnimView a;

        public a(LiveBannerStatusAnimView liveBannerStatusAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveBannerStatusAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveBannerStatusAnimView;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                this.a.l.setComposition(lottieComposition);
                this.a.l.playAnimation();
                this.a.c.setImageDrawable(this.a.l);
                this.a.c.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveBannerStatusAnimView(Context context) {
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
    public LiveBannerStatusAnimView(Context context, AttributeSet attributeSet) {
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
    public LiveBannerStatusAnimView(Context context, AttributeSet attributeSet, int i) {
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
        this.k = "";
        d(context);
    }

    public void setScene(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.h = str;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h)) {
                if (!"night".equals(vc0.f().r()) && !"dark".equals(vc0.f().r())) {
                    this.m = "live_feed_page_tag_live_ani.json";
                    return;
                } else {
                    this.m = "live_feed_page_tag_live_night.json";
                    return;
                }
            }
            this.m = "live_feed_page_tag_live_ani.json";
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0534, this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09135c);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09135d);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09135e);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09135b);
            this.f = findViewById(R.id.obfuscated_res_0x7f09133c);
            this.l = new LottieDrawable();
            c();
            this.l.loop(true);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        LottieDrawable lottieDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c != null && (lottieDrawable = this.l) != null) {
            if (lottieDrawable.isAnimating()) {
                this.l.cancelAnimation();
            }
            this.c.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            h();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setTextColor(vc0.f().a(this.a, this.h, "color_white3"));
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setTextColor(vc0.f().a(this.a, this.h, "color_white3"));
            }
            if (this.b != null && this.f != null && this.e != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(ea0.b(this.a, 9.0f));
                gradientDrawable.setGradientType(0);
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable.setColors(new int[]{Color.parseColor("#4D000000"), Color.parseColor("#4D000000")});
                setBackground(gradientDrawable);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(ea0.b(this.a, 9.0f));
                if (this.i == 1) {
                    int i = this.j;
                    if (i == 3) {
                        gradientDrawable2.setColors(new int[]{vc0.f().a(this.a, this.h, "color_768CAE"), vc0.f().a(this.a, this.h, "color_768CAE")});
                        this.b.setBackgroundDrawable(gradientDrawable2);
                        if (!"day".equals(vc0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h)) {
                            if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d1b);
                            } else {
                                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d1c);
                            }
                        } else {
                            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d1b);
                        }
                    } else if (i == 0) {
                        gradientDrawable2.setColors(new int[]{vc0.f().a(this.a, this.h, "color_4E6EF2"), vc0.f().a(this.a, this.h, "color_4E6EF2")});
                        this.b.setBackgroundDrawable(gradientDrawable2);
                        if (!"day".equals(vc0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h)) {
                            if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d1d);
                            } else {
                                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d1e);
                            }
                        } else {
                            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d1d);
                        }
                    } else {
                        gradientDrawable2.setColors(new int[]{vc0.f().a(this.a, this.h, "color_FF3333"), vc0.f().a(this.a, this.h, "color_FF3333")});
                        this.f.setBackgroundDrawable(gradientDrawable2);
                        this.e.setVisibility(0);
                    }
                }
                c();
            }
        }
    }

    public void g() {
        LottieDrawable lottieDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.c != null && (lottieDrawable = this.l) != null) {
            if (this.g) {
                try {
                    if (lottieDrawable.isAnimating() && this.c.getVisibility() == 0) {
                        return;
                    }
                    if (this.k != null && !this.k.equals(vc0.f().r())) {
                        this.k = vc0.f().r();
                        if (this.l.isAnimating()) {
                            this.l.cancelAnimation();
                        }
                        this.c.setImageDrawable(null);
                        this.l.clearComposition();
                        LottieComposition.Factory.fromAssetFileName(this.a, this.m, new a(this));
                        return;
                    }
                    this.c.setVisibility(0);
                    if (!this.l.isAnimating()) {
                        this.l.playAnimation();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            h();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
            if (i != 0) {
                h();
            } else if (e()) {
                g();
            } else {
                h();
            }
        }
    }

    public void setData(LiveBannerEntity liveBannerEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, liveBannerEntity) == null) {
            setVisibility(8);
            if (liveBannerEntity != null) {
                int i = liveBannerEntity.bannerType;
                this.i = i;
                int i2 = liveBannerEntity.liveStatus;
                this.j = i2;
                if (i == 1) {
                    if (i2 == 3) {
                        this.g = false;
                        this.b.setVisibility(0);
                        this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d21);
                        this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1c));
                        this.d.setPadding(ea0.b(this.a, 2.0f), 0, ea0.b(this.a, 4.0f), 0);
                        this.e.setVisibility(8);
                    } else if (i2 == 0) {
                        this.g = false;
                        this.b.setVisibility(0);
                        this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d21);
                        this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1e));
                        this.d.setPadding(ea0.b(this.a, 2.0f), 0, ea0.b(this.a, 4.0f), 0);
                        this.e.setVisibility(8);
                    } else {
                        this.g = true;
                        this.b.setVisibility(8);
                        this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1d));
                        this.d.setPadding(0, 0, ea0.b(this.a, 4.0f), 0);
                        this.e.setVisibility(0);
                        this.e.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1b), ea0.a(this.a, liveBannerEntity.audienceCount)));
                    }
                    f("day");
                    setVisibility(0);
                    return;
                }
                this.g = false;
                setVisibility(8);
                return;
            }
            this.g = false;
            setVisibility(8);
        }
    }
}
