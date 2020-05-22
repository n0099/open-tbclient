package com.baidu.swan.apps.performance.d;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class d {
    private static volatile d csj;
    private HashMap<String, e> csk;
    private HashMap<String, e> csl;
    private HashMap<String, e> csm;

    private d() {
        alN();
    }

    public static d alM() {
        if (csj == null) {
            synchronized (d.class) {
                if (csj == null) {
                    csj = new d();
                }
            }
        }
        return csj;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (csj != null) {
                csj.release();
                csj = null;
            }
        }
    }

    private void release() {
        if (this.csk != null) {
            this.csk.clear();
        }
        if (this.csl != null) {
            this.csl.clear();
        }
        if (this.csm != null) {
            this.csm.clear();
        }
    }

    public void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            alN();
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

    private void alN() {
        if (this.csk == null) {
            this.csk = new HashMap<>();
        }
        if (this.csl == null) {
            this.csl = new HashMap<>();
        }
        if (this.csm == null) {
            this.csm = new HashMap<>();
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
                    eVar = this.csk.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.csk.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.csl.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.csl.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.csm.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.csm.put(str, eVar);
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
                    eVar = this.csk.remove(str);
                    break;
                case 1:
                    eVar = this.csl.remove(str);
                    break;
                case 2:
                    eVar = this.csm.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                l(eVar.getType(), eVar.alG());
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
                    com.baidu.swan.apps.an.e.cIZ.T(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.an.e.cJa.T(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.an.e.cJb.T(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
