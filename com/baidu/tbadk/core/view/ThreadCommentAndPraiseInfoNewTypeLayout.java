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
        if (this.cmm != null && this.cqJ) {
            if (this.cmm.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmm.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.cmm.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.cmm.cng;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.cql;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void r(bh bhVar) {
        super.r(bhVar);
        if (this.cqs != null && this.cqN) {
            this.cqs.setVisibility(0);
            if (this.cqs.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqs.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cql;
                layoutParams.weight = 0.0f;
                this.cqs.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void q(bh bhVar) {
        super.q(bhVar);
        if (this.cqv != null && this.cqP && this.cqv.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqv.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.cql;
            layoutParams.weight = 0.0f;
            this.cqv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void s(bh bhVar) {
        super.s(bhVar);
        if (this.cqC != null && this.cqQ) {
            this.cqC.setVisibility(0);
            if (this.cqC.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqC.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.cql;
                layoutParams.weight = 0.0f;
                this.cqC.setLayoutParams(layoutParams);
            }
        }
    }
}
