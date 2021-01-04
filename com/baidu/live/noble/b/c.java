package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes11.dex */
public class c implements a {
    private a.InterfaceC0197a bxf;
    private com.baidu.live.noble.c.a bxg;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0197a interfaceC0197a) {
        this.bxf = interfaceC0197a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Rj() {
        if (this.bxg == null) {
            this.bxg = new com.baidu.live.noble.c.b();
            this.bxg.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bxf != null) {
                        c.this.bxf.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bxg.Rp();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bxf = null;
        if (this.bxg != null) {
            this.bxg.release();
            this.bxg = null;
        }
    }
}
