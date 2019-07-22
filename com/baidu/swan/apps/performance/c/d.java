package com.baidu.swan.apps.performance.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    private static volatile d aGV;
    private HashMap<String, e> aGW;
    private HashMap<String, e> aGX;
    private HashMap<String, e> aGY;

    private d() {
        IT();
    }

    public static d IS() {
        if (aGV == null) {
            synchronized (d.class) {
                if (aGV == null) {
                    aGV = new d();
                }
            }
        }
        return aGV;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (aGV != null) {
                aGV.release();
                aGV = null;
            }
        }
    }

    private void release() {
        if (this.aGW != null) {
            this.aGW.clear();
        }
        if (this.aGX != null) {
            this.aGX.clear();
        }
        if (this.aGY != null) {
            this.aGY.clear();
        }
    }

    public void e(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            IT();
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

    private void IT() {
        if (this.aGW == null) {
            this.aGW = new HashMap<>();
        }
        if (this.aGX == null) {
            this.aGX = new HashMap<>();
        }
        if (this.aGY == null) {
            this.aGY = new HashMap<>();
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
                    eVar = this.aGW.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.aGW.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.aGX.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.aGX.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.aGY.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.aGY.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.N(j);
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
                    eVar = this.aGW.remove(str);
                    break;
                case 1:
                    eVar = this.aGX.remove(str);
                    break;
                case 2:
                    eVar = this.aGY.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.O(j);
                j(eVar.getType(), eVar.IR());
            }
        }
    }

    private void j(String str, long j) {
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
                    com.baidu.swan.apps.ak.e.aZz.K(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ak.e.aZA.K(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ak.e.aZB.K(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
