package com.baidu.searchbox.aperf.bosuploader;
/* loaded from: classes5.dex */
public class STSInfo {
    public String ak;
    public String bucket;
    public String endpoint;
    public String expired;
    public long expiredAt;
    private String mOrigin;
    public String sk;
    public String token;

    public STSInfo(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        this.ak = str;
        this.sk = str2;
        this.token = str3;
        this.expiredAt = j;
        this.expired = str4;
        this.bucket = str5;
        this.endpoint = str6;
    }

    public String getOrigin() {
        return this.mOrigin;
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
    }
}
