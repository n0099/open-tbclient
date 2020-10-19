package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes10.dex */
public class a extends f {
    private InterfaceC0401a czD;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0401a {
        void aml();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0401a interfaceC0401a) {
        super(str);
        this.czD = interfaceC0401a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int alQ() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiW() {
        super.aiW();
        hQ(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        hQ(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void alU() {
        super.alU();
        if (amc() == null) {
            hQ(1);
            br("page_route_download", "0");
            return;
        }
        hQ(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType alV() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        hQ(-1);
    }

    private void hQ(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.czD != null) {
                    switch (i) {
                        case -1:
                            a.this.czD.onError();
                            return;
                        case 0:
                            a.this.czD.aml();
                            return;
                        case 1:
                            a.this.czD.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
