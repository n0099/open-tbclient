package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class c implements a {
    private a.InterfaceC0191a bnm;
    private com.baidu.live.noble.c.a bnn;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0191a interfaceC0191a) {
        this.bnm = interfaceC0191a;
    }

    @Override // com.baidu.live.noble.b.a
    public void NN() {
        if (this.bnn == null) {
            this.bnn = new com.baidu.live.noble.c.b();
            this.bnn.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bnm != null) {
                        c.this.bnm.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bnn.NS();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bnm = null;
        if (this.bnn != null) {
            this.bnn.release();
            this.bnn = null;
        }
    }
}
