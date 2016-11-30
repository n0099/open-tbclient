package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ap {
    private int Su;
    private ArrayList<a> Sv;

    /* loaded from: classes.dex */
    public static class a {
        public String HR;
        public String Rw;
        public int giftId;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Su = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Sv = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.HR = pbPresentList.gift_name;
                        aVar.Rw = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Sv.add(aVar);
                    }
                }
            }
        }
    }

    public int qF() {
        return this.Su;
    }

    public void bR(int i) {
        this.Su = i;
    }

    public ArrayList<a> qG() {
        return this.Sv;
    }

    public void h(ArrayList<a> arrayList) {
        this.Sv = arrayList;
    }
}
