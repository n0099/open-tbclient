package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class aq {
    private int Xb;
    private ArrayList<a> Xc;

    /* loaded from: classes.dex */
    public static class a {
        public String We;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Xb = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Xc = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.We = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Xc.add(aVar);
                    }
                }
            }
        }
    }

    public int rp() {
        return this.Xb;
    }

    public void bO(int i) {
        this.Xb = i;
    }

    public ArrayList<a> rq() {
        return this.Xc;
    }

    public void g(ArrayList<a> arrayList) {
        this.Xc = arrayList;
    }
}
