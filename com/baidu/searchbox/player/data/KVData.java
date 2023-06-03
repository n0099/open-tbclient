package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ$\u0010\u000f\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/data/KVData;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/ReadWriteProperty;", "", "key", "", "defaultValue", "dataProvider", "Lcom/baidu/searchbox/player/data/IKVDataProvider;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/baidu/searchbox/player/data/IKVDataProvider;)V", "getDataProvider", "()Lcom/baidu/searchbox/player/data/IKVDataProvider;", "Ljava/lang/Object;", "getKey", "()Ljava/lang/String;", "getValue", "thisRef", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class KVData<V> implements ReadWriteProperty<Object, V> {
    public final IKVDataProvider<V> dataProvider;
    public final V defaultValue;
    public final String key;

    public KVData(String key, V v, IKVDataProvider<V> dataProvider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.key = key;
        this.defaultValue = v;
        this.dataProvider = dataProvider;
    }

    public /* synthetic */ KVData(String str, Object obj, IKVDataProvider iKVDataProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, obj, iKVDataProvider);
    }

    public final IKVDataProvider<V> getDataProvider() {
        return this.dataProvider;
    }

    public final String getKey() {
        return this.key;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object obj, KProperty<?> property) {
        boolean z;
        Intrinsics.checkNotNullParameter(property, "property");
        IKVDataProvider<V> iKVDataProvider = this.dataProvider;
        String str = this.key;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = property.getName();
        }
        V data = iKVDataProvider.getData(str, this.defaultValue);
        BdVideoLog.d("KV data get value key is " + property.getName() + ",result is " + data);
        return data;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> property, V v) {
        boolean z;
        Intrinsics.checkNotNullParameter(property, "property");
        BdVideoLog.d("KV data set value key is " + property.getName() + ",result is " + v);
        IKVDataProvider<V> iKVDataProvider = this.dataProvider;
        String str = this.key;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = property.getName();
        }
        iKVDataProvider.saveData(str, v);
    }
}
