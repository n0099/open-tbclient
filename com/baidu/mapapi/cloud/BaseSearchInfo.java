package com.baidu.mapapi.cloud;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
/* loaded from: classes2.dex */
public abstract class BaseSearchInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6791a;
    public String ak;
    public int geoTableId;
    public String sn;

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6791a);
        sb.append("?");
        String str = this.ak;
        if (str != null && !str.equals("") && this.ak.length() <= 50) {
            sb.append(ContentUtil.RESULT_KEY_AK);
            sb.append("=");
            sb.append(this.ak);
            if (this.geoTableId != 0) {
                sb.append("&");
                sb.append("geotable_id");
                sb.append("=");
                sb.append(this.geoTableId);
                String str2 = this.sn;
                if (str2 != null && !str2.equals("") && this.sn.length() <= 50) {
                    sb.append("&");
                    sb.append(IAdRequestParam.SN);
                    sb.append("=");
                    sb.append(this.sn);
                }
                return sb.toString();
            }
        }
        return null;
    }
}
