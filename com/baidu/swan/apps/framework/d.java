package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class d implements b {
    private List<b> brA = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.brA.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.brA.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Qa() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                bVar.Qa();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Qb() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                bVar.Qb();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityResumed() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityPaused() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Qc() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                bVar.Qc();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Ht() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                bVar.Ht();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.brA == null || this.brA.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.brA) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Hu() {
        if (this.brA != null && this.brA.size() > 0) {
            for (b bVar : this.brA) {
                if (bVar != null) {
                    bVar.Hu();
                }
            }
        }
    }
}
