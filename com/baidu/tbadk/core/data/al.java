package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class al {
    private int RT;
    private ArrayList<a> RU;

    /* loaded from: classes.dex */
    public static class a {
        public String HP;
        public String QV;
        public int giftId;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.RT = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.RU = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.HP = pbPresentList.gift_name;
                        aVar.QV = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.RU.add(aVar);
                    }
                }
            }
        }
    }

    public int qs() {
        return this.RT;
    }

    public void bR(int i) {
        this.RT = i;
    }

    public ArrayList<a> qt() {
        return this.RU;
    }

    public void h(ArrayList<a> arrayList) {
        this.RU = arrayList;
    }
}
