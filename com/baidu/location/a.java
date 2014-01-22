package com.baidu.location;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: if  reason: not valid java name */
    private static String f54if = f.v;

    /* renamed from: do  reason: not valid java name */
    private ArrayList f55do;

    /* renamed from: int  reason: not valid java name */
    private Handler f57int;

    /* renamed from: for  reason: not valid java name */
    private boolean f56for = false;
    private boolean a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a {

        /* renamed from: for  reason: not valid java name */
        public Messenger f59for;

        /* renamed from: int  reason: not valid java name */
        public String f61int;

        /* renamed from: do  reason: not valid java name */
        public LocationClientOption f58do = new LocationClientOption();

        /* renamed from: if  reason: not valid java name */
        public int f60if = 0;

        public C0001a(Message message) {
            this.f61int = null;
            this.f59for = null;
            this.f59for = message.replyTo;
            this.f61int = message.getData().getString("packName");
            this.f58do.f51new = message.getData().getString("prodName");
            this.f58do.f52try = message.getData().getString("coorType");
            this.f58do.f43char = message.getData().getString("addrType");
            j.j = this.f58do.f43char;
            this.f58do.f42case = message.getData().getBoolean("openGPS");
            this.f58do.f49int = message.getData().getInt("scanSpan");
            this.f58do.f50long = message.getData().getInt("timeOut");
            this.f58do.f47goto = message.getData().getInt("priority");
            this.f58do.f53void = message.getData().getBoolean("location_change_notify");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f59for != null) {
                    this.f59for.send(obtain);
                }
                this.f60if = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f60if++;
                }
            }
        }

        private void a(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString(str, str2);
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f59for != null) {
                    this.f59for.send(obtain);
                }
                this.f60if = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f60if++;
                }
            }
        }

        public void a() {
            a(23);
        }

        public void a(String str) {
            if (this.f58do.f53void) {
                m44if(str);
            }
        }

        public void a(String str, int i) {
            int i2 = 0;
            j.a(a.f54if, "decode...");
            if (str == null) {
                return;
            }
            if (j.v) {
                a(i, "locStr", str);
                return;
            }
            if (i == 21) {
                a(27, "locStr", str);
            }
            if (this.f58do.f52try != null && !this.f58do.f52try.equals("gcj02")) {
                double m233do = j.m233do(str, "x\":\"", "\"");
                double m233do2 = j.m233do(str, "y\":\"", "\"");
                j.a(a.f54if, "decode..." + m233do + ":" + m233do2);
                if (m233do != Double.MIN_VALUE && m233do2 != Double.MIN_VALUE) {
                    double[] m2if = Jni.m2if(m233do, m233do2, this.f58do.f52try);
                    str = j.a(j.a(str, "x\":\"", "\"", m2if[0]), "y\":\"", "\"", m2if[1]);
                    j.a(a.f54if, "decode2 ..." + m2if[0] + ":" + m2if[1]);
                    j.a(a.f54if, "decode3 ..." + str);
                }
                if (this.f58do.f45else) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        JSONObject jSONObject3 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                        if (Integer.parseInt(jSONObject2.getString("error")) == 161) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("poi");
                            JSONArray jSONArray = jSONObject4.getJSONArray("p");
                            while (i2 < jSONArray.length()) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                                double parseDouble = Double.parseDouble(jSONObject5.getString("x"));
                                double parseDouble2 = Double.parseDouble(jSONObject5.getString("y"));
                                if (parseDouble != Double.MIN_VALUE && parseDouble2 != Double.MIN_VALUE) {
                                    double[] m2if2 = Jni.m2if(parseDouble, parseDouble2, this.f58do.f52try);
                                    jSONObject5.put("x", String.valueOf(m2if2[0]));
                                    jSONObject5.put("y", String.valueOf(m2if2[1]));
                                    jSONArray.put(i2, jSONObject5);
                                    i2++;
                                }
                            }
                            jSONObject4.put("p", jSONArray);
                            jSONObject3.put("poi", jSONObject4);
                            jSONObject.put(PushConstants.EXTRA_CONTENT, jSONObject3);
                            str = jSONObject.toString();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            a(i, "locStr", str);
        }

        /* renamed from: if  reason: not valid java name */
        public void m43if() {
            if (this.f58do.f53void) {
                if (j.b) {
                    a(54);
                } else {
                    a(55);
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m44if(String str) {
            if (str == null) {
                return;
            }
            if (j.v) {
                a(21, "locStr", str);
                return;
            }
            a(27, "locStr", str);
            if (this.f58do.f52try != null && !this.f58do.f52try.equals("gcj02")) {
                double m233do = j.m233do(str, "x\":\"", "\"");
                double m233do2 = j.m233do(str, "y\":\"", "\"");
                if (m233do != Double.MIN_VALUE && m233do2 != Double.MIN_VALUE) {
                    double[] m2if = Jni.m2if(m233do, m233do2, this.f58do.f52try);
                    if (m2if[0] > 0.0d || m2if[1] > 0.0d) {
                        str = j.a(j.a(str, "x\":\"", "\"", m2if[0]), "y\":\"", "\"", m2if[1]);
                    }
                }
            }
            a(21, "locStr", str);
        }
    }

    public a(Handler handler) {
        this.f55do = null;
        this.f57int = null;
        this.f57int = handler;
        this.f55do = new ArrayList();
    }

    private C0001a a(Messenger messenger) {
        if (this.f55do == null) {
            return null;
        }
        Iterator it = this.f55do.iterator();
        while (it.hasNext()) {
            C0001a c0001a = (C0001a) it.next();
            if (c0001a.f59for.equals(messenger)) {
                return c0001a;
            }
        }
        return null;
    }

    private void a() {
        boolean z;
        boolean z2 = false;
        Iterator it = this.f55do.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = ((C0001a) it.next()).f58do.f51new.equals("kuikedefancaiburudashahaochi") ? true : z;
        }
        if (this.a != z) {
            this.a = z;
            this.f57int.obtainMessage(81).sendToTarget();
        }
    }

    private void a(C0001a c0001a) {
        if (c0001a == null) {
            return;
        }
        if (a(c0001a.f59for) != null) {
            c0001a.a(14);
            return;
        }
        this.f55do.add(c0001a);
        j.a(f54if, c0001a.f61int + " registered ");
        c0001a.a(13);
    }

    /* renamed from: do  reason: not valid java name */
    private void m31do() {
        m32int();
        a();
        m42new();
    }

    /* renamed from: int  reason: not valid java name */
    private void m32int() {
        Iterator it = this.f55do.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0001a c0001a = (C0001a) it.next();
            if (c0001a.f58do.f42case) {
                z2 = true;
            }
            z = c0001a.f58do.f53void ? true : z;
        }
        j.I = z;
        if (this.f56for != z2) {
            this.f56for = z2;
            this.f57int.obtainMessage(52).sendToTarget();
        }
    }

    public String a(Message message) {
        if (message == null || message.replyTo == null) {
            j.a(f54if, "invalid Poirequest");
            return null;
        }
        C0001a a = a(message.replyTo);
        if (a != null) {
            a.f58do.a = message.getData().getInt("num", a.f58do.a);
            a.f58do.f44do = message.getData().getFloat("distance", a.f58do.f44do);
            a.f58do.f48if = message.getData().getBoolean("extraInfo", a.f58do.f48if);
            a.f58do.f45else = true;
            String format = String.format("&poi=%.1f|%d", Float.valueOf(a.f58do.f44do), Integer.valueOf(a.f58do.a));
            return a.f58do.f48if ? format + "|1" : format;
        }
        return null;
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f55do.iterator();
        while (it.hasNext()) {
            C0001a c0001a = (C0001a) it.next();
            c0001a.m44if(str);
            if (c0001a.f60if > 4) {
                arrayList.add(c0001a);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            j.a(f54if, "remove dead object...");
            this.f55do.remove((C0001a) it2.next());
        }
    }

    public void a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f55do.iterator();
        while (it.hasNext()) {
            C0001a c0001a = (C0001a) it.next();
            c0001a.a(str, i);
            if (c0001a.f60if > 4) {
                arrayList.add(c0001a);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            j.a(f54if, "remove dead object...");
            this.f55do.remove((C0001a) it2.next());
        }
    }

    public void a(String str, Message message) {
        if (str == null || message == null) {
            return;
        }
        C0001a a = a(message.replyTo);
        if (a == null) {
            j.a(f54if, "not found the client messener...");
            return;
        }
        a.m44if(str);
        if (a.f60if > 4) {
            this.f55do.remove(a);
        }
    }

    /* renamed from: byte  reason: not valid java name */
    public String m34byte() {
        StringBuffer stringBuffer = new StringBuffer(256);
        C0001a c0001a = (C0001a) this.f55do.get(0);
        if (c0001a.f58do.f51new != null) {
            stringBuffer.append(c0001a.f58do.f51new);
        }
        if (c0001a.f61int != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0001a.f61int);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    /* renamed from: do  reason: not valid java name */
    public int m35do(Message message) {
        C0001a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.f58do == null) {
            return 1;
        }
        return a.f58do.f47goto;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m36for() {
        return this.f56for;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m37for(Message message) {
        boolean z = true;
        C0001a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.f58do.f49int;
        a.f58do.f49int = message.getData().getInt("scanSpan", a.f58do.f49int);
        if (a.f58do.f49int < 1000) {
            j.J = false;
        } else {
            j.J = true;
        }
        if (a.f58do.f49int <= 999 || i >= 1000) {
            z = false;
        }
        a.f58do.f42case = message.getData().getBoolean("openGPS", a.f58do.f42case);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.f58do;
        if (string == null || string.equals("")) {
            string = a.f58do.f52try;
        }
        locationClientOption.f52try = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.f58do;
        if (string2 == null || string2.equals("")) {
            string2 = a.f58do.f43char;
        }
        locationClientOption2.f43char = string2;
        j.j = a.f58do.f43char;
        a.f58do.f50long = message.getData().getInt("timeOut", a.f58do.f50long);
        a.f58do.f53void = message.getData().getBoolean("location_change_notify", a.f58do.f53void);
        a.f58do.f47goto = message.getData().getInt("priority", a.f58do.f47goto);
        m31do();
        return z;
    }

    /* renamed from: if  reason: not valid java name */
    public void m38if() {
        Iterator it = this.f55do.iterator();
        while (it.hasNext()) {
            ((C0001a) it.next()).a();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m39if(Message message) {
        C0001a a = a(message.replyTo);
        if (a != null) {
            j.a(f54if, a.f61int + " unregistered");
            this.f55do.remove(a);
        }
        m31do();
    }

    /* renamed from: if  reason: not valid java name */
    public void m40if(String str) {
        Iterator it = this.f55do.iterator();
        while (it.hasNext()) {
            ((C0001a) it.next()).a(str);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public void m41int(Message message) {
        if (message == null || message.replyTo == null) {
            j.a(f54if, "invalid regist client");
            return;
        }
        a(new C0001a(message));
        m31do();
    }

    /* renamed from: new  reason: not valid java name */
    public void m42new() {
        Iterator it = this.f55do.iterator();
        while (it.hasNext()) {
            ((C0001a) it.next()).m43if();
        }
    }
}
