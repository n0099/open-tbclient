package com.baidu.c.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.c.a {
    private long awx;
    private int awy;

    @Override // com.baidu.c.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.c.a.c.b bVar) {
        try {
            this.awy++;
            if (xk()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.c.b.a aB = com.baidu.c.b.a.aB(context);
                c m14do = ((com.baidu.c.b.a.a.b) aB.xc()).m14do(str2);
                if (m14do != null) {
                    BIMConversation xh = ((com.baidu.c.b.a.a) m14do).xh();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.aww = i2;
                    aVar.sourceType = 0;
                    com.baidu.c.a.a.a xd = aB.xd();
                    if (xd != null && xd.isLogin() && xd.wU() != null) {
                        try {
                            aVar.uid = Long.parseLong(aB.xd().wU().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.c.b.b xg = aB.xg();
                    if (xg != null) {
                        aVar.awa = xg.awa;
                        aVar.cuid = xg.cuid;
                    }
                    xh.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.c.b.b.b.1
                        @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                        public void onResult(int i3, long j, long j2) {
                            if (bVar != null) {
                                bVar.onResult(i3, j, j2);
                            }
                        }
                    });
                } else if (bVar != null) {
                    bVar.onResult(-1, parseLong, parseLong2);
                }
                this.awy = 0;
                this.awx = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean xk() {
        if (this.awx == 0) {
            this.awx = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.awx > 1200 && this.awy > 0;
    }
}
