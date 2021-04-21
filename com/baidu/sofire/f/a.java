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
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static long f11406d;

    /* renamed from: a  reason: collision with root package name */
    public e f11407a;

    /* renamed from: b  reason: collision with root package name */
    public Context f11408b;

    /* renamed from: c  reason: collision with root package name */
    public Receiver f11409c;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.sofire.e.a f11411f;

    /* renamed from: g  reason: collision with root package name */
    public long f11412g = 0;

    /* renamed from: e  reason: collision with root package name */
    public HandlerC0159a f11410e = new HandlerC0159a(k.a());

    /* renamed from: com.baidu.sofire.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0159a extends Handler {
        public HandlerC0159a(Looper looper) {
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
                        com.baidu.sofire.c.a.a(a.this.f11408b).a((com.baidu.sofire.d.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        b.a();
                        a.b(a.this);
                        a.a(a.this, 0, d.n(a.this.f11408b));
                        return;
                    case 3:
                    default:
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (TextUtils.isEmpty(valueOf)) {
                            return;
                        }
                        com.baidu.sofire.c.a.a(a.this.f11408b).a(n.a(valueOf));
                        return;
                    case 5:
                        a.a(a.this);
                        return;
                    case 6:
                        int n = d.n(a.this.f11408b);
                        if (2 == n) {
                            a.a(a.this, 0, n);
                            return;
                        } else {
                            a.a(a.this, 1, n);
                            return;
                        }
                    case 7:
                        a.b(a.this);
                        int n2 = d.n(a.this.f11408b);
                        if (2 == n2) {
                            a.a(a.this, 0, n2);
                            return;
                        } else {
                            a.a(a.this, 1, n2);
                            return;
                        }
                    case 8:
                        a.a(a.this, 3, d.n(a.this.f11408b));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        if (System.currentTimeMillis() - a.this.f11412g >= 180000) {
                            a.this.f11412g = System.currentTimeMillis();
                            int n3 = d.n(a.this.f11408b);
                            if (2 != n3) {
                                if (1 == n3) {
                                    b.a();
                                    a.a(a.this, 4, n3);
                                    return;
                                }
                                return;
                            }
                            b.a();
                            if (com.baidu.sofire.c.a.a(a.this.f11408b).b() < new e(a.this.f11408b).f11402e.getInt("up_nu_co", 50)) {
                                List<com.baidu.sofire.d.a> a2 = com.baidu.sofire.c.a.a(a.this.f11408b).a(true, n3);
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
                        JSONObject a3 = d.a(a.this.f11408b, new JSONObject(valueOf2));
                        com.baidu.sofire.e.a aVar = a.this.f11411f;
                        String jSONArray = new JSONArray().put(a3).toString();
                        a.b(new JSONObject(valueOf2));
                        if (aVar.a(jSONArray)) {
                            return;
                        }
                        d.a(a.this.f11408b, valueOf2, false);
                        return;
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
    }

    public a(Context context) {
        this.f11408b = context.getApplicationContext();
        this.f11407a = new e(this.f11408b);
        this.f11411f = new com.baidu.sofire.e.a(this.f11408b);
    }

    public static String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 != null && jSONObject2.has(Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                return jSONObject2.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
            }
            return null;
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public final void a(Message message) {
        this.f11410e.sendMessage(message);
    }

    public static boolean a() {
        if (f11406d > 0) {
            if (System.currentTimeMillis() - f11406d < 300000) {
                return false;
            }
            f11406d = 0L;
            return true;
        }
        return true;
    }

    public static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.b.a> v = aVar.f11407a.v();
        if (v != null) {
            for (com.baidu.sofire.b.a aVar2 : v) {
                if (aVar.a(aVar.f11407a.f11402e.getString("li_pk_s", ""), aVar2.f11303b)) {
                    aVar.a(aVar2);
                }
            }
        }
    }

    private List<com.baidu.sofire.d.a> a(int i, int i2) {
        if (i == 0 && i2 == 2) {
            return com.baidu.sofire.c.a.a(this.f11408b).a(i2);
        }
        return null;
    }

    private void a(List<com.baidu.sofire.d.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        int i2 = this.f11407a.f11402e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.sofire.d.a> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.sofire.d.a next = it.next();
            try {
                String jSONObject2 = d.a(this.f11408b, new JSONObject(next.f11390d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length() + i3;
                } catch (Exception unused) {
                    d.a();
                }
            } catch (Exception unused2) {
                d.a();
            }
            if (length >= 1048576 * i2) {
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                sb.append(length);
                b.a();
                break;
            }
            arrayList.add(Integer.valueOf(next.f11387a));
            arrayList2.add(new com.baidu.sofire.d.b(jSONObject, next.j, next.f11387a));
            i3 = length;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.baidu.sofire.d.b bVar = (com.baidu.sofire.d.b) arrayList2.get(i4);
            if (bVar != null) {
                String str = bVar.f11396b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f11395a);
                    arrayList3.add(Integer.valueOf(bVar.f11397c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f11395a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f11395a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.f11397c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        if (jSONArray.length() > 0) {
            if (this.f11411f.a(jSONArray.toString())) {
                com.baidu.sofire.c.a.a(this.f11408b).a(arrayList3);
            } else {
                f11406d = System.currentTimeMillis();
            }
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    if (this.f11411f.a(jSONArray4.toString())) {
                        com.baidu.sofire.c.a.a(this.f11408b).a((List) hashMap2.get(str2));
                    } else {
                        f11406d = System.currentTimeMillis();
                    }
                }
            }
        }
        com.baidu.sofire.c.a.a(this.f11408b).c();
        if (2 != i) {
            this.f11407a.c(i3 + j);
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.f11408b.getPackageName())) {
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

    public final synchronized void a(com.baidu.sofire.b.a aVar) {
        e eVar = this.f11407a;
        String str = aVar.f11305d;
        SharedPreferences sharedPreferences = eVar.f11402e;
        String string = sharedPreferences.getString("re_net_ali2_" + str, "");
        String c2 = d.c();
        if (string.equals(c2)) {
            return;
        }
        String d2 = this.f11407a.d(aVar.f11305d);
        com.baidu.sofire.d.a aVar2 = new com.baidu.sofire.d.a();
        aVar2.f11388b = aVar.f11305d;
        aVar2.f11393g = 0;
        aVar2.f11389c = 2;
        aVar2.f11391e = System.currentTimeMillis();
        aVar2.f11392f = 1;
        aVar2.i = 5;
        aVar2.f11390d = d.a(this.f11408b, aVar, d2, true).toString();
        com.baidu.sofire.c.a.a(this.f11408b).a(aVar2);
        String a2 = n.a(d.m(this.f11408b).toString());
        if (com.baidu.sofire.c.a.a(this.f11408b).b(a2)) {
            aVar2.f11388b = GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND;
            aVar2.i = 0;
            aVar2.f11390d = d.a(this.f11408b, aVar.f11302a, aVar.f11304c, GameCenterCoreUtils.REF_TYPE_SINGLE_RECOMMEND, d.m(this.f11408b).toString()).toString();
            com.baidu.sofire.c.a.a(this.f11408b).a(aVar2);
            com.baidu.sofire.c.a.a(this.f11408b).a(a2);
        }
        e eVar2 = this.f11407a;
        String str2 = aVar.f11305d;
        SharedPreferences.Editor editor = eVar2.f11403f;
        editor.putString("re_net_ali2_" + str2, c2);
        eVar2.f11403f.commit();
    }

    public static /* synthetic */ void a(a aVar) {
        e eVar = new e(aVar.f11408b);
        int w = eVar.w();
        new StringBuilder(" 2").append(Integer.toString(w));
        b.a();
        long currentTimeMillis = System.currentTimeMillis() - eVar.f11402e.getLong("re_last_ofline_time", 0L);
        long j = w * 3600000;
        if (currentTimeMillis >= j) {
            com.baidu.sofire.g.e.a(aVar.f11408b).c();
            d.a(aVar.f11408b, j);
            eVar.b(System.currentTimeMillis());
            return;
        }
        d.a(aVar.f11408b, j - currentTimeMillis);
    }

    public static /* synthetic */ void a(a aVar, int i, int i2) {
        List<com.baidu.sofire.d.a> a2;
        if (i2 == 0) {
            b.a();
        } else if (a()) {
            if (i == 1) {
                a2 = com.baidu.sofire.c.a.a(aVar.f11408b).a();
                if (1 == i2) {
                    new StringBuilder(" 3g ").append(a2.size());
                    b.a();
                }
            } else if (i == 3) {
                a2 = com.baidu.sofire.c.a.a(aVar.f11408b).a(false, i2);
            } else if (i == 4) {
                a2 = com.baidu.sofire.c.a.a(aVar.f11408b).a(true, i2);
                new StringBuilder(" 3g to report ").append(a2.size());
                b.a();
            } else {
                a2 = com.baidu.sofire.c.a.a(aVar.f11408b).a(i2);
            }
            if (a2.size() > 0) {
                long j = aVar.f11407a.f11402e.getLong("re_day_len", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = aVar.f11407a.f11402e.getLong("re_day_b_t", 0L);
                int i3 = aVar.f11407a.f11402e.getInt("re_net_dy_lt", 50);
                if (j2 == 0) {
                    aVar.f11407a.d(currentTimeMillis);
                    j2 = currentTimeMillis;
                }
                b.a();
                b.a();
                if (currentTimeMillis - j2 < 86400000) {
                    if (i == 3) {
                        int i4 = aVar.f11407a.f11402e.getInt("g_r_d_d_n", 0);
                        if (i4 >= 5) {
                            return;
                        }
                        aVar.f11407a.h(i4 + 1);
                    }
                    if (j > i3 * 1048576) {
                        b.a();
                        return;
                    }
                } else {
                    aVar.f11407a.c(0L);
                    aVar.f11407a.d(currentTimeMillis);
                    if (i == 3) {
                        aVar.f11407a.h(0);
                    }
                }
                aVar.a(a2, i2, j);
                if (a() && i == 0 && i2 == 2 && a2.size() >= 100) {
                    List<com.baidu.sofire.d.a> a3 = aVar.a(i, i2);
                    while (a3 != null && a3.size() != 0) {
                        aVar.a(a3, i2, j);
                        if (a3.size() < 100 || !a()) {
                            return;
                        }
                        a3 = aVar.a(i, i2);
                    }
                }
            }
        }
    }
}
