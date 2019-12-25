package com.baidu.swan.apps.performance.b;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class d {
    private static volatile d bDc;
    private HashMap<String, e> bDd;
    private HashMap<String, e> bDe;
    private HashMap<String, e> bDf;

    private d() {
        Xp();
    }

    public static d Xo() {
        if (bDc == null) {
            synchronized (d.class) {
                if (bDc == null) {
                    bDc = new d();
                }
            }
        }
        return bDc;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (bDc != null) {
                bDc.release();
                bDc = null;
            }
        }
    }

    private void release() {
        if (this.bDd != null) {
            this.bDd.clear();
        }
        if (this.bDe != null) {
            this.bDe.clear();
        }
        if (this.bDf != null) {
            this.bDf.clear();
        }
    }

    public void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            Xp();
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

    private void Xp() {
        if (this.bDd == null) {
            this.bDd = new HashMap<>();
        }
        if (this.bDe == null) {
            this.bDe = new HashMap<>();
        }
        if (this.bDf == null) {
            this.bDf = new HashMap<>();
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
                    eVar = this.bDd.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.bDd.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.bDe.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.bDe.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.bDf.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.bDf.put(str, eVar);
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
                    eVar = this.bDd.remove(str);
                    break;
                case 1:
                    eVar = this.bDe.remove(str);
                    break;
                case 2:
                    eVar = this.bDf.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                l(eVar.getType(), eVar.Xn());
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
                    com.baidu.swan.apps.ap.e.bTv.M(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ap.e.bTw.M(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ap.e.bTx.M(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
