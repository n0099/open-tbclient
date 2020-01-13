package com.baidu.swan.pms.f;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes10.dex */
public class e {
    private Set<a> cyj = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.cyj.add(new a(eVar, pMSPkgStatus));
    }

    public int asd() {
        return this.cyj.size();
    }

    public boolean isEmpty() {
        return this.cyj.isEmpty();
    }

    public boolean ase() {
        for (a aVar : this.cyj) {
            if (aVar != null && (aVar.btq instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean asf() {
        for (a aVar : this.cyj) {
            if (aVar != null && (aVar.btq instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean asg() {
        for (a aVar : this.cyj) {
            if (aVar != null && (aVar.btq instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean ash() {
        for (a aVar : this.cyj) {
            if (aVar != null && (aVar.btq instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cyk = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cyj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.btq.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cyk = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cyj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.btq.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean asi() {
        boolean z;
        Iterator<a> it = this.cyj.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.btq instanceof g) && next.cyk == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private com.baidu.swan.pms.model.e btq;
        private PMSPkgStatus cyk;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.btq = eVar;
            this.cyk = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.btq.equals(((a) obj).btq);
        }

        public int hashCode() {
            return Objects.hash(this.btq);
        }
    }
}
