package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.h.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost YL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.YL = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.YL.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.YL.YB;
            view3.setVisibility(0);
            view4 = this.YL.YB;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.YL.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.YL.YB;
            view.setVisibility(8);
            view2 = this.YL.YB;
            view2.setClickable(false);
        }
    }
}
