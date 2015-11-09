package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.g.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost YH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.YH = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.YH.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.YH.Yy;
            view3.setVisibility(0);
            view4 = this.YH.Yy;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.YH.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.YH.Yy;
            view.setVisibility(8);
            view2 = this.YH.Yy;
            view2.setClickable(false);
        }
    }
}
