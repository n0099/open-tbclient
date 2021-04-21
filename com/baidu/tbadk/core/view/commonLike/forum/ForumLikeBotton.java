package com.baidu.tbadk.core.view.commonLike.forum;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonLike.CommonLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ForumLikeBotton extends CommonLikeButton {
    public ForumLikeBotton(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.CommonLikeButton
    public void g(int i) {
        if (this.f13285g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.btn_forum_focus_gray_color);
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
        SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public ForumLikeBotton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForumLikeBotton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
