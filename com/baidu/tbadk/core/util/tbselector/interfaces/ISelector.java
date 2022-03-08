package com.baidu.tbadk.core.util.tbselector.interfaces;

import android.view.View;
/* loaded from: classes5.dex */
public interface ISelector<T, V extends View> {
    T build();

    void into(V v);
}
