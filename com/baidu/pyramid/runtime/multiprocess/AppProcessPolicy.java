package com.baidu.pyramid.runtime.multiprocess;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface AppProcessPolicy {

    /* loaded from: classes14.dex */
    public enum ProcessType {
        ALL,
        DEFAULT,
        SERVER,
        OTHER
    }
}
