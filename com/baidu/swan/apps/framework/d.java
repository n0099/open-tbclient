package com.baidu.swan.apps.framework;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class d implements b {
    private List<b> dfo = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.dfo.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.dfo.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ayq() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                bVar.ayq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ayr() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                bVar.ayr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void anr() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                bVar.anr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aoK() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                bVar.aoK();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aqN() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                bVar.aqN();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void anq() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                bVar.anq();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.dfo == null || this.dfo.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.dfo) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ans() {
        if (this.dfo != null && this.dfo.size() > 0) {
            for (b bVar : this.dfo) {
                if (bVar != null) {
                    bVar.ans();
                }
            }
        }
    }
}
