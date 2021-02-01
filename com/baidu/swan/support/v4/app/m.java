package com.baidu.swan.support.v4.app;

import androidx.annotation.AnimRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
/* loaded from: classes15.dex */
public abstract class m {
    public abstract m a(@IdRes int i, Fragment fragment);

    public abstract m a(@IdRes int i, Fragment fragment, @Nullable String str);

    public abstract m aA(@AnimRes int i, @AnimRes int i2);

    public abstract m c(Fragment fragment);

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract m d(Fragment fragment);

    public abstract m e(Fragment fragment);
}
