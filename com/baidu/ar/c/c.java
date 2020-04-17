package com.baidu.ar.c;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c extends b {
    private ArrayList<b> lh;

    public c() {
        S("DetectorGroup");
    }

    public boolean T(String str) {
        Iterator<b> it = this.lh.iterator();
        while (it.hasNext()) {
            if (it.next().cl().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(b bVar) {
        if (this.lh == null) {
            this.lh = new ArrayList<>();
        }
        this.lh.add(bVar);
    }

    public ArrayList<b> co() {
        return this.lh;
    }
}
