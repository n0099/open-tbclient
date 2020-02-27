package com.baidu.mapapi.cloud;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes8.dex */
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
        sb.append(ETAG.EQUAL);
        sb.append(this.ak);
        if (this.geoTableId != 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append("geotable_id");
            sb.append(ETAG.EQUAL);
            sb.append(this.geoTableId);
            if (this.sn != null && !this.sn.equals("") && this.sn.length() <= 50) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(IXAdRequestInfo.SN);
                sb.append(ETAG.EQUAL);
                sb.append(this.sn);
            }
            return sb.toString();
        }
        return null;
    }
}
