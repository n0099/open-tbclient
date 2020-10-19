package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class d {
    private static volatile d cVM;
    private HashMap<String, e> cVN;
    private HashMap<String, e> cVO;
    private HashMap<String, e> cVP;

    private d() {
        azV();
    }

    public static d azU() {
        if (cVM == null) {
            synchronized (d.class) {
                if (cVM == null) {
                    cVM = new d();
                }
            }
        }
        return cVM;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cVM != null) {
                cVM.release();
                cVM = null;
            }
        }
    }

    private void release() {
        if (this.cVN != null) {
            this.cVN.clear();
        }
        if (this.cVO != null) {
            this.cVO.clear();
        }
        if (this.cVP != null) {
            this.cVP.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            azV();
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

    private void azV() {
        if (this.cVN == null) {
            this.cVN = new HashMap<>();
        }
        if (this.cVO == null) {
            this.cVO = new HashMap<>();
        }
        if (this.cVP == null) {
            this.cVP = new HashMap<>();
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
                    eVar = this.cVN.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cVN.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cVO.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cVO.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cVP.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cVP.put(str, eVar);
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
                    eVar = this.cVN.remove(str);
                    break;
                case 1:
                    eVar = this.cVO.remove(str);
                    break;
                case 2:
                    eVar = this.cVP.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                p(eVar.getType(), eVar.alE());
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
                    com.baidu.swan.apps.am.e.dou.aa(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.dov.aa(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dow.aa(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
