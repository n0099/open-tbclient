package com.baidu.searchbox.player.property;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/property/SpeedProperty;", "Lcom/baidu/searchbox/player/property/Property;", "", "speed", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "(FLcom/baidu/searchbox/player/property/Scope;)V", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpeedProperty extends Property<Float> {
    public SpeedProperty() {
        this(0.0f, null, 3, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeedProperty(float f, Scope scope) {
        super(Float.valueOf(f), scope);
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    public /* synthetic */ SpeedProperty(float f, Scope scope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? SingleScope.INSTANCE : scope);
    }
}
