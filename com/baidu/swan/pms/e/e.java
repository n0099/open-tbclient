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
    private Set<a> btS = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.btS.add(new a(eVar, pMSPkgStatus));
    }

    public int WU() {
        return this.btS.size();
    }

    public boolean isEmpty() {
        return this.btS.isEmpty();
    }

    public boolean WV() {
        for (a aVar : this.btS) {
            if (aVar != null && (aVar.ayr instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean WW() {
        for (a aVar : this.btS) {
            if (aVar != null && (aVar.ayr instanceof h)) {
                return true;
            }
        }
        return false;
    }

    public boolean WX() {
        for (a aVar : this.btS) {
            if (aVar != null && (aVar.ayr instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean WY() {
        for (a aVar : this.btS) {
            if (aVar != null && (aVar.ayr instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.btT = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.btS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.ayr.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.btT = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.btS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.ayr.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean WZ() {
        boolean z;
        Iterator<a> it = this.btS.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.ayr instanceof h) && next.btT == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.baidu.swan.pms.model.e ayr;
        private PMSPkgStatus btT;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.ayr = eVar;
            this.btT = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.ayr.equals(((a) obj).ayr);
        }

        public int hashCode() {
            return Objects.hash(this.ayr);
        }
    }
}
