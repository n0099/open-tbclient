package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class d {
    private static volatile d diB;
    private HashMap<String, e> diC;
    private HashMap<String, e> diD;
    private HashMap<String, e> diE;

    private d() {
        aDH();
    }

    public static d aDG() {
        if (diB == null) {
            synchronized (d.class) {
                if (diB == null) {
                    diB = new d();
                }
            }
        }
        return diB;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (diB != null) {
                diB.release();
                diB = null;
            }
        }
    }

    private void release() {
        if (this.diC != null) {
            this.diC.clear();
        }
        if (this.diD != null) {
            this.diD.clear();
        }
        if (this.diE != null) {
            this.diE.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aDH();
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

    private void aDH() {
        if (this.diC == null) {
            this.diC = new HashMap<>();
        }
        if (this.diD == null) {
            this.diD = new HashMap<>();
        }
        if (this.diE == null) {
            this.diE = new HashMap<>();
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
                    eVar = this.diC.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.diC.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.diD.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.diD.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.diE.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.diE.put(str, eVar);
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
                    eVar = this.diC.remove(str);
                    break;
                case 1:
                    eVar = this.diD.remove(str);
                    break;
                case 2:
                    eVar = this.diE.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                r(eVar.getType(), eVar.apr());
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
                    com.baidu.swan.apps.am.e.dBf.aa(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.dBg.aa(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dBh.aa(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
