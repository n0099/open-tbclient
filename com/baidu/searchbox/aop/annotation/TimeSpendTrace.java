package com.baidu.searchbox.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes11.dex */
public @interface TimeSpendTrace {
    boolean isEnd() default false;

    String parentTag() default "";

    String tag() default "";
}
