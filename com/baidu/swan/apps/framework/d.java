package com.baidu.swan.apps.framework;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class d implements b {
    private List<b> daz = new CopyOnWriteArrayList();

    public void c(@NonNull b bVar) {
        this.daz.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.daz.remove(bVar);
    }

    @Override // com.baidu.swan.apps.framework.b
    public void auw() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                bVar.auw();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void aux() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                bVar.aux();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajx() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                bVar.ajx();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void akQ() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                bVar.akQ();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void amS() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                bVar.amS();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajw() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                bVar.ajw();
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.daz == null || this.daz.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (b bVar : this.daz) {
            z = z || bVar.onKeyDown(i, keyEvent);
        }
        return z;
    }

    @Override // com.baidu.swan.apps.framework.b
    public void ajy() {
        if (this.daz != null && this.daz.size() > 0) {
            for (b bVar : this.daz) {
                if (bVar != null) {
                    bVar.ajy();
                }
            }
        }
    }
}
