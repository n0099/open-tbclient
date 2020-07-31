package com.baidu.sofire.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.baidu.sofire.i.d;
import com.baidu.sofire.i.f;
import com.baidu.sofire.i.l;
import com.baidu.sofire.i.o;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    e a;
    public Context b;
    com.baidu.sofire.g.a c;
    public Receiver d;
    private HandlerC0286a e = new HandlerC0286a(l.a());

    public a(Context context) {
        this.b = context.getApplicationContext();
        this.a = new e(this.b);
        this.c = new com.baidu.sofire.g.a(this.b);
    }

    public final void a(Message message) {
        this.e.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0286a extends Handler {
        public HandlerC0286a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.a(a.this);
                        return;
                    case 1:
                        com.baidu.sofire.e.a.a(a.this.b).a((com.baidu.sofire.f.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        b.a();
                        a.a(a.this);
                        a.a(a.this, 0, d.m(a.this.b));
                        return;
                    case 3:
                        com.baidu.sofire.d.a aVar = (com.baidu.sofire.d.a) message.obj;
                        if (aVar != null) {
                            a aVar2 = a.this;
                            String d = aVar2.a.d(aVar.e);
                            com.baidu.sofire.f.a aVar3 = new com.baidu.sofire.f.a();
                            aVar3.b = aVar.e;
                            aVar3.g = 0;
                            aVar3.c = 1;
                            aVar3.e = System.currentTimeMillis();
                            aVar3.f = 1;
                            aVar3.d = d.a(aVar2.b, aVar, d, false).toString();
                            com.baidu.sofire.e.a.a(aVar2.b).a(aVar3);
                            e eVar = aVar2.a;
                            eVar.f.putBoolean("re_net_ins_" + aVar.e, true);
                            eVar.f.commit();
                            String a = o.a(d.l(aVar2.b).toString());
                            if (!com.baidu.sofire.e.a.a(aVar2.b).b(a)) {
                                return;
                            }
                            aVar3.b = "1001001";
                            aVar3.d = d.a(aVar2.b, aVar.a, aVar.c, aVar3.b, d.l(aVar2.b).toString()).toString();
                            com.baidu.sofire.e.a.a(aVar2.b).a(aVar3);
                            com.baidu.sofire.e.a.a(aVar2.b).a(a);
                            return;
                        }
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.e.a.a(a.this.b).a(o.a(valueOf));
                            return;
                        }
                        return;
                    case 5:
                        a aVar4 = a.this;
                        e eVar2 = new e(aVar4.b);
                        int y = eVar2.y();
                        new StringBuilder(" 2").append(Integer.toString(y));
                        b.a();
                        long currentTimeMillis = System.currentTimeMillis() - eVar2.e.getLong("re_last_ofline_time", 0L);
                        if (currentTimeMillis >= y * 3600000) {
                            f.a(aVar4.b).c();
                            d.a(aVar4.b, y * 3600000);
                            eVar2.b(System.currentTimeMillis());
                        } else {
                            d.a(aVar4.b, (y * 3600000) - currentTimeMillis);
                        }
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        return;
                    case 6:
                        a.a(a.this, 1, d.m(a.this.b));
                        return;
                    case 7:
                        a.a(a.this);
                        a.a(a.this, 1, d.m(a.this.b));
                        return;
                    case 8:
                        a.a(a.this, 3, d.m(a.this.b));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        int m = d.m(a.this.b);
                        if (2 == m) {
                            b.a();
                            if (com.baidu.sofire.e.a.a(a.this.b).b() >= new e(a.this.b).e.getInt("up_nu_co", 50)) {
                                b.a();
                                a.a(a.this, 0, m);
                                return;
                            }
                            List<com.baidu.sofire.f.a> a2 = com.baidu.sofire.e.a.a(a.this.b).a(true, m);
                            new StringBuilder(" Dela ").append(a2.size());
                            b.a();
                            if (a2.size() > 0) {
                                b.a();
                                a.a(a.this, 0, m);
                                return;
                            }
                            return;
                        } else if (1 == m) {
                            b.a();
                            a.a(a.this, 4, m);
                            return;
                        } else {
                            return;
                        }
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        JSONObject a3 = d.a(a.this.b, new JSONObject(valueOf2));
                        com.baidu.sofire.g.a aVar5 = a.this.c;
                        String jSONArray = new JSONArray().put(a3).toString();
                        a.a(new JSONObject(valueOf2));
                        if (!aVar5.a(jSONArray)) {
                            d.a(a.this.b, valueOf2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                d.a();
            }
        }
    }

    static String a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 == null || !jSONObject2.has("12")) {
                return null;
            }
            return jSONObject2.optString("12", "");
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    private static boolean a() {
        if (com.baidu.sofire.e.a.a > 0 && System.currentTimeMillis() - com.baidu.sofire.e.a.a < 600000) {
            return false;
        }
        if (System.currentTimeMillis() - com.baidu.sofire.e.a.a > 600000) {
            com.baidu.sofire.e.a.a = 0L;
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
        int i3 = this.a.e.getInt("re_net_one_lt", 5);
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
                String jSONObject2 = d.a(this.b, new JSONObject(next.d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length();
                } catch (Exception e) {
                    d.a();
                }
            } catch (Exception e2) {
                d.a();
            }
            if (i4 + length >= 1048576 * i3) {
                new StringBuilder().append(i3).append(" : ").append(i4 + length);
                b.a();
                break;
            }
            i4 += length;
            arrayList.add(Integer.valueOf(next.a));
            arrayList2.add(new com.baidu.sofire.f.b(jSONObject, next.j, next.a));
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
            i2 = i5 + 1;
        }
        if (jSONArray.length() > 0 && this.c.a(jSONArray.toString())) {
            com.baidu.sofire.e.a.a(this.b).a(arrayList3);
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.c.a(jSONArray4.toString())) {
                    com.baidu.sofire.e.a.a(this.b).a((List) hashMap2.get(str2));
                }
            }
        }
        com.baidu.sofire.e.a.a(this.b).c();
        if (2 != i) {
            this.a.c(i4 + j);
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

    static /* synthetic */ void a(a aVar) {
        List<com.baidu.sofire.d.a> x = aVar.a.x();
        if (x == null) {
            return;
        }
        for (com.baidu.sofire.d.a aVar2 : x) {
            if (aVar.a(aVar.a.e.getString("li_pk_s", ""), aVar2.b)) {
                String string = aVar.a.e.getString("re_net_ali2_" + aVar2.d, "");
                String c = d.c();
                if (!string.equals(c)) {
                    String d = aVar.a.d(aVar2.d);
                    com.baidu.sofire.f.a aVar3 = new com.baidu.sofire.f.a();
                    aVar3.b = aVar2.d;
                    aVar3.g = 0;
                    aVar3.c = 2;
                    aVar3.e = System.currentTimeMillis();
                    aVar3.f = 1;
                    aVar3.i = 5;
                    aVar3.d = d.a(aVar.b, aVar2, d, true).toString();
                    com.baidu.sofire.e.a.a(aVar.b).a(aVar3);
                    String a = o.a(d.l(aVar.b).toString());
                    if (com.baidu.sofire.e.a.a(aVar.b).b(a)) {
                        aVar3.b = "1001001";
                        aVar3.i = 0;
                        aVar3.d = d.a(aVar.b, aVar2.a, aVar2.c, aVar3.b, d.l(aVar.b).toString()).toString();
                        com.baidu.sofire.e.a.a(aVar.b).a(aVar3);
                        com.baidu.sofire.e.a.a(aVar.b).a(a);
                    }
                    e eVar = aVar.a;
                    eVar.f.putString("re_net_ali2_" + aVar2.d, c);
                    eVar.f.commit();
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        List<com.baidu.sofire.f.a> a;
        if (i2 == 0) {
            b.a();
        } else if (a()) {
            if (i == 1) {
                a = com.baidu.sofire.e.a.a(aVar.b).a();
                if (1 == i2) {
                    new StringBuilder(" 3g ").append(a.size());
                    b.a();
                }
            } else if (i == 3) {
                a = com.baidu.sofire.e.a.a(aVar.b).a(false, i2);
            } else if (i == 4) {
                a = com.baidu.sofire.e.a.a(aVar.b).a(true, i2);
                new StringBuilder(" 3g to report ").append(a.size());
                b.a();
            } else {
                a = com.baidu.sofire.e.a.a(aVar.b).a(i2);
            }
            if (a.size() <= 0) {
                return;
            }
            long j = aVar.a.e.getLong("re_day_len", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = aVar.a.e.getLong("re_day_b_t", 0L);
            int i3 = aVar.a.e.getInt("re_net_dy_lt", 50);
            if (j2 == 0) {
                aVar.a.d(currentTimeMillis);
                j2 = currentTimeMillis;
            }
            b.a();
            b.a();
            if (currentTimeMillis - j2 < 86400000) {
                if (i == 3) {
                    int i4 = aVar.a.e.getInt("g_r_d_d_n", 0);
                    if (i4 < 5) {
                        aVar.a.h(i4 + 1);
                    } else {
                        return;
                    }
                }
                if (j > i3 * 1048576) {
                    b.a();
                    return;
                }
            } else {
                aVar.a.c(0L);
                aVar.a.d(currentTimeMillis);
                if (i == 3) {
                    aVar.a.h(0);
                }
            }
            aVar.a(a, i2, j);
            if (!a()) {
                return;
            }
            List<com.baidu.sofire.f.a> a2 = aVar.a(i, i2);
            while (a2 != null && a2.size() != 0) {
                aVar.a(a2, i2, j);
                if (!a()) {
                    return;
                }
                a2 = aVar.a(i, i2);
            }
        }
    }
}
