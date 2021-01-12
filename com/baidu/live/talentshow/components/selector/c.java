package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bAv = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> QC() {
        return this.bAv;
    }

    public int QD() {
        return this.bAv.size();
    }

    public void ad(List<com.baidu.live.talentshow.b.d> list) {
        this.bAv.addAll(ae(list));
    }

    public void QE() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bAv.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bAv.clear();
        this.bAv.addAll(arrayList);
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
        this.bAv.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> ae(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bAv)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
