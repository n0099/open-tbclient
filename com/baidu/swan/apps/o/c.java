package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> aQv = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.aQv.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.aQv.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void Im() {
        if (this.aQv != null && this.aQv.size() > 0) {
            for (b bVar : this.aQv) {
                bVar.Im();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void In() {
        if (this.aQv != null && this.aQv.size() > 0) {
            for (b bVar : this.aQv) {
                bVar.In();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.aQv != null && this.aQv.size() > 0) {
            for (b bVar : this.aQv) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.aQv != null && this.aQv.size() > 0) {
            for (b bVar : this.aQv) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Io() {
        if (this.aQv != null && this.aQv.size() > 0) {
            for (b bVar : this.aQv) {
                bVar.Io();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Ip() {
        if (this.aQv != null && this.aQv.size() > 0) {
            for (b bVar : this.aQv) {
                bVar.Ip();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aQv == null || this.aQv.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.aQv) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
