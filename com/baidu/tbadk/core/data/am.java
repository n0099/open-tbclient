package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class am {
    private int XF;
    private ArrayList<a> XG;

    /* loaded from: classes.dex */
    public static class a {
        public String WS;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.XF = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.XG = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.WS = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.XG.add(aVar);
                    }
                }
            }
        }
    }

    public int qw() {
        return this.XF;
    }

    public void bM(int i) {
        this.XF = i;
    }

    public ArrayList<a> qx() {
        return this.XG;
    }

    public void g(ArrayList<a> arrayList) {
        this.XG = arrayList;
    }
}
