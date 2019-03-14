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
/* loaded from: classes3.dex */
public abstract class h {
    public static String c = null;
    public com.baidu.location.e.e a = null;
    public com.baidu.location.e.a b = null;
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    final Handler d = new a();
    private String h = null;
    private String i = null;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 21:
                        h.this.a(message);
                        return;
                    case 62:
                    case 63:
                        h.this.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends com.baidu.location.g.e {
        String a = null;
        String b = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.g.e
        public void a() {
            this.h = com.baidu.location.g.g.c();
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.a == null) {
                this.a = p.b();
            }
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            if (this.a != null) {
                this.k.put("up", this.a);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.b = str;
            b(com.baidu.location.g.g.f);
        }

        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                Message obtainMessage = h.this.d.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String str = this.j;
                    h.c = str;
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            g.a().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.e.b.a().h());
                        if (l.a().d()) {
                            bDLocation.setDirection(l.a().e());
                        }
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        Message obtainMessage2 = h.this.d.obtainMessage(63);
                        obtainMessage2.obj = "HttpStatus error";
                        obtainMessage2.sendToTarget();
                    } else {
                        Message obtainMessage3 = h.this.d.obtainMessage(21);
                        obtainMessage3.obj = bDLocation;
                        obtainMessage3.sendToTarget();
                    }
                } catch (Exception e2) {
                    Message obtainMessage4 = h.this.d.obtainMessage(63);
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
        String m;
        if (this.b == null || !this.b.a()) {
            this.b = com.baidu.location.e.b.a().f();
        }
        if (this.a == null || !this.a.j()) {
            this.a = com.baidu.location.e.f.a().p();
        }
        Location g = com.baidu.location.e.d.a().i() ? com.baidu.location.e.d.a().g() : null;
        if ((this.b == null || this.b.d() || this.b.c()) && ((this.a == null || this.a.a() == 0) && g == null)) {
            return null;
        }
        String b2 = b();
        if (g.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int c2 = com.baidu.location.g.g.c(com.baidu.location.f.getServiceContext());
        if (c2 >= 0) {
            b2 = b2 + "&lmd=" + c2;
        }
        String str2 = ((this.a == null || this.a.a() == 0) && (m = com.baidu.location.e.f.a().m()) != null) ? m + b2 : b2;
        if (this.f) {
            this.f = false;
            return com.baidu.location.g.g.a(this.b, this.a, g, str2, 0, true);
        }
        return com.baidu.location.g.g.a(this.b, this.a, g, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.a.a.a().c();
        String format = com.baidu.location.e.f.j() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.e.b.a().e()));
        if (this.e) {
            this.e = false;
            String r = com.baidu.location.e.f.a().r();
            if (!TextUtils.isEmpty(r) && !r.equals(Config.DEF_MAC_ID)) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, r.replace(Config.TRACE_TODAY_VISIT_SPLIT, ""));
            }
            if (Build.VERSION.SDK_INT > 17) {
            }
        } else if (!this.g) {
            String e = p.e();
            if (e != null) {
                format = format + e;
            }
            this.g = true;
        }
        return format + c2;
    }
}
