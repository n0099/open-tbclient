package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.j;
import com.baidu.live.data.y;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private ArrayList<h> aZo;
    private ArrayList<com.baidu.live.data.h> aZp;
    private ArrayList<j> aZq;
    private com.baidu.live.yuyingift.giftlist.b bQk;
    private a bQl;
    private b.a bQm = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i == 0) {
                e.this.aZo = arrayList;
                e.this.aZp = arrayList2;
                e.this.aZq = arrayList3;
            }
            if (e.this.bQl != null) {
                e.this.bQl.b(i, str, true, e.this.aZo, e.this.aZp, e.this.aZq, yVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.bQk = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.bQk.a(this.bQm);
    }

    public void ho(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bQk.a(str, com.baidu.live.d.AZ().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hp(String str) {
        this.bQk.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bQl = aVar;
    }
}
