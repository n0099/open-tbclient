package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes8.dex */
public class a extends f {
    private InterfaceC0415a cWZ;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0415a {
        void are();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0415a interfaceC0415a) {
        super(str);
        this.cWZ = interfaceC0415a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int aqJ() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anJ() {
        super.anJ();
        gY(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        gY(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aqN() {
        super.aqN();
        if (aqV() == null) {
            gY(1);
            bw("page_route_download", "0");
            return;
        }
        gY(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aqO() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void l(Throwable th) {
        gY(-1);
    }

    private void gY(final int i) {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cWZ != null) {
                    switch (i) {
                        case -1:
                            a.this.cWZ.onError();
                            return;
                        case 0:
                            a.this.cWZ.are();
                            return;
                        case 1:
                            a.this.cWZ.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
