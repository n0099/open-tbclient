package com.baidu.g.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.g.a.b.c;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.c.a {
    private long aIV;
    private int aIW;

    @Override // com.baidu.g.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.g.a.c.b bVar) {
        try {
            this.aIW++;
            if (BV()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.g.b.a aP = com.baidu.g.b.a.aP(context);
                c ew = ((com.baidu.g.b.a.a.b) aP.BN()).ew(str2);
                if (ew != null) {
                    BIMConversation BS = ((com.baidu.g.b.a.a) ew).BS();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.aIU = i2;
                    aVar.sourceType = 0;
                    com.baidu.g.a.a.a BO = aP.BO();
                    if (BO != null && BO.isLogin() && BO.BG() != null) {
                        try {
                            aVar.uid = Long.parseLong(aP.BO().BG().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.g.b.b BR = aP.BR();
                    if (BR != null) {
                        aVar.aIy = BR.aIy;
                        aVar.cuid = BR.cuid;
                    }
                    BS.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.g.b.b.b.1
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
                this.aIW = 0;
                this.aIV = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean BV() {
        if (this.aIV == 0) {
            this.aIV = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.aIV > 1200 && this.aIW > 0;
    }
}
