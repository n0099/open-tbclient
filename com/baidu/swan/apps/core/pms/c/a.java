package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes9.dex */
public class a extends f {
    private InterfaceC0409a cVz;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0409a {
        void arb();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0409a interfaceC0409a) {
        super(str);
        this.cVz = interfaceC0409a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqG() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        gX(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        gX(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aqK() {
        super.aqK();
        if (aqS() == null) {
            gX(1);
            bw("page_route_download", "0");
            return;
        }
        gX(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqL() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        gX(-1);
    }

    private void gX(final int i) {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cVz != null) {
                    switch (i) {
                        case -1:
                            a.this.cVz.onError();
                            return;
                        case 0:
                            a.this.cVz.arb();
                            return;
                        case 1:
                            a.this.cVz.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
