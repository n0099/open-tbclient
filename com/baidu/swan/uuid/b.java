package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes4.dex */
public class b {
    private static b eBd;
    private final a<String> eBe = new a<>();
    private String eBf;

    private b(Context context) {
        this.eBe.a(new c(context));
        this.eBe.a(new e(context));
        this.eBe.a(new d(context));
        this.eBe.a(new g(context));
        this.eBe.a(new com.baidu.swan.uuid.a.a(context));
        this.eBe.a(new f(context));
    }

    public static b eJ(Context context) {
        if (eBd == null) {
            synchronized (b.class) {
                if (eBd == null) {
                    eBd = new b(context);
                }
            }
        }
        return eBd;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.eBf)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.eBf)) {
                    this.eBf = this.eBe.bfD();
                    this.eBe.at(this.eBf);
                }
            }
        }
        return this.eBf;
    }
}
