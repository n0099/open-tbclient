package com.baidu.pyramid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes7.dex */
public @interface Inject {
    boolean force() default true;

    String name() default "";
}
