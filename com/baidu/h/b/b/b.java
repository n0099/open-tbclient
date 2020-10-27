package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes15.dex */
public class b implements com.baidu.h.a.c.a {
    private long bQq;
    private int bQr;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.bQr++;
            if (VU()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a aJ = com.baidu.h.b.a.aJ(context);
                c iU = ((com.baidu.h.b.a.a.b) aJ.VM()).iU(str2);
                if (iU != null) {
                    BIMConversation VR = ((com.baidu.h.b.a.a) iU).VR();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bQp = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a VN = aJ.VN();
                    if (VN != null && VN.isLogin() && VN.VF() != null) {
                        try {
                            aVar.uid = Long.parseLong(aJ.VN().VF().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b VQ = aJ.VQ();
                    if (VQ != null) {
                        aVar.appVersion = VQ.appVersion;
                        aVar.cuid = VQ.cuid;
                    }
                    VR.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.bQr = 0;
                this.bQq = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean VU() {
        if (this.bQq == 0) {
            this.bQq = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bQq > 1200 && this.bQr > 0;
    }
}
