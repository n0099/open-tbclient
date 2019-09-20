package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> axy = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.axy.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.axy.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void Dr() {
        if (this.axy != null && this.axy.size() > 0) {
            for (b bVar : this.axy) {
                bVar.Dr();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Ds() {
        if (this.axy != null && this.axy.size() > 0) {
            for (b bVar : this.axy) {
                bVar.Ds();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.axy != null && this.axy.size() > 0) {
            for (b bVar : this.axy) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.axy != null && this.axy.size() > 0) {
            for (b bVar : this.axy) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Dt() {
        if (this.axy != null && this.axy.size() > 0) {
            for (b bVar : this.axy) {
                bVar.Dt();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Du() {
        if (this.axy != null && this.axy.size() > 0) {
            for (b bVar : this.axy) {
                bVar.Du();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.axy == null || this.axy.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.axy) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
