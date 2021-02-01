package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.gift.giftList.c baU;
    private ArrayList<h> baV;
    private ArrayList<i> baW;
    private ArrayList<l> baX;
    private a baY;
    private c.a baZ = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i == 0) {
                e.this.baV = arrayList;
                e.this.baW = arrayList2;
                e.this.baX = arrayList3;
            }
            if (e.this.baY != null) {
                e.this.baY.b(i, str, true, e.this.baV, e.this.baW, e.this.baX, aeVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.baU = new com.baidu.live.gift.giftList.c(this.mContext);
        this.baU.a(this.baZ);
    }

    public void gA(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.baU.a(str, com.baidu.live.d.xc().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gB(String str) {
        this.baU.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.baY = aVar;
    }
}
