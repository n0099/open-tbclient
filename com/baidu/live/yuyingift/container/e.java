package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.yuyingift.giftlist.b bYM;
    private a bYN;
    private b.a bYO = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i == 0) {
                e.this.baV = arrayList;
                e.this.baW = arrayList2;
                e.this.baX = arrayList3;
            }
            if (e.this.bYN != null) {
                e.this.bYN.b(i, str, true, e.this.baV, e.this.baW, e.this.baX, aeVar);
            }
        }
    };
    private ArrayList<h> baV;
    private ArrayList<i> baW;
    private ArrayList<l> baX;
    private BdPageContext mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bYM = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.bYM.a(this.bYO);
    }

    public void gA(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bYM.a(str, com.baidu.live.d.xc().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gB(String str) {
        this.bYM.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bYN = aVar;
    }
}
