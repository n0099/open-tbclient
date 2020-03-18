package com.baidu.swan.apps.performance.b;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class d {
    private static volatile d bIf;
    private HashMap<String, e> bIg;
    private HashMap<String, e> bIh;
    private HashMap<String, e> bIi;

    private d() {
        aaf();
    }

    public static d aae() {
        if (bIf == null) {
            synchronized (d.class) {
                if (bIf == null) {
                    bIf = new d();
                }
            }
        }
        return bIf;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (bIf != null) {
                bIf.release();
                bIf = null;
            }
        }
    }

    private void release() {
        if (this.bIg != null) {
            this.bIg.clear();
        }
        if (this.bIh != null) {
            this.bIh.clear();
        }
        if (this.bIi != null) {
            this.bIi.clear();
        }
    }

    public void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aaf();
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

    private void aaf() {
        if (this.bIg == null) {
            this.bIg = new HashMap<>();
        }
        if (this.bIh == null) {
            this.bIh = new HashMap<>();
        }
        if (this.bIi == null) {
            this.bIi = new HashMap<>();
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
                    eVar = this.bIg.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.bIg.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.bIh.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.bIh.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.bIi.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.bIi.put(str, eVar);
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
                    eVar = this.bIg.remove(str);
                    break;
                case 1:
                    eVar = this.bIh.remove(str);
                    break;
                case 2:
                    eVar = this.bIi.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                l(eVar.getType(), eVar.aad());
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
                    com.baidu.swan.apps.ap.e.bXY.O(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ap.e.bXZ.O(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ap.e.bYa.O(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
