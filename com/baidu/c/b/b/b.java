package com.baidu.c.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.c.a {
    private long bfi;
    private int bfj;

    @Override // com.baidu.c.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.c.a.c.b bVar) {
        try {
            this.bfj++;
            if (Ih()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.c.b.a ap = com.baidu.c.b.a.ap(context);
                c fp = ((com.baidu.c.b.a.a.b) ap.HZ()).fp(str2);
                if (fp != null) {
                    BIMConversation Ie = ((com.baidu.c.b.a.a) fp).Ie();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bfh = i2;
                    aVar.sourceType = 0;
                    com.baidu.c.a.a.a Ia = ap.Ia();
                    if (Ia != null && Ia.isLogin() && Ia.HS() != null) {
                        try {
                            aVar.uid = Long.parseLong(ap.Ia().HS().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.c.b.b Id = ap.Id();
                    if (Id != null) {
                        aVar.beK = Id.beK;
                        aVar.cuid = Id.cuid;
                    }
                    Ie.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.c.b.b.b.1
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
                this.bfj = 0;
                this.bfi = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Ih() {
        if (this.bfi == 0) {
            this.bfi = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bfi > 1200 && this.bfj > 0;
    }
}
