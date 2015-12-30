package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class r {
    private int We;
    private ArrayList<a> Wf;

    /* loaded from: classes.dex */
    public static class a {
        public String Wg;
        public int giftId;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.We = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.Wf = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.Wg = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.Wf.add(aVar);
                    }
                }
            }
        }
    }

    public int rQ() {
        return this.We;
    }

    public void bA(int i) {
        this.We = i;
    }

    public ArrayList<a> rR() {
        return this.Wf;
    }

    public void i(ArrayList<a> arrayList) {
        this.Wf = arrayList;
    }
}
