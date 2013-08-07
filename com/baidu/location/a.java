package com.baidu.location;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {

    /* renamed from: if  reason: not valid java name */
    private static String f90if = f.v;

    /* renamed from: do  reason: not valid java name */
    private ArrayList f91do;

    /* renamed from: int  reason: not valid java name */
    private Handler f93int;

    /* renamed from: for  reason: not valid java name */
    private boolean f92for = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f728a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a {

        /* renamed from: for  reason: not valid java name */
        public Messenger f95for;

        /* renamed from: int  reason: not valid java name */
        public String f97int;

        /* renamed from: do  reason: not valid java name */
        public LocationClientOption f94do = new LocationClientOption();

        /* renamed from: if  reason: not valid java name */
        public int f96if = 0;

        public C0000a(Message message) {
            this.f97int = null;
            this.f95for = null;
            this.f95for = message.replyTo;
            this.f97int = message.getData().getString("packName");
            this.f94do.f87new = message.getData().getString("prodName");
            this.f94do.f88try = message.getData().getString("coorType");
            this.f94do.f79char = message.getData().getString("addrType");
            j.j = this.f94do.f79char;
            this.f94do.f78case = message.getData().getBoolean("openGPS");
            this.f94do.f85int = message.getData().getInt("scanSpan");
            this.f94do.f86long = message.getData().getInt("timeOut");
            this.f94do.f83goto = message.getData().getInt("priority");
            this.f94do.f89void = message.getData().getBoolean("location_change_notify");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f95for != null) {
                    this.f95for.send(obtain);
                }
                this.f96if = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f96if++;
                }
            }
        }

        private void a(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString(str, str2);
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f95for != null) {
                    this.f95for.send(obtain);
                }
                this.f96if = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.f96if++;
                }
            }
        }

        public void a() {
            a(23);
        }

        public void a(String str) {
            if (this.f94do.f89void) {
                m60if(str);
            }
        }

        public void a(String str, int i) {
            int i2 = 0;
            j.a(a.f90if, "decode...");
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
            if (this.f94do.f88try != null && !this.f94do.f88try.equals("gcj02")) {
                double m249do = j.m249do(str, "x\":\"", "\"");
                double m249do2 = j.m249do(str, "y\":\"", "\"");
                j.a(a.f90if, "decode..." + m249do + ":" + m249do2);
                if (m249do != Double.MIN_VALUE && m249do2 != Double.MIN_VALUE) {
                    double[] m18if = Jni.m18if(m249do, m249do2, this.f94do.f88try);
                    str = j.a(j.a(str, "x\":\"", "\"", m18if[0]), "y\":\"", "\"", m18if[1]);
                    j.a(a.f90if, "decode2 ..." + m18if[0] + ":" + m18if[1]);
                    j.a(a.f90if, "decode3 ..." + str);
                }
                if (this.f94do.f81else) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                        if (Integer.parseInt(jSONObject2.getString("error")) == 161) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("poi");
                            JSONArray jSONArray = jSONObject4.getJSONArray("p");
                            while (i2 < jSONArray.length()) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                                double parseDouble = Double.parseDouble(jSONObject5.getString("x"));
                                double parseDouble2 = Double.parseDouble(jSONObject5.getString("y"));
                                if (parseDouble != Double.MIN_VALUE && parseDouble2 != Double.MIN_VALUE) {
                                    double[] m18if2 = Jni.m18if(parseDouble, parseDouble2, this.f94do.f88try);
                                    jSONObject5.put("x", String.valueOf(m18if2[0]));
                                    jSONObject5.put("y", String.valueOf(m18if2[1]));
                                    jSONArray.put(i2, jSONObject5);
                                    i2++;
                                }
                            }
                            jSONObject4.put("p", jSONArray);
                            jSONObject3.put("poi", jSONObject4);
                            jSONObject.put("content", jSONObject3);
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
        public void m59if() {
            if (this.f94do.f89void) {
                if (j.b) {
                    a(54);
                } else {
                    a(55);
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m60if(String str) {
            if (str == null) {
                return;
            }
            if (j.v) {
                a(21, "locStr", str);
                return;
            }
            a(27, "locStr", str);
            if (this.f94do.f88try != null && !this.f94do.f88try.equals("gcj02")) {
                double m249do = j.m249do(str, "x\":\"", "\"");
                double m249do2 = j.m249do(str, "y\":\"", "\"");
                if (m249do != Double.MIN_VALUE && m249do2 != Double.MIN_VALUE) {
                    double[] m18if = Jni.m18if(m249do, m249do2, this.f94do.f88try);
                    if (m18if[0] > 0.0d || m18if[1] > 0.0d) {
                        str = j.a(j.a(str, "x\":\"", "\"", m18if[0]), "y\":\"", "\"", m18if[1]);
                    }
                }
            }
            a(21, "locStr", str);
        }
    }

    public a(Handler handler) {
        this.f91do = null;
        this.f93int = null;
        this.f93int = handler;
        this.f91do = new ArrayList();
    }

    private C0000a a(Messenger messenger) {
        if (this.f91do == null) {
            return null;
        }
        Iterator it = this.f91do.iterator();
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            if (c0000a.f95for.equals(messenger)) {
                return c0000a;
            }
        }
        return null;
    }

    private void a() {
        boolean z;
        boolean z2 = false;
        Iterator it = this.f91do.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = ((C0000a) it.next()).f94do.f87new.equals("kuikedefancaiburudashahaochi") ? true : z;
        }
        if (this.f728a != z) {
            this.f728a = z;
            this.f93int.obtainMessage(81).sendToTarget();
        }
    }

    private void a(C0000a c0000a) {
        if (c0000a == null) {
            return;
        }
        if (a(c0000a.f95for) != null) {
            c0000a.a(14);
            return;
        }
        this.f91do.add(c0000a);
        j.a(f90if, c0000a.f97int + " registered ");
        c0000a.a(13);
    }

    /* renamed from: do  reason: not valid java name */
    private void m47do() {
        m48int();
        a();
        m58new();
    }

    /* renamed from: int  reason: not valid java name */
    private void m48int() {
        Iterator it = this.f91do.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            if (c0000a.f94do.f78case) {
                z2 = true;
            }
            z = c0000a.f94do.f89void ? true : z;
        }
        j.I = z;
        if (this.f92for != z2) {
            this.f92for = z2;
            this.f93int.obtainMessage(52).sendToTarget();
        }
    }

    public String a(Message message) {
        if (message == null || message.replyTo == null) {
            j.a(f90if, "invalid Poirequest");
            return null;
        }
        C0000a a2 = a(message.replyTo);
        if (a2 != null) {
            a2.f94do.f727a = message.getData().getInt("num", a2.f94do.f727a);
            a2.f94do.f80do = message.getData().getFloat("distance", a2.f94do.f80do);
            a2.f94do.f84if = message.getData().getBoolean("extraInfo", a2.f94do.f84if);
            a2.f94do.f81else = true;
            String format = String.format("&poi=%.1f|%d", Float.valueOf(a2.f94do.f80do), Integer.valueOf(a2.f94do.f727a));
            return a2.f94do.f84if ? format + "|1" : format;
        }
        return null;
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f91do.iterator();
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            c0000a.m60if(str);
            if (c0000a.f96if > 4) {
                arrayList.add(c0000a);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            j.a(f90if, "remove dead object...");
            this.f91do.remove((C0000a) it2.next());
        }
    }

    public void a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f91do.iterator();
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            c0000a.a(str, i);
            if (c0000a.f96if > 4) {
                arrayList.add(c0000a);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            j.a(f90if, "remove dead object...");
            this.f91do.remove((C0000a) it2.next());
        }
    }

    public void a(String str, Message message) {
        if (str == null || message == null) {
            return;
        }
        C0000a a2 = a(message.replyTo);
        if (a2 == null) {
            j.a(f90if, "not found the client messener...");
            return;
        }
        a2.m60if(str);
        if (a2.f96if > 4) {
            this.f91do.remove(a2);
        }
    }

    /* renamed from: byte  reason: not valid java name */
    public String m50byte() {
        StringBuffer stringBuffer = new StringBuffer(256);
        C0000a c0000a = (C0000a) this.f91do.get(0);
        if (c0000a.f94do.f87new != null) {
            stringBuffer.append(c0000a.f94do.f87new);
        }
        if (c0000a.f97int != null) {
            stringBuffer.append(":");
            stringBuffer.append(c0000a.f97int);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    /* renamed from: do  reason: not valid java name */
    public int m51do(Message message) {
        C0000a a2;
        if (message == null || message.replyTo == null || (a2 = a(message.replyTo)) == null || a2.f94do == null) {
            return 1;
        }
        return a2.f94do.f83goto;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m52for() {
        return this.f92for;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m53for(Message message) {
        boolean z = true;
        C0000a a2 = a(message.replyTo);
        if (a2 == null) {
            return false;
        }
        int i = a2.f94do.f85int;
        a2.f94do.f85int = message.getData().getInt("scanSpan", a2.f94do.f85int);
        if (a2.f94do.f85int < 1000) {
            j.J = false;
        } else {
            j.J = true;
        }
        if (a2.f94do.f85int <= 999 || i >= 1000) {
            z = false;
        }
        a2.f94do.f78case = message.getData().getBoolean("openGPS", a2.f94do.f78case);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a2.f94do;
        if (string == null || string.equals("")) {
            string = a2.f94do.f88try;
        }
        locationClientOption.f88try = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a2.f94do;
        if (string2 == null || string2.equals("")) {
            string2 = a2.f94do.f79char;
        }
        locationClientOption2.f79char = string2;
        j.j = a2.f94do.f79char;
        a2.f94do.f86long = message.getData().getInt("timeOut", a2.f94do.f86long);
        a2.f94do.f89void = message.getData().getBoolean("location_change_notify", a2.f94do.f89void);
        a2.f94do.f83goto = message.getData().getInt("priority", a2.f94do.f83goto);
        m47do();
        return z;
    }

    /* renamed from: if  reason: not valid java name */
    public void m54if() {
        Iterator it = this.f91do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).a();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m55if(Message message) {
        C0000a a2 = a(message.replyTo);
        if (a2 != null) {
            j.a(f90if, a2.f97int + " unregistered");
            this.f91do.remove(a2);
        }
        m47do();
    }

    /* renamed from: if  reason: not valid java name */
    public void m56if(String str) {
        Iterator it = this.f91do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).a(str);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public void m57int(Message message) {
        if (message == null || message.replyTo == null) {
            j.a(f90if, "invalid regist client");
            return;
        }
        a(new C0000a(message));
        m47do();
    }

    /* renamed from: new  reason: not valid java name */
    public void m58new() {
        Iterator it = this.f91do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).m59if();
        }
    }
}
