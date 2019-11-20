package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.live.gift.c.a adg;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void rs() {
        if (this.adg == null) {
            dv();
        }
        this.adg.rp();
    }

    public void rt() {
    }

    public void release() {
        if (this.adg != null) {
            this.adg.release();
        }
    }

    private void dv() {
        this.adg = new com.baidu.live.gift.c.a();
        this.adg.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
                super.a(z, str, arrayList, arrayList2, arrayList3);
                a.this.b(z, arrayList);
            }

            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                a.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, List<h> list) {
        if (z) {
            o.pI().t(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            m(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.adg == null) {
                this.adg = new com.baidu.live.gift.c.a();
            }
            this.adg.rp();
        }
    }

    private void m(String str, int i) {
        List<h> datas;
        if (!TextUtils.isEmpty(str) && (datas = o.pI().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> pt = hVar.pt();
                if (pt != null) {
                    if (i == 0) {
                        Iterator<g> it = pt.iterator();
                        while (it.hasNext()) {
                            if (it.next().pc().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : pt) {
                            if (gVar.pc().equals(str)) {
                                gVar.Wo.Ws = i;
                            }
                        }
                    }
                }
            }
            o.pI().t(arrayList);
        }
    }
}
