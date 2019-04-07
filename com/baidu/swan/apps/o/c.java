package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> avX = new ArrayList();

    public synchronized void c(@NonNull b bVar) {
        this.avX.add(bVar);
    }

    public synchronized void d(@NonNull b bVar) {
        this.avX.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void BC() {
        if (this.avX != null && this.avX.size() > 0) {
            for (b bVar : this.avX) {
                bVar.BC();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BD() {
        if (this.avX != null && this.avX.size() > 0) {
            for (b bVar : this.avX) {
                bVar.BD();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.avX != null && this.avX.size() > 0) {
            for (b bVar : this.avX) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.avX != null && this.avX.size() > 0) {
            for (b bVar : this.avX) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BE() {
        if (this.avX != null && this.avX.size() > 0) {
            for (b bVar : this.avX) {
                bVar.BE();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void BF() {
        if (this.avX != null && this.avX.size() > 0) {
            for (b bVar : this.avX) {
                bVar.BF();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.avX == null || this.avX.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.avX) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
