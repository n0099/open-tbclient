package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.live.gift.giftList.b ajB;
    private ArrayList<i> ajC;
    private ArrayList<com.baidu.live.data.d> ajD;
    private ArrayList<com.baidu.live.data.e> ajE;
    private a ajF;
    private b.a ajG = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3) {
            if (i == 0) {
                d.this.ajC = arrayList;
                d.this.ajD = arrayList2;
                d.this.ajE = arrayList3;
            }
            if (d.this.ajF != null) {
                d.this.ajF.b(i, str, true, d.this.ajC, d.this.ajD, d.this.ajE);
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
        this.ajB = new com.baidu.live.gift.giftList.b(this.mContext);
        this.ajB.a(this.ajG);
    }

    public void dv(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.ajB.i(str, com.baidu.live.c.pr().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void dw(String str) {
        this.ajB.dC(str);
    }

    public void ts() {
        this.ajB.cancelLoadData();
    }

    public void a(a aVar) {
        this.ajF = aVar;
    }
}
