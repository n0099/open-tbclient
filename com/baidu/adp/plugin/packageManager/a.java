package com.baidu.adp.plugin.packageManager;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a sC;
    private ArrayList<String> sD = new ArrayList<>();
    private b sE;

    private a() {
    }

    public static a hS() {
        if (sC == null) {
            synchronized (a.class) {
                if (sC == null) {
                    sC = new a();
                }
            }
        }
        return sC;
    }

    public void i(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.sD.contains(next)) {
                    this.sD.add(next);
                }
            }
            hT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT() {
        if (this.sD.size() != 0 && this.sE == null) {
            this.sE = new b(this, this.sD.get(0));
            this.sE.execute(new String[0]);
        }
    }
}
