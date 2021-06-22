package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class EntelechyUserLikeButton extends CommonUserLikeButton {
    public EntelechyUserLikeButton(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.a.n0.r.f0.q.b
    public void e(boolean z, int i2) {
        this.f12659g = z;
        if (z) {
            setClickable(false);
            setText(this.f12657e);
        } else {
            setClickable(true);
            setText(this.f12658f);
        }
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void f() {
        super.f();
        setTextSize(0, l.g(getContext(), R.dimen.ds26));
        setCompoundDrawablePadding(l.g(getContext(), R.dimen.ds6));
        setGravity(5);
        setGravity(16);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i2) {
        if (this.f12659g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0109);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
    }

    public EntelechyUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EntelechyUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
