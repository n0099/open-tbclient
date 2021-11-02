package com.baidu.fsg.base.restnet.beans.business.core.utils;

import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ExceptionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ExceptionUtils() {
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

    public static String createStackTrackMessage(Exception exc) {
        InterceptResult invokeL;
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, exc)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (exc != null) {
                stringBuffer.append(exc.getClass());
                stringBuffer.append(": ");
                stringBuffer.append(exc.getMessage());
                stringBuffer.append(org.apache.commons.lang3.StringUtils.LF);
                for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                    stringBuffer.append(TrackUI.SEPERATOR);
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(org.apache.commons.lang3.StringUtils.LF);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
