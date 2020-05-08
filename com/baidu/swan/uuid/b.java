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
    private static b dfb;
    private final a<String> dfc = new a<>();
    private String dfd;

    private b(Context context) {
        this.dfc.a(new c(context));
        this.dfc.a(new e(context));
        this.dfc.a(new d(context));
        this.dfc.a(new g(context));
        this.dfc.a(new com.baidu.swan.uuid.a.a(context));
        this.dfc.a(new f(context));
    }

    public static b di(Context context) {
        if (dfb == null) {
            synchronized (b.class) {
                if (dfb == null) {
                    dfb = new b(context);
                }
            }
        }
        return dfb;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dfd)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dfd)) {
                    this.dfd = this.dfc.aEw();
                    this.dfc.af(this.dfd);
                }
            }
        }
        return this.dfd;
    }
}
