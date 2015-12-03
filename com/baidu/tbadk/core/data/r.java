package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class r {
    private int VE;
    private ArrayList<a> VF;

    /* loaded from: classes.dex */
    public static class a {
        public String VG;
        public int giftId;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.VE = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.VF = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.VG = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.VF.add(aVar);
                    }
                }
            }
        }
    }

    public int sh() {
        return this.VE;
    }

    public void bH(int i) {
        this.VE = i;
    }

    public ArrayList<a> si() {
        return this.VF;
    }

    public void i(ArrayList<a> arrayList) {
        this.VF = arrayList;
    }
}
