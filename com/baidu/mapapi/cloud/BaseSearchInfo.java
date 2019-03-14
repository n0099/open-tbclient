package com.baidu.mapapi.cloud;
/* loaded from: classes5.dex */
public abstract class BaseSearchInfo {
    String a;
    public String ak;
    public int geoTableId;
    public String sn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("?");
        if (this.ak == null || this.ak.equals("") || this.ak.length() > 50) {
            return null;
        }
        sb.append("ak");
        sb.append("=");
        sb.append(this.ak);
        if (this.geoTableId != 0) {
            sb.append("&");
            sb.append("geotable_id");
            sb.append("=");
            sb.append(this.geoTableId);
            if (this.sn != null && !this.sn.equals("") && this.sn.length() <= 50) {
                sb.append("&");
                sb.append("sn");
                sb.append("=");
                sb.append(this.sn);
            }
            return sb.toString();
        }
        return null;
    }
}
