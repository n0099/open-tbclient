package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.StatService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DataCore {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    public static DataCore f35388b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f35389c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f35390d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f35391e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35392f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f35393g;

    /* renamed from: h  reason: collision with root package name */
    public StatService.WearListener f35394h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f35395i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35396j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1751348443, "Lcom/baidu/mobstat/dxmpay/DataCore;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1751348443, "Lcom/baidu/mobstat/dxmpay/DataCore;");
                return;
            }
        }
        a = new JSONObject();
        f35388b = new DataCore();
    }

    public DataCore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35389c = new JSONArray();
        this.f35390d = new JSONArray();
        this.f35391e = new JSONArray();
        this.f35392f = false;
        this.f35393g = 0;
        this.f35396j = new Object();
    }

    private void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, jSONObject) == null) {
        }
    }

    private void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, context, jSONObject, jSONObject2) == null) {
        }
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65542, this, context, jSONObject, z) != null) || jSONObject == null) {
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, jSONObject) == null) {
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) ? (str.getBytes().length + BDStatCore.instance().getSessionSize()) + this.f35393g > 184320 : invokeL.booleanValue;
    }

    public static DataCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f35388b : (DataCore) invokeV.objValue;
    }

    public void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            a(false);
            synchronized (a) {
                a = new JSONObject();
            }
            installHeader(context);
            a(context);
        }
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            HeadObject headObject = CooperService.instance().getHeadObject();
            if (TextUtils.isEmpty(headObject.f35416f)) {
                headObject.installHeader(context, jSONObject2);
            } else {
                headObject.updateHeader(context, jSONObject2);
            }
            JSONArray jSONArray = new JSONArray();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2.put("t", currentTimeMillis);
                jSONObject2.put("ss", currentTimeMillis);
                jSONObject2.put("wl2", jSONArray);
                jSONObject2.put("sq", 0);
                jSONObject2.put("sign", CooperService.instance().getUUID());
                jSONObject2.put("k", str);
                jSONObject.put("he", jSONObject2);
                jSONObject.put("pr", jSONArray);
                jSONObject.put("ev", jSONArray);
                jSONObject.put("ex", jSONArray);
                return jSONObject.toString();
            } catch (JSONException | Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void flush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                synchronized (this.f35389c) {
                    jSONObject.put("pr", new JSONArray(this.f35389c.toString()));
                }
                synchronized (this.f35390d) {
                    jSONObject.put("ev", new JSONArray(this.f35390d.toString()));
                }
                synchronized (a) {
                    jSONObject.put("he", new JSONObject(a.toString()));
                }
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            if (a()) {
                h.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
                return;
            }
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                a(true);
                return;
            }
            this.f35393g = length;
            String k = w.k(context);
            o.a(context, k + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
            synchronized (this.f35391e) {
                o.a(context, Config.LAST_AP_INFO_FILE_NAME, this.f35391e.toString(), false);
            }
        }
    }

    public int getCacheFileSzie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35393g : invokeV.intValue;
    }

    public JSONObject getLogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35395i : (JSONObject) invokeV.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            instance().loadWifiData(context);
            instance().loadStatData(context);
            instance().loadLastSession(context);
            instance().installHeader(context);
        }
    }

    public void installHeader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            synchronized (a) {
                CooperService.instance().getHeadObject().installHeader(context, a);
            }
        }
    }

    public void loadLastSession(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || context == null) {
            return;
        }
        String str = w.k(context) + Config.LAST_SESSION_FILE_NAME;
        if (o.c(context, str)) {
            String a2 = o.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            o.a(context, str, new JSONObject().toString(), false);
            putSession(a2);
            flush(context);
        }
    }

    public void loadStatData(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, context) == null) || context == null) {
            return;
        }
        String str = w.k(context) + Config.STAT_CACHE_FILE_NAME;
        if (o.c(context, str)) {
            String a2 = o.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(a2);
            } catch (Exception unused) {
            }
            if (jSONObject == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("pr");
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (currentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                            putSession(jSONObject2);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ev");
                if (jSONArray2 != null) {
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        if (currentTimeMillis - jSONObject3.getLong("t") <= 604800000) {
                            putEvent(context, jSONObject3);
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("he");
                if (jSONObject4 != null) {
                    synchronized (a) {
                        a = jSONObject4;
                        q.a().i(context, "");
                    }
                }
            } catch (Exception unused4) {
            }
        }
    }

    public void loadWifiData(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, context) != null) || context == null) {
        }
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            h.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.f35390d) {
            EventAnalysis.doEventMerge(this.f35390d, jSONObject);
        }
    }

    public void putSession(Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, session) == null) {
            putSession(session.constructJSONObject());
        }
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            saveLogData(context, z, z2, j2, z3, null);
        }
    }

    public void saveLogDataAndSendForRaven(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            synchronized (this.f35396j) {
            }
        }
    }

    public void sendDataForDueros(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
        }
    }

    public void putSession(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            h.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.f35389c) {
            try {
                this.f35389c.put(this.f35389c.length(), jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j2, boolean z3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2), Boolean.valueOf(z3), jSONObject}) == null) {
            HeadObject headObject = CooperService.instance().getHeadObject();
            if (headObject != null) {
                synchronized (a) {
                    if (TextUtils.isEmpty(headObject.f35416f)) {
                        headObject.installHeader(context, a);
                    } else {
                        headObject.updateHeader(context, a);
                    }
                }
                if (TextUtils.isEmpty(headObject.f35416f)) {
                    h.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            synchronized (a) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    String optString = a.optString("at");
                    String optString2 = a.optString("uid");
                    if (!TextUtils.isEmpty(optString) && optString.equals("0")) {
                        if (!optString2.equals(CooperService.instance().getLastUserId(context))) {
                            a.put(Config.UID_CHANGE, optString2);
                        } else {
                            a.put(Config.UID_CHANGE, "");
                        }
                        CooperService.instance().setLastUserId(context, optString2);
                    }
                    a.put("t", currentTimeMillis);
                    a.put("sq", z ? 0 : 1);
                    a.put("ss", j2);
                    synchronized (this.f35391e) {
                        a.put("wl2", this.f35391e);
                    }
                    a.put("sign", CooperService.instance().getUUID());
                    a(context, a, jSONObject);
                    jSONObject2.put("he", a);
                    synchronized (this.f35389c) {
                        try {
                            jSONObject2.put("pr", this.f35389c);
                            synchronized (this.f35390d) {
                                try {
                                    jSONObject2.put("ev", this.f35390d);
                                    try {
                                        jSONObject2.put("ex", new JSONArray());
                                        a(context, jSONObject2, z2);
                                        a(jSONObject2);
                                        a(context, jSONObject2);
                                        a(context, jSONObject2.toString(), z, z3);
                                        this.f35395i = jSONObject2;
                                        clearCache(context);
                                    } catch (JSONException unused) {
                                    }
                                } catch (JSONException unused2) {
                                }
                            }
                        } catch (JSONException unused3) {
                        }
                    }
                } catch (Exception unused4) {
                }
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            this.f35392f = z;
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.f35392f : invokeV.booleanValue;
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            StatService.WearListener wearListener = this.f35394h;
            if (wearListener != null && wearListener.onSendLogData(str)) {
                h c2 = h.c();
                c2.a("Log has been passed to app level, log: " + str);
                return;
            }
            LogSender.instance().saveLogData(context, str, false);
            h c3 = h.c();
            c3.a("Save log: " + str);
        }
    }

    public void putSession(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && !TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                putSession(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            synchronized (this.f35390d) {
                this.f35390d = new JSONArray();
            }
            synchronized (this.f35389c) {
                this.f35389c = new JSONArray();
            }
            synchronized (this.f35391e) {
                this.f35391e = new JSONArray();
            }
            flush(context);
        }
    }

    public void a(StatService.WearListener wearListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wearListener) == null) {
            this.f35394h = wearListener;
        }
    }
}
