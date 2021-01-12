package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes10.dex */
public class c implements a {
    private a.InterfaceC0188a bsr;
    private com.baidu.live.noble.c.a bss;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0188a interfaceC0188a) {
        this.bsr = interfaceC0188a;
    }

    @Override // com.baidu.live.noble.b.a
    public void No() {
        if (this.bss == null) {
            this.bss = new com.baidu.live.noble.c.b();
            this.bss.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.bsr != null) {
                        c.this.bsr.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bss.Nu();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bsr = null;
        if (this.bss != null) {
            this.bss.release();
            this.bss = null;
        }
    }
}
