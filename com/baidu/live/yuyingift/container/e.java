package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.j;
import com.baidu.live.data.z;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.yuyingift.giftlist.b bTK;
    private a bTL;
    private b.a bTM = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, z zVar) {
            if (i == 0) {
                e.this.baV = arrayList;
                e.this.baW = arrayList2;
                e.this.baX = arrayList3;
            }
            if (e.this.bTL != null) {
                e.this.bTL.b(i, str, true, e.this.baV, e.this.baW, e.this.baX, zVar);
            }
        }
    };
    private ArrayList<h> baV;
    private ArrayList<com.baidu.live.data.h> baW;
    private ArrayList<j> baX;
    private BdPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, z zVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bTK = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.bTK.a(this.bTM);
    }

    public void hD(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bTK.a(str, com.baidu.live.d.BM().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hE(String str) {
        this.bTK.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bTL = aVar;
    }
}
