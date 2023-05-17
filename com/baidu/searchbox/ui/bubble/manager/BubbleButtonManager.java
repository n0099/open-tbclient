package com.baidu.searchbox.ui.bubble.manager;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import com.baidu.searchbox.ui.bubble.BubbleHistory;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.views.BubbleButtonView;
/* loaded from: classes4.dex */
public class BubbleButtonManager extends BubbleTextManager {
    public static final String TAG = "BubbleTextManager";
    public BubbleManager.OnBtnClickListener mBtnClickListener;
    public BubbleButtonView mButtonViews;

    public BubbleButtonManager() {
        super(new BubbleButtonView());
        this.mButtonViews = (BubbleButtonView) this.mViews;
        this.mLocation.enableD20Template(false);
    }

    public void setBtnText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.mButtonViews.mBtnText = charSequence;
    }

    public void setOnBtnClickListener(BubbleManager.OnBtnClickListener onBtnClickListener) {
        this.mBtnClickListener = onBtnClickListener;
    }

    public void setText(CharSequence charSequence) {
        this.mButtonViews.mShowText = charSequence;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager
    public void setTextColor(@ColorInt int i) {
        this.mButtonViews.setTextColor(i, i);
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager
    public void updateBubble(int i) {
        try {
            if (!isDismissed()) {
                super.updateBubble(i);
                this.mViews.updateBubble(i, this.mButtonViews.getTextColor());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public BubbleButtonView getViews() {
        return this.mButtonViews;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void onShow() {
        super.onShow();
        this.mButtonViews.mArrowUp.enableNewTemplate(false);
        this.mButtonViews.mArrowDown.enableNewTemplate(false);
        this.mButtonViews.mArrowLeft.enableNewTemplate(false);
        this.mButtonViews.mArrowRight.enableNewTemplate(false);
        if (!TextUtils.isEmpty(this.mButtonViews.mBtnText)) {
            BubbleButtonView bubbleButtonView = this.mButtonViews;
            CharSequence charSequence = bubbleButtonView.mBtnText;
            int textColor = bubbleButtonView.getTextColor();
            BubbleButtonView bubbleButtonView2 = this.mButtonViews;
            bubbleButtonView.setBtnText(charSequence, textColor, bubbleButtonView2.mBtnTextUnit, bubbleButtonView2.mBtnTextSize);
            this.mButtonViews.setBtnClick(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleButtonManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (BubbleButtonManager.this.mBtnClickListener != null) {
                        BubbleButtonManager.this.mBtnClickListener.onBtnClick();
                    }
                    BubbleButtonManager.this.dismissBubble();
                }
            });
            BubbleHistory.getInstance().trackBubbleHistory(this.mButtonViews.mBtnText.toString());
        }
    }
}
