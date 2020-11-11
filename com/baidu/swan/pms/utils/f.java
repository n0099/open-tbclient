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
    private Set<a> ejw = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.ejw.add(new a(eVar, pMSPkgStatus));
    }

    public int bcy() {
        return this.ejw.size();
    }

    public boolean isEmpty() {
        return this.ejw.isEmpty();
    }

    public boolean bcz() {
        for (a aVar : this.ejw) {
            if (aVar != null && (aVar.cXo instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean bcA() {
        for (a aVar : this.ejw) {
            if (aVar != null && (aVar.cXo instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean bcB() {
        for (a aVar : this.ejw) {
            if (aVar != null && (aVar.cXo instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bcC() {
        for (a aVar : this.ejw) {
            if (aVar != null && (aVar.cXo instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean bcD() {
        for (a aVar : this.ejw) {
            if (aVar != null && (aVar.cXo instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.ejx = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.ejw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cXo.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.ejx = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.ejw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cXo.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean bcE() {
        boolean z;
        Iterator<a> it = this.ejw.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cXo instanceof com.baidu.swan.pms.model.g) && next.ejx == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cXo;
        private PMSPkgStatus ejx;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cXo = eVar;
            this.ejx = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cXo.equals(((a) obj).cXo);
        }

        public int hashCode() {
            return Objects.hash(this.cXo);
        }
    }
}
