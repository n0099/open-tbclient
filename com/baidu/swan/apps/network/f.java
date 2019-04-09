package com.baidu.swan.apps.network;

import okhttp3.MediaType;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes2.dex */
public interface f {

    /* loaded from: classes2.dex */
    public interface a {
        public static final MediaType aCo = MediaType.parse("application/json");
        public static final MediaType aCp = MediaType.parse(URLEncodedUtils.CONTENT_TYPE);
    }
}
