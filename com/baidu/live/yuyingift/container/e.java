package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private ArrayList<h> aXO;
    private ArrayList<i> aXP;
    private ArrayList<k> aXQ;
    private com.baidu.live.yuyingift.giftlist.b bUK;
    private a bUL;
    private b.a bUM = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i == 0) {
                e.this.aXO = arrayList;
                e.this.aXP = arrayList2;
                e.this.aXQ = arrayList3;
            }
            if (e.this.bUL != null) {
                e.this.bUL.b(i, str, true, e.this.aXO, e.this.aXP, e.this.aXQ, aaVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bUK = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.bUK.a(this.bUM);
    }

    public void gc(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bUK.a(str, com.baidu.live.d.xf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gd(String str) {
        this.bUK.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bUL = aVar;
    }
}
