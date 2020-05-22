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
    private static b dqU;
    private final a<String> dqV = new a<>();
    private String dqW;

    private b(Context context) {
        this.dqV.a(new c(context));
        this.dqV.a(new e(context));
        this.dqV.a(new d(context));
        this.dqV.a(new g(context));
        this.dqV.a(new com.baidu.swan.uuid.a.a(context));
        this.dqV.a(new f(context));
    }

    public static b dy(Context context) {
        if (dqU == null) {
            synchronized (b.class) {
                if (dqU == null) {
                    dqU = new b(context);
                }
            }
        }
        return dqU;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.dqW)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.dqW)) {
                    this.dqW = this.dqV.aJe();
                    this.dqV.aj(this.dqW);
                }
            }
        }
        return this.dqW;
    }
}
