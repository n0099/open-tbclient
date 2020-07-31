package com.baidu.sapi2.dto;
/* loaded from: classes12.dex */
public class SetPortraitDTO extends SapiDTO {
    public static final int PORTRAIT_TYPE_CARTOON = 2;
    public static final int PORTRAIT_TYPE_DEFAULT = 0;
    public static final int PORTRAIT_TYPE_PRODUCT_DEFINE = 1;
    public String bduss;
    public String contentType;
    public byte[] file;
    public int portraitType = 0;
}
