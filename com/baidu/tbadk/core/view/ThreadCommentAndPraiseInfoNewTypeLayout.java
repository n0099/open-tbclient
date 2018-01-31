package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
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
    public void updatePraiseNum(bd bdVar) {
        super.updatePraiseNum(bdVar);
        if (this.bbv != null && this.bbL) {
            if (this.bbv.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbv.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bbv.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bbu.getLayoutParams();
            layoutParams2.leftMargin = this.bbq;
            this.bbu.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.bby != null && this.bbR) {
            this.bby.setVisibility(0);
            if (this.bby.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bby.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bbq;
                layoutParams.weight = 0.0f;
                this.bby.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.bbB != null && this.bbT && this.bbB.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbB.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bbq;
            layoutParams.weight = 0.0f;
            this.bbB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bd bdVar) {
        super.g(bdVar);
        if (this.bbI != null && this.bbU) {
            this.bbI.setVisibility(0);
            if (this.bbI.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbI.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bbq;
                layoutParams.weight = 0.0f;
                this.bbI.setLayoutParams(layoutParams);
            }
        }
    }
}
