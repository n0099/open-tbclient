package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
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
        setTextSize(0, k.e(getContext(), r.e.ds26));
        setCompoundDrawablePadding(k.e(getContext(), r.e.ds6));
        setGravity(5);
        setGravity(16);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        this.ail = z;
        if (z) {
            setClickable(false);
            setText(this.aij);
        } else {
            setClickable(true);
            setText(this.aik);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.ail) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            at.j((View) this, r.d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        at.j((View) this, r.d.btn_forum_focus_color);
    }
}
