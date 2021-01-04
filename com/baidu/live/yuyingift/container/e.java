package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.yuyingift.giftlist.b bZw;
    private a bZx;
    private b.a bZy = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i == 0) {
                e.this.bcC = arrayList;
                e.this.bcD = arrayList2;
                e.this.bcE = arrayList3;
            }
            if (e.this.bZx != null) {
                e.this.bZx.b(i, str, true, e.this.bcC, e.this.bcD, e.this.bcE, aaVar);
            }
        }
    };
    private ArrayList<h> bcC;
    private ArrayList<i> bcD;
    private ArrayList<k> bcE;
    private BdPageContext mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bZw = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.bZw.a(this.bZy);
    }

    public void ho(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bZw.a(str, com.baidu.live.d.Ba().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hp(String str) {
        this.bZw.r(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bZx = aVar;
    }
}
