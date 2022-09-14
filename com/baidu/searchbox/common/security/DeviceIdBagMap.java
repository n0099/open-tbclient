package com.baidu.searchbox.common.security;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "Landroid/os/Parcelable;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "describeContents", "()I", "getDeviceFlag", "deviceFlag", "", "isSync", "(I)Z", "key", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "value", "put", "(ILcom/baidu/searchbox/common/security/DeviceIdBag;)Lcom/baidu/searchbox/common/security/DeviceIdBag;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "(Landroid/os/Parcel;)V", "()V", "CREATOR", "lib-security-framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceIdBagMap extends ConcurrentHashMap<Integer, DeviceIdBag> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final CREATOR CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceIdBagMap$CREATOR;", "android/os/Parcelable$Creator", "Landroid/os/Parcel;", "parcel", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "createFromParcel", "(Landroid/os/Parcel;)Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "", "size", "", "newArray", "(I)[Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "<init>", "()V", "lib-security-framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class CREATOR implements Parcelable.Creator<DeviceIdBagMap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new DeviceIdBagMap[i] : (DeviceIdBagMap[]) invokeI.objValue;
        }
    }

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

    public static /* synthetic */ boolean isSync$default(DeviceIdBagMap deviceIdBagMap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = deviceIdBagMap.getDeviceFlag();
        }
        return deviceIdBagMap.isSync(i);
    }

    public /* bridge */ boolean containsKey(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, num)) == null) ? super.containsKey((Object) num) : invokeL.booleanValue;
    }

    public /* bridge */ boolean containsValue(DeviceIdBag deviceIdBag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, deviceIdBag)) == null) ? super.containsValue((Object) deviceIdBag) : invokeL.booleanValue;
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

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Integer, DeviceIdBag>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getEntries() : (Set) invokeV.objValue;
    }

    public /* bridge */ DeviceIdBag get(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, num)) == null) ? (DeviceIdBag) super.get((Object) num) : (DeviceIdBag) invokeL.objValue;
    }

    public final int getDeviceFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = 0;
            for (Integer deviceFlag : keySet()) {
                Intrinsics.checkNotNullExpressionValue(deviceFlag, "deviceFlag");
                i |= deviceFlag.intValue();
            }
            return i;
        }
        return invokeV.intValue;
    }

    public /* bridge */ Set getEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? super.entrySet() : (Set) invokeV.objValue;
    }

    public /* bridge */ Set getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? super.keySet() : (Set) invokeV.objValue;
    }

    public /* bridge */ DeviceIdBag getOrDefault(Integer num, DeviceIdBag deviceIdBag) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, num, deviceIdBag)) == null) ? (DeviceIdBag) super.getOrDefault((Object) num, (Integer) deviceIdBag) : (DeviceIdBag) invokeLL.objValue;
    }

    public /* bridge */ int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? super.size() : invokeV.intValue;
    }

    public /* bridge */ Collection getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? super.values() : (Collection) invokeV.objValue;
    }

    public final boolean isSync(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (((~getDeviceFlag()) & i) != 0) {
                return false;
            }
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            DeviceInfoUtilKt.forEachDevice(new DeviceIdBagMap$isSync$1(this, i, booleanRef));
            return booleanRef.element;
        }
        return invokeI.booleanValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Integer> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getKeys() : (Set) invokeV.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put(((Number) obj).intValue(), (DeviceIdBag) obj2);
    }

    public /* bridge */ DeviceIdBag remove(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, num)) == null) ? (DeviceIdBag) super.remove((Object) num) : (DeviceIdBag) invokeL.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? getSize() : invokeV.intValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<DeviceIdBag> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getValues() : (Collection) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, parcel, i) == null) {
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
                Intrinsics.checkNotNullExpressionValue(deviceIdBag, "this");
                put(readInt2, deviceIdBag);
            }
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Integer) {
                return containsKey((Integer) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof DeviceIdBag) {
                return containsValue((DeviceIdBag) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, obj, obj2)) == null) ? obj instanceof Integer ? getOrDefault((Integer) obj, (DeviceIdBag) obj2) : obj2 : invokeLL.objValue;
    }

    public DeviceIdBag put(int i, DeviceIdBag value) {
        InterceptResult invokeIL;
        DeviceIdBag deviceIdBag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, value)) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (DeviceIdBagMap.class) {
                deviceIdBag = (DeviceIdBag) super.put((DeviceIdBagMap) Integer.valueOf(i), (Integer) value);
            }
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeIL.objValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public /* bridge */ boolean remove(Integer num, DeviceIdBag deviceIdBag) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, num, deviceIdBag)) == null) ? super.remove((Object) num, (Object) deviceIdBag) : invokeLL.booleanValue;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, obj, obj2)) == null) {
            if ((obj instanceof Integer) && (obj2 instanceof DeviceIdBag)) {
                return remove((Integer) obj, (DeviceIdBag) obj2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
