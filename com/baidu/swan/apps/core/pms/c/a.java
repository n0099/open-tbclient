package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes11.dex */
public class a extends f {
    private InterfaceC0340a bYu;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0340a {
        void aaj();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0340a interfaceC0340a) {
        super(str);
        this.bYu = interfaceC0340a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        eY(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        eY(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void ZR() {
        super.ZR();
        if (aaa() == null) {
            eY(1);
            ba("page_route_download", "0");
            return;
        }
        eY(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType ZS() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        eY(-1);
    }

    private void eY(final int i) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bYu != null) {
                    switch (i) {
                        case -1:
                            a.this.bYu.onError();
                            return;
                        case 0:
                            a.this.bYu.aaj();
                            return;
                        case 1:
                            a.this.bYu.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
