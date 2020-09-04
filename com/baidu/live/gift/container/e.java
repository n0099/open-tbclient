package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.g;
import com.baidu.live.data.t;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    private com.baidu.live.gift.giftList.c aRm;
    private ArrayList<i> aRn;
    private ArrayList<com.baidu.live.data.f> aRo;
    private ArrayList<g> aRp;
    private a aRq;
    private c.a aRr = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, t tVar) {
            if (i == 0) {
                e.this.aRn = arrayList;
                e.this.aRo = arrayList2;
                e.this.aRp = arrayList3;
            }
            if (e.this.aRq != null) {
                e.this.aRq.b(i, str, true, e.this.aRn, e.this.aRo, e.this.aRp, tVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, t tVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aRm = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aRm.a(this.aRr);
    }

    public void gy(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aRm.a(str, com.baidu.live.c.AD().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gz(String str) {
        this.aRm.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aRq = aVar;
    }
}
