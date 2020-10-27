package com.baidu.live.yuyingift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements ae {
    private com.baidu.live.yuyingift.c.c bMa;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
        IY();
    }

    @Override // com.baidu.live.gift.ae
    public void hd(String str) {
        this.bMa.hr(str);
    }

    @Override // com.baidu.live.gift.ae
    public void GS() {
    }

    @Override // com.baidu.live.gift.ae
    public void release() {
        if (this.bMa != null) {
            this.bMa.release();
        }
    }

    private void IY() {
        this.bMa = new com.baidu.live.yuyingift.c.c();
        this.bMa.a(new com.baidu.live.yuyingift.c.a() { // from class: com.baidu.live.yuyingift.panel.f.1
            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                f.this.b(z, arrayList);
            }

            @Override // com.baidu.live.yuyingift.c.a, com.baidu.live.yuyingift.c.b.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                f.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, List<i> list) {
        if (z) {
            z.GB().G(list);
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
            if (this.bMa == null) {
                this.bMa = new com.baidu.live.yuyingift.c.c();
            }
            this.bMa.hr("gift_send_101");
        }
    }

    private void B(String str, int i) {
        List<i> datas;
        if (!TextUtils.isEmpty(str) && (datas = z.GB().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> FT = iVar.FT();
                if (FT != null) {
                    if (i == 0) {
                        Iterator<g> it = FT.iterator();
                        while (it.hasNext()) {
                            if (it.next().Fs().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : FT) {
                            if (gVar.Fs().equals(str)) {
                                gVar.aTp.aTC = i;
                            }
                        }
                    }
                }
            }
            z.GB().G(arrayList);
        }
    }
}
