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
    private com.baidu.live.gift.c.a aGH;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        zq();
    }

    @Override // com.baidu.live.gift.w
    public void xi() {
        this.aGH.zn();
    }

    @Override // com.baidu.live.gift.w
    public void xj() {
    }

    @Override // com.baidu.live.gift.w
    public void release() {
        if (this.aGH != null) {
            this.aGH.release();
        }
    }

    private void zq() {
        this.aGH = new com.baidu.live.gift.c.a();
        this.aGH.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
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
            s.wV().w(list);
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
            if (this.aGH == null) {
                this.aGH = new com.baidu.live.gift.c.a();
            }
            this.aGH.zn();
        }
    }

    private void w(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = s.wV().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> ww = iVar.ww();
                if (ww != null) {
                    if (i == 0) {
                        Iterator<g> it = ww.iterator();
                        while (it.hasNext()) {
                            if (it.next().vV().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : ww) {
                            if (gVar.vV().equals(str)) {
                                gVar.ayN.ayU = i;
                            }
                        }
                    }
                }
            }
            s.wV().w(arrayList);
        }
    }
}
