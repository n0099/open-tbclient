package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes10.dex */
public class b {
    private static b cBK;
    private final a<String> cBL = new a<>();
    private String cBM;

    private b(Context context) {
        this.cBL.a(new c(context));
        this.cBL.a(new e(context));
        this.cBL.a(new d(context));
        this.cBL.a(new g(context));
        this.cBL.a(new com.baidu.swan.uuid.a.a(context));
        this.cBL.a(new f(context));
    }

    public static b dD(Context context) {
        if (cBK == null) {
            synchronized (b.class) {
                if (cBK == null) {
                    cBK = new b(context);
                }
            }
        }
        return cBK;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.cBM)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.cBM)) {
                    this.cBM = this.cBL.atS();
                    this.cBL.ab(this.cBM);
                }
            }
        }
        return this.cBM;
    }
}
