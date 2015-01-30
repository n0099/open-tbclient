package com.baidu.adp.plugin.packageManager;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a sF;
    private ArrayList<String> sG = new ArrayList<>();
    private b sH;

    private a() {
    }

    public static a hZ() {
        if (sF == null) {
            synchronized (a.class) {
                if (sF == null) {
                    sF = new a();
                }
            }
        }
        return sF;
    }

    public void i(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.sG.contains(next)) {
                    this.sG.add(next);
                }
            }
            ia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.sG.size() != 0 && this.sH == null) {
            this.sH = new b(this, this.sG.get(0));
            this.sH.execute(new String[0]);
        }
    }
}
