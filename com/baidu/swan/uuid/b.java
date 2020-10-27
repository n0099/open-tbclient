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
    private static b ehm;
    private final a<String> ehn = new a<>();
    private String eho;

    private b(Context context) {
        this.ehn.a(new c(context));
        this.ehn.a(new e(context));
        this.ehn.a(new d(context));
        this.ehn.a(new g(context));
        this.ehn.a(new com.baidu.swan.uuid.a.a(context));
        this.ehn.a(new f(context));
    }

    public static b dO(Context context) {
        if (ehm == null) {
            synchronized (b.class) {
                if (ehm == null) {
                    ehm = new b(context);
                }
            }
        }
        return ehm;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.eho)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.eho)) {
                    this.eho = this.ehn.bbM();
                    this.ehn.ap(this.eho);
                }
            }
        }
        return this.eho;
    }
}
