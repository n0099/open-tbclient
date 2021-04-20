package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class CardUserLikeButton extends EntelechyUserLikeButton {
    public CardUserLikeButton(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.b.h0.r.f0.q.b
    public void a(boolean z, int i) {
        this.f13300g = z;
        setVisibility(0);
        if (z) {
            setClickable(false);
            setText(this.f13298e);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.f13299f);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds8), 0);
        }
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void f() {
        super.f();
        setTextSize(0, l.g(getContext(), R.dimen.fontsize26));
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i) {
        if (this.f13300g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0110, 1, i);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(i, R.drawable.pb_user_like_add_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this, R.color.pb_like_user_select_color, 1, i);
        SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg, i);
    }

    public CardUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
