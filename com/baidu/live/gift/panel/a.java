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
    private com.baidu.live.gift.c.a alR;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        dP();
    }

    public void ty() {
        this.alR.tv();
    }

    public void tz() {
    }

    public void release() {
        if (this.alR != null) {
            this.alR.release();
        }
    }

    private void dP() {
        this.alR = new com.baidu.live.gift.c.a();
        this.alR.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<d> arrayList3) {
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
            q.rw().s(list);
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
            if (this.alR == null) {
                this.alR = new com.baidu.live.gift.c.a();
            }
            this.alR.tv();
        }
    }

    private void q(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = q.rw().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> qX = iVar.qX();
                if (qX != null) {
                    if (i == 0) {
                        Iterator<g> it = qX.iterator();
                        while (it.hasNext()) {
                            if (it.next().qE().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : qX) {
                            if (gVar.qE().equals(str)) {
                                gVar.aeg.aen = i;
                            }
                        }
                    }
                }
            }
            q.rw().s(arrayList);
        }
    }
}
