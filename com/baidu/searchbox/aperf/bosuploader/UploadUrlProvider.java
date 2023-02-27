package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.common.param.CommonUrlParamManager;
/* loaded from: classes2.dex */
public class UploadUrlProvider {
    public static volatile UploadUrlProvider sSingleton;
    public UploadUrlListener mUploadUrlListener;

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

    public String getUploadUrl() {
        UploadUrlListener uploadUrlListener = this.mUploadUrlListener;
        if (uploadUrlListener != null) {
            return uploadUrlListener.processUrl();
        }
        return CommonUrlParamManager.getInstance().processUrl(BaseUrlManager.getBaseUploadUrl());
    }

    public void setUploadUrlListener(UploadUrlListener uploadUrlListener) {
        this.mUploadUrlListener = uploadUrlListener;
    }
}
