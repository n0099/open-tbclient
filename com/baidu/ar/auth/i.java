package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.m;
import com.baidu.ar.g.r;
/* loaded from: classes14.dex */
class i implements m {
    private m[] jB;
    private volatile boolean jC = false;
    private volatile boolean jD;

    public i(m... mVarArr) {
        this.jB = mVarArr;
    }

    @Override // com.baidu.ar.auth.m
    public void a(m.a aVar) {
        if (this.jB != null) {
            for (m mVar : this.jB) {
                mVar.a(aVar);
            }
        }
    }

    @Override // com.baidu.ar.auth.m
    public void doAuth(Context context, final k kVar) {
        synchronized (this) {
            if (this.jC) {
                return;
            }
            if (this.jB == null || this.jB.length <= 0) {
                r.a(new Runnable() { // from class: com.baidu.ar.auth.i.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (kVar != null) {
                            kVar.onError("无效的鉴权组合方式", 0);
                        }
                    }
                }, 0L);
                return;
            }
            this.jC = true;
            final int[] iArr = {0, this.jB.length};
            for (m mVar : this.jB) {
                mVar.doAuth(context, new k() { // from class: com.baidu.ar.auth.i.1
                    @Override // com.baidu.ar.auth.k
                    public void onError(String str, int i) {
                        synchronized (this) {
                            boolean z = i.this.jC;
                            i.this.jC = false;
                            i.this.a((m.a) null);
                            if (z && kVar != null) {
                                kVar.onError(str, i);
                            }
                        }
                    }

                    @Override // com.baidu.ar.auth.k
                    public void onSuccess() {
                        synchronized (this) {
                            if (!i.this.jD && i.this.jC) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                                if (iArr[0] == iArr[1]) {
                                    i.this.jD = true;
                                    if (kVar != null) {
                                        kVar.onSuccess();
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
