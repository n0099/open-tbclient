package com.baidu.tbadk.core.view.userLike;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbFirstFloorUserLikeButton extends EntelechyUserLikeButton {
    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.f(getContext(), d.f.fontsize26));
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        this.aox = z;
        setVisibility(0);
        if (z) {
            setClickable(false);
            setText(this.aov);
            setPadding(0, 0, 0, 0);
        } else {
            setClickable(true);
            setText(this.aow);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds8), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aox) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.pb_user_like_add_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.pb_like_user_select_color);
        aj.j(this, d.g.btn_focus_border_bg);
    }
}
