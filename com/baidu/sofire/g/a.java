package com.baidu.sofire.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.e.b;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.d;
import com.baidu.sofire.utility.k;
import com.baidu.sofire.utility.o;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static long f10312d;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sofire.h.a f10313a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10314b;

    /* renamed from: c  reason: collision with root package name */
    public Receiver f10315c;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.sofire.f.a f10317f;

    /* renamed from: g  reason: collision with root package name */
    public long f10318g = 0;

    /* renamed from: e  reason: collision with root package name */
    public HandlerC0143a f10316e = new HandlerC0143a(k.a());

    /* renamed from: com.baidu.sofire.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0143a extends Handler {
        public HandlerC0143a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.b(a.this);
                        return;
                    case 1:
                        com.baidu.sofire.d.a.a(a.this.f10314b).a((com.baidu.sofire.e.a) message.obj);
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        a.b(a.this);
                        a.a(a.this, 0, c.m(a.this.f10314b));
                        return;
                    case 3:
                    default:
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (TextUtils.isEmpty(valueOf)) {
                            return;
                        }
                        com.baidu.sofire.d.a.a(a.this.f10314b).a(o.a(valueOf));
                        return;
                    case 5:
                        a.a(a.this);
                        return;
                    case 6:
                        int m = c.m(a.this.f10314b);
                        if (2 == m) {
                            a.a(a.this, 0, m);
                            return;
                        } else {
                            a.a(a.this, 1, m);
                            return;
                        }
                    case 7:
                        a.b(a.this);
                        int m2 = c.m(a.this.f10314b);
                        if (2 == m2) {
                            a.a(a.this, 0, m2);
                            return;
                        } else {
                            a.a(a.this, 1, m2);
                            return;
                        }
                    case 8:
                        a.a(a.this, 3, c.m(a.this.f10314b));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        if (System.currentTimeMillis() - a.this.f10318g >= 180000) {
                            a.this.f10318g = System.currentTimeMillis();
                            int m3 = c.m(a.this.f10314b);
                            if (2 != m3) {
                                if (1 == m3) {
                                    a.a(a.this, 4, m3);
                                    return;
                                }
                                return;
                            } else if (com.baidu.sofire.d.a.a(a.this.f10314b).b() >= com.baidu.sofire.h.a.a(a.this.f10314b).f10325e.getInt("up_nu_co", 50)) {
                                a.a(a.this, 0, m3);
                                return;
                            } else if (com.baidu.sofire.d.a.a(a.this.f10314b).a(true, m3).size() > 0) {
                                a.a(a.this, 0, m3);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        JSONObject a2 = c.a(a.this.f10314b, new JSONObject(valueOf2));
                        com.baidu.sofire.f.a aVar = a.this.f10317f;
                        String jSONArray = new JSONArray().put(a2).toString();
                        a.b(new JSONObject(valueOf2));
                        if (aVar.a(jSONArray)) {
                            return;
                        }
                        c.a(a.this.f10314b, valueOf2, false);
                        return;
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public a(Context context) {
        this.f10314b = context.getApplicationContext();
        this.f10313a = com.baidu.sofire.h.a.a(this.f10314b);
        this.f10317f = new com.baidu.sofire.f.a(this.f10314b);
    }

    public static String b(JSONObject jSONObject) {
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

    public final void a(Message message) {
        this.f10316e.sendMessage(message);
    }

    public static boolean a() {
        if (f10312d > 0) {
            if (System.currentTimeMillis() - f10312d < 300000) {
                return false;
            }
            f10312d = 0L;
            return true;
        }
        return true;
    }

    public static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.c.a> t = aVar.f10313a.t();
        if (t != null) {
            for (com.baidu.sofire.c.a aVar2 : t) {
                if (aVar.a(aVar.f10313a.f10325e.getString("li_pk_s", ""), aVar2.f10214b)) {
                    aVar.a(aVar2);
                }
            }
        }
    }

    private List<com.baidu.sofire.e.a> a(int i2, int i3) {
        if (i2 == 0 && i3 == 2) {
            return com.baidu.sofire.d.a.a(this.f10314b).a(i3);
        }
        return null;
    }

    private void a(List<com.baidu.sofire.e.a> list, int i2, long j) {
        JSONObject jSONObject;
        int length;
        int i3 = this.f10313a.f10325e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        for (com.baidu.sofire.e.a aVar : list) {
            try {
                String jSONObject2 = c.a(this.f10314b, new JSONObject(aVar.f10302d)).toString();
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
            arrayList.add(Integer.valueOf(aVar.f10299a));
            arrayList2.add(new b(jSONObject, aVar.j, aVar.f10299a));
            i4 = length;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            b bVar = (b) arrayList2.get(i5);
            if (bVar != null) {
                String str = bVar.f10309b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f10308a);
                    arrayList3.add(Integer.valueOf(bVar.f10310c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f10308a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f10308a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.f10310c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        if (jSONArray.length() > 0) {
            if (this.f10317f.a(jSONArray.toString())) {
                com.baidu.sofire.d.a.a(this.f10314b).a(arrayList3);
            } else {
                f10312d = System.currentTimeMillis();
            }
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    if (this.f10317f.a(jSONArray4.toString())) {
                        com.baidu.sofire.d.a.a(this.f10314b).a((List) hashMap2.get(str2));
                    } else {
                        f10312d = System.currentTimeMillis();
                    }
                }
            }
        }
        com.baidu.sofire.d.a.a(this.f10314b).c();
        if (2 != i2) {
            this.f10313a.c(i4 + j);
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.f10314b.getPackageName())) {
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

    public final synchronized void a(com.baidu.sofire.c.a aVar) {
        com.baidu.sofire.h.a aVar2 = this.f10313a;
        String str = aVar.f10216d;
        SharedPreferences sharedPreferences = aVar2.f10325e;
        String string = sharedPreferences.getString("re_net_ali2_" + str, "");
        String c2 = c.c();
        if (string.equals(c2)) {
            return;
        }
        String e2 = this.f10313a.e(aVar.f10216d);
        com.baidu.sofire.e.a aVar3 = new com.baidu.sofire.e.a();
        aVar3.f10300b = aVar.f10216d;
        aVar3.f10305g = 0;
        aVar3.f10301c = 2;
        aVar3.f10303e = System.currentTimeMillis();
        aVar3.f10304f = 1;
        aVar3.f10307i = 5;
        aVar3.f10302d = c.a(this.f10314b, aVar, e2, true).toString();
        com.baidu.sofire.d.a.a(this.f10314b).a(aVar3);
        String a2 = o.a(c.l(this.f10314b).toString());
        if (com.baidu.sofire.d.a.a(this.f10314b).b(a2)) {
            aVar3.f10300b = GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND;
            aVar3.f10307i = 0;
            aVar3.f10302d = c.a(this.f10314b, aVar.f10213a, aVar.f10215c, GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND, c.l(this.f10314b).toString()).toString();
            com.baidu.sofire.d.a.a(this.f10314b).a(aVar3);
            com.baidu.sofire.d.a.a(this.f10314b).a(a2);
        }
        com.baidu.sofire.h.a aVar4 = this.f10313a;
        String str2 = aVar.f10216d;
        SharedPreferences.Editor editor = aVar4.f10326f;
        editor.putString("re_net_ali2_" + str2, c2);
        aVar4.f10326f.commit();
    }

    public static /* synthetic */ void a(a aVar) {
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(aVar.f10314b);
        int u = a2.u();
        long currentTimeMillis = System.currentTimeMillis() - a2.f10325e.getLong("re_last_ofline_time", 0L);
        long j = u * 3600000;
        if (currentTimeMillis >= j) {
            d.a(aVar.f10314b).c();
            c.a(aVar.f10314b, j);
            a2.b(System.currentTimeMillis());
            return;
        }
        c.a(aVar.f10314b, j - currentTimeMillis);
    }

    public static /* synthetic */ void a(a aVar, int i2, int i3) {
        List<com.baidu.sofire.e.a> a2;
        if (i3 != 0 && a()) {
            if (i2 == 1) {
                a2 = com.baidu.sofire.d.a.a(aVar.f10314b).a();
            } else if (i2 == 3) {
                a2 = com.baidu.sofire.d.a.a(aVar.f10314b).a(false, i3);
            } else if (i2 == 4) {
                a2 = com.baidu.sofire.d.a.a(aVar.f10314b).a(true, i3);
            } else {
                a2 = com.baidu.sofire.d.a.a(aVar.f10314b).a(i3);
            }
            if (a2.size() > 0) {
                long j = aVar.f10313a.f10325e.getLong("re_day_len", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = aVar.f10313a.f10325e.getLong("re_day_b_t", 0L);
                int i4 = aVar.f10313a.f10325e.getInt("re_net_dy_lt", 50);
                if (j2 == 0) {
                    aVar.f10313a.d(currentTimeMillis);
                    j2 = currentTimeMillis;
                }
                if (currentTimeMillis - j2 < 86400000) {
                    if (i2 == 3) {
                        int i5 = aVar.f10313a.f10325e.getInt("g_r_d_d_n", 0);
                        if (i5 >= 5) {
                            return;
                        }
                        aVar.f10313a.h(i5 + 1);
                    }
                    if (j > i4 * 1048576) {
                        return;
                    }
                } else {
                    aVar.f10313a.c(0L);
                    aVar.f10313a.d(currentTimeMillis);
                    if (i2 == 3) {
                        aVar.f10313a.h(0);
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
