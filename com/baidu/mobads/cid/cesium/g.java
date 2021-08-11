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
    public static boolean f42670b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f42671a;

    /* renamed from: c  reason: collision with root package name */
    public Context f42672c;

    /* renamed from: d  reason: collision with root package name */
    public a.C1673a f42673d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.b.b f42674e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f42675b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f42676a;

        /* renamed from: c  reason: collision with root package name */
        public String f42677c;

        /* renamed from: d  reason: collision with root package name */
        public String f42678d;

        /* renamed from: e  reason: collision with root package name */
        public String f42679e;

        /* renamed from: f  reason: collision with root package name */
        public long f42680f;

        /* renamed from: g  reason: collision with root package name */
        public String f42681g;

        /* renamed from: h  reason: collision with root package name */
        public int f42682h;

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
            f42675b = new String[]{"V", "O", "0"};
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
            this.f42682h = 1;
            this.f42676a = false;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f42676a) {
                    return null;
                }
                return this.f42677c;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.f42677c);
                    jSONObject.put("v270fk", this.f42678d);
                    jSONObject.put("cck", this.f42679e);
                    jSONObject.put("vsk", this.f42682h);
                    jSONObject.put("ctk", this.f42680f);
                    jSONObject.put("ek", this.f42681g);
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
                if (this.f42676a) {
                    return null;
                }
                String str = this.f42678d;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f42677c);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f42679e);
                }
                if (!TextUtils.isEmpty(this.f42681g)) {
                    sb.append(this.f42681g);
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
                if (this.f42682h == aVar.f42682h && this.f42677c.equals(aVar.f42677c) && this.f42678d.equals(aVar.f42678d) && this.f42679e.equals(aVar.f42679e)) {
                    String str = this.f42681g;
                    String str2 = aVar.f42681g;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(new Object[]{this.f42677c, this.f42678d, this.f42679e, this.f42681g, Integer.valueOf(this.f42682h)}) : invokeV.intValue;
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
        this.f42672c = context.getApplicationContext();
        a.C1673a a2 = aVar.b().a("bohrium");
        this.f42673d = a2;
        a2.a();
        this.f42671a = cVar;
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
                    aVar.f42677c = optString;
                    aVar.f42679e = optString2;
                    aVar.f42680f = optLong;
                    aVar.f42682h = optInt;
                    aVar.f42681g = optString3;
                    aVar.f42678d = optString4;
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
                    aVar.f42677c = str;
                    aVar.f42679e = b2;
                    aVar.f42680f = currentTimeMillis;
                    aVar.f42682h = 1;
                    aVar.f42681g = str3;
                    aVar.f42678d = str2;
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
            a.C1671a c1671a = new a.C1671a();
            c1671a.f42534a = this.f42672c;
            c1671a.f42535b = aVar;
            a.c cVar = new a.c();
            for (com.baidu.mobads.cid.cesium.b.a aVar2 : bVar.a()) {
                aVar2.a(c1671a);
                aVar2.a(cVar);
            }
            this.f42674e = bVar;
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
            aVar.f42676a = true;
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
                aVar.f42680f = System.currentTimeMillis();
                aVar.f42682h = 1;
                try {
                    boolean z = false;
                    aVar.f42678d = eVar.f42654b.substring(0, 1);
                    aVar.f42677c = eVar.f42653a;
                    aVar.f42679e = b(eVar.f42653a);
                    String[] strArr = a.f42675b;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f42678d)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = eVar.f42654b) != null && str.length() >= 2) {
                        aVar.f42681g = eVar.f42654b.substring(1);
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
            dVar.f42540a = true;
            List<com.baidu.mobads.cid.cesium.b.a> a2 = this.f42674e.a();
            Collections.sort(a2, com.baidu.mobads.cid.cesium.b.a.f42529c);
            List<b> b2 = this.f42671a.b(this.f42672c);
            if (b2 != null) {
                for (b bVar : b2) {
                    if (!bVar.f42528d && bVar.f42527c) {
                        for (com.baidu.mobads.cid.cesium.b.a aVar2 : a2) {
                            a.e a3 = aVar2.a(bVar.f42525a.packageName, dVar);
                            if (a3 != null && a3.a() && (aVar = a3.f42541a) != null) {
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
            String a2 = a(this.f42672c);
            String a3 = com.baidu.mobads.cid.cesium.d.b.a(("com.baidu" + a2).getBytes(), true);
            a aVar = new a();
            aVar.f42680f = System.currentTimeMillis();
            aVar.f42682h = 1;
            aVar.f42677c = a3;
            aVar.f42678d = "V";
            aVar.f42679e = b(a3);
            aVar.f42681g = null;
            return aVar;
        }
        return (a) invokeV.objValue;
    }
}
