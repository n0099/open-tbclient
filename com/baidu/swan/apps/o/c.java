package com.baidu.swan.apps.o;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c implements b {
    private List<b> axa = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.axa.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.axa.remove(bVar);
    }

    @Override // com.baidu.swan.apps.o.b
    public void Dn() {
        if (this.axa != null && this.axa.size() > 0) {
            for (b bVar : this.axa) {
                bVar.Dn();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Do() {
        if (this.axa != null && this.axa.size() > 0) {
            for (b bVar : this.axa) {
                bVar.Do();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityResumed() {
        if (this.axa != null && this.axa.size() > 0) {
            for (b bVar : this.axa) {
                bVar.onActivityResumed();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void onActivityPaused() {
        if (this.axa != null && this.axa.size() > 0) {
            for (b bVar : this.axa) {
                bVar.onActivityPaused();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Dp() {
        if (this.axa != null && this.axa.size() > 0) {
            for (b bVar : this.axa) {
                bVar.Dp();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public void Dq() {
        if (this.axa != null && this.axa.size() > 0) {
            for (b bVar : this.axa) {
                bVar.Dq();
            }
        }
    }

    @Override // com.baidu.swan.apps.o.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.axa == null || this.axa.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.axa) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }
}
