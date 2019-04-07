package com.baidu.swan.apps.button.container;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.button.b.a;
import com.baidu.swan.apps.button.view.a;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class SwanAppNativeViewContainer<V extends a<? extends View, M>, M extends com.baidu.swan.apps.button.b.a> extends SwanAppNAViewContainer {
    private static final boolean DEBUG = b.DEBUG;
    protected V akj;

    public SwanAppNativeViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(@NonNull V v) {
        this.akj = v;
        return super.a(this.akj.getView(), this.akj.getModel());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.swan.apps.button.container.SwanAppNativeViewContainer<V extends com.baidu.swan.apps.button.view.a<? extends android.view.View, M>, M extends com.baidu.swan.apps.button.b.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.view.container.SwanAppNAViewContainer
    @Deprecated
    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (!(view instanceof com.baidu.swan.apps.button.view.a)) {
            if (DEBUG) {
                throw new RuntimeException("insert a illegal view : not a INativeView");
            }
            return false;
        }
        try {
            return a((SwanAppNativeViewContainer<V, M>) ((com.baidu.swan.apps.button.view.a) view));
        } catch (ClassCastException e) {
            if (DEBUG) {
                throw new RuntimeException("insert a illegal view : not a V", e);
            }
            return false;
        }
    }

    public boolean a(@NonNull M m) {
        return this.akj.a(m) && super.a((com.baidu.swan.apps.model.a.a.a) m);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.swan.apps.button.container.SwanAppNativeViewContainer<V extends com.baidu.swan.apps.button.view.a<? extends android.view.View, M>, M extends com.baidu.swan.apps.button.b.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.view.container.SwanAppNAViewContainer
    @Deprecated
    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar instanceof com.baidu.swan.apps.button.b.a) {
            if (DEBUG) {
                throw new RuntimeException("update a illegal view model: not a SwanAppNativeViewModel");
            }
            return false;
        }
        try {
            return a((SwanAppNativeViewContainer<V, M>) ((com.baidu.swan.apps.button.b.a) aVar));
        } catch (ClassCastException e) {
            if (DEBUG) {
                throw new RuntimeException("update a illegal view model: not a M", e);
            }
            return false;
        }
    }
}
