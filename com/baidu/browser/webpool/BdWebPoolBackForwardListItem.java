package com.baidu.browser.webpool;

import android.os.Bundle;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdWebPoolBackForwardListItem {
    private Bundle mBundle;
    private int mIndex;
    private LoadStatus mLoadStatus;
    private String mTitle;
    private String mUrl;
    private BdWebView mWebView;

    /* loaded from: classes.dex */
    public enum LoadStatus {
        STATUS_NORMAL,
        STATUS_ERROR;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static LoadStatus[] valuesCustom() {
            LoadStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            LoadStatus[] loadStatusArr = new LoadStatus[length];
            System.arraycopy(valuesCustom, 0, loadStatusArr, 0, length);
            return loadStatusArr;
        }
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public BdWebView getWebView() {
        return this.mWebView;
    }

    public void setWebView(BdWebView bdWebView) {
        this.mWebView = bdWebView;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public Bundle getExtras() {
        if (this.mBundle == null) {
            this.mBundle = new Bundle();
        }
        return this.mBundle;
    }

    public void putExtras(Bundle bundle) {
        this.mBundle = bundle;
    }

    public LoadStatus getLoadStatus() {
        return this.mLoadStatus;
    }

    public void setLoadStatus(LoadStatus loadStatus) {
        this.mLoadStatus = loadStatus;
    }
}
