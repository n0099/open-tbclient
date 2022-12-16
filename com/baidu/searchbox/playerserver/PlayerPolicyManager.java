package com.baidu.searchbox.playerserver;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class PlayerPolicyManager {
    public static /* synthetic */ Interceptable $ic;
    public static final PlayerPolicyManager ourInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public IPlayerPolicy mPlayerPolicy;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1082226958, "Lcom/baidu/searchbox/playerserver/PlayerPolicyManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1082226958, "Lcom/baidu/searchbox/playerserver/PlayerPolicyManager;");
                return;
            }
        }
        ourInstance = new PlayerPolicyManager();
    }

    public PlayerPolicyManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPlayerPolicy = null;
        this.mPlayerPolicy = new PlayerPolicyImplement();
    }

    public static PlayerPolicyManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ourInstance;
        }
        return (PlayerPolicyManager) invokeV.objValue;
    }

    public void stop() {
        IPlayerPolicy iPlayerPolicy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (iPlayerPolicy = this.mPlayerPolicy) != null) {
            iPlayerPolicy.stop();
        }
    }

    public void update() {
        IPlayerPolicy iPlayerPolicy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (iPlayerPolicy = this.mPlayerPolicy) != null) {
            iPlayerPolicy.start();
        }
    }

    public void notify(String str) {
        IPlayerPolicy iPlayerPolicy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (iPlayerPolicy = this.mPlayerPolicy) != null) {
            iPlayerPolicy.notify(str);
        }
    }

    public void register(IPlayerConfig iPlayerConfig) {
        IPlayerPolicy iPlayerPolicy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iPlayerConfig) == null) && (iPlayerPolicy = this.mPlayerPolicy) != null) {
            iPlayerPolicy.register(iPlayerConfig);
        }
    }

    public void unregister(IPlayerConfig iPlayerConfig) {
        IPlayerPolicy iPlayerPolicy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, iPlayerConfig) == null) && (iPlayerPolicy = this.mPlayerPolicy) != null) {
            iPlayerPolicy.unregister(iPlayerConfig);
        }
    }
}
