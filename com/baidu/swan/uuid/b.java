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
    private static b cFK;
    private final a<String> cFL = new a<>();
    private String cFM;

    private b(Context context) {
        this.cFL.a(new c(context));
        this.cFL.a(new e(context));
        this.cFL.a(new d(context));
        this.cFL.a(new g(context));
        this.cFL.a(new com.baidu.swan.uuid.a.a(context));
        this.cFL.a(new f(context));
    }

    public static b dH(Context context) {
        if (cFK == null) {
            synchronized (b.class) {
                if (cFK == null) {
                    cFK = new b(context);
                }
            }
        }
        return cFK;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.cFM)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.cFM)) {
                    this.cFM = this.cFL.awi();
                    this.cFL.ad(this.cFM);
                }
            }
        }
        return this.cFM;
    }
}
