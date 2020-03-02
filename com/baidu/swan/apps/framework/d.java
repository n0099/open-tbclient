package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> bvL = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bvL.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bvL.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sq() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                bVar.Sq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sr() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                bVar.Sr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityResumed() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityPaused() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Ss() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                bVar.Ss();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JK() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                bVar.JK();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvL == null || this.bvL.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bvL) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JL() {
        if (this.bvL != null && this.bvL.size() > 0) {
            for (b bVar : this.bvL) {
                if (bVar != null) {
                    bVar.JL();
                }
            }
        }
    }
}
