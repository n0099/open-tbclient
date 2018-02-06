package com.baidu.fsg.base.restnet.b;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestMultipartEntity;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private static e a;

    private e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public com.baidu.fsg.base.restnet.rest.d a(Context context, String str, String str2, String str3, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str4, boolean z) {
        return new f(new com.baidu.fsg.base.restnet.rest.c(new c(context, str2, z)), str3, httpMethod, list, restMultipartEntity, str4);
    }
}
