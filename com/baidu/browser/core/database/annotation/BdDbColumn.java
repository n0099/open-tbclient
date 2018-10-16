package com.baidu.browser.core.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface BdDbColumn {

    /* loaded from: classes2.dex */
    public enum TYPE {
        TEXT,
        INTEGER,
        LONG,
        SHORT,
        FLOAT,
        BLOB
    }
}
