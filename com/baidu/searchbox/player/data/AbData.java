package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ$\u0010\n\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0096\u0002¢\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015R\u001b\u0010\t\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/player/data/AbData;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/baidu/searchbox/player/data/KVData;", "key", "", "defaultValue", "dataProvider", "Lcom/baidu/searchbox/player/data/IKVDataProvider;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/baidu/searchbox/player/data/IKVDataProvider;)V", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "thisRef", "", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class AbData<V> extends KVData<V> {
    public final Lazy value$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbData(final String key, final V v, final IKVDataProvider<V> dataProvider) {
        super(key, v, dataProvider);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.value$delegate = LazyKt__LazyJVMKt.lazy(new Function0<V>() { // from class: com.baidu.searchbox.player.data.AbData$value$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final V invoke() {
                return dataProvider.getData(key, v);
            }
        });
    }

    @Override // com.baidu.searchbox.player.data.KVData, kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> property, V v) {
        Intrinsics.checkNotNullParameter(property, "property");
        getDataProvider().saveData(getKey(), v);
    }

    private final V getValue() {
        return (V) this.value$delegate.getValue();
    }

    @Override // com.baidu.searchbox.player.data.KVData, kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }
}
