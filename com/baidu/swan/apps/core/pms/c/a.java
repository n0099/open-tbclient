package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes9.dex */
public class a extends f {
    private InterfaceC0429a cXY;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0429a {
        void auy();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0429a interfaceC0429a) {
        super(str);
        this.cXY = interfaceC0429a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aud() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ard() {
        super.ard();
        iA(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        iA(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void auh() {
        super.auh();
        if (aup() == null) {
            iA(1);
            bD("page_route_download", "0");
            return;
        }
        iA(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aui() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        iA(-1);
    }

    private void iA(final int i) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cXY != null) {
                    switch (i) {
                        case -1:
                            a.this.cXY.onError();
                            return;
                        case 0:
                            a.this.cXY.auy();
                            return;
                        case 1:
                            a.this.cXY.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
