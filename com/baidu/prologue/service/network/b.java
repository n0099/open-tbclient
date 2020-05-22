package com.baidu.prologue.service.network;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class b implements e {
    /* JADX INFO: Access modifiers changed from: protected */
    public static String d(String str, Map<String, String> map) throws URISyntaxException {
        if (map != null && map.size() != 0) {
            URI create = URI.create(str);
            StringBuilder sb = new StringBuilder(TextUtils.isEmpty(create.getQuery()) ? "" : create.getQuery());
            if (sb.length() > 0) {
                sb.append('&');
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(ETAG.EQUAL);
                sb.append(entry.getValue());
                sb.append('&');
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return new URI(create.getScheme(), create.getAuthority(), create.getPath(), sb.toString(), create.getFragment()).toString();
        }
        return str;
    }
}
