package com.baidu.searchbox.network.core;

import java.util.Locale;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes5.dex */
public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    PUT(HttpPut.METHOD_NAME),
    DELETE(HttpDelete.METHOD_NAME),
    HEAD(HttpHead.METHOD_NAME),
    PATCH("PATCH"),
    OPTIONS(HttpOptions.METHOD_NAME),
    TRACE(HttpTrace.METHOD_NAME);
    
    private final String value;

    RequestMethod(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public boolean allowBody() {
        switch (this) {
            case POST:
            case PUT:
            case PATCH:
            case DELETE:
                return true;
            default:
                return false;
        }
    }

    public static RequestMethod reverse(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        char c = 65535;
        switch (upperCase.hashCode()) {
            case -531492226:
                if (upperCase.equals(HttpOptions.METHOD_NAME)) {
                    c = 6;
                    break;
                }
                break;
            case 70454:
                if (upperCase.equals("GET")) {
                    c = 0;
                    break;
                }
                break;
            case 79599:
                if (upperCase.equals(HttpPut.METHOD_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case 2213344:
                if (upperCase.equals(HttpHead.METHOD_NAME)) {
                    c = 4;
                    break;
                }
                break;
            case 2461856:
                if (upperCase.equals("POST")) {
                    c = 1;
                    break;
                }
                break;
            case 75900968:
                if (upperCase.equals("PATCH")) {
                    c = 5;
                    break;
                }
                break;
            case 80083237:
                if (upperCase.equals(HttpTrace.METHOD_NAME)) {
                    c = 7;
                    break;
                }
                break;
            case 2012838315:
                if (upperCase.equals(HttpDelete.METHOD_NAME)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return GET;
            case 1:
                return POST;
            case 2:
                return PUT;
            case 3:
                return DELETE;
            case 4:
                return HEAD;
            case 5:
                return PATCH;
            case 6:
                return OPTIONS;
            case 7:
                return TRACE;
            default:
                return GET;
        }
    }
}
