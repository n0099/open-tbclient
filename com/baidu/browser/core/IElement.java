package com.baidu.browser.core;

import android.content.Context;
/* loaded from: classes.dex */
public interface IElement {
    void onDestroy();

    void onInit(Context context);

    void onLoad(Context context);

    void onSave(Context context);
}
