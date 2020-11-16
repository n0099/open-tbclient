package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes9.dex */
public class b implements com.baidu.h.a.c.a {
    private long bUq;
    private int bUr;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.bUr++;
            if (XK()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a aJ = com.baidu.h.b.a.aJ(context);
                c jb = ((com.baidu.h.b.a.a.b) aJ.XC()).jb(str2);
                if (jb != null) {
                    BIMConversation XH = ((com.baidu.h.b.a.a) jb).XH();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bUp = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a XD = aJ.XD();
                    if (XD != null && XD.isLogin() && XD.Xv() != null) {
                        try {
                            aVar.uid = Long.parseLong(aJ.XD().Xv().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b XG = aJ.XG();
                    if (XG != null) {
                        aVar.appVersion = XG.appVersion;
                        aVar.cuid = XG.cuid;
                    }
                    XH.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.bUr = 0;
                this.bUq = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean XK() {
        if (this.bUq == 0) {
            this.bUq = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bUq > 1200 && this.bUr > 0;
    }
}
