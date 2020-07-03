package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.g;
import com.baidu.live.data.s;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.live.gift.giftList.c aKB;
    private ArrayList<i> aKC;
    private ArrayList<com.baidu.live.data.f> aKD;
    private ArrayList<g> aKE;
    private a aKF;
    private c.a aKG = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, s sVar) {
            if (i == 0) {
                e.this.aKC = arrayList;
                e.this.aKD = arrayList2;
                e.this.aKE = arrayList3;
            }
            if (e.this.aKF != null) {
                e.this.aKF.b(i, str, true, e.this.aKC, e.this.aKD, e.this.aKE, sVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, s sVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aKB = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aKB.a(this.aKG);
    }

    public void fd(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aKB.a(str, com.baidu.live.c.vf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void fe(String str) {
        this.aKB.n(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aKF = aVar;
    }
}
