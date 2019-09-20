package com.baidu.swan.apps.performance.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    private static volatile d aHt;
    private HashMap<String, e> aHu;
    private HashMap<String, e> aHv;
    private HashMap<String, e> aHw;

    private d() {
        IX();
    }

    public static d IW() {
        if (aHt == null) {
            synchronized (d.class) {
                if (aHt == null) {
                    aHt = new d();
                }
            }
        }
        return aHt;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (aHt != null) {
                aHt.release();
                aHt = null;
            }
        }
    }

    private void release() {
        if (this.aHu != null) {
            this.aHu.clear();
        }
        if (this.aHv != null) {
            this.aHv.clear();
        }
        if (this.aHw != null) {
            this.aHw.clear();
        }
    }

    public void e(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            IX();
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

    private void IX() {
        if (this.aHu == null) {
            this.aHu = new HashMap<>();
        }
        if (this.aHv == null) {
            this.aHv = new HashMap<>();
        }
        if (this.aHw == null) {
            this.aHw = new HashMap<>();
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
                    eVar = this.aHu.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.aHu.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.aHv.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.aHv.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.aHw.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.aHw.put(str, eVar);
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
                    eVar = this.aHu.remove(str);
                    break;
                case 1:
                    eVar = this.aHv.remove(str);
                    break;
                case 2:
                    eVar = this.aHw.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.O(j);
                l(eVar.getType(), eVar.IV());
            }
        }
    }

    private void l(String str, long j) {
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
                    com.baidu.swan.apps.ak.e.aZX.K(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ak.e.aZY.K(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ak.e.aZZ.K(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
