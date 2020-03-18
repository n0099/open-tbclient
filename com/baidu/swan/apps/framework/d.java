package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> bvY = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bvY.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bvY.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void St() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                bVar.St();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Su() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                bVar.Su();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityResumed() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityPaused() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Sv() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                bVar.Sv();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JN() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                bVar.JN();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvY == null || this.bvY.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bvY) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void JO() {
        if (this.bvY != null && this.bvY.size() > 0) {
            for (b bVar : this.bvY) {
                if (bVar != null) {
                    bVar.JO();
                }
            }
        }
    }
}
