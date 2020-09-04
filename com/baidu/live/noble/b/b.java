package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes7.dex */
public class b implements a {
    private a.InterfaceC0181a bfy;
    private com.baidu.live.noble.c.a bfz;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0181a interfaceC0181a) {
        this.bfy = interfaceC0181a;
    }

    @Override // com.baidu.live.noble.b.a
    public void LQ() {
        if (this.bfz == null) {
            this.bfz = new com.baidu.live.noble.c.b();
            this.bfz.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.bfy != null) {
                        b.this.bfy.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bfz.LW();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bfy = null;
        if (this.bfz != null) {
            this.bfz.release();
            this.bfz = null;
        }
    }
}
