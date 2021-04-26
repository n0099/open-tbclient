package com.baidu.mapapi.cloud;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public abstract class BaseCloudSearchInfo extends BaseSearchInfo {
    public String filter;
    public int pageIndex;
    public int pageSize = 10;
    public String q;
    public String sortby;
    public String tags;

    @Override // com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            String str = this.q;
            if (str != null && !str.equals("") && this.q.length() <= 45) {
                sb.append("&");
                sb.append(IAdRequestParam.COST_NAME);
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(this.q, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            String str2 = this.tags;
            if (str2 != null && !str2.equals("") && this.tags.length() <= 45) {
                sb.append("&");
                sb.append(CommandMessage.TYPE_TAGS);
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(this.tags, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
            String str3 = this.sortby;
            if (str3 != null && !str3.equals("")) {
                sb.append("&");
                sb.append("sortby");
                sb.append("=");
                sb.append(this.sortby);
            }
            String str4 = this.filter;
            if (str4 != null && !str4.equals("")) {
                sb.append("&");
                sb.append(CloudControlRequest.REQUEST_KEY_FILTER);
                sb.append("=");
                sb.append(this.filter);
            }
            if (this.pageIndex >= 0) {
                sb.append("&");
                sb.append("page_index");
                sb.append("=");
                sb.append(this.pageIndex);
            }
            int i2 = this.pageSize;
            if (i2 >= 0 && i2 <= 50) {
                sb.append("&");
                sb.append("page_size");
                sb.append("=");
                sb.append(this.pageSize);
            }
            return sb.toString();
        }
        return null;
    }
}
