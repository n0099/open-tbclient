package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.l;
import com.baidu.ar.f.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
class m implements l {
    private final List<String> jE = new ArrayList();

    public m(f fVar) {
        if (fVar == null || fVar.jo == null) {
            return;
        }
        this.jE.addAll(fVar.jo);
    }

    @Override // com.baidu.ar.auth.l
    public void a(l.a aVar) {
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, final j jVar) {
        final String aL = com.baidu.ar.f.j.aL(context.getPackageName());
        final boolean contains = this.jE.contains(aL);
        p.a(new Runnable() { // from class: com.baidu.ar.auth.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (jVar != null) {
                    if (contains) {
                        jVar.onSuccess();
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    Iterator it = m.this.jE.iterator();
                    while (it.hasNext()) {
                        sb.append(((String) it.next()) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    jVar.onError(String.format("包名不符，正确值：%s 现为：%s", sb.toString(), aL), 0);
                }
            }
        }, 0L);
    }
}
