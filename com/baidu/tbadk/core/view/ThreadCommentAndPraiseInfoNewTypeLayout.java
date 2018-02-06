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
        if (this.bdn != null && this.bdD) {
            if (this.bdn.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdn.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bdn.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bdm.getLayoutParams();
            layoutParams2.leftMargin = this.bdi;
            this.bdm.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.bdq != null && this.bdJ) {
            this.bdq.setVisibility(0);
            if (this.bdq.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdq.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bdi;
                layoutParams.weight = 0.0f;
                this.bdq.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.bdt != null && this.bdL && this.bdt.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdt.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bdi;
            layoutParams.weight = 0.0f;
            this.bdt.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bd bdVar) {
        super.g(bdVar);
        if (this.bdA != null && this.bdM) {
            this.bdA.setVisibility(0);
            if (this.bdA.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdA.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bdi;
                layoutParams.weight = 0.0f;
                this.bdA.setLayoutParams(layoutParams);
            }
        }
    }
}
