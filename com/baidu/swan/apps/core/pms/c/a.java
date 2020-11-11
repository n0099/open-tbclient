package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes10.dex */
public class a extends f {
    private InterfaceC0427a cNS;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0427a {
        void aqG();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0427a interfaceC0427a) {
        super(str);
        this.cNS = interfaceC0427a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aql() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        il(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        il(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aqp() {
        super.aqp();
        if (aqx() == null) {
            il(1);
            by("page_route_download", "0");
            return;
        }
        il(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqq() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        il(-1);
    }

    private void il(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cNS != null) {
                    switch (i) {
                        case -1:
                            a.this.cNS.onError();
                            return;
                        case 0:
                            a.this.cNS.aqG();
                            return;
                        case 1:
                            a.this.cNS.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
