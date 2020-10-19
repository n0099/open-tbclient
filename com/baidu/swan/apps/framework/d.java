package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class d implements b {
    private List<b> cGS = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.cGS.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.cGS.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aqd() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                bVar.aqd();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aqe() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                bVar.aqe();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afm() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                bVar.afm();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void agE() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                bVar.agE();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aiG() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                bVar.aiG();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afl() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                bVar.afl();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cGS == null || this.cGS.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.cGS) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afn() {
        if (this.cGS != null && this.cGS.size() > 0) {
            for (b bVar : this.cGS) {
                if (bVar != null) {
                    bVar.afn();
                }
            }
        }
    }
}
