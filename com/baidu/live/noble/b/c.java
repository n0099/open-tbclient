package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class c implements a {
    private a.InterfaceC0193a boX;
    private com.baidu.live.noble.c.a boY;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0193a interfaceC0193a) {
        this.boX = interfaceC0193a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Ow() {
        if (this.boY == null) {
            this.boY = new com.baidu.live.noble.c.b();
            this.boY.a(new com.baidu.live.noble.c.d() { // from class: com.baidu.live.noble.b.c.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (c.this.boX != null) {
                        c.this.boX.a(nobleUserInfo);
                    }
                }
            });
        }
        this.boY.OB();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.boX = null;
        if (this.boY != null) {
            this.boY.release();
            this.boY = null;
        }
    }
}
