package com.baidu.android.pushservice.frequency;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c.c;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.g.e;
import com.baidu.android.pushservice.i.i;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b a;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return new JSONObject(str).optInt("error_code");
            } catch (JSONException unused) {
                return IMConstants.ERROR_GROUP_DISBAND;
            }
        }
        return invokeL.intValue;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
            return a;
        }
        return (b) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            String cuid = DeviceId.getCUID(context);
            String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            if (TextUtils.isEmpty(cuid) || TextUtils.isEmpty(a2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(str);
            try {
                jSONObject2.put(SavedStateHandle.KEYS, jSONArray);
                String encodeToString = Base64.encodeToString(k.a(jSONObject2.toString().getBytes(), BaiduAppSSOJni.getPublicKey(3)), 2);
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
                jSONObject.put("cuid", cuid);
                jSONObject.put("data", encodeToString);
                jSONObject.put("data_len", encodeToString.length());
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(Context context, boolean z, String str, int i, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{context, Boolean.valueOf(z), str, Integer.valueOf(i), str2})) == null) {
            String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            String str4 = "";
            if (z) {
                str3 = i.a(context, "token");
            } else {
                str3 = "";
                str4 = DeviceId.getCUID(context);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String c = m.c(context, true);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray f = c.f(context);
            try {
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
                if (z) {
                    jSONObject.put("token", str3);
                    jSONObject.put("uuid", str);
                } else {
                    jSONObject.put("cuid", str4);
                }
                jSONObject.put("upload_time", currentTimeMillis);
                jSONObject.put("manufacture", c);
                jSONObject2.put("event_time", currentTimeMillis);
                jSONObject2.put("vendor_notice", i);
                jSONObject2.put("payload", str2);
                f.put(jSONObject2);
                jSONObject.put("data", f);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, hashMap) == null) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (entry.getKey().equals(PushConstants.EXTRA_BDUSS_ACTION)) {
                    i.a(context, PushConstants.EXTRA_BDUSS_ACTION, entry.getValue().toString());
                } else {
                    c.a(context, entry.getKey(), entry.getValue().toString(), Long.valueOf(currentTimeMillis));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, context, jSONObject) == null) {
            try {
                c.a(context, jSONObject.getJSONArray("data"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> b(Context context, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, context, hashMap)) == null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next.getValue() == null || (!c.d(context, next.getKey(), next.getValue().toString()) && !next.getKey().equals(PushConstants.EXTRA_BDUSS_ACTION))) {
                    it.remove();
                }
            }
            if (hashMap.containsKey(PushConstants.EXTRA_BDUSS_ACTION) && !hashMap.containsKey("bduss")) {
                hashMap.remove(PushConstants.EXTRA_BDUSS_ACTION);
            }
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                c.a(context, next, jSONObject.get(next).toString(), (Long) null);
            } catch (JSONException unused) {
            }
        }
    }

    private boolean b(Context context, String str, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, this, context, str, aVar)) == null) {
            String e = c.e(context, str);
            if (TextUtils.isEmpty(e)) {
                return false;
            }
            try {
                if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                    int parseInt = Integer.parseInt(e);
                    if (parseInt >= 1 && parseInt <= 7) {
                        ((GetFrequencyListener) aVar).onResult(0, parseInt);
                        return true;
                    }
                } else if (str.equals("do_not_disturb")) {
                    JSONObject jSONObject = new JSONObject(e);
                    int i = jSONObject.getInt("from");
                    int i2 = jSONObject.getInt("to");
                    if (i >= 0 && i <= 86400 && i2 <= 86400 && i2 >= 0) {
                        ((GetNoDisturbListener) aVar).onResult(0, i, i2);
                        return true;
                    }
                }
            } catch (NumberFormatException | JSONException unused) {
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, context, hashMap)) == null) {
            String cuid = DeviceId.getCUID(context);
            String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            if (TextUtils.isEmpty(cuid) || TextUtils.isEmpty(a2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                JSONArray a3 = k.a(jSONObject2.toString(), 3, 2);
                jSONObject.put("info", a3);
                jSONObject.put("info_len", a3.length());
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
                jSONObject.put("cuid", cuid);
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public JSONObject a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tz", TimeZone.getDefault().getID());
            } catch (JSONException unused) {
            }
            if (i == i2 && i == -1) {
                return jSONObject;
            }
            jSONObject.put("from", i);
            jSONObject.put("to", i2);
            return jSONObject;
        }
        return (JSONObject) invokeII.objValue;
    }

    public void a(Context context, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, aVar) == null) || b(context, str, aVar)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        e.a().a(new com.baidu.android.pushservice.g.c(this, context, g.c + g.g, str, hashMap, aVar) { // from class: com.baidu.android.pushservice.frequency.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ HashMap d;
            public final /* synthetic */ a e;
            public final /* synthetic */ b f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, r8, str, hashMap, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = this;
                this.a = context;
                this.b = r8;
                this.c = str;
                this.d = hashMap;
                this.e = aVar;
            }

            /* JADX WARN: Can't wrap try/catch for region: R(7:(2:9|10)|(1:12)(2:28|(7:30|31|32|14|15|16|(2:18|19)(2:21|(2:23|24)(1:25))))|13|14|15|16|(0)(0)) */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
            @Override // com.baidu.android.pushservice.g.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                int i;
                int i2;
                int i3;
                JSONObject jSONObject;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                Context context2 = this.a;
                com.baidu.android.pushservice.d.b a2 = com.baidu.android.pushservice.d.c.a(context2, this.b, "POST", this.f.a(context2, this.c), this.d, "application/json");
                int i4 = 0;
                if (a2 != null) {
                    String a3 = m.a(this.a, a2.a());
                    i = a2.b();
                    if (i == 200 && (i = this.f.a(a3)) == 0) {
                        try {
                            jSONObject = new JSONObject(a3).getJSONObject("data");
                        } catch (JSONException unused) {
                        }
                        if (this.c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                            i4 = jSONObject.getInt(PushConstants.EXTRA_PUSH_FREQ);
                        } else if (this.c.equals("do_not_disturb")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("do_not_disturb");
                            i3 = jSONObject2.getInt("from");
                            try {
                                i2 = jSONObject2.getInt("to");
                                this.f.b(this.a, jSONObject);
                            } catch (JSONException unused2) {
                                i2 = 0;
                            }
                            if (this.c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                                ((GetFrequencyListener) this.e).onResult(i, i4);
                                return;
                            } else if (this.c.equals("do_not_disturb")) {
                                ((GetNoDisturbListener) this.e).onResult(i, i3, i2);
                                return;
                            } else {
                                return;
                            }
                        }
                        i2 = 0;
                        i3 = 0;
                        this.f.b(this.a, jSONObject);
                        if (this.c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                        }
                    }
                } else {
                    i = 10001;
                }
                i2 = 0;
                i3 = 0;
                if (this.c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                }
            }
        });
    }

    public void a(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, hashMap, uploadDataListener) == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json");
            e.a().a(new com.baidu.android.pushservice.g.c(this, hashMap, context, hashMap2, uploadDataListener, g.c + g.e) { // from class: com.baidu.android.pushservice.frequency.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HashMap a;
                public final /* synthetic */ Context b;
                public final /* synthetic */ HashMap c;
                public final /* synthetic */ UploadDataListener d;
                public final /* synthetic */ String e;
                public final /* synthetic */ b f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap, context, hashMap2, uploadDataListener, r11};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f = this;
                    this.a = hashMap;
                    this.b = context;
                    this.c = hashMap2;
                    this.d = uploadDataListener;
                    this.e = r11;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a.containsKey("bduss")) {
                            HashMap hashMap3 = this.a;
                            hashMap3.put("bduss", "bduss=" + this.a.get("bduss"));
                        }
                        HashMap b = this.f.b(this.b, this.a);
                        if (b.containsKey("bduss")) {
                            if (b.containsKey(PushConstants.EXTRA_BDUSS_ACTION)) {
                                HashMap hashMap4 = this.c;
                                hashMap4.put("cookie", b.get("bduss") + "");
                            }
                            b.remove("bduss");
                        }
                        if (b.isEmpty() && !this.c.containsKey("bduss")) {
                            this.d.onResult(0);
                            return;
                        }
                        int i = 10001;
                        com.baidu.android.pushservice.d.b a2 = com.baidu.android.pushservice.d.c.a(this.b, this.e, "POST", this.f.c(this.b, b), this.c, "application/json");
                        if (a2 != null) {
                            String a3 = m.a(this.b, a2.a());
                            if (a2.b() == 200 && (i = this.f.a(a3)) == 0) {
                                if (this.c.containsKey("cookie")) {
                                    b.put("bduss", this.c.get("cookie"));
                                }
                                this.f.a(this.b, b);
                            }
                        }
                        this.d.onResult(i);
                    }
                }
            });
        }
    }

    public void a(Context context, boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) || context == null) {
            return;
        }
        a(context.getApplicationContext(), z, i, " ", str);
    }

    public void a(Context context, boolean z, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), str, str2}) == null) || TextUtils.isEmpty(i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"))) {
            return;
        }
        if (i.b(context, "click_data_size", -1) != -1 || z) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            e.a().a(new com.baidu.android.pushservice.g.c(this, context, z, str, i, str2, g.i + g.j, hashMap) { // from class: com.baidu.android.pushservice.frequency.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ boolean b;
                public final /* synthetic */ String c;
                public final /* synthetic */ int d;
                public final /* synthetic */ String e;
                public final /* synthetic */ String f;
                public final /* synthetic */ HashMap g;
                public final /* synthetic */ b h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Boolean.valueOf(z), str, Integer.valueOf(i), str2, r12, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.h = this;
                    this.a = context;
                    this.b = z;
                    this.c = str;
                    this.d = i;
                    this.e = str2;
                    this.f = r12;
                    this.g = hashMap;
                }

                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject a2 = this.h.a(this.a, this.b, this.c, this.d, this.e);
                        int i2 = 2;
                        do {
                            com.baidu.android.pushservice.d.b a3 = a2 != null ? com.baidu.android.pushservice.d.c.a(this.a, this.f, "POST", a2.toString(), this.g, "application/json") : null;
                            if (a3 != null) {
                                int b = a3.b();
                                String a4 = m.a(this.a, a3.a());
                                if (b == 200 && this.h.a(a4) == 0) {
                                    return;
                                }
                            }
                            if (i2 == 1) {
                                this.h.a(this.a, a2);
                            }
                            i2--;
                        } while (i2 > 0);
                    }
                }
            });
        }
    }
}
