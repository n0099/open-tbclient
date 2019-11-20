package com.baidu.swan.apps.performance.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {
    private static volatile d bap;
    private HashMap<String, e> baq;
    private HashMap<String, e> bar;
    private HashMap<String, e> bas;

    private d() {
        NS();
    }

    public static d NR() {
        if (bap == null) {
            synchronized (d.class) {
                if (bap == null) {
                    bap = new d();
                }
            }
        }
        return bap;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (bap != null) {
                bap.release();
                bap = null;
            }
        }
    }

    private void release() {
        if (this.baq != null) {
            this.baq.clear();
        }
        if (this.bar != null) {
            this.bar.clear();
        }
        if (this.bas != null) {
            this.bas.clear();
        }
    }

    public void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            NS();
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

    private void NS() {
        if (this.baq == null) {
            this.baq = new HashMap<>();
        }
        if (this.bar == null) {
            this.bar = new HashMap<>();
        }
        if (this.bas == null) {
            this.bas = new HashMap<>();
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
                    eVar = this.baq.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.baq.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.bar.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.bar.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.bas.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.bas.put(str, eVar);
                        break;
                    }
                    break;
            }
            if (eVar != null) {
                eVar.af(j);
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
                    eVar = this.baq.remove(str);
                    break;
                case 1:
                    eVar = this.bar.remove(str);
                    break;
                case 2:
                    eVar = this.bas.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.ag(j);
                n(eVar.getType(), eVar.NQ());
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
                    com.baidu.swan.apps.ak.e.bsf.I(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.ak.e.bsg.I(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.ak.e.bsh.I(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
