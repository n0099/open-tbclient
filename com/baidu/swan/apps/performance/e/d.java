package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class d {
    private static volatile d cHJ;
    private HashMap<String, e> cHK;
    private HashMap<String, e> cHL;
    private HashMap<String, e> cHM;

    private d() {
        awB();
    }

    public static d awA() {
        if (cHJ == null) {
            synchronized (d.class) {
                if (cHJ == null) {
                    cHJ = new d();
                }
            }
        }
        return cHJ;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cHJ != null) {
                cHJ.release();
                cHJ = null;
            }
        }
    }

    private void release() {
        if (this.cHK != null) {
            this.cHK.clear();
        }
        if (this.cHL != null) {
            this.cHL.clear();
        }
        if (this.cHM != null) {
            this.cHM.clear();
        }
    }

    public void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            awB();
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
                    d(str, str2, j);
                    return;
                case 3:
                case 4:
                case 5:
                    e(str, str2, j);
                    return;
                default:
                    return;
            }
        }
    }

    private void awB() {
        if (this.cHK == null) {
            this.cHK = new HashMap<>();
        }
        if (this.cHL == null) {
            this.cHL = new HashMap<>();
        }
        if (this.cHM == null) {
            this.cHM = new HashMap<>();
        }
    }

    private void d(String str, String str2, long j) {
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
                    eVar = this.cHK.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cHK.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cHL.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cHL.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cHM.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cHM.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.setStart(j);
            }
        }
    }

    private void e(String str, String str2, long j) {
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
                    eVar = this.cHK.remove(str);
                    break;
                case 1:
                    eVar = this.cHL.remove(str);
                    break;
                case 2:
                    eVar = this.cHM.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                p(eVar.getType(), eVar.aij());
            }
        }
    }

    private void p(String str, long j) {
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
                    com.baidu.swan.apps.am.e.dai.W(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.daj.W(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dak.W(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
