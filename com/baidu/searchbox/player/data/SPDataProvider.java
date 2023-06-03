package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/data/SPDataProvider;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/baidu/searchbox/player/data/IKVDataProvider;", "fileName", "", "(Ljava/lang/String;)V", ShareLoginStat.GetShareListStat.VALUE_FROM_SP, "Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "getSp", "()Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "sp$delegate", "Lkotlin/Lazy;", "getData", "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "saveData", "", "value", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SPDataProvider<V> implements IKVDataProvider<V> {
    public final Lazy sp$delegate;

    public SPDataProvider(final String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.sp$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPrefsWrapper>() { // from class: com.baidu.searchbox.player.data.SPDataProvider$sp$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefsWrapper invoke() {
                return new SharedPrefsWrapper(fileName);
            }
        });
    }

    @Override // com.baidu.searchbox.player.data.IReadOnlyDataProvider
    public V getData(String key, V v) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (v instanceof Long) {
            return (V) Long.valueOf(getSp().getLong(key, ((Number) v).longValue()));
        }
        if (v instanceof String) {
            return (V) getSp().getString(key, (String) v);
        }
        if (v instanceof Integer) {
            return (V) Integer.valueOf(getSp().getInt(key, ((Number) v).intValue()));
        }
        if (v instanceof Boolean) {
            return (V) Boolean.valueOf(getSp().getBoolean(key, ((Boolean) v).booleanValue()));
        }
        if (v instanceof Float) {
            return (V) Float.valueOf(getSp().getFloat(key, ((Number) v).floatValue()));
        }
        return v;
    }

    public final SharedPrefsWrapper getSp() {
        return (SharedPrefsWrapper) this.sp$delegate.getValue();
    }

    @Override // com.baidu.searchbox.player.data.IKVDataProvider
    public void saveData(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj instanceof Long) {
            getSp().putLong(key, ((Number) obj).longValue());
        } else if (obj instanceof String) {
            getSp().putString(key, (String) obj);
        } else if (obj instanceof Integer) {
            getSp().putInt(key, ((Number) obj).intValue());
        } else if (obj instanceof Boolean) {
            getSp().putBoolean(key, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            getSp().putFloat(key, ((Number) obj).floatValue());
        }
    }
}
