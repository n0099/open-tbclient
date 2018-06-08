package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bd;
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
    public void updatePraiseNum(bd bdVar) {
        super.updatePraiseNum(bdVar);
        if (this.awD != null && this.awT) {
            if (this.awD.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awD.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.awD.setLayoutParams(layoutParams);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.awC.getLayoutParams();
            layoutParams2.leftMargin = this.awy;
            this.awC.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void e(bd bdVar) {
        super.e(bdVar);
        if (this.awG != null && this.awZ) {
            this.awG.setVisibility(0);
            if (this.awG.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awG.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awy;
                layoutParams.weight = 0.0f;
                this.awG.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void f(bd bdVar) {
        super.f(bdVar);
        if (this.awJ != null && this.axb && this.awJ.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awJ.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.awy;
            layoutParams.weight = 0.0f;
            this.awJ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bd bdVar) {
        super.g(bdVar);
        if (this.awQ != null && this.axc) {
            this.awQ.setVisibility(0);
            if (this.awQ.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awQ.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.awy;
                layoutParams.weight = 0.0f;
                this.awQ.setLayoutParams(layoutParams);
            }
        }
    }
}
