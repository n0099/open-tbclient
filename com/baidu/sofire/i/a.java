package com.baidu.sofire.i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.sofire.a.b;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.k.h;
import com.baidu.sofire.k.j;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static long g;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerC0169a a;
    public com.baidu.sofire.j.a b;
    public Context c;
    public com.baidu.sofire.h.a d;
    public Receiver e;
    public long f;

    /* renamed from: com.baidu.sofire.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0169a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0169a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
            if (r4 != null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
            if (r4 == null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b8, code lost:
            r4.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00bc, code lost:
            r3 = com.baidu.sofire.a.b.a;
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            int f;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    Cursor cursor = null;
                    switch (message.what) {
                        case 0:
                            a.b(this.a);
                            return;
                        case 1:
                            com.baidu.sofire.f.a.a(this.a.c).a((com.baidu.sofire.g.a) message.obj);
                            Message message2 = new Message();
                            message2.what = 10;
                            sendMessage(message2);
                            return;
                        case 2:
                            a.b(this.a);
                            a.a(this.a, 0, com.baidu.sofire.k.a.f(this.a.c));
                            return;
                        case 3:
                        default:
                            return;
                        case 4:
                            String valueOf = String.valueOf(message.obj);
                            if (TextUtils.isEmpty(valueOf)) {
                                return;
                            }
                            com.baidu.sofire.f.a a = com.baidu.sofire.f.a.a(this.a.c);
                            String a2 = j.a(valueOf);
                            a.getClass();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("b", a2);
                            a.b.insert("c", null, contentValues);
                            return;
                        case 5:
                            a.a(this.a);
                            return;
                        case 6:
                            int f2 = com.baidu.sofire.k.a.f(this.a.c);
                            if (2 == f2) {
                                a.a(this.a, 0, f2);
                                return;
                            } else {
                                a.a(this.a, 1, f2);
                                return;
                            }
                        case 7:
                            a.b(this.a);
                            int f3 = com.baidu.sofire.k.a.f(this.a.c);
                            if (2 == f3) {
                                a.a(this.a, 0, f3);
                                return;
                            } else {
                                a.a(this.a, 1, f3);
                                return;
                            }
                        case 8:
                            a aVar = this.a;
                            a.a(aVar, 3, com.baidu.sofire.k.a.f(aVar.c));
                            return;
                        case 9:
                            a.a(this.a, 0, 2);
                            return;
                        case 10:
                            long currentTimeMillis = System.currentTimeMillis();
                            a aVar2 = this.a;
                            if (currentTimeMillis - aVar2.f < LiveFeedPageSdk.REFRESH_TIME) {
                                return;
                            }
                            aVar2.f = System.currentTimeMillis();
                            f = com.baidu.sofire.k.a.f(this.a.c);
                            if (2 != f) {
                                if (1 == f) {
                                    a.a(this.a, 4, f);
                                    return;
                                }
                                return;
                            }
                            com.baidu.sofire.f.a a3 = com.baidu.sofire.f.a.a(this.a.c);
                            a3.getClass();
                            try {
                                cursor = a3.b.query("r", null, null, null, null, null, null, null);
                                if (cursor == null) {
                                    i = 0;
                                    break;
                                } else {
                                    i = cursor.getCount();
                                    break;
                                }
                            } catch (Exception unused) {
                                int i2 = b.a;
                                i = 0;
                                break;
                            }
                        case 11:
                            String valueOf2 = String.valueOf(message.obj);
                            JSONObject b = com.baidu.sofire.k.a.b(this.a.c, new JSONObject(valueOf2));
                            com.baidu.sofire.h.a aVar3 = this.a.d;
                            String jSONArray = new JSONArray().put(b).toString();
                            a aVar4 = this.a;
                            JSONObject jSONObject = new JSONObject(valueOf2);
                            aVar4.getClass();
                            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
                            if (jSONObject2 != null && jSONObject2.has("12")) {
                                jSONObject2.optString("12", "");
                            }
                            if (aVar3.a(jSONArray)) {
                                return;
                            }
                            com.baidu.sofire.k.a.a(this.a.c, valueOf2, false);
                            return;
                    }
                } catch (Throwable unused2) {
                    int i3 = b.a;
                    return;
                }
            } else {
                return;
            }
            if (i >= com.baidu.sofire.j.a.a(this.a.c).e.getInt("up_nu_co", 50)) {
                a.a(this.a, 0, f);
            } else if (((ArrayList) com.baidu.sofire.f.a.a(this.a.c).a(true, f)).size() > 0) {
                a.a(this.a, 0, f);
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0L;
        this.c = context.getApplicationContext();
        this.a = new HandlerC0169a(this, h.a());
        this.b = com.baidu.sofire.j.a.a(this.c);
        this.d = new com.baidu.sofire.h.a(this.c);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x00ee */
    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x00f3 */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ee, code lost:
        if (r6 != null) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a aVar, int i, int i2) {
        ?? a;
        List<com.baidu.sofire.g.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, aVar, i, i2) == null) {
            aVar.getClass();
            if (i2 != 0 && aVar.a()) {
                if (i == 1) {
                    com.baidu.sofire.f.a a2 = com.baidu.sofire.f.a.a(aVar.c);
                    a2.getClass();
                    a = new ArrayList();
                    Cursor cursor = null;
                    try {
                        try {
                            Cursor cursor2 = a2.b.query("r", null, "i=5", null, null, null, "d desc", "100");
                            if (cursor2 != null) {
                                while (cursor2.moveToNext()) {
                                    try {
                                        try {
                                            com.baidu.sofire.g.a aVar2 = new com.baidu.sofire.g.a();
                                            aVar2.a = cursor2.getInt(cursor2.getColumnIndex("a"));
                                            aVar2.b = cursor2.getString(cursor2.getColumnIndex("b"));
                                            aVar2.c = cursor2.getInt(cursor2.getColumnIndex("c"));
                                            aVar2.e = cursor2.getLong(cursor2.getColumnIndex("d"));
                                            aVar2.f = cursor2.getInt(cursor2.getColumnIndex("g"));
                                            aVar2.g = cursor2.getInt(cursor2.getColumnIndex("e"));
                                            aVar2.h = cursor2.getInt(cursor2.getColumnIndex("f"));
                                            aVar2.i = cursor2.getInt(cursor2.getColumnIndex("i"));
                                            aVar2.j = cursor2.getString(cursor2.getColumnIndex("j"));
                                            String string = cursor2.getString(cursor2.getColumnIndex("h"));
                                            try {
                                                string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes(IMAudioTransRequest.CHARSET)));
                                            } catch (Exception unused) {
                                                int i3 = b.a;
                                            }
                                            aVar2.d = string;
                                            a.add(aVar2);
                                        } catch (Exception unused2) {
                                            cursor = cursor2;
                                            int i4 = b.a;
                                            if (cursor != null) {
                                                cursor2 = cursor;
                                                try {
                                                    cursor2.close();
                                                } catch (Exception unused3) {
                                                    int i5 = b.a;
                                                }
                                            }
                                            if (a.size() > 0) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused4) {
                                                int i6 = b.a;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused5) {
                    }
                } else {
                    a = i == 3 ? com.baidu.sofire.f.a.a(aVar.c).a(false, i2) : i == 4 ? com.baidu.sofire.f.a.a(aVar.c).a(true, i2) : com.baidu.sofire.f.a.a(aVar.c).a(i2);
                }
                if (a.size() > 0) {
                    return;
                }
                long j = aVar.b.e.getLong("re_day_len", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = aVar.b.e.getLong("re_day_b_t", 0L);
                int i7 = aVar.b.e.getInt("re_net_dy_lt", 50);
                if (j2 == 0) {
                    com.baidu.sofire.j.a aVar3 = aVar.b;
                    aVar3.f.putLong("re_day_b_t", currentTimeMillis);
                    aVar3.f.commit();
                    j2 = currentTimeMillis;
                }
                if (currentTimeMillis - j2 < 86400000) {
                    if (i == 3) {
                        int i8 = aVar.b.e.getInt("g_r_d_d_n", 0);
                        if (i8 >= 5) {
                            return;
                        }
                        com.baidu.sofire.j.a aVar4 = aVar.b;
                        aVar4.f.putInt("g_r_d_d_n", i8 + 1);
                        aVar4.f.commit();
                    }
                    if (j > i7 * 1048576) {
                        return;
                    }
                    list = a;
                } else {
                    com.baidu.sofire.j.a aVar5 = aVar.b;
                    list = a;
                    aVar5.f.putLong("re_day_len", 0L);
                    aVar5.f.commit();
                    com.baidu.sofire.j.a aVar6 = aVar.b;
                    aVar6.f.putLong("re_day_b_t", currentTimeMillis);
                    aVar6.f.commit();
                    if (i == 3) {
                        com.baidu.sofire.j.a aVar7 = aVar.b;
                        aVar7.f.putInt("g_r_d_d_n", 0);
                        aVar7.f.commit();
                    }
                }
                aVar.a(list, i2, j);
                if (aVar.a() && i == 0 && i2 == 2 && list.size() >= 100) {
                    List<com.baidu.sofire.g.a> a3 = aVar.a(i, i2);
                    while (a3 != null && a3.size() != 0) {
                        aVar.a(a3, i2, j);
                        if (a3.size() < 100 || !aVar.a()) {
                            return;
                        }
                        a3 = aVar.a(i, i2);
                    }
                }
            }
        }
    }

    public static void b(a aVar) {
        List<com.baidu.sofire.e.a> c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, aVar) == null) || (c = aVar.b.c()) == null) {
            return;
        }
        for (com.baidu.sofire.e.a aVar2 : c) {
            if (aVar.a(aVar.b.e.getString("li_pk_s", ""), aVar2.b)) {
                aVar.a(aVar2);
            }
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
            com.baidu.sofire.j.a a = com.baidu.sofire.j.a.a(aVar.c);
            int l = a.l();
            long currentTimeMillis = System.currentTimeMillis() - a.e.getLong("re_last_ofline_time", 0L);
            long j = l * 3600000;
            if (currentTimeMillis >= j) {
                com.baidu.sofire.k.b.a(aVar.c).a();
                com.baidu.sofire.k.a.a(aVar.c, j);
                a.f.putLong("re_last_ofline_time", System.currentTimeMillis());
                a.f.commit();
                return;
            }
            com.baidu.sofire.k.a.a(aVar.c, j - currentTimeMillis);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (g > 0) {
                if (System.currentTimeMillis() - g < 300000) {
                    return false;
                }
                g = 0L;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final List<com.baidu.sofire.g.a> a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            if (i == 0 && i2 == 2) {
                return com.baidu.sofire.f.a.a(this.c).a(i2);
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    public final void a(List<com.baidu.sofire.g.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            int i2 = this.b.e.getInt("re_net_one_lt", 5);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (com.baidu.sofire.g.a aVar : list) {
                try {
                    String jSONObject2 = com.baidu.sofire.k.a.b(this.c, new JSONObject(aVar.d)).toString();
                    try {
                        jSONObject = new JSONObject(jSONObject2);
                        length = jSONObject2.length() + i3;
                    } catch (Exception unused) {
                        int i4 = b.a;
                    }
                } catch (Exception unused2) {
                    int i5 = b.a;
                }
                if (length >= 1048576 * i2) {
                    break;
                }
                arrayList.add(Integer.valueOf(aVar.a));
                arrayList2.add(new com.baidu.sofire.g.b(jSONObject, aVar.j, aVar.a));
                i3 = length;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                com.baidu.sofire.g.b bVar = (com.baidu.sofire.g.b) arrayList2.get(i6);
                if (bVar != null) {
                    String str = bVar.b;
                    if (TextUtils.isEmpty(str)) {
                        jSONArray.put(bVar.a);
                        arrayList3.add(Integer.valueOf(bVar.c));
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
                        arrayList4.add(Integer.valueOf(bVar.c));
                        hashMap2.put(str, arrayList4);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                if (this.d.a(jSONArray.toString())) {
                    com.baidu.sofire.f.a.a(this.c).a(arrayList3);
                } else {
                    g = System.currentTimeMillis();
                }
            }
            if (hashMap.size() > 0) {
                for (String str2 : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        if (this.d.a(jSONArray4.toString())) {
                            com.baidu.sofire.f.a.a(this.c).a((List) hashMap2.get(str2));
                        } else {
                            g = System.currentTimeMillis();
                        }
                    }
                }
            }
            com.baidu.sofire.f.a a = com.baidu.sofire.f.a.a(this.c);
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(a.c);
            long currentTimeMillis = System.currentTimeMillis();
            int i7 = a2.e.getInt("re_net_over", 7) * 86400000;
            try {
                a.b.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - i7)});
            } catch (Exception unused3) {
                int i8 = b.a;
            }
            if (2 != i) {
                com.baidu.sofire.j.a aVar2 = this.b;
                aVar2.f.putLong("re_day_len", i3 + j);
                aVar2.f.commit();
            }
        }
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.equals(this.c.getPackageName())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str2.equals(jSONArray.get(i))) {
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

    public synchronized void a(com.baidu.sofire.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                com.baidu.sofire.j.a aVar2 = this.b;
                String str = aVar.d;
                String string = aVar2.e.getString("re_net_ali2_" + str, "");
                Calendar calendar = Calendar.getInstance();
                String str2 = calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
                if (string.equals(str2)) {
                    return;
                }
                com.baidu.sofire.j.a aVar3 = this.b;
                String str3 = aVar.d;
                String string2 = aVar3.e.getString("al_da" + str3, "");
                String str4 = aVar.d;
                long currentTimeMillis = System.currentTimeMillis();
                String jSONObject = com.baidu.sofire.k.a.a(this.c, aVar, string2, true).toString();
                com.baidu.sofire.f.a a = com.baidu.sofire.f.a.a(this.c);
                ContentValues contentValues = new ContentValues();
                contentValues.put("b", str4);
                contentValues.put("c", (Integer) 2);
                contentValues.put("d", Long.valueOf(currentTimeMillis));
                contentValues.put("e", (Integer) 0);
                contentValues.put("g", (Integer) 1);
                contentValues.put("f", (Integer) 0);
                contentValues.put("i", (Integer) 5);
                contentValues.put("j", (String) null);
                try {
                    jSONObject = Base64.encodeToString(F.getInstance().ae(jSONObject.getBytes(), "xVOTuxgN3lkRN2v4".getBytes(IMAudioTransRequest.CHARSET)), 0);
                } catch (Exception unused) {
                    int i = b.a;
                }
                contentValues.put("h", jSONObject);
                a.b.insert("r", null, contentValues);
                com.baidu.sofire.j.a aVar4 = this.b;
                String str5 = aVar.d;
                aVar4.f.putString("re_net_ali2_" + str5, str2);
                aVar4.f.commit();
            }
        }
    }
}
