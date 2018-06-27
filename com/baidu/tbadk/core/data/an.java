package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes.dex */
public class an {
    private int ahj;
    private ArrayList<a> ahk;

    /* loaded from: classes.dex */
    public static class a {
        public int giftId;
        public String giftName;
        public int num;
        public String thumbnailUrl;
    }

    public void a(PbPresent pbPresent) {
        if (pbPresent != null) {
            this.ahj = pbPresent.total.intValue();
            if (pbPresent.list != null && pbPresent.list.size() > 0) {
                this.ahk = new ArrayList<>();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    if (pbPresentList != null) {
                        a aVar = new a();
                        aVar.giftId = pbPresentList.gift_id.intValue();
                        aVar.giftName = pbPresentList.gift_name;
                        aVar.thumbnailUrl = pbPresentList.thumbnail_url;
                        aVar.num = pbPresentList.num.intValue();
                        this.ahk.add(aVar);
                    }
                }
            }
        }
    }

    public int uH() {
        return this.ahj;
    }

    public void bN(int i) {
        this.ahj = i;
    }

    public ArrayList<a> uI() {
        return this.ahk;
    }

    public void k(ArrayList<a> arrayList) {
        this.ahk = arrayList;
    }
}
