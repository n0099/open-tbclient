package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.d;
import com.baidu.live.data.e;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.s;
import com.baidu.live.gift.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements w {
    private com.baidu.live.gift.c.a aGN;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        zp();
    }

    @Override // com.baidu.live.gift.w
    public void xh() {
        this.aGN.zm();
    }

    @Override // com.baidu.live.gift.w
    public void xi() {
    }

    @Override // com.baidu.live.gift.w
    public void release() {
        if (this.aGN != null) {
            this.aGN.release();
        }
    }

    private void zp() {
        this.aGN = new com.baidu.live.gift.c.a();
        this.aGN.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
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
            s.wU().w(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            w(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.aGN == null) {
                this.aGN = new com.baidu.live.gift.c.a();
            }
            this.aGN.zm();
        }
    }

    private void w(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = s.wU().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> wv = iVar.wv();
                if (wv != null) {
                    if (i == 0) {
                        Iterator<g> it = wv.iterator();
                        while (it.hasNext()) {
                            if (it.next().vU().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : wv) {
                            if (gVar.vU().equals(str)) {
                                gVar.ayT.aza = i;
                            }
                        }
                    }
                }
            }
            s.wU().w(arrayList);
        }
    }
}
