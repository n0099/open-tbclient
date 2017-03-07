package com.baidu.tbadk.core.d;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface q {
    boolean ub() default false;

    String value() default "";
}
