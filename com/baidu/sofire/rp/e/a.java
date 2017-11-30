package com.baidu.sofire.rp.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.sofire.rp.d.a.b;
import com.baidu.sofire.rp.f.h;
import com.baidu.sofire.rp.f.i;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static int a = 1;
    public static boolean b = false;
    private HandlerC0040a QL = new HandlerC0040a(h.nr());
    private com.baidu.sofire.rp.a.a QM;
    private b QN;
    private Receiver QO;
    private Context e;

    static /* synthetic */ void a(a aVar) {
        if (System.currentTimeMillis() - aVar.QM.a.getLong("re_net_pu_de", 0L) >= 86400000) {
            aVar.QN.a(aVar.e);
            com.baidu.sofire.rp.a.a aVar2 = aVar.QM;
            aVar2.QC.putLong("re_net_pu_de", System.currentTimeMillis());
            aVar2.QC.commit();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r17v0 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v76 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v3 long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 long)] */
    static /* synthetic */ void a(a aVar, int i, int i2) {
        List<com.baidu.sofire.rp.c.a> aZ;
        List<com.baidu.sofire.rp.c.a> b2;
        com.baidu.sofire.rp.c.a aVar2;
        boolean z;
        JSONObject jSONObject;
        int length;
        if (i2 == 0) {
            return;
        }
        if (i == 1) {
            List<com.baidu.sofire.rp.c.a> a2 = com.baidu.sofire.rp.b.a.ar(aVar.e).a();
            if (1 == i2) {
                String str = " 3g " + a2.size();
                aZ = a2;
            } else {
                aZ = a2;
            }
        } else if (i == 3) {
            aZ = com.baidu.sofire.rp.b.a.ar(aVar.e).b(false, i2);
        } else if (i == 4) {
            String str2 = " 3g to report " + b2.size();
            aZ = com.baidu.sofire.rp.b.a.ar(aVar.e).b(true, i2);
        } else {
            aZ = com.baidu.sofire.rp.b.a.ar(aVar.e).aZ(i2);
        }
        if (aZ == null || aZ.size() <= 0) {
            return;
        }
        long j = aVar.QM.a.getLong("re_day_len", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = aVar.QM.a.getLong("re_day_b_t", 0L);
        int i3 = aVar.QM.a.getInt("re_net_dy_lt", 50);
        if (j2 == 0) {
            com.baidu.sofire.rp.a.a aVar3 = aVar.QM;
            aVar3.QC.putLong("re_day_b_t", currentTimeMillis);
            aVar3.QC.commit();
            j2 = currentTimeMillis;
        }
        new StringBuilder().append(currentTimeMillis).toString();
        new StringBuilder().append(j).toString();
        if (currentTimeMillis - j2 < 86400000) {
            new StringBuilder().append(i).toString();
            if (i == 3) {
                int i4 = aVar.QM.a.getInt("g_r_d_d_n", 0);
                new StringBuilder().append(i4).toString();
                if (i4 >= 5) {
                    new StringBuilder().append(i4).toString();
                    return;
                }
                com.baidu.sofire.rp.a.a aVar4 = aVar.QM;
                aVar4.QC.putInt("g_r_d_d_n", i4 + 1);
                aVar4.QC.commit();
            }
            if (j > AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START * i3) {
                String str3 = i3 + " : " + j;
                return;
            }
            aVar2 = null;
        } else {
            com.baidu.sofire.rp.a.a aVar5 = aVar.QM;
            aVar5.QC.putLong("re_day_len", 0L);
            aVar5.QC.commit();
            com.baidu.sofire.rp.a.a aVar6 = aVar.QM;
            aVar6.QC.putLong("re_day_b_t", currentTimeMillis);
            aVar6.QC.commit();
            if (i == 3) {
                com.baidu.sofire.rp.a.a aVar7 = aVar.QM;
                aVar7.QC.putInt("g_r_d_d_n", 0);
                aVar7.QC.commit();
            }
            com.baidu.sofire.rp.c.a aVar8 = new com.baidu.sofire.rp.c.a();
            aVar8.b = "1003123";
            aVar8.g = 0;
            aVar8.c = 1;
            aVar8.e = System.currentTimeMillis();
            aVar8.f = 1;
            aVar8.d = com.baidu.sofire.rp.f.b.a(aVar.e, "1003123").toString();
            aZ.add(aVar8);
            String str4 = aVar8.d;
            com.baidu.sofire.rp.a.a aVar9 = aVar.QM;
            aVar9.QC.putInt("g_r_o_5_m", 0);
            aVar9.QC.commit();
            aVar2 = aVar8;
        }
        int i5 = aVar.QM.a.getInt("re_net_one_lt", 5);
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        Iterator<com.baidu.sofire.rp.c.a> it = aZ.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.sofire.rp.c.a next = it.next();
            try {
                String jSONObject2 = com.baidu.sofire.rp.f.b.b(aVar.e, new JSONObject(next.d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length();
                } catch (Exception e) {
                    com.baidu.sofire.rp.f.b.a();
                }
            } catch (Exception e2) {
                com.baidu.sofire.rp.f.b.a();
            }
            if (i6 + length >= AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START * i5) {
                String str5 = i5 + " : " + (i6 + length);
                com.baidu.sofire.rp.a.a aVar10 = aVar.QM;
                aVar10.QC.putInt("g_r_o_5_m", aVar.QM.a.getInt("g_r_o_5_m", 0) + 1);
                aVar10.QC.commit();
                if (aVar.QN.b(jSONArray.toString())) {
                    com.baidu.sofire.rp.b.a.ar(aVar.e).a(arrayList);
                } else if (aVar2 != null) {
                    com.baidu.sofire.rp.b.a.ar(aVar.e).a(aVar2);
                }
                z = true;
            } else {
                i6 += length;
                arrayList.add(Integer.valueOf(next.a));
                jSONArray.put(jSONObject);
            }
        }
        if (!z) {
            if (aVar.QN.b(jSONArray.toString())) {
                com.baidu.sofire.rp.b.a.ar(aVar.e).a(arrayList);
            } else if (aVar2 != null) {
                com.baidu.sofire.rp.b.a.ar(aVar.e).a(aVar2);
            }
        }
        com.baidu.sofire.rp.b.a.ar(aVar.e).c();
        if (2 != i2) {
            com.baidu.sofire.rp.a.a aVar11 = aVar.QM;
            aVar11.QC.putLong("re_day_len", i6 + j);
            aVar11.QC.commit();
        }
    }

    static /* synthetic */ void a(a aVar, com.baidu.sofire.rp.a.b bVar) {
        String string = aVar.QM.a.getString("al_da" + bVar.e, "");
        com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
        aVar2.b = bVar.e;
        aVar2.g = 0;
        aVar2.c = 1;
        aVar2.e = System.currentTimeMillis();
        aVar2.f = 1;
        aVar2.d = com.baidu.sofire.rp.f.b.b(aVar.e, bVar, string).toString();
        com.baidu.sofire.rp.b.a.ar(aVar.e).a(aVar2);
        com.baidu.sofire.rp.a.a aVar3 = aVar.QM;
        aVar3.QC.putBoolean("re_net_ins_" + bVar.e, true);
        aVar3.QC.commit();
        String a2 = i.a(com.baidu.sofire.rp.f.b.e(aVar.e).toString());
        if (com.baidu.sofire.rp.b.a.ar(aVar.e).b(a2)) {
            aVar2.b = "1001001";
            aVar2.d = com.baidu.sofire.rp.f.b.a(aVar.e, bVar).toString();
            com.baidu.sofire.rp.b.a.ar(aVar.e).a(aVar2);
            com.baidu.sofire.rp.b.a.ar(aVar.e).bN(a2);
        }
    }

    static /* synthetic */ void c(a aVar) {
        List<com.baidu.sofire.rp.a.b> a2 = aVar.QM.a();
        if (a2 != null) {
            for (com.baidu.sofire.rp.a.b bVar : a2) {
                if (aVar.a(aVar.QM.a.getString("li_pk_s", ""), bVar.b)) {
                    String string = aVar.QM.a.getString("re_net_ali2_" + bVar.d, "");
                    String d = com.baidu.sofire.rp.f.b.d();
                    if (!string.equals(d)) {
                        String string2 = aVar.QM.a.getString("al_da" + bVar.d, "");
                        com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
                        aVar2.b = bVar.d;
                        aVar2.g = 0;
                        aVar2.c = 2;
                        aVar2.e = System.currentTimeMillis();
                        aVar2.f = 1;
                        aVar2.i = 5;
                        aVar2.d = com.baidu.sofire.rp.f.b.a(aVar.e, bVar, string2).toString();
                        com.baidu.sofire.rp.b.a.ar(aVar.e).a(aVar2);
                        String a3 = i.a(com.baidu.sofire.rp.f.b.e(aVar.e).toString());
                        if (com.baidu.sofire.rp.b.a.ar(aVar.e).b(a3)) {
                            aVar2.b = "1001001";
                            aVar2.i = 0;
                            aVar2.d = com.baidu.sofire.rp.f.b.a(aVar.e, bVar).toString();
                            com.baidu.sofire.rp.b.a.ar(aVar.e).a(aVar2);
                            com.baidu.sofire.rp.b.a.ar(aVar.e).bN(a3);
                        }
                        com.baidu.sofire.rp.a.a aVar3 = aVar.QM;
                        aVar3.QC.putString("re_net_ali2_" + bVar.d, d);
                        aVar3.QC.commit();
                    }
                }
            }
        }
    }

    public a(Context context) {
        this.e = context.getApplicationContext();
        this.QM = new com.baidu.sofire.rp.a.a(this.e);
        this.QN = new b(this.e);
    }

    public final void a() {
        if (this.QO == null) {
            this.QO = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.e.getApplicationContext().registerReceiver(this.QO, intentFilter);
        Message message = new Message();
        message.what = 5;
        this.QL.sendMessage(message);
    }

    public final void b() {
        Message message = new Message();
        message.what = 7;
        this.QL.sendMessage(message);
    }

    public final void a(Message message) {
        this.QL.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.rp.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0040a extends Handler {
        public HandlerC0040a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            try {
                switch (message.what) {
                    case 0:
                        a.c(a.this);
                        return;
                    case 1:
                        com.baidu.sofire.rp.b.a.ar(a.this.e).a((com.baidu.sofire.rp.c.a) message.obj);
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        a.a(a.this);
                        a.c(a.this);
                        a.a(a.this, 0, com.baidu.sofire.rp.f.b.a(a.this.e));
                        return;
                    case 3:
                        com.baidu.sofire.rp.a.b bVar = (com.baidu.sofire.rp.a.b) message.obj;
                        if (bVar != null) {
                            a.a(a.this, bVar);
                            return;
                        }
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.rp.b.a.ar(a.this.e).bN(i.a(valueOf));
                            return;
                        }
                        return;
                    case 5:
                        a.a(a.this);
                        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(a.this.e);
                        if (a.a == 1) {
                            int i = aVar.a.getInt("re_net_hr", 3);
                            r0 = " 1" + Integer.toString(i);
                            a.b = false;
                            com.baidu.sofire.rp.f.a.a(a.this.e, i * 3600000);
                        } else if (a.a == 2) {
                            a.b = true;
                            str = " 2" + Integer.toString(aVar.a.getInt("re_net_hr_bc", 8));
                        }
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        return;
                    case 6:
                        a.a(a.this, 1, com.baidu.sofire.rp.f.b.a(a.this.e));
                        return;
                    case 7:
                        a.c(a.this);
                        a.a(a.this, 1, com.baidu.sofire.rp.f.b.a(a.this.e));
                        return;
                    case 8:
                        a.a(a.this, 3, com.baidu.sofire.rp.f.b.a(a.this.e));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        int a = com.baidu.sofire.rp.f.b.a(a.this.e);
                        if (2 == a) {
                            List<com.baidu.sofire.rp.c.a> b = com.baidu.sofire.rp.b.a.ar(a.this.e).b();
                            if (b != null) {
                                if (b.size() >= new com.baidu.sofire.rp.a.a(a.this.e).a.getInt("up_nu_co", 50)) {
                                    a.a(a.this, 0, a);
                                    return;
                                }
                            }
                            List<com.baidu.sofire.rp.c.a> b2 = com.baidu.sofire.rp.b.a.ar(a.this.e).b(true, a);
                            String str2 = " Dela " + b2.size();
                            if (b2 != null && b2.size() > 0) {
                                a.a(a.this, 0, a);
                                return;
                            }
                            return;
                        } else if (1 == a) {
                            a.a(a.this, 4, a);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable th) {
                com.baidu.sofire.rp.f.b.a();
            }
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.e.getPackageName())) {
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
}
