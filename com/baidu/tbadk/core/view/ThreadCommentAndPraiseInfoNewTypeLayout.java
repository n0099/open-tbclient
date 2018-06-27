package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes2.dex */
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
    public void updatePraiseNum(bc bcVar) {
        super.updatePraiseNum(bcVar);
        if (this.axm != null && this.axF) {
            if (this.axm.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axm.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.axm.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.axl.getLayoutParams();
            layoutParams2.leftMargin = this.axh;
            this.axl.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bc bcVar) {
        super.f(bcVar);
        if (this.axp != null && this.axL) {
            this.axp.setVisibility(0);
            if (this.axp.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axp.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.axh;
                layoutParams.weight = 0.0f;
                this.axp.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bc bcVar) {
        super.g(bcVar);
        if (this.axs != null && this.axN && this.axs.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axs.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.axh;
            layoutParams.weight = 0.0f;
            this.axs.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bc bcVar) {
        super.h(bcVar);
        if (this.axz != null && this.axO) {
            this.axz.setVisibility(0);
            if (this.axz.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axz.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.axh;
                layoutParams.weight = 0.0f;
                this.axz.setLayoutParams(layoutParams);
            }
        }
    }
}
