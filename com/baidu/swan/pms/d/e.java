package com.baidu.swan.pms.d;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {
    private Set<a> bna = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.f fVar, PMSPkgStatus pMSPkgStatus) {
        this.bna.add(new a(fVar, pMSPkgStatus));
    }

    public int So() {
        return this.bna.size();
    }

    public boolean isEmpty() {
        return this.bna.isEmpty();
    }

    public boolean Sp() {
        for (a aVar : this.bna) {
            if (aVar != null && (aVar.bnb instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean Sq() {
        for (a aVar : this.bna) {
            if (aVar != null && (aVar.bnb instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean Sr() {
        for (a aVar : this.bna) {
            if (aVar != null && (aVar.bnb instanceof com.baidu.swan.pms.model.e)) {
                return true;
            }
        }
        return false;
    }

    public boolean Ss() {
        for (a aVar : this.bna) {
            if (aVar != null && (aVar.bnb instanceof com.baidu.swan.pms.model.c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bnc = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.f fVar) {
        if (fVar != null) {
            Iterator<a> it = this.bna.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bnb.equals(fVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bnc = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.f fVar) {
        if (fVar != null) {
            Iterator<a> it = this.bna.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bnb.equals(fVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean St() {
        boolean z;
        Iterator<a> it = this.bna.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bnb instanceof i) && next.bnc == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.baidu.swan.pms.model.f bnb;
        private PMSPkgStatus bnc;

        public a(com.baidu.swan.pms.model.f fVar, PMSPkgStatus pMSPkgStatus) {
            this.bnb = fVar;
            this.bnc = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bnb.equals(((a) obj).bnb);
        }

        public int hashCode() {
            return Objects.hash(this.bnb);
        }
    }
}
