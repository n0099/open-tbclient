package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bwV = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> RD() {
        return this.bwV;
    }

    public int RE() {
        return this.bwV.size();
    }

    public void aa(List<com.baidu.live.talentshow.b.d> list) {
        this.bwV.addAll(ab(list));
    }

    public void RF() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bwV.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bwV.clear();
        this.bwV.addAll(arrayList);
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
        this.bwV.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> ab(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bwV)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
