package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes12.dex */
public class b {
    private static b dBw;
    private final a<String> dBx = new a<>();
    private String dBy;

    private b(Context context) {
        this.dBx.a(new c(context));
        this.dBx.a(new e(context));
        this.dBx.a(new d(context));
        this.dBx.a(new g(context));
        this.dBx.a(new com.baidu.swan.uuid.a.a(context));
        this.dBx.a(new f(context));
    }

    public static b dD(Context context) {
        if (dBw == null) {
            synchronized (b.class) {
                if (dBw == null) {
                    dBw = new b(context);
                }
            }
        }
        return dBw;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dBy)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dBy)) {
                    this.dBy = this.dBx.aOb();
                    this.dBx.aj(this.dBy);
                }
            }
        }
        return this.dBy;
    }
}
