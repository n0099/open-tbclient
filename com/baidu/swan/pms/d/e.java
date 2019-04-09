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
    private Set<a> bnb = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.f fVar, PMSPkgStatus pMSPkgStatus) {
        this.bnb.add(new a(fVar, pMSPkgStatus));
    }

    public int So() {
        return this.bnb.size();
    }

    public boolean isEmpty() {
        return this.bnb.isEmpty();
    }

    public boolean Sp() {
        for (a aVar : this.bnb) {
            if (aVar != null && (aVar.bnc instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean Sq() {
        for (a aVar : this.bnb) {
            if (aVar != null && (aVar.bnc instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean Sr() {
        for (a aVar : this.bnb) {
            if (aVar != null && (aVar.bnc instanceof com.baidu.swan.pms.model.e)) {
                return true;
            }
        }
        return false;
    }

    public boolean Ss() {
        for (a aVar : this.bnb) {
            if (aVar != null && (aVar.bnc instanceof com.baidu.swan.pms.model.c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bnd = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.f fVar) {
        if (fVar != null) {
            Iterator<a> it = this.bnb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bnc.equals(fVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bnd = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.f fVar) {
        if (fVar != null) {
            Iterator<a> it = this.bnb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bnc.equals(fVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean St() {
        boolean z;
        Iterator<a> it = this.bnb.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bnc instanceof i) && next.bnd == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.baidu.swan.pms.model.f bnc;
        private PMSPkgStatus bnd;

        public a(com.baidu.swan.pms.model.f fVar, PMSPkgStatus pMSPkgStatus) {
            this.bnc = fVar;
            this.bnd = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bnc.equals(((a) obj).bnc);
        }

        public int hashCode() {
            return Objects.hash(this.bnc);
        }
    }
}
