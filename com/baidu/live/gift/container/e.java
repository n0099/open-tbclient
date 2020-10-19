package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.g;
import com.baidu.live.data.w;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.gift.giftList.c aWA;
    private ArrayList<i> aWB;
    private ArrayList<g> aWC;
    private ArrayList<com.baidu.live.data.i> aWD;
    private a aWE;
    private c.a aWF = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, w wVar) {
            if (i == 0) {
                e.this.aWB = arrayList;
                e.this.aWC = arrayList2;
                e.this.aWD = arrayList3;
            }
            if (e.this.aWE != null) {
                e.this.aWE.b(i, str, true, e.this.aWB, e.this.aWC, e.this.aWD, wVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, w wVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aWA = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aWA.a(this.aWF);
    }

    public void gW(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aWA.a(str, com.baidu.live.c.AZ().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gX(String str) {
        this.aWA.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aWE = aVar;
    }
}
