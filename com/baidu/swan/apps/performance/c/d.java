package com.baidu.swan.apps.performance.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    private static volatile d aEu;
    private HashMap<String, e> aEv;
    private HashMap<String, e> aEw;
    private HashMap<String, e> aEx;

    private d() {
        FY();
    }

    public static d FX() {
        if (aEu == null) {
            synchronized (d.class) {
                if (aEu == null) {
                    aEu = new d();
                }
            }
        }
        return aEu;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (aEu != null) {
                aEu.release();
                aEu = null;
            }
        }
    }

    private void release() {
        if (this.aEv != null) {
            this.aEv.clear();
        }
        if (this.aEw != null) {
            this.aEw.clear();
        }
        if (this.aEx != null) {
            this.aEx.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            FY();
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

    private void FY() {
        if (this.aEv == null) {
            this.aEv = new HashMap<>();
        }
        if (this.aEw == null) {
            this.aEw = new HashMap<>();
        }
        if (this.aEx == null) {
            this.aEx = new HashMap<>();
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
                    eVar = this.aEv.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.aEv.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.aEw.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.aEw.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.aEx.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.aEx.put(str, eVar);
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
                    eVar = this.aEv.remove(str);
                    break;
                case 1:
                    eVar = this.aEw.remove(str);
                    break;
                case 2:
                    eVar = this.aEx.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.C(j);
                j(eVar.getType(), eVar.FW());
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
                    com.baidu.swan.apps.ak.e.aVO.K(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ak.e.aVP.K(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ak.e.aVQ.K(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
