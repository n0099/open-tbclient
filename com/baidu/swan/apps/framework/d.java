package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class d implements b {
    private List<b> csF = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.csF.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.csF.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amH() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                bVar.amH();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amI() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                bVar.amI();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void abR() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                bVar.abR();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void adk() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                bVar.adk();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void afl() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                bVar.afl();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void abQ() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                bVar.abQ();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.csF == null || this.csF.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.csF) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void abS() {
        if (this.csF != null && this.csF.size() > 0) {
            for (b bVar : this.csF) {
                if (bVar != null) {
                    bVar.abS();
                }
            }
        }
    }
}
