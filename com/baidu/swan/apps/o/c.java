package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> avU = new ArrayList();

    public synchronized void c(@NonNull b bVar) {
        this.avU.add(bVar);
    }

    public synchronized void d(@NonNull b bVar) {
        this.avU.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void BE() {
        if (this.avU != null && this.avU.size() > 0) {
            for (b bVar : this.avU) {
                bVar.BE();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BF() {
        if (this.avU != null && this.avU.size() > 0) {
            for (b bVar : this.avU) {
                bVar.BF();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.avU != null && this.avU.size() > 0) {
            for (b bVar : this.avU) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.avU != null && this.avU.size() > 0) {
            for (b bVar : this.avU) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BG() {
        if (this.avU != null && this.avU.size() > 0) {
            for (b bVar : this.avU) {
                bVar.BG();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BH() {
        if (this.avU != null && this.avU.size() > 0) {
            for (b bVar : this.avU) {
                bVar.BH();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.avU == null || this.avU.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.avU) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
