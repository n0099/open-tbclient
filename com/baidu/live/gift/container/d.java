package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.d;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.live.gift.giftList.d YL;
    private ArrayList<h> YM;
    private ArrayList<com.baidu.live.gift.a.a> YN;
    private ArrayList<com.baidu.live.gift.a.b> YO;
    private a YP;
    private d.a YQ = new d.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.d.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
            if (i == 0) {
                d.this.YM = arrayList;
                d.this.YN = arrayList2;
                d.this.YO = arrayList3;
            }
            if (d.this.YP != null) {
                d.this.YP.b(i, str, true, d.this.YM, d.this.YN, d.this.YO);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3);
    }

    public d(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.YL = new com.baidu.live.gift.giftList.d(this.mContext);
        this.YL.a(this.YQ);
    }

    public void cq(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.YL.f(str, com.baidu.live.c.np().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void cr(String str) {
        this.YL.cy(str);
    }

    public void qj() {
        this.YL.cancelLoadData();
    }

    public void a(a aVar) {
        this.YP = aVar;
    }
}
