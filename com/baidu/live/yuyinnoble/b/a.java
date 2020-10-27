package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.d.d;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a bOq;
    private com.baidu.live.yuyinnoble.d.a bOr;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.bOq = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aA(String str, String str2) {
        if (this.bOr == null) {
            this.bOr = new com.baidu.live.yuyinnoble.d.b();
            this.bOr.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.d.d, com.baidu.live.yuyinnoble.d.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.bOq != null) {
                        a.this.bOq.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bOr.aV(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.bOq = null;
        if (this.bOr != null) {
            this.bOr.release();
            this.bOr = null;
        }
    }
}
