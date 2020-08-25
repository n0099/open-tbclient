package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class d {
    private static volatile d cHF;
    private HashMap<String, e> cHG;
    private HashMap<String, e> cHH;
    private HashMap<String, e> cHI;

    private d() {
        awB();
    }

    public static d awA() {
        if (cHF == null) {
            synchronized (d.class) {
                if (cHF == null) {
                    cHF = new d();
                }
            }
        }
        return cHF;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cHF != null) {
                cHF.release();
                cHF = null;
            }
        }
    }

    private void release() {
        if (this.cHG != null) {
            this.cHG.clear();
        }
        if (this.cHH != null) {
            this.cHH.clear();
        }
        if (this.cHI != null) {
            this.cHI.clear();
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
        if (this.cHG == null) {
            this.cHG = new HashMap<>();
        }
        if (this.cHH == null) {
            this.cHH = new HashMap<>();
        }
        if (this.cHI == null) {
            this.cHI = new HashMap<>();
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
                    eVar = this.cHG.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cHG.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cHH.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cHH.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cHI.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cHI.put(str, eVar);
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
                    eVar = this.cHG.remove(str);
                    break;
                case 1:
                    eVar = this.cHH.remove(str);
                    break;
                case 2:
                    eVar = this.cHI.remove(str);
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
                    com.baidu.swan.apps.am.e.dae.W(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.daf.W(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dag.W(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
