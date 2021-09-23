package com.baidu.swan.apps.event;

import androidx.annotation.Keep;
import c.a.p0.a.c1.a;
import c.a.p0.a.k;
import c.a.p0.a.m2.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes6.dex */
public class SwanJSVersionUpdateEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SwanJSVersionUpdateEven";
    public transient /* synthetic */ FieldHolder $fh;
    public final long mVersionCode;
    public final String mVersionName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1520484730, "Lcom/baidu/swan/apps/event/SwanJSVersionUpdateEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1520484730, "Lcom/baidu/swan/apps/event/SwanJSVersionUpdateEvent;");
                return;
            }
        }
        DEBUG = k.f7085a;
    }

    public SwanJSVersionUpdateEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SwanCoreVersion g2 = b.g(0);
        if (g2 != null) {
            this.mVersionCode = g2.swanCoreVersionCode;
            this.mVersionName = g2.swanCoreVersionName;
            return;
        }
        this.mVersionCode = 0L;
        this.mVersionName = null;
    }

    public static void sendEvent(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j2) == null) {
            SwanJSVersionUpdateEvent swanJSVersionUpdateEvent = new SwanJSVersionUpdateEvent();
            if (swanJSVersionUpdateEvent.mVersionName == null) {
                return;
            }
            a.I().a(swanJSVersionUpdateEvent);
            if (DEBUG) {
                String str = "send SwanJSVersionUpdateEvent, downVersion:" + j2 + ", getVersion:" + swanJSVersionUpdateEvent.getVersionName() + "(" + swanJSVersionUpdateEvent.getVersionCode() + SmallTailInfo.EMOTION_SUFFIX;
            }
        }
    }

    public long getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mVersionCode : invokeV.longValue;
    }

    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVersionName : (String) invokeV.objValue;
    }
}
