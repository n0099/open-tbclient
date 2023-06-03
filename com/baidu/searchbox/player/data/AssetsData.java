package com.baidu.searchbox.player.data;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.utils.AssetsUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\r\u0010\t\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0096\u0002¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/player/data/AssetsData;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/ReadOnlyProperty;", "", "fileName", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getAssetsValue", "()Ljava/lang/Object;", "getValue", "thisRef", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class AssetsData<V> implements ReadOnlyProperty<Object, V> {
    public final V defaultValue;
    public final String fileName;

    public AssetsData(String fileName, V v) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.fileName = fileName;
        this.defaultValue = v;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public V getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getAssetsValue();
    }

    public /* synthetic */ AssetsData(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.String] */
    public final V getAssetsValue() {
        V v;
        ?? r0 = (V) AssetsUtils.loadConfigFromAssets(BDPlayerConfig.getAppContext(), this.fileName);
        if (r0 == 0) {
            return this.defaultValue;
        }
        try {
            v = this.defaultValue;
        } catch (JSONException e) {
            BdVideoLog.e(e.getMessage());
        }
        if (v instanceof String) {
            return r0;
        }
        if (v instanceof JSONObject) {
            return (V) new JSONObject((String) r0);
        }
        return this.defaultValue;
    }
}
