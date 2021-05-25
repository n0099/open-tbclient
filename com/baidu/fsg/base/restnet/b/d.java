package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import java.util.List;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f5110a;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f5110a == null) {
                f5110a = new d();
            }
            dVar = f5110a;
        }
        return dVar;
    }

    public com.baidu.fsg.base.restnet.rest.d a(Context context, String str, String str2, String str3, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        return new e(new com.baidu.fsg.base.restnet.rest.c(new b(context, str2, z)), str3, httpMethod, list, restMultipartEntity, str4);
    }
}
