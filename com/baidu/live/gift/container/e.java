package com.baidu.live.gift.container;

import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.y;
import com.baidu.live.gift.giftList.c;
import com.baidu.live.gift.i;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.gift.giftList.c aXV;
    private ArrayList<i> aXW;
    private ArrayList<h> aXX;
    private ArrayList<j> aXY;
    private a aXZ;
    private c.a aYa = new c.a() { // from class: com.baidu.live.gift.container.e.1
        @Override // com.baidu.live.gift.giftList.c.a
        public void a(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i == 0) {
                e.this.aXW = arrayList;
                e.this.aXX = arrayList2;
                e.this.aXY = arrayList3;
            }
            if (e.this.aXZ != null) {
                e.this.aXZ.b(i, str, true, e.this.aXW, e.this.aXX, e.this.aXY, yVar);
            }
        }
    };
    private BdPageContext mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, y yVar);
    }

    public e(BdPageContext bdPageContext, boolean z) {
        this.mContext = bdPageContext;
        this.aXV = new com.baidu.live.gift.giftList.c(this.mContext);
        this.aXV.a(this.aYa);
    }

    public void hh(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.aXV.a(str, com.baidu.live.d.AZ().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0, "open", "gift_panel");
    }

    public void hi(String str) {
        this.aXV.o(str, "open", "gift_panel");
    }

    public void a(a aVar) {
        this.aXZ = aVar;
    }
}
