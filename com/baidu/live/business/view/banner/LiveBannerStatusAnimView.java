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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.w.c.a.b;
import c.a.w.c.a.c;
import c.a.w.c.a.d;
import c.a.w.c.a.e;
import c.a.w.i.f;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LiveBannerStatusAnimView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35341e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35342f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35343g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35344h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f35345i;

    /* renamed from: j  reason: collision with root package name */
    public View f35346j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f35347k;
    public boolean l;
    public int m;
    public int n;
    public String o;
    public LottieDrawable p;
    public String q;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveBannerStatusAnimView;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(@Nullable LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                this.a.p.setComposition(lottieComposition);
                this.a.p.playAnimation();
                this.a.f35343g.setImageDrawable(this.a.p);
                this.a.f35343g.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveBannerStatusAnimView(@NonNull Context context) {
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l) {
                this.q = "live_feed_page_tag_live_ani.json";
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().n()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().n())) {
                this.q = "live_feed_page_tag_live_ani.json";
            } else {
                this.q = "live_feed_page_tag_live_night.json";
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f35341e = context;
            LayoutInflater.from(context).inflate(d.live_feed_page_banner_status_anim_layout, this);
            this.f35342f = (ImageView) findViewById(c.live_feed_page_tip_iv);
            this.f35343g = (ImageView) findViewById(c.live_feed_page_tip_lottie);
            this.f35344h = (TextView) findViewById(c.live_feed_page_tip_text);
            this.f35345i = (TextView) findViewById(c.live_feed_page_tip_aud_text);
            this.f35346j = findViewById(c.live_feed_page_banner_left_layout);
            this.p = new LottieDrawable();
            c();
            this.p.loop(true);
        }
    }

    public boolean isHasAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35347k : invokeV.booleanValue;
    }

    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TextView textView = this.f35344h;
            if (textView != null) {
                textView.setTextColor(f.e().a(this.f35341e, this.l, "color_white3"));
            }
            TextView textView2 = this.f35345i;
            if (textView2 != null) {
                textView2.setTextColor(f.e().a(this.f35341e, this.l, "color_white3"));
            }
            if (this.f35342f == null || this.f35346j == null || this.f35345i == null) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(c.a.w.b.f.a.a(this.f35341e, 9.0f));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{Color.parseColor("#4D000000"), Color.parseColor("#4D000000")});
            setBackground(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(c.a.w.b.f.a.a(this.f35341e, 9.0f));
            if (this.m == 1) {
                int i2 = this.n;
                if (i2 == 3) {
                    gradientDrawable2.setColors(new int[]{f.e().a(this.f35341e, this.l, "color_768CAE"), f.e().a(this.f35341e, this.l, "color_768CAE")});
                    this.f35342f.setBackgroundDrawable(gradientDrawable2);
                    if (!"day".equals(f.e().n()) && !this.l) {
                        if ("tieba".equals(LiveFeedPageSdk.e().d())) {
                            this.f35342f.setImageResource(b.live_feed_page_tag_back);
                        } else {
                            this.f35342f.setImageResource(b.live_feed_page_tag_back_night);
                        }
                    } else {
                        this.f35342f.setImageResource(b.live_feed_page_tag_back);
                    }
                } else if (i2 == 0) {
                    gradientDrawable2.setColors(new int[]{f.e().a(this.f35341e, this.l, "color_4E6EF2"), f.e().a(this.f35341e, this.l, "color_4E6EF2")});
                    this.f35342f.setBackgroundDrawable(gradientDrawable2);
                    if (!"day".equals(f.e().n()) && !this.l) {
                        if ("tieba".equals(LiveFeedPageSdk.e().d())) {
                            this.f35342f.setImageResource(b.live_feed_page_tag_preview);
                        } else {
                            this.f35342f.setImageResource(b.live_feed_page_tag_preview_night);
                        }
                    } else {
                        this.f35342f.setImageResource(b.live_feed_page_tag_preview);
                    }
                } else {
                    gradientDrawable2.setColors(new int[]{f.e().a(this.f35341e, this.l, "color_FF3333"), f.e().a(this.f35341e, this.l, "color_FF3333")});
                    this.f35346j.setBackgroundDrawable(gradientDrawable2);
                    this.f35345i.setVisibility(0);
                }
            }
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            stopAnim();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 != 0) {
                stopAnim();
            } else if (isHasAnim()) {
                startAnim();
            } else {
                stopAnim();
            }
        }
    }

    public void setData(LiveBannerEntity liveBannerEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, liveBannerEntity) == null) {
            setVisibility(8);
            if (liveBannerEntity != null) {
                int i2 = liveBannerEntity.bannerType;
                this.m = i2;
                int i3 = liveBannerEntity.liveStatus;
                this.n = i3;
                if (i2 == 1) {
                    if (i3 == 3) {
                        this.f35347k = false;
                        this.f35342f.setVisibility(0);
                        this.f35346j.setBackgroundResource(b.live_feed_page_transparent);
                        this.f35344h.setText(this.f35341e.getResources().getString(e.live_feed_page_banner_status_back_txt));
                        this.f35344h.setPadding(c.a.w.b.f.a.a(this.f35341e, 2.0f), 0, c.a.w.b.f.a.a(this.f35341e, 4.0f), 0);
                        this.f35345i.setVisibility(8);
                    } else if (i3 == 0) {
                        this.f35347k = false;
                        this.f35342f.setVisibility(0);
                        this.f35346j.setBackgroundResource(b.live_feed_page_transparent);
                        this.f35344h.setText(this.f35341e.getResources().getString(e.live_feed_page_banner_status_preview_txt));
                        this.f35344h.setPadding(c.a.w.b.f.a.a(this.f35341e, 2.0f), 0, c.a.w.b.f.a.a(this.f35341e, 4.0f), 0);
                        this.f35345i.setVisibility(8);
                    } else {
                        this.f35347k = true;
                        this.f35342f.setVisibility(8);
                        this.f35344h.setText(this.f35341e.getResources().getString(e.live_feed_page_banner_status_living_txt));
                        this.f35344h.setPadding(0, 0, c.a.w.b.f.a.a(this.f35341e, 4.0f), 0);
                        this.f35345i.setVisibility(0);
                        this.f35345i.setText(String.format(this.f35341e.getResources().getString(e.live_feed_page_banner_status_aud_count_txt), c.a.w.b.f.e.a(this.f35341e, liveBannerEntity.audienceCount)));
                    }
                    onDarkModeChange("day");
                    setVisibility(0);
                    return;
                }
                this.f35347k = false;
                setVisibility(8);
                return;
            }
            this.f35347k = false;
            setVisibility(8);
        }
    }

    public void setIsImmersion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void startAnim() {
        LottieDrawable lottieDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f35343g == null || (lottieDrawable = this.p) == null) {
            return;
        }
        if (this.f35347k) {
            try {
                if (lottieDrawable.isAnimating() && this.f35343g.getVisibility() == 0) {
                    return;
                }
                if (this.o != null && !this.o.equals(f.e().n())) {
                    this.o = f.e().n();
                    if (this.p.isAnimating()) {
                        this.p.cancelAnimation();
                    }
                    this.f35343g.setImageDrawable(null);
                    this.p.clearComposition();
                    LottieComposition.Factory.fromAssetFileName(this.f35341e, this.q, new a(this));
                    return;
                }
                this.f35343g.setVisibility(0);
                if (this.p.isAnimating()) {
                    return;
                }
                this.p.playAnimation();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        stopAnim();
    }

    public void stopAnim() {
        LottieDrawable lottieDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f35343g == null || (lottieDrawable = this.p) == null) {
            return;
        }
        if (lottieDrawable.isAnimating()) {
            this.p.cancelAnimation();
        }
        this.f35343g.setVisibility(8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveBannerStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public LiveBannerStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f35347k = false;
        this.o = "";
        d(context);
    }
}
