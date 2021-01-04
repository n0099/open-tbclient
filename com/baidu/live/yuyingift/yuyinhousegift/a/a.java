package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes11.dex */
public abstract class a {
    public com.baidu.live.yuyingift.a.c cae;
    protected View mTarget;
    protected final int ccy = EncoderTextureDrawer.X264_WIDTH;
    protected final int ccz = 440;
    protected final int ccA = 560;
    protected final int ccB = 500;
    protected final int ccC = 640;
    protected final float ccD = 1.5f;
    protected final float ccE = 1.2f;
    public AnimatorSet ccF = aby();

    protected abstract AnimatorSet aby();

    public a(View view) {
        this.mTarget = view;
    }

    public void cancel() {
        if (this.ccF != null) {
            this.ccF.cancel();
        }
    }
}
