package com.baidu.c.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.c.a {
    private long brI;
    private int brJ;

    @Override // com.baidu.c.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.c.a.c.b bVar) {
        try {
            this.brJ++;
            if (Lj()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.c.b.a aA = com.baidu.c.b.a.aA(context);
                c gj = ((com.baidu.c.b.a.a.b) aA.Lb()).gj(str2);
                if (gj != null) {
                    BIMConversation Lg = ((com.baidu.c.b.a.a) gj).Lg();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.brH = i2;
                    aVar.sourceType = 0;
                    com.baidu.c.a.a.a Lc = aA.Lc();
                    if (Lc != null && Lc.isLogin() && Lc.KU() != null) {
                        try {
                            aVar.uid = Long.parseLong(aA.Lc().KU().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.c.b.b Lf = aA.Lf();
                    if (Lf != null) {
                        aVar.brl = Lf.brl;
                        aVar.cuid = Lf.cuid;
                    }
                    Lg.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.c.b.b.b.1
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
                this.brJ = 0;
                this.brI = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Lj() {
        if (this.brI == 0) {
            this.brI = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.brI > 1200 && this.brJ > 0;
    }
}
