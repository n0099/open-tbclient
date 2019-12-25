package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class d implements b {
    private List<b> bqM = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bqM.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bqM.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void PE() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                bVar.PE();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void PF() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                bVar.PF();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityResumed() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void onActivityPaused() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void PG() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                bVar.PG();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void GX() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                bVar.GX();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bqM == null || this.bqM.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bqM) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void GY() {
        if (this.bqM != null && this.bqM.size() > 0) {
            for (b bVar : this.bqM) {
                if (bVar != null) {
                    bVar.GY();
                }
            }
        }
    }
}
