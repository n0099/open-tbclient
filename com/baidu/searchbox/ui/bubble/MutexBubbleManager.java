package com.baidu.searchbox.ui.bubble;

import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.searchbox.ui.bubble.BubbleManager;
/* loaded from: classes4.dex */
public class MutexBubbleManager implements PopItem {
    public BubbleManager mBubbleManager;

    public MutexBubbleManager(BubbleManager bubbleManager) {
        this.mBubbleManager = bubbleManager;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) throws ClassCastException {
        BubbleManager bubbleManager = this.mBubbleManager;
        if (bubbleManager == null) {
            return false;
        }
        final BubbleManager.OnBubbleEventListener onBubbleEventListener = bubbleManager.getOnBubbleEventListener();
        this.mBubbleManager.setOnBubbleEventListener(new BubbleManager.OnBubbleEventListener() { // from class: com.baidu.searchbox.ui.bubble.MutexBubbleManager.1
            @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
            public void onBubbleClick() {
                BubbleManager.OnBubbleEventListener onBubbleEventListener2 = onBubbleEventListener;
                if (onBubbleEventListener2 != null) {
                    onBubbleEventListener2.onBubbleClick();
                }
            }

            @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
            public void onBubbleDismiss() {
                BubbleManager.OnBubbleEventListener onBubbleEventListener2 = onBubbleEventListener;
                if (onBubbleEventListener2 != null) {
                    onBubbleEventListener2.onBubbleDismiss();
                }
                MutexBubbleManager.this.mBubbleManager = null;
                MutexPopManager.doNextTask();
            }

            @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
            public void onBubbleShow() {
                BubbleManager.OnBubbleEventListener onBubbleEventListener2 = onBubbleEventListener;
                if (onBubbleEventListener2 != null) {
                    onBubbleEventListener2.onBubbleShow();
                }
            }
        });
        this.mBubbleManager.showBubble();
        return true;
    }

    public void dismissBubble() {
        BubbleManager bubbleManager = this.mBubbleManager;
        if (bubbleManager != null && !bubbleManager.isDismissed()) {
            this.mBubbleManager.dismissBubble();
            this.mBubbleManager = null;
        }
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        dismissBubble();
    }
}
