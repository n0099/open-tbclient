package com.baidu.android.pushservice.richmedia;

import com.baidu.android.pushservice.richmedia.c;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes2.dex */
public class d {
    public static c a(c.a aVar, String str) {
        c cVar = new c();
        cVar.a(aVar);
        switch (aVar) {
            case REQ_TYPE_GET_ZIP:
                cVar.b(str);
                cVar.a(HttpGet.METHOD_NAME);
                break;
        }
        return cVar;
    }
}
