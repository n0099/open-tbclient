package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> avY = new ArrayList();

    public synchronized void c(@NonNull b bVar) {
        this.avY.add(bVar);
    }

    public synchronized void d(@NonNull b bVar) {
        this.avY.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void BC() {
        if (this.avY != null && this.avY.size() > 0) {
            for (b bVar : this.avY) {
                bVar.BC();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BD() {
        if (this.avY != null && this.avY.size() > 0) {
            for (b bVar : this.avY) {
                bVar.BD();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.avY != null && this.avY.size() > 0) {
            for (b bVar : this.avY) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.avY != null && this.avY.size() > 0) {
            for (b bVar : this.avY) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BE() {
        if (this.avY != null && this.avY.size() > 0) {
            for (b bVar : this.avY) {
                bVar.BE();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BF() {
        if (this.avY != null && this.avY.size() > 0) {
            for (b bVar : this.avY) {
                bVar.BF();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.avY == null || this.avY.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.avY) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
