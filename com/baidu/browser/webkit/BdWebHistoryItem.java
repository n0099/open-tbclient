package com.baidu.browser.webkit;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
/* loaded from: classes.dex */
public class BdWebHistoryItem {
    private WebHistoryItem mSysWebHistoryItem;
    private com.baidu.zeus.WebHistoryItem mZeusWebHistoryItem;

    public BdWebHistoryItem(WebHistoryItem webHistoryItem) {
        this.mSysWebHistoryItem = webHistoryItem;
    }

    public BdWebHistoryItem(com.baidu.zeus.WebHistoryItem webHistoryItem) {
        this.mZeusWebHistoryItem = webHistoryItem;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebHistoryItem) && unwrap() == ((BdWebHistoryItem) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem.hashCode() : this.mSysWebHistoryItem.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem == obj : this.mSysWebHistoryItem == obj;
    }

    public Object unwrap() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem : this.mSysWebHistoryItem;
    }

    public int getId() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem.getId() : this.mSysWebHistoryItem.getId();
    }

    public String getUrl() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem.getUrl() : this.mSysWebHistoryItem.getUrl();
    }

    public String getOriginalUrl() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem.getOriginalUrl() : this.mSysWebHistoryItem.getOriginalUrl();
    }

    public String getTitle() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem.getTitle() : this.mSysWebHistoryItem.getTitle();
    }

    public Bitmap getFavicon() {
        return this.mZeusWebHistoryItem != null ? this.mZeusWebHistoryItem.getFavicon() : this.mSysWebHistoryItem.getFavicon();
    }
}
