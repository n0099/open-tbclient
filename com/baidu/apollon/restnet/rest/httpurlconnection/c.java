package com.baidu.apollon.restnet.rest.httpurlconnection;

import android.content.Context;
import com.baidu.apollon.restnet.RestMultipartEntity;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.rest.RestHttpNetwork;
import java.util.List;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f3890a;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f3890a == null) {
                f3890a = new c();
            }
            cVar = f3890a;
        }
        return cVar;
    }

    public com.baidu.apollon.restnet.rest.d a(Context context, String str, String str2, String str3, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        return new RestUrlConnectionRequest(new RestHttpNetwork(new b(context, str2, z)), str3, httpMethod, list, restMultipartEntity, str4);
    }
}
