package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> bUe = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bUe.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bUe.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aai() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                bVar.aai();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aaj() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                bVar.aaj();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void RA() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                bVar.RA();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void SH() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                bVar.SH();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aak() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                bVar.aak();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Rz() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                bVar.Rz();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bUe == null || this.bUe.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bUe) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void RB() {
        if (this.bUe != null && this.bUe.size() > 0) {
            for (b bVar : this.bUe) {
                if (bVar != null) {
                    bVar.RB();
                }
            }
        }
    }
}
