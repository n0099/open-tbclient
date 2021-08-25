package com.baidu.mobads.cid.cesium;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42777b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f42778a;

    /* renamed from: c  reason: collision with root package name */
    public Context f42779c;

    /* renamed from: d  reason: collision with root package name */
    public a.C1677a f42780d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.b.b f42781e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f42782b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f42783a;

        /* renamed from: c  reason: collision with root package name */
        public String f42784c;

        /* renamed from: d  reason: collision with root package name */
        public String f42785d;

        /* renamed from: e  reason: collision with root package name */
        public String f42786e;

        /* renamed from: f  reason: collision with root package name */
        public long f42787f;

        /* renamed from: g  reason: collision with root package name */
        public String f42788g;

        /* renamed from: h  reason: collision with root package name */
        public int f42789h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-480530540, "Lcom/baidu/mobads/cid/cesium/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-480530540, "Lcom/baidu/mobads/cid/cesium/g$a;");
                    return;
                }
            }
            f42782b = new String[]{"V", "O", "0"};
        }

        public a() {
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
            this.f42789h = 1;
            this.f42783a = false;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f42783a) {
                    return null;
                }
                return this.f42784c;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.f42784c);
                    jSONObject.put("v270fk", this.f42785d);
                    jSONObject.put("cck", this.f42786e);
                    jSONObject.put("vsk", this.f42789h);
                    jSONObject.put("ctk", this.f42787f);
                    jSONObject.put("ek", this.f42788g);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    com.baidu.mobads.cid.cesium.f.c.a(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f42783a) {
                    return null;
                }
                String str = this.f42785d;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f42784c);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f42786e);
                }
                if (!TextUtils.isEmpty(this.f42788g)) {
                    sb.append(this.f42788g);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f42789h == aVar.f42789h && this.f42784c.equals(aVar.f42784c) && this.f42785d.equals(aVar.f42785d) && this.f42786e.equals(aVar.f42786e)) {
                    String str = this.f42788g;
                    String str2 = aVar.f42788g;
                    if (str == str2) {
                        return true;
                    }
                    if (str != null && str.equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(new Object[]{this.f42784c, this.f42785d, this.f42786e, this.f42788g, Integer.valueOf(this.f42789h)}) : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(625197617, "Lcom/baidu/mobads/cid/cesium/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(625197617, "Lcom/baidu/mobads/cid/cesium/g;");
        }
    }

    public g(Context context, com.baidu.mobads.cid.cesium.e.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f42779c = context.getApplicationContext();
        a.C1677a a2 = aVar.b().a("bohrium");
        this.f42780d = a2;
        a2.a();
        this.f42778a = cVar;
        a(aVar);
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("dik", "");
                String optString2 = jSONObject.optString("cck", "");
                long optLong = jSONObject.optLong("ctk", 0L);
                int optInt = jSONObject.optInt("vsk", 1);
                String optString3 = jSONObject.optString("ek", "");
                String optString4 = jSONObject.optString("v270fk", "V");
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.f42784c = optString;
                    aVar.f42786e = optString2;
                    aVar.f42787f = optLong;
                    aVar.f42789h = optInt;
                    aVar.f42788g = optString3;
                    aVar.f42785d = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String b2 = b(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.f42784c = str;
                    aVar.f42786e = b2;
                    aVar.f42787f = currentTimeMillis;
                    aVar.f42789h = 1;
                    aVar.f42788g = str3;
                    aVar.f42785d = str2;
                    return aVar;
                } catch (Exception e2) {
                    com.baidu.mobads.cid.cesium.f.c.a(e2);
                }
            }
            return null;
        }
        return (a) invokeLLL.objValue;
    }

    private String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    private void a(com.baidu.mobads.cid.cesium.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) {
            com.baidu.mobads.cid.cesium.b.b bVar = new com.baidu.mobads.cid.cesium.b.b(new com.baidu.mobads.cid.cesium.a());
            a.C1675a c1675a = new a.C1675a();
            c1675a.f42641a = this.f42779c;
            c1675a.f42642b = aVar;
            a.c cVar = new a.c();
            for (com.baidu.mobads.cid.cesium.b.a aVar2 : bVar.a()) {
                aVar2.a(c1675a);
                aVar2.a(cVar);
            }
            this.f42781e = bVar;
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                return new com.baidu.mobads.cid.cesium.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.mobads.cid.cesium.a.a().a(str.getBytes("UTF-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a();
            aVar.f42783a = true;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public a a(e eVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            if (eVar != null) {
                a aVar = new a();
                aVar.f42787f = System.currentTimeMillis();
                aVar.f42789h = 1;
                try {
                    boolean z = false;
                    aVar.f42785d = eVar.f42761b.substring(0, 1);
                    aVar.f42784c = eVar.f42760a;
                    aVar.f42786e = b(eVar.f42760a);
                    String[] strArr = a.f42782b;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f42785d)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = eVar.f42761b) != null && str.length() >= 2) {
                        aVar.f42788g = eVar.f42761b.substring(1);
                    }
                    return aVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        return (a) invokeL.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a.d dVar = new a.d();
            dVar.f42647a = true;
            List<com.baidu.mobads.cid.cesium.b.a> a2 = this.f42781e.a();
            Collections.sort(a2, com.baidu.mobads.cid.cesium.b.a.f42636c);
            List<b> b2 = this.f42778a.b(this.f42779c);
            if (b2 != null) {
                for (b bVar : b2) {
                    if (!bVar.f42635d && bVar.f42634c) {
                        for (com.baidu.mobads.cid.cesium.b.a aVar2 : a2) {
                            a.e a3 = aVar2.a(bVar.f42632a.packageName, dVar);
                            if (a3 != null && a3.a() && (aVar = a3.f42648a) != null) {
                                return aVar;
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String a2 = a(this.f42779c);
            String a3 = com.baidu.mobads.cid.cesium.d.b.a(("com.baidu" + a2).getBytes(), true);
            a aVar = new a();
            aVar.f42787f = System.currentTimeMillis();
            aVar.f42789h = 1;
            aVar.f42784c = a3;
            aVar.f42785d = "V";
            aVar.f42786e = b(a3);
            aVar.f42788g = null;
            return aVar;
        }
        return (a) invokeV.objValue;
    }
}
