package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes3.dex */
public class b implements a {
    private a.InterfaceC0173a bac;
    private com.baidu.live.noble.c.a bad;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0173a interfaceC0173a) {
        this.bac = interfaceC0173a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Gi() {
        if (this.bad == null) {
            this.bad = new com.baidu.live.noble.c.b();
            this.bad.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.bac != null) {
                        b.this.bac.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bad.Go();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bac = null;
        if (this.bad != null) {
            this.bad.release();
            this.bad = null;
        }
    }
}
