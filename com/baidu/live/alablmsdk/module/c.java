package com.baidu.live.alablmsdk.module;
/* loaded from: classes4.dex */
public class c implements Cloneable {
    public String appVersion;
    public String azQ;
    public String cuid;
    public String ext;
    public String order;
    public String userName;
    public UserPermission azP = UserPermission.UNKNOWN;
    public long azK = 0;
    public long appId = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Bh */
    public c clone() {
        c cVar;
        CloneNotSupportedException e;
        try {
            cVar = (c) super.clone();
            try {
                switch (this.azP) {
                    case UNKNOWN:
                        cVar.azP = UserPermission.UNKNOWN;
                    case OWNER:
                        cVar.azP = UserPermission.OWNER;
                        break;
                    case VISITER:
                        cVar.azP = UserPermission.VISITER;
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
        sb.append(" cuid=").append(this.cuid).append(" , ").append("imUk=").append(this.azK).append(" , ").append("baiduUk=").append(this.azQ).append(" , ").append("appId=").append(this.appId).append(" , ").append("userName=").append(this.userName).append(" , ").append("appVersion=").append(this.appVersion).append(" , ").append("order=").append(this.order).append(" , ").append("ext=").append(this.ext);
        return sb.toString();
    }
}
