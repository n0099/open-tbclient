package com.baidu.live.alablmsdk.module;
/* loaded from: classes10.dex */
public class c implements Cloneable {
    public String appVersion;
    public String axZ;
    public long aya;
    public String cuid;
    public String ext;
    public String order;
    public String userName;
    public UserPermission axY = UserPermission.UNKNOWN;
    public long axT = 0;
    public long appId = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ym */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
            try {
                switch (this.axY) {
                    case UNKNOWN:
                        cVar.axY = UserPermission.UNKNOWN;
                    case OWNER:
                        cVar.axY = UserPermission.OWNER;
                        break;
                    case VISITER:
                        cVar.axY = UserPermission.VISITER;
                        break;
                }
            } catch (CloneNotSupportedException e) {
                e = e;
                e.printStackTrace();
                return cVar;
            }
        } catch (CloneNotSupportedException e2) {
            e = e2;
            cVar = null;
        }
        return cVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" cuid=").append(this.cuid).append(" , ").append("imUk=").append(this.axT).append(" , ").append("baiduUk=").append(this.axZ).append(" , ").append("appId=").append(this.appId).append(" , ").append("userName=").append(this.userName).append(" , ").append("appVersion=").append(this.appVersion).append(" , ").append("order=").append(this.order).append(" , ").append("ext=").append(this.ext).append(" , ").append("inviterImUk=").append(this.aya);
        return sb.toString();
    }
}
