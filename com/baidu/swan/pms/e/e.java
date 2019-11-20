package com.baidu.swan.pms.e;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {
    private Set<a> bMj = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.bMj.add(new a(eVar, pMSPkgStatus));
    }

    public int abL() {
        return this.bMj.size();
    }

    public boolean isEmpty() {
        return this.bMj.isEmpty();
    }

    public boolean abM() {
        for (a aVar : this.bMj) {
            if (aVar != null && (aVar.aRN instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean abN() {
        for (a aVar : this.bMj) {
            if (aVar != null && (aVar.aRN instanceof h)) {
                return true;
            }
        }
        return false;
    }

    public boolean abO() {
        for (a aVar : this.bMj) {
            if (aVar != null && (aVar.aRN instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean abP() {
        for (a aVar : this.bMj) {
            if (aVar != null && (aVar.aRN instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bMk = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.bMj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.aRN.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bMk = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.bMj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.aRN.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean abQ() {
        boolean z;
        Iterator<a> it = this.bMj.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.aRN instanceof h) && next.bMk == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.baidu.swan.pms.model.e aRN;
        private PMSPkgStatus bMk;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.aRN = eVar;
            this.bMk = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.aRN.equals(((a) obj).aRN);
        }

        public int hashCode() {
            return Objects.hash(this.aRN);
        }
    }
}
