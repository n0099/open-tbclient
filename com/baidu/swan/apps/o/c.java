package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> avT = new ArrayList();

    public synchronized void c(@NonNull b bVar) {
        this.avT.add(bVar);
    }

    public synchronized void d(@NonNull b bVar) {
        this.avT.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void BE() {
        if (this.avT != null && this.avT.size() > 0) {
            for (b bVar : this.avT) {
                bVar.BE();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BF() {
        if (this.avT != null && this.avT.size() > 0) {
            for (b bVar : this.avT) {
                bVar.BF();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.avT != null && this.avT.size() > 0) {
            for (b bVar : this.avT) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.avT != null && this.avT.size() > 0) {
            for (b bVar : this.avT) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BG() {
        if (this.avT != null && this.avT.size() > 0) {
            for (b bVar : this.avT) {
                bVar.BG();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BH() {
        if (this.avT != null && this.avT.size() > 0) {
            for (b bVar : this.avT) {
                bVar.BH();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.avT == null || this.avT.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.avT) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
