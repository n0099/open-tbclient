package com.baidu.live.talentshow.components.selector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private ArrayList<com.baidu.live.talentshow.b.d> bvk = new ArrayList<>();

    public ArrayList<com.baidu.live.talentshow.b.d> QU() {
        return this.bvk;
    }

    public int QV() {
        return this.bvk.size();
    }

    public void aa(List<com.baidu.live.talentshow.b.d> list) {
        this.bvk.addAll(ab(list));
    }

    public void QW() {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        Iterator<com.baidu.live.talentshow.b.d> it = this.bvk.iterator();
        while (it.hasNext()) {
            com.baidu.live.talentshow.b.d next = it.next();
            if (!a(next, arrayList)) {
                arrayList.add(next);
            }
        }
        this.bvk.clear();
        this.bvk.addAll(arrayList);
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
        this.bvk.clear();
    }

    private ArrayList<com.baidu.live.talentshow.b.d> ab(List<com.baidu.live.talentshow.b.d> list) {
        ArrayList<com.baidu.live.talentshow.b.d> arrayList = new ArrayList<>();
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (!a(dVar, this.bvk)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
