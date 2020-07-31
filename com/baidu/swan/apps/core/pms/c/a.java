package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes7.dex */
public class a extends f {
    private InterfaceC0348a ceO;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0348a {
        void acr();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0348a interfaceC0348a) {
        super(str);
        this.ceO = interfaceC0348a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int abW() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        fo(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        fo(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aca() {
        super.aca();
        if (aci() == null) {
            fo(1);
            be("page_route_download", "0");
            return;
        }
        fo(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType acb() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        fo(-1);
    }

    private void fo(final int i) {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ceO != null) {
                    switch (i) {
                        case -1:
                            a.this.ceO.onError();
                            return;
                        case 0:
                            a.this.ceO.acr();
                            return;
                        case 1:
                            a.this.ceO.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
