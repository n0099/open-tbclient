package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes10.dex */
public abstract class a {
    public com.baidu.live.yuyingift.a.c caU;
    protected final int cdp = EncoderTextureDrawer.X264_WIDTH;
    protected final int cdq = 440;
    protected final int cdr = 560;
    protected final int cds = 500;
    protected final int cdu = 640;
    protected final float cdv = 1.5f;
    protected final float cdw = 1.2f;
    public AnimatorSet cdx = Zz();
    protected View mTarget;

    protected abstract AnimatorSet Zz();

    public a(View view) {
        this.mTarget = view;
    }

    public void cancel() {
        if (this.cdx != null) {
            this.cdx.cancel();
        }
    }
}
