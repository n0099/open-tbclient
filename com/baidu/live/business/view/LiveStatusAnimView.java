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
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.util.CustomTypefaceSpan;
import com.baidu.tieba.R;
import com.baidu.tieba.he0;
import com.baidu.tieba.pb0;
import com.baidu.tieba.qb0;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class LiveStatusAnimView extends FrameLayout {
    public Context a;
    public ImageView b;
    public LottieAnimationView c;
    public TextView d;
    public SimpleDraweeView e;
    public SimpleDraweeView f;
    public boolean g;
    public String h;

    public LiveStatusAnimView(@NonNull Context context) {
        this(context, null);
    }

    public void setScene(String str) {
        this.h = str;
    }

    public LiveStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
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

    public LiveStatusAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        a(context);
    }

    public final void a(Context context) {
        this.a = context;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05cd, this);
        this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09156a);
        this.c = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09156b);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09156c);
        this.c.loop(true);
        this.e = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f091560);
        this.f = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f091561);
    }

    public boolean b() {
        return this.g;
    }

    public void c() {
        LottieAnimationView lottieAnimationView = this.c;
        if (lottieAnimationView != null) {
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

    public void d() {
        LottieAnimationView lottieAnimationView = this.c;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.c.cancelAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimationView lottieAnimationView = this.c;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.c.cancelAnimation();
        }
    }

    public void setData(LiveRoomEntity liveRoomEntity, boolean z) {
        boolean z2;
        d();
        this.c.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        if (!LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.h)) {
            if (!"night".equals(he0.f().r()) && !"dark".equals(he0.f().r())) {
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
        gradientDrawable.setCornerRadius(qb0.b(this.a, 9.0f));
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        try {
            gradientDrawable.setColors(new int[]{Color.parseColor(liveRoomEntity.leftLabel.startColor), Color.parseColor(liveRoomEntity.leftLabel.endColor)});
        } catch (Exception e) {
            gradientDrawable.setColors(new int[]{Color.parseColor("#FE33BA"), Color.parseColor("#FE3355")});
            e.printStackTrace();
        }
        if ("night".equals(he0.f().r()) && LiveFeedPageSdk.HOST_LIVE_TAB.equals(this.h)) {
            gradientDrawable.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP);
        } else {
            gradientDrawable.setColorFilter(null);
        }
        setBackground(gradientDrawable);
        if (z2) {
            this.d.setPadding(0, 0, 0, 0);
        } else {
            this.d.setPadding(qb0.b(this.a, 3.0f), 0, 0, 0);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(qb0.b(this.a, 9.0f));
        int i = liveRoomEntity.liveStatus;
        if (i == 3) {
            this.g = false;
            gradientDrawable2.setColors(new int[]{he0.f().a(this.a, this.h, "color_768CAE"), he0.f().a(this.a, this.h, "color_768CAE")});
            if (!"day".equals(he0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.h)) {
                if (!"tieba".equals(LiveFeedPageSdk.getInstance().getHost()) && !LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f20);
                } else {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f1f);
                }
            } else {
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f1f);
            }
            this.b.setBackgroundDrawable(gradientDrawable2);
            this.b.setVisibility(0);
        } else if (i == 0) {
            this.g = false;
            gradientDrawable2.setColors(new int[]{he0.f().a(this.a, this.h, "color_4E6EF2"), he0.f().a(this.a, this.h, "color_4E6EF2")});
            if (!"day".equals(he0.f().r()) && !LiveFeedPageSdk.IMMERSION.equals(this.h) && !"recommend".equals(this.h) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.h)) {
                if (!"tieba".equals(LiveFeedPageSdk.getInstance().getHost()) && !LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f22);
                } else {
                    this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f21);
                }
            } else {
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f21);
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
                gradientDrawable2.setColors(new int[]{he0.f().a(this.a, this.h, "color_FF3333"), he0.f().a(this.a, this.h, "color_FF3333")});
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080f25);
                this.b.setBackgroundDrawable(gradientDrawable2);
                this.b.setVisibility(0);
            }
        }
        if (z) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) liveRoomEntity.leftLabel.prefix);
            spannableStringBuilder.append((CharSequence) liveRoomEntity.leftLabel.newText);
            spannableStringBuilder.setSpan(new CustomTypefaceSpan(pb0.b("dinalternate.ttf")), liveRoomEntity.leftLabel.prefix.length(), spannableStringBuilder.length(), 33);
            this.d.setTextColor(he0.f().a(this.a, this.h, "color_white3"));
            this.d.setText(spannableStringBuilder);
        } else {
            this.d.setTextColor(he0.f().a(this.a, this.h, "color_white3"));
            this.d.setText(liveRoomEntity.leftLabel.text);
        }
        if (!TextUtils.isEmpty(liveRoomEntity.leftLabel.rightIcon)) {
            this.f.setVisibility(0);
            this.f.setImageURI(liveRoomEntity.leftLabel.rightIcon);
        }
    }
}
