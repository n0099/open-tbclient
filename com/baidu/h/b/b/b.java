package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes23.dex */
public class b implements com.baidu.h.a.c.a {
    private long bBt;
    private int bBu;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.bBu++;
            if (Sh()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a aF = com.baidu.h.b.a.aF(context);
                c ia = ((com.baidu.h.b.a.a.b) aF.RZ()).ia(str2);
                if (ia != null) {
                    BIMConversation Se = ((com.baidu.h.b.a.a) ia).Se();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bBs = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a Sa = aF.Sa();
                    if (Sa != null && Sa.isLogin() && Sa.RS() != null) {
                        try {
                            aVar.uid = Long.parseLong(aF.Sa().RS().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b Sd = aF.Sd();
                    if (Sd != null) {
                        aVar.bAW = Sd.bAW;
                        aVar.cuid = Sd.cuid;
                    }
                    Se.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.bBu = 0;
                this.bBt = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Sh() {
        if (this.bBt == 0) {
            this.bBt = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bBt > 1200 && this.bBu > 0;
    }
}
