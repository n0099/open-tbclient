package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes7.dex */
public class b implements a {
    private a.InterfaceC0181a bfw;
    private com.baidu.live.noble.c.a bfx;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0181a interfaceC0181a) {
        this.bfw = interfaceC0181a;
    }

    @Override // com.baidu.live.noble.b.a
    public void LQ() {
        if (this.bfx == null) {
            this.bfx = new com.baidu.live.noble.c.b();
            this.bfx.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.bfw != null) {
                        b.this.bfw.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bfx.LW();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.bfw = null;
        if (this.bfx != null) {
            this.bfx.release();
            this.bfx = null;
        }
    }
}
