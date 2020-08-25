package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes8.dex */
public class a extends f {
    private InterfaceC0389a clg;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0389a {
        void aiQ();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0389a interfaceC0389a) {
        super(str);
        this.clg = interfaceC0389a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aiv() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        hk(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        hk(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aiz() {
        super.aiz();
        if (aiH() == null) {
            hk(1);
            bm("page_route_download", "0");
            return;
        }
        hk(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aiA() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        hk(-1);
    }

    private void hk(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.clg != null) {
                    switch (i) {
                        case -1:
                            a.this.clg.onError();
                            return;
                        case 0:
                            a.this.clg.aiQ();
                            return;
                        case 1:
                            a.this.clg.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
