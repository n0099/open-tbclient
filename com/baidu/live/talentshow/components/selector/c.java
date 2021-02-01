package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bEb = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> Sm() {
        return this.bEb;
    }

    public int Sn() {
        return this.bEb.size();
    }

    public void ae(List<com.baidu.live.talentshow.b.d> list) {
        this.bEb.addAll(af(list));
    }

    public void So() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bEb.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bEb.clear();
        this.bEb.addAll(arrayList);
    }

    private boolean a(com.baidu.live.talentshow.b.d dVar, ArrayList<com.baidu.live.talentshow.b.d> arrayList) {
        Iterator<com.baidu.live.talentshow.b.d> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (next.uid != null && next.uid.equals(dVar.uid)) {
                return true;
            }
        }
        return false;
    }

    public void clearData() {
        this.bEb.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> af(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bEb)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
