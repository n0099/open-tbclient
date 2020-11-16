package com.baidu.live.yuyingift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.j;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements ad {
    private com.baidu.live.yuyingift.c.c bPY;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        IQ();
    }

    @Override // com.baidu.live.gift.ad
    public void he(String str) {
        this.bPY.hs(str);
    }

    @Override // com.baidu.live.gift.ad
    public void GK() {
    }

    @Override // com.baidu.live.gift.ad
    public void release() {
        if (this.bPY != null) {
            this.bPY.release();
        }
    }

    private void IQ() {
        this.bPY = new com.baidu.live.yuyingift.c.c();
        this.bPY.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.f.1
            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                f.this.b(z, arrayList);
            }

            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                f.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, List<h> list) {
        if (z) {
            y.Gt().G(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            B(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.bPY == null) {
                this.bPY = new com.baidu.live.yuyingift.c.c();
            }
            this.bPY.hs("gift_send_101");
        }
    }

    private void B(String str, int i) {
        List<h> datas;
        if (!TextUtils.isEmpty(str) && (datas = y.Gt().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> FL = hVar.FL();
                if (FL != null) {
                    if (i == 0) {
                        Iterator<g> it = FL.iterator();
                        while (it.hasNext()) {
                            if (it.next().Fk().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : FL) {
                            if (gVar.Fk().equals(str)) {
                                gVar.aSX.aTk = i;
                            }
                        }
                    }
                }
            }
            y.Gt().G(arrayList);
        }
    }
}
