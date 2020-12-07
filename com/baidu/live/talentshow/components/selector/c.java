package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bAu = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> Ts() {
        return this.bAu;
    }

    public int Tt() {
        return this.bAu.size();
    }

    public void ac(List<com.baidu.live.talentshow.b.d> list) {
        this.bAu.addAll(ad(list));
    }

    public void Tu() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bAu.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bAu.clear();
        this.bAu.addAll(arrayList);
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
        this.bAu.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> ad(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bAu)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
