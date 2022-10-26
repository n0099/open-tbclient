package com.baidu.searchbox.live.util;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ListUbc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM = "liveshow";
    public static final String KEY_ID_REACH_LIVEROOM = "4081";
    public static final String UBC_TYPE_REACH = "reach";
    public static ListUbc instance;
    public transient /* synthetic */ FieldHolder $fh;
    public UBCManager ubc;

    public ListUbc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public static ListUbc getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (ListUbc.class) {
                    if (instance == null) {
                        instance = new ListUbc();
                    }
                }
            }
            return instance;
        }
        return (ListUbc) invokeV.objValue;
    }

    public void reportReachEvent(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, str5, jSONObject}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (TextUtils.isEmpty(str5)) {
                    str5 = StringUtil.NULL_STRING;
                }
                if (str5 != null && str5.trim().length() == 0) {
                    str5 = "space";
                }
                jSONObject2.put("from", "liveshow");
                jSONObject2.put("page", str3);
                jSONObject2.put("source", str5);
                jSONObject2.putOpt("type", str2);
                jSONObject2.putOpt("value", str4);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject2.putOpt("ext", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubc.onEvent(str, jSONObject2);
        }
    }
}
