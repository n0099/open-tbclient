package com.baidu.adp.plugin.packageManager;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a sw;
    private ArrayList<String> sx = new ArrayList<>();
    private b sy;

    private a() {
    }

    public static a hZ() {
        if (sw == null) {
            synchronized (a.class) {
                if (sw == null) {
                    sw = new a();
                }
            }
        }
        return sw;
    }

    public void i(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.sx.contains(next)) {
                    this.sx.add(next);
                }
            }
            ia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        if (this.sx.size() != 0 && this.sy == null) {
            this.sy = new b(this, this.sx.get(0));
            this.sy.execute(new String[0]);
        }
    }
}
