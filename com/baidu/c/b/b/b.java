package com.baidu.c.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.c.a {
    private long bmI;
    private int bmJ;

    @Override // com.baidu.c.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.c.a.c.b bVar) {
        try {
            this.bmJ++;
            if (Ka()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.c.b.a az = com.baidu.c.b.a.az(context);
                c gb = ((com.baidu.c.b.a.a.b) az.JS()).gb(str2);
                if (gb != null) {
                    BIMConversation JX = ((com.baidu.c.b.a.a) gb).JX();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bmH = i2;
                    aVar.sourceType = 0;
                    com.baidu.c.a.a.a JT = az.JT();
                    if (JT != null && JT.isLogin() && JT.JL() != null) {
                        try {
                            aVar.uid = Long.parseLong(az.JT().JL().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.c.b.b JW = az.JW();
                    if (JW != null) {
                        aVar.bmk = JW.bmk;
                        aVar.cuid = JW.cuid;
                    }
                    JX.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.c.b.b.b.1
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
                this.bmJ = 0;
                this.bmI = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Ka() {
        if (this.bmI == 0) {
            this.bmI = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bmI > 1200 && this.bmJ > 0;
    }
}
