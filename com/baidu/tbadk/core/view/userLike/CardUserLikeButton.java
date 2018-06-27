package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CardUserLikeButton extends EntelechyUserLikeButton {
    public CardUserLikeButton(Context context) {
        super(context);
    }

    public CardUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.e(getContext(), d.e.fontsize26));
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.azB = z;
        setVisibility(0);
        if (z) {
            setClickable(false);
            setText(this.azz);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.azA);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds8), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.azB) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, d.C0142d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.pb_user_like_add_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, d.C0142d.pb_like_user_select_color);
        am.i(this, d.f.btn_focus_border_bg);
    }
}
