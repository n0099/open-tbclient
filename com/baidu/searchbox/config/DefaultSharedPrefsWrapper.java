package com.baidu.searchbox.config;

import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class DefaultSharedPrefsWrapper extends SharedPrefsWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SP_FILE_DEFAULT = "default";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.config.DefaultSharedPrefsWrapper$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final DefaultSharedPrefsWrapper INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(229615745, "Lcom/baidu/searchbox/config/DefaultSharedPrefsWrapper$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(229615745, "Lcom/baidu/searchbox/config/DefaultSharedPrefsWrapper$Holder;");
                    return;
                }
            }
            INSTANCE = new DefaultSharedPrefsWrapper(null);
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
    public DefaultSharedPrefsWrapper() {
        super("default");
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

    public static DefaultSharedPrefsWrapper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Holder.INSTANCE;
        }
        return (DefaultSharedPrefsWrapper) invokeV.objValue;
    }

    public /* synthetic */ DefaultSharedPrefsWrapper(AnonymousClass1 anonymousClass1) {
        this();
    }
}
