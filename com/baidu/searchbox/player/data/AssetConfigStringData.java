package com.baidu.searchbox.player.data;

import com.heytap.msp.push.mode.MessageStat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/player/data/AssetConfigStringData;", "Lcom/baidu/searchbox/player/data/AssetsData;", "", "fileName", "isSticky", "", "(Ljava/lang/String;Z)V", "value", "getValue", "()Ljava/lang/String;", "value$delegate", "Lkotlin/Lazy;", "thisRef", "", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssetConfigStringData extends AssetsData<String> {
    public final boolean isSticky;
    public final Lazy value$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetConfigStringData(String fileName, boolean z) {
        super(fileName, "");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.isSticky = z;
        this.value$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.baidu.searchbox.player.data.AssetConfigStringData$value$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return AssetConfigStringData.this.getAssetsValue();
            }
        });
    }

    @Override // com.baidu.searchbox.player.data.AssetsData, kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue(obj, (KProperty<?>) kProperty);
    }

    public /* synthetic */ AssetConfigStringData(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    private final String getValue() {
        return (String) this.value$delegate.getValue();
    }

    @Override // com.baidu.searchbox.player.data.AssetsData, kotlin.properties.ReadOnlyProperty
    public String getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.isSticky) {
            return getValue();
        }
        return getAssetsValue();
    }
}
