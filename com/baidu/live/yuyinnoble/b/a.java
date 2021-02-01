package com.baidu.live.yuyinnoble.b;

import com.baidu.live.noble.b.b;
import com.baidu.live.noble.data.NobleUserInfo;
import com.baidu.live.yuyinnoble.c.d;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.noble.b.b {
    private b.a cdI;
    private com.baidu.live.yuyinnoble.c.a cdJ;

    @Override // com.baidu.live.noble.b.b
    public void a(b.a aVar) {
        this.cdI = aVar;
    }

    @Override // com.baidu.live.noble.b.b
    public void aB(String str, String str2) {
        if (this.cdJ == null) {
            this.cdJ = new com.baidu.live.yuyinnoble.c.b();
            this.cdJ.a(new d() { // from class: com.baidu.live.yuyinnoble.b.a.1
                @Override // com.baidu.live.yuyinnoble.c.d, com.baidu.live.yuyinnoble.c.c
                public void b(NobleUserInfo nobleUserInfo) {
                    super.b(nobleUserInfo);
                    if (a.this.cdI != null) {
                        a.this.cdI.a(nobleUserInfo);
                    }
                }
            });
        }
        this.cdJ.aY(str, str2);
    }

    @Override // com.baidu.live.noble.b.b
    public void release() {
        this.cdI = null;
        if (this.cdJ != null) {
            this.cdJ.release();
            this.cdJ = null;
        }
    }
}
