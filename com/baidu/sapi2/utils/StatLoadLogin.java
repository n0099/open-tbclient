package com.baidu.sapi2.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class StatLoadLogin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IS_LOAD_CACHE = "is_load_cache";
    public static final String KEY_LOAD_LOGIN = "t_load_login";
    public static final String KEY_START_LOGIN = "t_start_login";
    public static final String KEY_TIME_BEFORE_LOGIN = "t_before_login";
    public static final String KEY_TIME_OPEN_LOGIN = "t_open_login";
    public static final String KEY_TIME_WEBVIEW_INIT_DONE = "t_view_init_done";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isLoadCache;
    public long tBeforeLogin;
    public long tLoadLogin;
    public long tOpenLoginPage;
    public long tStartLogin;
    public long tWebviewInitDone;

    public StatLoadLogin() {
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

    public JSONObject toJSON() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_TIME_OPEN_LOGIN, this.tOpenLoginPage);
                jSONObject.put(KEY_TIME_WEBVIEW_INIT_DONE, this.tWebviewInitDone);
                jSONObject.put(KEY_TIME_BEFORE_LOGIN, this.tBeforeLogin);
                jSONObject.put(KEY_START_LOGIN, this.tStartLogin);
                jSONObject.put(KEY_LOAD_LOGIN, this.tLoadLogin);
                jSONObject.put(KEY_IS_LOAD_CACHE, this.isLoadCache);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
