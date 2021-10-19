package com.baidu.fsg.face.liveness.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestConstant;
import com.baidu.fsg.base.restnet.beans.business.core.utils.ABTestUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LivenessABTestUtil {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static LivenessABTestUtil f40310a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ABTestUtils f40311b;

    public LivenessABTestUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized void cleanInstance() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (LivenessABTestUtil.class) {
                f40310a = null;
            }
        }
    }

    public static synchronized LivenessABTestUtil getInstance(Context context) {
        InterceptResult invokeL;
        LivenessABTestUtil livenessABTestUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (LivenessABTestUtil.class) {
                if (f40310a == null) {
                    f40310a = new LivenessABTestUtil(context);
                }
                livenessABTestUtil = f40310a;
            }
            return livenessABTestUtil;
        }
        return (LivenessABTestUtil) invokeL.objValue;
    }

    public JSONObject getLivenessBgStyleABTestContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ABTestUtils aBTestUtils = this.f40311b;
            if (aBTestUtils != null) {
                return aBTestUtils.getABTestStatistics("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0");
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean isWhiteBgEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ABTestUtils aBTestUtils = this.f40311b;
            if (aBTestUtils != null) {
                return "1".equals(aBTestUtils.getABTestValueString("1", ABTestConstant.LIVENESS_BG_STYLE_EXP_KEY_LIVENESS_BG_STYLE, "0"));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LivenessABTestUtil(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40311b = new ABTestUtils(context);
    }
}
