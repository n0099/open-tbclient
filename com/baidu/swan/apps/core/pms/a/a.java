package com.baidu.swan.apps.core.pms.a;

import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.f;
/* loaded from: classes10.dex */
public class a extends f {
    private InterfaceC0239a bmm;

    /* renamed from: com.baidu.swan.apps.core.pms.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0239a {
        void Np();

        void onError();

        void onSuccess();
    }

    public a(String str, InterfaceC0239a interfaceC0239a) {
        super(str);
        this.bmm = interfaceC0239a;
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        es(0);
    }

    @Override // com.baidu.swan.apps.core.pms.f, com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        es(-1);
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void MY() {
        if (Nh() == null) {
            es(1);
        } else {
            es(-1);
        }
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected PMSDownloadType MZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.core.pms.f
    protected void n(Throwable th) {
        es(-1);
    }

    private void es(final int i) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.pms.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bmm != null) {
                    switch (i) {
                        case -1:
                            a.this.bmm.onError();
                            return;
                        case 0:
                            a.this.bmm.Np();
                            return;
                        case 1:
                            a.this.bmm.onSuccess();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
