package com.baidu.live.business;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
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
import com.baidu.tieba.g60;
import com.baidu.tieba.t80;
import com.baidu.tieba.x80;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class Live4Ratio5ItemView extends LiveBaseItemView {
    public SimpleDraweeView h;
    public SimpleDraweeView i;
    public LiveStatusAnimView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public SimpleDraweeView o;
    public ViewStub p;
    public View q;
    public LiveBaseLottieView r;
    public boolean s;
    public View t;
    public View u;
    public TextView v;
    public SimpleDraweeView w;
    public boolean x;
    public Context y;

    public Live4Ratio5ItemView(Context context) {
        super(context);
        this.s = false;
        this.x = false;
        d(context);
    }

    public Live4Ratio5ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = false;
        this.x = false;
        d(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        LiveBaseLottieView liveBaseLottieView;
        super.a();
        if (this.s && this.j.b()) {
            this.j.c();
        }
        View view2 = this.q;
        if (view2 != null && view2.getVisibility() == 0 && (liveBaseLottieView = this.r) != null) {
            liveBaseLottieView.playAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        super.b();
        LiveStatusAnimView liveStatusAnimView = this.j;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.r;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        super.c();
        LiveStatusAnimView liveStatusAnimView = this.j;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.r;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    public final void d(Context context) {
        setNeedRatio(true);
        setAspectRatio(1.25f);
        this.y = context;
        View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d05f2, this);
        this.h = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f09163e);
        this.p = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f09165b);
        this.j = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f091642);
        this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091647);
        this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09163a);
        this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091644);
        this.i = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f09163b);
        this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091643);
        this.o = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091646);
        this.t = inflate.findViewById(R.id.obfuscated_res_0x7f091630);
        this.u = inflate.findViewById(R.id.obfuscated_res_0x7f0916b6);
        this.v = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916b7);
        this.w = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0916be);
    }

    public void e(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(x80.f().a(getContext(), this.c, "color_white2"));
        gradientDrawable.setCornerRadius(g60.b(getContext(), 10.0f));
        setBackgroundDrawable(gradientDrawable);
        SimpleDraweeView simpleDraweeView = this.h;
        if (simpleDraweeView != null) {
            simpleDraweeView.getHierarchy().setPlaceholderImage(x80.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
            this.h.getHierarchy().setFailureImage(x80.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
        }
        SimpleDraweeView simpleDraweeView2 = this.i;
        if (simpleDraweeView2 != null) {
            simpleDraweeView2.getHierarchy().setPlaceholderImage(x80.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
            this.i.getHierarchy().setFailureImage(x80.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
        TextView textView3 = this.l;
        if (textView3 != null) {
            textView3.setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
        TextView textView4 = this.m;
        if (textView4 != null) {
            textView4.setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
        TextView textView5 = this.v;
        if (textView5 != null) {
            textView5.setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        this.j.setScene(this.c);
        if (liveRoomEntity != null) {
            this.h.setImageURI(liveRoomEntity.cover);
            LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
            if (leftLableInfo != null && this.j != null && leftLableInfo.isRankTopStyle()) {
                this.j.setData(liveRoomEntity, true);
                this.s = true;
                this.j.setVisibility(0);
            } else {
                LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                if (leftLableInfo2 != null && leftLableInfo2.canShowLabel() && (liveStatusAnimView = this.j) != null) {
                    liveStatusAnimView.setData(liveRoomEntity, false);
                    this.s = true;
                    this.j.setVisibility(0);
                } else {
                    this.s = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.j;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
            }
            t80.h(this.k, 1, 14.0f);
            this.k.setText(liveRoomEntity.title);
            t80.h(this.n, 1, 14.0f);
            LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
            if (liveHostInfo != null) {
                this.n.setText(liveHostInfo.name);
                this.i.setImageURI(liveRoomEntity.hostInfo.avatar);
            }
            t80.h(this.l, 1, 10.0f);
            t80.h(this.m, 1, 10.0f);
            if (liveRoomEntity.liveStatus == 0) {
                this.l.setVisibility(8);
                this.m.setVisibility(0);
                this.m.setText(liveRoomEntity.formatReserveStartTime());
            } else {
                this.l.setText(g60.a(this.y, liveRoomEntity.audienceCount));
                this.l.setVisibility(0);
                this.m.setVisibility(8);
            }
            this.t.getLayoutParams().height = g60.b(getContext(), 61.0f);
            this.t.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f6c));
            LiveFeedConfig liveFeedConfig = this.d;
            if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.otherNewStyle) {
                this.x = true;
            }
            if (liveRoomEntity.showTpl == 1) {
                if (this.x) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                }
                this.k.setVisibility(0);
                this.n.setTypeface(Typeface.defaultFromStyle(0));
            } else {
                this.i.setVisibility(8);
                this.k.setVisibility(8);
                this.n.setTypeface(Typeface.defaultFromStyle(1));
                this.t.getLayoutParams().height = g60.b(getContext(), 35.0f);
                this.t.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f66));
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
                this.i.getHierarchy().setUseGlobalColorFilter(false);
                this.o.getHierarchy().setUseGlobalColorFilter(false);
                this.w.getHierarchy().setUseGlobalColorFilter(false);
            }
            ThirdLabelInfo thirdLabelInfo = liveRoomEntity.thirdLabel;
            if (thirdLabelInfo != null && thirdLabelInfo.canShowLabel()) {
                this.u.setVisibility(0);
                this.v.setText(liveRoomEntity.thirdLabel.text);
                if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.iconUrl)) {
                    this.w.setImageURI(liveRoomEntity.thirdLabel.iconUrl);
                    this.w.setVisibility(0);
                } else {
                    this.w.setVisibility(8);
                }
                if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.startColor) && !TextUtils.isEmpty(liveRoomEntity.thirdLabel.endColor)) {
                    try {
                        ((GradientDrawable) this.u.getBackground()).setColors(new int[]{Color.parseColor(liveRoomEntity.thirdLabel.startColor), Color.parseColor(liveRoomEntity.thirdLabel.endColor)});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                this.u.setVisibility(8);
            }
            e("day");
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        if (z) {
            View view2 = this.q;
            if (view2 == null) {
                View inflate = this.p.inflate();
                this.q = inflate;
                LiveBaseLottieView liveBaseLottieView = (LiveBaseLottieView) inflate.findViewById(R.id.obfuscated_res_0x7f09165a);
                this.r = liveBaseLottieView;
                liveBaseLottieView.setRepeatCount(-1);
                this.r.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/android/liveshow_room_viewing.json");
            } else {
                view2.setVisibility(0);
            }
            this.r.playAnimation();
        } else if (this.q != null) {
            this.r.cancelAnimation();
            this.q.setVisibility(8);
        }
    }
}
