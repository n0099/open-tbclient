package com.baidu.tbadk;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
/* loaded from: classes4.dex */
public interface TbPageContext<T> extends BdPageContext<T> {
    BDLayoutMode getLayoutMode();

    void showToast(int i);

    void showToast(int i, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener);
}
