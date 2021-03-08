package com.baidu.swan.apps.framework;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class d implements b {
    private List<b> dem = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.dem.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.dem.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auX() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                bVar.auX();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auY() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                bVar.auY();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajY() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                bVar.ajY();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void alr() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                bVar.alr();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ant() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                bVar.ant();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajX() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                bVar.ajX();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.dem == null || this.dem.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.dem) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajZ() {
        if (this.dem != null && this.dem.size() > 0) {
            for (b bVar : this.dem) {
                if (bVar != null) {
                    bVar.ajZ();
                }
            }
        }
    }
}
