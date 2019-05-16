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
    private Set<a> btc = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.btc.add(new a(eVar, pMSPkgStatus));
    }

    public int Wa() {
        return this.btc.size();
    }

    public boolean isEmpty() {
        return this.btc.isEmpty();
    }

    public boolean Wb() {
        for (a aVar : this.btc) {
            if (aVar != null && (aVar.axK instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean Wc() {
        for (a aVar : this.btc) {
            if (aVar != null && (aVar.axK instanceof h)) {
                return true;
            }
        }
        return false;
    }

    public boolean Wd() {
        for (a aVar : this.btc) {
            if (aVar != null && (aVar.axK instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean We() {
        for (a aVar : this.btc) {
            if (aVar != null && (aVar.axK instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.btd = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.btc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.axK.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.btd = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.btc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.axK.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean Wf() {
        boolean z;
        Iterator<a> it = this.btc.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.axK instanceof h) && next.btd == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.baidu.swan.pms.model.e axK;
        private PMSPkgStatus btd;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.axK = eVar;
            this.btd = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.axK.equals(((a) obj).axK);
        }

        public int hashCode() {
            return Objects.hash(this.axK);
        }
    }
}
