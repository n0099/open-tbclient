package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.d.c.b;
/* loaded from: classes6.dex */
public class UploadUrlProvider {
    private static volatile UploadUrlProvider sSingleton;
    private UploadUrlListener mUploadUrlListener;

    private UploadUrlProvider() {
    }

    public static UploadUrlProvider getInstance() {
        if (sSingleton == null) {
            synchronized (UploadUrlProvider.class) {
                if (sSingleton == null) {
                    sSingleton = new UploadUrlProvider();
                }
            }
        }
        return sSingleton;
    }

    public void setUploadUrlListener(UploadUrlListener uploadUrlListener) {
        this.mUploadUrlListener = uploadUrlListener;
    }

    public String getUploadUrl() {
        if (this.mUploadUrlListener != null) {
            return this.mUploadUrlListener.processUrl();
        }
        return b.ug().processUrl(BaseUrlManager.getBaseUploadUrl());
    }
}
