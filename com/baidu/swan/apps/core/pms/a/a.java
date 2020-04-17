package com.baidu.swan.apps.core.pms.a;

import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes11.dex */
public class a extends f {
    private InterfaceC0279a bOR;

    /* renamed from: com.baidu.swan.apps.core.pms.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0279a {
        void Xx();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0279a interfaceC0279a) {
        super(str);
        this.bOR = interfaceC0279a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        eN(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        eN(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Xg() {
        if (Xp() == null) {
            eN(1);
        } else {
            eN(-1);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Xh() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        eN(-1);
    }

    private void eN(final int i) {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.core.pms.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bOR != null) {
                    switch (i) {
                        case -1:
                            a.this.bOR.onError();
                            return;
                        case 0:
                            a.this.bOR.Xx();
                            return;
                        case 1:
                            a.this.bOR.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
