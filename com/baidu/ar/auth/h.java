package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.auth.l;
import com.baidu.ar.f.p;
/* loaded from: classes3.dex */
class h implements l {
    private l[] jt;
    private volatile boolean ju = false;
    private volatile boolean jv;

    public h(l... lVarArr) {
        this.jt = lVarArr;
    }

    @Override // com.baidu.ar.auth.l
    public void a(l.a aVar) {
        if (this.jt != null) {
            for (l lVar : this.jt) {
                lVar.a(aVar);
            }
        }
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, final j jVar) {
        synchronized (this) {
            if (this.ju) {
                return;
            }
            if (this.jt == null || this.jt.length <= 0) {
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
            this.ju = true;
            for (l lVar : this.jt) {
                lVar.doAuth(context, new j() { // from class: com.baidu.ar.auth.h.1
                    @Override // com.baidu.ar.auth.j
                    public void onError(String str, int i) {
                        synchronized (this) {
                            boolean z = h.this.ju;
                            h.this.ju = false;
                            if (z && jVar != null) {
                                jVar.onError(str, i);
                            }
                        }
                    }

                    @Override // com.baidu.ar.auth.j
                    public void onSuccess() {
                        synchronized (this) {
                            if (!h.this.jv && h.this.ju) {
                                h.this.jv = true;
                                if (jVar != null) {
                                    jVar.onSuccess();
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
