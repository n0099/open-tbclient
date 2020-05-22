package com.baidu.swan.c.c;

import android.support.annotation.NonNull;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes11.dex */
public class b {
    @NonNull
    public static HttpRequestBuilder d(@NonNull com.baidu.swan.c.b.a aVar) {
        HttpCommonRequestBuilder aFB;
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
                return a.aFx().getRequest();
            case 1:
                return a.aFx().headerRequest();
            case 2:
                aFB = a.aFx().aFz();
                break;
            case 3:
                aFB = a.aFx().postRequest();
                break;
            case 4:
                aFB = a.aFx().putRequest();
                break;
            case 5:
                aFB = a.aFx().deleteRequest();
                break;
            case 6:
                aFB = a.aFx().aFA();
                break;
            case 7:
                aFB = a.aFx().aFB();
                break;
            default:
                return a.aFx().getRequest();
        }
        if (aVar.requestBody != null) {
            aFB.requestBody(aVar.requestBody);
            return aFB;
        }
        return aFB;
    }
}
