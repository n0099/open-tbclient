package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes24.dex */
public class f {
    private Set<a> dJh = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.dJh.add(new a(eVar, pMSPkgStatus));
    }

    public int aVw() {
        return this.dJh.size();
    }

    public boolean isEmpty() {
        return this.dJh.isEmpty();
    }

    public boolean aVx() {
        for (a aVar : this.dJh) {
            if (aVar != null && (aVar.cwU instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aVy() {
        for (a aVar : this.dJh) {
            if (aVar != null && (aVar.cwU instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aVz() {
        for (a aVar : this.dJh) {
            if (aVar != null && (aVar.cwU instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean aVA() {
        for (a aVar : this.dJh) {
            if (aVar != null && (aVar.cwU instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aVB() {
        for (a aVar : this.dJh) {
            if (aVar != null && (aVar.cwU instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dJi = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dJh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cwU.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dJi = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dJh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cwU.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aVC() {
        boolean z;
        Iterator<a> it = this.dJh.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cwU instanceof com.baidu.swan.pms.model.g) && next.dJi == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes24.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cwU;
        private PMSPkgStatus dJi;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cwU = eVar;
            this.dJi = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cwU.equals(((a) obj).cwU);
        }

        public int hashCode() {
            return Objects.hash(this.cwU);
        }
    }
}
