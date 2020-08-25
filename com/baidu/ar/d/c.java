package com.baidu.ar.d;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class c extends b {
    private ArrayList<b> mm;

    public c() {
        T("DetectorGroup");
    }

    public boolean U(String str) {
        Iterator<b> it = this.mm.iterator();
        while (it.hasNext()) {
            if (it.next().dd().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(b bVar) {
        if (this.mm == null) {
            this.mm = new ArrayList<>();
        }
        this.mm.add(bVar);
    }

    public ArrayList<b> dg() {
        return this.mm;
    }
}
