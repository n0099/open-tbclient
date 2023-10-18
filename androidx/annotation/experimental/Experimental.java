package androidx.annotation.experimental;

import com.baidu.mobads.sdk.internal.bx;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
@Target({ElementType.ANNOTATION_TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Landroidx/annotation/experimental/Experimental;", "Ljava/lang/annotation/Annotation;", "Lkotlin/Any;", "Landroidx/annotation/experimental/Experimental$Level;", "level", "()Landroidx/annotation/experimental/Experimental$Level;", "<init>", "(Landroidx/annotation/experimental/Experimental$Level;)V", "Level", "annotation-experimental_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Deprecated(message = "This annotation has been replaced by `@RequiresOptIn`", replaceWith = @ReplaceWith(expression = "RequiresOptIn", imports = {"androidx.annotation.RequiresOptIn"}))
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: classes.dex */
public @interface Experimental {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/annotation/experimental/Experimental$Level;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "WARNING", bx.l, "annotation-experimental_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
