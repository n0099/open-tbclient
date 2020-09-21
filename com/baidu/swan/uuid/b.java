package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes24.dex */
public class b {
    private static b dMO;
    private final a<String> dMP = new a<>();
    private String dMQ;

    private b(Context context) {
        this.dMP.a(new c(context));
        this.dMP.a(new e(context));
        this.dMP.a(new d(context));
        this.dMP.a(new g(context));
        this.dMP.a(new com.baidu.swan.uuid.a.a(context));
        this.dMP.a(new f(context));
    }

    public static b dI(Context context) {
        if (dMO == null) {
            synchronized (b.class) {
                if (dMO == null) {
                    dMO = new b(context);
                }
            }
        }
        return dMO;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dMQ)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dMQ)) {
                    this.dMQ = this.dMP.aXl();
                    this.dMP.am(this.dMQ);
                }
            }
        }
        return this.dMQ;
    }
}
