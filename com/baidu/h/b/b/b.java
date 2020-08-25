package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes18.dex */
public class b implements com.baidu.h.a.c.a {
    private long bxT;
    private int bxU;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.bxU++;
            if (Rq()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a aF = com.baidu.h.b.a.aF(context);
                c hD = ((com.baidu.h.b.a.a.b) aF.Ri()).hD(str2);
                if (hD != null) {
                    BIMConversation Rn = ((com.baidu.h.b.a.a) hD).Rn();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bxS = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a Rj = aF.Rj();
                    if (Rj != null && Rj.isLogin() && Rj.Rb() != null) {
                        try {
                            aVar.uid = Long.parseLong(aF.Rj().Rb().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b Rm = aF.Rm();
                    if (Rm != null) {
                        aVar.bxw = Rm.bxw;
                        aVar.cuid = Rm.cuid;
                    }
                    Rn.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.bxU = 0;
                this.bxT = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Rq() {
        if (this.bxT == 0) {
            this.bxT = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bxT > 1200 && this.bxU > 0;
    }
}
