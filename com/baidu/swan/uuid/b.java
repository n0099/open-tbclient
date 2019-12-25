package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.a.c;
import com.baidu.swan.uuid.a.d;
import com.baidu.swan.uuid.a.e;
import com.baidu.swan.uuid.a.f;
import com.baidu.swan.uuid.a.g;
/* loaded from: classes9.dex */
public class b {
    private static b cBz;
    private final a<String> cBA = new a<>();
    private String cBB;

    private b(Context context) {
        this.cBA.a(new c(context));
        this.cBA.a(new e(context));
        this.cBA.a(new d(context));
        this.cBA.a(new g(context));
        this.cBA.a(new com.baidu.swan.uuid.a.a(context));
        this.cBA.a(new f(context));
    }

    public static b dD(Context context) {
        if (cBz == null) {
            synchronized (b.class) {
                if (cBz == null) {
                    cBz = new b(context);
                }
            }
        }
        return cBz;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.cBB)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.cBB)) {
                    this.cBB = this.cBA.atz();
                    this.cBA.ab(this.cBB);
                }
            }
        }
        return this.cBB;
    }
}
