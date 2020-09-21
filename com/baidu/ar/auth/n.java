package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.m;
import com.baidu.ar.g.r;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
class n implements m {
    private final List<String> jN = new ArrayList();
    private long jO;

    public n(g gVar) {
        if (gVar != null) {
            if (gVar.jv != null) {
                this.jN.addAll(gVar.jv);
            }
            this.jO = gVar.jA;
        }
    }

    @Override // com.baidu.ar.auth.m
    public void a(m.a aVar) {
    }

    public boolean a(Context context, String[] strArr) {
        boolean z;
        String aQ = com.baidu.ar.g.l.aQ(context.getPackageName());
        if (this.jO > 0) {
            long[] a = o.a(10, 50L);
            if (a[0] == 1) {
                z = a[1] <= this.jO;
            } else {
                com.baidu.ar.g.b.b("ARAuth", "time err. " + a[1]);
                z = true;
            }
        } else {
            z = true;
        }
        boolean z2 = z && this.jN.contains(aQ);
        if (strArr != null && strArr.length >= 1) {
            if (!z) {
                strArr[0] = "license已经过期";
            } else if (!z2) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.jN.iterator();
                while (it.hasNext()) {
                    sb.append(it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                strArr[0] = String.format("包名不符，MD5正确值：%s 现为：%s", sb.toString(), aQ);
            }
        }
        return z2;
    }

    @Override // com.baidu.ar.auth.m
    public void doAuth(Context context, final k kVar) {
        final String[] strArr = new String[1];
        final boolean a = a(context, strArr);
        r.a(new Runnable() { // from class: com.baidu.ar.auth.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (kVar != null) {
                    if (a) {
                        kVar.onSuccess();
                    } else {
                        kVar.onError(strArr[0], 0);
                    }
                }
            }
        }, 0L);
    }
}
