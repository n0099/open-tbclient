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
    private Set<a> dnn = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.dnn.add(new a(eVar, pMSPkgStatus));
    }

    public int aHn() {
        return this.dnn.size();
    }

    public boolean isEmpty() {
        return this.dnn.isEmpty();
    }

    public boolean aHo() {
        for (a aVar : this.dnn) {
            if (aVar != null && (aVar.cgu instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aHp() {
        for (a aVar : this.dnn) {
            if (aVar != null && (aVar.cgu instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aHq() {
        for (a aVar : this.dnn) {
            if (aVar != null && (aVar.cgu instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aHr() {
        for (a aVar : this.dnn) {
            if (aVar != null && (aVar.cgu instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dno = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dnn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cgu.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dno = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dnn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cgu.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aHs() {
        boolean z;
        Iterator<a> it = this.dnn.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cgu instanceof g) && next.dno == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cgu;
        private PMSPkgStatus dno;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cgu = eVar;
            this.dno = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cgu.equals(((a) obj).cgu);
        }

        public int hashCode() {
            return Objects.hash(this.cgu);
        }
    }
}
