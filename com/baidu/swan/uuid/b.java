package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes11.dex */
public class b {
    private static b dvG;
    private final a<String> dvH = new a<>();
    private String dvI;

    private b(Context context) {
        this.dvH.a(new c(context));
        this.dvH.a(new e(context));
        this.dvH.a(new d(context));
        this.dvH.a(new g(context));
        this.dvH.a(new com.baidu.swan.uuid.a.a(context));
        this.dvH.a(new f(context));
    }

    public static b dz(Context context) {
        if (dvG == null) {
            synchronized (b.class) {
                if (dvG == null) {
                    dvG = new b(context);
                }
            }
        }
        return dvG;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dvI)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dvI)) {
                    this.dvI = this.dvH.aKk();
                    this.dvH.aj(this.dvI);
                }
            }
        }
        return this.dvI;
    }
}
