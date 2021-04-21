package com.baidu.searchbox.dns.d.c;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class b<T> extends a<T> {
    @Override // com.baidu.searchbox.dns.d.c.a
    public void b(HttpURLConnection httpURLConnection) {
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        String q = q();
        Map<String, Object> parameters = getParameters();
        sb.append(q.contains("?") ? "&" : "?");
        String c2 = c(parameters);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(c2);
        }
        return q + sb.toString();
    }

    public abstract String q();
}
