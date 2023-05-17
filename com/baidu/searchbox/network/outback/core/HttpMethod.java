package com.baidu.searchbox.network.outback.core;

import org.apache.http.client.methods.HttpPut;
/* loaded from: classes3.dex */
public final class HttpMethod {
    public static boolean permitsRequestBody(String str) {
        if (!str.equals("GET") && !str.equals("HEAD")) {
            return true;
        }
        return false;
    }

    public static boolean requiresRequestBody(String str) {
        if (!str.equals("POST") && !str.equals(HttpPut.METHOD_NAME) && !str.equals("PATCH") && !str.equals("PROPPATCH") && !str.equals("REPORT")) {
            return false;
        }
        return true;
    }
}
