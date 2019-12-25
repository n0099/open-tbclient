package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.live.gift.c.a ald;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        dP();
    }

    public void tg() {
        this.ald.td();
    }

    public void th() {
    }

    public void release() {
        if (this.ald != null) {
            this.ald.release();
        }
    }

    private void dP() {
        this.ald = new com.baidu.live.gift.c.a();
        this.ald.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<d> arrayList3) {
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
    public void b(boolean z, List<i> list) {
        if (z) {
            q.rk().s(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            q(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.ald == null) {
                this.ald = new com.baidu.live.gift.c.a();
            }
            this.ald.td();
        }
    }

    private void q(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = q.rk().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> qQ = iVar.qQ();
                if (qQ != null) {
                    if (i == 0) {
                        Iterator<g> it = qQ.iterator();
                        while (it.hasNext()) {
                            if (it.next().qx().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : qQ) {
                            if (gVar.qx().equals(str)) {
                                gVar.adR.adY = i;
                            }
                        }
                    }
                }
            }
            q.rk().s(arrayList);
        }
    }
}
