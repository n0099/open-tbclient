package com.baidu.live.business;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.model.data.ThirdLabelInfo;
import com.baidu.live.business.util.LiveBaseLottieView;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.tieba.R;
import com.baidu.tieba.dc0;
import com.baidu.tieba.m90;
import com.baidu.tieba.zb0;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class Live16Ratio9ItemView extends LiveBaseItemView {
    public SimpleDraweeView h;
    public LiveStatusAnimView i;
    public TextView j;
    public TextView k;
    public SimpleDraweeView l;
    public TextView m;
    public TextView n;
    public SimpleDraweeView o;
    public FrameLayout p;
    public boolean q;
    public View r;
    public TextView s;
    public SimpleDraweeView t;
    public ViewStub u;
    public View v;
    public LiveBaseLottieView w;
    public float[] x;
    public Context y;
    public boolean z;

    public Live16Ratio9ItemView(Context context) {
        super(context);
        this.q = false;
        this.z = false;
        d(context);
    }

    public Live16Ratio9ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        this.z = false;
        d(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        LiveBaseLottieView liveBaseLottieView;
        super.a();
        if (this.q && this.i.b()) {
            this.i.c();
        }
        View view2 = this.v;
        if (view2 != null && view2.getVisibility() == 0 && (liveBaseLottieView = this.w) != null) {
            liveBaseLottieView.playAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        super.b();
        LiveStatusAnimView liveStatusAnimView = this.i;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.w;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        super.c();
        LiveStatusAnimView liveStatusAnimView = this.i;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.w;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    public final void d(Context context) {
        this.y = context;
        setNeedRatio(false);
        int e = (int) (((m90.e(context) - (m90.b(context, 12.0f) * 2)) - m90.b(context, 7.0f)) / 2.0d);
        View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0579, this);
        this.h = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0914d3);
        this.u = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f0914f0);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0914d5);
        this.p = frameLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = e;
        layoutParams.height = (int) ((e * 9) / 16.0d);
        this.p.setLayoutParams(layoutParams);
        this.i = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f0914d6);
        this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914dc);
        this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914d8);
        this.l = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0914d0);
        this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914d2);
        this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0914d9);
        this.o = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0914db);
        this.r = inflate.findViewById(R.id.obfuscated_res_0x7f091548);
        this.s = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091549);
        this.t = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091550);
        float b = m90.b(getContext(), 10.0f);
        this.x = new float[]{b, b, b, b, b, b, b, b};
    }

    public void e(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(dc0.f().a(getContext(), this.c, "color_white2"));
        gradientDrawable.setCornerRadii(this.x);
        setBackgroundDrawable(gradientDrawable);
        SimpleDraweeView simpleDraweeView = this.h;
        if (simpleDraweeView != null) {
            simpleDraweeView.getHierarchy().setPlaceholderImage(dc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
            this.h.getHierarchy().setFailureImage(dc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
        }
        SimpleDraweeView simpleDraweeView2 = this.l;
        if (simpleDraweeView2 != null) {
            simpleDraweeView2.getHierarchy().setPlaceholderImage(dc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
            this.l.getHierarchy().setFailureImage(dc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(dc0.f().a(getContext(), this.c, "color_white4"));
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setTextColor(dc0.f().a(getContext(), this.c, "color_858585"));
        }
        TextView textView3 = this.m;
        if (textView3 != null) {
            textView3.setTextColor(dc0.f().a(getContext(), this.c, "color_858585"));
        }
        TextView textView4 = this.n;
        if (textView4 != null) {
            textView4.setTextColor(dc0.f().a(getContext(), this.c, "color_858585"));
        }
        TextView textView5 = this.s;
        if (textView5 != null) {
            textView5.setTextColor(dc0.f().a(getContext(), this.c, "color_white3"));
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        this.i.setScene(this.c);
        if (liveRoomEntity != null) {
            this.h.setImageURI(liveRoomEntity.cover);
            LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
            if (leftLableInfo != null && this.i != null && leftLableInfo.isRankTopStyle()) {
                this.i.setData(liveRoomEntity, true);
                this.q = true;
                this.i.setVisibility(0);
            } else {
                LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                if (leftLableInfo2 != null && leftLableInfo2.canShowLabel() && (liveStatusAnimView = this.i) != null) {
                    liveStatusAnimView.setData(liveRoomEntity, false);
                    this.q = true;
                    this.i.setVisibility(0);
                } else {
                    this.q = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.i;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
            }
            zb0.h(this.k, 1, 14.0f);
            this.k.setText(liveRoomEntity.title);
            zb0.h(this.j, 1, 10.0f);
            LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
            if (liveHostInfo != null) {
                this.j.setText(liveHostInfo.name);
                LiveFeedConfig liveFeedConfig = this.d;
                if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.otherNewStyle) {
                    this.z = true;
                }
                if (this.z) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                    this.l.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
            }
            zb0.h(this.m, 1, 10.0f);
            zb0.h(this.n, 1, 10.0f);
            if (liveRoomEntity.liveStatus == 0) {
                this.m.setVisibility(8);
                this.n.setVisibility(0);
                this.n.setText(liveRoomEntity.formatReserveStartTime());
            } else {
                this.m.setText(m90.a(this.y, liveRoomEntity.audienceCount));
                this.m.setVisibility(0);
                this.n.setVisibility(8);
            }
            RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
            if (rightLableInfo != null && rightLableInfo.canShowLabel()) {
                this.o.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
            if (LiveFeedPageSdk.IMMERSION.equals(this.c) || "recommend".equals(this.c) || LiveFeedPageSdk.VIDEO_BAR.equals(this.c)) {
                this.h.getHierarchy().setUseGlobalColorFilter(false);
                this.l.getHierarchy().setUseGlobalColorFilter(false);
                this.o.getHierarchy().setUseGlobalColorFilter(false);
                this.t.getHierarchy().setUseGlobalColorFilter(false);
            }
            ThirdLabelInfo thirdLabelInfo = liveRoomEntity.thirdLabel;
            if (thirdLabelInfo != null && thirdLabelInfo.canShowLabel()) {
                this.r.setVisibility(0);
                this.s.setText(liveRoomEntity.thirdLabel.text);
                if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.iconUrl)) {
                    this.t.setImageURI(liveRoomEntity.thirdLabel.iconUrl);
                    this.t.setVisibility(0);
                } else {
                    this.t.setVisibility(8);
                }
                if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.startColor) && !TextUtils.isEmpty(liveRoomEntity.thirdLabel.endColor)) {
                    try {
                        ((GradientDrawable) this.r.getBackground()).setColors(new int[]{Color.parseColor(liveRoomEntity.thirdLabel.startColor), Color.parseColor(liveRoomEntity.thirdLabel.endColor)});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                this.r.setVisibility(8);
            }
            e("day");
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        if (z) {
            View view2 = this.v;
            if (view2 == null) {
                View inflate = this.u.inflate();
                this.v = inflate;
                LiveBaseLottieView liveBaseLottieView = (LiveBaseLottieView) inflate.findViewById(R.id.obfuscated_res_0x7f0914ef);
                this.w = liveBaseLottieView;
                liveBaseLottieView.setRepeatCount(-1);
                this.w.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/android/liveshow_room_viewing.json");
            } else {
                view2.setVisibility(0);
            }
            this.w.playAnimation();
        } else if (this.v != null) {
            this.w.cancelAnimation();
            this.v.setVisibility(8);
        }
    }
}
