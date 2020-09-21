package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.g;
import com.baidu.live.data.w;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.gift.giftList.c aTp;
    private ArrayList<i> aTq;
    private ArrayList<g> aTr;
    private ArrayList<com.baidu.live.data.i> aTs;
    private a aTt;
    private c.a aTu = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, w wVar) {
            if (i == 0) {
                e.this.aTq = arrayList;
                e.this.aTr = arrayList2;
                e.this.aTs = arrayList3;
            }
            if (e.this.aTt != null) {
                e.this.aTt.b(i, str, true, e.this.aTq, e.this.aTr, e.this.aTs, wVar);
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
        this.aTp = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aTp.a(this.aTu);
    }

    public void gI(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aTp.a(str, com.baidu.live.c.AR().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gJ(String str) {
        this.aTp.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aTt = aVar;
    }
}
