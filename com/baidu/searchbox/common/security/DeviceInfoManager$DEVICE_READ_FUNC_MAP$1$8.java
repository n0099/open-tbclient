package com.baidu.searchbox.common.security;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "context", "Landroid/content/Context;", "scene", "", "purpose", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8 extends Lambda implements Function3 {
    public static /* synthetic */ Interceptable $ic;
    public static final DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(616013689, "Lcom/baidu/searchbox/common/security/DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(616013689, "Lcom/baidu/searchbox/common/security/DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8;");
                return;
            }
        }
        INSTANCE = new DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8() {
        super(3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function3
    public final DeviceIdBag invoke(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        DeviceIdBag readHarmonyVersion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            readHarmonyVersion = DeviceInfoManager.INSTANCE.readHarmonyVersion(context, scene, purpose);
            return readHarmonyVersion;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }
}
