package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class b implements a {
    private a.InterfaceC0190a bmd;
    private com.baidu.live.noble.c.a bme;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0190a interfaceC0190a) {
        this.bmd = interfaceC0190a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Ny() {
        if (this.bme == null) {
            this.bme = new com.baidu.live.noble.c.b();
            this.bme.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.bmd != null) {
                        b.this.bmd.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bme.NE();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bmd = null;
        if (this.bme != null) {
            this.bme.release();
            this.bme = null;
        }
    }
}
