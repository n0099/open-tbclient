package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import java.util.List;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f1895a;

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f1895a == null) {
                f1895a = new d();
            }
            dVar = f1895a;
        }
        return dVar;
    }

    public com.baidu.fsg.base.restnet.rest.d a(Context context, String str, String str2, String str3, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        return new e(new com.baidu.fsg.base.restnet.rest.c(new b(context, str2, z)), str3, httpMethod, list, restMultipartEntity, str4);
    }
}
