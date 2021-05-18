package com.baidu.searchbox.v8engine.net;

import com.baidu.searchbox.v8engine.NotProguard;
@NotProguard
/* loaded from: classes2.dex */
public class NetRedirectInfo {
    public String mNewMethod;
    public String mNewReferrer;
    public String mNewUrl;
    public int mStatusCode;

    public NetRedirectInfo(int i2, String str, String str2, String str3) {
        this.mStatusCode = i2;
        this.mNewUrl = str;
        this.mNewMethod = str2;
        this.mNewReferrer = str3;
    }

    public String getNewMethod() {
        return this.mNewMethod;
    }

    public String getNewReferrer() {
        return this.mNewReferrer;
    }

    public String getNewUrl() {
        return this.mNewUrl;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String toString() {
        return "NetRedirectInfo{mStatusCode=" + this.mStatusCode + ", mNewUrl='" + this.mNewUrl + "', mNewMethod='" + this.mNewMethod + "', mNewReferrer='" + this.mNewReferrer + "'}";
    }
}
