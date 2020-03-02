package com.baidu.g.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.g.a.b.c;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.c.a {
    private long aIW;
    private int aIX;

    @Override // com.baidu.g.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.g.a.c.b bVar) {
        try {
            this.aIX++;
            if (BX()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.g.b.a aP = com.baidu.g.b.a.aP(context);
                c ew = ((com.baidu.g.b.a.a.b) aP.BP()).ew(str2);
                if (ew != null) {
                    BIMConversation BU = ((com.baidu.g.b.a.a) ew).BU();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.aIV = i2;
                    aVar.sourceType = 0;
                    com.baidu.g.a.a.a BQ = aP.BQ();
                    if (BQ != null && BQ.isLogin() && BQ.BI() != null) {
                        try {
                            aVar.uid = Long.parseLong(aP.BQ().BI().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.g.b.b BT = aP.BT();
                    if (BT != null) {
                        aVar.aIz = BT.aIz;
                        aVar.cuid = BT.cuid;
                    }
                    BU.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.g.b.b.b.1
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
                this.aIX = 0;
                this.aIW = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean BX() {
        if (this.aIW == 0) {
            this.aIW = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.aIW > 1200 && this.aIX > 0;
    }
}
