package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes10.dex */
public class b implements com.baidu.h.a.c.a {
    private long cfL;
    private int cfM;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.cfM++;
            if (aac()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a bA = com.baidu.h.b.a.bA(context);
                c iT = ((com.baidu.h.b.a.a.b) bA.ZU()).iT(str2);
                if (iT != null) {
                    BIMConversation ZZ = ((com.baidu.h.b.a.a) iT).ZZ();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.cfK = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a ZV = bA.ZV();
                    if (ZV != null && ZV.isLogin() && ZV.ZN() != null) {
                        try {
                            aVar.uid = Long.parseLong(bA.ZV().ZN().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b ZY = bA.ZY();
                    if (ZY != null) {
                        aVar.appVersion = ZY.appVersion;
                        aVar.cuid = ZY.cuid;
                    }
                    ZZ.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.cfM = 0;
                this.cfL = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean aac() {
        if (this.cfL == 0) {
            this.cfL = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.cfL > 1200 && this.cfM > 0;
    }
}
