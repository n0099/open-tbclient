package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes15.dex */
public class f {
    private Set<a> dVi = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.dVi.add(new a(eVar, pMSPkgStatus));
    }

    public int aYf() {
        return this.dVi.size();
    }

    public boolean isEmpty() {
        return this.dVi.isEmpty();
    }

    public boolean aYg() {
        for (a aVar : this.dVi) {
            if (aVar != null && (aVar.cIZ instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aYh() {
        for (a aVar : this.dVi) {
            if (aVar != null && (aVar.cIZ instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aYi() {
        for (a aVar : this.dVi) {
            if (aVar != null && (aVar.cIZ instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean aYj() {
        for (a aVar : this.dVi) {
            if (aVar != null && (aVar.cIZ instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aYk() {
        for (a aVar : this.dVi) {
            if (aVar != null && (aVar.cIZ instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dVj = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dVi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cIZ.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dVj = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dVi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cIZ.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aYl() {
        boolean z;
        Iterator<a> it = this.dVi.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cIZ instanceof com.baidu.swan.pms.model.g) && next.dVj == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cIZ;
        private PMSPkgStatus dVj;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cIZ = eVar;
            this.dVj = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cIZ.equals(((a) obj).cIZ);
        }

        public int hashCode() {
            return Objects.hash(this.cIZ);
        }
    }
}
