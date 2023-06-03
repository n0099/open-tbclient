package com.baidu.android.pushservice.r;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.a0.f;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static b a;
    public static volatile c b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ c e;

        public a(c cVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cVar;
            this.c = context;
            this.d = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap a = this.e.a(this.c, "POST", this.d);
                int i = 2;
                do {
                    com.baidu.android.pushservice.q.b a2 = com.baidu.android.pushservice.q.c.a(this.c, this.d, "POST", a, "BCCS_SDK/3.0", g.b());
                    if (a2 != null) {
                        int a3 = a2.a();
                        String a4 = Utility.a(this.c, a2.b());
                        if (a3 == 200 && this.e.a(a4) == 0) {
                            return;
                        }
                    }
                    i--;
                } while (i > 0);
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
            if (b == null) {
                synchronized (c.class) {
                    if (b == null) {
                        b = new c();
                    }
                }
            }
            return b;
        }
        return (c) invokeV.objValue;
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str).optJSONObject("response_params").optInt("ret");
                } catch (JSONException unused) {
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final String a(String str, String str2, HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, hashMap)) == null) {
            TreeSet<String> treeSet = new TreeSet(hashMap.keySet());
            StringBuilder sb = new StringBuilder();
            for (String str3 : treeSet) {
                sb.append(str3);
                sb.append("=");
                sb.append(hashMap.get(str3));
            }
            return f.a((str + str2 + sb.toString()).getBytes(), false);
        }
        return (String) invokeLLL.objValue;
    }

    public final HashMap<String, String> a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            hashMap.put("timestamp", currentTimeMillis + "");
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, a.a() + "");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(DeviceId.getCUID(context));
            hashMap.put("cuids", jSONArray.toString());
            try {
                hashMap.put("vcode", f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
            } catch (UnsupportedEncodingException unused) {
            }
            hashMap.put("sign", a("POST", str2, hashMap));
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append("=");
                sb.append((Object) entry.getValue());
                sb.append(" ");
            }
            return hashMap;
        }
        return (HashMap) invokeLLL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || context == null) {
            return;
        }
        a(context, 0);
        c(context);
    }

    public final void a(Context context, int i) {
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) || context == null) {
            return;
        }
        if (a == null) {
            b(context);
        }
        if (a == null || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName())) == null) {
            return;
        }
        a.a(context, launchIntentForPackage.getComponent(), i);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && Build.VERSION.SDK_INT >= 26 && d.m(context)) {
            a = new com.baidu.android.pushservice.r.a();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            String c = g.f() ? g.c() : g.d();
            e.a().a(new a(this, context, c + "/rest/3.0/clientfile/clearbadge"));
        }
    }
}
