package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.d;
import com.baidu.live.gift.h;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.live.gift.giftList.d Zd;
    private ArrayList<h> Ze;
    private ArrayList<com.baidu.live.gift.a.a> Zf;
    private ArrayList<com.baidu.live.gift.a.b> Zg;
    private a Zh;
    private d.a Zi = new d.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.d.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3) {
            if (i == 0) {
                d.this.Ze = arrayList;
                d.this.Zf = arrayList2;
                d.this.Zg = arrayList3;
            }
            if (d.this.Zh != null) {
                d.this.Zh.b(i, str, true, d.this.Ze, d.this.Zf, d.this.Zg);
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
        this.Zd = new com.baidu.live.gift.giftList.d(this.mContext);
        this.Zd.a(this.Zi);
    }

    public void cq(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.Zd.f(str, com.baidu.live.c.np().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void cr(String str) {
        this.Zd.cy(str);
    }

    public void qi() {
        this.Zd.cancelLoadData();
    }

    public void a(a aVar) {
        this.Zh = aVar;
    }
}
