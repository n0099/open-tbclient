package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int aMf;
    private ArrayList<a> aMg;

    /* loaded from: classes.dex */
    public static class a {
        public String aLu;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.aMf = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.aMg = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.aLu = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.aMg.add(aVar);
                    }
                }
            }
        }
    }

    public int xX() {
        return this.aMf;
    }

    public void eL(int i) {
        this.aMf = i;
    }

    public ArrayList<a> xY() {
        return this.aMg;
    }

    public void h(ArrayList<a> arrayList) {
        this.aMg = arrayList;
    }
}
