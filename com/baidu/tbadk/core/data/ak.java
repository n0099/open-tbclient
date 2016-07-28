package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ak {
    private int Ph;
    private ArrayList<a> Pi;

    /* loaded from: classes.dex */
    public static class a {
        public String FC;
        public int giftId;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Ph = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Pi = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.FC = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Pi.add(aVar);
                    }
                }
            }
        }
    }

    public int pp() {
        return this.Ph;
    }

    public void bE(int i) {
        this.Ph = i;
    }

    public ArrayList<a> pq() {
        return this.Pi;
    }

    public void h(ArrayList<a> arrayList) {
        this.Pi = arrayList;
    }
}
