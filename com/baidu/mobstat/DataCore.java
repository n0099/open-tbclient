package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DataCore {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject a;
    public static String b;
    public static DataCore c;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray d;
    public JSONArray e;
    public JSONArray f;
    public boolean g;
    public volatile int h;
    public StatService.WearListener i;
    public JSONObject j;
    public Object k;
    public boolean l;
    public HashMap<String, String> m;
    public List<String> n;
    public JSONObject o;

    private void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, context, jSONObject) == null) {
        }
    }

    private void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, jSONObject) == null) {
        }
    }

    public void sendDataForDueros(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, context) == null) {
        }
    }

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
        a = new JSONObject();
        b = "";
        c = new DataCore();
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public static DataCore instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return c;
        }
        return (DataCore) invokeV.objValue;
    }

    public int getCacheFileSzie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public String getHeadSessionPy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.m.get(Config.SESSION_JSON_PY);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject getLogData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String getTempPyd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            JSONObject jSONObject = this.o;
            if (jSONObject != null && jSONObject.length() > 0) {
                return this.o.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public DataCore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new JSONArray();
        this.e = new JSONArray();
        this.f = new JSONArray();
        this.g = false;
        this.h = 0;
        this.k = new Object();
        this.l = false;
        this.m = new HashMap<>();
        this.n = Collections.synchronizedList(new ArrayList());
        this.o = new JSONObject();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(3:8|9|10)|(5:14|15|16|(2:(5:22|23|(2:27|28)|29|20)|32)|34)|36|15|16|(3:18|(1:20)|32)|34) */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:15:0x0029, B:17:0x0031, B:19:0x0037, B:21:0x003d), top: B:35:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
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
                i = 1;
                jSONArray = jSONObject.getJSONArray("pr");
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                        long j2 = jSONObject3.getLong("c");
                        if (jSONObject3.getLong("e") != 0 && j2 == 0) {
                            i++;
                        }
                    }
                }
                return i;
            }
            i = 0;
            jSONArray = jSONObject.getJSONArray("pr");
            if (jSONArray != null) {
                while (i2 < jSONArray.length()) {
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void clearProperty(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str.equals("0")) {
                this.m.put(Config.UID_PY, "");
            } else if (str.equals("1")) {
                this.m.put(Config.USER_PY, "");
            } else if (str.equals("2")) {
                this.m.put(Config.SESSION_PY, "");
                this.m.put(Config.SESSION_JSON_PY, "");
            } else if (str.equals("3")) {
                this.m.put(Config.EVENT_PY, "");
            } else if (str.equals("4")) {
                this.m.put(Config.PAGE_PY, "");
            }
        }
    }

    public void loadProperty(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            String u = bp.a().u(context);
            if (!TextUtils.isEmpty(u)) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(u);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray jSONArray = (JSONArray) jSONObject.get(next);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            hashMap.put(next, jSONArray.optString(0));
                        }
                    }
                } catch (Exception unused) {
                }
                if (hashMap.size() > 0) {
                    setPydProperty(context, bx.a(hashMap), "1", "1");
                }
            }
            String q = bp.a().q(context);
            if (!TextUtils.isEmpty(q)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uid_", q);
                setPydProperty(context, bx.a(hashMap2), "1", "0");
            }
        }
    }

    private JSONArray a(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            List arrayList = new ArrayList();
            String f = ac.a().f(context);
            boolean z = false;
            if (!TextUtils.isEmpty(f)) {
                try {
                    JSONArray jSONArray = new JSONArray(f);
                    if (jSONArray.length() != 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add((JSONObject) jSONArray.get(i));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((JSONObject) it.next()).getLong("day") == j) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("day", j);
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

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            synchronized (this.e) {
                this.e = new JSONArray();
            }
            synchronized (this.d) {
                this.d = new JSONArray();
            }
            synchronized (this.f) {
                this.f = new JSONArray();
            }
            flush(context);
        }
    }

    public void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            a(false);
            String optString = a.optString(Config.DEVICE_ID_SEC);
            if (!TextUtils.isEmpty(optString)) {
                bp.a().l(context, optString);
            }
            synchronized (a) {
                a = new JSONObject();
            }
            installHeader(context);
            a(context);
        }
    }

    public void putSession(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            bb.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.d) {
            try {
                this.d.put(this.d.length(), jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    private void a(Context context, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            StatService.WearListener wearListener = this.i;
            if (wearListener != null && wearListener.onSendLogData(str)) {
                bb c2 = bb.c();
                c2.a("Log has been passed to app level, log: " + str);
                return;
            }
            boolean z3 = false;
            LogSender.instance().saveLogData(context, str, false);
            bb c3 = bb.c();
            c3.a("Save log: " + str);
            if (z) {
                au.a(context);
                return;
            }
            if (av.a().b() == 0 && av.a().c()) {
                z3 = true;
            }
            au.a(context, z3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, long j, int i) {
        long longValue;
        String str;
        int i2;
        long intValue;
        String f;
        Object obj;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, jSONObject, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            long longValue2 = ac.a().b(context).longValue();
            if (longValue2 <= 0 && i != 0) {
                ac.a().a(context, j);
                longValue2 = j;
            }
            a(jSONObject, Config.TRACE_VISIT_FIRST, Long.valueOf(longValue2));
            if (i != 0) {
                long longValue3 = ac.a().c(context).longValue();
                longValue = j - longValue3;
                int i3 = (longValue3 > 0L ? 1 : (longValue3 == 0L ? 0 : -1));
                if (i3 != 0 && longValue <= 0) {
                    longValue = -1;
                } else if (i3 == 0) {
                    longValue = 0;
                }
                ac.a().b(context, j);
                ac.a().c(context, longValue);
            } else {
                longValue = ac.a().d(context).longValue();
            }
            a(jSONObject, Config.TRACE_VISIT_SESSION_LAST_INTERVAL, Long.valueOf(longValue));
            String e = ac.a().e(context);
            int i4 = 0;
            String str2 = "";
            if (TextUtils.isEmpty(e) || !e.contains(":") || (split = e.split(":")) == null || split.length != 2) {
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
            if (!TextUtils.isEmpty(str) && !a2.equals(str)) {
                i2 = i;
            } else {
                i2 = i + i4;
            }
            if (i != 0) {
                ac.a().a(context, a2 + ":" + i2);
            }
            a(jSONObject, Config.TRACE_VISIT_SESSION_TODAY_COUNT, Integer.valueOf(i2));
            if (!TextUtils.isEmpty(str)) {
                try {
                    intValue = Integer.valueOf(str).intValue();
                } catch (Exception unused2) {
                }
                if (intValue == 0 && !TextUtils.isEmpty(str) && !a2.equals(str) && i != 0) {
                    JSONArray a3 = a(context, intValue, i4);
                    ac.a().b(context, a3.toString());
                    a(jSONObject, Config.TRACE_VISIT_RECENT, a3);
                    return;
                }
                f = ac.a().f(context);
                obj = null;
                if (!TextUtils.isEmpty(f)) {
                    try {
                        obj = new JSONArray(f);
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
            f = ac.a().f(context);
            obj = null;
            if (!TextUtils.isEmpty(f)) {
            }
            if (obj == null) {
            }
            a(jSONObject, Config.TRACE_VISIT_RECENT, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        long j2;
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
                if (j != 0) {
                    j2 = System.currentTimeMillis();
                } else {
                    j2 = j;
                }
                a(context, jSONObject2, j2, a2);
            }
            j = 0;
            if (j != 0) {
            }
            a(context, jSONObject2, j2, a2);
        }
    }

    private void a(Context context, JSONObject jSONObject, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65545, this, context, jSONObject, z) != null) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        boolean z2 = true;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        try {
            jSONObject2.put(Config.TRACE_APPLICATION_SESSION, i);
        } catch (Exception unused) {
        }
        try {
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused2) {
        }
        try {
            jSONObject2.put(Config.TRACE_CIRCLE, ad.c());
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Exception unused4) {
            z2 = false;
        }
        if (!z2) {
            return;
        }
        a(context, jSONObject, jSONObject2);
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65546, this, jSONObject, str, obj) != null) || jSONObject == null) {
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

    private void b(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, this, context, jSONObject, jSONObject2) == null) && jSONObject != null && jSONObject.length() != 0 && jSONObject2 != null && jSONObject2.length() != 0) {
            try {
                jSONObject.put("launch", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.g = z;
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            instance().loadStatData(context);
            instance().loadLastSession(context);
            instance().installHeader(context);
        }
    }

    public void installHeader(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            synchronized (a) {
                CooperService.instance().getHeadObject().installHeader(context, a);
            }
        }
    }

    public void putSession(Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, session) == null) {
            putSession(session.constructJSONObject());
        }
    }

    public void saveLogDataAndSendForRaven(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            synchronized (this.k) {
            }
        }
    }

    public void updatePyd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                b = str;
                av.a().a(str);
            } catch (Exception unused) {
            }
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            if (str.getBytes().length + BDStatCore.instance().getSessionSize() + this.h > 184320) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void putSession(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && !TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                putSession(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    public void a(StatService.WearListener wearListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wearListener) == null) {
            this.i = wearListener;
        }
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            HeadObject headObject = CooperService.instance().getHeadObject();
            if (TextUtils.isEmpty(headObject.e)) {
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
                jSONObject2.put("k", str);
                jSONObject.put(Config.HEADER_PART, jSONObject2);
                jSONObject.put("pr", jSONArray);
                jSONObject.put(Config.EVENT_PART, jSONArray);
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
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                synchronized (this.d) {
                    jSONObject.put("pr", new JSONArray(this.d.toString()));
                }
                synchronized (this.e) {
                    jSONObject.put(Config.EVENT_PART, new JSONArray(this.e.toString()));
                }
                synchronized (a) {
                    jSONObject.put(Config.HEADER_PART, new JSONObject(a.toString()));
                }
                jSONObject.put(Config.PYD, b);
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            if (a()) {
                bb.c().a("[WARNING] stat cache exceed 184320 Bytes, ignored");
                return;
            }
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                a(true);
                return;
            }
            this.h = length;
            String s = bw.s(context);
            bn.a(context, s + Config.STAT_CACHE_FILE_NAME, jSONObject2, false);
            synchronized (this.f) {
                bn.a(context, Config.LAST_AP_INFO_FILE_NAME, this.f.toString(), false);
            }
        }
    }

    public void loadStatData(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, context) != null) || context == null) {
            return;
        }
        String str = bw.s(context) + Config.STAT_CACHE_FILE_NAME;
        if (!bn.c(context, str)) {
            return;
        }
        String a2 = bn.a(context, str);
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
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (currentTimeMillis - jSONObject2.getLong("s") <= 604800000) {
                        putSession(jSONObject2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(Config.EVENT_PART);
            if (jSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
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
                synchronized (a) {
                    a = jSONObject4;
                }
            }
        } catch (Exception unused4) {
        }
        try {
            String optString = jSONObject.optString(Config.PYD);
            if (TextUtils.isEmpty(optString)) {
                optString = "";
            }
            b = optString;
        } catch (Exception unused5) {
        }
    }

    public String getEventPy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.m.get(Config.EVENT_PY);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String sessionPy = getSessionPy();
            return replace(sessionPy + "_" + str, "_");
        }
        return (String) invokeV.objValue;
    }

    public String getPagePy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.m.get(Config.PAGE_PY);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String sessionPy = getSessionPy();
            return replace(sessionPy + "_" + str, "_");
        }
        return (String) invokeV.objValue;
    }

    public String getSessionPy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String str = this.m.get(Config.SESSION_PY);
            String str2 = this.m.get(Config.USER_PY);
            String str3 = this.m.get(Config.UID_PY);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            String replace = replace(str + "_" + str3, "_");
            return replace(replace + "_" + str2, "_");
        }
        return (String) invokeV.objValue;
    }

    public void loadLastSession(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, context) != null) || context == null) {
            return;
        }
        String str = bw.s(context) + Config.LAST_SESSION_FILE_NAME;
        if (!bn.c(context, str)) {
            return;
        }
        String a2 = bn.a(context, str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        bn.a(context, str, new JSONObject().toString(), false);
        putSession(a2);
        flush(context);
    }

    public void loadWifiData(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, context) != null) || context == null || !bn.c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(bn.a(context, Config.LAST_AP_INFO_FILE_NAME));
            int length = jSONArray.length();
            if (length >= 10) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i = length - 10; i < length; i++) {
                    jSONArray2.put(jSONArray.get(i));
                }
                jSONArray = jSONArray2;
            }
            String m = bw.m(2, context);
            if (!TextUtils.isEmpty(m)) {
                jSONArray.put(m);
            }
            synchronized (this.f) {
                this.f = jSONArray;
            }
        } catch (JSONException unused) {
        }
    }

    public void putEvent(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, context, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (a(jSONObject.toString())) {
            bb.c().b("[WARNING] data to put exceed limit, ignored");
            return;
        }
        synchronized (this.e) {
            EventAnalysis.doEventMerge(this.e, jSONObject);
        }
    }

    public String replace(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, str2)) == null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            if (str.endsWith(str2)) {
                str = str.substring(0, str.length() - 1);
            }
            str = str.replace(StringUtil.NULL_STRING, "");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Boolean.valueOf(z3)}) == null) {
            saveLogData(context, z, z2, j, z3, null);
        }
    }

    public void saveLogData(Context context, boolean z, boolean z2, long j, boolean z3, JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Boolean.valueOf(z3), jSONObject}) == null) {
            HeadObject headObject = CooperService.instance().getHeadObject();
            if (headObject != null) {
                synchronized (a) {
                    if (TextUtils.isEmpty(headObject.e)) {
                        headObject.installHeader(context, a);
                    } else {
                        headObject.updateHeader(context, a);
                    }
                }
                if (TextUtils.isEmpty(headObject.e)) {
                    bb.c().c("[WARNING] 无法找到有效APP Key, 请参考文档配置");
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
                    JSONObject jSONObject3 = a;
                    if (z) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    jSONObject3.put(Config.SEQUENCE_INDEX, i);
                    a.put("ss", j);
                    synchronized (this.f) {
                        a.put(Config.WIFI_LOCATION, this.f);
                    }
                    a.put("sign", CooperService.instance().getUUID());
                    b(context, a, jSONObject);
                    jSONObject2.put(Config.HEADER_PART, a);
                    synchronized (this.d) {
                        try {
                            jSONObject2.put("pr", this.d);
                            synchronized (this.e) {
                                try {
                                    jSONObject2.put(Config.EVENT_PART, this.e);
                                    try {
                                        jSONObject2.put(Config.EXCEPTION_PART, new JSONArray());
                                        try {
                                            jSONObject2.put(Config.PYD, b);
                                            a(context, jSONObject2, z2);
                                            b(jSONObject2);
                                            a(context, jSONObject2);
                                            a(context, jSONObject2.toString(), z, z3);
                                            this.j = jSONObject2;
                                            clearCache(context);
                                            if (!this.l) {
                                                this.l = true;
                                                updatePyd("");
                                                loadProperty(context);
                                                updatePyd(getTempPyd());
                                            }
                                        } catch (JSONException unused) {
                                        }
                                    } catch (JSONException unused2) {
                                    }
                                } catch (JSONException unused3) {
                                }
                            }
                        } catch (JSONException unused4) {
                        }
                    }
                } catch (Exception unused5) {
                }
            }
        }
    }

    public void setPydProperty(Context context, Map<String, String> map, String str, String str2) {
        String str3;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        JSONObject jSONObject;
        StringBuffer stringBuffer3;
        String str4;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, context, map, str, str2) == null) {
            String str5 = "k";
            try {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    if (map == null) {
                        clearProperty(str2);
                        return;
                    }
                    if (map.size() <= 100 && this.n.size() <= 100) {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        StringBuffer stringBuffer5 = new StringBuffer();
                        StringBuffer stringBuffer6 = new StringBuffer();
                        StringBuffer stringBuffer7 = new StringBuffer();
                        StringBuffer stringBuffer8 = new StringBuffer();
                        JSONObject jSONObject2 = new JSONObject();
                        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                        while (true) {
                            JSONObject jSONObject3 = jSONObject2;
                            StringBuffer stringBuffer9 = stringBuffer7;
                            String str6 = "2";
                            if (it.hasNext()) {
                                Map.Entry<String, String> next = it.next();
                                Iterator<Map.Entry<String, String>> it2 = it;
                                String key = next.getKey();
                                String value = next.getValue();
                                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                                    StringBuffer stringBuffer10 = stringBuffer8;
                                    if (key.length() <= 256 && value.length() <= 256) {
                                        JSONObject jSONObject4 = new JSONObject();
                                        jSONObject4.put(str5, key);
                                        jSONObject4.put("v", value);
                                        jSONObject4.put("s", str);
                                        boolean z = false;
                                        if (this.n.size() > 0) {
                                            stringBuffer3 = stringBuffer6;
                                            i = 0;
                                            while (i < this.n.size()) {
                                                str4 = str6;
                                                JSONObject jSONObject5 = new JSONObject(this.n.get(i));
                                                String optString = jSONObject5.optString(str5);
                                                str3 = str5;
                                                String optString2 = jSONObject5.optString("v");
                                                String optString3 = jSONObject5.optString("s");
                                                if (key.equals(optString) && value.equals(optString2) && str.equals(optString3)) {
                                                    break;
                                                }
                                                i++;
                                                str6 = str4;
                                                str5 = str3;
                                            }
                                            str3 = str5;
                                        } else {
                                            str3 = str5;
                                            stringBuffer3 = stringBuffer6;
                                        }
                                        str4 = str6;
                                        i = 0;
                                        z = true;
                                        if (this.n.size() > 100) {
                                            return;
                                        }
                                        if (z) {
                                            try {
                                                this.n.add(jSONObject4.toString());
                                                i = this.n.size() - 1;
                                                this.o.put(i + "", jSONObject4);
                                            } catch (Exception unused) {
                                            }
                                        }
                                        updatePropertyKey(str2, stringBuffer4, "0", i);
                                        updatePropertyKey(str2, stringBuffer5, "1", i);
                                        stringBuffer = stringBuffer3;
                                        String str7 = str4;
                                        updatePropertyKey(str2, stringBuffer, str7, i);
                                        stringBuffer2 = stringBuffer10;
                                        updatePropertyKey(str2, stringBuffer2, "3", i);
                                        stringBuffer7 = stringBuffer9;
                                        updatePropertyKey(str2, stringBuffer7, "4", i);
                                        if (str2.equals(str7)) {
                                            JSONArray jSONArray = new JSONArray();
                                            jSONArray.put(value);
                                            jSONArray.put(str7);
                                            jSONObject = jSONObject3;
                                            jSONObject.put(key, jSONArray);
                                        } else {
                                            jSONObject = jSONObject3;
                                        }
                                        stringBuffer8 = stringBuffer2;
                                        jSONObject2 = jSONObject;
                                        it = it2;
                                        stringBuffer6 = stringBuffer;
                                        str5 = str3;
                                    }
                                    str3 = str5;
                                    stringBuffer = stringBuffer6;
                                    jSONObject = jSONObject3;
                                    stringBuffer7 = stringBuffer9;
                                    stringBuffer2 = stringBuffer10;
                                    bb.c().c("[WARNING] setProperty failed,key or value can not over 256 bytes !");
                                    stringBuffer8 = stringBuffer2;
                                    jSONObject2 = jSONObject;
                                    it = it2;
                                    stringBuffer6 = stringBuffer;
                                    str5 = str3;
                                }
                                str3 = str5;
                                stringBuffer = stringBuffer6;
                                stringBuffer2 = stringBuffer8;
                                jSONObject = jSONObject3;
                                stringBuffer7 = stringBuffer9;
                                bb.c().c("[WARNING] setProperty failed,key or value can not null !");
                                stringBuffer8 = stringBuffer2;
                                jSONObject2 = jSONObject;
                                it = it2;
                                stringBuffer6 = stringBuffer;
                                str5 = str3;
                            } else {
                                StringBuffer stringBuffer11 = stringBuffer6;
                                StringBuffer stringBuffer12 = stringBuffer8;
                                String jSONObject6 = this.o.toString();
                                if (str2.equals("0") && !TextUtils.isEmpty(stringBuffer4)) {
                                    this.m.put(Config.UID_PY, stringBuffer4.toString());
                                } else if (str2.equals("1") && !TextUtils.isEmpty(stringBuffer5)) {
                                    this.m.put(Config.USER_PY, stringBuffer5.toString());
                                } else if (str2.equals("2") && !TextUtils.isEmpty(stringBuffer11)) {
                                    this.m.put(Config.SESSION_PY, stringBuffer11.toString());
                                    this.m.put(Config.SESSION_JSON_PY, jSONObject3.toString());
                                } else if (str2.equals("3") && !TextUtils.isEmpty(stringBuffer12)) {
                                    this.m.put(Config.EVENT_PY, stringBuffer12.toString());
                                } else if (str2.equals("4") && !TextUtils.isEmpty(stringBuffer9)) {
                                    this.m.put(Config.PAGE_PY, stringBuffer9.toString());
                                }
                                if (str2.equals("2")) {
                                    CooperService.instance().setHeaderPy(jSONObject3.toString());
                                }
                                if (this.l) {
                                    updatePyd(jSONObject6);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    public void updatePropertyKey(String str, StringBuffer stringBuffer, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048604, this, str, stringBuffer, str2, i) == null) && i >= 0 && str.equals(str2)) {
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.append("_");
            }
            stringBuffer.append(i);
        }
    }
}
