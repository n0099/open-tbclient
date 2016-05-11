package com.baidu.sapi2.dto;
/* loaded from: classes.dex */
public class FaceCheckDTO extends SapiDTO {
    public String account;
    public AccountType accountType = AccountType.MERGE;
    public String bduss;

    /* loaded from: classes.dex */
    public enum AccountType {
        MERGE,
        USERNAME,
        PHONE
    }
}
