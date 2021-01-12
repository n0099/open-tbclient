package com.baidu.h.b.b;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.h.a.b.c;
/* loaded from: classes9.dex */
public class b implements com.baidu.h.a.c.a {
    private long cbA;
    private int cbB;

    @Override // com.baidu.h.a.c.a
    public void a(Context context, String str, String str2, int i, int i2, final com.baidu.h.a.c.b bVar) {
        try {
            this.cbB++;
            if (Yi()) {
                long parseLong = Long.parseLong(str);
                long parseLong2 = Long.parseLong(str2);
                com.baidu.h.b.a bx = com.baidu.h.b.a.bx(context);
                c in = ((com.baidu.h.b.a.a.b) bx.Ya()).in(str2);
                if (in != null) {
                    BIMConversation Yf = ((com.baidu.h.b.a.a) in).Yf();
                    a aVar = new a();
                    aVar.num = i;
                    aVar.roomId = parseLong;
                    aVar.cbz = i2;
                    aVar.sourceType = 0;
                    com.baidu.h.a.a.a Yb = bx.Yb();
                    if (Yb != null && Yb.isLogin() && Yb.XT() != null) {
                        try {
                            aVar.uid = Long.parseLong(bx.Yb().XT().getUid());
                        } catch (Exception e) {
                            aVar.uid = 0L;
                        }
                    }
                    com.baidu.h.b.b Ye = bx.Ye();
                    if (Ye != null) {
                        aVar.appVersion = Ye.appVersion;
                        aVar.cuid = Ye.cuid;
                    }
                    Yf.sendQuizOpts(parseLong, parseLong2, 1000, aVar.toJson(), new IMcastSetListener() { // from class: com.baidu.h.b.b.b.1
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
                this.cbB = 0;
                this.cbA = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            if (bVar != null) {
                bVar.onResult(-1, 0L, 0L);
            }
        }
    }

    private boolean Yi() {
        if (this.cbA == 0) {
            this.cbA = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.cbA > 1200 && this.cbB > 0;
    }
}
