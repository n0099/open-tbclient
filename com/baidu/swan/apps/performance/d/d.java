package com.baidu.swan.apps.performance.d;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class d {
    private static volatile d cwX;
    private HashMap<String, e> cwY;
    private HashMap<String, e> cwZ;
    private HashMap<String, e> cxa;

    private d() {
        amT();
    }

    public static d amS() {
        if (cwX == null) {
            synchronized (d.class) {
                if (cwX == null) {
                    cwX = new d();
                }
            }
        }
        return cwX;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cwX != null) {
                cwX.release();
                cwX = null;
            }
        }
    }

    private void release() {
        if (this.cwY != null) {
            this.cwY.clear();
        }
        if (this.cwZ != null) {
            this.cwZ.clear();
        }
        if (this.cxa != null) {
            this.cxa.clear();
        }
    }

    public void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            amT();
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

    private void amT() {
        if (this.cwY == null) {
            this.cwY = new HashMap<>();
        }
        if (this.cwZ == null) {
            this.cwZ = new HashMap<>();
        }
        if (this.cxa == null) {
            this.cxa = new HashMap<>();
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
                    eVar = this.cwY.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cwY.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cwZ.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cwZ.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cxa.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cxa.put(str, eVar);
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
                    eVar = this.cwY.remove(str);
                    break;
                case 1:
                    eVar = this.cwZ.remove(str);
                    break;
                case 2:
                    eVar = this.cxa.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                l(eVar.getType(), eVar.amM());
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
                    com.baidu.swan.apps.an.e.cNJ.T(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.an.e.cNK.T(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.an.e.cNL.T(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
