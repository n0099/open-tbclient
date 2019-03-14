package com.baidu.mapapi.cloud;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public abstract class BaseCloudSearchInfo extends BaseSearchInfo {
    public String filter;
    public int pageIndex;
    public int pageSize = 10;
    public String q;
    public String sortby;
    public String tags;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.cloud.BaseSearchInfo
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (super.a() != null) {
            sb.append(super.a());
            if (this.q != null && !this.q.equals("") && this.q.length() <= 45) {
                sb.append("&");
                sb.append("q");
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(this.q, HTTP.UTF_8));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (this.tags != null && !this.tags.equals("") && this.tags.length() <= 45) {
                sb.append("&");
                sb.append("tags");
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(this.tags, HTTP.UTF_8));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.sortby != null && !this.sortby.equals("")) {
                sb.append("&");
                sb.append("sortby");
                sb.append("=");
                sb.append(this.sortby);
            }
            if (this.filter != null && !this.filter.equals("")) {
                sb.append("&");
                sb.append("filter");
                sb.append("=");
                sb.append(this.filter);
            }
            if (this.pageIndex >= 0) {
                sb.append("&");
                sb.append("page_index");
                sb.append("=");
                sb.append(this.pageIndex);
            }
            if (this.pageSize >= 0 && this.pageSize <= 50) {
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
