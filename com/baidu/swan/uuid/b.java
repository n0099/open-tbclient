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
    private static b ene;
    private final a<String> enf = new a<>();
    private String eng;

    private b(Context context) {
        this.enf.a(new c(context));
        this.enf.a(new e(context));
        this.enf.a(new d(context));
        this.enf.a(new g(context));
        this.enf.a(new com.baidu.swan.uuid.a.a(context));
        this.enf.a(new f(context));
    }

    public static b dO(Context context) {
        if (ene == null) {
            synchronized (b.class) {
                if (ene == null) {
                    ene = new b(context);
                }
            }
        }
        return ene;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.eng)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.eng)) {
                    this.eng = this.enf.bem();
                    this.enf.ap(this.eng);
                }
            }
        }
        return this.eng;
    }
}
