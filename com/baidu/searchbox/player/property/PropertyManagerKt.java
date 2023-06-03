package com.baidu.searchbox.player.property;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0005¨\u0006\u0006"}, d2 = {"forKey", "", "clazzName", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "Lcom/baidu/searchbox/player/property/Property;", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PropertyManagerKt {
    public static final String forKey(String str, Scope scope) {
        if (!Intrinsics.areEqual(scope, GlobalScope.INSTANCE)) {
            return str + scope.getName();
        }
        return str;
    }

    public static final String forKey(Property<?> property) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        String name = property.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "this::class.java.name");
        return forKey(name, property.getScope());
    }
}
