package com.baidu.live.business.model;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RequestUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ORI_STATE = 1;
    public static final int REFRESH_TYPE_BIG = 0;
    public static final int REFRESH_TYPE_SMALL = 1;
    public static final int REQ_STATE_BANNER = 1;
    public static final int REQ_STATE_FEED = 8;
    public static final int REQ_STATE_FOLLOW = 2;
    public static final int REQ_STATE_RESERVE = 16;
    public static final int REQ_STATE_TABS = 4;
    public static final int REQ_STATE_TOPIC = 32;
    public static int resource;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestUtil() {
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

    public static String getResourceParam() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if ((resource & 1) != 0) {
                str = "banner,";
            } else {
                str = "";
            }
            if ((resource & 2) != 0) {
                str = str + "follow,";
            }
            if ((resource & 4) != 0) {
                str = str + "tab,";
            }
            if ((resource & 8) != 0) {
                str = str + "feed,";
            }
            if ((resource & 16) != 0) {
                str = str + "reserve,";
            }
            if ((resource & 32) != 0) {
                str = str + "topic,";
            }
            return TextUtils.isEmpty(str) ? "" : str.substring(0, str.length() - 1);
        }
        return (String) invokeV.objValue;
    }

    public static void setResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            resource = i;
        }
    }
}
