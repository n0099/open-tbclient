package com.baidu.sapi2.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.d.a.a;
/* loaded from: classes2.dex */
public class SweepLightLoadingView extends FrameLayout {
    private View rootView;
    private View sweepIV;
    private ObjectAnimator translationX;

    public SweepLightLoadingView(Context context) {
        super(context);
        this.rootView = LayoutInflater.from(context).inflate(a.f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.sweepIV = this.rootView.findViewById(a.e.sweep_iv);
    }

    @TargetApi(11)
    private void startAnim() {
        stopAnim();
        new ObjectAnimator();
        this.translationX = ObjectAnimator.ofFloat(this.sweepIV, "translationX", -300.0f, 300.0f);
        this.translationX.setDuration(1000L);
        this.translationX.setRepeatMode(1);
        this.translationX.setRepeatCount(Integer.MAX_VALUE);
        this.translationX.start();
    }

    @TargetApi(11)
    private void stopAnim() {
        if (this.translationX != null && this.translationX.isRunning()) {
            this.translationX.end();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            startAnim();
        } else {
            stopAnim();
        }
        super.setVisibility(i);
    }
}
