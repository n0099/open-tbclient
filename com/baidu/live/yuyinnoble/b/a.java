package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.d.d;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a bXG;
    private com.baidu.live.yuyinnoble.d.a bXH;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.bXG = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aE(String str, String str2) {
        if (this.bXH == null) {
            this.bXH = new com.baidu.live.yuyinnoble.d.b();
            this.bXH.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.d.d, com.baidu.live.yuyinnoble.d.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.bXG != null) {
                        a.this.bXG.a(nobleUserInfo);
                    }
                }
            });
        }
        this.bXH.bb(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.bXG = null;
        if (this.bXH != null) {
            this.bXH.release();
            this.bXH = null;
        }
    }
}
