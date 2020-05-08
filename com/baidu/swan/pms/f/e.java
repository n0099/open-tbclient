package com.baidu.swan.pms.f;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes11.dex */
public class e {
    private Set<a> dbz = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.dbz.add(new a(eVar, pMSPkgStatus));
    }

    public int aCH() {
        return this.dbz.size();
    }

    public boolean isEmpty() {
        return this.dbz.isEmpty();
    }

    public boolean aCI() {
        for (a aVar : this.dbz) {
            if (aVar != null && (aVar.bVZ instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aCJ() {
        for (a aVar : this.dbz) {
            if (aVar != null && (aVar.bVZ instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aCK() {
        for (a aVar : this.dbz) {
            if (aVar != null && (aVar.bVZ instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aCL() {
        for (a aVar : this.dbz) {
            if (aVar != null && (aVar.bVZ instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dbA = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dbz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bVZ.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dbA = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dbz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bVZ.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aCM() {
        boolean z;
        Iterator<a> it = this.dbz.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bVZ instanceof g) && next.dbA == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private com.baidu.swan.pms.model.e bVZ;
        private PMSPkgStatus dbA;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.bVZ = eVar;
            this.dbA = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bVZ.equals(((a) obj).bVZ);
        }

        public int hashCode() {
            return Objects.hash(this.bVZ);
        }
    }
}
