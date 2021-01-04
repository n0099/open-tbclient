package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bFh = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> Ux() {
        return this.bFh;
    }

    public int Uy() {
        return this.bFh.size();
    }

    public void ad(List<com.baidu.live.talentshow.b.d> list) {
        this.bFh.addAll(ae(list));
    }

    public void Uz() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bFh.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bFh.clear();
        this.bFh.addAll(arrayList);
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
        this.bFh.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> ae(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bFh)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
