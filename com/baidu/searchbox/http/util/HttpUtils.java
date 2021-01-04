package com.baidu.searchbox.http.util;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
/* loaded from: classes15.dex */
public final class HttpUtils {
    public static String generateBdTraceId() {
        return UUID.randomUUID().toString().toLowerCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }
}
