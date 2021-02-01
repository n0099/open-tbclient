package com.baidu.swan.a.c;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes15.dex */
public class b {
    @NonNull
    public static HttpRequestBuilder d(@NonNull com.baidu.swan.a.b.a aVar) {
        HttpCommonRequestBuilder bcc;
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
                return a.bbY().getRequest();
            case 1:
                return a.bbY().headerRequest();
            case 2:
                bcc = a.bbY().bca();
                break;
            case 3:
                bcc = a.bbY().postRequest();
                break;
            case 4:
                bcc = a.bbY().putRequest();
                break;
            case 5:
                bcc = a.bbY().deleteRequest();
                break;
            case 6:
                bcc = a.bbY().bcb();
                break;
            case 7:
                bcc = a.bbY().bcc();
                break;
            default:
                return a.bbY().getRequest();
        }
        if (aVar.requestBody != null) {
            bcc.requestBody(aVar.requestBody);
            return bcc;
        }
        return bcc;
    }
}
