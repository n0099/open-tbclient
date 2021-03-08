package com.baidu.browser.sailor;

import android.graphics.Bitmap;
import android.graphics.Picture;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebHistoryItem;
/* loaded from: classes14.dex */
public class BdSailorWebHistoryItem implements INoProGuard {
    private WebHistoryItem mItem;

    /* JADX INFO: Access modifiers changed from: protected */
    public BdSailorWebHistoryItem(WebHistoryItem webHistoryItem) {
        this.mItem = webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.mItem.getFavicon();
    }

    public int getKey() {
        return -1;
    }

    public String getOriginalUrl() {
        return this.mItem.getOriginalUrl();
    }

    public Picture getSnapshot() {
        return this.mItem.getScreenshot();
    }

    public String getTitle() {
        return this.mItem.getTitle();
    }

    public String getTouchIconUrl() {
        return this.mItem.getTouchIconUrl();
    }

    public String getUrl() {
        return this.mItem.getUrl();
    }

    public Object getUserData(int i) {
        return null;
    }

    @Deprecated
    public int getVisibleTitleHeight() {
        return this.mItem.getVisibleTitleHeight();
    }

    public void setUserData(int i, Object obj) {
    }

    public String toString() {
        return getUrl();
    }
}
