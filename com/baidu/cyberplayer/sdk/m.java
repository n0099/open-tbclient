package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public static m a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-598477274, "Lcom/baidu/cyberplayer/sdk/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-598477274, "Lcom/baidu/cyberplayer/sdk/m;");
        }
    }

    public m() {
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

    public static synchronized m a() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
                mVar = a;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }

    public PlayerProvider a(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), httpDNS, Boolean.valueOf(z)})) == null) {
            PlayerProvider a2 = (!z || CyberCfgManager.getInstance().a("remote_forbidden", false)) ? null : com.baidu.cyberplayer.sdk.remote.h.a(i, httpDNS);
            if (a2 == null) {
                a2 = d.a(i, httpDNS);
            }
            if (a2 == null && CyberCfgManager.getInstance().getCfgBoolValue("enable_mediaplayer_sub_thread", true)) {
                a2 = j.a();
            }
            return a2 == null ? new k() : a2;
        }
        return (PlayerProvider) invokeCommon.objValue;
    }
}
