package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d implements b {
    private List<b> clo = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.clo.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.clo.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afA() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                bVar.afA();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afB() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                bVar.afB();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void VL() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                bVar.VL();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Xe() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                bVar.Xe();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Zc() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                bVar.Zc();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void VK() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                bVar.VK();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.clo == null || this.clo.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.clo) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void VM() {
        if (this.clo != null && this.clo.size() > 0) {
            for (b bVar : this.clo) {
                if (bVar != null) {
                    bVar.VM();
                }
            }
        }
    }
}
