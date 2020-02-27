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
    private static b cFI;
    private final a<String> cFJ = new a<>();
    private String cFK;

    private b(Context context) {
        this.cFJ.a(new c(context));
        this.cFJ.a(new e(context));
        this.cFJ.a(new d(context));
        this.cFJ.a(new g(context));
        this.cFJ.a(new com.baidu.swan.uuid.a.a(context));
        this.cFJ.a(new f(context));
    }

    public static b dH(Context context) {
        if (cFI == null) {
            synchronized (b.class) {
                if (cFI == null) {
                    cFI = new b(context);
                }
            }
        }
        return cFI;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.cFK)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.cFK)) {
                    this.cFK = this.cFJ.awg();
                    this.cFJ.ad(this.cFK);
                }
            }
        }
        return this.cFK;
    }
}
