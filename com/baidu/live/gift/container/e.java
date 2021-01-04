package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.gift.giftList.c bcB;
    private ArrayList<h> bcC;
    private ArrayList<i> bcD;
    private ArrayList<k> bcE;
    private a bcF;
    private c.a bcG = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i == 0) {
                e.this.bcC = arrayList;
                e.this.bcD = arrayList2;
                e.this.bcE = arrayList3;
            }
            if (e.this.bcF != null) {
                e.this.bcF.b(i, str, true, e.this.bcC, e.this.bcD, e.this.bcE, aaVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bcB = new com.baidu.live.gift.giftList.c(this.mContext);
        this.bcB.a(this.bcG);
    }

    public void ho(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bcB.a(str, com.baidu.live.d.Ba().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hp(String str) {
        this.bcB.r(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bcF = aVar;
    }
}
