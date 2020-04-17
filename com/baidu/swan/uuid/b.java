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
    private static b deW;
    private final a<String> deX = new a<>();
    private String deY;

    private b(Context context) {
        this.deX.a(new c(context));
        this.deX.a(new e(context));
        this.deX.a(new d(context));
        this.deX.a(new g(context));
        this.deX.a(new com.baidu.swan.uuid.a.a(context));
        this.deX.a(new f(context));
    }

    public static b du(Context context) {
        if (deW == null) {
            synchronized (b.class) {
                if (deW == null) {
                    deW = new b(context);
                }
            }
        }
        return deW;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.deY)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.deY)) {
                    this.deY = this.deX.aEw();
                    this.deX.ae(this.deY);
                }
            }
        }
        return this.deY;
    }
}
