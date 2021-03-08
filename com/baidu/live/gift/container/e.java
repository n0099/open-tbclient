package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.live.gift.giftList.c bcu;
    private ArrayList<h> bcv;
    private ArrayList<i> bcw;
    private ArrayList<l> bcx;
    private a bcy;
    private c.a bcz = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i == 0) {
                e.this.bcv = arrayList;
                e.this.bcw = arrayList2;
                e.this.bcx = arrayList3;
            }
            if (e.this.bcy != null) {
                e.this.bcy.b(i, str, true, e.this.bcv, e.this.bcw, e.this.bcx, aeVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bcu = new com.baidu.live.gift.giftList.c(this.mContext);
        this.bcu.a(this.bcz);
    }

    public void gG(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bcu.a(str, com.baidu.live.d.xf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gH(String str) {
        this.bcu.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bcy = aVar;
    }
}
