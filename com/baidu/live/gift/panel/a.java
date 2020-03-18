package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.d;
import com.baidu.live.data.e;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.r;
import com.baidu.live.gift.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements v {
    private com.baidu.live.gift.c.a aop;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        dQ();
    }

    @Override // com.baidu.live.gift.v
    public void sP() {
        this.aop.uS();
    }

    @Override // com.baidu.live.gift.v
    public void sQ() {
    }

    @Override // com.baidu.live.gift.v
    public void release() {
        if (this.aop != null) {
            this.aop.release();
        }
    }

    private void dQ() {
        this.aop = new com.baidu.live.gift.c.a();
        this.aop.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<d> arrayList2, ArrayList<e> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
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
            r.sC().s(list);
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
            if (this.aop == null) {
                this.aop = new com.baidu.live.gift.c.a();
            }
            this.aop.uS();
        }
    }

    private void q(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = r.sC().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> sd = iVar.sd();
                if (sd != null) {
                    if (i == 0) {
                        Iterator<g> it = sd.iterator();
                        while (it.hasNext()) {
                            if (it.next().rC().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : sd) {
                            if (gVar.rC().equals(str)) {
                                gVar.agx.agE = i;
                            }
                        }
                    }
                }
            }
            r.sC().s(arrayList);
        }
    }
}
