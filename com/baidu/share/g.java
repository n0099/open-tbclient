package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private ArrayList a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        if (cVar == null || this.a == null) {
            return;
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ((a) this.a.get(i)).onShareEvent(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        boolean z = false;
        if (aVar != null) {
            synchronized (this.a) {
                if (!this.a.contains(aVar)) {
                    z = this.a.add(aVar);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(a aVar) {
        boolean remove;
        if (aVar == null) {
            return false;
        }
        synchronized (this.a) {
            remove = this.a.remove(aVar);
        }
        return remove;
    }
}
