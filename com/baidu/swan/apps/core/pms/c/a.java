package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes10.dex */
public class a extends f {
    private InterfaceC0415a cHZ;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0415a {
        void aof();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0415a interfaceC0415a) {
        super(str);
        this.cHZ = interfaceC0415a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int anK() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void akQ() {
        super.akQ();
        ib(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        ib(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void anO() {
        super.anO();
        if (anW() == null) {
            ib(1);
            by("page_route_download", "0");
            return;
        }
        ib(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType anP() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        ib(-1);
    }

    private void ib(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cHZ != null) {
                    switch (i) {
                        case -1:
                            a.this.cHZ.onError();
                            return;
                        case 0:
                            a.this.cHZ.aof();
                            return;
                        case 1:
                            a.this.cHZ.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
