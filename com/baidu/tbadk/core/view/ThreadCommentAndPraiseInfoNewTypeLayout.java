package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoNewTypeLayout extends ThreadCommentAndPraiseInfoLayout {
    public ThreadCommentAndPraiseInfoNewTypeLayout(Context context) {
        super(context);
        initSetting();
    }

    public ThreadCommentAndPraiseInfoNewTypeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initSetting();
    }

    private void initSetting() {
        setReplyTimeVisible(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
        setBarNameClickEnabled(true);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(bh bhVar) {
        super.updatePraiseNum(bhVar);
        if (this.bXh != null && this.ccw) {
            if (this.bXh.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bXh.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bXh.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bXh.bYd;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cbX;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        super.r(bhVar);
        if (this.cce != null && this.ccA) {
            this.cce.setVisibility(0);
            if (this.cce.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cce.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cbX;
                layoutParams.weight = 0.0f;
                this.cce.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        super.q(bhVar);
        if (this.cch != null && this.ccC && this.cch.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cch.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cbX;
            layoutParams.weight = 0.0f;
            this.cch.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void s(bh bhVar) {
        super.s(bhVar);
        if (this.cco != null && this.ccD) {
            this.cco.setVisibility(0);
            if (this.cco.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cco.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cbX;
                layoutParams.weight = 0.0f;
                this.cco.setLayoutParams(layoutParams);
            }
        }
    }
}
