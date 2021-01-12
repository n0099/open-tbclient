package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes8.dex */
public class a extends f {
    private InterfaceC0412a cTm;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0412a {
        void aqD();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0412a interfaceC0412a) {
        super(str);
        this.cTm = interfaceC0412a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqi() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        gU(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        gU(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aqm() {
        super.aqm();
        if (aqu() == null) {
            gU(1);
            bC("page_route_download", "0");
            return;
        }
        gU(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqn() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        gU(-1);
    }

    private void gU(final int i) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cTm != null) {
                    switch (i) {
                        case -1:
                            a.this.cTm.onError();
                            return;
                        case 0:
                            a.this.cTm.aqD();
                            return;
                        case 1:
                            a.this.cTm.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
