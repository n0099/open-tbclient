package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.h.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost Zw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.Zw = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.Zw.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.Zw.Zm;
            view3.setVisibility(0);
            view4 = this.Zw.Zm;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.Zw.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.Zw.Zm;
            view.setVisibility(8);
            view2 = this.Zw.Zm;
            view2.setClickable(false);
        }
    }
}
