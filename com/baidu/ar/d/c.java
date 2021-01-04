package com.baidu.ar.d;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c extends b {
    private ArrayList<b> mB;

    public c() {
        W("DetectorGroup");
    }

    public boolean X(String str) {
        Iterator<b> it = this.mB.iterator();
        while (it.hasNext()) {
            if (it.next().dc().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void c(b bVar) {
        if (this.mB == null) {
            this.mB = new ArrayList<>();
        }
        this.mB.add(bVar);
    }

    public ArrayList<b> df() {
        return this.mB;
    }
}
