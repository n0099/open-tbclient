package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.l;
import com.baidu.ar.f.p;
/* loaded from: classes3.dex */
class h implements l {
    private l[] jK;
    private volatile boolean jL = false;
    private volatile boolean jM;

    public h(l... lVarArr) {
        this.jK = lVarArr;
    }

    @Override // com.baidu.ar.auth.l
    public void a(l.a aVar) {
        if (this.jK != null) {
            for (l lVar : this.jK) {
                lVar.a(aVar);
            }
        }
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, final j jVar) {
        synchronized (this) {
            if (this.jL) {
                return;
            }
            if (this.jK == null || this.jK.length <= 0) {
                p.a(new Runnable() { // from class: com.baidu.ar.auth.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (jVar != null) {
                            jVar.onError("无效的鉴权组合方式", 0);
                        }
                    }
                }, 0L);
                return;
            }
            this.jL = true;
            final int[] iArr = {0, this.jK.length};
            for (l lVar : this.jK) {
                lVar.doAuth(context, new j() { // from class: com.baidu.ar.auth.h.1
                    @Override // com.baidu.ar.auth.j
                    public void onError(String str, int i) {
                        synchronized (this) {
                            boolean z = h.this.jL;
                            h.this.jL = false;
                            h.this.a((l.a) null);
                            if (z && jVar != null) {
                                jVar.onError(str, i);
                            }
                        }
                    }

                    @Override // com.baidu.ar.auth.j
                    public void onSuccess() {
                        synchronized (this) {
                            if (!h.this.jM && h.this.jL) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                                if (iArr[0] == iArr[1]) {
                                    h.this.jM = true;
                                    if (jVar != null) {
                                        jVar.onSuccess();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
