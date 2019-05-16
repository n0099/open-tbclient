package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> awv = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.awv.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.awv.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void CE() {
        if (this.awv != null && this.awv.size() > 0) {
            for (b bVar : this.awv) {
                bVar.CE();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void CF() {
        if (this.awv != null && this.awv.size() > 0) {
            for (b bVar : this.awv) {
                bVar.CF();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.awv != null && this.awv.size() > 0) {
            for (b bVar : this.awv) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.awv != null && this.awv.size() > 0) {
            for (b bVar : this.awv) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void CG() {
        if (this.awv != null && this.awv.size() > 0) {
            for (b bVar : this.awv) {
                bVar.CG();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void CH() {
        if (this.awv != null && this.awv.size() > 0) {
            for (b bVar : this.awv) {
                bVar.CH();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.awv == null || this.awv.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.awv) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
