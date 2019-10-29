package com.baidu.swan.apps.performance.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    private static volatile d baH;
    private HashMap<String, e> baI;
    private HashMap<String, e> baJ;
    private HashMap<String, e> baK;

    private d() {
        NR();
    }

    public static d NQ() {
        if (baH == null) {
            synchronized (d.class) {
                if (baH == null) {
                    baH = new d();
                }
            }
        }
        return baH;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (baH != null) {
                baH.release();
                baH = null;
            }
        }
    }

    private void release() {
        if (this.baI != null) {
            this.baI.clear();
        }
        if (this.baJ != null) {
            this.baJ.clear();
        }
        if (this.baK != null) {
            this.baK.clear();
        }
    }

    public void e(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            NR();
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

    private void NR() {
        if (this.baI == null) {
            this.baI = new HashMap<>();
        }
        if (this.baJ == null) {
            this.baJ = new HashMap<>();
        }
        if (this.baK == null) {
            this.baK = new HashMap<>();
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
                    eVar = this.baI.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.baI.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.baJ.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.baJ.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.baK.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.baK.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.ag(j);
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
                    eVar = this.baI.remove(str);
                    break;
                case 1:
                    eVar = this.baJ.remove(str);
                    break;
                case 2:
                    eVar = this.baK.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.ah(j);
                n(eVar.getType(), eVar.NP());
            }
        }
    }

    private void n(String str, long j) {
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
                    com.baidu.swan.apps.ak.e.bsW.I(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ak.e.bsX.I(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ak.e.bsY.I(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
