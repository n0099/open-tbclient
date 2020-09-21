package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes3.dex */
public class a extends f {
    private InterfaceC0384a cnm;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0384a {
        void ajA();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0384a interfaceC0384a) {
        super(str);
        this.cnm = interfaceC0384a;
    }

    @Override // com.baidu.swan.apps.core.pms.j
    protected int ajf() {
        return 1;
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        ht(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        ht(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void ajj() {
        super.ajj();
        if (ajr() == null) {
            ht(1);
            bm("page_route_download", "0");
            return;
        }
        ht(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType ajk() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        ht(-1);
    }

    private void ht(final int i) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cnm != null) {
                    switch (i) {
                        case -1:
                            a.this.cnm.onError();
                            return;
                        case 0:
                            a.this.cnm.ajA();
                            return;
                        case 1:
                            a.this.cnm.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
