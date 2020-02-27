package com.baidu.searchbox.dns.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes13.dex */
public abstract class b<T> extends a<T> {
    protected abstract String q();

    @Override // com.baidu.searchbox.dns.d.c.a
    protected String getUrl() {
        StringBuilder sb = new StringBuilder();
        String q = q();
        Map<String, Object> parameters = getParameters();
        sb.append(q.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
        String c = c(parameters);
        if (!TextUtils.isEmpty(c)) {
            sb.append(c);
        }
        return q + sb.toString();
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void b(HttpURLConnection httpURLConnection) {
    }
}
