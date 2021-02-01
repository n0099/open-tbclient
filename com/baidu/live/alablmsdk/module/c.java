package com.baidu.live.alablmsdk.module;
/* loaded from: classes11.dex */
public class c implements Cloneable {
    public String appVersion;
    public String ayq;
    public long ayr;
    public String cuid;
    public String ext;
    public String order;
    public String userName;
    public UserPermission ayp = UserPermission.UNKNOWN;
    public long ayk = 0;
    public long appId = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: yA */
    public c clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
            try {
                switch (this.ayp) {
                    case UNKNOWN:
                        cVar.ayp = UserPermission.UNKNOWN;
                    case OWNER:
                        cVar.ayp = UserPermission.OWNER;
                        break;
                    case VISITER:
                        cVar.ayp = UserPermission.VISITER;
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
        sb.append(" cuid=").append(this.cuid).append(" , ").append("imUk=").append(this.ayk).append(" , ").append("baiduUk=").append(this.ayq).append(" , ").append("appId=").append(this.appId).append(" , ").append("userName=").append(this.userName).append(" , ").append("appVersion=").append(this.appVersion).append(" , ").append("order=").append(this.order).append(" , ").append("ext=").append(this.ext).append(" , ").append("inviterImUk=").append(this.ayr);
        return sb.toString();
    }
}
