package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ad {
    private int Uc;
    private ArrayList<a> Ud;

    /* loaded from: classes.dex */
    public static class a {
        public String OF;
        public int giftId;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.Uc = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Ud = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.OF = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Ud.add(aVar);
                    }
                }
            }
        }
    }

    public int ss() {
        return this.Uc;
    }

    public void bT(int i) {
        this.Uc = i;
    }

    public ArrayList<a> st() {
        return this.Ud;
    }

    public void g(ArrayList<a> arrayList) {
        this.Ud = arrayList;
    }
}
