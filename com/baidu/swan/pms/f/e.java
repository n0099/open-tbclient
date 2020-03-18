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
    private Set<a> cCu = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.cCu.add(new a(eVar, pMSPkgStatus));
    }

    public int auw() {
        return this.cCu.size();
    }

    public boolean isEmpty() {
        return this.cCu.isEmpty();
    }

    public boolean aux() {
        for (a aVar : this.cCu) {
            if (aVar != null && (aVar.bxN instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean auy() {
        for (a aVar : this.cCu) {
            if (aVar != null && (aVar.bxN instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean auz() {
        for (a aVar : this.cCu) {
            if (aVar != null && (aVar.bxN instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean auA() {
        for (a aVar : this.cCu) {
            if (aVar != null && (aVar.bxN instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cCv = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cCu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bxN.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cCv = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cCu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bxN.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean auB() {
        boolean z;
        Iterator<a> it = this.cCu.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bxN instanceof g) && next.cCv == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private com.baidu.swan.pms.model.e bxN;
        private PMSPkgStatus cCv;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.bxN = eVar;
            this.cCv = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bxN.equals(((a) obj).bxN);
        }

        public int hashCode() {
            return Objects.hash(this.bxN);
        }
    }
}
