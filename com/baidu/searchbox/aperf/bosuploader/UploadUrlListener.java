package com.baidu.searchbox.aperf.bosuploader;
/* loaded from: classes4.dex */
public interface UploadUrlListener {
    public static final String BASE_UPLOAD_URL = BaseUrlManager.getBaseUploadUrl();

    String processUrl();
}
