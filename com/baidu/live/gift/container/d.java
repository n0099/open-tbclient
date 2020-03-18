package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.live.gift.giftList.b ajM;
    private ArrayList<i> ajN;
    private ArrayList<com.baidu.live.data.d> ajO;
    private ArrayList<com.baidu.live.data.e> ajP;
    private a ajQ;
    private b.a ajR = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3) {
            if (i == 0) {
                d.this.ajN = arrayList;
                d.this.ajO = arrayList2;
                d.this.ajP = arrayList3;
            }
            if (d.this.ajQ != null) {
                d.this.ajQ.b(i, str, true, d.this.ajN, d.this.ajO, d.this.ajP);
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
        this.ajM = new com.baidu.live.gift.giftList.b(this.mContext);
        this.ajM.a(this.ajR);
    }

    public void du(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.ajM.i(str, com.baidu.live.c.pw().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void dv(String str) {
        this.ajM.dB(str);
    }

    public void tx() {
        this.ajM.cancelLoadData();
    }

    public void a(a aVar) {
        this.ajQ = aVar;
    }
}
