package com.baidu.mapapi.cloud;

import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.webkit.internal.ETAG;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
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
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(IXAdRequestInfo.COST_NAME);
                sb.append(ETAG.EQUAL);
                try {
                    sb.append(URLEncoder.encode(this.q, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (this.tags != null && !this.tags.equals("") && this.tags.length() <= 45) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(CommandMessage.TYPE_TAGS);
                sb.append(ETAG.EQUAL);
                try {
                    sb.append(URLEncoder.encode(this.tags, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.sortby != null && !this.sortby.equals("")) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("sortby");
                sb.append(ETAG.EQUAL);
                sb.append(this.sortby);
            }
            if (this.filter != null && !this.filter.equals("")) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(FilterImageAction.ACTION_NAME);
                sb.append(ETAG.EQUAL);
                sb.append(this.filter);
            }
            if (this.pageIndex >= 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("page_index");
                sb.append(ETAG.EQUAL);
                sb.append(this.pageIndex);
            }
            if (this.pageSize >= 0 && this.pageSize <= 50) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append("page_size");
                sb.append(ETAG.EQUAL);
                sb.append(this.pageSize);
            }
            return sb.toString();
        }
        return null;
    }
}
