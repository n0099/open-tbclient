package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebHistoryItem;
/* loaded from: classes19.dex */
public class BdSailorWebBackForwardList implements INoProGuard {
    private WebBackForwardList mBackForwardList;

    /* JADX INFO: Access modifiers changed from: protected */
    public BdSailorWebBackForwardList(WebBackForwardList webBackForwardList) {
        this.mBackForwardList = webBackForwardList;
    }

    public int getCurrentIndex() {
        return this.mBackForwardList.getCurrentIndex();
    }

    public BdSailorWebHistoryItem getCurrentItem() {
        WebHistoryItem currentItem = this.mBackForwardList.getCurrentItem();
        if (currentItem != null) {
            return new BdSailorWebHistoryItem(currentItem);
        }
        return null;
    }

    public BdSailorWebHistoryItem getItemAtIndex(int i) {
        return new BdSailorWebHistoryItem(this.mBackForwardList.getItemAtIndex(i));
    }

    public int getSize() {
        return this.mBackForwardList.getSize();
    }
}
