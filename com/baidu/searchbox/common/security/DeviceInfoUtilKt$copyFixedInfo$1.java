package com.baidu.searchbox.common.security;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoUtilKt$copyFixedInfo$1 extends Lambda implements Function1<Integer, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ int $deviceFlag;
    public final /* synthetic */ CacheDeviceInfo $dst;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ DeviceIdBagMap $src;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoUtilKt$copyFixedInfo$1(int i, CacheDeviceInfo cacheDeviceInfo, DeviceIdBagMap deviceIdBagMap) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), cacheDeviceInfo, deviceIdBagMap};
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
        this.$deviceFlag = i;
        this.$dst = cacheDeviceInfo;
        this.$src = deviceIdBagMap;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (this.$deviceFlag & i) != 0) {
            CacheDeviceInfo cacheDeviceInfo = this.$dst;
            DeviceIdBag deviceIdBag = (DeviceIdBag) this.$src.get((Object) Integer.valueOf(i));
            if (deviceIdBag != null) {
                str = deviceIdBag.deviceId;
            } else {
                str = null;
            }
            cacheDeviceInfo.setDeviceInfo(str, i);
        }
    }
}
