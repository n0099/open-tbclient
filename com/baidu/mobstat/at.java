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
/* loaded from: classes2.dex */
public class at {
    public static /* synthetic */ Interceptable $ic;
    public static final at a;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap b;
    public HashMap c;
    public HashMap d;
    public HashMap e;
    public HashMap f;
    public HashMap g;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(627031362, "Lcom/baidu/mobstat/at$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(627031362, "Lcom/baidu/mobstat/at$a;");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657439, "Lcom/baidu/mobstat/at;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657439, "Lcom/baidu/mobstat/at;");
                return;
            }
        }
        a = new at();
    }

    public static at a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (at) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b(a.a);
            b(a.c);
            b(a.b);
        }
    }

    public at() {
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
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
    }

    private void a(String str, HashMap hashMap, HashMap hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, hashMap, hashMap2) == null) {
            int i = 0;
            char lowerCase = Character.toLowerCase(str.charAt(0));
            Integer num = (Integer) hashMap.get(Character.valueOf(lowerCase));
            if (num != null) {
                i = num.intValue() + 1;
            }
            hashMap.put(Character.valueOf(lowerCase), Integer.valueOf(i));
            hashMap2.put(str, Character.toString(lowerCase) + i);
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
                String str2 = (String) this.b.get(str);
                if (TextUtils.isEmpty(str2)) {
                    a(str, this.c, this.b);
                    return (String) this.b.get(str);
                }
                return str2;
            } else if (i == a.c) {
                String str3 = (String) this.f.get(str);
                if (TextUtils.isEmpty(str3)) {
                    a(str, this.g, this.f);
                    return (String) this.f.get(str);
                }
                return str3;
            } else {
                String str4 = (String) this.d.get(str);
                if (TextUtils.isEmpty(str4)) {
                    a(str, this.e, this.d);
                    return (String) this.d.get(str);
                }
                return str4;
            }
        }
        return (String) invokeLI.objValue;
    }

    public JSONObject a(int i) {
        InterceptResult invokeI;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i == a.a) {
                hashMap = this.b;
            } else if (i == a.c) {
                hashMap = this.f;
            } else {
                hashMap = this.d;
            }
            JSONObject jSONObject = new JSONObject();
            if (hashMap == null) {
                return jSONObject;
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
            try {
                Collections.sort(arrayList, new Comparator(this) { // from class: com.baidu.mobstat.at.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ at a;

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
                    public int compare(Map.Entry entry, Map.Entry entry2) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, entry, entry2)) == null) {
                            return ((String) entry.getValue()).compareTo((String) entry2.getValue());
                        }
                        return invokeLL.intValue;
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

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == a.a) {
                this.c.clear();
                this.b.clear();
            } else if (i == a.c) {
                this.g.clear();
                this.f.clear();
            } else {
                this.e.clear();
                this.d.clear();
            }
        }
    }
}
