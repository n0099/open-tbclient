package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.live.gift.giftList.b ajC;
    private ArrayList<i> ajD;
    private ArrayList<com.baidu.live.data.d> ajE;
    private ArrayList<com.baidu.live.data.e> ajF;
    private a ajG;
    private b.a ajH = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3) {
            if (i == 0) {
                d.this.ajD = arrayList;
                d.this.ajE = arrayList2;
                d.this.ajF = arrayList3;
            }
            if (d.this.ajG != null) {
                d.this.ajG.b(i, str, true, d.this.ajD, d.this.ajE, d.this.ajF);
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
        this.ajC = new com.baidu.live.gift.giftList.b(this.mContext);
        this.ajC.a(this.ajH);
    }

    public void dv(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.ajC.i(str, com.baidu.live.c.pr().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void dw(String str) {
        this.ajC.dC(str);
    }

    public void ts() {
        this.ajC.cancelLoadData();
    }

    public void a(a aVar) {
        this.ajG = aVar;
    }
}
