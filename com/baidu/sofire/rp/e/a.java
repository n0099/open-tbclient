package com.baidu.sofire.rp.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.f;
import com.baidu.sofire.b.j;
import com.baidu.sofire.rp.a.b;
import com.baidu.sofire.rp.f.c;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public HandlerC0067a aFv = new HandlerC0067a(c.uT());
    com.baidu.sofire.rp.a.a aFw;
    com.baidu.sofire.rp.d.a.a aFx;
    public Receiver aFy;
    public Context c;

    public a(Context context) {
        this.c = context.getApplicationContext();
        this.aFw = new com.baidu.sofire.rp.a.a(this.c);
        this.aFx = new com.baidu.sofire.rp.d.a.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.rp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0067a extends Handler {
        public HandlerC0067a(Looper looper) {
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
                        com.baidu.sofire.rp.b.a.aD(a.this.c).a((com.baidu.sofire.rp.c.a) message.obj);
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        break;
                    case 2:
                        a.a(a.this);
                        a.b(a.this);
                        a.a(a.this, 0, com.baidu.sofire.rp.f.a.a(a.this.c));
                        break;
                    case 3:
                        b bVar = (b) message.obj;
                        if (bVar != null) {
                            a aVar = a.this;
                            String string = aVar.aFw.a.getString("al_da" + bVar.e, "");
                            com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
                            aVar2.b = bVar.e;
                            aVar2.g = 0;
                            aVar2.c = 1;
                            aVar2.e = System.currentTimeMillis();
                            aVar2.f = 1;
                            aVar2.d = com.baidu.sofire.rp.f.a.a(aVar.c, bVar, string, false).toString();
                            com.baidu.sofire.rp.b.a.aD(aVar.c).a(aVar2);
                            com.baidu.sofire.rp.a.a aVar3 = aVar.aFw;
                            aVar3.c.putBoolean("re_net_ins_" + bVar.e, true);
                            aVar3.c.commit();
                            String a = j.a(com.baidu.sofire.rp.f.a.aE(aVar.c).toString());
                            if (com.baidu.sofire.rp.b.a.aD(aVar.c).b(a)) {
                                aVar2.b = "1001001";
                                aVar2.d = com.baidu.sofire.rp.f.a.a(aVar.c, bVar.a, bVar.c, aVar2.b, com.baidu.sofire.rp.f.a.aE(aVar.c).toString()).toString();
                                com.baidu.sofire.rp.b.a.aD(aVar.c).a(aVar2);
                                com.baidu.sofire.rp.b.a.aD(aVar.c).a(a);
                                break;
                            }
                        }
                        break;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.rp.b.a.aD(a.this.c).a(j.a(valueOf));
                            break;
                        }
                        break;
                    case 5:
                        a.a(a.this);
                        int b = new com.baidu.sofire.rp.a.a(a.this.c).b();
                        new StringBuilder("sj-setTimer-start 2").append(Integer.toString(b));
                        com.baidu.sofire.rp.f.a.a(a.this.c, b * 3600000);
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        break;
                    case 6:
                        a.a(a.this, 1, com.baidu.sofire.rp.f.a.a(a.this.c));
                        break;
                    case 7:
                        a.b(a.this);
                        a.a(a.this, 1, com.baidu.sofire.rp.f.a.a(a.this.c));
                        break;
                    case 8:
                        a.a(a.this, 3, com.baidu.sofire.rp.f.a.a(a.this.c));
                        break;
                    case 9:
                        a.a(a.this, 0, 2);
                        break;
                    case 10:
                        int a2 = com.baidu.sofire.rp.f.a.a(a.this.c);
                        if (2 == a2) {
                            List<com.baidu.sofire.rp.c.a> b2 = com.baidu.sofire.rp.b.a.aD(a.this.c).b();
                            if (b2.size() >= new com.baidu.sofire.rp.a.a(a.this.c).a.getInt("up_nu_co", 50)) {
                                a.a(a.this, 0, a2);
                                break;
                            } else {
                                List<com.baidu.sofire.rp.c.a> d = com.baidu.sofire.rp.b.a.aD(a.this.c).d(true, a2);
                                new StringBuilder("sj-trigger report Dela ").append(d.size());
                                if (d.size() > 0) {
                                    a.a(a.this, 0, a2);
                                    break;
                                }
                            }
                        } else if (1 == a2) {
                            a.a(a.this, 4, a2);
                            break;
                        }
                        break;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.aFx.a(new JSONArray().put(com.baidu.sofire.rp.f.a.b(a.this.c, new JSONObject(valueOf2))).toString(), a.d(new JSONObject(valueOf2)))) {
                            com.baidu.sofire.rp.f.a.a(a.this.c, valueOf2);
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    static String d(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 == null || !jSONObject2.has("12")) {
                return null;
            }
            return jSONObject2.optString("12", "");
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
        if (System.currentTimeMillis() - aVar.aFw.a.getLong("re_net_pu_de", 0L) < 86400000) {
            return;
        }
        com.baidu.sofire.rp.d.a.a aVar2 = aVar.aFx;
        try {
            JSONObject jSONObject = new JSONObject(f.a(aVar2.a, d.a() + "plugin/v1/report/setting", "", false, true, null)).getJSONObject("c");
            com.baidu.sofire.rp.a.a aVar3 = new com.baidu.sofire.rp.a.a(aVar2.a);
            int optInt = jSONObject.optInt("n");
            if (optInt > 0) {
                aVar3.c.putInt("re_net_ty", optInt);
                aVar3.c.commit();
            }
            int optInt2 = jSONObject.optInt("i");
            if (optInt2 > 0) {
                aVar3.c.putInt("re_net_hr", optInt2);
                aVar3.c.commit();
            }
            int optInt3 = jSONObject.optInt("i2");
            if (optInt3 > 0) {
                aVar3.c.putInt("re_net_hr_bc", optInt3);
                aVar3.c.commit();
            }
            int optInt4 = jSONObject.optInt("w");
            if (optInt4 > 0) {
                aVar3.c.putInt("re_net_wt", optInt4);
                aVar3.c.commit();
            }
            if (jSONObject.optInt("s1") > 0) {
                aVar3.c.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                aVar3.c.commit();
            }
            int optInt5 = jSONObject.optInt("s2");
            if (optInt5 > 0) {
                aVar3.c.putInt("re_net_dy_lt", optInt5);
                aVar3.c.commit();
            }
            int optInt6 = jSONObject.optInt(Info.kBaiduTimeKey);
            if (optInt6 > 0) {
                aVar3.c.putInt("re_net_over", optInt6);
                aVar3.c.commit();
            }
            int optInt7 = jSONObject.optInt("l1");
            if (optInt7 > 0) {
                aVar3.c.putInt("up_nu_co", optInt7);
                aVar3.c.commit();
            }
            int optInt8 = jSONObject.optInt("l2");
            if (optInt8 > 0) {
                aVar3.c.putInt("up_nu_li", optInt8);
                aVar3.c.commit();
            }
        } catch (Throwable th) {
            d.a(th);
        }
        com.baidu.sofire.rp.a.a aVar4 = aVar.aFw;
        aVar4.c.putLong("re_net_pu_de", System.currentTimeMillis());
        aVar4.c.commit();
    }

    static /* synthetic */ void b(a aVar) {
        List<b> a = aVar.aFw.a();
        if (a == null) {
            return;
        }
        for (b bVar : a) {
            if (aVar.a(aVar.aFw.a.getString("li_pk_s", ""), bVar.b)) {
                String string = aVar.aFw.a.getString("re_net_ali2_" + bVar.d, "");
                String a2 = com.baidu.sofire.rp.f.a.a();
                if (!string.equals(a2)) {
                    String string2 = aVar.aFw.a.getString("al_da" + bVar.d, "");
                    com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
                    aVar2.b = bVar.d;
                    aVar2.g = 0;
                    aVar2.c = 2;
                    aVar2.e = System.currentTimeMillis();
                    aVar2.f = 1;
                    aVar2.i = 5;
                    aVar2.d = com.baidu.sofire.rp.f.a.a(aVar.c, bVar, string2, true).toString();
                    com.baidu.sofire.rp.b.a.aD(aVar.c).a(aVar2);
                    String a3 = j.a(com.baidu.sofire.rp.f.a.aE(aVar.c).toString());
                    if (com.baidu.sofire.rp.b.a.aD(aVar.c).b(a3)) {
                        aVar2.b = "1001001";
                        aVar2.i = 0;
                        aVar2.d = com.baidu.sofire.rp.f.a.a(aVar.c, bVar.a, bVar.c, aVar2.b, com.baidu.sofire.rp.f.a.aE(aVar.c).toString()).toString();
                        com.baidu.sofire.rp.b.a.aD(aVar.c).a(aVar2);
                        com.baidu.sofire.rp.b.a.aD(aVar.c).a(a3);
                    }
                    com.baidu.sofire.rp.a.a aVar3 = aVar.aFw;
                    aVar3.c.putString("re_net_ali2_" + bVar.d, a2);
                    aVar3.c.commit();
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
                a = com.baidu.sofire.rp.b.a.aD(aVar.c).a();
                if (1 == i2) {
                    new StringBuilder("sj-trigger report 3g ").append(a.size());
                }
            } else if (i == 3) {
                a = com.baidu.sofire.rp.b.a.aD(aVar.c).d(false, i2);
            } else if (i == 4) {
                a = com.baidu.sofire.rp.b.a.aD(aVar.c).d(true, i2);
                new StringBuilder("sj-trigger report 3g to report ").append(a.size());
            } else {
                a = com.baidu.sofire.rp.b.a.aD(aVar.c).a(i2);
            }
            if (a.size() <= 0) {
                return;
            }
            long j = aVar.aFw.a.getLong("re_day_len", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = aVar.aFw.a.getLong("re_day_b_t", 0L);
            int i3 = aVar.aFw.a.getInt("re_net_dy_lt", 50);
            if (j2 == 0) {
                com.baidu.sofire.rp.a.a aVar2 = aVar.aFw;
                aVar2.c.putLong("re_day_b_t", currentTimeMillis);
                aVar2.c.commit();
                j2 = currentTimeMillis;
            }
            if (currentTimeMillis - j2 < 86400000) {
                if (i == 3) {
                    int i4 = aVar.aFw.a.getInt("g_r_d_d_n", 0);
                    if (i4 < 5) {
                        com.baidu.sofire.rp.a.a aVar3 = aVar.aFw;
                        aVar3.c.putInt("g_r_d_d_n", i4 + 1);
                        aVar3.c.commit();
                    } else {
                        return;
                    }
                }
                if (j > 1048576 * i3) {
                    new StringBuilder("rp over limit : maxday : ").append(i3).append(" : ").append(j);
                    return;
                }
            } else {
                com.baidu.sofire.rp.a.a aVar4 = aVar.aFw;
                aVar4.c.putLong("re_day_len", 0L);
                aVar4.c.commit();
                com.baidu.sofire.rp.a.a aVar5 = aVar.aFw;
                aVar5.c.putLong("re_day_b_t", currentTimeMillis);
                aVar5.c.commit();
                if (i == 3) {
                    com.baidu.sofire.rp.a.a aVar6 = aVar.aFw;
                    aVar6.c.putInt("g_r_d_d_n", 0);
                    aVar6.c.commit();
                }
            }
            int i5 = aVar.aFw.a.getInt("re_net_one_lt", 5);
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
                    String jSONObject2 = com.baidu.sofire.rp.f.a.b(aVar.c, new JSONObject(next.d)).toString();
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
                arrayList2.add(new com.baidu.sofire.rp.c.b(jSONObject, next.j, next.a));
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
                com.baidu.sofire.rp.c.b bVar = (com.baidu.sofire.rp.c.b) arrayList2.get(i8);
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
            if (jSONArray.length() > 0 && aVar.aFx.a(jSONArray.toString(), null)) {
                com.baidu.sofire.rp.b.a.aD(aVar.c).a(arrayList3);
            }
            if (hashMap.size() > 0) {
                for (String str2 : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                    if (jSONArray4 != null && jSONArray4.length() > 0 && aVar.aFx.a(jSONArray.toString(), null)) {
                        com.baidu.sofire.rp.b.a.aD(aVar.c).a((List) hashMap2.get(hashMap2));
                    }
                }
            }
            com.baidu.sofire.rp.b.a.aD(aVar.c).c();
            if (2 == i2) {
                return;
            }
            com.baidu.sofire.rp.a.a aVar7 = aVar.aFw;
            aVar7.c.putLong("re_day_len", i6 + j);
            aVar7.c.commit();
        }
    }
}
