package com.baidu.swan.apps.performance.b;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class d {
    private static volatile d cgO;
    private HashMap<String, e> cgP;
    private HashMap<String, e> cgQ;
    private HashMap<String, e> cgR;

    private d() {
        aik();
    }

    public static d aij() {
        if (cgO == null) {
            synchronized (d.class) {
                if (cgO == null) {
                    cgO = new d();
                }
            }
        }
        return cgO;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cgO != null) {
                cgO.release();
                cgO = null;
            }
        }
    }

    private void release() {
        if (this.cgP != null) {
            this.cgP.clear();
        }
        if (this.cgQ != null) {
            this.cgQ.clear();
        }
        if (this.cgR != null) {
            this.cgR.clear();
        }
    }

    public void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aik();
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
                    c(str, str2, j);
                    return;
                case 3:
                case 4:
                case 5:
                    d(str, str2, j);
                    return;
                default:
                    return;
            }
        }
    }

    private void aik() {
        if (this.cgP == null) {
            this.cgP = new HashMap<>();
        }
        if (this.cgQ == null) {
            this.cgQ = new HashMap<>();
        }
        if (this.cgR == null) {
            this.cgR = new HashMap<>();
        }
    }

    private void c(String str, String str2, long j) {
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
                    eVar = this.cgP.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cgP.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cgQ.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cgQ.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cgR.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cgR.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.setStart(j);
            }
        }
    }

    private void d(String str, String str2, long j) {
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
                    eVar = this.cgP.remove(str);
                    break;
                case 1:
                    eVar = this.cgQ.remove(str);
                    break;
                case 2:
                    eVar = this.cgR.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                m(eVar.getType(), eVar.aii());
            }
        }
    }

    private void m(String str, long j) {
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
                    com.baidu.swan.apps.ap.e.cwQ.P(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ap.e.cwR.P(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ap.e.cwS.P(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
