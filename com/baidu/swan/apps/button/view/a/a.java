package com.baidu.swan.apps.button.view.a;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.baidu.swan.apps.button.b.b.a;
/* loaded from: classes2.dex */
public interface a<V extends TextView, M extends com.baidu.swan.apps.button.b.b.a> extends com.baidu.swan.apps.button.view.a<V, M> {
    @Override // com.baidu.swan.apps.button.view.a
    M getModel();

    @Override // com.baidu.swan.apps.button.view.a
    @NonNull
    V getView();
}
