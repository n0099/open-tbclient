package com.baidu.live.business;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.de0;
/* loaded from: classes3.dex */
public class LiveLoadMoreView extends LiveBaseItemView {
    public ViewGroup h;
    public LottieAnimationView i;
    public TextView j;

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
    }

    public LiveLoadMoreView(Context context) {
        super(context);
        f();
    }

    public void setAnimViewVisibility(int i) {
        if (i == 0) {
            this.i.playAnimation();
        } else {
            this.i.cancelAnimation();
        }
        this.i.setVisibility(i);
    }

    public void setLoadMoreLabel(int i) {
        String string = getResources().getString(i);
        if (!TextUtils.isEmpty(string)) {
            this.j.setText(string);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setScene(String str) {
        super.setScene(str);
        e();
    }

    public void setTextColor(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextSize(2, i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            this.i.playAnimation();
        } else {
            this.i.cancelAnimation();
        }
        super.setVisibility(i);
    }

    public LiveLoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        super.a();
        i();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        super.b();
        h();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        super.c();
        h();
    }

    public void d() {
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void f() {
        setMinimumHeight(1);
    }

    public final void h() {
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.i.cancelAnimation();
        }
    }

    public final void i() {
        LottieAnimationView lottieAnimationView = this.i;
        if (lottieAnimationView != null && !lottieAnimationView.isAnimating()) {
            this.i.playAnimation();
        }
    }

    public final void e() {
        boolean equals = "recommend".equals(this.c);
        int i = R.layout.obfuscated_res_0x7f0d05b3;
        if (!equals && !"baidu".equals(LiveFeedPageSdk.getInstance().getHost())) {
            if (LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                i = R.layout.obfuscated_res_0x7f0d05b4;
            } else if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                i = R.layout.obfuscated_res_0x7f0d05b5;
            } else if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                i = R.layout.obfuscated_res_0x7f0d05b6;
            }
        }
        LayoutInflater.from(getContext()).inflate(i, this);
        this.h = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091ec5);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0915f3);
        this.i = lottieAnimationView;
        lottieAnimationView.loop(true);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0915f4);
    }

    public void g(String str) {
        String g = de0.f().g(str);
        if (TextUtils.isEmpty(g)) {
            int h = de0.f().h(str);
            if (h != 0) {
                this.i.setAnimation(h);
            }
        } else {
            this.i.setAnimation(g);
        }
        this.j.setTextColor(de0.f().a(getContext(), str, "color_1F1F1F"));
    }
}
