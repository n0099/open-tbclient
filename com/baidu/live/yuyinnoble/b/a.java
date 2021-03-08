package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.c.d;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a cfi;
    private com.baidu.live.yuyinnoble.c.a cfj;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.cfi = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aB(String str, String str2) {
        if (this.cfj == null) {
            this.cfj = new com.baidu.live.yuyinnoble.c.b();
            this.cfj.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.c.d, com.baidu.live.yuyinnoble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.cfi != null) {
                        a.this.cfi.a(nobleUserInfo);
                    }
                }
            });
        }
        this.cfj.aY(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.cfi = null;
        if (this.cfj != null) {
            this.cfj.release();
            this.cfj = null;
        }
    }
}
