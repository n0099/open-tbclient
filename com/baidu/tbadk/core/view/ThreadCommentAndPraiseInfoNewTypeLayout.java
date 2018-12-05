package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes6.dex */
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
        if (this.aFd != null && this.aJs) {
            if (this.aFd.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFd.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = 0;
                layoutParams.weight = 0.0f;
                this.aFd.setLayoutParams(layoutParams);
            }
            ImageView imageView = this.aFd.aFx;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.leftMargin = this.aIV;
            imageView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void g(bb bbVar) {
        super.g(bbVar);
        if (this.aJb != null && this.aJw) {
            this.aJb.setVisibility(0);
            if (this.aJb.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJb.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aIV;
                layoutParams.weight = 0.0f;
                this.aJb.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void h(bb bbVar) {
        super.h(bbVar);
        if (this.aJe != null && this.aJy && this.aJe.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJe.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.leftMargin = this.aIV;
            layoutParams.weight = 0.0f;
            this.aJe.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void i(bb bbVar) {
        super.i(bbVar);
        if (this.aJl != null && this.aJz) {
            this.aJl.setVisibility(0);
            if (this.aJl.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJl.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.leftMargin = this.aIV;
                layoutParams.weight = 0.0f;
                this.aJl.setLayoutParams(layoutParams);
            }
        }
    }
}
