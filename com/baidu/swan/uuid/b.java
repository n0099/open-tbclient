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
    private static b exu;
    private final a<String> exv = new a<>();
    private String exw;

    private b(Context context) {
        this.exv.a(new c(context));
        this.exv.a(new e(context));
        this.exv.a(new d(context));
        this.exv.a(new g(context));
        this.exv.a(new com.baidu.swan.uuid.a.a(context));
        this.exv.a(new f(context));
    }

    public static b eL(Context context) {
        if (exu == null) {
            synchronized (b.class) {
                if (exu == null) {
                    exu = new b(context);
                }
            }
        }
        return exu;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.exw)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.exw)) {
                    this.exw = this.exv.bfo();
                    this.exv.ar(this.exw);
                }
            }
        }
        return this.exw;
    }
}
