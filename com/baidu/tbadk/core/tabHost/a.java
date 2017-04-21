package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.g.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost adI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.adI = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.adI.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.adI.ady;
            view3.setVisibility(0);
            view4 = this.adI.ady;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.adI.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.adI.ady;
            view.setVisibility(8);
            view2 = this.adI.ady;
            view2.setClickable(false);
        }
    }
}
