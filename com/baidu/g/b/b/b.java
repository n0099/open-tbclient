package com.baidu.g.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.g.a.b.c;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.c.a {
    private long aJl;
    private int aJm;

    @Override // com.baidu.g.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.g.a.c.b bVar) {
        try {
            this.aJm++;
            if (Ce()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.g.b.a aO = com.baidu.g.b.a.aO(context);
                c ev = ((com.baidu.g.b.a.a.b) aO.BW()).ev(str2);
                if (ev != null) {
                    BIMConversation Cb = ((com.baidu.g.b.a.a) ev).Cb();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.aJk = i2;
                    aVar.sourceType = 0;
                    com.baidu.g.a.a.a BX = aO.BX();
                    if (BX != null && BX.isLogin() && BX.BP() != null) {
                        try {
                            aVar.uid = Long.parseLong(aO.BX().BP().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.g.b.b Ca = aO.Ca();
                    if (Ca != null) {
                        aVar.aIO = Ca.aIO;
                        aVar.cuid = Ca.cuid;
                    }
                    Cb.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.g.b.b.b.1
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
                this.aJm = 0;
                this.aJl = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Ce() {
        if (this.aJl == 0) {
            this.aJl = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.aJl > 1200 && this.aJm > 0;
    }
}
