package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bFB = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> Sp() {
        return this.bFB;
    }

    public int Sq() {
        return this.bFB.size();
    }

    public void ae(List<com.baidu.live.talentshow.b.d> list) {
        this.bFB.addAll(af(list));
    }

    public void Sr() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bFB.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bFB.clear();
        this.bFB.addAll(arrayList);
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
        this.bFB.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> af(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bFB)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
