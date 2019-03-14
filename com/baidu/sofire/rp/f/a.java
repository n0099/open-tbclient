package com.baidu.sofire.rp.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.b;
import com.baidu.sofire.b.f;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.l;
import com.baidu.sofire.b.o;
import com.baidu.sofire.e;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    e a;
    public Context b;
    com.baidu.sofire.rp.d.a.a c;
    public com.baidu.sofire.rp.e.a d;
    private HandlerC0105a e = new HandlerC0105a(l.a());

    public a(Context context) {
        this.b = context.getApplicationContext();
        this.a = new e(this.b);
        this.c = new com.baidu.sofire.rp.d.a.a(this.b);
    }

    public final void a(Message message) {
        this.e.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.rp.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0105a extends Handler {
        public HandlerC0105a(Looper looper) {
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
                        com.baidu.sofire.rp.b.a.a(a.this.b).a((com.baidu.sofire.rp.c.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        b.a();
                        a.a(a.this);
                        a.b(a.this);
                        int m = com.baidu.sofire.b.e.m(a.this.b);
                        b.a();
                        a.a(a.this, 0, m);
                        return;
                    case 3:
                        com.baidu.sofire.rp.a.a aVar = (com.baidu.sofire.rp.a.a) message.obj;
                        if (aVar != null) {
                            a aVar2 = a.this;
                            String c = aVar2.a.c(aVar.e);
                            com.baidu.sofire.rp.c.a aVar3 = new com.baidu.sofire.rp.c.a();
                            aVar3.b = aVar.e;
                            aVar3.g = 0;
                            aVar3.c = 1;
                            aVar3.e = System.currentTimeMillis();
                            aVar3.f = 1;
                            aVar3.d = com.baidu.sofire.b.e.a(aVar2.b, aVar, c, false).toString();
                            com.baidu.sofire.rp.b.a.a(aVar2.b).a(aVar3);
                            e eVar = aVar2.a;
                            eVar.f.putBoolean("re_net_ins_" + aVar.e, true);
                            eVar.f.commit();
                            String a = o.a(com.baidu.sofire.b.e.l(aVar2.b).toString());
                            if (!com.baidu.sofire.rp.b.a.a(aVar2.b).b(a)) {
                                return;
                            }
                            aVar3.b = "1001001";
                            aVar3.d = com.baidu.sofire.b.e.a(aVar2.b, aVar.a, aVar.c, aVar3.b, com.baidu.sofire.b.e.l(aVar2.b).toString()).toString();
                            com.baidu.sofire.rp.b.a.a(aVar2.b).a(aVar3);
                            com.baidu.sofire.rp.b.a.a(aVar2.b).a(a);
                            return;
                        }
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.rp.b.a.a(a.this.b).a(o.a(valueOf));
                            return;
                        }
                        return;
                    case 5:
                        a.a(a.this);
                        a aVar4 = a.this;
                        e eVar2 = new e(aVar4.b);
                        int w = eVar2.w();
                        new StringBuilder("sj-setTimer-start 2").append(Integer.toString(w));
                        b.a();
                        long currentTimeMillis = System.currentTimeMillis() - eVar2.e.getLong("re_last_ofline_time", 0L);
                        if (currentTimeMillis >= w * 3600000) {
                            f.a(aVar4.b).c();
                            com.baidu.sofire.b.e.a(aVar4.b, w * 3600000);
                            eVar2.c(System.currentTimeMillis());
                        } else {
                            com.baidu.sofire.b.e.a(aVar4.b, (w * 3600000) - currentTimeMillis);
                        }
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        return;
                    case 6:
                        a.a(a.this, 1, com.baidu.sofire.b.e.m(a.this.b));
                        return;
                    case 7:
                        a.b(a.this);
                        a.a(a.this, 1, com.baidu.sofire.b.e.m(a.this.b));
                        return;
                    case 8:
                        b.a();
                        a.a(a.this, 3, com.baidu.sofire.b.e.m(a.this.b));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        int m2 = com.baidu.sofire.b.e.m(a.this.b);
                        if (2 == m2) {
                            b.a();
                            if (com.baidu.sofire.rp.b.a.a(a.this.b).b() >= new e(a.this.b).e.getInt("up_nu_co", 50)) {
                                b.a();
                                a.a(a.this, 0, m2);
                                return;
                            }
                            List<com.baidu.sofire.rp.c.a> a2 = com.baidu.sofire.rp.b.a.a(a.this.b).a(true, m2);
                            new StringBuilder("sj-trigger report Dela ").append(a2.size());
                            b.a();
                            if (a2.size() > 0) {
                                b.a();
                                a.a(a.this, 0, m2);
                                return;
                            }
                            return;
                        } else if (1 == m2) {
                            b.a();
                            a.a(a.this, 4, m2);
                            return;
                        } else {
                            return;
                        }
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.c.a(new JSONArray().put(com.baidu.sofire.b.e.a(a.this.b, new JSONObject(valueOf2))).toString(), a.a(new JSONObject(valueOf2)))) {
                            com.baidu.sofire.b.e.b(a.this.b, valueOf2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a();
            }
        }
    }

    static String a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 == null || !jSONObject2.has(Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                return null;
            }
            return jSONObject2.optString(Constants.VIA_REPORT_TYPE_SET_AVATAR, "");
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
            return null;
        }
    }

    private void a(List<com.baidu.sofire.rp.c.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        int i2 = 0;
        int i3 = this.a.e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.sofire.rp.c.a> it = list.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.sofire.rp.c.a next = it.next();
            try {
                String jSONObject2 = com.baidu.sofire.b.e.a(this.b, new JSONObject(next.d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length();
                } catch (Exception e) {
                    com.baidu.sofire.b.e.a();
                }
            } catch (Exception e2) {
                com.baidu.sofire.b.e.a();
            }
            if (i4 + length >= 1048576 * i3) {
                new StringBuilder("rp once over limit : maxOnece : ").append(i3).append(" : ").append(i4 + length);
                b.a();
                break;
            }
            i4 += length;
            arrayList.add(Integer.valueOf(next.a));
            arrayList2.add(new com.baidu.sofire.rp.c.b(jSONObject, next.j, next.a));
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
            com.baidu.sofire.rp.c.b bVar = (com.baidu.sofire.rp.c.b) arrayList2.get(i5);
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
        b.a();
        if (jSONArray.length() > 0) {
            if (this.c.a(jSONArray.toString(), null)) {
                b.a();
                com.baidu.sofire.rp.b.a.a(this.b).a(arrayList3);
            }
        } else {
            b.a();
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.c.a(jSONArray4.toString(), str2)) {
                    b.a();
                    com.baidu.sofire.rp.b.a.a(this.b).a((List) hashMap2.get(str2));
                }
            }
        } else {
            b.a();
        }
        com.baidu.sofire.rp.b.a.a(this.b).c();
        if (2 != i) {
            this.a.d(i4 + j);
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
        if (System.currentTimeMillis() - aVar.a.e.getLong("re_net_pu_de", 0L) < 86400000) {
            return;
        }
        com.baidu.sofire.rp.d.a.a aVar2 = aVar.c;
        try {
            String a = h.a(aVar2.a, com.baidu.sofire.b.e.b() + "p/1/rs", "", false, true);
            b.a();
            JSONObject jSONObject = new JSONObject(a).getJSONObject("c");
            e eVar = new e(aVar2.a);
            int optInt = jSONObject.optInt("n");
            if (optInt > 0) {
                eVar.f.putInt("re_net_ty", optInt);
                eVar.f.commit();
            }
            int optInt2 = jSONObject.optInt("i");
            if (optInt2 > 0) {
                eVar.f.putInt("re_net_hr", optInt2);
                eVar.f.commit();
            }
            int optInt3 = jSONObject.optInt("i2");
            if (optInt3 > 0) {
                eVar.f.putInt("re_net_hr_bc", optInt3);
                eVar.f.commit();
            }
            int optInt4 = jSONObject.optInt(Config.DEVICE_WIDTH);
            if (optInt4 > 0) {
                eVar.f.putInt("re_net_wt", optInt4);
                eVar.f.commit();
            }
            if (jSONObject.optInt("s1") > 0) {
                eVar.f.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                eVar.f.commit();
            }
            int optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
            if (optInt5 > 0) {
                eVar.f.putInt("re_net_dy_lt", optInt5);
                eVar.f.commit();
            }
            int optInt6 = jSONObject.optInt("t");
            if (optInt6 > 0) {
                eVar.f.putInt("re_net_over", optInt6);
                eVar.f.commit();
            }
            int optInt7 = jSONObject.optInt("l1");
            if (optInt7 > 0) {
                eVar.f.putInt("up_nu_co", optInt7);
                eVar.f.commit();
            }
            int optInt8 = jSONObject.optInt("l2");
            if (optInt8 > 0) {
                eVar.f.putInt("up_nu_li", optInt8);
                eVar.f.commit();
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
        e eVar2 = aVar.a;
        eVar2.f.putLong("re_net_pu_de", System.currentTimeMillis());
        eVar2.f.commit();
    }

    static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.rp.a.a> v = aVar.a.v();
        if (v == null) {
            return;
        }
        for (com.baidu.sofire.rp.a.a aVar2 : v) {
            if (aVar.a(aVar.a.e.getString("li_pk_s", ""), aVar2.b)) {
                String string = aVar.a.e.getString("re_net_ali2_" + aVar2.d, "");
                String c = com.baidu.sofire.b.e.c();
                if (!string.equals(c)) {
                    String c2 = aVar.a.c(aVar2.d);
                    com.baidu.sofire.rp.c.a aVar3 = new com.baidu.sofire.rp.c.a();
                    aVar3.b = aVar2.d;
                    aVar3.g = 0;
                    aVar3.c = 2;
                    aVar3.e = System.currentTimeMillis();
                    aVar3.f = 1;
                    aVar3.i = 5;
                    aVar3.d = com.baidu.sofire.b.e.a(aVar.b, aVar2, c2, true).toString();
                    com.baidu.sofire.rp.b.a.a(aVar.b).a(aVar3);
                    String a = o.a(com.baidu.sofire.b.e.l(aVar.b).toString());
                    if (com.baidu.sofire.rp.b.a.a(aVar.b).b(a)) {
                        aVar3.b = "1001001";
                        aVar3.i = 0;
                        aVar3.d = com.baidu.sofire.b.e.a(aVar.b, aVar2.a, aVar2.c, aVar3.b, com.baidu.sofire.b.e.l(aVar.b).toString()).toString();
                        com.baidu.sofire.rp.b.a.a(aVar.b).a(aVar3);
                        com.baidu.sofire.rp.b.a.a(aVar.b).a(a);
                    }
                    e eVar = aVar.a;
                    eVar.f.putString("re_net_ali2_" + aVar2.d, c);
                    eVar.f.commit();
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        List<com.baidu.sofire.rp.c.a> a;
        if (i2 == 0) {
            b.a();
            return;
        }
        if (i == 1) {
            a = com.baidu.sofire.rp.b.a.a(aVar.b).a();
            if (1 == i2) {
                new StringBuilder("sj-trigger report 3g ").append(a.size());
                b.a();
            }
        } else if (i == 3) {
            a = com.baidu.sofire.rp.b.a.a(aVar.b).a(false, i2);
        } else if (i == 4) {
            a = com.baidu.sofire.rp.b.a.a(aVar.b).a(true, i2);
            new StringBuilder("sj-trigger report 3g to report ").append(a.size());
            b.a();
        } else {
            a = com.baidu.sofire.rp.b.a.a(aVar.b).a(i2);
        }
        if (a.size() <= 0) {
            b.a();
            return;
        }
        long j = aVar.a.e.getLong("re_day_len", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = aVar.a.e.getLong("re_day_b_t", 0L);
        int i3 = aVar.a.e.getInt("re_net_dy_lt", 50);
        if (j2 == 0) {
            aVar.a.e(currentTimeMillis);
            j2 = currentTimeMillis;
        }
        b.a();
        b.a();
        if (currentTimeMillis - j2 < 86400000) {
            b.a();
            if (i == 3) {
                int i4 = aVar.a.e.getInt("g_r_d_d_n", 0);
                b.a();
                if (i4 >= 5) {
                    b.a();
                    return;
                }
                aVar.a.h(i4 + 1);
            }
            if (j > 1048576 * i3) {
                new StringBuilder("rp over limit : maxday : ").append(i3).append(" : ").append(j);
                b.a();
                return;
            }
        } else {
            aVar.a.d(0L);
            aVar.a.e(currentTimeMillis);
            if (i == 3) {
                aVar.a.h(0);
            }
        }
        do {
            aVar.a(a, i2, j);
            if (i != 0) {
                a = null;
            } else if (i2 != 2) {
                a = null;
            } else {
                a = com.baidu.sofire.rp.b.a.a(aVar.b).a(i2);
            }
            if (a == null) {
                return;
            }
        } while (a.size() != 0);
    }
}
