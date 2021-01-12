package com.baidu.swan.apps.network;

import com.baidu.android.imsdk.utils.HttpHelper;
import okhttp3.MediaType;
/* loaded from: classes8.dex */
public interface f {

    /* loaded from: classes8.dex */
    public interface a {
        public static final MediaType dmC = MediaType.parse(HttpHelper.CONTENT_JSON);
        public static final MediaType dmD = MediaType.parse("application/x-www-form-urlencoded");
    }
}
