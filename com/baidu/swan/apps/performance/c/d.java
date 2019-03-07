package com.baidu.swan.apps.performance.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    private static volatile d aEq;
    private HashMap<String, e> aEr;
    private HashMap<String, e> aEs;
    private HashMap<String, e> aEt;

    private d() {
        Ga();
    }

    public static d FZ() {
        if (aEq == null) {
            synchronized (d.class) {
                if (aEq == null) {
                    aEq = new d();
                }
            }
        }
        return aEq;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (aEq != null) {
                aEq.release();
                aEq = null;
            }
        }
    }

    private void release() {
        if (this.aEr != null) {
            this.aEr.clear();
        }
        if (this.aEs != null) {
            this.aEs.clear();
        }
        if (this.aEt != null) {
            this.aEt.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            Ga();
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

    private void Ga() {
        if (this.aEr == null) {
            this.aEr = new HashMap<>();
        }
        if (this.aEs == null) {
            this.aEs = new HashMap<>();
        }
        if (this.aEt == null) {
            this.aEt = new HashMap<>();
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
                    eVar = this.aEr.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.aEr.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.aEs.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.aEs.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.aEt.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.aEt.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.B(j);
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
                    eVar = this.aEr.remove(str);
                    break;
                case 1:
                    eVar = this.aEs.remove(str);
                    break;
                case 2:
                    eVar = this.aEt.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.C(j);
                j(eVar.getType(), eVar.FY());
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
                    com.baidu.swan.apps.ak.e.aVK.K(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ak.e.aVL.K(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ak.e.aVM.K(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
