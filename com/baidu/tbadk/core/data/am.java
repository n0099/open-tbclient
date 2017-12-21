package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int XI;
    private ArrayList<a> XJ;

    /* loaded from: classes.dex */
    public static class a {
        public String WV;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.XI = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.XJ = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.WV = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.XJ.add(aVar);
                    }
                }
            }
        }
    }

    public int qw() {
        return this.XI;
    }

    public void bM(int i) {
        this.XI = i;
    }

    public ArrayList<a> qx() {
        return this.XJ;
    }

    public void g(ArrayList<a> arrayList) {
        this.XJ = arrayList;
    }
}
