package com.baidu.swan.pms.f;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes9.dex */
public class e {
    private Set<a> cxY = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.cxY.add(new a(eVar, pMSPkgStatus));
    }

    public int arK() {
        return this.cxY.size();
    }

    public boolean isEmpty() {
        return this.cxY.isEmpty();
    }

    public boolean arL() {
        for (a aVar : this.cxY) {
            if (aVar != null && (aVar.bsC instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean arM() {
        for (a aVar : this.cxY) {
            if (aVar != null && (aVar.bsC instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean arN() {
        for (a aVar : this.cxY) {
            if (aVar != null && (aVar.bsC instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean arO() {
        for (a aVar : this.cxY) {
            if (aVar != null && (aVar.bsC instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cxZ = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cxY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bsC.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cxZ = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cxY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bsC.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean arP() {
        boolean z;
        Iterator<a> it = this.cxY.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bsC instanceof g) && next.cxZ == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes9.dex */
    public static class a {
        private com.baidu.swan.pms.model.e bsC;
        private PMSPkgStatus cxZ;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.bsC = eVar;
            this.cxZ = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bsC.equals(((a) obj).bsC);
        }

        public int hashCode() {
            return Objects.hash(this.bsC);
        }
    }
}
