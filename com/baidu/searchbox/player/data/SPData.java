package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\u000b\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/data/SPData;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/baidu/searchbox/player/data/KVData;", "key", "", "defaultValue", "spFileName", "isSticky", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)V", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "thisRef", "", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SPData<V> extends KVData<V> {
    public boolean isSticky;
    public final Lazy value$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SPData(final String key, final V v, String spFileName, boolean z) {
        super(key, v, new SPDataProvider(spFileName));
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(spFileName, "spFileName");
        this.isSticky = z;
        this.value$delegate = LazyKt__LazyJVMKt.lazy(new Function0<V>(this) { // from class: com.baidu.searchbox.player.data.SPData$value$2
            public final /* synthetic */ SPData<V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final V invoke() {
                return this.this$0.getDataProvider().getData(key, v);
            }
        });
    }

    public /* synthetic */ SPData(String str, Object obj, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? "com.baidu.searchbox.player.pref" : str2, (i & 8) != 0 ? false : z);
    }

    public final V getValue() {
        return (V) this.value$delegate.getValue();
    }

    @Override // com.baidu.searchbox.player.data.KVData, kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.isSticky) {
            return getValue();
        }
        return (V) super.getValue(obj, property);
    }
}
