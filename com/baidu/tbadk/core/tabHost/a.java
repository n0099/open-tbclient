package com.baidu.tbadk.core.tabHost;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.lib.h.d;
/* loaded from: classes.dex */
class a extends d {
    final /* synthetic */ FragmentTabHost aau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentTabHost fragmentTabHost) {
        this.aau = fragmentTabHost;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        Animation layerInAnimation;
        Animation layerOutAnimation;
        View view;
        View view2;
        View view3;
        View view4;
        layerInAnimation = this.aau.getLayerInAnimation();
        if (animation == layerInAnimation) {
            view3 = this.aau.aak;
            view3.setVisibility(0);
            view4 = this.aau.aak;
            view4.setClickable(true);
            return;
        }
        layerOutAnimation = this.aau.getLayerOutAnimation();
        if (animation == layerOutAnimation) {
            view = this.aau.aak;
            view.setVisibility(8);
            view2 = this.aau.aak;
            view2.setClickable(false);
        }
    }
}
