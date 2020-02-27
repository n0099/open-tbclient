package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> bvK = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bvK.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bvK.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void So() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                bVar.So();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sp() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                bVar.Sp();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityResumed() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityPaused() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sq() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                bVar.Sq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JI() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                bVar.JI();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvK == null || this.bvK.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bvK) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JJ() {
        if (this.bvK != null && this.bvK.size() > 0) {
            for (b bVar : this.bvK) {
                if (bVar != null) {
                    bVar.JJ();
                }
            }
        }
    }
}
