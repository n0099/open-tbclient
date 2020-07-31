package com.baidu.android.util.media.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface MediaQueryParam {
    public static final String SORT_ASC = " ASC";
    public static final String SORT_DESC = " DESC";

    String[] select() default {};

    String[] selectArgs() default {};

    String sortBy() default "date_added";

    String sortType() default " DESC";
}
