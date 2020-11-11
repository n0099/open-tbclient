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
    private com.baidu.live.yuyingift.c.c bRI;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        Jz();
    }

    @Override // com.baidu.live.gift.ad
    public void hk(String str) {
        this.bRI.hy(str);
    }

    @Override // com.baidu.live.gift.ad
    public void Ht() {
    }

    @Override // com.baidu.live.gift.ad
    public void release() {
        if (this.bRI != null) {
            this.bRI.release();
        }
    }

    private void Jz() {
        this.bRI = new com.baidu.live.yuyingift.c.c();
        this.bRI.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.f.1
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
            y.Hc().G(list);
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
            if (this.bRI == null) {
                this.bRI = new com.baidu.live.yuyingift.c.c();
            }
            this.bRI.hy("gift_send_101");
        }
    }

    private void B(String str, int i) {
        List<h> datas;
        if (!TextUtils.isEmpty(str) && (datas = y.Hc().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> Gu = hVar.Gu();
                if (Gu != null) {
                    if (i == 0) {
                        Iterator<g> it = Gu.iterator();
                        while (it.hasNext()) {
                            if (it.next().FT().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : Gu) {
                            if (gVar.FT().equals(str)) {
                                gVar.aUI.aUV = i;
                            }
                        }
                    }
                }
            }
            y.Hc().G(arrayList);
        }
    }
}
