package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class CardUserLikeButton extends EntelechyUserLikeButton {
    public CardUserLikeButton(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.a.i0.r.f0.q.b
    public void e(boolean z, int i2) {
        this.f13271g = z;
        setVisibility(0);
        if (z) {
            setClickable(false);
            setText(this.f13269e);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.f13270f);
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
    public void g(int i2) {
        if (this.f13271g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0110, 1, i2);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(i2, R.drawable.pb_user_like_add_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this, R.color.pb_like_user_select_color, 1, i2);
        SkinManager.setBackgroundResource(this, R.drawable.btn_focus_border_bg, i2);
    }

    public CardUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardUserLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
