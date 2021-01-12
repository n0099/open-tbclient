package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes10.dex */
public abstract class a {
    public com.baidu.live.yuyingift.a.c bVs;
    protected final int bXK = EncoderTextureDrawer.X264_WIDTH;
    protected final int bXL = 440;
    protected final int bXM = 560;
    protected final int bXN = 500;
    protected final int bXO = 640;
    protected final float bXP = 1.5f;
    protected final float bXQ = 1.2f;
    public AnimatorSet bXR = XG();
    protected View mTarget;

    protected abstract AnimatorSet XG();

    public a(View view) {
        this.mTarget = view;
    }

    public void cancel() {
        if (this.bXR != null) {
            this.bXR.cancel();
        }
    }
}
