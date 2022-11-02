package com.baidu.searchbox.aideviceperformance.utils;

import com.baidu.android.util.UniKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DeviceInfoSharedPreferenceWrapper extends UniKV {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SP_FILE_DEFAULT = "com.baidu.searchbox.device_info_sp";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final DeviceInfoSharedPreferenceWrapper INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1987897477, "Lcom/baidu/searchbox/aideviceperformance/utils/DeviceInfoSharedPreferenceWrapper$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1987897477, "Lcom/baidu/searchbox/aideviceperformance/utils/DeviceInfoSharedPreferenceWrapper$Holder;");
                    return;
                }
            }
            INSTANCE = new DeviceInfoSharedPreferenceWrapper(null);
        }

        public Holder() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoSharedPreferenceWrapper() {
        super(SP_FILE_DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static DeviceInfoSharedPreferenceWrapper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Holder.INSTANCE;
        }
        return (DeviceInfoSharedPreferenceWrapper) invokeV.objValue;
    }

    public /* synthetic */ DeviceInfoSharedPreferenceWrapper(AnonymousClass1 anonymousClass1) {
        this();
    }
}
