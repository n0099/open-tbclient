package com.baidu.g.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.g.a.b.c;
/* loaded from: classes2.dex */
public class b implements com.baidu.g.a.c.a {
    private long aEP;
    private int aEQ;

    @Override // com.baidu.g.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.g.a.c.b bVar) {
        try {
            this.aEQ++;
            if (zF()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.g.b.a aL = com.baidu.g.b.a.aL(context);
                c eh = ((com.baidu.g.b.a.a.b) aL.zx()).eh(str2);
                if (eh != null) {
                    BIMConversation zC = ((com.baidu.g.b.a.a) eh).zC();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.aEO = i2;
                    aVar.sourceType = 0;
                    com.baidu.g.a.a.a zy = aL.zy();
                    if (zy != null && zy.isLogin() && zy.zq() != null) {
                        try {
                            aVar.uid = Long.parseLong(aL.zy().zq().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.g.b.b zB = aL.zB();
                    if (zB != null) {
                        aVar.aEs = zB.aEs;
                        aVar.cuid = zB.cuid;
                    }
                    zC.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.g.b.b.b.1
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
                this.aEQ = 0;
                this.aEP = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean zF() {
        if (this.aEP == 0) {
            this.aEP = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.aEP > 1200 && this.aEQ > 0;
    }
}
