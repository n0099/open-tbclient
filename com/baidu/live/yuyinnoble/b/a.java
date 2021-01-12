package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.c.d;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a bZC;
    private com.baidu.live.yuyinnoble.c.a bZD;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.bZC = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aB(String str, String str2) {
        if (this.bZD == null) {
            this.bZD = new com.baidu.live.yuyinnoble.c.b();
            this.bZD.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.c.d, com.baidu.live.yuyinnoble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.bZC != null) {
                        a.this.bZC.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bZD.aZ(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.bZC = null;
        if (this.bZD != null) {
            this.bZD.release();
            this.bZD = null;
        }
    }
}
