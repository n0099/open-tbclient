package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bg;
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
    public void updatePraiseNum(bg bgVar) {
        super.updatePraiseNum(bgVar);
        if (this.bNv != null && this.bSA) {
            if (this.bNv.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNv.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bNv.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bNv.bOn;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.bSc;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        super.p(bgVar);
        if (this.bSj != null && this.bSE) {
            this.bSj.setVisibility(0);
            if (this.bSj.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSj.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bSc;
                layoutParams.weight = 0.0f;
                this.bSj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        super.o(bgVar);
        if (this.bSm != null && this.bSG && this.bSm.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSm.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.bSc;
            layoutParams.weight = 0.0f;
            this.bSm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        super.q(bgVar);
        if (this.bSt != null && this.bSH) {
            this.bSt.setVisibility(0);
            if (this.bSt.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSt.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.bSc;
                layoutParams.weight = 0.0f;
                this.bSt.setLayoutParams(layoutParams);
            }
        }
    }
}
