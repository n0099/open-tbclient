package com.baidu.location.a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.mobstat.Config;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes10.dex */
public abstract class i {
    public static String c = null;
    public com.baidu.location.b.h a = null;
    public com.baidu.location.b.a b = null;
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    final Handler d = new a();
    private String h = null;
    private String i = null;

    /* loaded from: classes10.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 21:
                        i.this.a(message);
                        return;
                    case 62:
                    case 63:
                        i.this.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends com.baidu.location.d.e {
        String a = null;
        String b = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.h = com.baidu.location.d.j.c();
            if ((com.baidu.location.d.j.h || com.baidu.location.d.j.j) && i.this.h != null && i.this.i != null) {
                this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", i.this.h, i.this.i);
            }
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.a == null) {
                this.a = w.b();
            }
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            if (this.a != null) {
                this.k.put("up", this.a);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.b = str;
            b(com.baidu.location.d.j.f);
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                Message obtainMessage = i.this.d.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String str = this.j;
                    i.c = str;
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            h.a().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.b.b.a().h());
                        if (o.a().d()) {
                            bDLocation.setDirection(o.a().e());
                        }
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        Message obtainMessage2 = i.this.d.obtainMessage(63);
                        obtainMessage2.obj = "HttpStatus error";
                        obtainMessage2.sendToTarget();
                    } else {
                        Message obtainMessage3 = i.this.d.obtainMessage(21);
                        obtainMessage3.obj = bDLocation;
                        obtainMessage3.sendToTarget();
                    }
                } catch (Exception e2) {
                    Message obtainMessage4 = i.this.d.obtainMessage(63);
                    obtainMessage4.obj = "HttpStatus error";
                    obtainMessage4.sendToTarget();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    public String a(String str) {
        String l;
        if (this.h == null) {
            this.h = j.b(com.baidu.location.f.getServiceContext());
        }
        if (this.i == null) {
            this.i = j.c(com.baidu.location.f.getServiceContext());
        }
        if (this.b == null || !this.b.a()) {
            this.b = com.baidu.location.b.b.a().f();
        }
        if (this.a == null || !this.a.i()) {
            this.a = com.baidu.location.b.i.a().o();
        }
        Location g = com.baidu.location.b.e.a().i() ? com.baidu.location.b.e.a().g() : null;
        if ((this.b == null || this.b.d() || this.b.c()) && ((this.a == null || this.a.a() == 0) && g == null)) {
            return null;
        }
        String b2 = b();
        if (h.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int b3 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            b2 = b2 + "&lmd=" + b3;
        }
        String str2 = ((this.a == null || this.a.a() == 0) && (l = com.baidu.location.b.i.a().l()) != null) ? l + b2 : b2;
        if (this.f) {
            this.f = false;
            return com.baidu.location.d.j.a(this.b, this.a, g, str2, 0, true);
        }
        return com.baidu.location.d.j.a(this.b, this.a, g, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.a.a.a().c();
        String format = com.baidu.location.b.i.i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.b.b.a().e()));
        if (this.e) {
            this.e = false;
            String q = com.baidu.location.b.i.a().q();
            if (!TextUtils.isEmpty(q) && !q.equals(Config.DEF_MAC_ID)) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, q.replace(":", ""));
            }
            if (Build.VERSION.SDK_INT > 17) {
            }
        } else if (!this.g) {
            String e = w.e();
            if (e != null) {
                format = format + e;
            }
            this.g = true;
        }
        return format + c2;
    }
}
