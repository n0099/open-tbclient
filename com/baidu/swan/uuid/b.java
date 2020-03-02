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
    private static b cFJ;
    private final a<String> cFK = new a<>();
    private String cFL;

    private b(Context context) {
        this.cFK.a(new c(context));
        this.cFK.a(new e(context));
        this.cFK.a(new d(context));
        this.cFK.a(new g(context));
        this.cFK.a(new com.baidu.swan.uuid.a.a(context));
        this.cFK.a(new f(context));
    }

    public static b dH(Context context) {
        if (cFJ == null) {
            synchronized (b.class) {
                if (cFJ == null) {
                    cFJ = new b(context);
                }
            }
        }
        return cFJ;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.cFL)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.cFL)) {
                    this.cFL = this.cFK.awi();
                    this.cFK.ad(this.cFL);
                }
            }
        }
        return this.cFL;
    }
}
