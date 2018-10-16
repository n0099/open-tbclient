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
/* loaded from: classes6.dex */
public abstract class g {
    public static String c = null;
    public com.baidu.location.b.e adF = null;
    public com.baidu.location.b.a adG = null;
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    final Handler d = new a();
    private String h = null;
    private String i = null;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 21:
                        g.this.a(message);
                        return;
                    case 62:
                    case 63:
                        g.this.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends com.baidu.location.d.e {
        String a = null;
        String b = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.h = com.baidu.location.d.g.c();
            if ((com.baidu.location.d.g.h || com.baidu.location.d.g.i) && g.this.h != null && g.this.i != null) {
                this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", g.this.h, g.this.i);
            }
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
            b(com.baidu.location.d.g.f);
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                Message obtainMessage = g.this.d.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String str = this.j;
                    g.c = str;
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            f.tn().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.b.b.tA().h());
                        if (l.tu().d()) {
                            bDLocation.setDirection(l.tu().e());
                        }
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        Message obtainMessage2 = g.this.d.obtainMessage(63);
                        obtainMessage2.obj = "HttpStatus error";
                        obtainMessage2.sendToTarget();
                    } else {
                        Message obtainMessage3 = g.this.d.obtainMessage(21);
                        obtainMessage3.obj = bDLocation;
                        obtainMessage3.sendToTarget();
                    }
                } catch (Exception e2) {
                    Message obtainMessage4 = g.this.d.obtainMessage(63);
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
            this.h = h.b(com.baidu.location.f.getServiceContext());
        }
        if (this.i == null) {
            this.i = h.c(com.baidu.location.f.getServiceContext());
        }
        if (this.adG == null || !this.adG.a()) {
            this.adG = com.baidu.location.b.b.tA().tB();
        }
        if (this.adF == null || !this.adF.i()) {
            this.adF = com.baidu.location.b.f.tH().tK();
        }
        Location tG = com.baidu.location.b.d.tF().i() ? com.baidu.location.b.d.tF().tG() : null;
        if ((this.adG == null || this.adG.d() || this.adG.c()) && ((this.adF == null || this.adF.a() == 0) && tG == null)) {
            return null;
        }
        String b2 = b();
        if (f.tn().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int b3 = com.baidu.location.d.g.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            b2 = b2 + "&lmd=" + b3;
        }
        String str2 = ((this.adF == null || this.adF.a() == 0) && (l = com.baidu.location.b.f.tH().l()) != null) ? l + b2 : b2;
        if (this.f) {
            this.f = false;
            return com.baidu.location.d.g.a(this.adG, this.adF, tG, str2, 0, true);
        }
        return com.baidu.location.d.g.a(this.adG, this.adF, tG, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.a.a.ti().c();
        String format = com.baidu.location.b.f.i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.b.b.tA().e()));
        if (this.e) {
            this.e = false;
            String q = com.baidu.location.b.f.tH().q();
            if (!TextUtils.isEmpty(q) && !q.equals(Config.DEF_MAC_ID)) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, q.replace(":", ""));
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
