package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Bz(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                return true;
            }
            if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                return url.getHost().endsWith(".baidu.com");
            }
            return false;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean BA(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                return true;
            }
            if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                if (url.getHost().endsWith(".baidu.com")) {
                    if (str.contains("tieba_hybrid_enabled=1")) {
                        return true;
                    }
                    if (str.contains("tieba_hybrid_enabled%3D1")) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
