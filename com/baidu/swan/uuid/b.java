package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes3.dex */
public class b {
    private static b dKL;
    private final a<String> dKM = new a<>();
    private String dKN;

    private b(Context context) {
        this.dKM.a(new c(context));
        this.dKM.a(new e(context));
        this.dKM.a(new d(context));
        this.dKM.a(new g(context));
        this.dKM.a(new com.baidu.swan.uuid.a.a(context));
        this.dKM.a(new f(context));
    }

    public static b dJ(Context context) {
        if (dKL == null) {
            synchronized (b.class) {
                if (dKL == null) {
                    dKL = new b(context);
                }
            }
        }
        return dKL;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dKN)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dKN)) {
                    this.dKN = this.dKM.aWz();
                    this.dKM.al(this.dKN);
                }
            }
        }
        return this.dKN;
    }
}
