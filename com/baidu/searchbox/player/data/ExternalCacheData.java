package com.baidu.searchbox.player.data;

import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.utils.AssetsUtils;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0096\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/player/data/ExternalCacheData;", "Lkotlin/properties/ReadOnlyProperty;", "", "", "fileName", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "thisRef", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExternalCacheData implements ReadOnlyProperty<Object, String> {
    public final String defaultValue;
    public final String fileName;

    public ExternalCacheData(String fileName, String defaultValue) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.fileName = fileName;
        this.defaultValue = defaultValue;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ String getValue(Object obj, KProperty kProperty) {
        return getValue2(obj, (KProperty<?>) kProperty);
    }

    public /* synthetic */ ExternalCacheData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* renamed from: getValue  reason: avoid collision after fix types in other method */
    public String getValue2(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        String loadConfigFromExternalCache = AssetsUtils.loadConfigFromExternalCache(BDPlayerConfig.getAppContext(), this.fileName);
        if (loadConfigFromExternalCache == null) {
            return this.defaultValue;
        }
        return loadConfigFromExternalCache;
    }
}
