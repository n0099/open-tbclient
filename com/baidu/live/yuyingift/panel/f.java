package com.baidu.live.yuyingift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.j;
import com.baidu.live.gift.af;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements af {
    private com.baidu.live.yuyingift.c.c bVi;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        KR();
    }

    @Override // com.baidu.live.gift.af
    public void hz(String str) {
        this.bVi.hQ(str);
    }

    @Override // com.baidu.live.gift.af
    public void IB() {
    }

    @Override // com.baidu.live.gift.af
    public void release() {
        if (this.bVi != null) {
            this.bVi.release();
        }
    }

    private void KR() {
        this.bVi = new com.baidu.live.yuyingift.c.c();
        this.bVi.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.f.1
            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                f.this.d(z, arrayList);
            }

            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                f.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, List<h> list) {
        if (z) {
            z.Ii().H(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            D(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.bVi == null) {
                this.bVi = new com.baidu.live.yuyingift.c.c();
            }
            this.bVi.hQ("gift_send_101");
        }
    }

    private void D(String str, int i) {
        List<h> datas;
        if (!TextUtils.isEmpty(str) && (datas = z.Ii().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> HA = hVar.HA();
                if (HA != null) {
                    if (i == 0) {
                        Iterator<g> it = HA.iterator();
                        while (it.hasNext()) {
                            if (it.next().GX().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : HA) {
                            if (gVar.GX().equals(str)) {
                                gVar.aVZ.aWo = i;
                            }
                        }
                    }
                }
            }
            z.Ii().H(arrayList);
        }
    }
}
