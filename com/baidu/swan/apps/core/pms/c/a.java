package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes25.dex */
public class a extends f {
    private InterfaceC0437a cTb;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0437a {
        void atg();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0437a interfaceC0437a) {
        super(str);
        this.cTb = interfaceC0437a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int asL() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        iF(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        iF(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void asP() {
        super.asP();
        if (asX() == null) {
            iF(1);
            bE("page_route_download", "0");
            return;
        }
        iF(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType asQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        iF(-1);
    }

    private void iF(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cTb != null) {
                    switch (i) {
                        case -1:
                            a.this.cTb.onError();
                            return;
                        case 0:
                            a.this.cTb.atg();
                            return;
                        case 1:
                            a.this.cTb.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
