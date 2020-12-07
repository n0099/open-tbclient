package com.baidu.searchbox.ui.bubble;

import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.searchbox.ui.bubble.BubbleManager;
/* loaded from: classes20.dex */
public class MutexBubbleManager implements PopItem {
    private BubbleManager mBubbleManager;

    public MutexBubbleManager(BubbleManager bubbleManager) {
        this.mBubbleManager = bubbleManager;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) throws ClassCastException {
        if (this.mBubbleManager == null) {
            return false;
        }
        final BubbleManager.OnBubbleEventListener onBubbleEventListener = this.mBubbleManager.getOnBubbleEventListener();
        this.mBubbleManager.setOnBubbleEventListener(new BubbleManager.OnBubbleEventListener() { // from class: com.baidu.searchbox.ui.bubble.MutexBubbleManager.1
            @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
            public void onBubbleDismiss() {
                if (onBubbleEventListener != null) {
                    onBubbleEventListener.onBubbleDismiss();
                }
                MutexBubbleManager.this.mBubbleManager = null;
                MutexPopManager.doNextTask();
            }

            @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
            public void onBubbleShow() {
                if (onBubbleEventListener != null) {
                    onBubbleEventListener.onBubbleShow();
                }
            }

            @Override // com.baidu.searchbox.ui.bubble.BubbleManager.OnBubbleEventListener
            public void onBubbleClick() {
                if (onBubbleEventListener != null) {
                    onBubbleEventListener.onBubbleClick();
                }
            }
        });
        this.mBubbleManager.showBubble();
        return true;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        dismissBubble();
    }

    public void dismissBubble() {
        if (this.mBubbleManager != null && !this.mBubbleManager.isDismissed()) {
            this.mBubbleManager.dismissBubble();
            this.mBubbleManager = null;
        }
    }
}
