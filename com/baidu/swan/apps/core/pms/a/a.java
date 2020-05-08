package com.baidu.swan.apps.core.pms.a;

import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes11.dex */
public class a extends f {
    private InterfaceC0300a bOW;

    /* renamed from: com.baidu.swan.apps.core.pms.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0300a {
        void Xw();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0300a interfaceC0300a) {
        super(str);
        this.bOW = interfaceC0300a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void WZ() {
        super.WZ();
        eN(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        eN(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void Xf() {
        if (Xo() == null) {
            eN(1);
        } else {
            eN(-1);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType Xg() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void o(Throwable th) {
        eN(-1);
    }

    private void eN(final int i) {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.core.pms.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bOW != null) {
                    switch (i) {
                        case -1:
                            a.this.bOW.onError();
                            return;
                        case 0:
                            a.this.bOW.Xw();
                            return;
                        case 1:
                            a.this.bOW.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
