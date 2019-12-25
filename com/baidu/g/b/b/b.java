package com.baidu.g.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.g.a.b.c;
/* loaded from: classes2.dex */
public class b implements com.baidu.g.a.c.a {
    private long aDX;
    private int aDY;

    @Override // com.baidu.g.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.g.a.c.b bVar) {
        try {
            this.aDY++;
            if (zj()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.g.b.a aL = com.baidu.g.b.a.aL(context);
                c ee = ((com.baidu.g.b.a.a.b) aL.zb()).ee(str2);
                if (ee != null) {
                    BIMConversation zg = ((com.baidu.g.b.a.a) ee).zg();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.aDW = i2;
                    aVar.sourceType = 0;
                    com.baidu.g.a.a.a zc = aL.zc();
                    if (zc != null && zc.isLogin() && zc.yU() != null) {
                        try {
                            aVar.uid = Long.parseLong(aL.zc().yU().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.g.b.b zf = aL.zf();
                    if (zf != null) {
                        aVar.aDA = zf.aDA;
                        aVar.cuid = zf.cuid;
                    }
                    zg.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.g.b.b.b.1
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
                this.aDY = 0;
                this.aDX = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean zj() {
        if (this.aDX == 0) {
            this.aDX = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.aDX > 1200 && this.aDY > 0;
    }
}
