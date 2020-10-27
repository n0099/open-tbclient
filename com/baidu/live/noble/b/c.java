package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class c implements a {
    private a.InterfaceC0191a bnE;
    private com.baidu.live.noble.c.a bnF;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0191a interfaceC0191a) {
        this.bnE = interfaceC0191a;
    }

    @Override // com.baidu.live.noble.b.a
    public void NW() {
        if (this.bnF == null) {
            this.bnF = new com.baidu.live.noble.c.b();
            this.bnF.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bnE != null) {
                        c.this.bnE.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bnF.Ob();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bnE = null;
        if (this.bnF != null) {
            this.bnF.release();
            this.bnF = null;
        }
    }
}
