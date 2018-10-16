package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
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
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.aAO != null && this.aFc) {
            if (this.aAO.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAO.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aAO.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aAO.aBi;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aEF;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.aEL != null && this.aFg) {
            this.aEL.setVisibility(0);
            if (this.aEL.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEL.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aEF;
                layoutParams.weight = 0.0f;
                this.aEL.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.aEO != null && this.aFi && this.aEO.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEO.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aEF;
            layoutParams.weight = 0.0f;
            this.aEO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void i(bb bbVar) {
        super.i(bbVar);
        if (this.aEV != null && this.aFj) {
            this.aEV.setVisibility(0);
            if (this.aEV.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEV.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aEF;
                layoutParams.weight = 0.0f;
                this.aEV.setLayoutParams(layoutParams);
            }
        }
    }
}
