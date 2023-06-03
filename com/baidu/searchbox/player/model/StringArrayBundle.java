package com.baidu.searchbox.player.model;

import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u0002H\b\"\u0006\b\u0000\u0010\b\u0018\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u0002H\bH\u0087\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007J\"\u0010\u000e\u001a\u0004\u0018\u0001H\b\"\u0006\b\u0000\u0010\b\u0018\u00012\u0006\u0010\t\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0015H\u0007J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0007J$\u0010\u001a\u001a\u0002H\b\"\u0006\b\u0000\u0010\b\u0018\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u0002H\bH\u0086\b¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/player/model/StringArrayBundle;", "Landroidx/collection/ArrayMap;", "", "", "capacity", "", "(I)V", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getBooleanExtra", "", "getExtra", "getExtraValue", "(Ljava/lang/String;)Ljava/lang/Object;", "getFloatExtra", "", "getIntExtra", "getLongExtra", "", "getStringExtra", "putExtra", "", "obj", "toValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StringArrayBundle extends ArrayMap<String, Object> {
    public StringArrayBundle() {
        this(0, 1, null);
    }

    @JvmOverloads
    public final boolean getBooleanExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getBooleanExtra$default(this, key, false, 2, null);
    }

    @JvmOverloads
    public final float getFloatExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getFloatExtra$default(this, key, 0.0f, 2, null);
    }

    @JvmOverloads
    public final int getIntExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getIntExtra$default(this, key, 0, 2, null);
    }

    @JvmOverloads
    public final long getLongExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getLongExtra$default(this, key, 0L, 2, null);
    }

    @JvmOverloads
    public final String getStringExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getStringExtra$default(this, key, null, 2, null);
    }

    public StringArrayBundle(int i) {
        super(i);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof String;
        }
        if (!z) {
            return false;
        }
        return containsKey((String) obj);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof String;
        }
        if (!z) {
            return null;
        }
        return get((String) obj);
    }

    public final Object getExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return get((Object) key);
    }

    @JvmName(name = "getExtraValue")
    public final /* synthetic */ <T> T getExtraValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) getExtra(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof String;
        }
        if (!z) {
            return null;
        }
        return remove((String) obj);
    }

    public /* synthetic */ StringArrayBundle(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }

    public static /* synthetic */ boolean getBooleanExtra$default(StringArrayBundle stringArrayBundle, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return stringArrayBundle.getBooleanExtra(str, z);
    }

    public static /* synthetic */ float getFloatExtra$default(StringArrayBundle stringArrayBundle, String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return stringArrayBundle.getFloatExtra(str, f);
    }

    public static /* synthetic */ int getIntExtra$default(StringArrayBundle stringArrayBundle, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return stringArrayBundle.getIntExtra(str, i);
    }

    public static /* synthetic */ long getLongExtra$default(StringArrayBundle stringArrayBundle, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return stringArrayBundle.getLongExtra(str, j);
    }

    public static /* synthetic */ String getStringExtra$default(StringArrayBundle stringArrayBundle, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return stringArrayBundle.getStringExtra(str, str2);
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    public /* bridge */ Object get(String str) {
        return super.get((Object) str);
    }

    public /* bridge */ Object remove(String str) {
        return super.remove((Object) str);
    }

    @Override // androidx.collection.ArrayMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // androidx.collection.ArrayMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // androidx.collection.ArrayMap, java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public final /* synthetic */ <T> T get(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get((Object) key);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (t2 instanceof Object) {
            return t2;
        }
        return t;
    }

    @JvmOverloads
    public final boolean getBooleanExtra(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = get((Object) key);
        Boolean valueOf = Boolean.valueOf(z);
        if (!(obj instanceof Boolean)) {
            obj = valueOf;
        }
        return ((Boolean) obj).booleanValue();
    }

    @JvmOverloads
    public final float getFloatExtra(String key, float f) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = get((Object) key);
        Float valueOf = Float.valueOf(f);
        if (!(obj instanceof Float)) {
            obj = valueOf;
        }
        return ((Number) obj).floatValue();
    }

    @JvmOverloads
    public final int getIntExtra(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = get((Object) key);
        Integer valueOf = Integer.valueOf(i);
        if (!(obj instanceof Integer)) {
            obj = valueOf;
        }
        return ((Number) obj).intValue();
    }

    @JvmOverloads
    public final long getLongExtra(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = get((Object) key);
        Long valueOf = Long.valueOf(j);
        if (!(obj instanceof Long)) {
            obj = valueOf;
        }
        return ((Number) obj).longValue();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof String;
        }
        if (!z) {
            return obj2;
        }
        return getOrDefault((String) obj, obj2);
    }

    @JvmOverloads
    public final String getStringExtra(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object obj = get((Object) key);
        if (obj instanceof String) {
            defaultValue = obj;
        }
        return defaultValue;
    }

    public final void putExtra(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj == null) {
            return;
        }
        put(key, obj);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof String;
        }
        if (!z) {
            return false;
        }
        return remove((String) obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T toValue(Object obj, T t) {
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (!(obj instanceof Object)) {
            return t;
        }
        return obj;
    }

    public /* bridge */ Object getOrDefault(String str, Object obj) {
        return super.getOrDefault((Object) str, (String) obj);
    }

    public /* bridge */ boolean remove(String str, Object obj) {
        return super.remove((Object) str, obj);
    }
}
