package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int aNo;
    private ArrayList<a> aNp;

    /* loaded from: classes.dex */
    public static class a {
        public int giftId;
        public String giftName;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.aNo = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.aNp = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.aNp.add(aVar);
                    }
                }
            }
        }
    }

    public int yy() {
        return this.aNo;
    }

    public void eL(int i) {
        this.aNo = i;
    }

    public ArrayList<a> yz() {
        return this.aNp;
    }

    public void h(ArrayList<a> arrayList) {
        this.aNp = arrayList;
    }
}
