package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.k;
import com.baidu.ar.h.r;
/* loaded from: classes6.dex */
class h implements k {
    private k[] jQ;
    private volatile boolean jR = false;
    private volatile boolean jS;

    public h(k... kVarArr) {
        this.jQ = kVarArr;
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        if (this.jQ != null) {
            for (k kVar : this.jQ) {
                kVar.a(aVar);
            }
        }
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, final IAuthCallback iAuthCallback) {
        synchronized (this) {
            if (this.jR) {
                return;
            }
            if (this.jQ == null || this.jQ.length <= 0) {
                r.a(new Runnable() { // from class: com.baidu.ar.auth.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iAuthCallback != null) {
                            iAuthCallback.onError("无效的鉴权组合方式", 0);
                        }
                    }
                }, 0L);
                return;
            }
            this.jR = true;
            final int[] iArr = {0, this.jQ.length};
            for (k kVar : this.jQ) {
                kVar.doAuth(context, new IAuthCallback() { // from class: com.baidu.ar.auth.h.1
                    @Override // com.baidu.ar.auth.IAuthCallback
                    public void onError(String str, int i) {
                        synchronized (this) {
                            boolean z = h.this.jR;
                            h.this.jR = false;
                            h.this.a((k.a) null);
                            if (z && iAuthCallback != null) {
                                iAuthCallback.onError(str, i);
                            }
                        }
                    }

                    @Override // com.baidu.ar.auth.IAuthCallback
                    public void onSuccess() {
                        synchronized (this) {
                            if (!h.this.jS && h.this.jR) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                                if (iArr[0] == iArr[1]) {
                                    h.this.jS = true;
                                    if (iAuthCallback != null) {
                                        iAuthCallback.onSuccess();
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
