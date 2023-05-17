package com.baidu.searchbox.ui.bubble.manager;

import android.view.View;
import com.baidu.searchbox.ui.bubble.views.BubbleJumpArrowView;
/* loaded from: classes4.dex */
public class BubbleJumpArrowManager extends BubbleTextManager {
    public BubbleJumpArrowView mArrowViews;

    public BubbleJumpArrowManager() {
        super(new BubbleJumpArrowView());
        this.mArrowViews = (BubbleJumpArrowView) this.mViews;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void onShow() {
        super.onShow();
        BubbleJumpArrowView bubbleJumpArrowView = this.mArrowViews;
        if (bubbleJumpArrowView != null) {
            bubbleJumpArrowView.onShowArrow();
            this.mArrowViews.setJumpArrowClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleJumpArrowManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BubbleJumpArrowManager.this.onClickCore(view2);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public BubbleJumpArrowView getViews() {
        return this.mArrowViews;
    }

    public void setJumpArrowClickListener(View.OnClickListener onClickListener) {
        this.mArrowViews.setJumpArrowClickListener(onClickListener);
    }

    public void setJumpArrowVisible(boolean z) {
        this.mArrowViews.setJumpArrowVisible(true);
    }
}
