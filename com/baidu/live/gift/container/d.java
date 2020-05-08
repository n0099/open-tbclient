package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private ArrayList<com.baidu.live.data.d> aCA;
    private ArrayList<com.baidu.live.data.e> aCB;
    private a aCC;
    private b.a aCD = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3) {
            if (i == 0) {
                d.this.aCz = arrayList;
                d.this.aCA = arrayList2;
                d.this.aCB = arrayList3;
            }
            if (d.this.aCC != null) {
                d.this.aCC.b(i, str, true, d.this.aCz, d.this.aCA, d.this.aCB);
            }
        }
    };
    private com.baidu.live.gift.giftList.b aCy;
    private ArrayList<i> aCz;
    private BdPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3);
    }

    public d(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aCy = new com.baidu.live.gift.giftList.b(this.mContext);
        this.aCy.a(this.aCD);
    }

    public void en(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aCy.m(str, com.baidu.live.c.tG().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void eo(String str) {
        this.aCy.et(str);
    }

    public void a(a aVar) {
        this.aCC = aVar;
    }
}
