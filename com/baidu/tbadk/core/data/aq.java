package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class aq {
    private int Xc;
    private ArrayList<a> Xd;

    /* loaded from: classes.dex */
    public static class a {
        public String Wg;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Xc = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Xd = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.Wg = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Xd.add(aVar);
                    }
                }
            }
        }
    }

    public int rp() {
        return this.Xc;
    }

    public void bO(int i) {
        this.Xc = i;
    }

    public ArrayList<a> rq() {
        return this.Xd;
    }

    public void g(ArrayList<a> arrayList) {
        this.Xd = arrayList;
    }
}
