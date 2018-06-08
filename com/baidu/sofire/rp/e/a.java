package com.baidu.sofire.rp.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.g;
import com.baidu.sofire.b.j;
import com.baidu.sofire.b.l;
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
    public HandlerC0097a a = new HandlerC0097a(j.a());
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
    public class HandlerC0097a extends Handler {
        public HandlerC0097a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.b(a.this);
                        break;
                    case 1:
                        com.baidu.sofire.rp.b.a.a(a.this.c).a((com.baidu.sofire.rp.c.a) message.obj);
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        break;
                    case 2:
                        a.a(a.this);
                        a.b(a.this);
                        a.a(a.this, 0, d.l(a.this.c));
                        break;
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
                            aVar3.d = d.a(aVar2.c, aVar, string, false).toString();
                            com.baidu.sofire.rp.b.a.a(aVar2.c).a(aVar3);
                            e eVar = aVar2.b;
                            eVar.f.putBoolean("re_net_ins_" + aVar.e, true);
                            eVar.f.commit();
                            String a = l.a(d.k(aVar2.c).toString());
                            if (com.baidu.sofire.rp.b.a.a(aVar2.c).b(a)) {
                                aVar3.b = "1001001";
                                aVar3.d = d.a(aVar2.c, aVar.a, aVar.c, aVar3.b, d.k(aVar2.c).toString()).toString();
                                com.baidu.sofire.rp.b.a.a(aVar2.c).a(aVar3);
                                com.baidu.sofire.rp.b.a.a(aVar2.c).a(a);
                                break;
                            }
                        }
                        break;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.rp.b.a.a(a.this.c).a(l.a(valueOf));
                            break;
                        }
                        break;
                    case 5:
                        a.a(a.this);
                        int e = new e(a.this.c).e();
                        new StringBuilder("sj-setTimer-start 2").append(Integer.toString(e));
                        d.a(a.this.c, e * 3600000);
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        break;
                    case 6:
                        a.a(a.this, 1, d.l(a.this.c));
                        break;
                    case 7:
                        a.b(a.this);
                        a.a(a.this, 1, d.l(a.this.c));
                        break;
                    case 8:
                        a.a(a.this, 3, d.l(a.this.c));
                        break;
                    case 9:
                        a.a(a.this, 0, 2);
                        break;
                    case 10:
                        int l = d.l(a.this.c);
                        if (2 == l) {
                            List<com.baidu.sofire.rp.c.a> b = com.baidu.sofire.rp.b.a.a(a.this.c).b();
                            if (b.size() >= new e(a.this.c).e.getInt("up_nu_co", 50)) {
                                a.a(a.this, 0, l);
                                break;
                            } else {
                                List<com.baidu.sofire.rp.c.a> a2 = com.baidu.sofire.rp.b.a.a(a.this.c).a(true, l);
                                new StringBuilder("sj-trigger report Dela ").append(a2.size());
                                if (a2.size() > 0) {
                                    a.a(a.this, 0, l);
                                    break;
                                }
                            }
                        } else if (1 == l) {
                            a.a(a.this, 4, l);
                            break;
                        }
                        break;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.d.a(new JSONArray().put(d.a(a.this.c, new JSONObject(valueOf2))).toString(), a.a(new JSONObject(valueOf2)))) {
                            d.b(a.this.c, valueOf2);
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
                d.a(th);
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
            d.a(th);
            return null;
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
            JSONObject jSONObject = new JSONObject(g.a(aVar2.a, d.a() + "plugin/v1/report/setting", "", false, true, null)).getJSONObject("c");
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
            int optInt4 = jSONObject.optInt("w");
            if (optInt4 > 0) {
                eVar.f.putInt("re_net_wt", optInt4);
                eVar.f.commit();
            }
            if (jSONObject.optInt("s1") > 0) {
                eVar.f.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                eVar.f.commit();
            }
            int optInt5 = jSONObject.optInt("s2");
            if (optInt5 > 0) {
                eVar.f.putInt("re_net_dy_lt", optInt5);
                eVar.f.commit();
            }
            int optInt6 = jSONObject.optInt(Info.kBaiduTimeKey);
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
            d.a(th);
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
                String b = d.b();
                if (!string.equals(b)) {
                    String string2 = aVar.b.e.getString("al_da" + aVar2.d, "");
                    com.baidu.sofire.rp.c.a aVar3 = new com.baidu.sofire.rp.c.a();
                    aVar3.b = aVar2.d;
                    aVar3.g = 0;
                    aVar3.c = 2;
                    aVar3.e = System.currentTimeMillis();
                    aVar3.f = 1;
                    aVar3.i = 5;
                    aVar3.d = d.a(aVar.c, aVar2, string2, true).toString();
                    com.baidu.sofire.rp.b.a.a(aVar.c).a(aVar3);
                    String a = l.a(d.k(aVar.c).toString());
                    if (com.baidu.sofire.rp.b.a.a(aVar.c).b(a)) {
                        aVar3.b = "1001001";
                        aVar3.i = 0;
                        aVar3.d = d.a(aVar.c, aVar2.a, aVar2.c, aVar3.b, d.k(aVar.c).toString()).toString();
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
        JSONObject jSONObject;
        int length;
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
            int i5 = aVar.b.e.getInt("re_net_one_lt", 5);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.sofire.rp.c.a> it = a.iterator();
            int i6 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.sofire.rp.c.a next = it.next();
                try {
                    String jSONObject2 = d.a(aVar.c, new JSONObject(next.d)).toString();
                    try {
                        jSONObject = new JSONObject(jSONObject2);
                        length = jSONObject2.length();
                    } catch (Exception e) {
                        d.a(e);
                    }
                } catch (Exception e2) {
                    d.a(e2);
                }
                if (i6 + length >= 1048576 * i5) {
                    new StringBuilder("rp once over limit : maxOnece : ").append(i5).append(" : ").append(length + i6);
                    break;
                }
                arrayList.add(Integer.valueOf(next.a));
                arrayList2.add(new b(jSONObject, next.j, next.a));
                i6 = length + i6;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= arrayList2.size()) {
                    break;
                }
                b bVar = (b) arrayList2.get(i8);
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
                i7 = i8 + 1;
            }
            if (jSONArray.length() > 0 && aVar.d.a(jSONArray.toString(), null)) {
                com.baidu.sofire.rp.b.a.a(aVar.c).a(arrayList3);
            }
            if (hashMap.size() > 0) {
                for (String str2 : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                    if (jSONArray4 != null && jSONArray4.length() > 0 && aVar.d.a(jSONArray4.toString(), str2)) {
                        com.baidu.sofire.rp.b.a.a(aVar.c).a((List) hashMap2.get(str2));
                    }
                }
            }
            com.baidu.sofire.rp.b.a.a(aVar.c).c();
            if (2 == i2) {
                return;
            }
            e eVar6 = aVar.b;
            eVar6.f.putLong("re_day_len", i6 + j);
            eVar6.f.commit();
        }
    }
}
