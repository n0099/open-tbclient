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
    private static b esy;
    private String esA;
    private final a<String> esz = new a<>();

    private b(Context context) {
        this.esz.a(new c(context));
        this.esz.a(new e(context));
        this.esz.a(new d(context));
        this.esz.a(new g(context));
        this.esz.a(new com.baidu.swan.uuid.a.a(context));
        this.esz.a(new f(context));
    }

    public static b et(Context context) {
        if (esy == null) {
            synchronized (b.class) {
                if (esy == null) {
                    esy = new b(context);
                }
            }
        }
        return esy;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.esA)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.esA)) {
                    this.esA = this.esz.bgK();
                    this.esz.ap(this.esA);
                }
            }
        }
        return this.esA;
    }
}
