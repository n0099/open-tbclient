package com.baidu.searchbox.player.property;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/player/property/Property;", ExifInterface.GPS_DIRECTION_TRUE, "", "initState", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "(Ljava/lang/Object;Lcom/baidu/searchbox/player/property/Scope;)V", "getScope", "()Lcom/baidu/searchbox/player/property/Scope;", "setScope", "(Lcom/baidu/searchbox/player/property/Scope;)V", "state", "Ljava/lang/Object;", "getState", "()Ljava/lang/Object;", "setState", "", "targetState", "notify", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class Property<T> {
    public Scope scope;
    public T state;

    @JvmOverloads
    public final void setState(T t) {
        setState$default(this, t, null, 2, null);
    }

    public Property(T t, Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.state = t;
    }

    @JvmOverloads
    public final void setState(T t, Function0<Unit> function0) {
        this.state = t;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.property.Property */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setState$default(Property property, Object obj, Function0 function0, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            property.setState(obj, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
    }

    public final Scope getScope() {
        return this.scope;
    }

    public final T getState() {
        return this.state;
    }

    public final void setScope(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "<set-?>");
        this.scope = scope;
    }
}
