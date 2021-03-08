package com.baidu.live.yuyingift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.h;
import com.baidu.live.yuyingift.giftlist.b;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private ArrayList<h> bcv;
    private ArrayList<i> bcw;
    private ArrayList<l> bcx;
    private com.baidu.live.yuyingift.giftlist.b cam;
    private a can;
    private b.a cao = new b.a() { // from class: com.baidu.live.yuyingift.container.e.1
        @Override // com.baidu.live.yuyingift.giftlist.b.a
        public void a(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i == 0) {
                e.this.bcv = arrayList;
                e.this.bcw = arrayList2;
                e.this.bcx = arrayList3;
            }
            if (e.this.can != null) {
                e.this.can.b(i, str, true, e.this.bcv, e.this.bcw, e.this.bcx, aeVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.cam = new com.baidu.live.yuyingift.giftlist.b(this.mContext);
        this.cam.a(this.cao);
    }

    public void gG(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.cam.a(str, com.baidu.live.d.xf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void gH(String str) {
        this.cam.q(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.can = aVar;
    }
}
