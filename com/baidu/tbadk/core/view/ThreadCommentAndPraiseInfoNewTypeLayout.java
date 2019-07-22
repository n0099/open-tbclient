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
        if (this.bWi != null && this.cbv) {
            if (this.bWi.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWi.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.bWi.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.bWi.bXe;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.caX;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void p(bg bgVar) {
        super.p(bgVar);
        if (this.cbe != null && this.cbz) {
            this.cbe.setVisibility(0);
            if (this.cbe.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbe.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.caX;
                layoutParams.weight = 0.0f;
                this.cbe.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void o(bg bgVar) {
        super.o(bgVar);
        if (this.cbh != null && this.cbB && this.cbh.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbh.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.caX;
            layoutParams.weight = 0.0f;
            this.cbh.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bg bgVar) {
        super.q(bgVar);
        if (this.cbo != null && this.cbC) {
            this.cbo.setVisibility(0);
            if (this.cbo.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbo.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.caX;
                layoutParams.weight = 0.0f;
                this.cbo.setLayoutParams(layoutParams);
            }
        }
    }
}
