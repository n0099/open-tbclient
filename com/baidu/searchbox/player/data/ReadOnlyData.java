package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J$\u0010\r\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0096\u0002¢\u0006\u0002\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0000X\u0084\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/player/data/ReadOnlyData;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/ReadOnlyProperty;", "", "defaultValue", "dataProvider", "Lcom/baidu/searchbox/player/data/IReadOnlyDataProvider;", "(Ljava/lang/Object;Lcom/baidu/searchbox/player/data/IReadOnlyDataProvider;)V", "getDataProvider", "()Lcom/baidu/searchbox/player/data/IReadOnlyDataProvider;", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ReadOnlyData<V> implements ReadOnlyProperty<Object, V> {
    public final IReadOnlyDataProvider<V> dataProvider;
    public final V defaultValue;

    public ReadOnlyData(V v, IReadOnlyDataProvider<V> dataProvider) {
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.defaultValue = v;
        this.dataProvider = dataProvider;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public V getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.dataProvider.getData(property.getName(), this.defaultValue);
    }

    public final IReadOnlyDataProvider<V> getDataProvider() {
        return this.dataProvider;
    }

    public final V getDefaultValue() {
        return this.defaultValue;
    }
}
