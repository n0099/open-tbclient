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
    private static b dKH;
    private final a<String> dKI = new a<>();
    private String dKJ;

    private b(Context context) {
        this.dKI.a(new c(context));
        this.dKI.a(new e(context));
        this.dKI.a(new d(context));
        this.dKI.a(new g(context));
        this.dKI.a(new com.baidu.swan.uuid.a.a(context));
        this.dKI.a(new f(context));
    }

    public static b dJ(Context context) {
        if (dKH == null) {
            synchronized (b.class) {
                if (dKH == null) {
                    dKH = new b(context);
                }
            }
        }
        return dKH;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dKJ)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dKJ)) {
                    this.dKJ = this.dKI.aWz();
                    this.dKI.al(this.dKJ);
                }
            }
        }
        return this.dKJ;
    }
}
