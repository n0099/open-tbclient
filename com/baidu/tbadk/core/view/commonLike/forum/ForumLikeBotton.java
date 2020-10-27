package com.baidu.tbadk.core.view.commonLike.forum;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonLike.CommonLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ForumLikeBotton extends CommonLikeButton {
    public ForumLikeBotton(Context context) {
        super(context);
    }

    public ForumLikeBotton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForumLikeBotton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.commonLike.CommonLikeButton
    public void onChangeSkinType(int i) {
        if (this.eTI) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this, R.color.btn_forum_focus_gray_color);
            ap.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }
}
