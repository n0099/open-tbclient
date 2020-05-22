package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes3.dex */
public class b implements a {
    private a.InterfaceC0171a aXu;
    private com.baidu.live.noble.c.a aXv;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0171a interfaceC0171a) {
        this.aXu = interfaceC0171a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Fz() {
        if (this.aXv == null) {
            this.aXv = new com.baidu.live.noble.c.b();
            this.aXv.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.aXu != null) {
                        b.this.aXu.a(nobleUserInfo);
                    }
                }
            });
        }
        this.aXv.FF();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.aXu = null;
        if (this.aXv != null) {
            this.aXv.release();
            this.aXv = null;
        }
    }
}
