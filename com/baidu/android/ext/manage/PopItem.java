package com.baidu.android.ext.manage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes16.dex */
public interface PopItem {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface MethodName {
    }

    void mutexDismiss();

    boolean mutexShow(String str, Object... objArr) throws ClassCastException;
}
