package com.baidu.searchbox.ui.bubble.builder;

import android.view.View;
import com.baidu.searchbox.ui.bubble.manager.BubbleJumpArrowManager;
/* loaded from: classes4.dex */
public class BubbleJumpArrowBuilder extends BubbleTextBuilder {
    public BubbleJumpArrowManager mManager;

    public BubbleJumpArrowBuilder() {
        this(new BubbleJumpArrowManager());
    }

    public BubbleJumpArrowBuilder(BubbleJumpArrowManager bubbleJumpArrowManager) {
        super(bubbleJumpArrowManager);
        this.mManager = bubbleJumpArrowManager;
    }

    public void setJumpArrowClickListener(View.OnClickListener onClickListener) {
        this.mManager.setJumpArrowClickListener(onClickListener);
    }

    public void setJumpArrowVisible(boolean z) {
        this.mManager.setJumpArrowVisible(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder, com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleJumpArrowManager build() {
        return this.mManager;
    }
}
