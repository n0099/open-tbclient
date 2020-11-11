package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class d implements b {
    private List<b> cVh = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.cVh.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.cVh.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auy() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                bVar.auy();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auz() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                bVar.auz();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajG() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                bVar.ajG();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void akY() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                bVar.akY();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ana() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                bVar.ana();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajF() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                bVar.ajF();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cVh == null || this.cVh.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.cVh) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajH() {
        if (this.cVh != null && this.cVh.size() > 0) {
            for (b bVar : this.cVh) {
                if (bVar != null) {
                    bVar.ajH();
                }
            }
        }
    }
}
