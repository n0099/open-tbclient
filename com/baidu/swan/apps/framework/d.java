package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d implements b {
    private List<b> cjo = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.cjo.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.cjo.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aen() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                bVar.aen();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aeo() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                bVar.aeo();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Vg() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                bVar.Vg();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Wx() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                bVar.Wx();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aep() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                bVar.aep();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Vf() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                bVar.Vf();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cjo == null || this.cjo.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.cjo) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void Vh() {
        if (this.cjo != null && this.cjo.size() > 0) {
            for (b bVar : this.cjo) {
                if (bVar != null) {
                    bVar.Vh();
                }
            }
        }
    }
}
