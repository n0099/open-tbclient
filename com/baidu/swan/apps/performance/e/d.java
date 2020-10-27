package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class d {
    private static volatile d dem;
    private HashMap<String, e> den;
    private HashMap<String, e> deo;
    private HashMap<String, e> dep;

    private d() {
        aBP();
    }

    public static d aBO() {
        if (dem == null) {
            synchronized (d.class) {
                if (dem == null) {
                    dem = new d();
                }
            }
        }
        return dem;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (dem != null) {
                dem.release();
                dem = null;
            }
        }
    }

    private void release() {
        if (this.den != null) {
            this.den.clear();
        }
        if (this.deo != null) {
            this.deo.clear();
        }
        if (this.dep != null) {
            this.dep.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aBP();
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

    private void aBP() {
        if (this.den == null) {
            this.den = new HashMap<>();
        }
        if (this.deo == null) {
            this.deo = new HashMap<>();
        }
        if (this.dep == null) {
            this.dep = new HashMap<>();
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
                    eVar = this.den.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.den.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.deo.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.deo.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.dep.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.dep.put(str, eVar);
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
                    eVar = this.den.remove(str);
                    break;
                case 1:
                    eVar = this.deo.remove(str);
                    break;
                case 2:
                    eVar = this.dep.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                r(eVar.getType(), eVar.any());
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
                    com.baidu.swan.apps.am.e.dwU.aa(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.dwV.aa(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dwW.aa(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
