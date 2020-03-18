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
    private static b cFV;
    private final a<String> cFW = new a<>();
    private String cFX;

    private b(Context context) {
        this.cFW.a(new c(context));
        this.cFW.a(new e(context));
        this.cFW.a(new d(context));
        this.cFW.a(new g(context));
        this.cFW.a(new com.baidu.swan.uuid.a.a(context));
        this.cFW.a(new f(context));
    }

    public static b dG(Context context) {
        if (cFV == null) {
            synchronized (b.class) {
                if (cFV == null) {
                    cFV = new b(context);
                }
            }
        }
        return cFV;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.cFX)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.cFX)) {
                    this.cFX = this.cFW.awl();
                    this.cFW.ad(this.cFX);
                }
            }
        }
        return this.cFX;
    }
}
