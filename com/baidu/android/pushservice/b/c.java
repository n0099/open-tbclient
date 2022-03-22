package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24183b;

    /* renamed from: c  reason: collision with root package name */
    public int f24184c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<e> f24185d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<f> f24186e;

    /* renamed from: f  reason: collision with root package name */
    public String f24187f;

    /* renamed from: g  reason: collision with root package name */
    public String f24188g;

    /* renamed from: h  reason: collision with root package name */
    public a f24189h;
    public int i;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f24190b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f24191c;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24191c = cVar;
        }
    }

    public c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.a = str;
        a(context, str);
    }

    private void a(Context context, String str) {
        String str2;
        int i;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, str) == null) {
            String str4 = "apksign";
            try {
                JSONObject jSONObject = new JSONObject(str);
                a(jSONObject.getString(HttpConstants.HTTP_MANUFACTURER));
                String string = jSONObject.getString("mode");
                if ("I".equalsIgnoreCase(string)) {
                    a(1);
                } else if ("I_HW".equalsIgnoreCase(string)) {
                    a(5);
                } else if ("I_XM".equalsIgnoreCase(string)) {
                    a(6);
                } else if ("I_MZ".equalsIgnoreCase(string)) {
                    a(7);
                } else if ("I_OP".equalsIgnoreCase(string)) {
                    a(8);
                } else if ("I_VI".equalsIgnoreCase(string)) {
                    a(9);
                } else if ("C".equalsIgnoreCase(string)) {
                    a(2);
                } else {
                    a(0);
                }
                ArrayList<e> arrayList = new ArrayList<>();
                String str5 = "match";
                if (jSONObject.has("osversion")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("osversion");
                    str2 = "apkversion";
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        JSONArray jSONArray2 = jSONArray;
                        e eVar = new e();
                        String str6 = str4;
                        eVar.a(jSONObject2.getString("key"));
                        eVar.b(jSONObject2.getString("value"));
                        String string2 = jSONObject2.getString("match");
                        if (string2.equalsIgnoreCase("above")) {
                            eVar.a(0);
                        } else if (string2.equalsIgnoreCase("equal")) {
                            eVar.a(1);
                        } else if (string2.equalsIgnoreCase("regular")) {
                            eVar.a(2);
                            arrayList.add(eVar);
                            i2++;
                            jSONArray = jSONArray2;
                            str4 = str6;
                        }
                        arrayList.add(eVar);
                        i2++;
                        jSONArray = jSONArray2;
                        str4 = str6;
                    }
                } else {
                    str2 = "apkversion";
                }
                String str7 = str4;
                ArrayList<f> arrayList2 = new ArrayList<>();
                if (jSONObject.has("systemprop")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("systemprop");
                    int i3 = 0;
                    while (i3 < jSONArray3.length()) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                        f fVar = new f();
                        JSONArray jSONArray4 = jSONArray3;
                        fVar.a(jSONObject3.getString("key"));
                        fVar.b(jSONObject3.getString("value"));
                        String string3 = jSONObject3.getString(str5);
                        if (string3.equalsIgnoreCase("above")) {
                            str3 = str5;
                            fVar.a(0);
                        } else {
                            str3 = str5;
                            if (string3.equalsIgnoreCase("equal")) {
                                fVar.a(1);
                                fVar.c(jSONObject3.getString("regular"));
                                arrayList2.add(fVar);
                                i3++;
                                jSONArray3 = jSONArray4;
                                str5 = str3;
                            }
                        }
                        fVar.c(jSONObject3.getString("regular"));
                        arrayList2.add(fVar);
                        i3++;
                        jSONArray3 = jSONArray4;
                        str5 = str3;
                    }
                }
                if (jSONObject.has("proxyswitch")) {
                    try {
                        i = Integer.parseInt(jSONObject.getString("proxyswitch"));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    b(i);
                }
                if (jSONObject.has("apkname")) {
                    b(jSONObject.getString("apkname"));
                }
                if (jSONObject.has(str7)) {
                    c(jSONObject.getString(str7));
                }
                String str8 = str2;
                if (jSONObject.has(str8)) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject(str8);
                    a(jSONObject4.optInt("from"), jSONObject4.optInt("to"));
                }
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                if (arrayList2.size() > 0) {
                    b(arrayList2);
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24189h : (a) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f24184c = i;
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            a aVar = new a(this);
            this.f24189h = aVar;
            aVar.a = i;
            aVar.f24190b = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f24183b = str;
        }
    }

    public void a(ArrayList<e> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f24185d = arrayList;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24183b : (String) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.i = i;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f24187f = str;
        }
    }

    public void b(ArrayList<f> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.f24186e = arrayList;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f24184c : invokeV.intValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f24188g = str;
        }
    }

    public ArrayList<e> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f24185d : (ArrayList) invokeV.objValue;
    }

    public ArrayList<f> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f24186e : (ArrayList) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f24187f : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f24188g : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
