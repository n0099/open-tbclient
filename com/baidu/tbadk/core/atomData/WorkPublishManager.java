package com.baidu.tbadk.core.atomData;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.s7a;
import com.baidu.tieba.vt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class WorkPublishManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_VIDEO_HOT_TOPIC = 8;
    public static String objLocate;
    public transient /* synthetic */ FieldHolder $fh;

    public WorkPublishManager() {
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

    public static String getObjLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return objLocate;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isWorkPublishLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!isWorkPublishLocateMyTab() && !isWorkPublishLocateVideoCenter()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isWorkPublishLocateMyTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return "5".equals(objLocate);
        }
        return invokeV.booleanValue;
    }

    public static boolean isWorkPublishLocateVideoCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return "6".equals(objLocate);
        }
        return invokeV.booleanValue;
    }

    public static void prepareToSend(String str, String str2, String str3, String str4, String str5) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65541, null, str, str2, str3, str4, str5) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        objLocate = str;
        if (str != null && str.equals("7")) {
            vt9.k(true);
            vt9.i(str2);
            i = 7;
        } else if (TextUtils.equals(str, "8")) {
            vt9.j(8);
            vt9.i(str2);
            i = 8;
        } else {
            i = 6;
        }
        if (s7a.b()) {
            s7a.h(null, null, null, null, i, Boolean.TRUE, str3, str4, str5);
            return;
        }
        s7a.k(false, false, null, null, null, null, i, Boolean.TRUE, str3, str4, str5);
    }

    public static void setObjLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            objLocate = str;
        }
    }
}
