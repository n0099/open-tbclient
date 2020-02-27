package com.baidu.swan.apps.core.pms.a;

import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes11.dex */
public class a extends f {
    private InterfaceC0249a bqw;

    /* renamed from: com.baidu.swan.apps.core.pms.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0249a {
        void PD();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0249a interfaceC0249a) {
        super(str);
        this.bqw = interfaceC0249a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pg() {
        super.Pg();
        eI(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        eI(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Pm() {
        if (Pv() == null) {
            eI(1);
        } else {
            eI(-1);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Pn() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void m(Throwable th) {
        eI(-1);
    }

    private void eI(final int i) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bqw != null) {
                    switch (i) {
                        case -1:
                            a.this.bqw.onError();
                            return;
                        case 0:
                            a.this.bqw.PD();
                            return;
                        case 1:
                            a.this.bqw.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
