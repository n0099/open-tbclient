package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bb;
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
    public void updatePraiseNum(bb bbVar) {
        super.updatePraiseNum(bbVar);
        if (this.awS != null && this.axl) {
            if (this.awS.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awS.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.awS.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.awR.getLayoutParams();
            layoutParams2.leftMargin = this.awN;
            this.awR.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bb bbVar) {
        super.f(bbVar);
        if (this.awV != null && this.axr) {
            this.awV.setVisibility(0);
            if (this.awV.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awV.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awN;
                layoutParams.weight = 0.0f;
                this.awV.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.awY != null && this.axt && this.awY.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awY.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.awN;
            layoutParams.weight = 0.0f;
            this.awY.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.axf != null && this.axu) {
            this.axf.setVisibility(0);
            if (this.axf.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axf.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awN;
                layoutParams.weight = 0.0f;
                this.axf.setLayoutParams(layoutParams);
            }
        }
    }
}
