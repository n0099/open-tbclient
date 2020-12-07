package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class c implements a {
    private a.InterfaceC0199a bsu;
    private com.baidu.live.noble.c.a bsv;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0199a interfaceC0199a) {
        this.bsu = interfaceC0199a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Qg() {
        if (this.bsv == null) {
            this.bsv = new com.baidu.live.noble.c.b();
            this.bsv.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bsu != null) {
                        c.this.bsu.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bsv.Ql();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bsu = null;
        if (this.bsv != null) {
            this.bsv.release();
            this.bsv = null;
        }
    }
}
