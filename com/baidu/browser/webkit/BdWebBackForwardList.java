package com.baidu.browser.webkit;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class BdWebBackForwardList {
    private WebBackForwardList mSysWebBackForwardList;
    private SoftReference mWebHistroyItemWrapper;
    private com.baidu.zeus.WebBackForwardList mZeusWebBackForwardList;

    public BdWebBackForwardList(WebBackForwardList webBackForwardList) {
        this.mSysWebBackForwardList = webBackForwardList;
    }

    public BdWebBackForwardList(com.baidu.zeus.WebBackForwardList webBackForwardList) {
        this.mZeusWebBackForwardList = webBackForwardList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebBackForwardList) && unwrap() == ((BdWebBackForwardList) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebBackForwardList != null ? this.mZeusWebBackForwardList.hashCode() : this.mSysWebBackForwardList.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebBackForwardList != null ? this.mZeusWebBackForwardList == obj : this.mSysWebBackForwardList == obj;
    }

    public Object unwrap() {
        return this.mZeusWebBackForwardList != null ? this.mZeusWebBackForwardList : this.mSysWebBackForwardList;
    }

    private BdWebHistoryItem obtainWebHistoryItemWrapper(WebHistoryItem webHistoryItem) {
        BdWebHistoryItem bdWebHistoryItem = null;
        if (this.mWebHistroyItemWrapper != null) {
            bdWebHistoryItem = (BdWebHistoryItem) this.mWebHistroyItemWrapper.get();
        }
        if (bdWebHistoryItem == null || !bdWebHistoryItem.isContains(webHistoryItem)) {
            BdWebHistoryItem bdWebHistoryItem2 = new BdWebHistoryItem(webHistoryItem);
            this.mWebHistroyItemWrapper = new SoftReference(bdWebHistoryItem2);
            return bdWebHistoryItem2;
        }
        return bdWebHistoryItem;
    }

    private BdWebHistoryItem obtainWebHistoryItemWrapper(com.baidu.zeus.WebHistoryItem webHistoryItem) {
        BdWebHistoryItem bdWebHistoryItem = null;
        if (this.mWebHistroyItemWrapper != null) {
            bdWebHistoryItem = (BdWebHistoryItem) this.mWebHistroyItemWrapper.get();
        }
        if (bdWebHistoryItem == null || !bdWebHistoryItem.isContains(webHistoryItem)) {
            BdWebHistoryItem bdWebHistoryItem2 = new BdWebHistoryItem(webHistoryItem);
            this.mWebHistroyItemWrapper = new SoftReference(bdWebHistoryItem2);
            return bdWebHistoryItem2;
        }
        return bdWebHistoryItem;
    }

    public synchronized BdWebHistoryItem getCurrentItem() {
        BdWebHistoryItem bdWebHistoryItem = null;
        synchronized (this) {
            if (this.mZeusWebBackForwardList != null) {
                com.baidu.zeus.WebHistoryItem currentItem = this.mZeusWebBackForwardList.getCurrentItem();
                if (currentItem != null) {
                    bdWebHistoryItem = obtainWebHistoryItemWrapper(currentItem);
                }
            } else {
                WebHistoryItem currentItem2 = this.mSysWebBackForwardList.getCurrentItem();
                if (currentItem2 != null) {
                    bdWebHistoryItem = obtainWebHistoryItemWrapper(currentItem2);
                }
            }
        }
        return bdWebHistoryItem;
    }

    public synchronized int getCurrentIndex() {
        return this.mZeusWebBackForwardList != null ? this.mZeusWebBackForwardList.getCurrentIndex() : this.mSysWebBackForwardList.getCurrentIndex();
    }

    public synchronized BdWebHistoryItem getItemAtIndex(int i) {
        BdWebHistoryItem bdWebHistoryItem = null;
        synchronized (this) {
            if (this.mZeusWebBackForwardList != null) {
                com.baidu.zeus.WebHistoryItem itemAtIndex = this.mZeusWebBackForwardList.getItemAtIndex(i);
                if (itemAtIndex != null) {
                    bdWebHistoryItem = new BdWebHistoryItem(itemAtIndex);
                }
            } else {
                WebHistoryItem itemAtIndex2 = this.mSysWebBackForwardList.getItemAtIndex(i);
                if (itemAtIndex2 != null) {
                    bdWebHistoryItem = new BdWebHistoryItem(itemAtIndex2);
                }
            }
        }
        return bdWebHistoryItem;
    }

    public synchronized int getSize() {
        return this.mZeusWebBackForwardList != null ? this.mZeusWebBackForwardList.getSize() : this.mSysWebBackForwardList.getSize();
    }
}
