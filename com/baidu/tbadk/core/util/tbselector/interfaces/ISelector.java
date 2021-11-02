package com.baidu.tbadk.core.util.tbselector.interfaces;

import android.view.View;
/* loaded from: classes8.dex */
public interface ISelector<T, V extends View> {
    T build();

    void into(V v);
}
