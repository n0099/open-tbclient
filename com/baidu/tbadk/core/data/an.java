package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class an {
    private int RZ;
    private ArrayList<a> Sa;

    /* loaded from: classes.dex */
    public static class a {
        public String HP;
        public String Rb;
        public int giftId;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.RZ = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Sa = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.HP = pbPresentList.gift_name;
                        aVar.Rb = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Sa.add(aVar);
                    }
                }
            }
        }
    }

    public int qD() {
        return this.RZ;
    }

    public void bR(int i) {
        this.RZ = i;
    }

    public ArrayList<a> qE() {
        return this.Sa;
    }

    public void h(ArrayList<a> arrayList) {
        this.Sa = arrayList;
    }
}
