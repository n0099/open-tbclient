package com.baidu.i.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.i.a.b.c;
/* loaded from: classes11.dex */
public class b implements com.baidu.i.a.c.a {
    private long bZF;
    private int bZG;

    @Override // com.baidu.i.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.i.a.c.b bVar) {
        try {
            this.bZG++;
            if (aan()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.i.b.a bn = com.baidu.i.b.a.bn(context);
                c jF = ((com.baidu.i.b.a.a.b) bn.aaf()).jF(str2);
                if (jF != null) {
                    BIMConversation aak = ((com.baidu.i.b.a.a) jF).aak();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.bZE = i2;
                    aVar.sourceType = 0;
                    com.baidu.i.a.a.a aag = bn.aag();
                    if (aag != null && aag.isLogin() && aag.ZY() != null) {
                        try {
                            aVar.uid = Long.parseLong(bn.aag().ZY().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.i.b.b aaj = bn.aaj();
                    if (aaj != null) {
                        aVar.appVersion = aaj.appVersion;
                        aVar.cuid = aaj.cuid;
                    }
                    aak.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.i.b.b.b.1
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
                this.bZG = 0;
                this.bZF = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean aan() {
        if (this.bZF == 0) {
            this.bZF = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.bZF > 1200 && this.bZG > 0;
    }
}
