package com.baidu.clientupdate.appinfo;
/* loaded from: classes17.dex */
public class ClientUpdateInfo extends AppInfo {
    public String mContentUrl;
    public String mIsForceUpdate;
    public String mReverson;
    public String mStatus;

    @Override // com.baidu.clientupdate.appinfo.AppInfo
    public String toString() {
        return super.toString() + " isforce: " + this.mIsForceUpdate + " status: " + this.mStatus + " re_version: " + this.mReverson;
    }
}
