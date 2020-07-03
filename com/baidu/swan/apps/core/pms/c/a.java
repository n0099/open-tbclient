package com.baidu.swan.apps.core.pms.c;

import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes11.dex */
public class a extends f {
    private InterfaceC0346a cdj;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0346a {
        void abp();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0346a interfaceC0346a) {
        super(str);
        this.cdj = interfaceC0346a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        fj(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        fj(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void aaX() {
        super.aaX();
        if (abg() == null) {
            fj(1);
            bc("page_route_download", "0");
            return;
        }
        fj(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType aaY() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void p(Throwable th) {
        fj(-1);
    }

    private void fj(final int i) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.core.pms.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cdj != null) {
                    switch (i) {
                        case -1:
                            a.this.cdj.onError();
                            return;
                        case 0:
                            a.this.cdj.abp();
                            return;
                        case 1:
                            a.this.cdj.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
