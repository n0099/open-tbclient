package com.baidu.searchbox.retrieve.inter.upload;
/* loaded from: classes11.dex */
public interface IActiveUploadListener {
    public static final String DIR_ERR_MSG = "dir error";
    public static final String PARAM_ERR_MSG = "params error";
    public static final String PRE_ZIP_ERR_MSG = "check before zip error";
    public static final String UPLOAD_ERR_MSG = "upload failed";
    public static final String ZIP_ERR_MSG = "zip failed";

    void onFailure(String str);

    void onSuccess();
}
