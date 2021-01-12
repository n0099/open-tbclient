package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.live.gift.giftList.c aXN;
    private ArrayList<h> aXO;
    private ArrayList<i> aXP;
    private ArrayList<k> aXQ;
    private a aXR;
    private c.a aXS = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i == 0) {
                e.this.aXO = arrayList;
                e.this.aXP = arrayList2;
                e.this.aXQ = arrayList3;
            }
            if (e.this.aXR != null) {
                e.this.aXR.b(i, str, true, e.this.aXO, e.this.aXP, e.this.aXQ, aaVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aXN = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aXN.a(this.aXS);
    }

    public void gc(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aXN.a(str, com.baidu.live.d.xf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gd(String str) {
        this.aXN.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aXR = aVar;
    }
}
