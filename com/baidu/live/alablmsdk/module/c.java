package com.baidu.live.alablmsdk.module;
/* loaded from: classes4.dex */
public class c {
    public String aBl;
    public String appVersion;
    public String cuid;
    public String userName;
    public UserPermission aBk = UserPermission.VISITER;
    public long aBd = -1;
    public long appId = -1;

    public String toString() {
        return "cuid=" + this.cuid + "|imuk=" + this.aBd + "|baiduUk=" + this.aBl + "|appId=" + this.appId + "|userName=" + this.userName + "|appVersion=" + this.appVersion;
    }
}
