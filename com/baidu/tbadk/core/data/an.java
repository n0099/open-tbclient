package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class an {
    private int aMg;
    private ArrayList<a> aMh;

    /* loaded from: classes.dex */
    public static class a {
        public String aLt;
        public int giftId;
        public String giftName;
        public int num;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.aMg = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.aMh = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.aLt = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.aMh.add(aVar);
                    }
                }
            }
        }
    }

    public int xZ() {
        return this.aMg;
    }

    public void eM(int i) {
        this.aMg = i;
    }

    public ArrayList<a> ya() {
        return this.aMh;
    }

    public void h(ArrayList<a> arrayList) {
        this.aMh = arrayList;
    }
}
