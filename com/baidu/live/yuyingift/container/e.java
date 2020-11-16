package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.j;
import com.baidu.live.data.y;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private ArrayList<h> aXD;
    private ArrayList<com.baidu.live.data.h> aXE;
    private ArrayList<j> aXF;
    private com.baidu.live.yuyingift.giftlist.b bOA;
    private a bOB;
    private b.a bOC = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i == 0) {
                e.this.aXD = arrayList;
                e.this.aXE = arrayList2;
                e.this.aXF = arrayList3;
            }
            if (e.this.bOB != null) {
                e.this.bOB.b(i, str, true, e.this.aXD, e.this.aXE, e.this.aXF, yVar);
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
        this.bOA = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.bOA.a(this.bOC);
    }

    public void hi(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bOA.a(str, com.baidu.live.d.Aq().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hj(String str) {
        this.bOA.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.bOB = aVar;
    }
}
