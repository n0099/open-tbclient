package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class an {
    private int agR;
    private ArrayList<a> agS;

    /* loaded from: classes.dex */
    public static class a {
        public int giftId;
        public String giftName;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.agR = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.agS = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.agS.add(aVar);
                    }
                }
            }
        }
    }

    public int uz() {
        return this.agR;
    }

    public void bM(int i) {
        this.agR = i;
    }

    public ArrayList<a> uA() {
        return this.agS;
    }

    public void g(ArrayList<a> arrayList) {
        this.agS = arrayList;
    }
}
