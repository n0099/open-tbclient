package com.baidu.swan.apps.event;

import android.util.Log;
import androidx.annotation.Keep;
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
import com.repackage.n93;
import com.repackage.pj2;
import com.repackage.sg1;
@Keep
/* loaded from: classes2.dex */
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
        DEBUG = sg1.a;
    }

    public SwanJSVersionUpdateEvent() {
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
        SwanCoreVersion g = n93.g(0);
        if (g != null) {
            this.mVersionCode = g.swanCoreVersionCode;
            this.mVersionName = g.swanCoreVersionName;
            return;
        }
        this.mVersionCode = 0L;
        this.mVersionName = null;
    }

    public static void sendEvent(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            SwanJSVersionUpdateEvent swanJSVersionUpdateEvent = new SwanJSVersionUpdateEvent();
            if (swanJSVersionUpdateEvent.mVersionName == null) {
                return;
            }
            pj2.N().a(swanJSVersionUpdateEvent);
            if (DEBUG) {
                Log.d(TAG, "send SwanJSVersionUpdateEvent, downVersion:" + j + ", getVersion:" + swanJSVersionUpdateEvent.getVersionName() + "(" + swanJSVersionUpdateEvent.getVersionCode() + SmallTailInfo.EMOTION_SUFFIX);
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
