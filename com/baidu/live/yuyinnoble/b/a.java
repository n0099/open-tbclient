package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.c.d;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a ces;
    private com.baidu.live.yuyinnoble.c.a cet;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.ces = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aC(String str, String str2) {
        if (this.cet == null) {
            this.cet = new com.baidu.live.yuyinnoble.c.b();
            this.cet.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.c.d, com.baidu.live.yuyinnoble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.ces != null) {
                        a.this.ces.a(nobleUserInfo);
                    }
                }
            });
        }
        this.cet.ba(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.ces = null;
        if (this.cet != null) {
            this.cet.release();
            this.cet = null;
        }
    }
}
