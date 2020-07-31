package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class d {
    private static volatile d czw;
    private HashMap<String, e> czx;
    private HashMap<String, e> czy;
    private HashMap<String, e> czz;

    private d() {
        aoB();
    }

    public static d aoA() {
        if (czw == null) {
            synchronized (d.class) {
                if (czw == null) {
                    czw = new d();
                }
            }
        }
        return czw;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (czw != null) {
                czw.release();
                czw = null;
            }
        }
    }

    private void release() {
        if (this.czx != null) {
            this.czx.clear();
        }
        if (this.czy != null) {
            this.czy.clear();
        }
        if (this.czz != null) {
            this.czz.clear();
        }
    }

    public void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            aoB();
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

    private void aoB() {
        if (this.czx == null) {
            this.czx = new HashMap<>();
        }
        if (this.czy == null) {
            this.czy = new HashMap<>();
        }
        if (this.czz == null) {
            this.czz = new HashMap<>();
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
                    eVar = this.czx.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.czx.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.czy.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.czy.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.czz.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.czz.put(str, eVar);
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
                    eVar = this.czx.remove(str);
                    break;
                case 1:
                    eVar = this.czy.remove(str);
                    break;
                case 2:
                    eVar = this.czz.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                m(eVar.getType(), eVar.aog());
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
                    com.baidu.swan.apps.an.e.cRe.T(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.an.e.cRf.T(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.an.e.cRg.T(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
