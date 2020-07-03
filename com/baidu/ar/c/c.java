package com.baidu.ar.c;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c extends b {
    private ArrayList<b> lE;

    public c() {
        S("DetectorGroup");
    }

    public boolean T(String str) {
        Iterator<b> it = this.lE.iterator();
        while (it.hasNext()) {
            if (it.next().cD().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(b bVar) {
        if (this.lE == null) {
            this.lE = new ArrayList<>();
        }
        this.lE.add(bVar);
    }

    public ArrayList<b> cG() {
        return this.lE;
    }
}
