package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int XL;
    private ArrayList<a> XM;

    /* loaded from: classes.dex */
    public static class a {
        public String WY;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.XL = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.XM = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.WY = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.XM.add(aVar);
                    }
                }
            }
        }
    }

    public int qy() {
        return this.XL;
    }

    public void bM(int i) {
        this.XL = i;
    }

    public ArrayList<a> qz() {
        return this.XM;
    }

    public void g(ArrayList<a> arrayList) {
        this.XM = arrayList;
    }
}
