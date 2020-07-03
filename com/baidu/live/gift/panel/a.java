package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.t;
import com.baidu.live.gift.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements x {
    private com.baidu.live.gift.c.a aPa;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        Bc();
    }

    @Override // com.baidu.live.gift.x
    public void eZ(String str) {
        this.aPa.fp(str);
    }

    @Override // com.baidu.live.gift.x
    public void yW() {
    }

    @Override // com.baidu.live.gift.x
    public void release() {
        if (this.aPa != null) {
            this.aPa.release();
        }
    }

    private void Bc() {
        this.aPa = new com.baidu.live.gift.c.a();
        this.aPa.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                a.this.c(z, arrayList);
            }

            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                a.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, List<i> list) {
        if (z) {
            t.yL().A(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            A(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.aPa == null) {
                this.aPa = new com.baidu.live.gift.c.a();
            }
            this.aPa.fp("gift_send_101");
        }
    }

    private void A(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = t.yL().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<com.baidu.live.gift.g> ym = iVar.ym();
                if (ym != null) {
                    if (i == 0) {
                        Iterator<com.baidu.live.gift.g> it = ym.iterator();
                        while (it.hasNext()) {
                            if (it.next().xM().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (com.baidu.live.gift.g gVar : ym) {
                            if (gVar.xM().equals(str)) {
                                gVar.aGH.aGO = i;
                            }
                        }
                    }
                }
            }
            t.yL().A(arrayList);
        }
    }
}
