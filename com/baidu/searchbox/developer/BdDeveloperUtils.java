package com.baidu.searchbox.developer;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class BdDeveloperUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String API_KEY = "T9UCyRzS7RQsG1Q8TqUTCjp2";
    public static final String APPID = "405384";
    public static final String MEIZU_PUSH_APPID = "111252";
    public static final String MEIZU_PUSH_APPKEY = "2138dd4a87a94fe6b92b0d4359665832";
    public static final String NTP_SERVER = "time.apple.com";
    public static final int NTP_TIME_OUT_MS = 30000;
    public static final String OPPO_PUSH_APPKEY = "ZVmQC5dJBtC4TWrAqYobsa3X";
    public static final String OPPO_PUSH_APPSECRET = "Oto2VBhQ0LmyYg0ZiM17BZyO";
    public static final String SECRET_KEY = "3cZkzgwRMgP9PfXzjf3a75mdldFYs3m4";
    public static final String XIAOMI_PUSH_APPID = "2882303761517132673";
    public static final String XIAOMI_PUSH_APPKEY = "5391713263673";
    public transient /* synthetic */ FieldHolder $fh;

    public BdDeveloperUtils() {
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
}
