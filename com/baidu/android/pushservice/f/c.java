package com.baidu.android.pushservice.f;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.f;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.m;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f37295a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f37296b;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str).optJSONObject("response_params").optInt(Constants.KEYS.RET);
                } catch (JSONException unused) {
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f37296b == null) {
                synchronized (c.class) {
                    if (f37296b == null) {
                        f37296b = new c();
                    }
                }
            }
            return f37296b;
        }
        return (c) invokeV.objValue;
    }

    private String a(String str, String str2, HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, hashMap)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, str, str2)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, i.a(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            hashMap.put("timestamp", currentTimeMillis + "");
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, f37295a.a() + "");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(DeviceId.getCUID(context));
            hashMap.put("cuids", jSONArray.toString());
            try {
                hashMap.put("vcode", f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
            } catch (UnsupportedEncodingException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
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

    private void a(Context context, int i2) {
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65543, this, context, i2) == null) || context == null) {
            return;
        }
        if (f37295a == null) {
            b(context);
        }
        if (f37295a == null || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName())) == null) {
            return;
        }
        f37295a.a(context, launchIntentForPackage.getComponent(), i2);
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, context) == null) && Build.VERSION.SDK_INT >= 26 && d.l(context)) {
            f37295a = new a();
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            String a2 = h.f() ? h.a() : h.b();
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, context, a2 + "/rest/3.0/clientfile/clearbadge") { // from class: com.baidu.android.pushservice.f.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f37297a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f37298b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ c f37299c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37299c = this;
                    this.f37297a = context;
                    this.f37298b = r8;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HashMap a3 = this.f37299c.a(this.f37297a, "POST", this.f37298b);
                        int i2 = 2;
                        do {
                            com.baidu.android.pushservice.e.b b2 = com.baidu.android.pushservice.e.c.b(this.f37297a, this.f37298b, "POST", a3, "BCCS_SDK/3.0", h.c());
                            if (b2 != null) {
                                int b3 = b2.b();
                                String a4 = m.a(this.f37297a, b2.a());
                                if (b3 == 200 && this.f37299c.a(a4) == 0) {
                                    return;
                                }
                            }
                            i2--;
                        } while (i2 > 0);
                    }
                }
            });
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        a(context, 0);
        c(context);
    }
}
