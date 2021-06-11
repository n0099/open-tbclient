package com.baidu.sofire.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.baidu.sofire.g.d;
import com.baidu.sofire.g.k;
import com.baidu.sofire.g.n;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static long f10259d;

    /* renamed from: a  reason: collision with root package name */
    public e f10260a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10261b;

    /* renamed from: c  reason: collision with root package name */
    public Receiver f10262c;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.sofire.e.a f10264f;

    /* renamed from: g  reason: collision with root package name */
    public long f10265g = 0;

    /* renamed from: e  reason: collision with root package name */
    public HandlerC0140a f10263e = new HandlerC0140a(k.a());

    /* renamed from: com.baidu.sofire.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0140a extends Handler {
        public HandlerC0140a(Looper looper) {
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
                        com.baidu.sofire.c.a.a(a.this.f10261b).a((com.baidu.sofire.d.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        b.a();
                        a.b(a.this);
                        a.a(a.this, 0, d.n(a.this.f10261b));
                        return;
                    case 3:
                    default:
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (TextUtils.isEmpty(valueOf)) {
                            return;
                        }
                        com.baidu.sofire.c.a.a(a.this.f10261b).a(n.a(valueOf));
                        return;
                    case 5:
                        a.a(a.this);
                        return;
                    case 6:
                        int n = d.n(a.this.f10261b);
                        if (2 == n) {
                            a.a(a.this, 0, n);
                            return;
                        } else {
                            a.a(a.this, 1, n);
                            return;
                        }
                    case 7:
                        a.b(a.this);
                        int n2 = d.n(a.this.f10261b);
                        if (2 == n2) {
                            a.a(a.this, 0, n2);
                            return;
                        } else {
                            a.a(a.this, 1, n2);
                            return;
                        }
                    case 8:
                        a.a(a.this, 3, d.n(a.this.f10261b));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        if (System.currentTimeMillis() - a.this.f10265g >= 180000) {
                            a.this.f10265g = System.currentTimeMillis();
                            int n3 = d.n(a.this.f10261b);
                            if (2 != n3) {
                                if (1 == n3) {
                                    b.a();
                                    a.a(a.this, 4, n3);
                                    return;
                                }
                                return;
                            }
                            b.a();
                            if (com.baidu.sofire.c.a.a(a.this.f10261b).b() < new e(a.this.f10261b).f10255e.getInt("up_nu_co", 50)) {
                                List<com.baidu.sofire.d.a> a2 = com.baidu.sofire.c.a.a(a.this.f10261b).a(true, n3);
                                new StringBuilder(" Delay ").append(a2.size());
                                b.a();
                                if (a2.size() > 0) {
                                    b.a();
                                    a.a(a.this, 0, n3);
                                    return;
                                }
                                return;
                            }
                            b.a();
                            a.a(a.this, 0, n3);
                            return;
                        }
                        return;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        JSONObject a3 = d.a(a.this.f10261b, new JSONObject(valueOf2));
                        com.baidu.sofire.e.a aVar = a.this.f10264f;
                        String jSONArray = new JSONArray().put(a3).toString();
                        a.b(new JSONObject(valueOf2));
                        if (aVar.a(jSONArray)) {
                            return;
                        }
                        d.a(a.this.f10261b, valueOf2, false);
                        return;
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
    }

    public a(Context context) {
        this.f10261b = context.getApplicationContext();
        this.f10260a = new e(this.f10261b);
        this.f10264f = new com.baidu.sofire.e.a(this.f10261b);
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
            d.a();
            return null;
        }
    }

    public final void a(Message message) {
        this.f10263e.sendMessage(message);
    }

    public static boolean a() {
        if (f10259d > 0) {
            if (System.currentTimeMillis() - f10259d < 300000) {
                return false;
            }
            f10259d = 0L;
            return true;
        }
        return true;
    }

    public static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.b.a> v = aVar.f10260a.v();
        if (v != null) {
            for (com.baidu.sofire.b.a aVar2 : v) {
                if (aVar.a(aVar.f10260a.f10255e.getString("li_pk_s", ""), aVar2.f10152b)) {
                    aVar.a(aVar2);
                }
            }
        }
    }

    private List<com.baidu.sofire.d.a> a(int i2, int i3) {
        if (i2 == 0 && i3 == 2) {
            return com.baidu.sofire.c.a.a(this.f10261b).a(i3);
        }
        return null;
    }

    private void a(List<com.baidu.sofire.d.a> list, int i2, long j) {
        JSONObject jSONObject;
        int length;
        int i3 = this.f10260a.f10255e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.sofire.d.a> it = list.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.sofire.d.a next = it.next();
            try {
                String jSONObject2 = d.a(this.f10261b, new JSONObject(next.f10242d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length() + i4;
                } catch (Exception unused) {
                    d.a();
                }
            } catch (Exception unused2) {
                d.a();
            }
            if (length >= 1048576 * i3) {
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb.append(length);
                b.a();
                break;
            }
            arrayList.add(Integer.valueOf(next.f10239a));
            arrayList2.add(new com.baidu.sofire.d.b(jSONObject, next.j, next.f10239a));
            i4 = length;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            com.baidu.sofire.d.b bVar = (com.baidu.sofire.d.b) arrayList2.get(i5);
            if (bVar != null) {
                String str = bVar.f10249b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f10248a);
                    arrayList3.add(Integer.valueOf(bVar.f10250c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f10248a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f10248a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.f10250c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        if (jSONArray.length() > 0) {
            if (this.f10264f.a(jSONArray.toString())) {
                com.baidu.sofire.c.a.a(this.f10261b).a(arrayList3);
            } else {
                f10259d = System.currentTimeMillis();
            }
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    if (this.f10264f.a(jSONArray4.toString())) {
                        com.baidu.sofire.c.a.a(this.f10261b).a((List) hashMap2.get(str2));
                    } else {
                        f10259d = System.currentTimeMillis();
                    }
                }
            }
        }
        com.baidu.sofire.c.a.a(this.f10261b).c();
        if (2 != i2) {
            this.f10260a.c(i4 + j);
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.f10261b.getPackageName())) {
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

    public final synchronized void a(com.baidu.sofire.b.a aVar) {
        e eVar = this.f10260a;
        String str = aVar.f10154d;
        SharedPreferences sharedPreferences = eVar.f10255e;
        String string = sharedPreferences.getString("re_net_ali2_" + str, "");
        String c2 = d.c();
        if (string.equals(c2)) {
            return;
        }
        String d2 = this.f10260a.d(aVar.f10154d);
        com.baidu.sofire.d.a aVar2 = new com.baidu.sofire.d.a();
        aVar2.f10240b = aVar.f10154d;
        aVar2.f10245g = 0;
        aVar2.f10241c = 2;
        aVar2.f10243e = System.currentTimeMillis();
        aVar2.f10244f = 1;
        aVar2.f10247i = 5;
        aVar2.f10242d = d.a(this.f10261b, aVar, d2, true).toString();
        com.baidu.sofire.c.a.a(this.f10261b).a(aVar2);
        String a2 = n.a(d.m(this.f10261b).toString());
        if (com.baidu.sofire.c.a.a(this.f10261b).b(a2)) {
            aVar2.f10240b = GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND;
            aVar2.f10247i = 0;
            aVar2.f10242d = d.a(this.f10261b, aVar.f10151a, aVar.f10153c, GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND, d.m(this.f10261b).toString()).toString();
            com.baidu.sofire.c.a.a(this.f10261b).a(aVar2);
            com.baidu.sofire.c.a.a(this.f10261b).a(a2);
        }
        e eVar2 = this.f10260a;
        String str2 = aVar.f10154d;
        SharedPreferences.Editor editor = eVar2.f10256f;
        editor.putString("re_net_ali2_" + str2, c2);
        eVar2.f10256f.commit();
    }

    public static /* synthetic */ void a(a aVar) {
        e eVar = new e(aVar.f10261b);
        int w = eVar.w();
        new StringBuilder(" 2").append(Integer.toString(w));
        b.a();
        long currentTimeMillis = System.currentTimeMillis() - eVar.f10255e.getLong("re_last_ofline_time", 0L);
        long j = w * 3600000;
        if (currentTimeMillis >= j) {
            com.baidu.sofire.g.e.a(aVar.f10261b).c();
            d.a(aVar.f10261b, j);
            eVar.b(System.currentTimeMillis());
            return;
        }
        d.a(aVar.f10261b, j - currentTimeMillis);
    }

    public static /* synthetic */ void a(a aVar, int i2, int i3) {
        List<com.baidu.sofire.d.a> a2;
        if (i3 == 0) {
            b.a();
        } else if (a()) {
            if (i2 == 1) {
                a2 = com.baidu.sofire.c.a.a(aVar.f10261b).a();
                if (1 == i3) {
                    new StringBuilder(" 3g ").append(a2.size());
                    b.a();
                }
            } else if (i2 == 3) {
                a2 = com.baidu.sofire.c.a.a(aVar.f10261b).a(false, i3);
            } else if (i2 == 4) {
                a2 = com.baidu.sofire.c.a.a(aVar.f10261b).a(true, i3);
                new StringBuilder(" 3g to report ").append(a2.size());
                b.a();
            } else {
                a2 = com.baidu.sofire.c.a.a(aVar.f10261b).a(i3);
            }
            if (a2.size() > 0) {
                long j = aVar.f10260a.f10255e.getLong("re_day_len", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = aVar.f10260a.f10255e.getLong("re_day_b_t", 0L);
                int i4 = aVar.f10260a.f10255e.getInt("re_net_dy_lt", 50);
                if (j2 == 0) {
                    aVar.f10260a.d(currentTimeMillis);
                    j2 = currentTimeMillis;
                }
                b.a();
                b.a();
                if (currentTimeMillis - j2 < 86400000) {
                    if (i2 == 3) {
                        int i5 = aVar.f10260a.f10255e.getInt("g_r_d_d_n", 0);
                        if (i5 >= 5) {
                            return;
                        }
                        aVar.f10260a.h(i5 + 1);
                    }
                    if (j > i4 * 1048576) {
                        b.a();
                        return;
                    }
                } else {
                    aVar.f10260a.c(0L);
                    aVar.f10260a.d(currentTimeMillis);
                    if (i2 == 3) {
                        aVar.f10260a.h(0);
                    }
                }
                aVar.a(a2, i3, j);
                if (a() && i2 == 0 && i3 == 2 && a2.size() >= 100) {
                    List<com.baidu.sofire.d.a> a3 = aVar.a(i2, i3);
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
