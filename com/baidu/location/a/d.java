package com.baidu.location.a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes.dex */
public abstract class d {
    public static String c = null;
    public com.baidu.location.f.i LZ = null;
    public com.baidu.location.f.a Ma = null;
    private boolean e = true;
    private boolean f = false;
    final Handler d = new a();

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 21:
                        d.this.a(message);
                        return;
                    case 62:
                    case 63:
                        d.this.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends com.baidu.location.h.f {
        String a = null;
        String b = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.h = com.baidu.location.h.i.c();
            String b = com.baidu.location.c.d.mB().b();
            if (g == com.baidu.location.h.b.e || g == com.baidu.location.h.b.f) {
                this.h = "http://" + b + "/sdk.php";
            }
            if (b != null) {
                com.baidu.location.c.f.mD().mE().b("&host=" + b);
            }
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.a == null) {
                this.a = j.b();
            }
            this.k.put("bloc", encodeTp4);
            if (this.a != null) {
                this.k.put("up", this.a);
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", com.baidu.location.h.a.b(com.baidu.location.f.getServiceContext()), com.baidu.location.h.a.a(com.baidu.location.f.getServiceContext())));
            if (stringBuffer.length() > 0) {
                this.k.put("ext", Jni.encode(stringBuffer.toString()));
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.b = str;
            e();
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                Message obtainMessage = d.this.d.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String str = this.j;
                    d.c = str;
                    try {
                        bDLocation = new BDLocation(str);
                        bDLocation.setOperators(com.baidu.location.f.c.mY().g());
                        if (f.mn().f()) {
                            bDLocation.setDirection(f.mn().h());
                        }
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        Message obtainMessage2 = d.this.d.obtainMessage(63);
                        obtainMessage2.obj = "HttpStatus error";
                        obtainMessage2.sendToTarget();
                    } else {
                        Message obtainMessage3 = d.this.d.obtainMessage(21);
                        obtainMessage3.obj = bDLocation;
                        obtainMessage3.sendToTarget();
                    }
                } catch (Exception e2) {
                    Message obtainMessage4 = d.this.d.obtainMessage(63);
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
        if (this.Ma == null || !this.Ma.a()) {
            this.Ma = com.baidu.location.f.c.mY().mU();
        }
        if (this.LZ == null || !this.LZ.f()) {
            this.LZ = com.baidu.location.f.k.nh().nf();
        }
        Location na = com.baidu.location.f.f.nb().i() ? com.baidu.location.f.f.nb().na() : null;
        if ((this.Ma == null || this.Ma.c()) && ((this.LZ == null || this.LZ.a() == 0) && na == null)) {
            return null;
        }
        String c2 = com.baidu.location.a.a.mk().c();
        String format = com.baidu.location.f.k.nh().g() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.f.c.mY().e()));
        if (this.e) {
            this.e = false;
            com.baidu.location.c.f.mD().mE().a(true);
            String l = com.baidu.location.f.k.nh().l();
            if (!TextUtils.isEmpty(l)) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, l.replace(":", ""));
            }
            if (Build.VERSION.SDK_INT > 17) {
            }
        } else if (!this.f) {
            String f = j.f();
            if (f != null) {
                format = format + f;
            }
            this.f = true;
        }
        String str2 = format + c2;
        if (str != null) {
            str2 = str + str2;
        }
        return com.baidu.location.h.i.a(this.Ma, this.LZ, na, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);
}
