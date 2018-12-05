package com.baidu.sofire.rp.f;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.b.f;
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
public class a {
    private HandlerC0150a a = new HandlerC0150a(l.a());
    private e b;
    private Context c;
    private com.baidu.sofire.rp.d.a.a d;
    private com.baidu.sofire.rp.e.a e;

    public a(Context context) {
        this.c = context.getApplicationContext();
        this.b = new e(this.c);
        this.d = new com.baidu.sofire.rp.d.a.a(this.c);
    }

    public void a(boolean z) {
        b();
        Message message = new Message();
        message.what = 5;
        a(message);
    }

    public void a() {
        Message message = new Message();
        message.what = 7;
        a(message);
    }

    private void b() {
        if (this.e == null) {
            this.e = new com.baidu.sofire.rp.e.a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        this.c.getApplicationContext().registerReceiver(this.e, intentFilter);
    }

    private void c() {
        this.d.a();
        this.b.f(System.currentTimeMillis());
    }

    public void a(Message message) {
        this.a.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.rp.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0150a extends Handler {
        public HandlerC0150a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.f();
                        break;
                    case 1:
                        com.baidu.sofire.rp.b.a.a(a.this.c).a((com.baidu.sofire.rp.c.a) message.obj);
                        b.a("sj-trigger report f ACTION_REPORT_RECORD");
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        break;
                    case 2:
                        b.a("sj-trigger report ACTION_REPORT_DATA");
                        a.this.d();
                        a.this.f();
                        int o = com.baidu.sofire.b.e.o(a.this.c);
                        b.a("sj-trigger report ACTI " + o);
                        a.this.a(0, o);
                        break;
                    case 3:
                        com.baidu.sofire.rp.a.a aVar = (com.baidu.sofire.rp.a.a) message.obj;
                        if (aVar != null) {
                            a.this.b(aVar);
                            break;
                        }
                        break;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.sofire.rp.b.a.a(a.this.c).a(o.a(valueOf));
                            break;
                        }
                        break;
                    case 5:
                        a.this.d();
                        a.this.e();
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        break;
                    case 6:
                        a.this.a(1, com.baidu.sofire.b.e.o(a.this.c));
                        break;
                    case 7:
                        a.this.f();
                        a.this.a(1, com.baidu.sofire.b.e.o(a.this.c));
                        break;
                    case 8:
                        b.a("report 3 day data.. ");
                        a.this.a(3, com.baidu.sofire.b.e.o(a.this.c));
                        break;
                    case 9:
                        a.this.a(0, 2);
                        break;
                    case 10:
                        int o2 = com.baidu.sofire.b.e.o(a.this.c);
                        if (2 == o2) {
                            b.a("sj-trigger report wifi ");
                            if (com.baidu.sofire.rp.b.a.a(a.this.c).b() < new e(a.this.c).W()) {
                                List<com.baidu.sofire.rp.c.a> a = com.baidu.sofire.rp.b.a.a(a.this.c).a(true, o2);
                                b.a("sj-trigger report Dela " + a.size());
                                if (a != null && a.size() > 0) {
                                    b.a("sj-trigger reportde condi");
                                    a.this.a(0, o2);
                                    break;
                                }
                            } else {
                                b.a("sj-trigger reportrc condi");
                                a.this.a(0, o2);
                                break;
                            }
                        } else if (1 == o2) {
                            b.a("sj-trigger reportde re");
                            a.this.a(4, o2);
                            break;
                        }
                        break;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (!a.this.d.a(new JSONArray().put(com.baidu.sofire.b.e.a(a.this.c, new JSONObject(valueOf2))).toString(), a.this.a(new JSONObject(valueOf2)))) {
                            com.baidu.sofire.b.e.b(a.this.c, valueOf2);
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (System.currentTimeMillis() - this.b.Z() >= 86400000) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e eVar = new e(this.c);
        int R = eVar.R();
        b.a("sj-setTimer-start 2" + Integer.toString(R));
        long currentTimeMillis = System.currentTimeMillis() - eVar.S();
        if (currentTimeMillis >= R * 3600000) {
            f.a(this.c).b();
            com.baidu.sofire.b.e.a(this.c, R * 3600000);
            eVar.e(System.currentTimeMillis());
            return;
        }
        com.baidu.sofire.b.e.a(this.c, (R * 3600000) - currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        List<com.baidu.sofire.rp.c.a> b;
        if (i2 == 0) {
            b.a("sj-trigger EVENT_NETWORK_NONE");
            return;
        }
        if (i == 1) {
            List<com.baidu.sofire.rp.c.a> a = com.baidu.sofire.rp.b.a.a(this.c).a();
            if (1 == i2) {
                b.a("sj-trigger report 3g " + a.size());
                b = a;
            } else {
                b = a;
            }
        } else if (i == 3) {
            b = com.baidu.sofire.rp.b.a.a(this.c).a(false, i2);
        } else if (i == 4) {
            List<com.baidu.sofire.rp.c.a> a2 = com.baidu.sofire.rp.b.a.a(this.c).a(true, i2);
            b.a("sj-trigger report 3g to report " + a2.size());
            b = a2;
        } else {
            b = com.baidu.sofire.rp.b.a.a(this.c).b(i2);
        }
        if (b == null || b.size() <= 0) {
            b.a("sj-trigger report size =0");
            return;
        }
        long aa = this.b.aa();
        long currentTimeMillis = System.currentTimeMillis();
        long ab = this.b.ab();
        int Y = this.b.Y();
        if (ab == 0) {
            this.b.h(currentTimeMillis);
            ab = currentTimeMillis;
        }
        b.a("begintime : " + currentTimeMillis);
        b.a("last rp len : " + aa);
        if (currentTimeMillis - ab < 86400000) {
            b.a("in one day ...type :  " + i);
            if (i == 3) {
                int af = this.b.af();
                b.a("report 3 day num :  " + af);
                if (af >= 5) {
                    b.a("report 3 day end .. " + af);
                    return;
                }
                this.b.z(af + 1);
            }
            if (aa > 1048576 * Y) {
                b.a("rp over limit : maxday : " + Y + " : " + aa);
                return;
            }
        } else {
            this.b.g(0L);
            this.b.h(currentTimeMillis);
            if (i == 3) {
                this.b.z(0);
            }
        }
        a(b, i2, aa);
        List<com.baidu.sofire.rp.c.a> b2 = b(i, i2);
        while (b2 != null && b2.size() != 0) {
            a(b2, i2, aa);
            b2 = b(i, i2);
        }
    }

    private List<com.baidu.sofire.rp.c.a> b(int i, int i2) {
        if (i == 0 && i2 == 2) {
            return com.baidu.sofire.rp.b.a.a(this.c).b(i2);
        }
        return null;
    }

    private void a(List<com.baidu.sofire.rp.c.a> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        int i2 = 0;
        int X = this.b.X();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.sofire.rp.c.a> it = list.iterator();
        int i3 = 0;
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
            if (i3 + length >= 1048576 * X) {
                b.a("rp once over limit : maxOnece : " + X + " : " + (i3 + length));
                break;
            }
            i3 += length;
            arrayList.add(Integer.valueOf(next.a));
            arrayList2.add(new com.baidu.sofire.rp.c.b(jSONObject, next.j, next.a));
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        while (true) {
            int i4 = i2;
            if (i4 >= arrayList2.size()) {
                break;
            }
            com.baidu.sofire.rp.c.b bVar = (com.baidu.sofire.rp.c.b) arrayList2.get(i4);
            if (bVar != null) {
                String b = bVar.b();
                if (TextUtils.isEmpty(b)) {
                    jSONArray.put(bVar.a());
                    arrayList3.add(Integer.valueOf(bVar.c()));
                } else {
                    if (hashMap.containsKey(b)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(b);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.a());
                        hashMap.put(b, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.a());
                        hashMap.put(b, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(b);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.c()));
                    hashMap2.put(b, arrayList4);
                }
            }
            i2 = i4 + 1;
        }
        b.a("sj-trigger before report");
        if (jSONArray != null && jSONArray.length() > 0) {
            if (this.d.a(jSONArray.toString(), null)) {
                b.a("report one sucess");
                com.baidu.sofire.rp.b.a.a(this.c).a(arrayList3);
            }
        } else {
            b.a("sj-trigger 1 null");
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.d.a(jSONArray4.toString(), str)) {
                    b.a("report one sucess");
                    com.baidu.sofire.rp.b.a.a(this.c).a((List) hashMap2.get(str));
                }
            }
        } else {
            b.a("sj-trigger 2 null");
        }
        com.baidu.sofire.rp.b.a.a(this.c).c();
        if (2 != i) {
            this.b.g(i3 + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        List<com.baidu.sofire.rp.a.a> P = this.b.P();
        if (P != null) {
            for (com.baidu.sofire.rp.a.a aVar : P) {
                if (a(this.b.ac(), aVar.b)) {
                    a(aVar);
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        boolean z = true;
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
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    z = false;
                    break;
                } else if (str2.equals(jSONArray.get(i))) {
                    break;
                } else {
                    i++;
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    private void a(com.baidu.sofire.rp.a.a aVar) {
        String j = this.b.j(aVar.d);
        String a = com.baidu.sofire.b.e.a();
        if (!j.equals(a)) {
            String l = this.b.l(aVar.d);
            com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
            aVar2.b = aVar.d;
            aVar2.g = 0;
            aVar2.c = 2;
            aVar2.e = System.currentTimeMillis();
            aVar2.f = 1;
            aVar2.i = 5;
            aVar2.d = com.baidu.sofire.b.e.a(this.c, aVar, l, true).toString();
            com.baidu.sofire.rp.b.a.a(this.c).a(aVar2);
            String a2 = o.a(com.baidu.sofire.b.e.n(this.c).toString());
            if (com.baidu.sofire.rp.b.a.a(this.c).b(a2)) {
                aVar2.b = "1001001";
                aVar2.i = 0;
                aVar2.d = com.baidu.sofire.b.e.a(this.c, aVar.a, aVar.c, aVar2.b, com.baidu.sofire.b.e.n(this.c).toString()).toString();
                com.baidu.sofire.rp.b.a.a(this.c).a(aVar2);
                com.baidu.sofire.rp.b.a.a(this.c).a(a2);
            }
            this.b.c(aVar.d, a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.sofire.rp.a.a aVar) {
        String l = this.b.l(aVar.e);
        com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
        aVar2.b = aVar.e;
        aVar2.g = 0;
        aVar2.c = 1;
        aVar2.e = System.currentTimeMillis();
        aVar2.f = 1;
        aVar2.d = com.baidu.sofire.b.e.a(this.c, aVar, l, false).toString();
        com.baidu.sofire.rp.b.a.a(this.c).a(aVar2);
        this.b.a(aVar.e, true);
        String a = o.a(com.baidu.sofire.b.e.n(this.c).toString());
        if (com.baidu.sofire.rp.b.a.a(this.c).b(a)) {
            aVar2.b = "1001001";
            aVar2.d = com.baidu.sofire.b.e.a(this.c, aVar.a, aVar.c, aVar2.b, com.baidu.sofire.b.e.n(this.c).toString()).toString();
            com.baidu.sofire.rp.b.a.a(this.c).a(aVar2);
            com.baidu.sofire.rp.b.a.a(this.c).a(a);
        }
    }
}
