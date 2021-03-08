package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class d {
    private static volatile d dty;
    private HashMap<String, e> dtA;
    private HashMap<String, e> dtB;
    private HashMap<String, e> dtz;

    private d() {
        aEN();
    }

    public static d aEM() {
        if (dty == null) {
            synchronized (d.class) {
                if (dty == null) {
                    dty = new d();
                }
            }
        }
        return dty;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (dty != null) {
                dty.release();
                dty = null;
            }
        }
    }

    private void release() {
        if (this.dtz != null) {
            this.dtz.clear();
        }
        if (this.dtA != null) {
            this.dtA.clear();
        }
        if (this.dtB != null) {
            this.dtB.clear();
        }
    }

    public void f(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aEN();
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

    private void aEN() {
        if (this.dtz == null) {
            this.dtz = new HashMap<>();
        }
        if (this.dtA == null) {
            this.dtA = new HashMap<>();
        }
        if (this.dtB == null) {
            this.dtB = new HashMap<>();
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
                    eVar = this.dtz.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.dtz.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.dtA.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.dtA.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.dtB.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.dtB.put(str, eVar);
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
                    eVar = this.dtz.remove(str);
                    break;
                case 1:
                    eVar = this.dtA.remove(str);
                    break;
                case 2:
                    eVar = this.dtB.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                q(eVar.getType(), eVar.aqx());
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
                    com.baidu.swan.apps.al.e.dPB.ad(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.al.e.dPC.ad(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.al.e.dPD.ad(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
