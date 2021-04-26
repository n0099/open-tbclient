package com.baidu.sdk.container.filedownloader;
/* loaded from: classes2.dex */
public enum MaterialLoadErrorCode {
    ERROR_CODE_REQUEST_ERROR(0, "请求异常"),
    ERROR_CODE_URL_NULL(1, "图片url为空"),
    ERROR_CODE_VIEW_NULL(2, "图片view为空"),
    ERROR_CODE_PARSE_ERROR(3, "图片获取异常"),
    ERROR_CODE_TYPE_ERROR(4, "图片类型异常，非静态图"),
    ERROR_CODE_CACHE_ERROR(5, "缓存异常");
    
    public int code;
    public String msg;

    MaterialLoadErrorCode(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
