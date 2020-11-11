package com.baidu.swan.apps.network;

import com.baidu.android.imsdk.utils.HttpHelper;
import okhttp3.MediaType;
/* loaded from: classes10.dex */
public interface f {

    /* loaded from: classes10.dex */
    public interface a {
        public static final MediaType dhb = MediaType.parse(HttpHelper.CONTENT_JSON);
        public static final MediaType dhc = MediaType.parse("application/x-www-form-urlencoded");
    }
}
