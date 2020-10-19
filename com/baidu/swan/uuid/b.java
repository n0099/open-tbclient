package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes5.dex */
public class b {
    private static b dYP;
    private final a<String> dYQ = new a<>();
    private String dYR;

    private b(Context context) {
        this.dYQ.a(new c(context));
        this.dYQ.a(new e(context));
        this.dYQ.a(new d(context));
        this.dYQ.a(new g(context));
        this.dYQ.a(new com.baidu.swan.uuid.a.a(context));
        this.dYQ.a(new f(context));
    }

    public static b dO(Context context) {
        if (dYP == null) {
            synchronized (b.class) {
                if (dYP == null) {
                    dYP = new b(context);
                }
            }
        }
        return dYP;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dYR)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dYR)) {
                    this.dYR = this.dYQ.aZT();
                    this.dYQ.ap(this.dYR);
                }
            }
        }
        return this.dYR;
    }
}
