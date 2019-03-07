package com.baidu.swan.apps.button.view.button;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class SwanAppNativeButton extends TextView implements a<TextView, com.baidu.swan.apps.button.b.a.a> {
    private com.baidu.swan.apps.button.b.a.a akj;

    public SwanAppNativeButton(@NonNull Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a.a, com.baidu.swan.apps.button.view.a
    public com.baidu.swan.apps.button.b.a.a getModel() {
        return this.akj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a.a, com.baidu.swan.apps.button.view.a
    @NonNull
    public TextView getView() {
        return this;
    }

    public void a(@NonNull com.baidu.swan.apps.button.b.a.a aVar) {
        this.akj = aVar;
        com.baidu.swan.apps.button.c.a.b(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a
    /* renamed from: b */
    public boolean a(@NonNull com.baidu.swan.apps.button.b.a.a aVar) {
        com.baidu.swan.apps.button.b.a.a aVar2;
        if (aVar.aBE == null || !aVar.aBE.isValid() || (aVar2 = this.akj) == null || aVar2.aBE == null || !aVar2.aBE.isValid()) {
            return false;
        }
        if ((com.baidu.swan.apps.button.c.a.a(aVar2, aVar).get() & 2) == 2) {
            a(aVar);
        } else {
            this.akj = aVar;
        }
        return true;
    }
}
