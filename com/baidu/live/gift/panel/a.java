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
/* loaded from: classes7.dex */
public class a implements x {
    private com.baidu.live.gift.c.a aVH;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        Hh();
    }

    @Override // com.baidu.live.gift.x
    public void gt(String str) {
        this.aVH.gJ(str);
    }

    @Override // com.baidu.live.gift.x
    public void Fb() {
    }

    @Override // com.baidu.live.gift.x
    public void release() {
        if (this.aVH != null) {
            this.aVH.release();
        }
    }

    private void Hh() {
        this.aVH = new com.baidu.live.gift.c.a();
        this.aVH.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
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
            t.EQ().D(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            B(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.aVH == null) {
                this.aVH = new com.baidu.live.gift.c.a();
            }
            this.aVH.gJ("gift_send_101");
        }
    }

    private void B(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = t.EQ().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<com.baidu.live.gift.g> Er = iVar.Er();
                if (Er != null) {
                    if (i == 0) {
                        Iterator<com.baidu.live.gift.g> it = Er.iterator();
                        while (it.hasNext()) {
                            if (it.next().DR().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (com.baidu.live.gift.g gVar : Er) {
                            if (gVar.DR().equals(str)) {
                                gVar.aNn.aNu = i;
                            }
                        }
                    }
                }
            }
            t.EQ().D(arrayList);
        }
    }
}
