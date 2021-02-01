package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes11.dex */
public class c implements a {
    private a.InterfaceC0189a bvV;
    private com.baidu.live.noble.c.a bvW;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0189a interfaceC0189a) {
        this.bvV = interfaceC0189a;
    }

    @Override // com.baidu.live.noble.b.a
    public void ON() {
        if (this.bvW == null) {
            this.bvW = new com.baidu.live.noble.c.b();
            this.bvW.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bvV != null) {
                        c.this.bvV.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bvW.OT();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bvV = null;
        if (this.bvW != null) {
            this.bvW.release();
            this.bvW = null;
        }
    }
}
