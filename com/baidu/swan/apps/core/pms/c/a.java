package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes7.dex */
public class a extends f {
    private InterfaceC0425a cMi;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0425a {
        void apY();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0425a interfaceC0425a) {
        super(str);
        this.cMi = interfaceC0425a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int apD() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void amI() {
        super.amI();
        ih(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        ih(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void apH() {
        super.apH();
        if (apP() == null) {
            ih(1);
            bx("page_route_download", "0");
            return;
        }
        ih(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType apI() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        ih(-1);
    }

    private void ih(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cMi != null) {
                    switch (i) {
                        case -1:
                            a.this.cMi.onError();
                            return;
                        case 0:
                            a.this.cMi.apY();
                            return;
                        case 1:
                            a.this.cMi.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
