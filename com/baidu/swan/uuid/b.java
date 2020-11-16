package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes14.dex */
public class b {
    private static b elw;
    private final a<String> elx = new a<>();
    private String ely;

    private b(Context context) {
        this.elx.a(new c(context));
        this.elx.a(new e(context));
        this.elx.a(new d(context));
        this.elx.a(new g(context));
        this.elx.a(new com.baidu.swan.uuid.a.a(context));
        this.elx.a(new f(context));
    }

    public static b dO(Context context) {
        if (elw == null) {
            synchronized (b.class) {
                if (elw == null) {
                    elw = new b(context);
                }
            }
        }
        return elw;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.ely)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.ely)) {
                    this.ely = this.elx.bdF();
                    this.elx.ap(this.ely);
                }
            }
        }
        return this.ely;
    }
}
