package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class d {
    private static volatile d drV;
    private HashMap<String, e> drW;
    private HashMap<String, e> drX;
    private HashMap<String, e> drY;

    private d() {
        aEK();
    }

    public static d aEJ() {
        if (drV == null) {
            synchronized (d.class) {
                if (drV == null) {
                    drV = new d();
                }
            }
        }
        return drV;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (drV != null) {
                drV.release();
                drV = null;
            }
        }
    }

    private void release() {
        if (this.drW != null) {
            this.drW.clear();
        }
        if (this.drX != null) {
            this.drX.clear();
        }
        if (this.drY != null) {
            this.drY.clear();
        }
    }

    public void f(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aEK();
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
                    g(str, str2, j);
                    return;
                case 3:
                case 4:
                case 5:
                    h(str, str2, j);
                    return;
                default:
                    return;
            }
        }
    }

    private void aEK() {
        if (this.drW == null) {
            this.drW = new HashMap<>();
        }
        if (this.drX == null) {
            this.drX = new HashMap<>();
        }
        if (this.drY == null) {
            this.drY = new HashMap<>();
        }
    }

    private void g(String str, String str2, long j) {
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
                    eVar = this.drW.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.drW.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.drX.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.drX.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.drY.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.drY.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.setStart(j);
            }
        }
    }

    private void h(String str, String str2, long j) {
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
                    eVar = this.drW.remove(str);
                    break;
                case 1:
                    eVar = this.drX.remove(str);
                    break;
                case 2:
                    eVar = this.drY.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                q(eVar.getType(), eVar.aqu());
            }
        }
    }

    private void q(String str, long j) {
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
                    com.baidu.swan.apps.al.e.dOa.ab(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.al.e.dOb.ab(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.al.e.dOc.ab(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
