package com.baidu.live.alablmsdk.module;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public String aCv;
    public long aCw;
    public String appVersion;
    public String cuid;
    public String ext;
    public String order;
    public String userName;
    public UserPermission aCu = UserPermission.UNKNOWN;
    public long aCp = 0;
    public long appId = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CQ */
    public c clone() {
        c cVar;
        CloneNotSupportedException e;
        try {
            cVar = (c) super.clone();
            try {
                switch (this.aCu) {
                    case UNKNOWN:
                        cVar.aCu = UserPermission.UNKNOWN;
                    case OWNER:
                        cVar.aCu = UserPermission.OWNER;
                        break;
                    case VISITER:
                        cVar.aCu = UserPermission.VISITER;
                        break;
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return cVar;
            }
        } catch (CloneNotSupportedException e3) {
            cVar = null;
            e = e3;
        }
        return cVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" cuid=").append(this.cuid).append(" , ").append("imUk=").append(this.aCp).append(" , ").append("baiduUk=").append(this.aCv).append(" , ").append("appId=").append(this.appId).append(" , ").append("userName=").append(this.userName).append(" , ").append("appVersion=").append(this.appVersion).append(" , ").append("order=").append(this.order).append(" , ").append("ext=").append(this.ext).append(" , ").append("inviterImUk=").append(this.aCw);
        return sb.toString();
    }
}
