package com.baidu.searchbox.common.security;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static final CREATOR CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1737099343, "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1737099343, "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;");
                return;
            }
        }
        CREATOR = new CREATOR(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CREATOR implements Parcelable.Creator<DeviceIdBagMap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public CREATOR() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceIdBagMap createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DeviceIdBagMap(parcel);
            }
            return (DeviceIdBagMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceIdBagMap[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return new DeviceIdBagMap[i];
            }
            return (DeviceIdBagMap[]) invokeI.objValue;
        }
    }

    public DeviceIdBagMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getEntries();
        }
        return (Set) invokeV.objValue;
    }

    public final int getDeviceFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = 0;
            for (Integer deviceFlag : keySet()) {
                Intrinsics.checkNotNullExpressionValue(deviceFlag, "deviceFlag");
                i |= deviceFlag.intValue();
            }
            return i;
        }
        return invokeV.intValue;
    }

    public /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> getEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return super.entrySet();
        }
        return (Set) invokeV.objValue;
    }

    public /* bridge */ Set<Integer> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return super.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public /* bridge */ int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return super.size();
        }
        return invokeV.intValue;
    }

    public /* bridge */ Collection<DeviceIdBag> getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return super.values();
        }
        return (Collection) invokeV.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Integer> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getKeys();
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return getSize();
        }
        return invokeV.intValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<DeviceIdBag> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return getValues();
        }
        return (Collection) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceIdBagMap(Parcel parcel) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            DeviceIdBag deviceIdBag = (DeviceIdBag) parcel.readParcelable(DeviceIdBag.class.getClassLoader());
            if (deviceIdBag != null) {
                put(readInt2, deviceIdBag);
            }
        }
    }

    public static /* synthetic */ boolean isSync$default(DeviceIdBagMap deviceIdBagMap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = deviceIdBagMap.getDeviceFlag();
        }
        return deviceIdBagMap.isSync(i);
    }

    public /* bridge */ boolean containsKey(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, num)) == null) {
            return super.containsKey((Object) num);
        }
        return invokeL.booleanValue;
    }

    public /* bridge */ boolean containsValue(DeviceIdBag deviceIdBag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, deviceIdBag)) == null) {
            return super.containsValue((Object) deviceIdBag);
        }
        return invokeL.booleanValue;
    }

    public /* bridge */ DeviceIdBag get(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, num)) == null) {
            return (DeviceIdBag) super.get((Object) num);
        }
        return (DeviceIdBag) invokeL.objValue;
    }

    public final boolean isSync(final int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (((~getDeviceFlag()) & i) != 0) {
                return false;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            DeviceInfoUtilKt.forEachDevice(new Function1<Integer, Unit>(i, this, booleanRef) { // from class: com.baidu.searchbox.common.security.DeviceIdBagMap$isSync$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ int $deviceFlag;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.BooleanRef $isSync;
                public final /* synthetic */ DeviceIdBagMap this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), this, booleanRef};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$deviceFlag = i;
                    this.this$0 = this;
                    this.$isSync = booleanRef;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (this.$deviceFlag & i2) != 0) {
                        DeviceIdBag deviceIdBag = (DeviceIdBag) this.this$0.get((Object) Integer.valueOf(i2));
                        if (deviceIdBag == null || deviceIdBag.errorCode != 3) {
                            this.$isSync.element = false;
                        }
                    }
                }
            });
            return booleanRef.element;
        }
        return invokeI.booleanValue;
    }

    public /* bridge */ DeviceIdBag remove(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, num)) == null) {
            return (DeviceIdBag) super.remove((Object) num);
        }
        return (DeviceIdBag) invokeL.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof Integer)) {
                return false;
            }
            return containsKey((Integer) obj);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (!(obj instanceof DeviceIdBag)) {
                return false;
            }
            return containsValue((DeviceIdBag) obj);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ DeviceIdBag get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (!(obj instanceof Integer)) {
                return null;
            }
            return get((Integer) obj);
        }
        return (DeviceIdBag) invokeL.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ DeviceIdBag remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (!(obj instanceof Integer)) {
                return null;
            }
            return remove((Integer) obj);
        }
        return (DeviceIdBag) invokeL.objValue;
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, num, deviceIdBag)) == null) {
            return (DeviceIdBag) super.getOrDefault((Object) num, (Integer) deviceIdBag);
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public DeviceIdBag put(int i, DeviceIdBag value) {
        InterceptResult invokeIL;
        DeviceIdBag deviceIdBag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i, value)) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (DeviceIdBagMap.class) {
                deviceIdBag = (DeviceIdBag) super.put((DeviceIdBagMap) Integer.valueOf(i), (Integer) value);
            }
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeIL.objValue;
    }

    public /* bridge */ boolean remove(Integer num, DeviceIdBag deviceIdBag) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, num, deviceIdBag)) == null) {
            return super.remove((Object) num, (Object) deviceIdBag);
        }
        return invokeLL.booleanValue;
    }

    public final /* bridge */ DeviceIdBag getOrDefault(Object obj, DeviceIdBag deviceIdBag) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, obj, deviceIdBag)) == null) {
            if (!(obj instanceof Integer)) {
                return deviceIdBag;
            }
            return getOrDefault((Integer) obj, deviceIdBag);
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put(((Number) obj).intValue(), (DeviceIdBag) obj2);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, obj, obj2)) == null) {
            if (!(obj instanceof Integer) || !(obj2 instanceof DeviceIdBag)) {
                return false;
            }
            return remove((Integer) obj, (DeviceIdBag) obj2);
        }
        return invokeLL.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, parcel, i) == null) {
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
}
