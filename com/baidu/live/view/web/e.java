package com.baidu.live.view.web;

import android.graphics.Color;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e {
    public static HashMap fT(String str) {
        HashMap hashMap = new HashMap();
        String replace = str.replace("?", ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (replace.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            String[] split = replace.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split.length >= 2) {
                String[] split2 = split[1].split(ETAG.ITEM_SEPARATOR);
                for (String str2 : split2) {
                    if (str2 != null) {
                        String[] split3 = str2.split(ETAG.EQUAL);
                        if (split3.length >= 2) {
                            hashMap.put(split3[0], split3[1]);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static boolean du(int i) {
        return 1.0d - ((((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i)))) / 255.0d) >= 0.5d;
    }
}
