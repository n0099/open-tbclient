package com.baidu.swan.apps.b.c.a;

import android.app.Activity;
import android.content.Intent;
import com.baidu.swan.apps.b.c.h;
import com.baidu.swan.apps.b.c.i;
import com.baidu.swan.apps.b.c.j;
/* loaded from: classes2.dex */
public final class b implements j {
    private h aEA = new h() { // from class: com.baidu.swan.apps.b.c.a.b.1
        @Override // com.baidu.swan.apps.b.c.h
        public void a(Activity activity, int i, int i2, Intent intent) {
            c.Cz().b(activity, i, i2, intent);
        }
    };

    @Override // com.baidu.swan.apps.b.c.j
    public i Cv() {
        return com.baidu.swan.apps.core.container.a.a.Eq();
    }

    @Override // com.baidu.swan.apps.b.c.j
    public h Cw() {
        return this.aEA;
    }
}
