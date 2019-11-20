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
        if (this.clu != null && this.cpS) {
            if (this.clu.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clu.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.clu.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.clu.cmp;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cpt;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        super.r(bhVar);
        if (this.cpB != null && this.cpW) {
            this.cpB.setVisibility(0);
            if (this.cpB.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpB.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cpt;
                layoutParams.weight = 0.0f;
                this.cpB.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        super.q(bhVar);
        if (this.cpE != null && this.cpY && this.cpE.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpE.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cpt;
            layoutParams.weight = 0.0f;
            this.cpE.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void s(bh bhVar) {
        super.s(bhVar);
        if (this.cpL != null && this.cpZ) {
            this.cpL.setVisibility(0);
            if (this.cpL.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpL.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cpt;
                layoutParams.weight = 0.0f;
                this.cpL.setLayoutParams(layoutParams);
            }
        }
    }
}
