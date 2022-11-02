package com.baidu.searchbox.common.security;

import android.content.Context;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke", "com/baidu/searchbox/common/security/DeviceInfoManager$getDeviceInfo$1$1"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoManager$getDeviceInfo$$inlined$apply$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ int $deviceFlag$inlined;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ boolean $forceApi$inlined;
    public final /* synthetic */ String $purpose$inlined;
    public final /* synthetic */ String $scene$inlined;
    public final /* synthetic */ DeviceIdBagMap $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoManager$getDeviceInfo$$inlined$apply$lambda$1(DeviceIdBagMap deviceIdBagMap, int i, boolean z, Context context, String str, String str2) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {deviceIdBagMap, Integer.valueOf(i), Boolean.valueOf(z), context, str, str2};
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
        this.$deviceFlag$inlined = i;
        this.$forceApi$inlined = z;
        this.$context$inlined = context;
        this.$scene$inlined = str;
        this.$purpose$inlined = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        boolean z;
        DeviceIdBagMap deviceIdBagMap;
        SparseArray sparseArray;
        DeviceIdBagMap deviceIdBagMap2;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            boolean z2 = true;
            if ((this.$deviceFlag$inlined & i) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 66) == 0) {
                z2 = false;
            }
            if (z && z2) {
                if (this.$forceApi$inlined) {
                    DeviceIdBagMap deviceIdBagMap3 = this.$this_apply;
                    sparseArray3 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                    deviceIdBagMap3.put(i, (DeviceIdBag) ((Function3) sparseArray3.get(i)).invoke(this.$context$inlined, this.$scene$inlined, this.$purpose$inlined));
                    return;
                }
                DeviceIdBagMap deviceIdBagMap4 = this.$this_apply;
                DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                deviceIdBagMap2 = DeviceInfoManager.mDeviceInfoMap;
                DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap2.get((Object) Integer.valueOf(i));
                if (deviceIdBag == null) {
                    sparseArray2 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                    deviceIdBag = (DeviceIdBag) ((Function3) sparseArray2.get(i)).invoke(this.$context$inlined, this.$scene$inlined, this.$purpose$inlined);
                }
                Intrinsics.checkNotNullExpressionValue(deviceIdBag, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
                deviceIdBagMap4.put(i, deviceIdBag);
            } else if (z) {
                DeviceIdBagMap deviceIdBagMap5 = this.$this_apply;
                DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.INSTANCE;
                deviceIdBagMap = DeviceInfoManager.mDeviceInfoMap;
                DeviceIdBag deviceIdBag2 = (DeviceIdBag) deviceIdBagMap.get((Object) Integer.valueOf(i));
                if (deviceIdBag2 == null) {
                    sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                    deviceIdBag2 = (DeviceIdBag) ((Function3) sparseArray.get(i)).invoke(this.$context$inlined, this.$scene$inlined, this.$purpose$inlined);
                }
                Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
                deviceIdBagMap5.put(i, deviceIdBag2);
            }
        }
    }
}
