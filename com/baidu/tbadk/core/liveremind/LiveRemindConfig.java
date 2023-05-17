package com.baidu.tbadk.core.liveremind;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LiveRemindConfig {
    public static /* synthetic */ Interceptable $ic;
    public static volatile LiveRemindConfig d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public long c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Scene {
        public static final /* synthetic */ Scene[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Scene LIVE_BUBBLE;
        public static final Scene LIVE_FLOAT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1670276783, "Lcom/baidu/tbadk/core/liveremind/LiveRemindConfig$Scene;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1670276783, "Lcom/baidu/tbadk/core/liveremind/LiveRemindConfig$Scene;");
                    return;
                }
            }
            LIVE_BUBBLE = new Scene("LIVE_BUBBLE", 0);
            Scene scene = new Scene("LIVE_FLOAT", 1);
            LIVE_FLOAT = scene;
            $VALUES = new Scene[]{LIVE_BUBBLE, scene};
        }

        public Scene(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Scene valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Scene) Enum.valueOf(Scene.class, str);
            }
            return (Scene) invokeL.objValue;
        }

        public static Scene[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Scene[]) $VALUES.clone();
            }
            return (Scene[]) invokeV.objValue;
        }
    }

    public LiveRemindConfig() {
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

    public static LiveRemindConfig c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (LiveRemindConfig.class) {
                    if (d == null) {
                        d = new LiveRemindConfig();
                    }
                }
            }
            return d;
        }
        return (LiveRemindConfig) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public void e(LiveRemindRecommendData liveRemindRecommendData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, liveRemindRecommendData) == null) && liveRemindRecommendData != null) {
            this.a = liveRemindRecommendData.getDayMaxNum();
            this.b = liveRemindRecommendData.getSingleOpenMaxNum();
            this.c = liveRemindRecommendData.getMinStepSecond();
        }
    }
}
