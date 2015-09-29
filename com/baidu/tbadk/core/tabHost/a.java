package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.g.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost YB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.YB = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.YB.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.YB.Ys;
            view3.setVisibility(0);
            view4 = this.YB.Ys;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.YB.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.YB.Ys;
            view.setVisibility(8);
            view2 = this.YB.Ys;
            view2.setClickable(false);
        }
    }
}
