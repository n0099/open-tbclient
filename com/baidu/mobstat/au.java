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
/* loaded from: classes5.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final au f43273a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f43274b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Character, Integer> f43275c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f43276d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Character, Integer> f43277e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f43278f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Character, Integer> f43279g;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f43281a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static int f43282b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static int f43283c = 2;
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
        f43273a = new au();
    }

    public au() {
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
        this.f43274b = new HashMap<>();
        this.f43275c = new HashMap<>();
        this.f43276d = new HashMap<>();
        this.f43277e = new HashMap<>();
        this.f43278f = new HashMap<>();
        this.f43279g = new HashMap<>();
    }

    public static au a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f43273a : (au) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == a.f43281a) {
                this.f43275c.clear();
                this.f43274b.clear();
            } else if (i2 == a.f43283c) {
                this.f43279g.clear();
                this.f43278f.clear();
            } else {
                this.f43277e.clear();
                this.f43276d.clear();
            }
        }
    }

    public String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i2 == a.f43281a) {
                String str2 = this.f43274b.get(str);
                if (TextUtils.isEmpty(str2)) {
                    a(str, this.f43275c, this.f43274b);
                    return this.f43274b.get(str);
                }
                return str2;
            } else if (i2 == a.f43283c) {
                String str3 = this.f43278f.get(str);
                if (TextUtils.isEmpty(str3)) {
                    a(str, this.f43279g, this.f43278f);
                    return this.f43278f.get(str);
                }
                return str3;
            } else {
                String str4 = this.f43276d.get(str);
                if (TextUtils.isEmpty(str4)) {
                    a(str, this.f43277e, this.f43276d);
                    return this.f43276d.get(str);
                }
                return str4;
            }
        }
        return (String) invokeLI.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b(a.f43281a);
            b(a.f43283c);
            b(a.f43282b);
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

    public JSONObject a(int i2) {
        InterceptResult invokeI;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == a.f43281a) {
                hashMap = this.f43274b;
            } else if (i2 == a.f43283c) {
                hashMap = this.f43278f;
            } else {
                hashMap = this.f43276d;
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

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ au f43280a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f43280a = this;
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
