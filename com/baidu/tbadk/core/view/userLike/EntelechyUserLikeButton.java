package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class EntelechyUserLikeButton extends CommonUserLikeButton {
    public EntelechyUserLikeButton(Context context) {
        super(context);
    }

    public EntelechyUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EntelechyUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, k.g(getContext(), w.f.ds26));
        setCompoundDrawablePadding(k.g(getContext(), w.f.ds6));
        setGravity(5);
        setGravity(16);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aP(boolean z) {
        this.anL = z;
        if (z) {
            setClickable(false);
            setText(this.anJ);
        } else {
            setClickable(true);
            setText(this.anK);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.anL) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            as.i(this, w.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        as.i(this, w.e.btn_forum_focus_color);
    }
}
