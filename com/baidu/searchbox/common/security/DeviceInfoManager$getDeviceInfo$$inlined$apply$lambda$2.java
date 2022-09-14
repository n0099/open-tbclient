package com.baidu.searchbox.common.security;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke", "com/baidu/searchbox/common/security/DeviceInfoManager$getDeviceInfo$result$1$1"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoManager$getDeviceInfo$$inlined$apply$lambda$2 extends Lambda implements Function1<Integer, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ int $deviceFlag$inlined;
    public final /* synthetic */ Ref.ObjectRef $deviceInfo;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ boolean $forceApi$inlined;
    public final /* synthetic */ Ref.IntRef $needSyncDeviceFlag;
    public final /* synthetic */ String $purpose$inlined;
    public final /* synthetic */ String $scene$inlined;
    public final /* synthetic */ DeviceIdBagMap $this_apply;
    public final /* synthetic */ boolean $useMapping$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoManager$getDeviceInfo$$inlined$apply$lambda$2(DeviceIdBagMap deviceIdBagMap, Ref.ObjectRef objectRef, Ref.IntRef intRef, int i, boolean z, Context context, String str, String str2, boolean z2) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {deviceIdBagMap, objectRef, intRef, Integer.valueOf(i), Boolean.valueOf(z), context, str, str2, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$this_apply = deviceIdBagMap;
        this.$deviceInfo = objectRef;
        this.$needSyncDeviceFlag = intRef;
        this.$deviceFlag$inlined = i;
        this.$forceApi$inlined = z;
        this.$context$inlined = context;
        this.$scene$inlined = str;
        this.$purpose$inlined = str2;
        this.$useMapping$inlined = z2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v46, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v47, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v50, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v51, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(int i) {
        DeviceIdBagMap deviceIdBagMap;
        SparseArray sparseArray;
        DeviceIdBagMap deviceIdBagMap2;
        SparseArray sparseArray2;
        T t;
        SparseArray sparseArray3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            boolean z = (this.$deviceFlag$inlined & i) != 0;
            boolean z2 = (i & 66) != 0;
            if (!z || !z2) {
                if (z) {
                    Ref.ObjectRef objectRef = this.$deviceInfo;
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                    deviceIdBagMap = DeviceInfoManager.mDeviceInfoMap;
                    DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap.get((Object) Integer.valueOf(i));
                    T t2 = deviceIdBag;
                    if (deviceIdBag == null) {
                        sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                        t2 = (DeviceIdBag) ((Function3) sparseArray.get(i)).invoke(this.$context$inlined, this.$scene$inlined, this.$purpose$inlined);
                    }
                    objectRef.element = t2;
                    if (this.$useMapping$inlined) {
                        T t3 = this.$deviceInfo.element;
                        if (((DeviceIdBag) t3).errorCode != 3 && !TextUtils.isEmpty(((DeviceIdBag) t3).deviceId)) {
                            this.$needSyncDeviceFlag.element |= i;
                        }
                    }
                    this.$this_apply.put(i, (DeviceIdBag) this.$deviceInfo.element);
                    return;
                }
                return;
            }
            Ref.ObjectRef objectRef2 = this.$deviceInfo;
            if (this.$forceApi$inlined) {
                sparseArray3 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                t = (DeviceIdBag) ((Function3) sparseArray3.get(i)).invoke(this.$context$inlined, this.$scene$inlined, this.$purpose$inlined);
            } else {
                DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.INSTANCE;
                deviceIdBagMap2 = DeviceInfoManager.mDeviceInfoMap;
                DeviceIdBag deviceIdBag2 = (DeviceIdBag) deviceIdBagMap2.get((Object) Integer.valueOf(i));
                DeviceIdBag deviceIdBag3 = deviceIdBag2;
                if (deviceIdBag2 == null) {
                    sparseArray2 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                    deviceIdBag3 = (DeviceIdBag) ((Function3) sparseArray2.get(i)).invoke(this.$context$inlined, this.$scene$inlined, this.$purpose$inlined);
                }
                Intrinsics.checkNotNullExpressionValue(deviceIdBag3, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
                t = deviceIdBag3;
            }
            objectRef2.element = t;
            if (this.$useMapping$inlined) {
                T t4 = this.$deviceInfo.element;
                if (((DeviceIdBag) t4).errorCode != 3 && !TextUtils.isEmpty(((DeviceIdBag) t4).deviceId)) {
                    this.$needSyncDeviceFlag.element |= i;
                }
            }
            this.$this_apply.put(i, (DeviceIdBag) this.$deviceInfo.element);
        }
    }
}
