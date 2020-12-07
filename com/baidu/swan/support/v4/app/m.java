package com.baidu.swan.support.v4.app;

import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public abstract class m {
    public abstract m a(@IdRes int i, Fragment fragment);

    public abstract m a(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract m aG(@AnimRes int i, @AnimRes int i2);

    public abstract m c(Fragment fragment);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract m d(Fragment fragment);

    public abstract m e(Fragment fragment);
}
