package com.baidu.swan.a.c;

import android.support.annotation.NonNull;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes8.dex */
public class b {
    @NonNull
    public static HttpRequestBuilder d(@NonNull com.baidu.swan.a.b.a aVar) {
        HttpCommonRequestBuilder aYo;
        String str = aVar.method;
        char c = 65535;
        switch (str.hashCode()) {
            case -531492226:
                if (str.equals(HttpOptions.METHOD_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case 70454:
                if (str.equals("GET")) {
                    c = 0;
                    break;
                }
                break;
            case 79599:
                if (str.equals(HttpPut.METHOD_NAME)) {
                    c = 4;
                    break;
                }
                break;
            case 2213344:
                if (str.equals(HttpHead.METHOD_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case 2461856:
                if (str.equals("POST")) {
                    c = 3;
                    break;
                }
                break;
            case 80083237:
                if (str.equals(HttpTrace.METHOD_NAME)) {
                    c = 6;
                    break;
                }
                break;
            case 1669334218:
                if (str.equals("CONNECT")) {
                    c = 7;
                    break;
                }
                break;
            case 2012838315:
                if (str.equals(HttpDelete.METHOD_NAME)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a.aYk().getRequest();
            case 1:
                return a.aYk().headerRequest();
            case 2:
                aYo = a.aYk().aYm();
                break;
            case 3:
                aYo = a.aYk().postRequest();
                break;
            case 4:
                aYo = a.aYk().putRequest();
                break;
            case 5:
                aYo = a.aYk().deleteRequest();
                break;
            case 6:
                aYo = a.aYk().aYn();
                break;
            case 7:
                aYo = a.aYk().aYo();
                break;
            default:
                return a.aYk().getRequest();
        }
        if (aVar.requestBody != null) {
            aYo.requestBody(aVar.requestBody);
            return aYo;
        }
        return aYo;
    }
}
