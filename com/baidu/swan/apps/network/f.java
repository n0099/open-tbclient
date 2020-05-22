package com.baidu.swan.apps.network;

import com.baidu.android.imsdk.utils.HttpHelper;
import okhttp3.MediaType;
/* loaded from: classes11.dex */
public interface f {

    /* loaded from: classes11.dex */
    public interface a {
        public static final MediaType cpR = MediaType.parse(HttpHelper.CONTENT_JSON);
        public static final MediaType cpS = MediaType.parse("application/x-www-form-urlencoded");
    }
}
