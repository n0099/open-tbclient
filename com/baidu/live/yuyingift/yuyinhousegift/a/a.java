package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes11.dex */
public abstract class a {
    public com.baidu.live.yuyingift.a.c bZu;
    protected final int cbN = EncoderTextureDrawer.X264_WIDTH;
    protected final int cbO = 440;
    protected final int cbP = 560;
    protected final int cbQ = 500;
    protected final int cbR = 640;
    protected final float cbS = 1.5f;
    protected final float cbT = 1.2f;
    public AnimatorSet cbU = Zw();
    protected View mTarget;

    protected abstract AnimatorSet Zw();

    public a(View view) {
        this.mTarget = view;
    }

    public void cancel() {
        if (this.cbU != null) {
            this.cbU.cancel();
        }
    }
}
