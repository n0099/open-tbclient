package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebHistoryItem;
/* loaded from: classes.dex */
public class BdSailorWebBackForwardList implements INoProGuard {
    public WebBackForwardList mBackForwardList;

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

    public BdSailorWebHistoryItem getItemAtIndex(int i2) {
        return new BdSailorWebHistoryItem(this.mBackForwardList.getItemAtIndex(i2));
    }

    public int getSize() {
        return this.mBackForwardList.getSize();
    }
}
