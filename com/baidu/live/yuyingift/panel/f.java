package com.baidu.live.yuyingift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.af;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class f implements af {
    private com.baidu.live.yuyingift.c.d cbZ;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        initModel();
    }

    @Override // com.baidu.live.gift.af
    public void gC(String str) {
        this.cbZ.gT(str);
    }

    @Override // com.baidu.live.gift.af
    public void FB() {
    }

    @Override // com.baidu.live.gift.af
    public void release() {
        if (this.cbZ != null) {
            this.cbZ.release();
        }
    }

    private void initModel() {
        this.cbZ = new com.baidu.live.yuyingift.c.d();
        this.cbZ.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.f.1
            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                f.this.f(z, arrayList);
            }

            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                f.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, List<h> list) {
        if (z) {
            z.Fh().H(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            F(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.cbZ == null) {
                this.cbZ = new com.baidu.live.yuyingift.c.d();
            }
            this.cbZ.gT("gift_send_101");
        }
    }

    private void F(String str, int i) {
        List<h> datas;
        if (!TextUtils.isEmpty(str) && (datas = z.Fh().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> Ez = hVar.Ez();
                if (Ez != null) {
                    if (i == 0) {
                        Iterator<g> it = Ez.iterator();
                        while (it.hasNext()) {
                            if (it.next().DU().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : Ez) {
                            if (gVar.DU().equals(str)) {
                                gVar.aXx.aXM = i;
                            }
                        }
                    }
                }
            }
            z.Fh().H(arrayList);
        }
    }
}
