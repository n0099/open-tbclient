package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class d implements b {
    private List<b> csB = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.csB.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.csB.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amH() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                bVar.amH();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amI() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                bVar.amI();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void abR() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                bVar.abR();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void adk() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                bVar.adk();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afl() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                bVar.afl();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void abQ() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                bVar.abQ();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.csB == null || this.csB.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.csB) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void abS() {
        if (this.csB != null && this.csB.size() > 0) {
            for (b bVar : this.csB) {
                if (bVar != null) {
                    bVar.abS();
                }
            }
        }
    }
}
