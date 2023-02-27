package com.baidu.ar.child.b;

import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, HashMap hashMap, com.baidu.ar.ihttp.a aVar) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest != null) {
            newRequest.setMethod("POST").setUrl(str).addFormData(hashMap);
            newRequest.enqueue(aVar);
        }
    }
}
