package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> ceA = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.ceA.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.ceA.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void adh() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                bVar.adh();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void adi() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                bVar.adi();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Ua() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                bVar.Ua();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Vr() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                bVar.Vr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void adj() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                bVar.adj();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void TZ() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                bVar.TZ();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ceA == null || this.ceA.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.ceA) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Ub() {
        if (this.ceA != null && this.ceA.size() > 0) {
            for (b bVar : this.ceA) {
                if (bVar != null) {
                    bVar.Ub();
                }
            }
        }
    }
}
