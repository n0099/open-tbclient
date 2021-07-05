package com.baidu.sofire.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.e.b;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.d;
import com.baidu.sofire.utility.k;
import com.baidu.sofire.utility.o;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static long f10384d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.h.a f10385a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10386b;

    /* renamed from: c  reason: collision with root package name */
    public Receiver f10387c;

    /* renamed from: e  reason: collision with root package name */
    public HandlerC0162a f10388e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.sofire.f.a f10389f;

    /* renamed from: g  reason: collision with root package name */
    public long f10390g;

    /* renamed from: com.baidu.sofire.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC0162a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10391a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0162a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10391a = aVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    switch (message.what) {
                        case 0:
                            a.b(this.f10391a);
                            return;
                        case 1:
                            com.baidu.sofire.d.a.a(this.f10391a.f10386b).a((com.baidu.sofire.e.a) message.obj);
                            Message message2 = new Message();
                            message2.what = 10;
                            sendMessage(message2);
                            return;
                        case 2:
                            a.b(this.f10391a);
                            a.a(this.f10391a, 0, c.m(this.f10391a.f10386b));
                            return;
                        case 3:
                        default:
                            return;
                        case 4:
                            String valueOf = String.valueOf(message.obj);
                            if (TextUtils.isEmpty(valueOf)) {
                                return;
                            }
                            com.baidu.sofire.d.a.a(this.f10391a.f10386b).a(o.a(valueOf));
                            return;
                        case 5:
                            a.a(this.f10391a);
                            return;
                        case 6:
                            int m = c.m(this.f10391a.f10386b);
                            if (2 == m) {
                                a.a(this.f10391a, 0, m);
                                return;
                            } else {
                                a.a(this.f10391a, 1, m);
                                return;
                            }
                        case 7:
                            a.b(this.f10391a);
                            int m2 = c.m(this.f10391a.f10386b);
                            if (2 == m2) {
                                a.a(this.f10391a, 0, m2);
                                return;
                            } else {
                                a.a(this.f10391a, 1, m2);
                                return;
                            }
                        case 8:
                            a.a(this.f10391a, 3, c.m(this.f10391a.f10386b));
                            return;
                        case 9:
                            a.a(this.f10391a, 0, 2);
                            return;
                        case 10:
                            if (System.currentTimeMillis() - this.f10391a.f10390g >= 180000) {
                                this.f10391a.f10390g = System.currentTimeMillis();
                                int m3 = c.m(this.f10391a.f10386b);
                                if (2 != m3) {
                                    if (1 == m3) {
                                        a.a(this.f10391a, 4, m3);
                                        return;
                                    }
                                    return;
                                } else if (com.baidu.sofire.d.a.a(this.f10391a.f10386b).b() >= com.baidu.sofire.h.a.a(this.f10391a.f10386b).f10397e.getInt("up_nu_co", 50)) {
                                    a.a(this.f10391a, 0, m3);
                                    return;
                                } else if (com.baidu.sofire.d.a.a(this.f10391a.f10386b).a(true, m3).size() > 0) {
                                    a.a(this.f10391a, 0, m3);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        case 11:
                            String valueOf2 = String.valueOf(message.obj);
                            JSONObject a2 = c.a(this.f10391a.f10386b, new JSONObject(valueOf2));
                            com.baidu.sofire.f.a aVar = this.f10391a.f10389f;
                            String jSONArray = new JSONArray().put(a2).toString();
                            a.b(new JSONObject(valueOf2));
                            if (aVar.a(jSONArray)) {
                                return;
                            }
                            c.a(this.f10391a.f10386b, valueOf2, false);
                            return;
                    }
                } catch (Throwable unused) {
                    c.a();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2074139697, "Lcom/baidu/sofire/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2074139697, "Lcom/baidu/sofire/g/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10390g = 0L;
        this.f10386b = context.getApplicationContext();
        this.f10388e = new HandlerC0162a(this, k.a());
        this.f10385a = com.baidu.sofire.h.a.a(this.f10386b);
        this.f10389f = new com.baidu.sofire.f.a(this.f10386b);
    }

    public static String b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
                if (jSONObject2 != null && jSONObject2.has("12")) {
                    return jSONObject2.optString("12", "");
                }
                return null;
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            this.f10388e.sendMessage(message);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f10384d > 0) {
                if (System.currentTimeMillis() - f10384d < 300000) {
                    return false;
                }
                f10384d = 0L;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.c.a> t = aVar.f10385a.t();
        if (t != null) {
            for (com.baidu.sofire.c.a aVar2 : t) {
                if (aVar.a(aVar.f10385a.f10397e.getString("li_pk_s", ""), aVar2.f10286b)) {
                    aVar.a(aVar2);
                }
            }
        }
    }

    private List<com.baidu.sofire.e.a> a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65540, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == 2) {
                return com.baidu.sofire.d.a.a(this.f10386b).a(i3);
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    private void a(List<com.baidu.sofire.e.a> list, int i2, long j) {
        JSONObject jSONObject;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            int i3 = this.f10385a.f10397e.getInt("re_net_one_lt", 5);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            for (com.baidu.sofire.e.a aVar : list) {
                try {
                    String jSONObject2 = c.a(this.f10386b, new JSONObject(aVar.f10374d)).toString();
                    try {
                        jSONObject = new JSONObject(jSONObject2);
                        length = jSONObject2.length() + i4;
                    } catch (Exception unused) {
                        c.a();
                    }
                } catch (Exception unused2) {
                    c.a();
                }
                if (length >= 1048576 * i3) {
                    break;
                }
                arrayList.add(Integer.valueOf(aVar.f10371a));
                arrayList2.add(new b(jSONObject, aVar.j, aVar.f10371a));
                i4 = length;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                b bVar = (b) arrayList2.get(i5);
                if (bVar != null) {
                    String str = bVar.f10381b;
                    if (TextUtils.isEmpty(str)) {
                        jSONArray.put(bVar.f10380a);
                        arrayList3.add(Integer.valueOf(bVar.f10382c));
                    } else {
                        if (hashMap.containsKey(str)) {
                            JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                            if (jSONArray2 == null) {
                                jSONArray2 = new JSONArray();
                            }
                            jSONArray2.put(bVar.f10380a);
                            hashMap.put(str, jSONArray2);
                        } else {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(bVar.f10380a);
                            hashMap.put(str, jSONArray3);
                        }
                        ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(Integer.valueOf(bVar.f10382c));
                        hashMap2.put(str, arrayList4);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                if (this.f10389f.a(jSONArray.toString())) {
                    com.baidu.sofire.d.a.a(this.f10386b).a(arrayList3);
                } else {
                    f10384d = System.currentTimeMillis();
                }
            }
            if (hashMap.size() > 0) {
                for (String str2 : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        if (this.f10389f.a(jSONArray4.toString())) {
                            com.baidu.sofire.d.a.a(this.f10386b).a((List) hashMap2.get(str2));
                        } else {
                            f10384d = System.currentTimeMillis();
                        }
                    }
                }
            }
            com.baidu.sofire.d.a.a(this.f10386b).c();
            if (2 != i2) {
                this.f10385a.c(i4 + j);
            }
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.equals(this.f10386b.getPackageName())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (str2.equals(jSONArray.get(i2))) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final synchronized void a(com.baidu.sofire.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                com.baidu.sofire.h.a aVar2 = this.f10385a;
                String str = aVar.f10288d;
                SharedPreferences sharedPreferences = aVar2.f10397e;
                String string = sharedPreferences.getString("re_net_ali2_" + str, "");
                String c2 = c.c();
                if (string.equals(c2)) {
                    return;
                }
                String e2 = this.f10385a.e(aVar.f10288d);
                com.baidu.sofire.e.a aVar3 = new com.baidu.sofire.e.a();
                aVar3.f10372b = aVar.f10288d;
                aVar3.f10377g = 0;
                aVar3.f10373c = 2;
                aVar3.f10375e = System.currentTimeMillis();
                aVar3.f10376f = 1;
                aVar3.f10379i = 5;
                aVar3.f10374d = c.a(this.f10386b, aVar, e2, true).toString();
                com.baidu.sofire.d.a.a(this.f10386b).a(aVar3);
                String a2 = o.a(c.l(this.f10386b).toString());
                if (com.baidu.sofire.d.a.a(this.f10386b).b(a2)) {
                    aVar3.f10372b = GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND;
                    aVar3.f10379i = 0;
                    aVar3.f10374d = c.a(this.f10386b, aVar.f10285a, aVar.f10287c, GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND, c.l(this.f10386b).toString()).toString();
                    com.baidu.sofire.d.a.a(this.f10386b).a(aVar3);
                    com.baidu.sofire.d.a.a(this.f10386b).a(a2);
                }
                com.baidu.sofire.h.a aVar4 = this.f10385a;
                String str2 = aVar.f10288d;
                SharedPreferences.Editor editor = aVar4.f10398f;
                editor.putString("re_net_ali2_" + str2, c2);
                aVar4.f10398f.commit();
            }
        }
    }

    public static /* synthetic */ void a(a aVar) {
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(aVar.f10386b);
        int u = a2.u();
        long currentTimeMillis = System.currentTimeMillis() - a2.f10397e.getLong("re_last_ofline_time", 0L);
        long j = u * 3600000;
        if (currentTimeMillis >= j) {
            d.a(aVar.f10386b).c();
            c.a(aVar.f10386b, j);
            a2.b(System.currentTimeMillis());
            return;
        }
        c.a(aVar.f10386b, j - currentTimeMillis);
    }

    public static /* synthetic */ void a(a aVar, int i2, int i3) {
        List<com.baidu.sofire.e.a> a2;
        if (i3 != 0 && a()) {
            if (i2 == 1) {
                a2 = com.baidu.sofire.d.a.a(aVar.f10386b).a();
            } else if (i2 == 3) {
                a2 = com.baidu.sofire.d.a.a(aVar.f10386b).a(false, i3);
            } else if (i2 == 4) {
                a2 = com.baidu.sofire.d.a.a(aVar.f10386b).a(true, i3);
            } else {
                a2 = com.baidu.sofire.d.a.a(aVar.f10386b).a(i3);
            }
            if (a2.size() > 0) {
                long j = aVar.f10385a.f10397e.getLong("re_day_len", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = aVar.f10385a.f10397e.getLong("re_day_b_t", 0L);
                int i4 = aVar.f10385a.f10397e.getInt("re_net_dy_lt", 50);
                if (j2 == 0) {
                    aVar.f10385a.d(currentTimeMillis);
                    j2 = currentTimeMillis;
                }
                if (currentTimeMillis - j2 < 86400000) {
                    if (i2 == 3) {
                        int i5 = aVar.f10385a.f10397e.getInt("g_r_d_d_n", 0);
                        if (i5 >= 5) {
                            return;
                        }
                        aVar.f10385a.h(i5 + 1);
                    }
                    if (j > i4 * 1048576) {
                        return;
                    }
                } else {
                    aVar.f10385a.c(0L);
                    aVar.f10385a.d(currentTimeMillis);
                    if (i2 == 3) {
                        aVar.f10385a.h(0);
                    }
                }
                aVar.a(a2, i3, j);
                if (a() && i2 == 0 && i3 == 2 && a2.size() >= 100) {
                    List<com.baidu.sofire.e.a> a3 = aVar.a(i2, i3);
                    while (a3 != null && a3.size() != 0) {
                        aVar.a(a3, i3, j);
                        if (a3.size() < 100 || !a()) {
                            return;
                        }
                        a3 = aVar.a(i2, i3);
                    }
                }
            }
        }
    }
}
