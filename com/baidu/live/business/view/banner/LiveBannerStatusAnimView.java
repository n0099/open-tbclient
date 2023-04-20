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
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.bc0;
import com.baidu.tieba.k90;
/* loaded from: classes2.dex */
public class LiveBannerStatusAnimView extends FrameLayout {
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
        public a() {
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(@Nullable LottieComposition lottieComposition) {
            LiveBannerStatusAnimView.this.l.setComposition(lottieComposition);
            LiveBannerStatusAnimView.this.l.playAnimation();
            LiveBannerStatusAnimView.this.c.setImageDrawable(LiveBannerStatusAnimView.this.l);
            LiveBannerStatusAnimView.this.c.setVisibility(0);
        }
    }

    public LiveBannerStatusAnimView(@NonNull Context context) {
        this(context, null);
    }

    public void setScene(String str) {
        this.h = str;
    }

    public LiveBannerStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
        if (i != 0) {
            h();
        } else if (e()) {
            g();
        } else {
            h();
        }
    }

    public LiveBannerStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        this.k = "";
        d(context);
    }

    public final void c() {
        if (!LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h)) {
            if (!LiveFeedPageSdk.UI_MODE_NIGHT.equals(bc0.f().r()) && !"dark".equals(bc0.f().r())) {
                this.m = "live_feed_page_tag_live_ani.json";
                return;
            } else {
                this.m = "live_feed_page_tag_live_night.json";
                return;
            }
        }
        this.m = "live_feed_page_tag_live_ani.json";
    }

    public final void d(Context context) {
        this.a = context;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0576, this);
        this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914d9);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914da);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0914db);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0914d8);
        this.f = findViewById(R.id.obfuscated_res_0x7f0914b9);
        this.l = new LottieDrawable();
        c();
        this.l.loop(true);
    }

    public boolean e() {
        return this.g;
    }

    public void h() {
        LottieDrawable lottieDrawable;
        if (this.c != null && (lottieDrawable = this.l) != null) {
            if (lottieDrawable.isAnimating()) {
                this.l.cancelAnimation();
            }
            this.c.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void f(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(bc0.f().a(this.a, this.h, "color_white3"));
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setTextColor(bc0.f().a(this.a, this.h, "color_white3"));
        }
        if (this.b != null && this.f != null && this.e != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(k90.b(this.a, 9.0f));
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{Color.parseColor("#4D000000"), Color.parseColor("#4D000000")});
            setBackground(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(k90.b(this.a, 9.0f));
            if (this.i == 1) {
                int i = this.j;
                if (i == 3) {
                    gradientDrawable2.setColors(new int[]{bc0.f().a(this.a, this.h, "color_768CAE"), bc0.f().a(this.a, this.h, "color_768CAE")});
                    this.b.setBackgroundDrawable(gradientDrawable2);
                    if (!"day".equals(bc0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h)) {
                        if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d79);
                        } else {
                            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d7a);
                        }
                    } else {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d79);
                    }
                } else if (i == 0) {
                    gradientDrawable2.setColors(new int[]{bc0.f().a(this.a, this.h, "color_4E6EF2"), bc0.f().a(this.a, this.h, "color_4E6EF2")});
                    this.b.setBackgroundDrawable(gradientDrawable2);
                    if (!"day".equals(bc0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h)) {
                        if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d7b);
                        } else {
                            this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d7c);
                        }
                    } else {
                        this.b.setImageResource(R.drawable.obfuscated_res_0x7f080d7b);
                    }
                } else {
                    gradientDrawable2.setColors(new int[]{bc0.f().a(this.a, this.h, "color_FF3333"), bc0.f().a(this.a, this.h, "color_FF3333")});
                    this.f.setBackgroundDrawable(gradientDrawable2);
                    this.e.setVisibility(0);
                }
            }
            c();
        }
    }

    public void g() {
        LottieDrawable lottieDrawable;
        if (this.c != null && (lottieDrawable = this.l) != null) {
            if (this.g) {
                try {
                    if (lottieDrawable.isAnimating() && this.c.getVisibility() == 0) {
                        return;
                    }
                    if (this.k != null && !this.k.equals(bc0.f().r())) {
                        this.k = bc0.f().r();
                        if (this.l.isAnimating()) {
                            this.l.cancelAnimation();
                        }
                        this.c.setImageDrawable(null);
                        this.l.clearComposition();
                        LottieComposition.Factory.fromAssetFileName(this.a, this.m, new a());
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

    public void setData(LiveBannerEntity liveBannerEntity) {
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
                    this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d7f);
                    this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0abb));
                    this.d.setPadding(k90.b(this.a, 2.0f), 0, k90.b(this.a, 4.0f), 0);
                    this.e.setVisibility(8);
                } else if (i2 == 0) {
                    this.g = false;
                    this.b.setVisibility(0);
                    this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d7f);
                    this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0abd));
                    this.d.setPadding(k90.b(this.a, 2.0f), 0, k90.b(this.a, 4.0f), 0);
                    this.e.setVisibility(8);
                } else {
                    this.g = true;
                    this.b.setVisibility(8);
                    this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0abc));
                    this.d.setPadding(0, 0, k90.b(this.a, 4.0f), 0);
                    this.e.setVisibility(0);
                    this.e.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0aba), k90.a(this.a, liveBannerEntity.audienceCount)));
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
