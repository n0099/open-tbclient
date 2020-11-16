package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes6.dex */
public class f {
    private Set<a> ehP = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.ehP.add(new a(eVar, pMSPkgStatus));
    }

    public int bbR() {
        return this.ehP.size();
    }

    public boolean isEmpty() {
        return this.ehP.isEmpty();
    }

    public boolean bbS() {
        for (a aVar : this.ehP) {
            if (aVar != null && (aVar.cVE instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean bbT() {
        for (a aVar : this.ehP) {
            if (aVar != null && (aVar.cVE instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean bbU() {
        for (a aVar : this.ehP) {
            if (aVar != null && (aVar.cVE instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bbV() {
        for (a aVar : this.ehP) {
            if (aVar != null && (aVar.cVE instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean bbW() {
        for (a aVar : this.ehP) {
            if (aVar != null && (aVar.cVE instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.ehQ = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.ehP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cVE.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.ehQ = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.ehP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cVE.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean bbX() {
        boolean z;
        Iterator<a> it = this.ehP.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cVE instanceof com.baidu.swan.pms.model.g) && next.ehQ == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cVE;
        private PMSPkgStatus ehQ;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cVE = eVar;
            this.ehQ = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cVE.equals(((a) obj).cVE);
        }

        public int hashCode() {
            return Objects.hash(this.cVE);
        }
    }
}
