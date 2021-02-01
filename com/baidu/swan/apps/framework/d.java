package com.baidu.swan.apps.framework;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class d implements b {
    private List<b> dcK = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.dcK.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.dcK.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auU() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                bVar.auU();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auV() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                bVar.auV();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajV() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                bVar.ajV();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void alo() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                bVar.alo();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void anq() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                bVar.anq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajU() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                bVar.ajU();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.dcK == null || this.dcK.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.dcK) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajW() {
        if (this.dcK != null && this.dcK.size() > 0) {
            for (b bVar : this.dcK) {
                if (bVar != null) {
                    bVar.ajW();
                }
            }
        }
    }
}
