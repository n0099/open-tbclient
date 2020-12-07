package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes25.dex */
public class d implements b {
    private List<b> dar = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.dar.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.dar.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void awY() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                bVar.awY();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void awZ() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                bVar.awZ();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amg() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                bVar.amg();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void any() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                bVar.any();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void apA() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                bVar.apA();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amf() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                bVar.amf();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.dar == null || this.dar.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.dar) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amh() {
        if (this.dar != null && this.dar.size() > 0) {
            for (b bVar : this.dar) {
                if (bVar != null) {
                    bVar.amh();
                }
            }
        }
    }
}
