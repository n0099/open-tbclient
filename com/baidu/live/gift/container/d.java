package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.live.gift.giftList.c aHX;
    private ArrayList<i> aHY;
    private ArrayList<f> aHZ;
    private ArrayList<g> aIa;
    private a aIb;
    private c.a aIc = new c.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<f> arrayList2, ArrayList<g> arrayList3) {
            if (i == 0) {
                d.this.aHY = arrayList;
                d.this.aHZ = arrayList2;
                d.this.aIa = arrayList3;
            }
            if (d.this.aIb != null) {
                d.this.aIb.b(i, str, true, d.this.aHY, d.this.aHZ, d.this.aIa);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<f> arrayList2, ArrayList<g> arrayList3);
    }

    public d(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aHX = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aHX.a(this.aIc);
    }

    public void eX(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aHX.a(str, com.baidu.live.c.uN().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void eY(String str) {
        this.aHX.m(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aIb = aVar;
    }
}
