package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class d {
    private static volatile d dpK;
    private HashMap<String, e> dpL;
    private HashMap<String, e> dpM;
    private HashMap<String, e> dpN;

    private d() {
        aEp();
    }

    public static d aEo() {
        if (dpK == null) {
            synchronized (d.class) {
                if (dpK == null) {
                    dpK = new d();
                }
            }
        }
        return dpK;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (dpK != null) {
                dpK.release();
                dpK = null;
            }
        }
    }

    private void release() {
        if (this.dpL != null) {
            this.dpL.clear();
        }
        if (this.dpM != null) {
            this.dpM.clear();
        }
        if (this.dpN != null) {
            this.dpN.clear();
        }
    }

    public void e(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aEp();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1880922749:
                    if (str2.equals("pageUpdateEnd")) {
                        c = 5;
                        break;
                    }
                    break;
                case -964566145:
                    if (str2.equals("pageSwitchStart")) {
                        c = 0;
                        break;
                    }
                    break;
                case -410083667:
                    if (str2.equals("pageInitRenderStart")) {
                        c = 1;
                        break;
                    }
                    break;
                case 4028902:
                    if (str2.equals("pageInitRenderEnd")) {
                        c = 4;
                        break;
                    }
                    break;
                case 627578634:
                    if (str2.equals("pageUpdateStart")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1719651128:
                    if (str2.equals("pageSwitchEnd")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    f(str, str2, j);
                    return;
                case 3:
                case 4:
                case 5:
                    g(str, str2, j);
                    return;
                default:
                    return;
            }
        }
    }

    private void aEp() {
        if (this.dpL == null) {
            this.dpL = new HashMap<>();
        }
        if (this.dpM == null) {
            this.dpM = new HashMap<>();
        }
        if (this.dpN == null) {
            this.dpN = new HashMap<>();
        }
    }

    private void f(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            e eVar = null;
            char c = 65535;
            switch (str2.hashCode()) {
                case -964566145:
                    if (str2.equals("pageSwitchStart")) {
                        c = 0;
                        break;
                    }
                    break;
                case -410083667:
                    if (str2.equals("pageInitRenderStart")) {
                        c = 1;
                        break;
                    }
                    break;
                case 627578634:
                    if (str2.equals("pageUpdateStart")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    eVar = this.dpL.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.dpL.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.dpM.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.dpM.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.dpN.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.dpN.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.setStart(j);
            }
        }
    }

    private void g(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            e eVar = null;
            char c = 65535;
            switch (str2.hashCode()) {
                case -1880922749:
                    if (str2.equals("pageUpdateEnd")) {
                        c = 2;
                        break;
                    }
                    break;
                case 4028902:
                    if (str2.equals("pageInitRenderEnd")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1719651128:
                    if (str2.equals("pageSwitchEnd")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    eVar = this.dpL.remove(str);
                    break;
                case 1:
                    eVar = this.dpM.remove(str);
                    break;
                case 2:
                    eVar = this.dpN.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                r(eVar.getType(), eVar.apW());
            }
        }
    }

    private void r(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            char c = 65535;
            switch (str.hashCode()) {
                case 767526192:
                    if (str.equals("PageSwitchCost")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1331686101:
                    if (str.equals("PageInitRender")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1390184462:
                    if (str.equals("PageUpdateRender")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    com.baidu.swan.apps.al.e.dLW.ab(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.al.e.dLX.ab(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.al.e.dLY.ab(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
