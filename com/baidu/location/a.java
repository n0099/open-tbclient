package com.baidu.location;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
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
    private static String f53if = f.g;

    /* renamed from: do  reason: not valid java name */
    private ArrayList f54do;

    /* renamed from: int  reason: not valid java name */
    private Handler f56int;

    /* renamed from: for  reason: not valid java name */
    private boolean f55for = false;
    private boolean a = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a {

        /* renamed from: do  reason: not valid java name */
        public Messenger f57do;

        /* renamed from: for  reason: not valid java name */
        public String f58for;

        /* renamed from: if  reason: not valid java name */
        public LocationClientOption f59if = new LocationClientOption();

        public C0000a(Message message) {
            this.f58for = null;
            this.f57do = null;
            this.f57do = message.replyTo;
            this.f58for = message.getData().getString("packName");
            this.f59if.f50new = message.getData().getString("prodName");
            this.f59if.f51try = message.getData().getString("coorType");
            this.f59if.f42char = message.getData().getString("addrType");
            this.f59if.f41case = message.getData().getBoolean("openGPS");
            this.f59if.f48int = message.getData().getInt("scanSpan");
            this.f59if.f49long = message.getData().getInt("timeOut");
            this.f59if.f46goto = message.getData().getInt("priority");
            this.f59if.f52void = message.getData().getBoolean("location_change_notify");
            try {
                j.f181do = message.getData().getBoolean("map");
                j.c = message.getData().getBoolean("import");
                j.m187if(message.getData().getString("Url"));
            } catch (Exception e) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                if (this.f57do != null) {
                    this.f57do.send(obtain);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void a(int i, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString(str, str2);
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                if (this.f57do != null) {
                    this.f57do.send(obtain);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void a() {
            a(23);
        }

        public void a(String str) {
            if (this.f59if.f52void) {
                m40if(str);
            }
        }

        public void a(String str, int i) {
            int i2 = 0;
            if (str == null) {
                return;
            }
            if (j.c) {
                a(i, "locStr", str);
                return;
            }
            if (i == 21) {
                a(27, "locStr", str);
            }
            if (this.f59if.f51try != null && !this.f59if.f51try.equals("gcj02")) {
                double m182do = j.m182do(str, "x\":\"", "\"");
                double m182do2 = j.m182do(str, "y\":\"", "\"");
                if (m182do != Double.MIN_VALUE && m182do2 != Double.MIN_VALUE) {
                    double[] m1if = Jni.m1if(m182do, m182do2, this.f59if.f51try);
                    str = j.a(j.a(str, "x\":\"", "\"", m1if[0]), "y\":\"", "\"", m1if[1]);
                }
                if (this.f59if.f44else) {
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
                                    double[] m1if2 = Jni.m1if(parseDouble, parseDouble2, this.f59if.f51try);
                                    jSONObject5.put("x", String.valueOf(m1if2[0]));
                                    jSONObject5.put("y", String.valueOf(m1if2[1]));
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
        public void m39if() {
            if (this.f59if.f52void) {
                if (j.f189try) {
                    a(54);
                } else {
                    a(55);
                }
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m40if(String str) {
            if (str == null) {
                return;
            }
            if (j.c) {
                a(21, "locStr", str);
                return;
            }
            a(27, "locStr", str);
            if (this.f59if.f51try != null && !this.f59if.f51try.equals("gcj02")) {
                double m182do = j.m182do(str, "x\":\"", "\"");
                double m182do2 = j.m182do(str, "y\":\"", "\"");
                if (m182do != Double.MIN_VALUE && m182do2 != Double.MIN_VALUE) {
                    double[] m1if = Jni.m1if(m182do, m182do2, this.f59if.f51try);
                    if (m1if[0] > 0.0d || m1if[1] > 0.0d) {
                        str = j.a(j.a(str, "x\":\"", "\"", m1if[0]), "y\":\"", "\"", m1if[1]);
                    }
                }
            }
            a(21, "locStr", str);
        }
    }

    public a(Handler handler) {
        this.f54do = null;
        this.f56int = null;
        this.f56int = handler;
        this.f54do = new ArrayList();
    }

    private C0000a a(Messenger messenger) {
        if (this.f54do == null) {
            return null;
        }
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            if (c0000a.f57do.equals(messenger)) {
                return c0000a;
            }
        }
        return null;
    }

    private void a() {
        boolean z;
        boolean z2 = false;
        Iterator it = this.f54do.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = ((C0000a) it.next()).f59if.f50new.equals("kuikedefancaiburudashahaochi") ? true : z;
        }
        if (this.a != z) {
            this.a = z;
            this.f56int.obtainMessage(81).sendToTarget();
        }
    }

    private void a(C0000a c0000a) {
        if (c0000a == null) {
            return;
        }
        if (a(c0000a.f57do) != null) {
            c0000a.a(14);
            return;
        }
        this.f54do.add(c0000a);
        j.a(f53if, c0000a.f58for + " registered ");
        c0000a.a(13);
    }

    /* renamed from: do  reason: not valid java name */
    private void m28do() {
        m29int();
        a();
        m37new();
    }

    /* renamed from: int  reason: not valid java name */
    private void m29int() {
        Iterator it = this.f54do.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            if (c0000a.f59if.f41case) {
                z2 = true;
            }
            z = c0000a.f59if.f52void ? true : z;
        }
        j.f190void = z;
        if (this.f55for != z2) {
            this.f55for = z2;
            this.f56int.obtainMessage(52).sendToTarget();
        }
    }

    public String a(Message message) {
        if (message == null || message.replyTo == null) {
            j.a(f53if, "invalid Poirequest");
            return null;
        }
        C0000a a = a(message.replyTo);
        if (a != null) {
            a.f59if.a = message.getData().getInt("num", a.f59if.a);
            a.f59if.f43do = message.getData().getFloat("distance", a.f59if.f43do);
            a.f59if.f47if = message.getData().getBoolean("extraInfo", a.f59if.f47if);
            a.f59if.f44else = true;
            String format = String.format("&poi=%.1f|%d", Float.valueOf(a.f59if.f43do), Integer.valueOf(a.f59if.a));
            return a.f59if.f47if ? format + "|1" : format;
        }
        return null;
    }

    public void a(String str) {
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).m40if(str);
        }
    }

    public void a(String str, int i) {
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).a(str, i);
        }
    }

    public void a(String str, Message message) {
        if (str == null || message == null) {
            return;
        }
        C0000a a = a(message.replyTo);
        if (a != null) {
            a.m40if(str);
        } else {
            j.a(f53if, "not found the client messener...");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public int m30do(Message message) {
        C0000a a;
        if (message == null || message.replyTo == null || (a = a(message.replyTo)) == null || a.f59if == null) {
            return 1;
        }
        return a.f59if.f46goto;
    }

    /* renamed from: for  reason: not valid java name */
    public void m31for(Message message) {
        if (message == null || message.replyTo == null) {
            j.a(f53if, "invalid regist client");
            return;
        }
        a(new C0000a(message));
        m28do();
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m32for() {
        return this.f55for;
    }

    /* renamed from: if  reason: not valid java name */
    public void m33if() {
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).a();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m34if(Message message) {
        C0000a a = a(message.replyTo);
        if (a != null) {
            j.a(f53if, a.f58for + " unregistered");
            this.f54do.remove(a);
        }
        m28do();
    }

    /* renamed from: if  reason: not valid java name */
    public void m35if(String str) {
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).a(str);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public void m36int(Message message) {
        C0000a a = a(message.replyTo);
        if (a == null) {
            return;
        }
        a.f59if.f48int = message.getData().getInt("scanSpan", a.f59if.f48int);
        a.f59if.f41case = message.getData().getBoolean("openGPS", a.f59if.f41case);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.f59if;
        if (string == null || string.equals("")) {
            string = a.f59if.f51try;
        }
        locationClientOption.f51try = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption2 = a.f59if;
        if (string2 == null || string2.equals("")) {
            string2 = a.f59if.f42char;
        }
        locationClientOption2.f42char = string2;
        a.f59if.f49long = message.getData().getInt("timeOut", a.f59if.f49long);
        a.f59if.f52void = message.getData().getBoolean("location_change_notify", a.f59if.f52void);
        m28do();
    }

    /* renamed from: new  reason: not valid java name */
    public void m37new() {
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            ((C0000a) it.next()).m39if();
        }
    }

    /* renamed from: try  reason: not valid java name */
    public String m38try() {
        StringBuffer stringBuffer = new StringBuffer((int) AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT);
        Iterator it = this.f54do.iterator();
        while (it.hasNext()) {
            C0000a c0000a = (C0000a) it.next();
            if (c0000a.f59if.f50new != null) {
                stringBuffer.append(c0000a.f59if.f50new);
            }
            if (c0000a.f58for != null) {
                stringBuffer.append(":");
                stringBuffer.append(c0000a.f58for);
                stringBuffer.append("|");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }
}
