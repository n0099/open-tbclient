package com.baidu.sofire.rp.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.b.f;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.l;
import com.baidu.sofire.b.n;
import com.baidu.sofire.e;
import com.baidu.sofire.rp.c.b;
import com.baidu.sofire.rp.receiver.Receiver;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public HandlerC0117a a = new HandlerC0117a(l.a());
    e b;
    public Context c;
    com.baidu.sofire.rp.d.a.a d;
    public Receiver e;

    public a(Context context) {
        this.c = context.getApplicationContext();
        this.b = new e(this.c);
        this.d = new com.baidu.sofire.rp.d.a.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.rp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0117a extends Handler {
        public HandlerC0117a(Looper looper) {
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
                        com.baidu.sofire.rp.b.a.a(a.this.c).a((com.baidu.sofire.rp.c.a) message.obj);
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        a.a(a.this);
                        a.b(a.this);
                        a.a(a.this, 0, com.baidu.sofire.b.e.l(a.this.c));
                        return;
                    case 3:
                        com.baidu.sofire.rp.a.a aVar = (com.baidu.sofire.rp.a.a) message.obj;
                        if (aVar != null) {
                            a aVar2 = a.this;
                            String string = aVar2.b.e.getString("al_da" + aVar.e, "");
                            com.baidu.sofire.rp.c.a aVar3 = new com.baidu.sofire.rp.c.a();
                            aVar3.b = aVar.e;
                            aVar3.g = 0;
                            aVar3.c = 1;
                            aVar3.e = System.currentTimeMillis();
                            aVar3.f = 1;
                            aVar3.d = com.baidu.sofire.b.e.a(aVar2.c, aVar, string, false).toString();
                            com.baidu.sofire.rp.b.a.a(aVar2.c).a(aVar3);
                            e eVar = aVar2.b;
                            eVar.f.putBoolean("re_net_ins_" + aVar.e, true);
                            eVar.f.commit();
                            String a = n.a(com.baidu.sofire.b.e.k(aVar2.c).toString());
                            if (!com.baidu.sofire.rp.b.a.a(aVar2.c).b(a)) {
                                return;
                            }
                            aVar3.b = "1001001";
                            aVar3.d = com.baidu.sofire.b.e.a(aVar2.c, aVar.a, aVar.c, aVar3.b, com.baidu.sofire.b.e.k(aVar2.c).toString()).toString();
                            com.baidu.sofire.rp.b.a.a(aVar2.c).a(aVar3);
                            com.baidu.sofire.rp.b.a.a(aVar2.c).a(a);
                            return;
                        }
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.rp.b.a.a(a.this.c).a(n.a(valueOf));
                            return;
                        }
                        return;
                    case 5:
                        a.a(a.this);
                        a aVar4 = a.this;
                        e eVar2 = new e(aVar4.c);
                        int e = eVar2.e();
                        new StringBuilder("sj-setTimer-start 2").append(Integer.toString(e));
                        long currentTimeMillis = System.currentTimeMillis() - eVar2.e.getLong("re_last_ofline_time", 0L);
                        if (currentTimeMillis >= e * 3600000) {
                            f a2 = f.a(aVar4.c);
                            Message message3 = new Message();
                            message3.what = 2;
                            a2.a.a.sendMessage(message3);
                            com.baidu.sofire.b.e.a(aVar4.c, e * 3600000);
                            eVar2.f.putLong("re_last_ofline_time", System.currentTimeMillis());
                            eVar2.f.commit();
                        } else {
                            com.baidu.sofire.b.e.a(aVar4.c, (e * 3600000) - currentTimeMillis);
                        }
                        Message message4 = new Message();
                        message4.what = 10;
                        sendMessage(message4);
                        return;
                    case 6:
                        a.a(a.this, 1, com.baidu.sofire.b.e.l(a.this.c));
                        return;
                    case 7:
                        a.b(a.this);
                        a.a(a.this, 1, com.baidu.sofire.b.e.l(a.this.c));
                        return;
                    case 8:
                        a.a(a.this, 3, com.baidu.sofire.b.e.l(a.this.c));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        int l = com.baidu.sofire.b.e.l(a.this.c);
                        if (2 == l) {
                            if (com.baidu.sofire.rp.b.a.a(a.this.c).b() >= new e(a.this.c).e.getInt("up_nu_co", 50)) {
                                a.a(a.this, 0, l);
                                return;
                            }
                            List<com.baidu.sofire.rp.c.a> a3 = com.baidu.sofire.rp.b.a.a(a.this.c).a(true, l);
                            new StringBuilder("sj-trigger report Dela ").append(a3.size());
                            if (a3.size() > 0) {
                                a.a(a.this, 0, l);
                                return;
                            }
                            return;
                        } else if (1 == l) {
                            a.a(a.this, 4, l);
                            return;
                        } else {
                            return;
                        }
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.d.a(new JSONArray().put(com.baidu.sofire.b.e.a(a.this.c, new JSONObject(valueOf2))).toString(), a.a(new JSONObject(valueOf2)))) {
                            com.baidu.sofire.b.e.b(a.this.c, valueOf2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
            return null;
        }
    }

    private void a(List<com.baidu.sofire.rp.c.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        int i2 = 0;
        int i3 = this.b.e.getInt("re_net_one_lt", 5);
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
                String jSONObject2 = com.baidu.sofire.b.e.a(this.c, new JSONObject(next.d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length();
                } catch (Exception e) {
                    com.baidu.sofire.b.e.a(e);
                }
            } catch (Exception e2) {
                com.baidu.sofire.b.e.a(e2);
            }
            if (i4 + length >= 1048576 * i3) {
                new StringBuilder("rp once over limit : maxOnece : ").append(i3).append(" : ").append(i4 + length);
                break;
            }
            i4 += length;
            arrayList.add(Integer.valueOf(next.a));
            arrayList2.add(new b(jSONObject, next.j, next.a));
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
            b bVar = (b) arrayList2.get(i5);
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
        if (jSONArray.length() > 0 && this.d.a(jSONArray.toString(), null)) {
            com.baidu.sofire.rp.b.a.a(this.c).a(arrayList3);
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.d.a(jSONArray4.toString(), str2)) {
                    com.baidu.sofire.rp.b.a.a(this.c).a((List) hashMap2.get(str2));
                }
            }
        }
        com.baidu.sofire.rp.b.a.a(this.c).c();
        if (2 != i) {
            e eVar = this.b;
            eVar.f.putLong("re_day_len", i4 + j);
            eVar.f.commit();
        }
    }

    private boolean a(String str, String str2) {
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
        } catch (Exception e) {
            return false;
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (System.currentTimeMillis() - aVar.b.e.getLong("re_net_pu_de", 0L) < 86400000) {
            return;
        }
        com.baidu.sofire.rp.d.a.a aVar2 = aVar.d;
        try {
            JSONObject jSONObject = new JSONObject(h.a(aVar2.a, com.baidu.sofire.b.e.a() + "p/1/rs", "", false, true)).getJSONObject("c");
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
            com.baidu.sofire.b.e.a(th);
        }
        e eVar2 = aVar.b;
        eVar2.f.putLong("re_net_pu_de", System.currentTimeMillis());
        eVar2.f.commit();
    }

    static /* synthetic */ void b(a aVar) {
        List<com.baidu.sofire.rp.a.a> d = aVar.b.d();
        if (d == null) {
            return;
        }
        for (com.baidu.sofire.rp.a.a aVar2 : d) {
            if (aVar.a(aVar.b.e.getString("li_pk_s", ""), aVar2.b)) {
                String string = aVar.b.e.getString("re_net_ali2_" + aVar2.d, "");
                String b = com.baidu.sofire.b.e.b();
                if (!string.equals(b)) {
                    String string2 = aVar.b.e.getString("al_da" + aVar2.d, "");
                    com.baidu.sofire.rp.c.a aVar3 = new com.baidu.sofire.rp.c.a();
                    aVar3.b = aVar2.d;
                    aVar3.g = 0;
                    aVar3.c = 2;
                    aVar3.e = System.currentTimeMillis();
                    aVar3.f = 1;
                    aVar3.i = 5;
                    aVar3.d = com.baidu.sofire.b.e.a(aVar.c, aVar2, string2, true).toString();
                    com.baidu.sofire.rp.b.a.a(aVar.c).a(aVar3);
                    String a = n.a(com.baidu.sofire.b.e.k(aVar.c).toString());
                    if (com.baidu.sofire.rp.b.a.a(aVar.c).b(a)) {
                        aVar3.b = "1001001";
                        aVar3.i = 0;
                        aVar3.d = com.baidu.sofire.b.e.a(aVar.c, aVar2.a, aVar2.c, aVar3.b, com.baidu.sofire.b.e.k(aVar.c).toString()).toString();
                        com.baidu.sofire.rp.b.a.a(aVar.c).a(aVar3);
                        com.baidu.sofire.rp.b.a.a(aVar.c).a(a);
                    }
                    e eVar = aVar.b;
                    eVar.f.putString("re_net_ali2_" + aVar2.d, b);
                    eVar.f.commit();
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        List<com.baidu.sofire.rp.c.a> a;
        List<com.baidu.sofire.rp.c.a> a2;
        if (i2 != 0) {
            if (i == 1) {
                a = com.baidu.sofire.rp.b.a.a(aVar.c).a();
                if (1 == i2) {
                    new StringBuilder("sj-trigger report 3g ").append(a.size());
                }
            } else if (i == 3) {
                a = com.baidu.sofire.rp.b.a.a(aVar.c).a(false, i2);
            } else if (i == 4) {
                a = com.baidu.sofire.rp.b.a.a(aVar.c).a(true, i2);
                new StringBuilder("sj-trigger report 3g to report ").append(a.size());
            } else {
                a = com.baidu.sofire.rp.b.a.a(aVar.c).a(i2);
            }
            if (a.size() <= 0) {
                return;
            }
            long j = aVar.b.e.getLong("re_day_len", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = aVar.b.e.getLong("re_day_b_t", 0L);
            int i3 = aVar.b.e.getInt("re_net_dy_lt", 50);
            if (j2 == 0) {
                e eVar = aVar.b;
                eVar.f.putLong("re_day_b_t", currentTimeMillis);
                eVar.f.commit();
                j2 = currentTimeMillis;
            }
            if (currentTimeMillis - j2 < 86400000) {
                if (i == 3) {
                    int i4 = aVar.b.e.getInt("g_r_d_d_n", 0);
                    if (i4 < 5) {
                        e eVar2 = aVar.b;
                        eVar2.f.putInt("g_r_d_d_n", i4 + 1);
                        eVar2.f.commit();
                    } else {
                        return;
                    }
                }
                if (j > 1048576 * i3) {
                    new StringBuilder("rp over limit : maxday : ").append(i3).append(" : ").append(j);
                    return;
                }
            } else {
                e eVar3 = aVar.b;
                eVar3.f.putLong("re_day_len", 0L);
                eVar3.f.commit();
                e eVar4 = aVar.b;
                eVar4.f.putLong("re_day_b_t", currentTimeMillis);
                eVar4.f.commit();
                if (i == 3) {
                    e eVar5 = aVar.b;
                    eVar5.f.putInt("g_r_d_d_n", 0);
                    eVar5.f.commit();
                }
            }
            aVar.a(a, i2, j);
            if (i != 0) {
                a2 = null;
            } else if (i2 != 2) {
                a2 = null;
            } else {
                a2 = com.baidu.sofire.rp.b.a.a(aVar.c).a(i2);
            }
            while (a2 != null && a2.size() != 0) {
                aVar.a(a2, i2, j);
                if (i != 0) {
                    a2 = null;
                } else if (i2 != 2) {
                    a2 = null;
                } else {
                    a2 = com.baidu.sofire.rp.b.a.a(aVar.c).a(i2);
                }
            }
        }
    }
}
