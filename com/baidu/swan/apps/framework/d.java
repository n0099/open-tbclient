package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class d implements b {
    private List<b> cPo = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.cPo.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.cPo.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void arX() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                bVar.arX();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void arY() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                bVar.arY();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ahg() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                bVar.ahg();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aiy() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                bVar.aiy();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void akA() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                bVar.akA();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ahf() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                bVar.ahf();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cPo == null || this.cPo.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.cPo) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ahh() {
        if (this.cPo != null && this.cPo.size() > 0) {
            for (b bVar : this.cPo) {
                if (bVar != null) {
                    bVar.ahh();
                }
            }
        }
    }
}
