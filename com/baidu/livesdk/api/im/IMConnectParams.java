package com.baidu.livesdk.api.im;
/* loaded from: classes3.dex */
public class IMConnectParams {
    public int accountType;
    public String appId;
    public String bduss;
    public String cUid;
    public String cfrom;
    public String from;
    public boolean isLogin;
    public Object other;
    public int pl;
    public String uid;
    public String versionName;

    public int getAccountType() {
        return this.accountType;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBduss() {
        return this.bduss;
    }

    public String getFrom() {
        return this.from;
    }

    public Object getOther() {
        return this.other;
    }

    public int getPl() {
        return this.pl;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getcUid() {
        return this.cUid;
    }

    public String getcfrom() {
        return this.cfrom;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void setAccountType(int i) {
        this.accountType = i;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBduss(String str) {
        this.bduss = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setLogin(boolean z) {
        this.isLogin = z;
    }

    public void setOther(Object obj) {
        this.other = obj;
    }

    public void setPl(int i) {
        this.pl = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setcUid(String str) {
        this.cUid = str;
    }

    public void setcfrom(String str) {
        this.cfrom = str;
    }
}
