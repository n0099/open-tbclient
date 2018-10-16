package com.baidu.searchbox.dns.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class b<T> extends a<T> {
    protected abstract String o();

    @Override // com.baidu.searchbox.dns.d.c.a
    protected String getUrl() {
        StringBuilder sb = new StringBuilder();
        String o = o();
        Map<String, Object> parameters = getParameters();
        sb.append(o.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
        String a = a(parameters);
        if (!TextUtils.isEmpty(a)) {
            sb.append(a);
        }
        return o + sb.toString();
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    protected void b(HttpURLConnection httpURLConnection) {
    }
}
