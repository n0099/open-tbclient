package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.k;
import com.baidu.ar.h.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l implements k {
    public final List<String> kc;
    public long kd;

    public l(f fVar) {
        ArrayList arrayList = new ArrayList();
        this.kc = arrayList;
        if (fVar != null) {
            List<String> list = fVar.jK;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.kd = fVar.jP;
        }
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Context context, String[] strArr) {
        boolean z;
        String aT = com.baidu.ar.h.l.aT(context.getPackageName());
        if (this.kd > 0) {
            long[] a = m.a(10, 50L);
            if (a[0] != 1) {
                com.baidu.ar.h.b.b("ARAuth", "time err. " + a[1]);
            } else if (a[1] > this.kd) {
                z = false;
                boolean z2 = !z && this.kc.contains(aT);
                if (strArr != null && strArr.length >= 1) {
                    if (z) {
                        strArr[0] = "license已经过期";
                    } else if (!z2) {
                        StringBuilder sb = new StringBuilder();
                        Iterator<String> it = this.kc.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next() + ",");
                        }
                        strArr[0] = String.format("包名不符，MD5正确值：%s 现为：%s", sb.toString(), aT);
                    }
                }
                return z2;
            }
        }
        z = true;
        if (z) {
        }
        if (strArr != null) {
            if (z) {
            }
        }
        return z2;
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, final IAuthCallback iAuthCallback) {
        final String[] strArr = new String[1];
        final boolean a = a(context, strArr);
        r.a(new Runnable() { // from class: com.baidu.ar.auth.l.1
            @Override // java.lang.Runnable
            public void run() {
                IAuthCallback iAuthCallback2 = iAuthCallback;
                if (iAuthCallback2 != null) {
                    if (a) {
                        iAuthCallback2.onSuccess();
                    } else {
                        iAuthCallback2.onError(strArr[0], 0);
                    }
                }
            }
        }, 0L);
    }
}
