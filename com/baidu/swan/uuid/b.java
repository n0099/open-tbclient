package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes6.dex */
public class b {
    private static b eCi;
    private final a<String> eCj = new a<>();
    private String eCk;

    private b(Context context) {
        this.eCj.a(new c(context));
        this.eCj.a(new e(context));
        this.eCj.a(new d(context));
        this.eCj.a(new g(context));
        this.eCj.a(new com.baidu.swan.uuid.a.a(context));
        this.eCj.a(new f(context));
    }

    public static b eM(Context context) {
        if (eCi == null) {
            synchronized (b.class) {
                if (eCi == null) {
                    eCi = new b(context);
                }
            }
        }
        return eCi;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.eCk)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.eCk)) {
                    this.eCk = this.eCj.bjh();
                    this.eCj.ar(this.eCk);
                }
            }
        }
        return this.eCk;
    }
}
