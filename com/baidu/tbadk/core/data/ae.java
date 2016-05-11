package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ae {
    private int OT;
    private ArrayList<a> OU;

    /* loaded from: classes.dex */
    public static class a {
        public String EV;
        public int giftId;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.OT = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.OU = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.EV = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.OU.add(aVar);
                    }
                }
            }
        }
    }

    public int pM() {
        return this.OT;
    }

    public void bF(int i) {
        this.OT = i;
    }

    public ArrayList<a> pN() {
        return this.OU;
    }

    public void g(ArrayList<a> arrayList) {
        this.OU = arrayList;
    }
}
