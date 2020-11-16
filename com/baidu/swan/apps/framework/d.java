package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d implements b {
    private List<b> cTx = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.cTx.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.cTx.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void atQ() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                bVar.atQ();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void atR() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                bVar.atR();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aiY() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                bVar.aiY();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void akq() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                bVar.akq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ams() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                bVar.ams();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aiX() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                bVar.aiX();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cTx == null || this.cTx.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.cTx) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aiZ() {
        if (this.cTx != null && this.cTx.size() > 0) {
            for (b bVar : this.cTx) {
                if (bVar != null) {
                    bVar.aiZ();
                }
            }
        }
    }
}
