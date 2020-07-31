package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class b implements a {
    private a.InterfaceC0173a baa;
    private com.baidu.live.noble.c.a bab;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0173a interfaceC0173a) {
        this.baa = interfaceC0173a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Gc() {
        if (this.bab == null) {
            this.bab = new com.baidu.live.noble.c.b();
            this.bab.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.baa != null) {
                        b.this.baa.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bab.Gi();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.baa = null;
        if (this.bab != null) {
            this.bab.release();
            this.bab = null;
        }
    }
}
