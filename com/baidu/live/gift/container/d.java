package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.live.gift.giftList.b agJ;
    private ArrayList<i> agK;
    private ArrayList<com.baidu.live.data.c> agL;
    private ArrayList<com.baidu.live.data.d> agM;
    private a agN;
    private b.a agO = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3) {
            if (i == 0) {
                d.this.agK = arrayList;
                d.this.agL = arrayList2;
                d.this.agM = arrayList3;
            }
            if (d.this.agN != null) {
                d.this.agN.b(i, str, true, d.this.agK, d.this.agL, d.this.agM);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3);
    }

    public d(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.agJ = new com.baidu.live.gift.giftList.b(this.mContext);
        this.agJ.a(this.agO);
    }

    public void di(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.agJ.i(str, com.baidu.live.c.oI().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void dj(String str) {
        this.agJ.dq(str);
    }

    public void rQ() {
        this.agJ.cancelLoadData();
    }

    public void a(a aVar) {
        this.agN = aVar;
    }
}
