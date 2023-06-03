package com.baidu.searchbox.download.util;
/* loaded from: classes3.dex */
public abstract class DuplicateDownloadCallback {
    public String mDownloadUrl;

    public abstract void onDuplicate();

    public abstract void onNotDuplicate();

    public DuplicateDownloadCallback(String str) {
        this.mDownloadUrl = str;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }
}
