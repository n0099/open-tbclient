package com.baidu.live.alablmsdk.module;
/* loaded from: classes4.dex */
public class c {
    public String aBq;
    public String appVersion;
    public String cuid;
    public String userName;
    public UserPermission aBp = UserPermission.VISITER;
    public long aBi = -1;
    public long appId = -1;

    public String toString() {
        return "cuid=" + this.cuid + "|imuk=" + this.aBi + "|baiduUk=" + this.aBq + "|appId=" + this.appId + "|userName=" + this.userName + "|appVersion=" + this.appVersion;
    }
}
