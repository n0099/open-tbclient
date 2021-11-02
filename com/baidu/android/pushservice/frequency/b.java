package com.baidu.android.pushservice.frequency;

import android.content.Context;
import android.os.Build;
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
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.h.d;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.m;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f35338a;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
            if (f35338a == null) {
                synchronized (b.class) {
                    if (f35338a == null) {
                        f35338a = new b();
                    }
                }
            }
            return f35338a;
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
    public JSONObject a(Context context, boolean z, String str, int i2, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{context, Boolean.valueOf(z), str, Integer.valueOf(i2), str2})) == null) {
            String a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            String str4 = "";
            if (z) {
                str3 = i.a(context, "token");
            } else {
                str3 = "";
                str4 = DeviceId.getCUID(context);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String upperCase = Build.MANUFACTURER.toUpperCase();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray f2 = c.f(context);
            try {
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, a2);
                if (z) {
                    jSONObject.put("token", str3);
                    jSONObject.put("uuid", str);
                } else {
                    jSONObject.put("cuid", str4);
                }
                jSONObject.put("upload_time", currentTimeMillis);
                jSONObject.put("manufacture", upperCase);
                jSONObject2.put("event_time", currentTimeMillis);
                jSONObject2.put("vendor_notice", i2);
                jSONObject2.put("payload", str2);
                f2.put(jSONObject2);
                jSONObject.put("data", f2);
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
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            String e2 = c.e(context, str);
            if (TextUtils.isEmpty(e2)) {
                return false;
            }
            try {
                if (str.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                    int parseInt = Integer.parseInt(e2);
                    if (parseInt >= 1 && parseInt <= 3) {
                        ((GetFrequencyListener) aVar).onResult(0, parseInt);
                        return true;
                    }
                } else if (str.equals("do_not_disturb")) {
                    JSONObject jSONObject = new JSONObject(e2);
                    int i2 = jSONObject.getInt("from");
                    int i3 = jSONObject.getInt("to");
                    if (i2 >= 0 && i2 <= 86400 && i3 <= 86400 && i3 >= 0) {
                        ((GetNoDisturbListener) aVar).onResult(0, i2, i3);
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

    public JSONObject a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tz", TimeZone.getDefault().getID());
            } catch (JSONException unused) {
            }
            if (i2 == i3 && i2 == -1) {
                return jSONObject;
            }
            jSONObject.put("from", i2);
            jSONObject.put("to", i3);
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
        d.a().a(new com.baidu.android.pushservice.h.c(this, context, h.f35373c + h.f35377g, str, hashMap, aVar) { // from class: com.baidu.android.pushservice.frequency.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f35353a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f35354b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f35355c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HashMap f35356d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f35357e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f35358f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, r8, str, hashMap, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35358f = this;
                this.f35353a = context;
                this.f35354b = r8;
                this.f35355c = str;
                this.f35356d = hashMap;
                this.f35357e = aVar;
            }

            /* JADX WARN: Can't wrap try/catch for region: R(7:(2:9|10)|(1:12)(2:28|(7:30|31|32|14|15|16|(2:18|19)(2:21|(2:23|24)(1:25))))|13|14|15|16|(0)(0)) */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
            @Override // com.baidu.android.pushservice.h.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                int i2;
                int i3;
                int i4;
                JSONObject jSONObject;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                Context context2 = this.f35353a;
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(context2, this.f35354b, "POST", this.f35358f.a(context2, this.f35355c), this.f35356d, "application/json");
                int i5 = 0;
                if (a2 != null) {
                    String a3 = m.a(this.f35353a, a2.a());
                    i2 = a2.b();
                    if (i2 == 200 && (i2 = this.f35358f.a(a3)) == 0) {
                        try {
                            jSONObject = new JSONObject(a3).getJSONObject("data");
                        } catch (JSONException unused) {
                        }
                        if (this.f35355c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                            i5 = jSONObject.getInt(PushConstants.EXTRA_PUSH_FREQ);
                        } else if (this.f35355c.equals("do_not_disturb")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("do_not_disturb");
                            i4 = jSONObject2.getInt("from");
                            try {
                                i3 = jSONObject2.getInt("to");
                                this.f35358f.b(this.f35353a, jSONObject);
                            } catch (JSONException unused2) {
                                i3 = 0;
                            }
                            if (this.f35355c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                                ((GetFrequencyListener) this.f35357e).onResult(i2, i5);
                                return;
                            } else if (this.f35355c.equals("do_not_disturb")) {
                                ((GetNoDisturbListener) this.f35357e).onResult(i2, i4, i3);
                                return;
                            } else {
                                return;
                            }
                        }
                        i3 = 0;
                        i4 = 0;
                        this.f35358f.b(this.f35353a, jSONObject);
                        if (this.f35355c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                        }
                    }
                } else {
                    i2 = 10001;
                }
                i3 = 0;
                i4 = 0;
                if (this.f35355c.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                }
            }
        });
    }

    public void a(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, hashMap, uploadDataListener) == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json");
            d.a().a(new com.baidu.android.pushservice.h.c(this, hashMap, context, hashMap2, uploadDataListener, h.f35373c + h.f35375e) { // from class: com.baidu.android.pushservice.frequency.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HashMap f35339a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f35340b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ HashMap f35341c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ UploadDataListener f35342d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f35343e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ b f35344f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hashMap, context, hashMap2, uploadDataListener, r11};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35344f = this;
                    this.f35339a = hashMap;
                    this.f35340b = context;
                    this.f35341c = hashMap2;
                    this.f35342d = uploadDataListener;
                    this.f35343e = r11;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f35339a.containsKey("bduss")) {
                            HashMap hashMap3 = this.f35339a;
                            hashMap3.put("bduss", "bduss=" + this.f35339a.get("bduss"));
                        }
                        HashMap b2 = this.f35344f.b(this.f35340b, this.f35339a);
                        if (b2.containsKey("bduss")) {
                            if (b2.containsKey(PushConstants.EXTRA_BDUSS_ACTION)) {
                                HashMap hashMap4 = this.f35341c;
                                hashMap4.put("cookie", b2.get("bduss") + "");
                            }
                            b2.remove("bduss");
                        }
                        if (b2.isEmpty() && !this.f35341c.containsKey("bduss")) {
                            this.f35342d.onResult(0);
                            return;
                        }
                        int i2 = 10001;
                        com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(this.f35340b, this.f35343e, "POST", this.f35344f.c(this.f35340b, b2), this.f35341c, "application/json");
                        if (a2 != null) {
                            String a3 = m.a(this.f35340b, a2.a());
                            if (a2.b() == 200 && (i2 = this.f35344f.a(a3)) == 0) {
                                if (this.f35341c.containsKey("cookie")) {
                                    b2.put("bduss", this.f35341c.get("cookie"));
                                }
                                this.f35344f.a(this.f35340b, b2);
                            }
                        }
                        this.f35342d.onResult(i2);
                    }
                }
            });
        }
    }

    public void a(Context context, boolean z, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || context == null) {
            return;
        }
        a(context.getApplicationContext(), z, i2, " ", str);
    }

    public void a(Context context, boolean z, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2), str, str2}) == null) || TextUtils.isEmpty(i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"))) {
            return;
        }
        if (i.b(context, "click_data_size", -1) != -1 || z) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            d.a().a(new com.baidu.android.pushservice.h.c(this, context, z, str, i2, str2, h.f35379i + h.j, hashMap) { // from class: com.baidu.android.pushservice.frequency.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f35345a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f35346b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f35347c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f35348d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f35349e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f35350f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ HashMap f35351g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ b f35352h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Boolean.valueOf(z), str, Integer.valueOf(i2), str2, r12, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35352h = this;
                    this.f35345a = context;
                    this.f35346b = z;
                    this.f35347c = str;
                    this.f35348d = i2;
                    this.f35349e = str2;
                    this.f35350f = r12;
                    this.f35351g = hashMap;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject a2 = this.f35352h.a(this.f35345a, this.f35346b, this.f35347c, this.f35348d, this.f35349e);
                        int i3 = 2;
                        do {
                            com.baidu.android.pushservice.e.b a3 = a2 != null ? com.baidu.android.pushservice.e.c.a(this.f35345a, this.f35350f, "POST", a2.toString(), this.f35351g, "application/json") : null;
                            if (a3 != null) {
                                int b2 = a3.b();
                                String a4 = m.a(this.f35345a, a3.a());
                                if (b2 == 200 && this.f35352h.a(a4) == 0) {
                                    return;
                                }
                            }
                            if (i3 == 1) {
                                this.f35352h.a(this.f35345a, a2);
                            }
                            i3--;
                        } while (i3 > 0);
                    }
                }
            });
        }
    }
}
