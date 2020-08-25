package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.g;
import com.baidu.live.data.t;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    private com.baidu.live.gift.giftList.c aRk;
    private ArrayList<i> aRl;
    private ArrayList<com.baidu.live.data.f> aRm;
    private ArrayList<g> aRn;
    private a aRo;
    private c.a aRp = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<g> arrayList3, t tVar) {
            if (i == 0) {
                e.this.aRl = arrayList;
                e.this.aRm = arrayList2;
                e.this.aRn = arrayList3;
            }
            if (e.this.aRo != null) {
                e.this.aRo.b(i, str, true, e.this.aRl, e.this.aRm, e.this.aRn, tVar);
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
        this.aRk = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aRk.a(this.aRp);
    }

    public void gx(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aRk.a(str, com.baidu.live.c.AD().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gy(String str) {
        this.aRk.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aRo = aVar;
    }
}
