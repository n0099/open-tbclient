package com.baidu.swan.b.c;

import android.support.annotation.NonNull;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes10.dex */
public class b {
    @NonNull
    public static HttpRequestBuilder d(@NonNull com.baidu.swan.b.b.a aVar) {
        HttpCommonRequestBuilder aKy;
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
                return a.aKu().getRequest();
            case 1:
                return a.aKu().headerRequest();
            case 2:
                aKy = a.aKu().aKw();
                break;
            case 3:
                aKy = a.aKu().postRequest();
                break;
            case 4:
                aKy = a.aKu().putRequest();
                break;
            case 5:
                aKy = a.aKu().deleteRequest();
                break;
            case 6:
                aKy = a.aKu().aKx();
                break;
            case 7:
                aKy = a.aKu().aKy();
                break;
            default:
                return a.aKu().getRequest();
        }
        if (aVar.requestBody != null) {
            aKy.requestBody(aVar.requestBody);
            return aKy;
        }
        return aKy;
    }
}
