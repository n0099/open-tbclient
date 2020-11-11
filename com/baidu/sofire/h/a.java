package com.baidu.sofire.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.baidu.sofire.i.g;
import com.baidu.sofire.i.m;
import com.baidu.sofire.i.p;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class a {
    public static long d = 0;

    /* renamed from: a  reason: collision with root package name */
    public e f3628a;
    public Context b;
    public Receiver c;
    private HandlerC0359a e = new HandlerC0359a(m.a());
    private com.baidu.sofire.g.a f;

    public a(Context context) {
        this.b = context.getApplicationContext();
        this.f3628a = new e(this.b);
        this.f = new com.baidu.sofire.g.a(this.b);
    }

    public final void a(Message message) {
        this.e.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class HandlerC0359a extends Handler {
        public HandlerC0359a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.c(a.this);
                        break;
                    case 1:
                        com.baidu.sofire.e.a.a(a.this.b).a((com.baidu.sofire.f.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        break;
                    case 2:
                        b.a();
                        a.c(a.this);
                        a.a(a.this, 0, com.baidu.sofire.i.e.m(a.this.b));
                        break;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.e.a.a(a.this.b).a(p.a(valueOf));
                            break;
                        }
                        break;
                    case 5:
                        com.baidu.sofire.j.a.a().a(a.this.b, null);
                        a.b(a.this);
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        break;
                    case 6:
                        int m = com.baidu.sofire.i.e.m(a.this.b);
                        if (2 == m) {
                            a.a(a.this, 0, m);
                            break;
                        } else {
                            a.a(a.this, 1, m);
                            break;
                        }
                    case 7:
                        a.c(a.this);
                        int m2 = com.baidu.sofire.i.e.m(a.this.b);
                        if (2 == m2) {
                            a.a(a.this, 0, m2);
                            break;
                        } else {
                            a.a(a.this, 1, m2);
                            break;
                        }
                    case 8:
                        a.a(a.this, 3, com.baidu.sofire.i.e.m(a.this.b));
                        break;
                    case 9:
                        a.a(a.this, 0, 2);
                        break;
                    case 10:
                        int m3 = com.baidu.sofire.i.e.m(a.this.b);
                        if (2 == m3) {
                            b.a();
                            if (com.baidu.sofire.e.a.a(a.this.b).b() < new e(a.this.b).e.getInt("up_nu_co", 50)) {
                                List<com.baidu.sofire.f.a> a2 = com.baidu.sofire.e.a.a(a.this.b).a(true, m3);
                                new StringBuilder(" Dela ").append(a2.size());
                                b.a();
                                if (a2.size() > 0) {
                                    b.a();
                                    a.a(a.this, 0, m3);
                                    break;
                                }
                            } else {
                                b.a();
                                a.a(a.this, 0, m3);
                                break;
                            }
                        } else if (1 == m3) {
                            b.a();
                            a.a(a.this, 4, m3);
                            break;
                        }
                        break;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        JSONObject a3 = com.baidu.sofire.i.e.a(a.this.b, new JSONObject(valueOf2));
                        com.baidu.sofire.g.a aVar = a.this.f;
                        String jSONArray = new JSONArray().put(a3).toString();
                        a.b(new JSONObject(valueOf2));
                        if (!aVar.a(jSONArray)) {
                            com.baidu.sofire.i.e.a(a.this.b, valueOf2);
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 == null || !jSONObject2.has("12")) {
                return null;
            }
            return jSONObject2.optString("12", "");
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return null;
        }
    }

    private static boolean a() {
        if (d > 0) {
            if (System.currentTimeMillis() - d < 300000) {
                return false;
            }
            d = 0L;
        }
        return true;
    }

    private List<com.baidu.sofire.f.a> a(int i, int i2) {
        if (i == 0 && i2 == 2) {
            return com.baidu.sofire.e.a.a(this.b).a(i2);
        }
        return null;
    }

    private void a(List<com.baidu.sofire.f.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        int i2 = 0;
        int i3 = this.f3628a.e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.sofire.f.a> it = list.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.sofire.f.a next = it.next();
            try {
                String jSONObject2 = com.baidu.sofire.i.e.a(this.b, new JSONObject(next.d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length();
                } catch (Exception e) {
                    com.baidu.sofire.i.e.a();
                }
            } catch (Exception e2) {
                com.baidu.sofire.i.e.a();
            }
            if (i4 + length >= 1048576 * i3) {
                new StringBuilder().append(i3).append(" : ").append(i4 + length);
                b.a();
                break;
            }
            i4 += length;
            arrayList.add(Integer.valueOf(next.f3624a));
            arrayList2.add(new com.baidu.sofire.f.b(jSONObject, next.j, next.f3624a));
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        while (true) {
            int i5 = i2;
            if (i5 >= arrayList2.size()) {
                break;
            }
            com.baidu.sofire.f.b bVar = (com.baidu.sofire.f.b) arrayList2.get(i5);
            if (bVar != null) {
                String str = bVar.b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f3625a);
                    arrayList3.add(Integer.valueOf(bVar.c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f3625a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f3625a);
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
            i2 = i5 + 1;
        }
        if (jSONArray.length() > 0) {
            if (this.f.a(jSONArray.toString())) {
                com.baidu.sofire.e.a.a(this.b).a(arrayList3);
            } else {
                d = System.currentTimeMillis();
            }
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    if (this.f.a(jSONArray4.toString())) {
                        com.baidu.sofire.e.a.a(this.b).a((List) hashMap2.get(str2));
                    } else {
                        d = System.currentTimeMillis();
                    }
                }
            }
        }
        com.baidu.sofire.e.a.a(this.b).c();
        if (2 != i) {
            this.f3628a.c(i4 + j);
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.b.getPackageName())) {
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
        } catch (Exception e) {
            return false;
        }
    }

    public final synchronized void a(com.baidu.sofire.d.a aVar) {
        String string = this.f3628a.e.getString("re_net_ali2_" + aVar.d, "");
        String c = com.baidu.sofire.i.e.c();
        if (!string.equals(c)) {
            String d2 = this.f3628a.d(aVar.d);
            com.baidu.sofire.f.a aVar2 = new com.baidu.sofire.f.a();
            aVar2.b = aVar.d;
            aVar2.g = 0;
            aVar2.c = 2;
            aVar2.e = System.currentTimeMillis();
            aVar2.f = 1;
            aVar2.i = 5;
            aVar2.d = com.baidu.sofire.i.e.a(this.b, aVar, d2, true).toString();
            com.baidu.sofire.e.a.a(this.b).a(aVar2);
            String a2 = p.a(com.baidu.sofire.i.e.l(this.b).toString());
            if (com.baidu.sofire.e.a.a(this.b).b(a2)) {
                aVar2.b = "1001001";
                aVar2.i = 0;
                aVar2.d = com.baidu.sofire.i.e.a(this.b, aVar.f3620a, aVar.c, aVar2.b, com.baidu.sofire.i.e.l(this.b).toString()).toString();
                com.baidu.sofire.e.a.a(this.b).a(aVar2);
                com.baidu.sofire.e.a.a(this.b).a(a2);
            }
            e eVar = this.f3628a;
            eVar.f.putString("re_net_ali2_" + aVar.d, c);
            eVar.f.commit();
        }
    }

    static /* synthetic */ void b(a aVar) {
        e eVar = new e(aVar.b);
        int y = eVar.y();
        new StringBuilder(" 2").append(Integer.toString(y));
        b.a();
        long currentTimeMillis = System.currentTimeMillis() - eVar.e.getLong("re_last_ofline_time", 0L);
        if (currentTimeMillis >= y * 3600000) {
            g.a(aVar.b).c();
            com.baidu.sofire.i.e.a(aVar.b, y * 3600000);
            eVar.b(System.currentTimeMillis());
            return;
        }
        com.baidu.sofire.i.e.a(aVar.b, (y * 3600000) - currentTimeMillis);
    }

    static /* synthetic */ void c(a aVar) {
        List<com.baidu.sofire.d.a> x = aVar.f3628a.x();
        if (x == null) {
            return;
        }
        for (com.baidu.sofire.d.a aVar2 : x) {
            if (aVar.a(aVar.f3628a.e.getString("li_pk_s", ""), aVar2.b)) {
                aVar.a(aVar2);
            }
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        List<com.baidu.sofire.f.a> a2;
        if (i2 == 0) {
            b.a();
        } else if (a()) {
            if (i == 1) {
                a2 = com.baidu.sofire.e.a.a(aVar.b).a();
                if (1 == i2) {
                    new StringBuilder(" 3g ").append(a2.size());
                    b.a();
                }
            } else if (i == 3) {
                a2 = com.baidu.sofire.e.a.a(aVar.b).a(false, i2);
            } else if (i == 4) {
                a2 = com.baidu.sofire.e.a.a(aVar.b).a(true, i2);
                new StringBuilder(" 3g to report ").append(a2.size());
                b.a();
            } else {
                a2 = com.baidu.sofire.e.a.a(aVar.b).a(i2);
            }
            if (a2.size() <= 0) {
                return;
            }
            long j = aVar.f3628a.e.getLong("re_day_len", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = aVar.f3628a.e.getLong("re_day_b_t", 0L);
            int i3 = aVar.f3628a.e.getInt("re_net_dy_lt", 50);
            if (j2 == 0) {
                aVar.f3628a.d(currentTimeMillis);
                j2 = currentTimeMillis;
            }
            b.a();
            b.a();
            if (currentTimeMillis - j2 < 86400000) {
                if (i == 3) {
                    int i4 = aVar.f3628a.e.getInt("g_r_d_d_n", 0);
                    if (i4 < 5) {
                        aVar.f3628a.h(i4 + 1);
                    } else {
                        return;
                    }
                }
                if (j > i3 * 1048576) {
                    b.a();
                    return;
                }
            } else {
                aVar.f3628a.c(0L);
                aVar.f3628a.d(currentTimeMillis);
                if (i == 3) {
                    aVar.f3628a.h(0);
                }
            }
            aVar.a(a2, i2, j);
            if (!a()) {
                return;
            }
            List<com.baidu.sofire.f.a> a3 = aVar.a(i, i2);
            while (a3 != null && a3.size() != 0) {
                aVar.a(a3, i2, j);
                if (!a()) {
                    return;
                }
                a3 = aVar.a(i, i2);
            }
        }
    }
}
