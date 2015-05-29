package com.baidu.sapi2.dto;
/* loaded from: classes.dex */
public class VoiceCheckDTO extends SapiDTO {
    public String account;
    public AccountType accountType = AccountType.MERGE;

    /* loaded from: classes.dex */
    public enum AccountType {
        MERGE,
        USERNAME,
        PHONE
    }
}
