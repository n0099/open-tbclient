package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class v {
    private int VU;
    private ArrayList<a> VV;

    /* loaded from: classes.dex */
    public static class a {
        public String Oy;
        public int giftId;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.VU = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.VV = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.Oy = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.VV.add(aVar);
                    }
                }
            }
        }
    }

    public int sx() {
        return this.VU;
    }

    public void bR(int i) {
        this.VU = i;
    }

    public ArrayList<a> sy() {
        return this.VV;
    }

    public void j(ArrayList<a> arrayList) {
        this.VV = arrayList;
    }
}
