package com.baidu.d.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.d.a.b.c;
/* loaded from: classes4.dex */
public class b implements com.baidu.d.a.c.a {
    private long bsd;
    private int bse;

    @Override // com.baidu.d.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.d.a.c.b bVar) {
        try {
            this.bse++;
            if (Lq()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.d.b.a aA = com.baidu.d.b.a.aA(context);
                c gi = ((com.baidu.d.b.a.a.b) aA.Li()).gi(str2);
                if (gi != null) {
                    BIMConversation Ln = ((com.baidu.d.b.a.a) gi).Ln();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bsc = i2;
                    aVar.sourceType = 0;
                    com.baidu.d.a.a.a Lj = aA.Lj();
                    if (Lj != null && Lj.isLogin() && Lj.Lb() != null) {
                        try {
                            aVar.uid = Long.parseLong(aA.Lj().Lb().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.d.b.b Lm = aA.Lm();
                    if (Lm != null) {
                        aVar.brG = Lm.brG;
                        aVar.cuid = Lm.cuid;
                    }
                    Ln.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.d.b.b.b.1
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
                this.bse = 0;
                this.bsd = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Lq() {
        if (this.bsd == 0) {
            this.bsd = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bsd > 1200 && this.bse > 0;
    }
}
