package com.baidu.live.yuyingift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.af;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class f implements af {
    private com.baidu.live.yuyingift.c.d cbi;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        initModel();
    }

    @Override // com.baidu.live.gift.af
    public void hk(String str) {
        this.cbi.hB(str);
    }

    @Override // com.baidu.live.gift.af
    public void Id() {
    }

    @Override // com.baidu.live.gift.af
    public void release() {
        if (this.cbi != null) {
            this.cbi.release();
        }
    }

    private void initModel() {
        this.cbi = new com.baidu.live.yuyingift.c.d();
        this.cbi.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.f.1
            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                f.this.e(z, arrayList);
            }

            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                f.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, List<h> list) {
        if (z) {
            z.HJ().H(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            E(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.cbi == null) {
                this.cbi = new com.baidu.live.yuyingift.c.d();
            }
            this.cbi.hB("gift_send_101");
        }
    }

    private void E(String str, int i) {
        List<h> datas;
        if (!TextUtils.isEmpty(str) && (datas = z.HJ().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> Hb = hVar.Hb();
                if (Hb != null) {
                    if (i == 0) {
                        Iterator<g> it = Hb.iterator();
                        while (it.hasNext()) {
                            if (it.next().Gx().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : Hb) {
                            if (gVar.Gx().equals(str)) {
                                gVar.aXF.aXU = i;
                            }
                        }
                    }
                }
            }
            z.HJ().H(arrayList);
        }
    }
}
