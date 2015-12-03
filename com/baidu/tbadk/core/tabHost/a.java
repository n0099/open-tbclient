package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.h.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost Zt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.Zt = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.Zt.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.Zt.Zk;
            view3.setVisibility(0);
            view4 = this.Zt.Zk;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.Zt.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.Zt.Zk;
            view.setVisibility(8);
            view2 = this.Zt.Zk;
            view2.setClickable(false);
        }
    }
}
