package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public static final au a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f27241b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f27242c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f27243d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f27244e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f27245f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f27246g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f27247b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f27248c = 2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(627061153, "Lcom/baidu/mobstat/au$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(627061153, "Lcom/baidu/mobstat/au$a;");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657470, "Lcom/baidu/mobstat/au;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657470, "Lcom/baidu/mobstat/au;");
                return;
            }
        }
        a = new au();
    }

    public au() {
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
        this.f27241b = new HashMap<>();
        this.f27242c = new HashMap<>();
        this.f27243d = new HashMap<>();
        this.f27244e = new HashMap<>();
        this.f27245f = new HashMap<>();
        this.f27246g = new HashMap<>();
    }

    public static au a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (au) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == a.a) {
                this.f27242c.clear();
                this.f27241b.clear();
            } else if (i == a.f27248c) {
                this.f27246g.clear();
                this.f27245f.clear();
            } else {
                this.f27244e.clear();
                this.f27243d.clear();
            }
        }
    }

    public String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i == a.a) {
                String str2 = this.f27241b.get(str);
                if (TextUtils.isEmpty(str2)) {
                    a(str, this.f27242c, this.f27241b);
                    return this.f27241b.get(str);
                }
                return str2;
            } else if (i == a.f27248c) {
                String str3 = this.f27245f.get(str);
                if (TextUtils.isEmpty(str3)) {
                    a(str, this.f27246g, this.f27245f);
                    return this.f27245f.get(str);
                }
                return str3;
            } else {
                String str4 = this.f27243d.get(str);
                if (TextUtils.isEmpty(str4)) {
                    a(str, this.f27244e, this.f27243d);
                    return this.f27243d.get(str);
                }
                return str4;
            }
        }
        return (String) invokeLI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b(a.a);
            b(a.f27248c);
            b(a.f27247b);
        }
    }

    private void a(String str, HashMap<Character, Integer> hashMap, HashMap<String, String> hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, hashMap, hashMap2) == null) {
            char lowerCase = Character.toLowerCase(str.charAt(0));
            Integer num = hashMap.get(Character.valueOf(lowerCase));
            int intValue = num != null ? num.intValue() + 1 : 0;
            hashMap.put(Character.valueOf(lowerCase), Integer.valueOf(intValue));
            hashMap2.put(str, Character.toString(lowerCase) + intValue);
        }
    }

    public JSONObject a(int i) {
        InterceptResult invokeI;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i == a.a) {
                hashMap = this.f27241b;
            } else if (i == a.f27248c) {
                hashMap = this.f27245f;
            } else {
                hashMap = this.f27243d;
            }
            JSONObject jSONObject = new JSONObject();
            if (hashMap == null) {
                return jSONObject;
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
            try {
                Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>(this) { // from class: com.baidu.mobstat.au.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ au a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, entry, entry2)) == null) ? entry.getValue().compareTo(entry2.getValue()) : invokeLL.intValue;
                    }
                });
            } catch (Exception unused) {
            }
            for (Map.Entry entry : arrayList) {
                try {
                    jSONObject.put((String) entry.getValue(), (String) entry.getKey());
                } catch (Exception unused2) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeI.objValue;
    }
}
