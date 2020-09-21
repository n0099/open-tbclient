package com.baidu.swan.apps.performance.e;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class d {
    private static volatile d cJJ;
    private HashMap<String, e> cJK;
    private HashMap<String, e> cJL;
    private HashMap<String, e> cJM;

    private d() {
        axk();
    }

    public static d axj() {
        if (cJJ == null) {
            synchronized (d.class) {
                if (cJJ == null) {
                    cJJ = new d();
                }
            }
        }
        return cJJ;
    }

    public static synchronized void releaseInstance() {
        synchronized (d.class) {
            if (cJJ != null) {
                cJJ.release();
                cJJ = null;
            }
        }
    }

    private void release() {
        if (this.cJK != null) {
            this.cJK.clear();
        }
        if (this.cJL != null) {
            this.cJL.clear();
        }
        if (this.cJM != null) {
            this.cJM.clear();
        }
    }

    public void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            axk();
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

    private void axk() {
        if (this.cJK == null) {
            this.cJK = new HashMap<>();
        }
        if (this.cJL == null) {
            this.cJL = new HashMap<>();
        }
        if (this.cJM == null) {
            this.cJM = new HashMap<>();
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
                    eVar = this.cJK.get(str);
                    if (eVar == null) {
                        eVar = new b();
                        this.cJK.put(str, eVar);
                        break;
                    }
                    break;
                case 1:
                    eVar = this.cJL.get(str);
                    if (eVar == null) {
                        eVar = new a();
                        this.cJL.put(str, eVar);
                        break;
                    }
                    break;
                case 2:
                    eVar = this.cJM.get(str);
                    if (eVar == null) {
                        eVar = new c();
                        this.cJM.put(str, eVar);
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
                    eVar = this.cJK.remove(str);
                    break;
                case 1:
                    eVar = this.cJL.remove(str);
                    break;
                case 2:
                    eVar = this.cJM.remove(str);
                    break;
            }
            if (eVar != null) {
                eVar.setEnd(j);
                p(eVar.getType(), eVar.aiT());
            }
        }
    }

    private void p(String str, long j) {
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
                    com.baidu.swan.apps.am.e.dck.X(Long.valueOf(j));
                    return;
                case 1:
                    com.baidu.swan.apps.am.e.dcl.X(Long.valueOf(j));
                    return;
                case 2:
                    com.baidu.swan.apps.am.e.dcm.X(Long.valueOf(j));
                    return;
                default:
                    return;
            }
        }
    }
}
