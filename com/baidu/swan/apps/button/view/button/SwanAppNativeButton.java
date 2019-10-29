package com.baidu.swan.apps.button.view.button;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class SwanAppNativeButton extends TextView implements a<TextView, com.baidu.swan.apps.button.b.a.a> {
    private com.baidu.swan.apps.button.b.a.a aEX;

    public SwanAppNativeButton(@NonNull Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a.a, com.baidu.swan.apps.button.view.a
    public com.baidu.swan.apps.button.b.a.a getModel() {
        return this.aEX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a.a, com.baidu.swan.apps.button.view.a
    @NonNull
    public TextView getView() {
        return this;
    }

    public void a(@NonNull com.baidu.swan.apps.button.b.a.a aVar) {
        this.aEX = aVar;
        com.baidu.swan.apps.button.c.a.b(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a
    /* renamed from: b */
    public boolean a(@NonNull com.baidu.swan.apps.button.b.a.a aVar) {
        com.baidu.swan.apps.button.b.a.a aVar2;
        if (aVar.aXJ == null || !aVar.aXJ.isValid() || (aVar2 = this.aEX) == null || aVar2.aXJ == null || !aVar2.aXJ.isValid()) {
            return false;
        }
        if ((com.baidu.swan.apps.button.c.a.a(aVar2, aVar).Vl() & 2) == 2) {
            a(aVar);
        } else {
            this.aEX = aVar;
        }
        return true;
    }
}
