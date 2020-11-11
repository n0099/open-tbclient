package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.j;
import com.baidu.live.data.y;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.gift.giftList.c aZn;
    private ArrayList<h> aZo;
    private ArrayList<com.baidu.live.data.h> aZp;
    private ArrayList<j> aZq;
    private a aZr;
    private c.a aZs = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i == 0) {
                e.this.aZo = arrayList;
                e.this.aZp = arrayList2;
                e.this.aZq = arrayList3;
            }
            if (e.this.aZr != null) {
                e.this.aZr.b(i, str, true, e.this.aZo, e.this.aZp, e.this.aZq, yVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aZn = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aZn.a(this.aZs);
    }

    public void ho(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aZn.a(str, com.baidu.live.d.AZ().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hp(String str) {
        this.aZn.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aZr = aVar;
    }
}
