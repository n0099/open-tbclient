package com.baidu.c.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.c.a {
    private long awf;
    private int awg;

    @Override // com.baidu.c.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.c.a.c.b bVar) {
        try {
            this.awg++;
            if (xl()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.c.b.a aB = com.baidu.c.b.a.aB(context);
                c m14do = ((com.baidu.c.b.a.a.b) aB.xd()).m14do(str2);
                if (m14do != null) {
                    BIMConversation xi = ((com.baidu.c.b.a.a) m14do).xi();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.awe = i2;
                    aVar.sourceType = 0;
                    com.baidu.c.a.a.a xe = aB.xe();
                    if (xe != null && xe.isLogin() && xe.wV() != null) {
                        try {
                            aVar.uid = Long.parseLong(aB.xe().wV().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.c.b.b xh = aB.xh();
                    if (xh != null) {
                        aVar.avI = xh.avI;
                        aVar.cuid = xh.cuid;
                    }
                    xi.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.c.b.b.b.1
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
                this.awg = 0;
                this.awf = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean xl() {
        if (this.awf == 0) {
            this.awf = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.awf > 1200 && this.awg > 0;
    }
}
