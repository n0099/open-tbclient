package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class av {
    private ArrayList<a> dJJ;
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
                this.dJJ = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.dJJ.add(aVar);
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

    public ArrayList<a> aRh() {
        return this.dJJ;
    }

    public void w(ArrayList<a> arrayList) {
        this.dJJ = arrayList;
    }
}
