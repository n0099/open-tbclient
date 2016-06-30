package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.h.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost Vp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.Vp = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.Vp.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.Vp.Vf;
            view3.setVisibility(0);
            view4 = this.Vp.Vf;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.Vp.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.Vp.Vf;
            view.setVisibility(8);
            view2 = this.Vp.Vf;
            view2.setClickable(false);
        }
    }
}
