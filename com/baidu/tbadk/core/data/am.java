package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int aMc;
    private ArrayList<a> aMd;

    /* loaded from: classes.dex */
    public static class a {
        public String aLr;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.aMc = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.aMd = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.aLr = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.aMd.add(aVar);
                    }
                }
            }
        }
    }

    public int xW() {
        return this.aMc;
    }

    public void eL(int i) {
        this.aMc = i;
    }

    public ArrayList<a> xX() {
        return this.aMd;
    }

    public void h(ArrayList<a> arrayList) {
        this.aMd = arrayList;
    }
}
