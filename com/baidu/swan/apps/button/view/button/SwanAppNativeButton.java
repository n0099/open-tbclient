package com.baidu.swan.apps.button.view.button;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class SwanAppNativeButton extends TextView implements a<TextView, com.baidu.swan.apps.button.b.a.a> {
    private com.baidu.swan.apps.button.b.a.a akB;

    public SwanAppNativeButton(@NonNull Context context) {
        super(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a.a, com.baidu.swan.apps.button.view.a
    public com.baidu.swan.apps.button.b.a.a getModel() {
        return this.akB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a.a, com.baidu.swan.apps.button.view.a
    @NonNull
    public TextView getView() {
        return this;
    }

    public void a(@NonNull com.baidu.swan.apps.button.b.a.a aVar) {
        this.akB = aVar;
        com.baidu.swan.apps.button.c.a.b(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.button.view.a
    /* renamed from: b */
    public boolean a(@NonNull com.baidu.swan.apps.button.b.a.a aVar) {
        com.baidu.swan.apps.button.b.a.a aVar2;
        if (aVar.aDo == null || !aVar.aDo.isValid() || (aVar2 = this.akB) == null || aVar2.aDo == null || !aVar2.aDo.isValid()) {
            return false;
        }
        if ((com.baidu.swan.apps.button.c.a.a(aVar2, aVar).get() & 2) == 2) {
            a(aVar);
        } else {
            this.akB = aVar;
        }
        return true;
    }
}
