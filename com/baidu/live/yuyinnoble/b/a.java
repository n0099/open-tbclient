package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.d.d;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a bSq;
    private com.baidu.live.yuyinnoble.d.a bSr;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.bSq = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aA(String str, String str2) {
        if (this.bSr == null) {
            this.bSr = new com.baidu.live.yuyinnoble.d.b();
            this.bSr.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.d.d, com.baidu.live.yuyinnoble.d.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.bSq != null) {
                        a.this.bSq.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bSr.aV(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.bSq = null;
        if (this.bSr != null) {
            this.bSr.release();
            this.bSr = null;
        }
    }
}
