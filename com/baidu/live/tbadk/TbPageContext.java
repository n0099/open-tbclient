package com.baidu.live.tbadk;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.tbadk.core.BDLayoutMode;
/* loaded from: classes2.dex */
public interface TbPageContext<T> extends BdPageContext<T> {
    BDLayoutMode getLayoutMode();

    void showToast(int i);

    void showToast(int i, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener);
}
