package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.d.d;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a bUa;
    private com.baidu.live.yuyinnoble.d.a bUb;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.bUa = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aB(String str, String str2) {
        if (this.bUb == null) {
            this.bUb = new com.baidu.live.yuyinnoble.d.b();
            this.bUb.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.d.d, com.baidu.live.yuyinnoble.d.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.bUa != null) {
                        a.this.bUa.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bUb.aW(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.bUa = null;
        if (this.bUb != null) {
            this.bUb.release();
            this.bUb = null;
        }
    }
}
