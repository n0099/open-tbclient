package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ax {
    private ArrayList<a> ebC;
    private int total;

    /* loaded from: classes.dex */
    public static class a {
        public int giftId;
        public String giftName;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.total = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.ebC = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.ebC.add(aVar);
                    }
                }
            }
        }
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public ArrayList<a> beq() {
        return this.ebC;
    }

    public void D(ArrayList<a> arrayList) {
        this.ebC = arrayList;
    }
}
