package com.baidu.swan.apps.core.pms.a;

import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes9.dex */
public class a extends f {
    private InterfaceC0237a blx;

    /* renamed from: com.baidu.swan.apps.core.pms.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0237a {
        void MT();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0237a interfaceC0237a) {
        super(str);
        this.blx = interfaceC0237a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        er(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        er(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MC() {
        if (ML() == null) {
            er(1);
        } else {
            er(-1);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType MD() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        er(-1);
    }

    private void er(final int i) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.blx != null) {
                    switch (i) {
                        case -1:
                            a.this.blx.onError();
                            return;
                        case 0:
                            a.this.blx.MT();
                            return;
                        case 1:
                            a.this.blx.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
