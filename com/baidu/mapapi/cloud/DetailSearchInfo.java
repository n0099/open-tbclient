package com.baidu.mapapi.cloud;
/* loaded from: classes.dex */
public class DetailSearchInfo {
    public String ak;
    public int id;
    public String sn;
    public int scope = 1;
    public int timeStamp = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        if (this.id == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("/");
        sb.append(this.id).append('?');
        sb.append("scope=").append(this.scope);
        if (this.ak != null) {
            sb.append("&ak=").append(this.ak);
        }
        if (this.sn != null) {
            sb.append("&sn=").append(this.sn);
            sb.append("&timestamp=").append(this.timeStamp);
        }
        return sb.toString();
    }
}
