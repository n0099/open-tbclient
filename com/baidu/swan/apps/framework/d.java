package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> bUk = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.bUk.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.bUk.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aah() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                bVar.aah();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aai() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                bVar.aai();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Rz() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                bVar.Rz();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void SG() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                bVar.SG();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aaj() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                bVar.aaj();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Ry() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                bVar.Ry();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bUk == null || this.bUk.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.bUk) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void RA() {
        if (this.bUk != null && this.bUk.size() > 0) {
            for (b bVar : this.bUk) {
                if (bVar != null) {
                    bVar.RA();
                }
            }
        }
    }
}
