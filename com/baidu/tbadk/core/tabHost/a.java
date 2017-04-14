package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.g.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost adH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.adH = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.adH.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.adH.adx;
            view3.setVisibility(0);
            view4 = this.adH.adx;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.adH.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.adH.adx;
            view.setVisibility(8);
            view2 = this.adH.adx;
            view2.setClickable(false);
        }
    }
}
