package com.baidu.live.business.view.emotion;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.tieba.R;
import com.baidu.tieba.fd0;
import com.baidu.tieba.oa0;
/* loaded from: classes3.dex */
public class LoadingView extends LinearLayout {
    public boolean a;
    public LottieAnimationView b;

    public LoadingView(Context context) {
        super(context);
        this.a = true;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            if (this.a) {
                this.b.playAnimation();
            }
        } else {
            this.b.cancelAnimation();
        }
        super.setVisibility(i);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        b();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        b();
    }

    public void a() {
        LottieAnimationView lottieAnimationView = this.b;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    public final void b() {
        setGravity(17);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05c9, (ViewGroup) this, true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f091630);
        this.b = lottieAnimationView;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.b.cancelAnimation();
        }
    }

    public void d() {
        this.a = false;
        if (this.b.isAnimating()) {
            this.b.cancelAnimation();
        }
    }

    public void e() {
        this.a = true;
        if (getVisibility() == 0 && !this.b.isAnimating()) {
            this.b.playAnimation();
        }
    }

    public void c(String str) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = oa0.b(getContext(), LoadAnimStrategy.getInstance().loadingLottieWidth);
        layoutParams.height = oa0.b(getContext(), LoadAnimStrategy.getInstance().loadingLottieHeight);
        this.b.setLayoutParams(layoutParams);
        this.b.setImageAssetsFolder(LoadAnimStrategy.getInstance().loadingLottieImgRes);
        String j = fd0.f().j(str);
        if (TextUtils.isEmpty(j)) {
            int k = fd0.f().k(str);
            if (k != 0) {
                this.b.setAnimation(k);
                return;
            }
            return;
        }
        this.b.setAnimation(j);
    }
}
