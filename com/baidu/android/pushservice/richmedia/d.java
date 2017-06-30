package com.baidu.android.pushservice.richmedia;

import com.baidu.android.pushservice.richmedia.c;
/* loaded from: classes2.dex */
public class d {
    public static c a(c.a aVar, String str) {
        c cVar = new c();
        cVar.a(aVar);
        switch (aVar) {
            case REQ_TYPE_GET_ZIP:
                cVar.b(str);
                cVar.a("GET");
                break;
            default:
                com.baidu.android.pushservice.g.a.e("RequestFactory", "illegal request type " + aVar);
                break;
        }
        return cVar;
    }
}
