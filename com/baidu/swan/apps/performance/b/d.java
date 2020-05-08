package com.baidu.swan.apps.performance.b;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class d {
    private static volatile d cgU;
    private HashMap<String, e> cgV;
    private HashMap<String, e> cgW;
    private HashMap<String, e> cgX;

    private d() {
        aij();
    }

    public static d aii() {
        if (cgU == null) {
            synchronized (d.class) {
                if (cgU == null) {
                    cgU = new d();
                }
            }
        }
        return cgU;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cgU != null) {
                cgU.release();
                cgU = null;
            }
        }
    }

    private void release() {
        if (this.cgV != null) {
            this.cgV.clear();
        }
        if (this.cgW != null) {
            this.cgW.clear();
        }
        if (this.cgX != null) {
            this.cgX.clear();
        }
    }

    public void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aij();
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

    private void aij() {
        if (this.cgV == null) {
            this.cgV = new HashMap<>();
        }
        if (this.cgW == null) {
            this.cgW = new HashMap<>();
        }
        if (this.cgX == null) {
            this.cgX = new HashMap<>();
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
                    eVar = this.cgV.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cgV.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cgW.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cgW.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cgX.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cgX.put(str, eVar);
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
                    eVar = this.cgV.remove(str);
                    break;
                case 1:
                    eVar = this.cgW.remove(str);
                    break;
                case 2:
                    eVar = this.cgX.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                m(eVar.getType(), eVar.aih());
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
                    com.baidu.swan.apps.ap.e.cwW.Q(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ap.e.cwX.Q(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ap.e.cwY.Q(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
