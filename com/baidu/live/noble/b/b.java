package com.baidu.live.noble.b;

import com.baidu.live.noble.b.a;
import com.baidu.live.noble.c.d;
import com.baidu.live.noble.data.NobleUserInfo;
/* loaded from: classes4.dex */
public class b implements a {
    private a.InterfaceC0182a biq;
    private com.baidu.live.noble.c.a bir;

    @Override // com.baidu.live.noble.b.a
    public void a(a.InterfaceC0182a interfaceC0182a) {
        this.biq = interfaceC0182a;
    }

    @Override // com.baidu.live.noble.b.a
    public void Mt() {
        if (this.bir == null) {
            this.bir = new com.baidu.live.noble.c.b();
            this.bir.a(new d() { // from class: com.baidu.live.noble.b.b.1
                @Override // com.baidu.live.noble.c.d, com.baidu.live.noble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (b.this.biq != null) {
                        b.this.biq.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bir.Mz();
    }

    @Override // com.baidu.live.noble.b.a
    public void release() {
        this.biq = null;
        if (this.bir != null) {
            this.bir.release();
            this.bir = null;
        }
    }
}
