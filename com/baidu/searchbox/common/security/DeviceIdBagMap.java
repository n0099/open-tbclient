package com.baidu.searchbox.common.security;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "getDeviceFlag", "isSync", "", "deviceFlag", "put", "key", "value", "writeToParcel", "", "flags", "CREATOR", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceIdBagMap extends ConcurrentHashMap<Integer, DeviceIdBag> implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CREATOR implements Parcelable.Creator<DeviceIdBagMap> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public CREATOR() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceIdBagMap createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceIdBagMap(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceIdBagMap[] newArray(int i) {
            return new DeviceIdBagMap[i];
        }
    }

    public DeviceIdBagMap() {
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> entrySet() {
        return getEntries();
    }

    public final int getDeviceFlag() {
        int i = 0;
        for (Integer deviceFlag : keySet()) {
            Intrinsics.checkNotNullExpressionValue(deviceFlag, "deviceFlag");
            i |= deviceFlag.intValue();
        }
        return i;
    }

    public /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Integer> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<DeviceIdBag> getValues() {
        return super.values();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Integer> keySet() {
        return getKeys();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<DeviceIdBag> values() {
        return getValues();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceIdBagMap(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parcel.readInt();
            DeviceIdBag deviceIdBag = (DeviceIdBag) parcel.readParcelable(DeviceIdBag.class.getClassLoader());
            if (deviceIdBag != null) {
                put(readInt2, deviceIdBag);
            }
        }
    }

    public /* bridge */ boolean containsKey(Integer num) {
        return super.containsKey((Object) num);
    }

    public /* bridge */ boolean containsValue(DeviceIdBag deviceIdBag) {
        return super.containsValue((Object) deviceIdBag);
    }

    public /* bridge */ DeviceIdBag get(Integer num) {
        return (DeviceIdBag) super.get((Object) num);
    }

    public final boolean isSync(final int i) {
        if (((~getDeviceFlag()) & i) != 0) {
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        DeviceInfoUtilKt.forEachDevice(new Function1<Integer, Unit>() { // from class: com.baidu.searchbox.common.security.DeviceIdBagMap$isSync$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                if ((i & i2) != 0) {
                    DeviceIdBag deviceIdBag = (DeviceIdBag) this.get((Object) Integer.valueOf(i2));
                    if (deviceIdBag == null || deviceIdBag.errorCode != 3) {
                        booleanRef.element = false;
                    }
                }
            }
        });
        return booleanRef.element;
    }

    public /* bridge */ DeviceIdBag remove(Integer num) {
        return (DeviceIdBag) super.remove((Object) num);
    }

    public static /* synthetic */ boolean isSync$default(DeviceIdBagMap deviceIdBagMap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = deviceIdBagMap.getDeviceFlag();
        }
        return deviceIdBagMap.isSync(i);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        return containsKey((Integer) obj);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof DeviceIdBag)) {
            return false;
        }
        return containsValue((DeviceIdBag) obj);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ DeviceIdBag get(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        return get((Integer) obj);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ DeviceIdBag remove(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        return remove((Integer) obj);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        return get((Integer) obj);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        return remove((Integer) obj);
    }

    public /* bridge */ DeviceIdBag getOrDefault(Integer num, DeviceIdBag deviceIdBag) {
        return (DeviceIdBag) super.getOrDefault((Object) num, (Integer) deviceIdBag);
    }

    public DeviceIdBag put(int i, DeviceIdBag value) {
        DeviceIdBag deviceIdBag;
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (DeviceIdBagMap.class) {
            deviceIdBag = (DeviceIdBag) super.put((DeviceIdBagMap) Integer.valueOf(i), (Integer) value);
        }
        return deviceIdBag;
    }

    public /* bridge */ boolean remove(Integer num, DeviceIdBag deviceIdBag) {
        return super.remove((Object) num, (Object) deviceIdBag);
    }

    public final /* bridge */ DeviceIdBag getOrDefault(Object obj, DeviceIdBag deviceIdBag) {
        if (!(obj instanceof Integer)) {
            return deviceIdBag;
        }
        return getOrDefault((Integer) obj, deviceIdBag);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put(((Number) obj).intValue(), (DeviceIdBag) obj2);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj instanceof Integer) || !(obj2 instanceof DeviceIdBag)) {
            return false;
        }
        return remove((Integer) obj, (DeviceIdBag) obj2);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        if (!(obj instanceof Integer)) {
            return obj2;
        }
        return getOrDefault((Integer) obj, (DeviceIdBag) obj2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        synchronized (DeviceIdBagMap.class) {
            Set<Integer> keys = keySet();
            Intrinsics.checkNotNullExpressionValue(keys, "keys");
            parcel.writeInt(keys.size());
            for (Integer deviceFlag : keys) {
                Intrinsics.checkNotNullExpressionValue(deviceFlag, "deviceFlag");
                parcel.writeInt(deviceFlag.intValue());
                parcel.writeParcelable((Parcelable) get((Object) deviceFlag), 0);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
