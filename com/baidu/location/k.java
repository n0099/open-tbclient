package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {
    private static String a = "baidu_location_service";
    private ArrayList b;
    private Handler c;
    private boolean d = false;
    private boolean e = false;

    public k(Handler handler) {
        this.b = null;
        this.c = null;
        this.c = handler;
        this.b = new ArrayList();
    }

    private l a(Messenger messenger) {
        if (this.b == null) {
            return null;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (lVar.b.equals(messenger)) {
                return lVar;
            }
        }
        return null;
    }

    private void a(l lVar) {
        if (lVar == null) {
            return;
        }
        if (a(lVar.b) != null) {
            l.a(lVar, 14);
            return;
        }
        this.b.add(lVar);
        ap.a(a, lVar.a + " registered ");
        l.a(lVar, 13);
    }

    private void e() {
        f();
        g();
        c();
    }

    private void f() {
        Iterator it = this.b.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (lVar.c.c) {
                z2 = true;
            }
            z = lVar.c.h ? true : z;
        }
        ap.c = z;
        if (this.d != z2) {
            this.d = z2;
            this.c.obtainMessage(52).sendToTarget();
        }
    }

    private void g() {
        boolean z;
        boolean z2 = false;
        Iterator it = this.b.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = ((l) it.next()).c.f.equals("kuikedefancaiburudashahaochi") ? true : z;
        }
        if (this.e != z) {
            this.e = z;
            this.c.obtainMessage(81).sendToTarget();
        }
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            ap.a(a, "invalid regist client");
            return;
        }
        a(new l(this, message));
        e();
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            lVar.a(str);
            if (lVar.d > 4) {
                arrayList.add(lVar);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ap.a(a, "remove dead object...");
            this.b.remove((l) it2.next());
        }
    }

    public void a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            lVar.a(str, i);
            if (lVar.d > 4) {
                arrayList.add(lVar);
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ap.a(a, "remove dead object...");
            this.b.remove((l) it2.next());
        }
    }

    public void a(String str, Message message) {
        if (str == null || message == null) {
            return;
        }
        l a2 = a(message.replyTo);
        if (a2 == null) {
            ap.a(a, "not found the client messener...");
            return;
        }
        a2.a(str);
        if (a2.d > 4) {
            this.b.remove(a2);
        }
    }

    public boolean a() {
        return this.d;
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer(256);
        l lVar = (l) this.b.get(0);
        if (lVar.c.f != null) {
            stringBuffer.append(lVar.c.f);
        }
        if (lVar.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(lVar.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        return "&prod=" + stringBuffer2;
    }

    public void b(Message message) {
        l a2 = a(message.replyTo);
        if (a2 != null) {
            ap.a(a, a2.a + " unregistered");
            this.b.remove(a2);
        }
        e();
    }

    public void b(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(str);
        }
    }

    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    public boolean c(Message message) {
        boolean z = true;
        l a2 = a(message.replyTo);
        if (a2 == null) {
            return false;
        }
        int i = a2.c.d;
        a2.c.d = message.getData().getInt("scanSpan", a2.c.d);
        if (a2.c.d < 1000) {
            ap.k = false;
        } else {
            ap.k = true;
        }
        if (a2.c.d <= 999 || i >= 1000) {
            z = false;
        }
        a2.c.c = message.getData().getBoolean("openGPS", a2.c.c);
        String string = message.getData().getString("coorType");
        j jVar = a2.c;
        if (string == null || string.equals("")) {
            string = a2.c.a;
        }
        jVar.a = string;
        String string2 = message.getData().getString("addrType");
        j jVar2 = a2.c;
        if (string2 == null || string2.equals("")) {
            string2 = a2.c.b;
        }
        jVar2.b = string2;
        ap.i = a2.c.b;
        a2.c.e = message.getData().getInt("timeOut", a2.c.e);
        a2.c.h = message.getData().getBoolean("location_change_notify", a2.c.h);
        a2.c.g = message.getData().getInt("priority", a2.c.g);
        e();
        return z;
    }

    public String d(Message message) {
        if (message == null || message.replyTo == null) {
            ap.a(a, "invalid Poirequest");
            return null;
        }
        l a2 = a(message.replyTo);
        if (a2 != null) {
            a2.c.m = message.getData().getInt("num", a2.c.m);
            a2.c.l = message.getData().getFloat("distance", a2.c.l);
            a2.c.k = message.getData().getBoolean("extraInfo", a2.c.k);
            a2.c.j = true;
            String format = String.format("&poi=%.1f|%d", Float.valueOf(a2.c.l), Integer.valueOf(a2.c.m));
            return a2.c.k ? format + "|1" : format;
        }
        return null;
    }

    public int e(Message message) {
        l a2;
        if (message == null || message.replyTo == null || (a2 = a(message.replyTo)) == null || a2.c == null) {
            return 1;
        }
        return a2.c.g;
    }
}
