package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class ar {
    private int WM;
    private ArrayList<a> WN;

    /* loaded from: classes.dex */
    public static class a {
        public String VP;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.WM = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.WN = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.VP = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.WN.add(aVar);
                    }
                }
            }
        }
    }

    public int qS() {
        return this.WM;
    }

    public void bL(int i) {
        this.WM = i;
    }

    public ArrayList<a> qT() {
        return this.WN;
    }

    public void g(ArrayList<a> arrayList) {
        this.WN = arrayList;
    }
}
