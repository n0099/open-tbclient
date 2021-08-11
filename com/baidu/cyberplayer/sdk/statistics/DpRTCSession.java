package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes5.dex */
public class DpRTCSession {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f38994a;

    public DpRTCSession() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38994a = new c(DpStatConstants.SESSION_TYPE_RTC_COMMON);
    }

    private synchronized JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            synchronized (this) {
                this.f38994a.a(jSONObject);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static synchronized void uploadSession(int i2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i2, hashMap) == null) {
            synchronized (DpRTCSession.class) {
                if (hashMap != null) {
                    if (hashMap.size() > 0) {
                        DpRTCSession dpRTCSession = new DpRTCSession();
                        dpRTCSession.add(i2, hashMap);
                        dpRTCSession.upload();
                    }
                }
            }
        }
    }

    public synchronized void add(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
            synchronized (this) {
                if (20488 == i2) {
                    this.f38994a.a(new e((int) DpStatConstants.SESSION_TYPE_RTC_COMMON, str, str2));
                }
            }
        }
    }

    public synchronized void add(int i2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, hashMap) == null) {
            synchronized (this) {
                if (hashMap != null) {
                    if (hashMap.size() > 0) {
                        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                            add(i2, entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
        }
    }

    public synchronized String toJson() {
        InterceptResult invokeV;
        String jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    a.a().a(jSONObject2);
                    jSONObject2.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_RTC);
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject3 = new JSONObject();
                    a(jSONObject3);
                    jSONArray.put(jSONObject3);
                    jSONObject2.put("items", jSONArray);
                    jSONObject = jSONObject2.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONObject2.remove("cuid");
                CyberLog.i("DpRTCSession", "toJson rtc session = " + jSONObject2.toString());
            }
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void upload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                DpSessionDatasUploader.getInstance().upload(toJson(), "sailor_monitor");
            }
        }
    }
}
