package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class d implements b {
    private List<b> cuL = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.cuL.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.cuL.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void anr() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                bVar.anr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ans() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                bVar.ans();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void acA() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                bVar.acA();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void adT() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                bVar.adT();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afV() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                bVar.afV();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void acz() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                bVar.acz();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cuL == null || this.cuL.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.cuL) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void acB() {
        if (this.cuL != null && this.cuL.size() > 0) {
            for (b bVar : this.cuL) {
                if (bVar != null) {
                    bVar.acB();
                }
            }
        }
    }
}
