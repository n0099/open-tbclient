package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
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
        setTextSize(0, l.e(getContext(), d.e.ds26));
        setCompoundDrawablePadding(l.e(getContext(), d.e.ds6));
        setGravity(5);
        setGravity(16);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.ayJ = z;
        if (z) {
            setClickable(false);
            setText(this.ayH);
        } else {
            setClickable(true);
            setText(this.ayI);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.ayJ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, d.C0141d.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, d.C0141d.btn_forum_focus_color);
    }
}
