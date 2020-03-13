package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> bvM = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bvM.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bvM.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sq() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                bVar.Sq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sr() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                bVar.Sr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityResumed() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityPaused() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Ss() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                bVar.Ss();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JK() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                bVar.JK();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvM == null || this.bvM.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bvM) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JL() {
        if (this.bvM != null && this.bvM.size() > 0) {
            for (b bVar : this.bvM) {
                if (bVar != null) {
                    bVar.JL();
                }
            }
        }
    }
}
