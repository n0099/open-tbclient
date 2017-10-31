package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class aq {
    private int Xt;
    private ArrayList<a> Xu;

    /* loaded from: classes.dex */
    public static class a {
        public String WE;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Xt = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Xu = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.WE = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Xu.add(aVar);
                    }
                }
            }
        }
    }

    public int qt() {
        return this.Xt;
    }

    public void bM(int i) {
        this.Xt = i;
    }

    public ArrayList<a> qu() {
        return this.Xu;
    }

    public void g(ArrayList<a> arrayList) {
        this.Xu = arrayList;
    }
}
