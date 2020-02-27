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
    private Set<a> cCh = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.cCh.add(new a(eVar, pMSPkgStatus));
    }

    public int aur() {
        return this.cCh.size();
    }

    public boolean isEmpty() {
        return this.cCh.isEmpty();
    }

    public boolean aus() {
        for (a aVar : this.cCh) {
            if (aVar != null && (aVar.bxA instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aut() {
        for (a aVar : this.cCh) {
            if (aVar != null && (aVar.bxA instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean auu() {
        for (a aVar : this.cCh) {
            if (aVar != null && (aVar.bxA instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean auv() {
        for (a aVar : this.cCh) {
            if (aVar != null && (aVar.bxA instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cCi = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cCh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bxA.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cCi = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cCh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bxA.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean auw() {
        boolean z;
        Iterator<a> it = this.cCh.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bxA instanceof g) && next.cCi == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private com.baidu.swan.pms.model.e bxA;
        private PMSPkgStatus cCi;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.bxA = eVar;
            this.cCi = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bxA.equals(((a) obj).bxA);
        }

        public int hashCode() {
            return Objects.hash(this.bxA);
        }
    }
}
