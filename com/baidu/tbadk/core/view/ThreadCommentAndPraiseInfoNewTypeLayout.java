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
        if (this.bWo != null && this.cbC) {
            if (this.bWo.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWo.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bWo.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bWo.bXk;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cbe;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        super.q(bhVar);
        if (this.cbl != null && this.cbG) {
            this.cbl.setVisibility(0);
            if (this.cbl.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbl.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cbe;
                layoutParams.weight = 0.0f;
                this.cbl.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bh bhVar) {
        super.p(bhVar);
        if (this.cbo != null && this.cbI && this.cbo.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbo.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cbe;
            layoutParams.weight = 0.0f;
            this.cbo.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        super.r(bhVar);
        if (this.cbv != null && this.cbJ) {
            this.cbv.setVisibility(0);
            if (this.cbv.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbv.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cbe;
                layoutParams.weight = 0.0f;
                this.cbv.setLayoutParams(layoutParams);
            }
        }
    }
}
