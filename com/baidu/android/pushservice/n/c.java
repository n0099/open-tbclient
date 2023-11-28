package com.baidu.android.pushservice.n;

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
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.l;
import com.baidu.android.pushservice.database.PushConfigData;
import com.baidu.android.pushservice.frequency.GetFrequencyListener;
import com.baidu.android.pushservice.frequency.GetNoDisturbListener;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.m.d;
import com.baidu.android.pushservice.message.LocalPushMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ HashMap e;
        public final /* synthetic */ UploadDataListener f;
        public final /* synthetic */ String g;
        public final /* synthetic */ c h;

        public a(c cVar, HashMap hashMap, Context context, HashMap hashMap2, UploadDataListener uploadDataListener, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hashMap, context, hashMap2, uploadDataListener, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = cVar;
            this.c = hashMap;
            this.d = context;
            this.e = hashMap2;
            this.f = uploadDataListener;
            this.g = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.containsKey("bduss")) {
                    HashMap hashMap = this.c;
                    hashMap.put("bduss", "bduss=" + this.c.get("bduss"));
                }
                HashMap a = this.h.a(this.d, this.c);
                if (a.containsKey("bduss")) {
                    if (a.containsKey(PushConstants.EXTRA_BDUSS_ACTION)) {
                        HashMap hashMap2 = this.e;
                        hashMap2.put("cookie", a.get("bduss") + "");
                    }
                    a.remove("bduss");
                }
                if (a.isEmpty() && !this.e.containsKey("bduss")) {
                    this.f.onResult(0);
                    return;
                }
                int i = 10001;
                com.baidu.android.pushservice.q.b a2 = com.baidu.android.pushservice.q.c.a(this.d, this.g, "POST", this.h.c(this.d, a), this.e, "application/json");
                if (a2 != null) {
                    String a3 = Utility.a(this.d, a2.b());
                    if (a2.a() == 200 && (i = this.h.a(a3)) == 0) {
                        if (this.e.containsKey("cookie")) {
                            a.put("bduss", this.e.get("cookie"));
                        }
                        this.h.b(this.d, a);
                    }
                }
                this.f.onResult(i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ HashMap j;
        public final /* synthetic */ c k;

        public b(c cVar, Context context, boolean z, String str, int i, String str2, String str3, String str4, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, Boolean.valueOf(z), str, Integer.valueOf(i), str2, str3, str4, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = cVar;
            this.c = context;
            this.d = z;
            this.e = str;
            this.f = i;
            this.g = str2;
            this.h = str3;
            this.i = str4;
            this.j = hashMap;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject a = this.k.a(this.c, this.d, this.e, this.f, this.g, this.h);
                int i = 2;
                do {
                    com.baidu.android.pushservice.q.b a2 = a != null ? com.baidu.android.pushservice.q.c.a(this.c, this.i, "POST", a.toString(), this.j, "application/json") : null;
                    if (a2 != null) {
                        int a3 = a2.a();
                        String a4 = Utility.a(this.c, a2.b());
                        if (a3 == 200 && this.k.a(a4) == 0) {
                            return;
                        }
                    }
                    if (i == 1) {
                        this.k.b(this.c, a);
                    }
                    i--;
                } while (i > 0);
            }
        }
    }

    /* renamed from: com.baidu.android.pushservice.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0032c extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ HashMap f;
        public final /* synthetic */ com.baidu.android.pushservice.n.a g;
        public final /* synthetic */ c h;

        public C0032c(c cVar, Context context, String str, String str2, HashMap hashMap, com.baidu.android.pushservice.n.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, str, str2, hashMap, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = cVar;
            this.c = context;
            this.d = str;
            this.e = str2;
            this.f = hashMap;
            this.g = aVar;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:(2:9|10)|(1:12)(2:28|(7:30|31|32|14|15|16|(2:18|19)(2:21|(2:23|24)(1:25))))|13|14|15|16|(0)(0)) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
        @Override // com.baidu.android.pushservice.z.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            int i;
            int i2;
            int i3;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            Context context = this.c;
            com.baidu.android.pushservice.q.b a = com.baidu.android.pushservice.q.c.a(context, this.d, "POST", this.h.b(context, this.e), this.f, "application/json");
            int i4 = 0;
            if (a != null) {
                String a2 = Utility.a(this.c, a.b());
                i = a.a();
                if (i == 200 && (i = this.h.a(a2)) == 0) {
                    try {
                        jSONObject = new JSONObject(a2).getJSONObject("data");
                    } catch (JSONException unused) {
                    }
                    if (this.e.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                        i4 = jSONObject.getInt(PushConstants.EXTRA_PUSH_FREQ);
                    } else if (this.e.equals("do_not_disturb")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("do_not_disturb");
                        i3 = jSONObject2.getInt("from");
                        try {
                            i2 = jSONObject2.getInt("to");
                            this.h.a(this.c, jSONObject);
                        } catch (JSONException unused2) {
                            i2 = 0;
                        }
                        if (this.e.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                            ((GetFrequencyListener) this.g).onResult(i, i4);
                            return;
                        } else if (this.e.equals("do_not_disturb")) {
                            ((GetNoDisturbListener) this.g).onResult(i, i3, i2);
                            return;
                        } else {
                            return;
                        }
                    }
                    i2 = 0;
                    i3 = 0;
                    this.h.a(this.c, jSONObject);
                    if (this.e.equals(PushConstants.EXTRA_PUSH_FREQ)) {
                    }
                }
            } else {
                i = 10001;
            }
            i2 = 0;
            i3 = 0;
            if (this.e.equals(PushConstants.EXTRA_PUSH_FREQ)) {
            }
        }
    }

    public c() {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c();
                    }
                }
            }
            return a;
        }
        return (c) invokeV.objValue;
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
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

    public PushConfigData a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? d.d(context, str) : (PushConfigData) invokeLL.objValue;
    }

    public final HashMap<String, Object> a(Context context, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, hashMap)) == null) {
            Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next.getValue() == null || (!d.a(context, next.getKey(), next.getValue().toString()) && !next.getKey().equals(PushConstants.EXTRA_BDUSS_ACTION))) {
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

    public JSONObject a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
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

    public final JSONObject a(Context context, boolean z, String str, int i, String str2, String str3) {
        InterceptResult invokeCommon;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), str, Integer.valueOf(i), str2, str3})) == null) {
            String c = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            String str5 = "";
            if (z) {
                str4 = i.c(context, "token");
            } else {
                str4 = "";
                str5 = DeviceId.getCUID(context);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String a2 = Utility.a(context, true);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray c2 = d.c(context);
            try {
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, c);
                if (z) {
                    jSONObject.put("token", str4);
                    jSONObject.put("uuid", str);
                } else {
                    jSONObject.put("cuid", str5);
                }
                jSONObject.put("upload_time", currentTimeMillis);
                jSONObject.put("manufacture", a2);
                jSONObject2.put("event_time", currentTimeMillis);
                jSONObject2.put("vendor_notice", i);
                jSONObject2.put("payload", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("log_ext", str3);
                }
                c2.put(jSONObject2);
                jSONObject.put("data", c2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void a(Context context, LocalPushMsg localPushMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, localPushMsg) == null) {
            try {
                if (d.b(context, localPushMsg.f())) {
                    return;
                }
                d.a(context, localPushMsg);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void a(Context context, com.baidu.android.pushservice.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, bVar) == null) {
            synchronized (this) {
                try {
                    List<LocalPushMsg> j = d.j(context);
                    if (bVar != null) {
                        List<LocalPushMsg> a2 = bVar.a(j);
                        if (a2 == null || a2.size() == 0) {
                            return;
                        }
                        i.b(context, "local_notify_msg_handle_last_time", System.currentTimeMillis() / 1000);
                        for (LocalPushMsg localPushMsg : a2) {
                            if (localPushMsg != null) {
                                a(context, new String[]{localPushMsg.f()});
                                try {
                                    d.a(context, localPushMsg.a(), localPushMsg.g(), Long.parseLong(localPushMsg.f()), localPushMsg.e().getBytes(), null, localPushMsg.c(), 0, localPushMsg.h());
                                } catch (NumberFormatException unused) {
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void a(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, hashMap, uploadDataListener) == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json");
            e.a().a(new a(this, hashMap, context, hashMap2, uploadDataListener, g.g + g.h));
        }
    }

    public final void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                d.a(context, next, jSONObject.get(next).toString(), (Long) null);
            } catch (JSONException unused) {
            }
        }
    }

    public void a(Context context, boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) || context == null) {
            return;
        }
        a(context.getApplicationContext(), z, i, " ", str, "");
    }

    public void a(Context context, boolean z, int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), str, str2, str3}) == null) || TextUtils.isEmpty(i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"))) {
            return;
        }
        if (i.a(context, "click_data_size", -1) != -1 || z) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            e.a().a(new b(this, context, z, str, i, str2, str3, g.k + g.l, hashMap));
        }
    }

    public final void a(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, strArr) == null) {
            try {
                d.a(context, strArr);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean a(Context context, String str, com.baidu.android.pushservice.n.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, context, str, aVar)) == null) {
            String e = d.e(context, str);
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

    public final String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, context, str)) == null) {
            String cuid = DeviceId.getCUID(context);
            String c = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            if (TextUtils.isEmpty(cuid) || TextUtils.isEmpty(c)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(str);
            try {
                jSONObject2.put(SavedStateHandle.KEYS, jSONArray);
                String encodeToString = Base64.encodeToString(l.a(jSONObject2.toString().getBytes(), BaiduAppSSOJni.getPublicKey(3)), 2);
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, c);
                jSONObject.put("cuid", cuid);
                jSONObject.put("data", encodeToString);
                jSONObject.put("data_len", encodeToString.length());
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void b(Context context, String str, com.baidu.android.pushservice.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, context, str, aVar) == null) || a(context, str, aVar)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        e.a().a(new C0032c(this, context, g.g + g.i, str, hashMap, aVar));
    }

    public final void b(Context context, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, hashMap) == null) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (entry.getKey().equals(PushConstants.EXTRA_BDUSS_ACTION)) {
                    i.b(context, PushConstants.EXTRA_BDUSS_ACTION, entry.getValue().toString());
                } else {
                    d.a(context, entry.getKey(), entry.getValue().toString(), Long.valueOf(currentTimeMillis));
                }
            }
        }
    }

    public final void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, jSONObject) == null) {
            try {
                d.a(context, jSONObject.getJSONArray("data"));
            } catch (JSONException unused) {
            }
        }
    }

    public final String c(Context context, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, hashMap)) == null) {
            String cuid = DeviceId.getCUID(context);
            String c = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            if (TextUtils.isEmpty(cuid) || TextUtils.isEmpty(c)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                JSONArray a2 = l.a(jSONObject2.toString().getBytes(StandardCharsets.UTF_8), 3, 2);
                jSONObject.put("info", a2);
                jSONObject.put("info_len", a2.length());
                jSONObject.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, c);
                jSONObject.put("cuid", cuid);
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }
}
