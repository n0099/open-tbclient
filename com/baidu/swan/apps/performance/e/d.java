package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes25.dex */
public final class d {
    private static volatile d dpA;
    private HashMap<String, e> dpB;
    private HashMap<String, e> dpC;
    private HashMap<String, e> dpD;

    private d() {
        aGP();
    }

    public static d aGO() {
        if (dpA == null) {
            synchronized (d.class) {
                if (dpA == null) {
                    dpA = new d();
                }
            }
        }
        return dpA;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (dpA != null) {
                dpA.release();
                dpA = null;
            }
        }
    }

    private void release() {
        if (this.dpB != null) {
            this.dpB.clear();
        }
        if (this.dpC != null) {
            this.dpC.clear();
        }
        if (this.dpD != null) {
            this.dpD.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aGP();
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
                    e(str, str2, j);
                    return;
                case 3:
                case 4:
                case 5:
                    f(str, str2, j);
                    return;
                default:
                    return;
            }
        }
    }

    private void aGP() {
        if (this.dpB == null) {
            this.dpB = new HashMap<>();
        }
        if (this.dpC == null) {
            this.dpC = new HashMap<>();
        }
        if (this.dpD == null) {
            this.dpD = new HashMap<>();
        }
    }

    private void e(String str, String str2, long j) {
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
                    eVar = this.dpB.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.dpB.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.dpC.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.dpC.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.dpD.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.dpD.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.setStart(j);
            }
        }
    }

    private void f(String str, String str2, long j) {
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
                    eVar = this.dpB.remove(str);
                    break;
                case 1:
                    eVar = this.dpC.remove(str);
                    break;
                case 2:
                    eVar = this.dpD.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                r(eVar.getType(), eVar.asz());
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
                    com.baidu.swan.apps.am.e.dId.aa(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.dIe.aa(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dIf.aa(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
