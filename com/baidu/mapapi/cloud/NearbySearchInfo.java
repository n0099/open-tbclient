package com.baidu.mapapi.cloud;

import android.content.ContentValues;
import com.baidu.mapapi.GeoPoint;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class NearbySearchInfo {
    public String ak;
    public GeoPoint location;
    public String queryWords;
    public String sn;
    public int radius = 1000;
    public ContentValues filter = new ContentValues();
    public int scope = 1;
    public int pageIndex = 0;
    public int pageSize = 10;
    public int timeStamp = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        if (this.queryWords == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("?");
        if (this.queryWords != null) {
            try {
                sb.append("q=").append(URLEncoder.encode(this.queryWords, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (this.location != null) {
            sb.append("&location=").append(this.location.getLatitudeE6() / 1000000.0d).append(',').append(this.location.getLongitudeE6() / 1000000.0d);
        }
        sb.append("&radius=").append(this.radius);
        if (this.filter.size() > 0) {
            sb.append("&filter=");
            Iterator<Map.Entry<String, Object>> it = this.filter.valueSet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                sb.append(next.getKey()).append(':').append(next.getValue());
                while (it.hasNext()) {
                    Map.Entry<String, Object> next2 = it.next();
                    sb.append('|').append(next2.getKey()).append(':').append(next2.getValue());
                }
            }
        }
        sb.append("&page_index=").append(this.pageIndex);
        sb.append("&scope=").append(this.scope);
        sb.append("&page_size=").append(this.pageSize);
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
