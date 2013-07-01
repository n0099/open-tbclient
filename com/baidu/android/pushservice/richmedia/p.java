package com.baidu.android.pushservice.richmedia;
/* loaded from: classes.dex */
public class p {
    public static n a(o oVar, String str) {
        n nVar = new n();
        nVar.a(oVar);
        switch (oVar) {
            case REQ_TYPE_GET_ZIP:
                nVar.b(str);
                nVar.a("GET");
                return nVar;
            default:
                throw new IllegalArgumentException("illegal request type " + oVar);
        }
    }
}
