package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int aoL;
    private ArrayList<a> aoM;

    /* loaded from: classes.dex */
    public static class a {
        public int giftId;
        public String giftName;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.aoL = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.aoM = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.aoM.add(aVar);
                    }
                }
            }
        }
    }

    public int getTotal() {
        return this.aoL;
    }

    public void setTotal(int i) {
        this.aoL = i;
    }

    public ArrayList<a> xN() {
        return this.aoM;
    }

    public void k(ArrayList<a> arrayList) {
        this.aoM = arrayList;
    }
}
