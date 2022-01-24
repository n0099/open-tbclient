package com.baidu.sofire.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.e.b;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.d;
import com.baidu.sofire.utility.m;
import com.baidu.sofire.utility.q;
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
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static long f38469d;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.sofire.h.a a;

    /* renamed from: b  reason: collision with root package name */
    public Context f38470b;

    /* renamed from: c  reason: collision with root package name */
    public Receiver f38471c;

    /* renamed from: e  reason: collision with root package name */
    public HandlerC1871a f38472e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.sofire.f.a f38473f;

    /* renamed from: g  reason: collision with root package name */
    public long f38474g;

    /* renamed from: com.baidu.sofire.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class HandlerC1871a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1871a(a aVar, Looper looper) {
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
            this.a = aVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    switch (message.what) {
                        case 0:
                            a.b(this.a);
                            return;
                        case 1:
                            com.baidu.sofire.d.a.a(this.a.f38470b).a((com.baidu.sofire.e.a) message.obj);
                            Message message2 = new Message();
                            message2.what = 10;
                            sendMessage(message2);
                            return;
                        case 2:
                            a.b(this.a);
                            a.a(this.a, 0, c.m(this.a.f38470b));
                            return;
                        case 3:
                        default:
                            return;
                        case 4:
                            String valueOf = String.valueOf(message.obj);
                            if (TextUtils.isEmpty(valueOf)) {
                                return;
                            }
                            com.baidu.sofire.d.a.a(this.a.f38470b).a(q.a(valueOf));
                            return;
                        case 5:
                            a.a(this.a);
                            return;
                        case 6:
                            int m = c.m(this.a.f38470b);
                            if (2 == m) {
                                a.a(this.a, 0, m);
                                return;
                            } else {
                                a.a(this.a, 1, m);
                                return;
                            }
                        case 7:
                            a.b(this.a);
                            int m2 = c.m(this.a.f38470b);
                            if (2 == m2) {
                                a.a(this.a, 0, m2);
                                return;
                            } else {
                                a.a(this.a, 1, m2);
                                return;
                            }
                        case 8:
                            a.a(this.a, 3, c.m(this.a.f38470b));
                            return;
                        case 9:
                            a.a(this.a, 0, 2);
                            return;
                        case 10:
                            if (System.currentTimeMillis() - this.a.f38474g >= 180000) {
                                this.a.f38474g = System.currentTimeMillis();
                                int m3 = c.m(this.a.f38470b);
                                if (2 != m3) {
                                    if (1 == m3) {
                                        a.a(this.a, 4, m3);
                                        return;
                                    }
                                    return;
                                } else if (com.baidu.sofire.d.a.a(this.a.f38470b).b() >= com.baidu.sofire.h.a.a(this.a.f38470b).f38479e.getInt("up_nu_co", 50)) {
                                    a.a(this.a, 0, m3);
                                    return;
                                } else if (com.baidu.sofire.d.a.a(this.a.f38470b).a(true, m3).size() > 0) {
                                    a.a(this.a, 0, m3);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        case 11:
                            String valueOf2 = String.valueOf(message.obj);
                            JSONObject a = c.a(this.a.f38470b, new JSONObject(valueOf2));
                            com.baidu.sofire.f.a aVar = this.a.f38473f;
                            String jSONArray = new JSONArray().put(a).toString();
                            a.b(new JSONObject(valueOf2));
                            if (aVar.a(jSONArray)) {
                                return;
                            }
                            c.a(this.a.f38470b, valueOf2, false);
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
        this.f38474g = 0L;
        this.f38470b = context.getApplicationContext();
        this.f38472e = new HandlerC1871a(this, m.a());
        this.a = com.baidu.sofire.h.a.a(this.f38470b);
        this.f38473f = new com.baidu.sofire.f.a(this.f38470b);
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
            this.f38472e.sendMessage(message);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f38469d > 0) {
                if (System.currentTimeMillis() - f38469d < 300000) {
                    return false;
                }
                f38469d = 0L;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.c.a> t = aVar.a.t();
        if (t != null) {
            for (com.baidu.sofire.c.a aVar2 : t) {
                if (aVar.a(aVar.a.f38479e.getString("li_pk_s", ""), aVar2.f38392b)) {
                    aVar.a(aVar2);
                }
            }
        }
    }

    private List<com.baidu.sofire.e.a> a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == 2) {
                return com.baidu.sofire.d.a.a(this.f38470b).a(i3);
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    private void a(List<com.baidu.sofire.e.a> list, int i2, long j2) {
        JSONObject jSONObject;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            int i3 = this.a.f38479e.getInt("re_net_one_lt", 5);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            for (com.baidu.sofire.e.a aVar : list) {
                try {
                    String jSONObject2 = c.a(this.f38470b, new JSONObject(aVar.f38460d)).toString();
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
                arrayList.add(Integer.valueOf(aVar.a));
                arrayList2.add(new b(jSONObject, aVar.f38466j, aVar.a));
                i4 = length;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                b bVar = (b) arrayList2.get(i5);
                if (bVar != null) {
                    String str = bVar.f38467b;
                    if (TextUtils.isEmpty(str)) {
                        jSONArray.put(bVar.a);
                        arrayList3.add(Integer.valueOf(bVar.f38468c));
                    } else {
                        if (hashMap.containsKey(str)) {
                            JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                            if (jSONArray2 == null) {
                                jSONArray2 = new JSONArray();
                            }
                            jSONArray2.put(bVar.a);
                            hashMap.put(str, jSONArray2);
                        } else {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(bVar.a);
                            hashMap.put(str, jSONArray3);
                        }
                        ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(Integer.valueOf(bVar.f38468c));
                        hashMap2.put(str, arrayList4);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                if (this.f38473f.a(jSONArray.toString())) {
                    com.baidu.sofire.d.a.a(this.f38470b).a(arrayList3);
                } else {
                    f38469d = System.currentTimeMillis();
                }
            }
            if (hashMap.size() > 0) {
                for (String str2 : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        if (this.f38473f.a(jSONArray4.toString())) {
                            com.baidu.sofire.d.a.a(this.f38470b).a((List) hashMap2.get(str2));
                        } else {
                            f38469d = System.currentTimeMillis();
                        }
                    }
                }
            }
            com.baidu.sofire.d.a.a(this.f38470b).c();
            if (2 != i2) {
                this.a.c(i4 + j2);
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
            if (str2.equals(this.f38470b.getPackageName())) {
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
                com.baidu.sofire.h.a aVar2 = this.a;
                String str = aVar.f38394d;
                SharedPreferences sharedPreferences = aVar2.f38479e;
                String string = sharedPreferences.getString("re_net_ali2_" + str, "");
                String c2 = c.c();
                if (string.equals(c2)) {
                    return;
                }
                String e2 = this.a.e(aVar.f38394d);
                com.baidu.sofire.e.a aVar3 = new com.baidu.sofire.e.a();
                aVar3.f38458b = aVar.f38394d;
                aVar3.f38463g = 0;
                aVar3.f38459c = 2;
                aVar3.f38461e = System.currentTimeMillis();
                aVar3.f38462f = 1;
                aVar3.f38465i = 5;
                aVar3.f38460d = c.a(this.f38470b, aVar, e2, true).toString();
                com.baidu.sofire.d.a.a(this.f38470b).a(aVar3);
                String a = q.a(c.l(this.f38470b).toString());
                if (com.baidu.sofire.d.a.a(this.f38470b).b(a)) {
                    aVar3.f38458b = GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND;
                    aVar3.f38465i = 0;
                    aVar3.f38460d = c.a(this.f38470b, aVar.a, aVar.f38393c, GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND, c.l(this.f38470b).toString()).toString();
                    com.baidu.sofire.d.a.a(this.f38470b).a(aVar3);
                    com.baidu.sofire.d.a.a(this.f38470b).a(a);
                }
                com.baidu.sofire.h.a aVar4 = this.a;
                String str2 = aVar.f38394d;
                SharedPreferences.Editor editor = aVar4.f38480f;
                editor.putString("re_net_ali2_" + str2, c2);
                aVar4.f38480f.commit();
            }
        }
    }

    public static /* synthetic */ void a(a aVar) {
        com.baidu.sofire.h.a a = com.baidu.sofire.h.a.a(aVar.f38470b);
        int u = a.u();
        long currentTimeMillis = System.currentTimeMillis() - a.f38479e.getLong("re_last_ofline_time", 0L);
        long j2 = u * 3600000;
        if (currentTimeMillis >= j2) {
            d.a(aVar.f38470b).c();
            c.a(aVar.f38470b, j2);
            a.b(System.currentTimeMillis());
            return;
        }
        c.a(aVar.f38470b, j2 - currentTimeMillis);
    }

    public static /* synthetic */ void a(a aVar, int i2, int i3) {
        List<com.baidu.sofire.e.a> a;
        if (i3 != 0 && a()) {
            if (i2 == 1) {
                a = com.baidu.sofire.d.a.a(aVar.f38470b).a();
            } else if (i2 == 3) {
                a = com.baidu.sofire.d.a.a(aVar.f38470b).a(false, i3);
            } else if (i2 == 4) {
                a = com.baidu.sofire.d.a.a(aVar.f38470b).a(true, i3);
            } else {
                a = com.baidu.sofire.d.a.a(aVar.f38470b).a(i3);
            }
            if (a.size() > 0) {
                long j2 = aVar.a.f38479e.getLong("re_day_len", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = aVar.a.f38479e.getLong("re_day_b_t", 0L);
                int i4 = aVar.a.f38479e.getInt("re_net_dy_lt", 50);
                if (j3 == 0) {
                    aVar.a.d(currentTimeMillis);
                    j3 = currentTimeMillis;
                }
                if (currentTimeMillis - j3 < 86400000) {
                    if (i2 == 3) {
                        int i5 = aVar.a.f38479e.getInt("g_r_d_d_n", 0);
                        if (i5 >= 5) {
                            return;
                        }
                        aVar.a.h(i5 + 1);
                    }
                    if (j2 > i4 * 1048576) {
                        return;
                    }
                } else {
                    aVar.a.c(0L);
                    aVar.a.d(currentTimeMillis);
                    if (i2 == 3) {
                        aVar.a.h(0);
                    }
                }
                aVar.a(a, i3, j2);
                if (a() && i2 == 0 && i3 == 2 && a.size() >= 100) {
                    List<com.baidu.sofire.e.a> a2 = aVar.a(i2, i3);
                    while (a2 != null && a2.size() != 0) {
                        aVar.a(a2, i3, j2);
                        if (a2.size() < 100 || !a()) {
                            return;
                        }
                        a2 = aVar.a(i2, i3);
                    }
                }
            }
        }
    }
}
