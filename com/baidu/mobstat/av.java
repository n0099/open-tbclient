package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.mobstat.at;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class av {
    public static /* synthetic */ Interceptable $ic;
    public static av b;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public HandlerThread c;
    public Handler d;
    public volatile int e;
    public int f;
    public JSONObject g;
    public JSONArray h;
    public JSONArray i;
    public JSONArray j;
    public JSONArray k;
    public boolean m;
    public List<JSONObject> n;
    public List<String> o;
    public List<String> p;

    /* loaded from: classes2.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    private void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, jSONObject) == null) {
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657501, "Lcom/baidu/mobstat/av;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657501, "Lcom/baidu/mobstat/av;");
                return;
            }
        }
        b = new av();
        l = "";
    }

    public static av a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return (av) invokeV.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.f++;
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.f = 0;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public av() {
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
        this.c = new HandlerThread("fullTraceHandleThread");
        this.g = new JSONObject();
        this.h = new JSONArray();
        this.i = new JSONArray();
        this.j = new JSONArray();
        this.k = new JSONArray();
        this.m = false;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.c.start();
        this.c.setPriority(10);
        this.d = new Handler(this.c.getLooper());
    }

    private long a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return 0L;
            }
            try {
                return jSONArray.getJSONObject(0).optLong("s");
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, context) == null) {
            this.i = b(this.i, BDStatCore.instance().getPageSessionHead());
            b(context, false);
            d();
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            CooperService.instance().getHeadObject().installHeader(context, this.g);
        }
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, this, context, str)) == null) {
            if (str != null) {
                i = str.getBytes().length;
            } else {
                i = 0;
            }
            if (i + this.e <= 184320) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, this, context, str) == null) {
            LogSender.instance().saveLogData(context, str, true);
            if (this.a != null) {
                try {
                    this.a.a(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j, String str, String str2, String str3, int i, long j2, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, Long.valueOf(j), str, str2, str3, Integer.valueOf(i), Long.valueOf(j2), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7, jSONArray3}) == null) {
            a(context, EventAnalysis.getEvent(context, j, str, str2, str3, i, j2, 0L, "", null, null, bi.a(str4), bi.a(str5), str6, Config.EventViewType.EDIT.getValue(), 3, null, map, bi.c(jSONArray), bi.d(jSONArray2), z, jSONObject, str7, jSONArray3));
            c(context);
        }
    }

    private void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, this, context, jSONArray) == null) && context != null && this.j != null && jSONArray != null && jSONArray.length() != 0) {
            if (bg.c().b()) {
                bg c = bg.c();
                c.a("putFeedList: " + jSONArray.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (b(context, jSONArray2)) {
                if (bg.c().b()) {
                    bg c2 = bg.c();
                    c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONArray2.length());
                }
                d(context);
            }
            a(this.j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(2:12|13)|(6:29|30|16|17|(2:22|23)|(1:20))|15|16|17|(0)|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray b(JSONArray jSONArray, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        JSONObject jSONObject4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, jSONArray, jSONObject)) == null) {
            if (jSONObject != null && jSONArray != null) {
                if (jSONObject.optLong("s") <= 0) {
                    return jSONArray;
                }
                JSONArray jSONArray3 = new JSONArray();
                JSONObject jSONObject5 = null;
                if (jSONArray.length() == 0) {
                    try {
                        jSONObject2 = new JSONObject(jSONObject.toString());
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject2.put("p", new JSONArray());
                    } catch (Exception unused2) {
                        jSONObject5 = jSONObject2;
                        jSONObject2 = jSONObject5;
                        if (jSONObject2 != null) {
                        }
                        return jSONArray3;
                    }
                    if (jSONObject2 != null) {
                        jSONArray3.put(jSONObject2);
                    }
                } else {
                    try {
                        jSONObject3 = jSONArray.getJSONObject(0);
                    } catch (Exception unused3) {
                        jSONObject3 = null;
                    }
                    if (jSONObject3 != null) {
                        try {
                            jSONArray2 = jSONObject3.getJSONArray("p");
                        } catch (Exception unused4) {
                        }
                        jSONObject4 = new JSONObject(jSONObject.toString());
                        if (jSONArray2 != null) {
                            try {
                                jSONObject4.put("p", jSONArray2);
                            } catch (Exception unused5) {
                                jSONObject5 = jSONObject4;
                                jSONObject4 = jSONObject5;
                                if (jSONObject4 != null) {
                                }
                                return jSONArray3;
                            }
                        }
                        if (jSONObject4 != null) {
                            jSONArray3.put(jSONObject4);
                        }
                    }
                    jSONArray2 = null;
                    jSONObject4 = new JSONObject(jSONObject.toString());
                    if (jSONArray2 != null) {
                    }
                    if (jSONObject4 != null) {
                    }
                }
                return jSONArray3;
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    private void d(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65568, this, context, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (bg.c().b()) {
            bg c = bg.c();
            c.a("putPage: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (b(context, jSONObject2)) {
            if (bg.c().b()) {
                bg c2 = bg.c();
                c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        a(this.i, jSONObject);
    }

    private void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, this, context, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (bg.c().b()) {
            bg c = bg.c();
            c.a("putEvent: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (b(context, jSONObject2)) {
            if (bg.c().b()) {
                bg c2 = bg.c();
                c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        try {
            jSONObject.put(Config.EVENT_NEXT_PAGENAME, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventAnalysis.doEventMerge(this.h, jSONObject);
    }

    private void b(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, this, context, jSONArray) == null) && context != null && this.k != null && jSONArray != null && jSONArray.length() != 0) {
            if (bg.c().b()) {
                bg c = bg.c();
                c.a("putFeedListItem: " + jSONArray.toString());
            }
            String jSONArray2 = jSONArray.toString();
            if (b(context, jSONArray2)) {
                if (bg.c().b()) {
                    bg c2 = bg.c();
                    c2.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.e + "; addedSize:" + jSONArray2.length());
                }
                d(context);
            }
            b(this.k, jSONArray);
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, this, jSONArray, jSONArray2) == null) && jSONArray != null && jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                try {
                    jSONArray.put(jSONArray2.getJSONObject(i));
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    private void c(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65564, this, context, jSONObject) != null) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put(Config.TRACE_PART, jSONObject2);
        } catch (Exception unused2) {
        }
    }

    public void b(Context context, ArrayList<ap> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, context, arrayList) != null) || CooperService.instance().isCloseTrace() || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable(this, context, arrayList) { // from class: com.baidu.mobstat.av.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ ArrayList b;
            public final /* synthetic */ av c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, arrayList};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = context;
                this.b = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.d(this.a, this.b);
            }
        });
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, jSONArray, jSONObject) == null) {
            JSONArray jSONArray2 = null;
            try {
                jSONObject2 = jSONArray.getJSONObject(0);
            } catch (Exception unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    jSONArray2 = jSONObject2.optJSONArray("p");
                } catch (Exception unused2) {
                }
            }
            if (jSONArray2 == null) {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(jSONObject);
                if (jSONObject2 != null) {
                    try {
                        jSONObject2.put("p", jSONArray3);
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                return;
            }
            jSONArray2.put(jSONObject);
        }
    }

    public void c(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, context, z) == null) {
            this.g = new JSONObject();
            b(context);
            this.i = new JSONArray();
            this.h = new JSONArray();
            this.j = new JSONArray();
            this.k = new JSONArray();
            if (!z) {
                at.a().b();
            }
            c(context);
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, str, str2)) == null) {
            if (str == str2) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, jSONObject, jSONObject2)) == null) {
            if (jSONObject != null && jSONObject2 != null) {
                String optString = jSONObject.optString("id");
                jSONObject.optString("d");
                String optString2 = jSONObject.optString("p");
                String optString3 = jSONObject.optString("path");
                String optString4 = jSONObject.optString("title");
                String optString5 = jSONObject.optString("index");
                String optString6 = jSONObject.optString("n");
                int optInt = jSONObject.optInt("user");
                jSONObject.optInt("c");
                jSONObject.optLong("t");
                jSONObject.optString("ps");
                String optString7 = jSONObject2.optString("id");
                jSONObject2.optString("d");
                String optString8 = jSONObject2.optString("p");
                String optString9 = jSONObject2.optString("path");
                String optString10 = jSONObject2.optString("title");
                String optString11 = jSONObject2.optString("index");
                String optString12 = jSONObject2.optString("n");
                int optInt2 = jSONObject2.optInt("user");
                jSONObject2.optInt("c");
                jSONObject2.optLong("t");
                jSONObject2.optString("ps");
                if (!a(optString, optString7) || !a(optString2, optString8) || !a(optString3, optString9) || !a(optString4, optString10) || !a(optString5, optString11) || !a(optString6, optString12) || optInt != optInt2) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, context, z) == null) {
            try {
                if (z) {
                    e();
                } else {
                    d();
                }
                try {
                    b(context, this.g);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.h.length() == 0 && this.i.length() == 0 && this.j.length() == 0 && this.k.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.HEADER_PART, this.g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put(Config.PRINCIPAL_PART, this.i);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put(Config.EVENT_PART, this.h);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put(Config.FEED_LIST_PART, this.j);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("sv", this.k);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                jSONObject.put(Config.EVENT_PAGE_MAPPING, at.a().a(at.a.b));
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                jSONObject.put(Config.EVENT_PATH_MAPPING, at.a().a(at.a.a));
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            try {
                jSONObject.put("sd", at.a().a(at.a.c));
            } catch (Exception e9) {
                e9.printStackTrace();
            }
            try {
                jSONObject.put(Config.PYD, l);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            c(context, jSONObject);
            b(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (bg.c().b()) {
                bg c = bg.c();
                c.a("saveCurrentCacheToSend content: " + jSONObject2);
            }
            c(context, jSONObject2);
            c(context, !z);
            this.m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, an anVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, this, context, anVar) == null) && context != null && anVar != null) {
            JSONArray b2 = b(this.i, BDStatCore.instance().getPageSessionHead());
            this.i = b2;
            if (b2.length() == 0) {
                return;
            }
            long a2 = a(this.i);
            if (a2 <= 0) {
                return;
            }
            d(context, anVar.a(a2, at.a().a(anVar.a(), at.a.b), at.a().a(anVar.b(), at.a.c)));
            c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ArrayList<ao> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65563, this, context, arrayList) == null) && context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ao> it = arrayList.iterator();
            while (it.hasNext()) {
                ao next = it.next();
                JSONObject a2 = next.a(at.a().a(next.a(), at.a.c));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            a(context, jSONArray);
            c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ArrayList<ap> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65567, this, context, arrayList) == null) && context != null && arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<ap> it = arrayList.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                JSONObject a2 = next.a(at.a().a(next.b(), at.a.b), at.a().a(next.f(), at.a.c), bi.c(next.c()));
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            b(context, jSONArray);
            c(context);
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, context, jSONObject) == null) {
            CooperService.instance().getHeadObject().installHeader(context, jSONObject);
            try {
                jSONObject.put("t", System.currentTimeMillis());
                jSONObject.put(Config.SEQUENCE_INDEX, this.f);
                jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
                jSONObject.put("at", "1");
                jSONObject.put("sign", CooperService.instance().getUUID());
                jSONObject.put(Config.PY, DataCore.instance().getHeadSessionPy());
                jSONObject.put(Config.PLT, CooperService.instance().getPlatformType());
            } catch (Exception unused) {
            }
        }
    }

    public void a(Context context, String str) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) != null) || (jSONArray = this.h) == null || jSONArray.length() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            JSONObject jSONObject = (JSONObject) this.h.get(this.h.length() - 1);
            if (jSONObject != null) {
                String optString = jSONObject.optString(Config.EVENT_NEXT_PAGENAME);
                long optLong = jSONObject.optLong("t");
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - optLong <= 1500 && TextUtils.isEmpty(optString)) {
                    jSONObject.put(Config.EVENT_NEXT_PAGENAME, str + "|" + currentTimeMillis);
                    this.h.put(this.h.length() + (-1), jSONObject);
                    c(context);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65558, this, jSONArray, jSONArray2) == null) && jSONArray != null && jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i);
                    if (jSONObject != null && jSONObject.length() != 0) {
                        JSONObject jSONObject2 = null;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            if (jSONObject3 != null && jSONObject3.length() != 0 && a(jSONObject3, jSONObject)) {
                                jSONObject2 = jSONObject3;
                                break;
                            }
                            i2++;
                        }
                        if (jSONObject2 == null) {
                            jSONArray.put(jSONObject);
                        } else {
                            b(jSONObject2, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        String str;
        String str2;
        String str3;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, this, jSONObject, jSONObject2) == null) {
            String optString = jSONObject.optString("d");
            int optInt = jSONObject.optInt("c");
            long optLong = jSONObject.optLong("t");
            String optString2 = jSONObject.optString("ps");
            String optString3 = jSONObject2.optString("d");
            int optInt2 = jSONObject2.optInt("c");
            long optLong2 = jSONObject2.optLong("t");
            String optString4 = jSONObject2.optString("ps");
            int i = optInt + optInt2;
            int i2 = (optLong > optLong2 ? 1 : (optLong == optLong2 ? 0 : -1));
            if (i2 <= 0) {
                j = optLong;
            } else {
                j = optLong2;
            }
            if (i2 <= 0) {
                str = "ps";
                str2 = optString + "|" + optString3;
            } else {
                str = "ps";
                str2 = optString3 + "|" + optString;
            }
            int i3 = 0;
            long j4 = 0;
            if (i2 <= 0) {
                long j5 = optLong2 - optLong;
                StringBuilder sb = new StringBuilder();
                String[] split = optString4.split(WebChromeClient.PARAM_SEPARATOR);
                if (split != null && split.length != 0) {
                    int length = split.length;
                    while (i3 < length) {
                        String str4 = split[i3];
                        if (!TextUtils.isEmpty(sb.toString())) {
                            sb.append("|");
                        }
                        try {
                            j3 = Long.valueOf(str4).longValue();
                        } catch (Exception unused) {
                            j3 = 0;
                        }
                        sb.append(j3 + j5);
                        i3++;
                    }
                } else {
                    try {
                        j4 = Long.valueOf(optString4).longValue();
                    } catch (Exception unused2) {
                    }
                    sb.append(j5 + j4);
                }
                str3 = optString2 + "|" + sb.toString();
            } else {
                long j6 = optLong - optLong2;
                StringBuilder sb2 = new StringBuilder();
                String[] split2 = optString2.split(WebChromeClient.PARAM_SEPARATOR);
                if (split2 != null && split2.length != 0) {
                    int length2 = split2.length;
                    while (i3 < length2) {
                        String str5 = split2[i3];
                        if (!TextUtils.isEmpty(sb2.toString())) {
                            sb2.append("|");
                        }
                        try {
                            j2 = Long.valueOf(str5).longValue();
                        } catch (Exception unused3) {
                            j2 = 0;
                        }
                        sb2.append(j2 + j6);
                        i3++;
                    }
                } else {
                    try {
                        j4 = Long.valueOf(optString2).longValue();
                    } catch (Exception unused4) {
                    }
                    sb2.append(j6 + j4);
                }
                str3 = optString4 + "|" + sb2.toString();
            }
            try {
                jSONObject.put("c", i);
                jSONObject.put("t", j);
                jSONObject.put("d", str2);
                jSONObject.put(str, str3);
            } catch (Exception unused5) {
            }
        }
    }

    public void a(Context context) {
        String str;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || context == null) {
            return;
        }
        try {
            this.m = true;
            e();
            str = bw.s(context) + Config.STAT_FULL_CACHE_FILE_NAME;
        } catch (Throwable th) {
            th.printStackTrace();
        }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        try {
            optJSONArray = jSONObject.optJSONArray(Config.EVENT_PART);
            optJSONArray2 = jSONObject.optJSONArray(Config.PRINCIPAL_PART);
            optJSONArray3 = jSONObject.optJSONArray(Config.FEED_LIST_PART);
            optJSONArray4 = jSONObject.optJSONArray("sv");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ((optJSONArray != null && optJSONArray.length() != 0) || ((optJSONArray2 != null && optJSONArray2.length() != 0) || ((optJSONArray3 != null && optJSONArray3.length() != 0) || (optJSONArray4 != null && optJSONArray4.length() != 0)))) {
            b(context, jSONObject.getJSONObject(Config.HEADER_PART));
            c(context, jSONObject);
            b(jSONObject);
            a2 = jSONObject.toString();
            if (bg.c().b()) {
                bg.c().a("saveLastCacheToSend content: " + a2);
            }
            c(context, a2);
            c(context, false);
            this.m = false;
            return;
        }
        if (bg.c().b()) {
            bg.c().a("saveLastCacheToSend content:empty, return");
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Config.HEADER_PART, new JSONObject(this.g.toString()));
                    jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.i.toString()));
                    jSONObject.put(Config.EVENT_PART, new JSONArray(this.h.toString()));
                    jSONObject.put(Config.FEED_LIST_PART, new JSONArray(this.j.toString()));
                    jSONObject.put("sv", new JSONArray(this.k.toString()));
                    jSONObject.put(Config.PYD, l);
                    jSONObject.put(Config.EVENT_PAGE_MAPPING, at.a().a(at.a.b));
                    jSONObject.put(Config.EVENT_PATH_MAPPING, at.a().a(at.a.a));
                    jSONObject.put("sd", at.a().a(at.a.c));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String jSONObject2 = jSONObject.toString();
                int length = jSONObject2.getBytes().length;
                if (length >= 184320) {
                    return;
                }
                this.e = length;
                String s = bw.s(context);
                bn.a(context, s + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
            } catch (Throwable th) {
                th.printStackTrace();
                StatService.closeTrace();
            }
        }
    }

    public void a(Context context, an anVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, anVar) != null) || CooperService.instance().isCloseTrace() || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable(this, context, anVar) { // from class: com.baidu.mobstat.av.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ an b;
            public final /* synthetic */ av c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, anVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = context;
                this.b = anVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || BDStatCore.instance().getSessionStartTime() <= 0) {
                    return;
                }
                this.c.b(this.a, this.b);
            }
        });
    }

    public void a(Context context, String str, String str2, String str3, int i, long j, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, JSONObject jSONObject, String str7, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, str3, Integer.valueOf(i), Long.valueOf(j), str4, jSONArray, str5, jSONArray2, str6, map, jSONObject, str7, jSONArray3}) == null) {
            a(context, str, str2, str3, i, j, str4, jSONArray, str5, jSONArray2, str6, map, false, jSONObject, str7, jSONArray3);
        }
    }

    public void a(Context context, String str, String str2, String str3, int i, long j, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{context, str, str2, str3, Integer.valueOf(i), Long.valueOf(j), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7, jSONArray3}) != null) || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable(this, context, str, str2, str3, i, j, str4, jSONArray, str5, jSONArray2, str6, map, z, jSONObject, str7, jSONArray3) { // from class: com.baidu.mobstat.av.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ int e;
            public final /* synthetic */ long f;
            public final /* synthetic */ String g;
            public final /* synthetic */ JSONArray h;
            public final /* synthetic */ String i;
            public final /* synthetic */ JSONArray j;
            public final /* synthetic */ String k;
            public final /* synthetic */ Map l;
            public final /* synthetic */ boolean m;
            public final /* synthetic */ JSONObject n;
            public final /* synthetic */ String o;
            public final /* synthetic */ JSONArray p;
            public final /* synthetic */ av q;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, str, str2, str3, Integer.valueOf(i), Long.valueOf(j), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7, jSONArray3};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.q = this;
                this.a = context;
                this.b = str;
                this.c = str2;
                this.d = str3;
                this.e = i;
                this.f = j;
                this.g = str4;
                this.h = jSONArray;
                this.i = str5;
                this.j = jSONArray2;
                this.k = str6;
                this.l = map;
                this.m = z;
                this.n = jSONObject;
                this.o = str7;
                this.p = jSONArray3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                    if (sessionStartTime <= 0) {
                        return;
                    }
                    this.q.a(this.a, sessionStartTime, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
                }
            }
        });
    }

    public void a(Context context, ArrayList<ao> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, context, arrayList) != null) || CooperService.instance().isCloseTrace() || !bu.a().e()) {
            return;
        }
        this.d.post(new Runnable(this, context, arrayList) { // from class: com.baidu.mobstat.av.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ ArrayList b;
            public final /* synthetic */ av c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, arrayList};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = context;
                this.b = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.c.c(this.a, this.b);
            }
        });
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            this.d.post(new Runnable(this, context, z) { // from class: com.baidu.mobstat.av.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ boolean b;
                public final /* synthetic */ av c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = context;
                    this.b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.c.b(this.a, this.b);
                    }
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                l = str;
            } catch (Exception unused) {
            }
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            this.d.post(new Runnable(this, jSONObject) { // from class: com.baidu.mobstat.av.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JSONObject a;
                public final /* synthetic */ av b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (jSONObject2 = this.a) != null && jSONObject2.length() != 0) {
                        av avVar = this.b;
                        avVar.i = avVar.b(avVar.i, this.a);
                    }
                }
            });
        }
    }
}
