package com.baidu.live.business;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.util.LiveBaseLottieView;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.tieba.R;
import com.baidu.tieba.g60;
import com.baidu.tieba.i80;
import com.baidu.tieba.x80;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class Live4Ratio5TopicView extends LiveBaseItemView {
    public BannerView h;
    public SimpleDraweeView i;
    public LiveStatusAnimView j;
    public TextSwitcher k;
    public TextSwitcher l;
    public TextSwitcher m;
    public ViewStub n;
    public View o;
    public LiveBaseLottieView p;
    public boolean q;
    public View r;
    public Context s;
    public LeftLableInfo t;
    public List<LiveRoomEntity> u;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (Live4Ratio5TopicView.this.f != null && Live4Ratio5TopicView.this.t != null && !TextUtils.isEmpty(Live4Ratio5TopicView.this.t.cmd)) {
                Live4Ratio5TopicView.this.f.a(Live4Ratio5TopicView.this.t.cmd);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (Live4Ratio5TopicView.this.g != null) {
                Live4Ratio5TopicView.this.g.a(Live4Ratio5TopicView.this.h.getCurrentPosition());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BannerView.i {
        public c() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public void onBannerShow(LiveBannerEntity liveBannerEntity) {
            if (Live4Ratio5TopicView.this.g != null && liveBannerEntity != null) {
                Live4Ratio5TopicView.this.g.b(Live4Ratio5TopicView.this.h.getCurrentPosition());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BannerView.j {
        public d() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.j
        public void a(int i) {
            if (Live4Ratio5TopicView.this.u == null) {
                return;
            }
            int i2 = i + 1;
            if (i2 >= Live4Ratio5TopicView.this.u.size()) {
                i2 = 0;
            }
            Live4Ratio5TopicView.this.u((LiveRoomEntity) Live4Ratio5TopicView.this.u.get(i2), true);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ViewSwitcher.ViewFactory {
        public e() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(Live4Ratio5TopicView.this.getContext());
            textView.setMaxLines(1);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(x80.f().a(Live4Ratio5TopicView.this.getContext(), Live4Ratio5TopicView.this.c, "color_white3"));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ViewSwitcher.ViewFactory {
        public f() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(Live4Ratio5TopicView.this.getContext());
            textView.setMaxLines(1);
            textView.setTextSize(1, 14.0f);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextColor(x80.f().a(Live4Ratio5TopicView.this.getContext(), Live4Ratio5TopicView.this.c, "color_white3"));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ViewSwitcher.ViewFactory {
        public g() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(Live4Ratio5TopicView.this.getContext());
            textView.setMaxLines(1);
            textView.setTextSize(1, 10.0f);
            textView.setTextColor(x80.f().a(Live4Ratio5TopicView.this.getContext(), Live4Ratio5TopicView.this.c, "color_white3"));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    public Live4Ratio5TopicView(Context context) {
        super(context);
        this.q = false;
        s(context);
    }

    public Live4Ratio5TopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = false;
        s(context);
    }

    private void setCoverBannerData(List<LiveRoomEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (!i80.c(list)) {
            for (LiveRoomEntity liveRoomEntity : list) {
                LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                liveBannerEntity.pic = liveRoomEntity.cover;
                liveBannerEntity.liveStatus = liveRoomEntity.liveStatus;
                liveBannerEntity.roomEntity = liveRoomEntity;
                arrayList.add(liveBannerEntity);
            }
        }
        if (this.h.r(arrayList)) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.mBannerList = arrayList;
            bannerEntity.mBroadcastInterval = 2000;
            this.h.setBannerEntity(bannerEntity);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        LiveBaseLottieView liveBaseLottieView;
        super.a();
        BannerView bannerView = this.h;
        if (bannerView != null) {
            bannerView.x();
        }
        if (this.q && this.j.b()) {
            this.j.c();
        }
        View view2 = this.o;
        if (view2 != null && view2.getVisibility() == 0 && (liveBaseLottieView = this.p) != null) {
            liveBaseLottieView.playAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        super.b();
        BannerView bannerView = this.h;
        if (bannerView != null) {
            bannerView.w();
        }
        LiveStatusAnimView liveStatusAnimView = this.j;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.p;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        super.c();
        BannerView bannerView = this.h;
        if (bannerView != null) {
            bannerView.w();
        }
        LiveStatusAnimView liveStatusAnimView = this.j;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.p;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    public final void q() {
        this.h.setHasIndicator(false);
        this.h.setCanTouchScroll(false);
        this.h.setSwitchDuration(300);
        this.h.setAspectRatio(1.25f);
        this.h.setOnBannerShowListener(new c());
        this.h.setOnBannerSwitchListener(new d());
    }

    public final void r() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.s, 17432576);
        loadAnimation.setDuration(300L);
        loadAnimation.setInterpolator(new AccelerateInterpolator());
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s, 17432577);
        loadAnimation2.setDuration(300L);
        loadAnimation2.setInterpolator(new AccelerateInterpolator());
        this.k.setInAnimation(loadAnimation);
        this.k.setOutAnimation(loadAnimation2);
        this.m.setInAnimation(loadAnimation);
        this.m.setOutAnimation(loadAnimation2);
        this.l.setInAnimation(loadAnimation);
        this.l.setOutAnimation(loadAnimation2);
        this.k.setFactory(new e());
        this.m.setFactory(new f());
        this.l.setFactory(new g());
    }

    public final void s(Context context) {
        setNeedRatio(true);
        setAspectRatio(1.25f);
        this.s = context;
        View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d05f3, this);
        this.h = (BannerView) inflate.findViewById(R.id.obfuscated_res_0x7f091657);
        this.n = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f09165a);
        this.j = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f091641);
        this.k = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f091646);
        this.l = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f091639);
        this.i = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f09163a);
        this.m = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f091642);
        View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f09162f);
        this.r = findViewById;
        findViewById.getLayoutParams().height = g60.b(getContext(), 35.0f);
        this.r.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080f66, null));
        r();
        q();
        this.j.setOnClickListener(new a());
        setOnClickListener(new b());
    }

    public void t(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(x80.f().a(getContext(), this.c, "color_white2"));
        gradientDrawable.setCornerRadius(g60.b(getContext(), 10.0f));
        setBackgroundDrawable(gradientDrawable);
        BannerView bannerView = this.h;
        if (bannerView != null) {
            bannerView.u(str);
        }
        SimpleDraweeView simpleDraweeView = this.i;
        if (simpleDraweeView != null) {
            simpleDraweeView.getHierarchy().setPlaceholderImage(x80.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
        }
        TextSwitcher textSwitcher = this.k;
        if (textSwitcher != null && textSwitcher.getCurrentView() != null) {
            ((TextView) this.k.getCurrentView()).setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
        TextSwitcher textSwitcher2 = this.m;
        if (textSwitcher2 != null && textSwitcher2.getCurrentView() != null) {
            ((TextView) this.m.getCurrentView()).setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
        TextSwitcher textSwitcher3 = this.l;
        if (textSwitcher3 != null && textSwitcher3.getCurrentView() != null) {
            ((TextView) this.l.getCurrentView()).setTextColor(x80.f().a(getContext(), this.c, "color_white3"));
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        if (liveRoomEntity == null) {
            return;
        }
        this.u = liveRoomEntity.topicRoomList;
        this.h.setScene(this.c);
        this.j.setScene(this.c);
        this.t = liveRoomEntity.leftLabel;
        setCoverBannerData(liveRoomEntity.topicRoomList);
        LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
        if (leftLableInfo != null && this.j != null && leftLableInfo.isRankTopStyle()) {
            this.j.setData(liveRoomEntity, true);
            this.q = true;
            this.j.setVisibility(0);
        } else {
            LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
            if (leftLableInfo2 != null && leftLableInfo2.canShowLabel() && (liveStatusAnimView = this.j) != null) {
                liveStatusAnimView.setData(liveRoomEntity, false);
                this.q = true;
                this.j.setVisibility(0);
            } else {
                this.q = false;
                LiveStatusAnimView liveStatusAnimView2 = this.j;
                if (liveStatusAnimView2 != null) {
                    liveStatusAnimView2.setVisibility(8);
                }
            }
        }
        u(this.u.get(this.h.getCurrentPosition()), false);
        t("day");
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        if (z) {
            View view2 = this.o;
            if (view2 == null) {
                View inflate = this.n.inflate();
                this.o = inflate;
                LiveBaseLottieView liveBaseLottieView = (LiveBaseLottieView) inflate.findViewById(R.id.obfuscated_res_0x7f091659);
                this.p = liveBaseLottieView;
                liveBaseLottieView.setRepeatCount(-1);
                this.p.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/android/liveshow_room_viewing.json");
            } else {
                view2.setVisibility(0);
            }
            this.p.playAnimation();
        } else if (this.o != null) {
            this.p.cancelAnimation();
            this.o.setVisibility(8);
        }
    }

    public final void u(LiveRoomEntity liveRoomEntity, boolean z) {
        LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
        if (liveHostInfo != null) {
            if (z) {
                this.m.setText(liveHostInfo.name);
            } else {
                this.m.setCurrentText(liveHostInfo.name);
            }
        }
        if (liveRoomEntity.liveStatus == 0) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        if (z) {
            this.l.setText(g60.a(this.s, liveRoomEntity.audienceCount));
        } else {
            this.l.setCurrentText(g60.a(this.s, liveRoomEntity.audienceCount));
        }
    }
}
