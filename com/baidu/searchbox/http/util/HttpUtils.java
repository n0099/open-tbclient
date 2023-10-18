package com.baidu.searchbox.http.util;

import java.util.UUID;
/* loaded from: classes4.dex */
public final class HttpUtils {
    public static String generateBdTraceId() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
}
