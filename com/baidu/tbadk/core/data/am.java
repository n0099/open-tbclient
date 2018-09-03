package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int agD;
    private ArrayList<a> agE;

    /* loaded from: classes.dex */
    public static class a {
        public int giftId;
        public String giftName;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.agD = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.agE = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.agE.add(aVar);
                    }
                }
            }
        }
    }

    public int ut() {
        return this.agD;
    }

    public void bP(int i) {
        this.agD = i;
    }

    public ArrayList<a> uu() {
        return this.agE;
    }

    public void k(ArrayList<a> arrayList) {
        this.agE = arrayList;
    }
}
