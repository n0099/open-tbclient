package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.h.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost YQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.YQ = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.YQ.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.YQ.YG;
            view3.setVisibility(0);
            view4 = this.YQ.YG;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.YQ.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.YQ.YG;
            view.setVisibility(8);
            view2 = this.YQ.YG;
            view2.setClickable(false);
        }
    }
}
