package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.g;
import com.baidu.live.data.s;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.gift.giftList.c aLX;
    private ArrayList<i> aLY;
    private ArrayList<com.baidu.live.data.f> aLZ;
    private ArrayList<g> aMa;
    private a aMb;
    private c.a aMc = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, s sVar) {
            if (i == 0) {
                e.this.aLY = arrayList;
                e.this.aLZ = arrayList2;
                e.this.aMa = arrayList3;
            }
            if (e.this.aMb != null) {
                e.this.aMb.b(i, str, true, e.this.aLY, e.this.aLZ, e.this.aMa, sVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, s sVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aLX = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aLX.a(this.aMc);
    }

    public void fc(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aLX.a(str, com.baidu.live.c.vf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void fd(String str) {
        this.aLX.n(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aMb = aVar;
    }
}
