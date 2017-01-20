package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ap {
    private int Ry;
    private ArrayList<a> Rz;

    /* loaded from: classes.dex */
    public static class a {
        public String QC;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Ry = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Rz = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.QC = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Rz.add(aVar);
                    }
                }
            }
        }
    }

    public int qz() {
        return this.Ry;
    }

    public void bQ(int i) {
        this.Ry = i;
    }

    public ArrayList<a> qA() {
        return this.Rz;
    }

    public void h(ArrayList<a> arrayList) {
        this.Rz = arrayList;
    }
}
