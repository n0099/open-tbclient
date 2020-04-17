package com.baidu.c.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.c.a {
    private long bfd;
    private int bfe;

    @Override // com.baidu.c.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.c.a.c.b bVar) {
        try {
            this.bfe++;
            if (Ii()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.c.b.a aB = com.baidu.c.b.a.aB(context);
                c fp = ((com.baidu.c.b.a.a.b) aB.Ia()).fp(str2);
                if (fp != null) {
                    BIMConversation If = ((com.baidu.c.b.a.a) fp).If();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bfc = i2;
                    aVar.sourceType = 0;
                    com.baidu.c.a.a.a Ib = aB.Ib();
                    if (Ib != null && Ib.isLogin() && Ib.HT() != null) {
                        try {
                            aVar.uid = Long.parseLong(aB.Ib().HT().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.c.b.b Ie = aB.Ie();
                    if (Ie != null) {
                        aVar.beF = Ie.beF;
                        aVar.cuid = Ie.cuid;
                    }
                    If.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.c.b.b.b.1
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
                this.bfe = 0;
                this.bfd = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Ii() {
        if (this.bfd == 0) {
            this.bfd = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bfd > 1200 && this.bfe > 0;
    }
}
