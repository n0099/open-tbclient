package com.baidu.swan.apps.b.c.a;

import android.app.Activity;
import android.content.Intent;
import com.baidu.swan.apps.b.c.h;
import com.baidu.swan.apps.b.c.i;
import com.baidu.swan.apps.b.c.j;
/* loaded from: classes2.dex */
public final class b implements j {
    private h ale = new h() { // from class: com.baidu.swan.apps.b.c.a.b.1
        @Override // com.baidu.swan.apps.b.c.h
        public void a(Activity activity, int i, int i2, Intent intent) {
            c.xF().b(activity, i, i2, intent);
        }
    };

    @Override // com.baidu.swan.apps.b.c.j
    public i xB() {
        return com.baidu.swan.apps.core.container.a.a.zv();
    }

    @Override // com.baidu.swan.apps.b.c.j
    public h xC() {
        return this.ale;
    }
}
