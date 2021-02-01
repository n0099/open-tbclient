package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes15.dex */
public class b {
    private static b ezC;
    private final a<String> ezD = new a<>();
    private String ezE;

    private b(Context context) {
        this.ezD.a(new c(context));
        this.ezD.a(new e(context));
        this.ezD.a(new d(context));
        this.ezD.a(new g(context));
        this.ezD.a(new com.baidu.swan.uuid.a.a(context));
        this.ezD.a(new f(context));
    }

    public static b eK(Context context) {
        if (ezC == null) {
            synchronized (b.class) {
                if (ezC == null) {
                    ezC = new b(context);
                }
            }
        }
        return ezC;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.ezE)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.ezE)) {
                    this.ezE = this.ezD.bfB();
                    this.ezD.ar(this.ezE);
                }
            }
        }
        return this.ezE;
    }
}
