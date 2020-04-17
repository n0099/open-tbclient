package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.live.gift.giftList.b aCs;
    private ArrayList<i> aCt;
    private ArrayList<com.baidu.live.data.d> aCu;
    private ArrayList<com.baidu.live.data.e> aCv;
    private a aCw;
    private b.a aCx = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3) {
            if (i == 0) {
                d.this.aCt = arrayList;
                d.this.aCu = arrayList2;
                d.this.aCv = arrayList3;
            }
            if (d.this.aCw != null) {
                d.this.aCw.b(i, str, true, d.this.aCt, d.this.aCu, d.this.aCv);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3);
    }

    public d(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aCs = new com.baidu.live.gift.giftList.b(this.mContext);
        this.aCs.a(this.aCx);
    }

    public void en(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aCs.m(str, com.baidu.live.c.tH().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void eo(String str) {
        this.aCs.et(str);
    }

    public void a(a aVar) {
        this.aCw = aVar;
    }
}
