package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pushservice.j.m;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3466a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f3467b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f3468c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-840926861, "Lcom/baidu/android/pushservice/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-840926861, "Lcom/baidu/android/pushservice/j;");
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static j a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f3467b == null) {
                synchronized (j.class) {
                    if (f3467b == null) {
                        f3467b = new j();
                        f3468c = context;
                    }
                }
            }
            return f3467b;
        }
        return (j) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str).getJSONObject("info").getString("token");
                } catch (JSONException unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, com.baidu.android.pushservice.j.i.a(f3468c, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE"));
                jSONObject2.put("timestamp", (System.currentTimeMillis() / 1000) + "");
                jSONObject2.put(IAdRequestParam.CELL_ID, com.baidu.android.pushservice.j.i.a(f3468c, IAdRequestParam.CELL_ID));
                jSONObject2.put(HttpConstants.DEVICE_TYPE, "3");
                jSONObject2.put("sdk_int", Build.VERSION.SDK_INT + "");
                jSONObject2.put("push_sdk_version", ((int) a.a()) + "");
                int i2 = m.o(f3468c) ? 3 : 2;
                jSONObject2.put("connect_version", i2 + "");
                jSONObject2.put("bind_name", Build.MODEL);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("push_proxy", str);
                }
                jSONObject2.put(HttpConstants.OS_VERSION, Build.DISPLAY);
                jSONObject2.put(HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
                jSONObject2.put("bind_notify_status", com.baidu.android.pushservice.j.h.b(f3468c));
                jSONObject2.put("source", 2);
                JSONArray a2 = com.baidu.android.pushservice.j.k.a(jSONObject2.toString(), 3, 2);
                jSONObject.put("info", a2);
                jSONObject.put("info_len", a2.length());
            } catch (JSONException | Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "requestNewBind", (short) 100, str, h.f3144c + h.f3149h, hashMap) { // from class: com.baidu.android.pushservice.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f3469a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f3470b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ HashMap f3471c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ j f3472d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Short.valueOf(r10), str, r12, hashMap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f3472d = this;
                    this.f3469a = str;
                    this.f3470b = r12;
                    this.f3471c = hashMap;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String b2 = this.f3472d.b(this.f3469a);
                        com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(j.f3468c, this.f3470b, "POST", this.f3472d.c(this.f3469a), this.f3471c, "application/json");
                        if (a2 != null) {
                            try {
                                com.baidu.android.pushservice.j.i.a(j.f3468c, IAdRequestParam.CELL_ID, new JSONObject(m.a(j.f3468c, a2.a())).getJSONObject("response_params").getString(IAdRequestParam.CELL_ID));
                                if (TextUtils.isEmpty(b2)) {
                                    return;
                                }
                                com.baidu.android.pushservice.j.i.a(j.f3468c, "token", b2);
                            } catch (JSONException unused) {
                            }
                        }
                    }
                }
            });
        }
    }
}
