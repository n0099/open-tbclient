package com.baidu.live.business;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
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
import com.baidu.tieba.ac0;
import com.baidu.tieba.j90;
import com.baidu.tieba.lb0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class Live16Ratio9TopicView extends LiveBaseItemView {
    public BannerView h;
    public LiveStatusAnimView i;
    public TextSwitcher j;
    public TextSwitcher k;
    public TextSwitcher l;
    public FrameLayout m;
    public boolean n;
    public ViewStub o;
    public View p;
    public LiveBaseLottieView q;
    public float[] r;
    public Context s;
    public LeftLableInfo t;
    public List<LiveRoomEntity> u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (Live16Ratio9TopicView.this.f != null && Live16Ratio9TopicView.this.t != null && !TextUtils.isEmpty(Live16Ratio9TopicView.this.t.cmd)) {
                Live16Ratio9TopicView.this.f.a(Live16Ratio9TopicView.this.t.cmd);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (Live16Ratio9TopicView.this.g != null) {
                Live16Ratio9TopicView.this.g.a(Live16Ratio9TopicView.this.h.getCurrentPosition());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements BannerView.i {
        public c() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public void onBannerShow(LiveBannerEntity liveBannerEntity) {
            if (Live16Ratio9TopicView.this.g != null && liveBannerEntity != null) {
                Live16Ratio9TopicView.this.g.b(Live16Ratio9TopicView.this.h.getCurrentPosition());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements BannerView.j {
        public d() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.j
        public void a(int i) {
            if (Live16Ratio9TopicView.this.u == null) {
                return;
            }
            int i2 = i + 1;
            if (i2 >= Live16Ratio9TopicView.this.u.size()) {
                i2 = 0;
            }
            Live16Ratio9TopicView.this.t((LiveRoomEntity) Live16Ratio9TopicView.this.u.get(i2), true);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ViewSwitcher.ViewFactory {
        public e() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(Live16Ratio9TopicView.this.getContext());
            textView.setLineSpacing(3.0f, 1.0f);
            textView.setMaxLines(2);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(ac0.f().a(Live16Ratio9TopicView.this.getContext(), Live16Ratio9TopicView.this.c, "color_white4"));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements ViewSwitcher.ViewFactory {
        public f() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(Live16Ratio9TopicView.this.getContext());
            textView.setMaxLines(1);
            textView.setTextSize(1, 10.0f);
            textView.setTextColor(ac0.f().a(Live16Ratio9TopicView.this.getContext(), Live16Ratio9TopicView.this.c, "color_858585"));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements ViewSwitcher.ViewFactory {
        public g() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            TextView textView = new TextView(Live16Ratio9TopicView.this.getContext());
            textView.setMaxLines(1);
            textView.setTextSize(1, 10.0f);
            textView.setTextColor(ac0.f().a(Live16Ratio9TopicView.this.getContext(), Live16Ratio9TopicView.this.c, "color_858585"));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return textView;
        }
    }

    public Live16Ratio9TopicView(Context context) {
        super(context);
        this.n = false;
        r(context);
    }

    public Live16Ratio9TopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = false;
        r(context);
    }

    private void setCoverBannerData(List<LiveRoomEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (!lb0.c(list)) {
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
        if (this.n && this.i.b()) {
            this.i.c();
        }
        View view2 = this.p;
        if (view2 != null && view2.getVisibility() == 0 && (liveBaseLottieView = this.q) != null) {
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
        LiveStatusAnimView liveStatusAnimView = this.i;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.q;
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
        LiveStatusAnimView liveStatusAnimView = this.i;
        if (liveStatusAnimView != null) {
            liveStatusAnimView.d();
        }
        LiveBaseLottieView liveBaseLottieView = this.q;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    public final void p() {
        this.h.setHasIndicator(false);
        this.h.setCanTouchScroll(false);
        this.h.setSwitchDuration(300);
        this.h.setAspectRatio(0.5625f);
        this.h.setOnBannerShowListener(new c());
        this.h.setOnBannerSwitchListener(new d());
    }

    public final void q() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.s, 17432576);
        loadAnimation.setInterpolator(new AccelerateInterpolator());
        loadAnimation.setDuration(300L);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s, 17432577);
        loadAnimation2.setInterpolator(new AccelerateInterpolator());
        loadAnimation2.setDuration(300L);
        this.k.setInAnimation(loadAnimation);
        this.k.setOutAnimation(loadAnimation2);
        this.j.setInAnimation(loadAnimation);
        this.j.setOutAnimation(loadAnimation2);
        this.l.setInAnimation(loadAnimation);
        this.l.setOutAnimation(loadAnimation2);
        this.k.setFactory(new e());
        this.j.setFactory(new f());
        this.l.setFactory(new g());
    }

    public final void r(Context context) {
        this.s = context;
        setNeedRatio(false);
        int e2 = (int) (((j90.e(context) - (j90.b(context, 12.0f) * 2)) - j90.b(context, 7.0f)) / 2.0d);
        View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0571, this);
        this.h = (BannerView) inflate.findViewById(R.id.obfuscated_res_0x7f0914c6);
        this.o = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f0914e2);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0914c7);
        this.m = frameLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = e2;
        layoutParams.height = (int) ((e2 * 9) / 16.0d);
        this.m.setLayoutParams(layoutParams);
        this.i = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f0914c8);
        this.k = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f0914ce);
        this.j = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f0914ca);
        this.l = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f0914c4);
        float b2 = j90.b(getContext(), 10.0f);
        this.r = new float[]{b2, b2, b2, b2, b2, b2, b2, b2};
        q();
        p();
        this.i.setOnClickListener(new a());
        setOnClickListener(new b());
    }

    public void s(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ac0.f().a(getContext(), this.c, "color_white2"));
        gradientDrawable.setCornerRadii(this.r);
        setBackgroundDrawable(gradientDrawable);
        BannerView bannerView = this.h;
        if (bannerView != null) {
            bannerView.u(str);
        }
        TextSwitcher textSwitcher = this.k;
        if (textSwitcher != null && textSwitcher.getCurrentView() != null) {
            ((TextView) this.k.getCurrentView()).setTextColor(ac0.f().a(getContext(), this.c, "color_white4"));
        }
        TextSwitcher textSwitcher2 = this.j;
        if (textSwitcher2 != null && textSwitcher2.getCurrentView() != null) {
            ((TextView) this.j.getCurrentView()).setTextColor(ac0.f().a(getContext(), this.c, "color_858585"));
        }
        TextSwitcher textSwitcher3 = this.l;
        if (textSwitcher3 != null && textSwitcher3.getCurrentView() != null) {
            ((TextView) this.l.getCurrentView()).setTextColor(ac0.f().a(getContext(), this.c, "color_858585"));
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        this.u = liveRoomEntity.topicRoomList;
        this.h.setScene(this.c);
        this.i.setScene(this.c);
        this.t = liveRoomEntity.leftLabel;
        setCoverBannerData(liveRoomEntity.topicRoomList);
        LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
        if (leftLableInfo != null && this.i != null && leftLableInfo.isRankTopStyle()) {
            this.i.setData(liveRoomEntity, true);
            this.n = true;
            this.i.setVisibility(0);
        } else {
            LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
            if (leftLableInfo2 != null && leftLableInfo2.canShowLabel() && (liveStatusAnimView = this.i) != null) {
                liveStatusAnimView.setData(liveRoomEntity, false);
                this.n = true;
                this.i.setVisibility(0);
            } else {
                this.n = false;
                LiveStatusAnimView liveStatusAnimView2 = this.i;
                if (liveStatusAnimView2 != null) {
                    liveStatusAnimView2.setVisibility(8);
                }
            }
        }
        t(this.u.get(this.h.getCurrentPosition()), false);
        s("day");
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        if (z) {
            View view2 = this.p;
            if (view2 == null) {
                View inflate = this.o.inflate();
                this.p = inflate;
                LiveBaseLottieView liveBaseLottieView = (LiveBaseLottieView) inflate.findViewById(R.id.obfuscated_res_0x7f0914e1);
                this.q = liveBaseLottieView;
                liveBaseLottieView.setRepeatCount(-1);
                this.q.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/android/liveshow_room_viewing.json");
            } else {
                view2.setVisibility(0);
            }
            this.q.playAnimation();
        } else if (this.p != null) {
            this.q.cancelAnimation();
            this.p.setVisibility(8);
        }
    }

    public final void t(LiveRoomEntity liveRoomEntity, boolean z) {
        if (z) {
            this.k.setText(liveRoomEntity.title);
        } else {
            this.k.setCurrentText(liveRoomEntity.title);
        }
        LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
        if (liveHostInfo != null) {
            if (z) {
                this.j.setText(liveHostInfo.name);
            } else {
                this.j.setCurrentText(liveHostInfo.name);
            }
        }
        if (liveRoomEntity.liveStatus == 0) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        if (z) {
            this.l.setText(j90.a(this.s, liveRoomEntity.audienceCount));
        } else {
            this.l.setCurrentText(j90.a(this.s, liveRoomEntity.audienceCount));
        }
    }
}
