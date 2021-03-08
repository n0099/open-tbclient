package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes10.dex */
public class c implements a {
    private a.InterfaceC0195a bxv;
    private com.baidu.live.noble.c.a bxw;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0195a interfaceC0195a) {
        this.bxv = interfaceC0195a;
    }

    @Override // com.baidu.live.noble.b.a
    public void OQ() {
        if (this.bxw == null) {
            this.bxw = new com.baidu.live.noble.c.b();
            this.bxw.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bxv != null) {
                        c.this.bxv.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bxw.OW();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bxv = null;
        if (this.bxw != null) {
            this.bxw.release();
            this.bxw = null;
        }
    }
}
