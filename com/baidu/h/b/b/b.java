package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes9.dex */
public class b implements com.baidu.h.a.c.a {
    private long chl;
    private int chm;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.chm++;
            if (aaf()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a bz = com.baidu.h.b.a.bz(context);
                c iZ = ((com.baidu.h.b.a.a.b) bz.ZX()).iZ(str2);
                if (iZ != null) {
                    BIMConversation aac = ((com.baidu.h.b.a.a) iZ).aac();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.chk = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a ZY = bz.ZY();
                    if (ZY != null && ZY.isLogin() && ZY.ZQ() != null) {
                        try {
                            aVar.uid = Long.parseLong(bz.ZY().ZQ().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b aab = bz.aab();
                    if (aab != null) {
                        aVar.appVersion = aab.appVersion;
                        aVar.cuid = aab.cuid;
                    }
                    aac.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.chm = 0;
                this.chl = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean aaf() {
        if (this.chl == 0) {
            this.chl = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.chl > 1200 && this.chm > 0;
    }
}
