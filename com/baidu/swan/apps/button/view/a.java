package com.baidu.swan.apps.button.view;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.swan.apps.button.b.a;
/* loaded from: classes2.dex */
public interface a<V extends View, M extends com.baidu.swan.apps.button.b.a> {
    boolean a(@NonNull M m);

    M getModel();

    @NonNull
    V getView();
}
