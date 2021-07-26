package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.StatService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DataCore {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f8538a;

    /* renamed from: b  reason: collision with root package name */
    public static DataCore f8539b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f8540c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f8541d;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f8542e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8543f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f8544g;

    /* renamed from: h  reason: collision with root package name */
    public StatService.WearListener f8545h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f8546i;
    public Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-805580151, "Lcom/baidu/mobstat/DataCore;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-805580151, "Lcom/baidu/mobstat/DataCore;");
                return;
            }
        }
        f8538a = new JSONObject();
        f8539b = new DataCore();
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
        this.f8540c = new JSONArray();
        this.f8541d = new JSONArray();
        this.f8542e = new JSONArray();
        this.f8543f = false;
        this.f8544g = 0;
        this.j = new Object();
    }

    private void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, jSONObject) == null) {
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? (str.getBytes().length + BDStatCore.instance().getSessionSize()) + this.f8544g > 184320 : invokeL.booleanValue;
    }

    private void b(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, this, context, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject.length() != 0 && jSONObject2 != null && jSONObject2.length() != 0) {
            try {
                jSONObject.put("launch", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, jSONObject) == null) {
        }
    }

    public static DataCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f8539b : (DataCore) invokeV.objValue;
    }

    public void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            a(false);
            synchronized (f8538a) {
                f8538a = new JSONObject();
            }
            installHeader(context);
            a(context);
        }
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            HeadObject headObject = CooperService.instance().getHeadObject();
            if (TextUtils.isEmpty(headObject.f8570e)) {
                headObject.installHeader(context, jSONObject2);
            } else {
                headObject.updateHeader(context, jSONObject2);
            }
            JSONArray jSONArray = new JSONArray();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2.put("t", currentTimeMillis);
                jSONObject2.put("ss", currentTimeMillis);
                jSONObject2.put(Config.WIFI_LOCATION, jSONArray);
                jSONObject2.put(Config.SEQUENCE_INDEX, 0);
                jSONObject2.put("sign", CooperService.instance().getUUID());
                jSONObject2.put(Config.APP_KEY, str);
                jSONObject.put(Config.HEADER_PART, jSONObject2);
                jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
                jSONObject.put("ev", jSONArray);
                jSONObject.put(Config.EXCEPTION_PART, jSONArray);
                return jSONObject.toString();
            } catch (JSONException | Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void flush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                synchronized (this.f8540c) {
                    jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f8540c.toString()));
                }
                synchronized (this.f8541d) {
                    jSONObject.put("ev", new JSONArray(this.f8541d.toString()));
                }
                synchronized (f8538a) {
                    jSONObject.put(Config.HEADER_PART, new JSONObject(f8538a.toString()));
                }
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            if (a()) {
                bc.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
                return;
            }
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                a(true);
                return;
            }
            this.f8544g = length;
            String u = bw.u(context);
            bo.a(context, u + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
            synchronized (this.f8542e) {
                bo.a(context, Config.LAST_AP_INFO_FILE_NAME, this.f8542e.toString(), false);
            }
        }
    }

    public int getCacheFileSzie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8544g : invokeV.intValue;
    }

    public JSONObject getLogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8546i : (JSONObject) invokeV.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            instance().loadStatData(context);
            instance().loadLastSession(context);
            instance().installHeader(context);
        }
    }

    public void installHeader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            synchronized (f8538a) {
                CooperService.instance().getHeadObject().installHeader(context, f8538a);
            }
        }
    }

    public void loadLastSession(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, context) == null) || context == null) {
            return;
        }
        String str = bw.u(context) + Config.LAST_SESSION_FILE_NAME;
        if (bo.c(context, str)) {
            String a2 = bo.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            bo.a(context, str, new JSONObject().toString(), false);
            putSession(a2);
            flush(context);
        }
    }

    public void loadStatData(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || context == null) {
            return;
        }
        String str = bw.u(context) + Config.STAT_CACHE_FILE_NAME;
        if (bo.c(context, str)) {
            String a2 = bo.a(context, str);
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
                JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
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
                JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
                if (jSONObject4 != null) {
                    synchronized (f8538a) {
                        f8538a = jSONObject4;
                        if (TextUtils.isEmpty(bq.a().s(context))) {
                            String string = f8538a.getString(Config.DEVICE_ID_SEC);
                            if (!TextUtils.isEmpty(string)) {
                                bq.a().k(context, string);
                            }
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
    }

    public void loadWifiData(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, context) == null) && context != null && bo.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray = new JSONArray(bo.a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray.length();
                if (length >= 10) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = length - 10; i2 < length; i2++) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                    jSONArray = jSONArray2;
                }
                String g2 = bw.g(1, context);
                if (!TextUtils.isEmpty(g2)) {
                    jSONArray.put(g2);
                }
                synchronized (this.f8542e) {
                    this.f8542e = jSONArray;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            bc.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.f8541d) {
            EventAnalysis.doEventMerge(this.f8541d, jSONObject);
        }
    }

    public void putSession(Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, session) == null) {
            putSession(session.constructJSONObject());
        }
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Boolean.valueOf(z3)}) == null) {
            saveLogData(context, z, z2, j, z3, null);
        }
    }

    public void saveLogDataAndSendForRaven(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            synchronized (this.j) {
            }
        }
    }

    public void sendDataForDueros(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
        }
    }

    public void putSession(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            bc.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.f8540c) {
            try {
                this.f8540c.put(this.f8540c.length(), jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Boolean.valueOf(z3), jSONObject}) == null) {
            HeadObject headObject = CooperService.instance().getHeadObject();
            if (headObject != null) {
                synchronized (f8538a) {
                    if (TextUtils.isEmpty(headObject.f8570e)) {
                        headObject.installHeader(context, f8538a);
                    } else {
                        headObject.updateHeader(context, f8538a);
                    }
                }
                if (TextUtils.isEmpty(headObject.f8570e)) {
                    bc.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            synchronized (f8538a) {
                try {
                    f8538a.put("t", System.currentTimeMillis());
                    f8538a.put(Config.SEQUENCE_INDEX, z ? 0 : 1);
                    f8538a.put("ss", j);
                    synchronized (this.f8542e) {
                        f8538a.put(Config.WIFI_LOCATION, this.f8542e);
                    }
                    f8538a.put("sign", CooperService.instance().getUUID());
                    b(context, f8538a, jSONObject);
                    jSONObject2.put(Config.HEADER_PART, f8538a);
                    synchronized (this.f8540c) {
                        try {
                            jSONObject2.put(Config.PRINCIPAL_PART, this.f8540c);
                            synchronized (this.f8541d) {
                                try {
                                    jSONObject2.put("ev", this.f8541d);
                                    try {
                                        jSONObject2.put(Config.EXCEPTION_PART, new JSONArray());
                                        a(context, jSONObject2, z2);
                                        b(jSONObject2);
                                        a(context, jSONObject2);
                                        a(context, jSONObject2.toString(), z, z3);
                                        this.f8546i = jSONObject2;
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
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.f8543f = z;
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.f8543f : invokeV.booleanValue;
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65545, this, context, jSONObject, z) == null) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        boolean z2 = true;
        try {
            jSONObject2.put(Config.TRACE_APPLICATION_SESSION, z ? 1 : 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused2) {
        }
        try {
            jSONObject2.put(Config.TRACE_CIRCLE, af.c());
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Exception unused4) {
            z2 = false;
        }
        if (z2) {
            a(context, jSONObject, jSONObject2);
        }
    }

    public void putSession(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                putSession(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        JSONObject jSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, context, jSONObject, jSONObject2) == null) {
            int a2 = a(jSONObject);
            try {
                jSONObject3 = jSONObject.getJSONObject(Config.HEADER_PART);
            } catch (Exception unused) {
            }
            if (jSONObject3 != null) {
                j = jSONObject3.getLong("ss");
                a(context, jSONObject2, j != 0 ? System.currentTimeMillis() : j, a2);
            }
            j = 0;
            a(context, jSONObject2, j != 0 ? System.currentTimeMillis() : j, a2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(3:8|9|10)|(5:14|15|16|(2:(5:22|23|(2:27|28)|29|20)|32)|34)|36|15|16|(3:18|(1:20)|32)|34) */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:15:0x0029, B:17:0x0031, B:19:0x0037, B:21:0x003d), top: B:35:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return 0;
            }
            try {
                jSONObject2 = jSONObject.getJSONObject(Config.HEADER_PART);
                j = jSONObject2.getLong(Config.SEQUENCE_INDEX);
            } catch (Exception unused) {
            }
            if (jSONObject2.getLong("ss") > 0 && j == 0) {
                i2 = 1;
                jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                        long j2 = jSONObject3.getLong("c");
                        if (jSONObject3.getLong("e") != 0 && j2 == 0) {
                            i2++;
                        }
                    }
                }
                return i2;
            }
            i2 = 0;
            jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
            if (jSONArray != null) {
                while (i3 < jSONArray.length()) {
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, long j, int i2) {
        long longValue;
        String str;
        long intValue;
        String f2;
        Object obj;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, jSONObject, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            long longValue2 = ae.a().b(context).longValue();
            if (longValue2 <= 0 && i2 != 0) {
                ae.a().a(context, j);
                longValue2 = j;
            }
            a(jSONObject, Config.TRACE_VISIT_FIRST, Long.valueOf(longValue2));
            if (i2 != 0) {
                long longValue3 = ae.a().c(context).longValue();
                longValue = j - longValue3;
                int i3 = (longValue3 > 0L ? 1 : (longValue3 == 0L ? 0 : -1));
                if (i3 != 0 && longValue <= 0) {
                    longValue = -1;
                } else if (i3 == 0) {
                    longValue = 0;
                }
                ae.a().b(context, j);
                ae.a().c(context, longValue);
            } else {
                longValue = ae.a().d(context).longValue();
            }
            a(jSONObject, Config.TRACE_VISIT_SESSION_LAST_INTERVAL, Long.valueOf(longValue));
            String e2 = ae.a().e(context);
            int i4 = 0;
            String str2 = "";
            if (TextUtils.isEmpty(e2) || !e2.contains(":") || (split = e2.split(":")) == null || split.length != 2) {
                str = "";
            } else {
                String str3 = split[0];
                str2 = split[1];
                str = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    i4 = Integer.valueOf(str2).intValue();
                } catch (Exception unused) {
                }
            }
            String a2 = bx.a(j);
            int i5 = (TextUtils.isEmpty(str) || a2.equals(str)) ? i2 + i4 : i2;
            if (i2 != 0) {
                ae.a().a(context, a2 + ":" + i5);
            }
            a(jSONObject, Config.TRACE_VISIT_SESSION_TODAY_COUNT, Integer.valueOf(i5));
            if (!TextUtils.isEmpty(str)) {
                try {
                    intValue = Integer.valueOf(str).intValue();
                } catch (Exception unused2) {
                }
                if (intValue == 0 && !TextUtils.isEmpty(str) && !a2.equals(str) && i2 != 0) {
                    JSONArray a3 = a(context, intValue, i4);
                    ae.a().b(context, a3.toString());
                    a(jSONObject, Config.TRACE_VISIT_RECENT, a3);
                    return;
                }
                f2 = ae.a().f(context);
                obj = null;
                if (!TextUtils.isEmpty(f2)) {
                    try {
                        obj = new JSONArray(f2);
                    } catch (Exception unused3) {
                    }
                }
                if (obj == null) {
                    obj = new JSONArray();
                }
                a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
            }
            intValue = 0;
            if (intValue == 0) {
            }
            f2 = ae.a().f(context);
            obj = null;
            if (!TextUtils.isEmpty(f2)) {
            }
            if (obj == null) {
            }
            a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
        }
    }

    private JSONArray a(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            List arrayList = new ArrayList();
            String f2 = ae.a().f(context);
            boolean z = false;
            if (!TextUtils.isEmpty(f2)) {
                try {
                    JSONArray jSONArray = new JSONArray(f2);
                    if (jSONArray.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add((JSONObject) jSONArray.get(i2));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((JSONObject) it.next()).getLong(Config.TRACE_VISIT_RECENT_DAY) == j) {
                    break;
                }
            }
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Config.TRACE_VISIT_RECENT_DAY, j);
                    jSONObject.put("count", j2);
                    arrayList.add(jSONObject);
                } catch (Exception unused2) {
                }
            }
            int size = arrayList.size();
            if (size > 5) {
                arrayList = arrayList.subList(size - 5, size);
            }
            return new JSONArray((Collection) arrayList);
        }
        return (JSONArray) invokeCommon.objValue;
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, this, jSONObject, str, obj) == null) || jSONObject == null) {
            return;
        }
        if (!jSONObject.has(Config.TRACE_VISIT)) {
            try {
                jSONObject.put(Config.TRACE_VISIT, new JSONObject());
            } catch (Exception unused) {
            }
        }
        try {
            ((JSONObject) jSONObject.get(Config.TRACE_VISIT)).put(str, obj);
        } catch (Exception unused2) {
        }
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            StatService.WearListener wearListener = this.f8545h;
            if (wearListener != null && wearListener.onSendLogData(str)) {
                bc c2 = bc.c();
                c2.a("Log has been passed to app level, log: " + str);
                return;
            }
            LogSender.instance().saveLogData(context, str, false);
            bc c3 = bc.c();
            c3.a("Save log: " + str);
            if (z) {
                if (z2) {
                    av.a(context);
                } else {
                    av.a(context, true);
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            synchronized (this.f8541d) {
                this.f8541d = new JSONArray();
            }
            synchronized (this.f8540c) {
                this.f8540c = new JSONArray();
            }
            synchronized (this.f8542e) {
                this.f8542e = new JSONArray();
            }
            flush(context);
        }
    }
}
