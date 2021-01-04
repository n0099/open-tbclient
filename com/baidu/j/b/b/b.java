package com.baidu.j.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.j.a.b.c;
/* loaded from: classes10.dex */
public class b implements com.baidu.j.a.c.a {
    private long cgp;
    private int cgq;

    @Override // com.baidu.j.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.j.a.c.b bVar) {
        try {
            this.cgq++;
            if (aca()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.j.b.a by = com.baidu.j.b.a.by(context);
                c jy = ((com.baidu.j.b.a.a.b) by.abS()).jy(str2);
                if (jy != null) {
                    BIMConversation abX = ((com.baidu.j.b.a.a) jy).abX();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.cgo = i2;
                    aVar.sourceType = 0;
                    com.baidu.j.a.a.a abT = by.abT();
                    if (abT != null && abT.isLogin() && abT.abL() != null) {
                        try {
                            aVar.uid = Long.parseLong(by.abT().abL().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.j.b.b abW = by.abW();
                    if (abW != null) {
                        aVar.appVersion = abW.appVersion;
                        aVar.cuid = abW.cuid;
                    }
                    abX.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.j.b.b.b.1
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
                this.cgq = 0;
                this.cgp = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean aca() {
        if (this.cgp == 0) {
            this.cgp = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.cgp > 1200 && this.cgq > 0;
    }
}
