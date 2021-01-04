package com.baidu.live.alablmsdk.module;
/* loaded from: classes11.dex */
public class c implements Cloneable {
    public String aCM;
    public long aCN;
    public String appVersion;
    public String cuid;
    public String ext;
    public String order;
    public String userName;
    public UserPermission aCL = UserPermission.UNKNOWN;
    public long aCG = 0;
    public long appId = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ch */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
            try {
                switch (this.aCL) {
                    case UNKNOWN:
                        cVar.aCL = UserPermission.UNKNOWN;
                    case OWNER:
                        cVar.aCL = UserPermission.OWNER;
                        break;
                    case VISITER:
                        cVar.aCL = UserPermission.VISITER;
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
        sb.append(" cuid=").append(this.cuid).append(" , ").append("imUk=").append(this.aCG).append(" , ").append("baiduUk=").append(this.aCM).append(" , ").append("appId=").append(this.appId).append(" , ").append("userName=").append(this.userName).append(" , ").append("appVersion=").append(this.appVersion).append(" , ").append("order=").append(this.order).append(" , ").append("ext=").append(this.ext).append(" , ").append("inviterImUk=").append(this.aCN);
        return sb.toString();
    }
}
