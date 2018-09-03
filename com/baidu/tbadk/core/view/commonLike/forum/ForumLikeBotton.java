package com.baidu.tbadk.core.view.commonLike.forum;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonLike.CommonLikeButton;
import com.baidu.tieba.f;
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
        if (this.azk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, f.d.btn_forum_focus_gray_color);
            am.i(this, f.C0146f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, f.d.btn_forum_focus_color);
        am.i(this, f.C0146f.btn_transparent_focus_border_bg);
    }
}
