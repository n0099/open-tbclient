package com.baidu.searchbox.afx;

import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AlphaVideoManager {
    public static /* synthetic */ Interceptable $ic;
    public static OnReportListener sOnReportListener;
    public transient /* synthetic */ FieldHolder $fh;

    public AlphaVideoManager() {
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

    public static OnReportListener getOnReportListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? sOnReportListener : (OnReportListener) invokeV.objValue;
    }

    public static void setOnReportListener(OnReportListener onReportListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, onReportListener) == null) {
            sOnReportListener = onReportListener;
        }
    }
}
