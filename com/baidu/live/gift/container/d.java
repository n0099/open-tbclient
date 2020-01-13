package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.live.gift.giftList.b ahs;
    private ArrayList<i> aht;
    private ArrayList<com.baidu.live.data.c> ahu;
    private ArrayList<com.baidu.live.data.d> ahv;
    private a ahw;
    private b.a ahx = new b.a() { // from class: com.baidu.live.gift.container.d.1
        @Override // com.baidu.live.gift.giftList.b.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3) {
            if (i == 0) {
                d.this.aht = arrayList;
                d.this.ahu = arrayList2;
                d.this.ahv = arrayList3;
            }
            if (d.this.ahw != null) {
                d.this.ahw.b(i, str, true, d.this.aht, d.this.ahu, d.this.ahv);
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
        this.ahs = new com.baidu.live.gift.giftList.b(this.mContext);
        this.ahs.a(this.ahx);
    }

    public void dk(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.ahs.i(str, com.baidu.live.c.oJ().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    public void dl(String str) {
        this.ahs.ds(str);
    }

    public void sg() {
        this.ahs.cancelLoadData();
    }

    public void a(a aVar) {
        this.ahw = aVar;
    }
}
