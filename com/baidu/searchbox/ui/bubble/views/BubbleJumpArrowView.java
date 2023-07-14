package com.baidu.searchbox.ui.bubble.views;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BubbleJumpArrowView extends BubbleTextView {
    public ImageView mJumpArrow;
    public ImageView mStartIcon;

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public int getBubbleViewResId() {
        return R.layout.obfuscated_res_0x7f0d018a;
    }

    public ImageView getJumpArrowImageView() {
        return this.mJumpArrow;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public boolean initViewIfNeed() {
        if (!super.initViewIfNeed()) {
            return false;
        }
        this.mJumpArrow = (ImageView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f090503);
        this.mStartIcon = (ImageView) this.mBubbleView.findViewById(R.id.obfuscated_res_0x7f09050b);
        FontSizeViewExtKt.setScaledSizeRes(this.mJumpArrow, 0, R.dimen.obfuscated_res_0x7f0701ec, R.dimen.obfuscated_res_0x7f0701ec);
        return true;
    }

    public void onShowArrow() {
        ImageView imageView = this.mJumpArrow;
        if (imageView == null) {
            return;
        }
        imageView.setBackground(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080494));
        this.mJumpArrow.setVisibility(0);
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void resetAll() {
        super.resetAll();
        this.mJumpArrow = null;
    }

    @Override // com.baidu.searchbox.ui.bubble.views.BubbleTextView, com.baidu.searchbox.ui.bubble.views.BubbleBaseView
    public void updateViewUI() {
        super.updateViewUI();
        ImageView imageView = this.mJumpArrow;
        if (imageView != null) {
            FontSizeViewExtKt.setScaledSizeRes(imageView, 0, R.dimen.obfuscated_res_0x7f0701ec, R.dimen.obfuscated_res_0x7f0701ec);
        }
    }

    public void setJumpArrowBgColor(int i) {
        ImageView imageView = this.mJumpArrow;
        if (imageView == null) {
            return;
        }
        imageView.setBackground(AppRuntime.getAppContext().getResources().getDrawable(i));
        this.mJumpArrow.setVisibility(0);
    }

    public void setJumpArrowClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mJumpArrow;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setJumpArrowVisible(boolean z) {
        int i;
        ImageView imageView = this.mJumpArrow;
        if (imageView == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void setStartIconDrawable(Drawable drawable) {
        ImageView imageView = this.mStartIcon;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        this.mStartIcon.setVisibility(0);
    }
}
