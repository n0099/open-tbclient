package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes15.dex */
public class b implements com.baidu.h.a.c.a {
    private long bHV;
    private int bHW;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.bHW++;
            if (Ua()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a aJ = com.baidu.h.b.a.aJ(context);
                c iB = ((com.baidu.h.b.a.a.b) aJ.TS()).iB(str2);
                if (iB != null) {
                    BIMConversation TX = ((com.baidu.h.b.a.a) iB).TX();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bHU = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a TT = aJ.TT();
                    if (TT != null && TT.isLogin() && TT.TL() != null) {
                        try {
                            aVar.uid = Long.parseLong(aJ.TT().TL().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b TW = aJ.TW();
                    if (TW != null) {
                        aVar.appVersion = TW.appVersion;
                        aVar.cuid = TW.cuid;
                    }
                    TX.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.bHW = 0;
                this.bHV = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Ua() {
        if (this.bHV == 0) {
            this.bHV = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bHV > 1200 && this.bHW > 0;
    }
}
