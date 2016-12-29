package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ao {
    private int Sp;
    private ArrayList<a> Sq;

    /* loaded from: classes.dex */
    public static class a {
        public String HQ;
        public String Rt;
        public int giftId;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Sp = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Sq = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.HQ = pbPresentList.gift_name;
                        aVar.Rt = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Sq.add(aVar);
                    }
                }
            }
        }
    }

    public int qG() {
        return this.Sp;
    }

    public void bR(int i) {
        this.Sp = i;
    }

    public ArrayList<a> qH() {
        return this.Sq;
    }

    public void h(ArrayList<a> arrayList) {
        this.Sq = arrayList;
    }
}
